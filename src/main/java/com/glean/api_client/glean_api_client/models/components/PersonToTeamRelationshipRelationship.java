/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * PersonToTeamRelationshipRelationship
 * 
 * <p>The team member's relationship to the team. This defaults to MEMBER if not set.
 */
public enum PersonToTeamRelationshipRelationship {
    MEMBER("MEMBER"),
    MANAGER("MANAGER"),
    LEAD("LEAD"),
    POINT_OF_CONTACT("POINT_OF_CONTACT"),
    OTHER("OTHER");

    @JsonValue
    private final String value;

    private PersonToTeamRelationshipRelationship(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<PersonToTeamRelationshipRelationship> fromValue(String value) {
        for (PersonToTeamRelationshipRelationship o: PersonToTeamRelationshipRelationship.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

