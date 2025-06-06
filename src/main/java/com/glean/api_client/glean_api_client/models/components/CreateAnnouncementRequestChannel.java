/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * CreateAnnouncementRequestChannel
 * 
 * <p>This determines whether this is a Social Feed post or a regular announcement.
 */
public enum CreateAnnouncementRequestChannel {
    MAIN("MAIN"),
    SOCIAL_FEED("SOCIAL_FEED");

    @JsonValue
    private final String value;

    private CreateAnnouncementRequestChannel(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<CreateAnnouncementRequestChannel> fromValue(String value) {
        for (CreateAnnouncementRequestChannel o: CreateAnnouncementRequestChannel.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

