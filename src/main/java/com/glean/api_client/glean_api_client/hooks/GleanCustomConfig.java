package com.glean.api_client.glean_api_client.hooks;

import java.util.Optional;

/**
 * Thread-safe singleton storing custom Glean configuration values.
 *
 * <p>This class holds configuration that is not part of the auto-generated SDK,
 * providing a way to configure custom headers and features without modifying
 * generated code.
 *
 * <p>Values can be set via {@link GleanBuilder} when constructing the SDK instance.
 */
public final class GleanCustomConfig {

    private static final GleanCustomConfig INSTANCE = new GleanCustomConfig();

    private volatile Optional<String> excludeDeprecatedAfter = Optional.empty();
    private volatile Optional<Boolean> includeExperimental = Optional.empty();

    private GleanCustomConfig() {
        // private constructor for singleton
    }

    /**
     * Gets the singleton instance.
     *
     * @return the singleton instance
     */
    public static GleanCustomConfig getInstance() {
        return INSTANCE;
    }

    /**
     * Gets the date after which deprecated API endpoints should be excluded.
     *
     * @return Optional containing the date string (YYYY-MM-DD format) if set
     */
    public Optional<String> excludeDeprecatedAfter() {
        return excludeDeprecatedAfter;
    }

    /**
     * Sets the date after which deprecated API endpoints should be excluded.
     * Use this to test your integration against upcoming deprecations.
     *
     * @param excludeDeprecatedAfter date string in YYYY-MM-DD format, or empty to clear
     */
    public void setExcludeDeprecatedAfter(Optional<String> excludeDeprecatedAfter) {
        this.excludeDeprecatedAfter = excludeDeprecatedAfter != null ? excludeDeprecatedAfter : Optional.empty();
    }

    /**
     * Gets whether experimental API features should be enabled.
     *
     * @return Optional containing the boolean value if set
     */
    public Optional<Boolean> includeExperimental() {
        return includeExperimental;
    }

    /**
     * Sets whether experimental API features should be enabled.
     * When true, enables experimental API features that are not yet generally available.
     *
     * @param includeExperimental whether to include experimental features, or empty to clear
     */
    public void setIncludeExperimental(Optional<Boolean> includeExperimental) {
        this.includeExperimental = includeExperimental != null ? includeExperimental : Optional.empty();
    }

    /**
     * Resets all configuration values to their defaults (empty).
     * Primarily intended for testing.
     */
    public void reset() {
        this.excludeDeprecatedAfter = Optional.empty();
        this.includeExperimental = Optional.empty();
    }
}
