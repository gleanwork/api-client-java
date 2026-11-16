package com.glean.api_client.glean_api_client.hooks;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.SDKConfiguration;
import com.glean.api_client.glean_api_client.SecuritySource;
import com.glean.api_client.glean_api_client.models.components.PlatformSearchRequest;
import com.glean.api_client.glean_api_client.utils.HTTPClient;
import com.glean.api_client.glean_api_client.utils.Hook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class XGleanHeadersHookTest {

    private static final String HEADER_EXCLUDE_DEPRECATED_AFTER = XGleanHeadersHook.HEADER_EXCLUDE_DEPRECATED_AFTER;
    private static final String HEADER_EXPERIMENTAL = XGleanHeadersHook.HEADER_EXPERIMENTAL;

    @BeforeEach
    void setUp() {
        GleanCustomConfigRegistry.clearForTests();
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
        SDKConfiguration config = new SDKConfiguration();
        if (excludeDeprecatedAfter != null || includeExperimental != null) {
            GleanCustomConfigRegistry.put(
                    config,
                    new GleanCustomConfig(Optional.ofNullable(excludeDeprecatedAfter), Optional.ofNullable(includeExperimental))
            );
        }
        return config;
    }

    private SDKConfiguration createBetaConfig(Boolean includeBeta, Boolean includeExperimental) {
        SDKConfiguration config = new SDKConfiguration();
        GleanCustomConfigRegistry.put(
                config,
                new GleanCustomConfig(
                        Optional.empty(),
                        Optional.ofNullable(includeExperimental),
                        Optional.ofNullable(includeBeta))
        );
        return config;
    }

    static Stream<Arguments> includeBetaCases() {
        // betaEnv, experimentalEnv, includeBeta option, includeExperimental option, expected header
        return Stream.of(
                Arguments.of("neither option set", null, null, null, null, null),
                Arguments.of("includeBeta alone", null, null, true, null, "true"),
                Arguments.of("includeBeta false", null, null, false, null, null),
                Arguments.of("includeExperimental alone", null, null, null, true, "true"),
                Arguments.of("both options true", null, null, true, true, "true"),
                Arguments.of("includeBeta true, includeExperimental false", null, null, true, false, "true"),
                Arguments.of("X_GLEAN_INCLUDE_BETA alone", "true", null, null, null, "true"),
                Arguments.of("X_GLEAN_INCLUDE_BETA is case-insensitive", " TRUE ", null, null, null, "true"),
                Arguments.of("both env vars true", "true", "true", null, null, "true"),
                Arguments.of("X_GLEAN_INCLUDE_BETA=false overrides includeBeta", "false", null, true, null, null),
                Arguments.of("X_GLEAN_INCLUDE_BETA=true overrides includeBeta=false", "true", null, false, null, "true"),
                Arguments.of("empty X_GLEAN_INCLUDE_BETA falls back to includeBeta", " ", null, true, null, "true"),
                Arguments.of("X_GLEAN_INCLUDE_BETA=false does not turn off includeExperimental", "false", null, null, true, "true"),
                Arguments.of("X_GLEAN_INCLUDE_BETA=false does not turn off X_GLEAN_INCLUDE_EXPERIMENTAL", "false", "true", null, null, "true"),
                Arguments.of("X_GLEAN_INCLUDE_EXPERIMENTAL=false does not turn off includeBeta", null, "false", true, null, "true")
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("includeBetaCases")
    void includeBetaAndItsIncludeExperimentalAliasSetTheSameHeader(
            String name,
            String betaEnv,
            String experimentalEnv,
            Boolean includeBeta,
            Boolean includeExperimental,
            String expected) throws Exception {
        Map<String, String> env = new HashMap<>();
        if (betaEnv != null) {
            env.put(XGleanHeadersHook.ENV_INCLUDE_BETA, betaEnv);
        }
        if (experimentalEnv != null) {
            env.put(XGleanHeadersHook.ENV_INCLUDE_EXPERIMENTAL, experimentalEnv);
        }
        SDKConfiguration config = createBetaConfig(includeBeta, includeExperimental);

        HttpRequest syncResult = XGleanHeadersHook.createSyncHook(createEnvProvider(env))
                .beforeRequest(createMockContext(config), createMockRequest());
        HttpRequest asyncResult = XGleanHeadersHook.createAsyncHook(createEnvProvider(env))
                .beforeRequest(createMockContext(config), createMockRequest())
                .join();

        for (HttpRequest result : List.of(syncResult, asyncResult)) {
            assertEquals(expected, result.headers().firstValue(HEADER_EXPERIMENTAL).orElse(null));
            assertFalse(result.headers().firstValue("X-Glean-Beta").isPresent());
        }
    }

    @Test
    void keepsTwoArgumentGleanCustomConfigConstructor() {
        GleanCustomConfig config = new GleanCustomConfig(Optional.of("2026-10-15"), Optional.of(true));

        assertEquals(Optional.of("2026-10-15"), config.excludeDeprecatedAfter());
        assertEquals(Optional.of(true), config.includeExperimental());
        assertEquals(Optional.empty(), config.includeBeta());
    }

    /**
     * HTTP client that records requests and fails them, so no network call is made.
     */
    private static final class CapturingHttpClient implements HTTPClient {
        final List<HttpRequest> requests = new ArrayList<>();

        @Override
        public HttpResponse<InputStream> send(HttpRequest request) throws IOException {
            requests.add(request);
            throw new IOException("request captured by test");
        }
    }

    private HttpRequest sendSearch(GleanBuilder builder) {
        CapturingHttpClient client = new CapturingHttpClient();
        Glean glean = builder
                .apiToken("test-token")
                .serverURL("https://example.com")
                .client(client)
                .build();
        try {
            glean.search().query(PlatformSearchRequest.builder().query("test").build());
        } catch (Exception e) {
            // Expected: the capturing client fails every request.
        }
        assertFalse(client.requests.isEmpty(), "expected a request to be sent");
        return client.requests.get(0);
    }

    @Nested
    class WhenUsingGleanBuilder {

        @BeforeEach
        void requireCleanEnvironment() {
            org.junit.jupiter.api.Assumptions.assumeTrue(
                    System.getenv(XGleanHeadersHook.ENV_INCLUDE_BETA) == null
                            && System.getenv(XGleanHeadersHook.ENV_INCLUDE_EXPERIMENTAL) == null,
                    "X-Glean environment variables must be unset");
        }

        @Test
        void includeBetaSendsIncludeExperimentalHeader() {
            HttpRequest request = sendSearch(GleanBuilder.create().includeBeta(true));

            assertEquals("true", request.headers().firstValue(HEADER_EXPERIMENTAL).orElse(null));
            assertFalse(request.headers().firstValue("X-Glean-Beta").isPresent());
        }

        @Test
        void includeExperimentalSendsIncludeExperimentalHeader() {
            HttpRequest request = sendSearch(GleanBuilder.create().includeExperimental(true));

            assertEquals("true", request.headers().firstValue(HEADER_EXPERIMENTAL).orElse(null));
        }

        @Test
        void bothOptionsSendOneIncludeExperimentalHeader() {
            HttpRequest request = sendSearch(GleanBuilder.create().includeBeta(true).includeExperimental(true));

            assertEquals(List.of("true"), request.headers().allValues(HEADER_EXPERIMENTAL));
        }

        @Test
        void neitherOptionSendsNoHeader() {
            HttpRequest request = sendSearch(GleanBuilder.create());

            assertFalse(request.headers().firstValue(HEADER_EXPERIMENTAL).isPresent());
        }
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

    @Nested
    class WhenMultipleSDKInstancesExist {

        @Test
        void shouldNotLeakConfigBetweenSDKConfigurations() throws Exception {
            Hook.BeforeRequest hook = XGleanHeadersHook.createSyncHook(emptyEnvProvider());
            HttpRequest request = createMockRequest();

            SDKConfiguration configA = createConfig("2026-10-15", true);
            SDKConfiguration configB = createConfig("2027-01-01", false);

            HttpRequest resA = hook.beforeRequest(createMockContext(configA), request);
            HttpRequest resB = hook.beforeRequest(createMockContext(configB), request);

            assertEquals("2026-10-15", resA.headers().firstValue(HEADER_EXCLUDE_DEPRECATED_AFTER).orElse(null));
            assertEquals("true", resA.headers().firstValue(HEADER_EXPERIMENTAL).orElse(null));

            assertEquals("2027-01-01", resB.headers().firstValue(HEADER_EXCLUDE_DEPRECATED_AFTER).orElse(null));
            assertFalse(resB.headers().firstValue(HEADER_EXPERIMENTAL).isPresent());
        }
    }

    @Nested
    class AsyncHookParity {

        @Test
        void shouldApplySameHeadersInAsyncHook() {
            var hook = XGleanHeadersHook.createAsyncHook(emptyEnvProvider());
            HttpRequest request = createMockRequest();
            SDKConfiguration config = createConfig("2026-10-15", true);

            CompletableFuture<HttpRequest> fut = hook.beforeRequest(createMockContext(config), request);
            HttpRequest result = fut.join();

            assertEquals("2026-10-15", result.headers().firstValue(HEADER_EXCLUDE_DEPRECATED_AFTER).orElse(null));
            assertEquals("true", result.headers().firstValue(HEADER_EXPERIMENTAL).orElse(null));
        }
    }

    @Nested
    class BackwardCompatibilityWithGeneratedSDKConfiguration {

        @Test
        void shouldFallBackToSDKConfigurationWhenRegistryIsEmpty() throws Exception {
            Hook.BeforeRequest hook = XGleanHeadersHook.createSyncHook(emptyEnvProvider());
            HttpRequest request = createMockRequest();
            SDKConfiguration config = new SDKConfiguration();

            boolean setDeprecatedAfter = tryInvokeOptionalSetter(config, "setExcludeDeprecatedAfter", Optional.of("2029-12-31"));
            boolean setExperimental = tryInvokeOptionalSetter(config, "setIncludeExperimental", Optional.of(true));

            HttpRequest result = hook.beforeRequest(createMockContext(config), request);

            if (setDeprecatedAfter) {
                assertEquals("2029-12-31", result.headers().firstValue(HEADER_EXCLUDE_DEPRECATED_AFTER).orElse(null));
            } else {
                assertFalse(result.headers().firstValue(HEADER_EXCLUDE_DEPRECATED_AFTER).isPresent());
            }

            if (setExperimental) {
                assertEquals("true", result.headers().firstValue(HEADER_EXPERIMENTAL).orElse(null));
            } else {
                assertFalse(result.headers().firstValue(HEADER_EXPERIMENTAL).isPresent());
            }
        }
    }

    private static boolean tryInvokeOptionalSetter(Object target, String methodName, Optional<?> value) {
        try {
            Method m = target.getClass().getMethod(methodName, Optional.class);
            m.invoke(target, value);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
