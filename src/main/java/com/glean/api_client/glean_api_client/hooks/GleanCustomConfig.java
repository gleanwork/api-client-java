package com.glean.api_client.glean_api_client.hooks;

import java.util.Optional;

/**
 * Immutable custom Glean configuration values.
 *
 * <p>This class holds configuration that is not part of the auto-generated SDK,
 * providing a way to configure custom headers and features without modifying
 * generated code.
 *
 * <p>Values are associated with a specific SDK instance via {@link GleanCustomConfigRegistry}.
 */
public final class GleanCustomConfig {

    private final Optional<String> excludeDeprecatedAfter;
    private final Optional<Boolean> includeExperimental;

    public GleanCustomConfig(Optional<String> excludeDeprecatedAfter, Optional<Boolean> includeExperimental) {
        this.excludeDeprecatedAfter = excludeDeprecatedAfter != null ? excludeDeprecatedAfter : Optional.empty();
        this.includeExperimental = includeExperimental != null ? includeExperimental : Optional.empty();
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
     * Gets whether experimental API features should be enabled.
     *
     * @return Optional containing the boolean value if set
     */
    public Optional<Boolean> includeExperimental() {
        return includeExperimental;
    }
}
