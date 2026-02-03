package com.glean.api_client.glean_api_client.hooks;

import com.glean.api_client.glean_api_client.SDKConfiguration;
import com.glean.api_client.glean_api_client.SecuritySource;
import com.glean.api_client.glean_api_client.utils.Hook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class XGleanHeadersHookTest {

    private static final String HEADER_EXCLUDE_DEPRECATED_AFTER = XGleanHeadersHook.HEADER_EXCLUDE_DEPRECATED_AFTER;
    private static final String HEADER_EXPERIMENTAL = XGleanHeadersHook.HEADER_EXPERIMENTAL;

    @BeforeEach
    void setUp() {
        // Reset the singleton config before each test
        GleanCustomConfig.getInstance().reset();
    }

    private HttpRequest createMockRequest() {
        return HttpRequest.newBuilder()
                .uri(URI.create("https://example.com/api/test"))
                .GET()
                .build();
    }

    private Hook.BeforeRequestContext createMockContext(SDKConfiguration config) {
        return new Hook.BeforeRequestContextImpl(
                config,
                "https://example.com",
                "test-operation",
                Optional.empty(),
                Optional.of(SecuritySource.of(null))
        );
    }

    private SDKConfiguration createConfig(String excludeDeprecatedAfter, Boolean includeExperimental) {
        // Configure the GleanCustomConfig singleton (used by the hook)
        GleanCustomConfig customConfig = GleanCustomConfig.getInstance();
        if (excludeDeprecatedAfter != null) {
            customConfig.setExcludeDeprecatedAfter(Optional.of(excludeDeprecatedAfter));
        }
        if (includeExperimental != null) {
            customConfig.setIncludeExperimental(Optional.of(includeExperimental));
        }
        // Return a plain SDKConfiguration (not used for the custom fields anymore)
        return new SDKConfiguration();
    }

    /**
     * Creates a mock environment provider with the given key-value pairs.
     */
    private Function<String, String> createEnvProvider(Map<String, String> env) {
        return env::get;
    }

    /**
     * Creates an empty environment provider (no environment variables set).
     */
    private Function<String, String> emptyEnvProvider() {
        return name -> null;
    }

    @Nested
    class WhenNeitherOptionsNorEnvironmentVariablesAreSet {

        @Test
        void shouldNotSetAnyXGleanHeaders() throws Exception {
            Hook.BeforeRequest hook = XGleanHeadersHook.createSyncHook(emptyEnvProvider());
            HttpRequest request = createMockRequest();
            SDKConfiguration config = createConfig(null, null);
            Hook.BeforeRequestContext context = createMockContext(config);

            HttpRequest result = hook.beforeRequest(context, request);

            assertFalse(result.headers().firstValue(HEADER_EXCLUDE_DEPRECATED_AFTER).isPresent());
            assertFalse(result.headers().firstValue(HEADER_EXPERIMENTAL).isPresent());
        }
    }

    @Nested
    class WhenUsingSDKConstructorOptions {

        @Test
        void shouldSetExcludeDeprecatedAfterHeaderFromOption() throws Exception {
            Hook.BeforeRequest hook = XGleanHeadersHook.createSyncHook(emptyEnvProvider());
            HttpRequest request = createMockRequest();
            SDKConfiguration config = createConfig("2026-10-15", null);
            Hook.BeforeRequestContext context = createMockContext(config);

            HttpRequest result = hook.beforeRequest(context, request);

            assertEquals("2026-10-15", result.headers().firstValue(HEADER_EXCLUDE_DEPRECATED_AFTER).orElse(null));
        }

        @Test
        void shouldSetExperimentalHeaderWhenIncludeExperimentalIsTrue() throws Exception {
            Hook.BeforeRequest hook = XGleanHeadersHook.createSyncHook(emptyEnvProvider());
            HttpRequest request = createMockRequest();
            SDKConfiguration config = createConfig(null, true);
            Hook.BeforeRequestContext context = createMockContext(config);

            HttpRequest result = hook.beforeRequest(context, request);

            assertEquals("true", result.headers().firstValue(HEADER_EXPERIMENTAL).orElse(null));
        }

        @Test
        void shouldNotSetExperimentalHeaderWhenIncludeExperimentalIsFalse() throws Exception {
            Hook.BeforeRequest hook = XGleanHeadersHook.createSyncHook(emptyEnvProvider());
            HttpRequest request = createMockRequest();
            SDKConfiguration config = createConfig(null, false);
            Hook.BeforeRequestContext context = createMockContext(config);

            HttpRequest result = hook.beforeRequest(context, request);

            assertFalse(result.headers().firstValue(HEADER_EXPERIMENTAL).isPresent());
        }

        @Test
        void shouldSetBothHeadersWhenBothOptionsAreProvided() throws Exception {
            Hook.BeforeRequest hook = XGleanHeadersHook.createSyncHook(emptyEnvProvider());
            HttpRequest request = createMockRequest();
            SDKConfiguration config = createConfig("2026-10-15", true);
            Hook.BeforeRequestContext context = createMockContext(config);

            HttpRequest result = hook.beforeRequest(context, request);

            assertEquals("2026-10-15", result.headers().firstValue(HEADER_EXCLUDE_DEPRECATED_AFTER).orElse(null));
            assertEquals("true", result.headers().firstValue(HEADER_EXPERIMENTAL).orElse(null));
        }
    }

    @Nested
    class WhenUsingEnvironmentVariables {

        @Test
        void shouldSetExcludeDeprecatedAfterHeaderFromEnvironmentVariable() throws Exception {
            Map<String, String> env = new HashMap<>();
            env.put(XGleanHeadersHook.ENV_EXCLUDE_DEPRECATED_AFTER, "2027-01-01");

            Hook.BeforeRequest hook = XGleanHeadersHook.createSyncHook(createEnvProvider(env));
            HttpRequest request = createMockRequest();
            SDKConfiguration config = createConfig(null, null);
            Hook.BeforeRequestContext context = createMockContext(config);

            HttpRequest result = hook.beforeRequest(context, request);

            assertEquals("2027-01-01", result.headers().firstValue(HEADER_EXCLUDE_DEPRECATED_AFTER).orElse(null));
        }

        @Test
        void shouldSetExperimentalHeaderFromEnvironmentVariable() throws Exception {
            Map<String, String> env = new HashMap<>();
            env.put(XGleanHeadersHook.ENV_INCLUDE_EXPERIMENTAL, "true");

            Hook.BeforeRequest hook = XGleanHeadersHook.createSyncHook(createEnvProvider(env));
            HttpRequest request = createMockRequest();
            SDKConfiguration config = createConfig(null, null);
            Hook.BeforeRequestContext context = createMockContext(config);

            HttpRequest result = hook.beforeRequest(context, request);

            assertEquals("true", result.headers().firstValue(HEADER_EXPERIMENTAL).orElse(null));
        }

        @Test
        void shouldSetBothHeadersFromEnvironmentVariables() throws Exception {
            Map<String, String> env = new HashMap<>();
            env.put(XGleanHeadersHook.ENV_EXCLUDE_DEPRECATED_AFTER, "2027-06-15");
            env.put(XGleanHeadersHook.ENV_INCLUDE_EXPERIMENTAL, "true");

            Hook.BeforeRequest hook = XGleanHeadersHook.createSyncHook(createEnvProvider(env));
            HttpRequest request = createMockRequest();
            SDKConfiguration config = createConfig(null, null);
            Hook.BeforeRequestContext context = createMockContext(config);

            HttpRequest result = hook.beforeRequest(context, request);

            assertEquals("2027-06-15", result.headers().firstValue(HEADER_EXCLUDE_DEPRECATED_AFTER).orElse(null));
            assertEquals("true", result.headers().firstValue(HEADER_EXPERIMENTAL).orElse(null));
        }

        @Test
        void shouldIgnoreNonTrueValuesForExperimentalEnvironmentVariable() throws Exception {
            Map<String, String> env = new HashMap<>();
            env.put(XGleanHeadersHook.ENV_INCLUDE_EXPERIMENTAL, "false");

            Hook.BeforeRequest hook = XGleanHeadersHook.createSyncHook(createEnvProvider(env));
            HttpRequest request = createMockRequest();
            SDKConfiguration config = createConfig(null, null);
            Hook.BeforeRequestContext context = createMockContext(config);

            HttpRequest result = hook.beforeRequest(context, request);

            assertFalse(result.headers().firstValue(HEADER_EXPERIMENTAL).isPresent());
        }
    }

    @Nested
    class EnvironmentVariablesTakePrecedenceOverSDKOptions {

        @Test
        void shouldUseEnvironmentVariableForExcludeDeprecatedAfterWhenBothAreSet() throws Exception {
            Map<String, String> env = new HashMap<>();
            env.put(XGleanHeadersHook.ENV_EXCLUDE_DEPRECATED_AFTER, "2027-12-31");

            Hook.BeforeRequest hook = XGleanHeadersHook.createSyncHook(createEnvProvider(env));
            HttpRequest request = createMockRequest();
            SDKConfiguration config = createConfig("2026-01-01", null);
            Hook.BeforeRequestContext context = createMockContext(config);

            HttpRequest result = hook.beforeRequest(context, request);

            assertEquals("2027-12-31", result.headers().firstValue(HEADER_EXCLUDE_DEPRECATED_AFTER).orElse(null));
        }

        @Test
        void shouldUseEnvironmentVariableForIncludeExperimentalWhenBothAreSet() throws Exception {
            Map<String, String> env = new HashMap<>();
            env.put(XGleanHeadersHook.ENV_INCLUDE_EXPERIMENTAL, "true");

            Hook.BeforeRequest hook = XGleanHeadersHook.createSyncHook(createEnvProvider(env));
            HttpRequest request = createMockRequest();
            SDKConfiguration config = createConfig(null, false);
            Hook.BeforeRequestContext context = createMockContext(config);

            HttpRequest result = hook.beforeRequest(context, request);

            assertEquals("true", result.headers().firstValue(HEADER_EXPERIMENTAL).orElse(null));
        }

        @Test
        void shouldUseEnvironmentVariablesForBothHeadersWhenAllAreSet() throws Exception {
            Map<String, String> env = new HashMap<>();
            env.put(XGleanHeadersHook.ENV_EXCLUDE_DEPRECATED_AFTER, "2028-01-01");
            env.put(XGleanHeadersHook.ENV_INCLUDE_EXPERIMENTAL, "true");

            Hook.BeforeRequest hook = XGleanHeadersHook.createSyncHook(createEnvProvider(env));
            HttpRequest request = createMockRequest();
            SDKConfiguration config = createConfig("2026-06-01", false);
            Hook.BeforeRequestContext context = createMockContext(config);

            HttpRequest result = hook.beforeRequest(context, request);

            assertEquals("2028-01-01", result.headers().firstValue(HEADER_EXCLUDE_DEPRECATED_AFTER).orElse(null));
            assertEquals("true", result.headers().firstValue(HEADER_EXPERIMENTAL).orElse(null));
        }
    }
}
