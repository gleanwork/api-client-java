package com.glean.api_client.glean_api_client.hooks;

import com.glean.api_client.glean_api_client.SDKConfiguration;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;

/**
 * Registry mapping a generated {@link SDKConfiguration} instance to preserved custom configuration.
 *
 * <p>Speakeasy regenerations overwrite generated classes, so custom configuration is stored outside
 * generated code and associated to a specific SDK instance at runtime.
 */
final class GleanCustomConfigRegistry {

    private static final Map<SDKConfiguration, GleanCustomConfig> REGISTRY =
            Collections.synchronizedMap(new WeakHashMap<>());

    private GleanCustomConfigRegistry() {
        // prevent instantiation
    }

    static void put(SDKConfiguration sdkConfiguration, GleanCustomConfig customConfig) {
        if (sdkConfiguration == null) {
            return;
        }

        if (customConfig == null) {
            return;
        }

        REGISTRY.put(sdkConfiguration, customConfig);
    }

    static Optional<GleanCustomConfig> get(SDKConfiguration sdkConfiguration) {
        if (sdkConfiguration == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(REGISTRY.get(sdkConfiguration));
    }

    static void clearForTests() {
        REGISTRY.clear();
    }
}
