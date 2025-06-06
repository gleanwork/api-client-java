/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * ChatFileFailureReason
 * 
 * <p>Reason for failed status.
 */
public enum ChatFileFailureReason {
    PARSE_FAILED("PARSE_FAILED"),
    AV_SCAN_FAILED("AV_SCAN_FAILED"),
    FILE_TOO_SMALL("FILE_TOO_SMALL"),
    FILE_TOO_LARGE("FILE_TOO_LARGE"),
    FILE_EXTENSION_UNSUPPORTED("FILE_EXTENSION_UNSUPPORTED"),
    FILE_METADATA_VALIDATION_FAIL("FILE_METADATA_VALIDATION_FAIL"),
    FILE_PROCESSING_TIMED_OUT("FILE_PROCESSING_TIMED_OUT");

    @JsonValue
    private final String value;

    private ChatFileFailureReason(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<ChatFileFailureReason> fromValue(String value) {
        for (ChatFileFailureReason o: ChatFileFailureReason.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

