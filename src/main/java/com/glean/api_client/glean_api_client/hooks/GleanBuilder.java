package com.glean.api_client.glean_api_client.hooks;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.SDKConfiguration;
import com.glean.api_client.glean_api_client.SecuritySource;
import com.glean.api_client.glean_api_client.utils.HTTPClient;
import com.glean.api_client.glean_api_client.utils.RetryConfig;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

/**
 * Builder wrapper for creating {@link Glean} instances with custom configuration options.
 *
 * <p>This builder extends the standard SDK builder with additional configuration options
 * for experimental features and deprecation testing that are preserved across SDK regenerations.
 *
 * <p>Example usage:
 * <pre>{@code
 * Glean glean = GleanBuilder.create()
 *         .apiToken("your-api-token")
 *         .serverURL("https://mycompany-be.glean.com")
 *         .excludeDeprecatedAfter("2026-10-15")
 *         .includeExperimental(true)
 *         .build();
 * }</pre>
 */
public final class GleanBuilder {

    private final Glean.Builder delegate;

    private Optional<String> excludeDeprecatedAfter = Optional.empty();
    private Optional<Boolean> includeExperimental = Optional.empty();

    private GleanBuilder() {
        this.delegate = Glean.builder();
    }

    /**
     * Creates a new builder instance.
     *
     * @return a new GleanBuilder
     */
    public static GleanBuilder create() {
        return new GleanBuilder();
    }

    /**
     * Configures the SDK security to use the provided API token.
     *
     * @param apiToken The API token to use for all requests.
     * @return This builder instance.
     */
    public GleanBuilder apiToken(String apiToken) {
        delegate.apiToken(apiToken);
        return this;
    }

    /**
     * Configures the SDK to use a custom security source.
     *
     * @param securitySource The security source to use for all requests.
     * @return This builder instance.
     */
    public GleanBuilder securitySource(SecuritySource securitySource) {
        delegate.securitySource(securitySource);
        return this;
    }

    /**
     * Allows the default HTTP client to be overridden with a custom implementation.
     *
     * @param client The HTTP client to use for all requests.
     * @return This builder instance.
     */
    public GleanBuilder client(HTTPClient client) {
        delegate.client(client);
        return this;
    }

    /**
     * Overrides the default server URL.
     *
     * @param serverUrl The server URL to use for all requests.
     * @return This builder instance.
     */
    public GleanBuilder serverURL(String serverUrl) {
        delegate.serverURL(serverUrl);
        return this;
    }

    /**
     * Overrides the default server URL with a templated URL populated with the provided parameters.
     *
     * @param serverUrl The server URL to use for all requests.
     * @param params The parameters to use when templating the URL.
     * @return This builder instance.
     */
    public GleanBuilder serverURL(String serverUrl, Map<String, String> params) {
        delegate.serverURL(serverUrl, params);
        return this;
    }

    /**
     * Overrides the default server by index.
     *
     * @param serverIdx The server to use for all requests.
     * @return This builder instance.
     */
    public GleanBuilder serverIndex(int serverIdx) {
        delegate.serverIndex(serverIdx);
        return this;
    }

    /**
     * Sets the instance variable for URL substitution.
     *
     * @param instance The instance name to set.
     * @return This builder instance.
     */
    public GleanBuilder instance(String instance) {
        delegate.instance(instance);
        return this;
    }

    /**
     * Overrides the default configuration for retries.
     *
     * @param retryConfig The retry configuration to use for all requests.
     * @return This builder instance.
     */
    public GleanBuilder retryConfig(RetryConfig retryConfig) {
        delegate.retryConfig(retryConfig);
        return this;
    }

    /**
     * Enables debug logging for HTTP requests and responses, including JSON body content.
     *
     * @param enabled Whether to enable debug logging.
     * @return This builder instance.
     */
    public GleanBuilder enableHTTPDebugLogging(boolean enabled) {
        delegate.enableHTTPDebugLogging(enabled);
        return this;
    }

    /**
     * Exclude API endpoints that will be deprecated after this date.
     * Use this to test your integration against upcoming deprecations.
     *
     * <p>More information: <a href="https://developers.glean.com/deprecations/overview">Deprecations Overview</a>
     *
     * @param excludeDeprecatedAfter date string in YYYY-MM-DD format (e.g., '2026-10-15')
     * @return This builder instance.
     */
    public GleanBuilder excludeDeprecatedAfter(String excludeDeprecatedAfter) {
        this.excludeDeprecatedAfter = Optional.ofNullable(excludeDeprecatedAfter);
        return this;
    }

    /**
     * Enable experimental API features that are not yet generally available.
     * Use this to preview and test new functionality.
     *
     * <p><strong>Warning:</strong> Experimental features may change or be removed without notice.
     * Do not rely on experimental features in production environments.
     *
     * @param includeExperimental whether to include experimental features
     * @return This builder instance.
     */
    public GleanBuilder includeExperimental(boolean includeExperimental) {
        this.includeExperimental = Optional.of(includeExperimental);
        return this;
    }

    /**
     * Builds a new instance of the Glean SDK.
     *
     * @return The configured Glean instance.
     */
    public Glean build() {
        Glean sdk = delegate.build();
        SDKConfiguration sdkConfiguration = extractSdkConfiguration(sdk);
        if (sdkConfiguration != null) {
            GleanCustomConfigRegistry.put(
                    sdkConfiguration,
                    new GleanCustomConfig(excludeDeprecatedAfter, includeExperimental)
            );
        }
        return sdk;
    }

    private static SDKConfiguration extractSdkConfiguration(Glean sdk) {
        if (sdk == null) {
            return null;
        }

        try {
            // Preferred: reflectively access Glean.client -> Client.sdkConfiguration
            Object client = readFieldValue(sdk, "client");
            if (client != null) {
                Object cfg = readFieldValue(client, "sdkConfiguration");
                if (cfg instanceof SDKConfiguration) {
                    return (SDKConfiguration) cfg;
                }
            }
        } catch (RuntimeException e) {
            // Best-effort: fall through to generic field scan
        }

        // Fallback: scan first-level fields for an SDKConfiguration
        for (Field f : sdk.getClass().getDeclaredFields()) {
            if (!SDKConfiguration.class.isAssignableFrom(f.getType())) {
                continue;
            }
            try {
                f.setAccessible(true);
                Object cfg = f.get(sdk);
                if (cfg instanceof SDKConfiguration) {
                    return (SDKConfiguration) cfg;
                }
            } catch (IllegalAccessException e) {
                // ignore
            }
        }

        return null;
    }

    private static Object readFieldValue(Object target, String fieldName) {
        Class<?> c = target.getClass();
        while (c != null) {
            try {
                Field f = c.getDeclaredField(fieldName);
                f.setAccessible(true);
                return f.get(target);
            } catch (NoSuchFieldException e) {
                c = c.getSuperclass();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
