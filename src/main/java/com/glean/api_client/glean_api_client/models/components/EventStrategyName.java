/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * EventStrategyName
 * 
 * <p>The name of method used to surface relevant data for a given calendar event.
 */
public enum EventStrategyName {
    CUSTOMER_CARD("customerCard"),
    NEWS("news"),
    CALL("call"),
    EMAIL("email"),
    MEETING_NOTES("meetingNotes"),
    LINKED_IN("linkedIn"),
    RELEVANT_DOCUMENTS("relevantDocuments"),
    CHAT_FOLLOW_UPS("chatFollowUps"),
    CONVERSATIONS("conversations");

    @JsonValue
    private final String value;

    private EventStrategyName(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<EventStrategyName> fromValue(String value) {
        for (EventStrategyName o: EventStrategyName.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

