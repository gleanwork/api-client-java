/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * StructuredResultSource
 * 
 * <p>Source context for this result. Possible values depend on the result type.
 */
public enum StructuredResultSource {
    EXPERT_DETECTION("EXPERT_DETECTION"),
    ENTITY_NLQ("ENTITY_NLQ");

    @JsonValue
    private final String value;

    private StructuredResultSource(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<StructuredResultSource> fromValue(String value) {
        for (StructuredResultSource o: StructuredResultSource.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

