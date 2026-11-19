package com.glean.api_client.glean_api_client.hooks;

import com.glean.api_client.glean_api_client.SDKConfiguration;
import com.glean.api_client.glean_api_client.utils.AsyncHook;
import com.glean.api_client.glean_api_client.utils.Helpers;
import com.glean.api_client.glean_api_client.utils.Hook;

import java.lang.reflect.Method;
import java.net.http.HttpRequest;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * Hook that adds X-Glean headers for beta features and deprecation testing.
 *
 * <p>This hook sets the following headers based on SDK options or environment variables:
 * <ul>
 *   <li>{@code X-Glean-Exclude-Deprecated-After} - Exclude API endpoints deprecated after this date</li>
 *   <li>{@code X-Glean-Include-Experimental} - Enable beta API features. Set by either
 *       {@code includeBeta} or its {@code includeExperimental} alias.</li>
 * </ul>
 *
 * <p>Environment variables take precedence over SDK constructor options:
 * <ul>
 *   <li>{@code X_GLEAN_EXCLUDE_DEPRECATED_AFTER} - Date in YYYY-MM-DD format</li>
 *   <li>{@code X_GLEAN_INCLUDE_BETA} - "true" to enable beta features; any other non-empty
 *       value overrides {@code includeBeta(true)}</li>
 *   <li>{@code X_GLEAN_INCLUDE_EXPERIMENTAL} - "true" to enable beta features</li>
 * </ul>
 */
public final class XGleanHeadersHook {

    static final String ENV_EXCLUDE_DEPRECATED_AFTER = "X_GLEAN_EXCLUDE_DEPRECATED_AFTER";
    static final String ENV_INCLUDE_EXPERIMENTAL = "X_GLEAN_INCLUDE_EXPERIMENTAL";
    static final String ENV_INCLUDE_BETA = "X_GLEAN_INCLUDE_BETA";

    static final String HEADER_EXCLUDE_DEPRECATED_AFTER = "X-Glean-Exclude-Deprecated-After";
    static final String HEADER_EXPERIMENTAL = "X-Glean-Include-Experimental";

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

    private static void addHeaders(HttpRequest.Builder builder,
                                   SDKConfiguration sdkConfiguration,
                                   Function<String, String> envProvider) {
        Optional<GleanCustomConfig> customConfig = GleanCustomConfigRegistry.get(sdkConfiguration);

        // Get deprecated after value - environment variable takes precedence
        Optional<String> deprecatedAfterValue = getFirstNonEmpty(
                getEnv(ENV_EXCLUDE_DEPRECATED_AFTER, envProvider),
                customConfig.flatMap(GleanCustomConfig::excludeDeprecatedAfter),
                getSdkConfigurationExcludeDeprecatedAfter(sdkConfiguration)
        );

        deprecatedAfterValue.ifPresent(value ->
                builder.header(HEADER_EXCLUDE_DEPRECATED_AFTER, value)
        );

        // Get experimental value - environment variable takes precedence
        Optional<String> experimentalValue = getFirstNonEmpty(
                getEnvAsBoolean(ENV_INCLUDE_EXPERIMENTAL, envProvider),
                customConfig.flatMap(GleanCustomConfig::includeExperimental).filter(b -> b).map(b -> "true"),
                getSdkConfigurationBoolean(sdkConfiguration, "includeExperimental").filter(b -> b).map(b -> "true")
        );

        // includeExperimental is an alias of includeBeta. Each one resolves on its own, and
        // either one enables the header. Disabling one never disables the other. Keep sending
        // X-Glean-Include-Experimental for both: older deployments do not allow X-Glean-Beta
        // in their CORS preflight.
        boolean includeBeta = resolveBooleanOption(
                envProvider.apply(ENV_INCLUDE_BETA),
                customConfig.flatMap(GleanCustomConfig::includeBeta)
                        .or(() -> getSdkConfigurationBoolean(sdkConfiguration, "includeBeta"))
        );
        if (includeBeta) {
            experimentalValue = Optional.of("true");
        }

        experimentalValue.ifPresent(value ->
                builder.header(HEADER_EXPERIMENTAL, value)
        );
    }

    /**
     * Resolves a boolean opt-in from its environment variable and SDK option. The environment
     * variable takes precedence: "true" (case-insensitive) enables it, any other non-empty value
     * disables it, and an unset or blank value falls back to the SDK option.
     */
    private static boolean resolveBooleanOption(String envValue, Optional<Boolean> optionValue) {
        if (envValue != null && !envValue.trim().isEmpty()) {
            return "true".equalsIgnoreCase(envValue.trim());
        }
        return optionValue.orElse(false);
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
        if (value != null) {
            value = value.trim();
            if (!value.isEmpty()) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }

    private static Optional<String> getEnvAsBoolean(String name, Function<String, String> envProvider) {
        String value = envProvider.apply(name);
        if (value != null && "true".equalsIgnoreCase(value.trim())) {
            return Optional.of("true");
        }
        return Optional.empty();
    }

    private static Optional<String> getSdkConfigurationExcludeDeprecatedAfter(SDKConfiguration sdkConfiguration) {
        if (sdkConfiguration == null) {
            return Optional.empty();
        }

        // Use reflection to avoid a compile-time dependency on generated methods.
        try {
            Method m = sdkConfiguration.getClass().getMethod("excludeDeprecatedAfter");
            Object result = m.invoke(sdkConfiguration);
            if (result instanceof Optional) {
                Optional<?> opt = (Optional<?>) result;
                Object v = opt.orElse(null);
                if (v instanceof String) {
                    String s = ((String) v).trim();
                    return s.isEmpty() ? Optional.empty() : Optional.of(s);
                }
            }
        } catch (NoSuchMethodException e) {
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }

        return Optional.empty();
    }

    private static Optional<Boolean> getSdkConfigurationBoolean(SDKConfiguration sdkConfiguration, String methodName) {
        if (sdkConfiguration == null) {
            return Optional.empty();
        }

        // Use reflection to avoid a compile-time dependency on generated methods.
        try {
            Method m = sdkConfiguration.getClass().getMethod(methodName);
            Object result = m.invoke(sdkConfiguration);
            if (result instanceof Optional) {
                Optional<?> opt = (Optional<?>) result;
                Object v = opt.orElse(null);
                if (v instanceof Boolean) {
                    return Optional.of((Boolean) v);
                }
            }
        } catch (NoSuchMethodException e) {
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }

        return Optional.empty();
    }
}
