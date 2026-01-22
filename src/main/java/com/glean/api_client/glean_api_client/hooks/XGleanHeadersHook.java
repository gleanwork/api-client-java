package com.glean.api_client.glean_api_client.hooks;

import com.glean.api_client.glean_api_client.SDKConfiguration;
import com.glean.api_client.glean_api_client.utils.AsyncHook;
import com.glean.api_client.glean_api_client.utils.Helpers;
import com.glean.api_client.glean_api_client.utils.Hook;

import java.net.http.HttpRequest;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * Hook that adds X-Glean headers for experimental features and deprecation testing.
 *
 * <p>This hook sets the following headers based on SDK options or environment variables:
 * <ul>
 *   <li>{@code X-Glean-Exclude-Deprecated-After} - Exclude API endpoints deprecated after this date</li>
 *   <li>{@code X-Glean-Experimental} - Enable experimental API features</li>
 * </ul>
 *
 * <p>Environment variables take precedence over SDK constructor options:
 * <ul>
 *   <li>{@code X_GLEAN_EXCLUDE_DEPRECATED_AFTER} - Date in YYYY-MM-DD format</li>
 *   <li>{@code X_GLEAN_INCLUDE_EXPERIMENTAL} - "true" to enable experimental features</li>
 * </ul>
 */
public final class XGleanHeadersHook {

    static final String ENV_EXCLUDE_DEPRECATED_AFTER = "X_GLEAN_EXCLUDE_DEPRECATED_AFTER";
    static final String ENV_INCLUDE_EXPERIMENTAL = "X_GLEAN_INCLUDE_EXPERIMENTAL";

    static final String HEADER_EXCLUDE_DEPRECATED_AFTER = "X-Glean-Exclude-Deprecated-After";
    static final String HEADER_EXPERIMENTAL = "X-Glean-Experimental";

    private XGleanHeadersHook() {
        // prevent instantiation
    }

    /**
     * Creates a synchronous BeforeRequest hook for adding X-Glean headers.
     *
     * @return the sync hook
     */
    public static Hook.BeforeRequest createSyncHook() {
        return createSyncHook(System::getenv);
    }

    /**
     * Creates a synchronous BeforeRequest hook for adding X-Glean headers.
     * This variant accepts a custom environment variable provider for testing.
     *
     * @param envProvider function to get environment variables
     * @return the sync hook
     */
    static Hook.BeforeRequest createSyncHook(Function<String, String> envProvider) {
        return (context, request) -> {
            HttpRequest.Builder builder = Helpers.copy(request);
            addHeaders(builder, context.sdkConfiguration(), envProvider);
            return builder.build();
        };
    }

    /**
     * Creates an asynchronous BeforeRequest hook for adding X-Glean headers.
     *
     * @return the async hook
     */
    public static AsyncHook.BeforeRequest createAsyncHook() {
        return createAsyncHook(System::getenv);
    }

    /**
     * Creates an asynchronous BeforeRequest hook for adding X-Glean headers.
     * This variant accepts a custom environment variable provider for testing.
     *
     * @param envProvider function to get environment variables
     * @return the async hook
     */
    static AsyncHook.BeforeRequest createAsyncHook(Function<String, String> envProvider) {
        return (context, request) -> {
            HttpRequest.Builder builder = Helpers.copy(request);
            addHeaders(builder, context.sdkConfiguration(), envProvider);
            return CompletableFuture.completedFuture(builder.build());
        };
    }

    private static void addHeaders(HttpRequest.Builder builder, SDKConfiguration config,
                                   Function<String, String> envProvider) {
        // Get deprecated after value - environment variable takes precedence
        Optional<String> deprecatedAfterValue = getFirstNonEmpty(
                getEnv(ENV_EXCLUDE_DEPRECATED_AFTER, envProvider),
                config.excludeDeprecatedAfter()
        );

        deprecatedAfterValue.ifPresent(value ->
                builder.header(HEADER_EXCLUDE_DEPRECATED_AFTER, value)
        );

        // Get experimental value - environment variable takes precedence
        Optional<String> experimentalValue = getFirstNonEmpty(
                getEnvAsBoolean(ENV_INCLUDE_EXPERIMENTAL, envProvider),
                config.includeExperimental().filter(b -> b).map(b -> "true")
        );

        experimentalValue.ifPresent(value ->
                builder.header(HEADER_EXPERIMENTAL, value)
        );
    }

    /**
     * Returns the first non-empty Optional from the provided arguments.
     */
    @SafeVarargs
    private static Optional<String> getFirstNonEmpty(Optional<String>... optionals) {
        for (Optional<String> opt : optionals) {
            if (opt.isPresent()) {
                return opt;
            }
        }
        return Optional.empty();
    }

    private static Optional<String> getEnv(String name, Function<String, String> envProvider) {
        String value = envProvider.apply(name);
        if (value != null && !value.isEmpty()) {
            return Optional.of(value);
        }
        return Optional.empty();
    }

    private static Optional<String> getEnvAsBoolean(String name, Function<String, String> envProvider) {
        String value = envProvider.apply(name);
        if ("true".equalsIgnoreCase(value)) {
            return Optional.of("true");
        }
        return Optional.empty();
    }
}
