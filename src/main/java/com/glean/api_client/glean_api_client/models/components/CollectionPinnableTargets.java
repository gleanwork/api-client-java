/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * CollectionPinnableTargets
 * 
 * <p>What targets can a Collection be pinned to.
 */
public enum CollectionPinnableTargets {
    RESOURCE_CARD("RESOURCE_CARD"),
    TEAM_PROFILE_PAGE("TEAM_PROFILE_PAGE");

    @JsonValue
    private final String value;

    private CollectionPinnableTargets(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<CollectionPinnableTargets> fromValue(String value) {
        for (CollectionPinnableTargets o: CollectionPinnableTargets.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

