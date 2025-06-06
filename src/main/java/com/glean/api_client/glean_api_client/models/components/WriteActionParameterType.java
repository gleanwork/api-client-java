/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * WriteActionParameterType
 * 
 * <p>The type of the value (e.g., integer, string, boolean, etc.)
 */
public enum WriteActionParameterType {
    UNKNOWN("UNKNOWN"),
    INTEGER("INTEGER"),
    STRING("STRING"),
    BOOLEAN("BOOLEAN");

    @JsonValue
    private final String value;

    private WriteActionParameterType(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<WriteActionParameterType> fromValue(String value) {
        for (WriteActionParameterType o: WriteActionParameterType.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

