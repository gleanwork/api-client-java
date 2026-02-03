package com.glean.api_client.glean_api_client.hooks;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.SecuritySource;
import com.glean.api_client.glean_api_client.utils.HTTPClient;
import com.glean.api_client.glean_api_client.utils.RetryConfig;

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
 *         .instance("instance-name")
 *         .excludeDeprecatedAfter("2026-10-15")
 *         .includeExperimental(true)
 *         .build();
 * }</pre>
 */
public final class GleanBuilder {

    private final Glean.Builder delegate;

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
        GleanCustomConfig.getInstance().setExcludeDeprecatedAfter(Optional.ofNullable(excludeDeprecatedAfter));
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
        GleanCustomConfig.getInstance().setIncludeExperimental(Optional.of(includeExperimental));
        return this;
    }

    /**
     * Builds a new instance of the Glean SDK.
     *
     * @return The configured Glean instance.
     */
    public Glean build() {
        return delegate.build();
    }
}
