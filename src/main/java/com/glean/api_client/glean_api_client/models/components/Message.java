/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Message {

    /**
     * The role of the message.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("role")
    private Optional<String> role;

    /**
     * The content of the message.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("content")
    private Optional<? extends List<MessageTextBlock>> content;

    @JsonCreator
    public Message(
            @JsonProperty("role") Optional<String> role,
            @JsonProperty("content") Optional<? extends List<MessageTextBlock>> content) {
        Utils.checkNotNull(role, "role");
        Utils.checkNotNull(content, "content");
        this.role = role;
        this.content = content;
    }
    
    public Message() {
        this(Optional.empty(), Optional.empty());
    }

    /**
     * The role of the message.
     */
    @JsonIgnore
    public Optional<String> role() {
        return role;
    }

    /**
     * The content of the message.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<MessageTextBlock>> content() {
        return (Optional<List<MessageTextBlock>>) content;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The role of the message.
     */
    public Message withRole(String role) {
        Utils.checkNotNull(role, "role");
        this.role = Optional.ofNullable(role);
        return this;
    }

    /**
     * The role of the message.
     */
    public Message withRole(Optional<String> role) {
        Utils.checkNotNull(role, "role");
        this.role = role;
        return this;
    }

    /**
     * The content of the message.
     */
    public Message withContent(List<MessageTextBlock> content) {
        Utils.checkNotNull(content, "content");
        this.content = Optional.ofNullable(content);
        return this;
    }

    /**
     * The content of the message.
     */
    public Message withContent(Optional<? extends List<MessageTextBlock>> content) {
        Utils.checkNotNull(content, "content");
        this.content = content;
        return this;
    }

    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message other = (Message) o;
        return 
            Objects.deepEquals(this.role, other.role) &&
            Objects.deepEquals(this.content, other.content);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            role,
            content);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Message.class,
                "role", role,
                "content", content);
    }
    
    public final static class Builder {
 
        private Optional<String> role = Optional.empty();
 
        private Optional<? extends List<MessageTextBlock>> content = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The role of the message.
         */
        public Builder role(String role) {
            Utils.checkNotNull(role, "role");
            this.role = Optional.ofNullable(role);
            return this;
        }

        /**
         * The role of the message.
         */
        public Builder role(Optional<String> role) {
            Utils.checkNotNull(role, "role");
            this.role = role;
            return this;
        }

        /**
         * The content of the message.
         */
        public Builder content(List<MessageTextBlock> content) {
            Utils.checkNotNull(content, "content");
            this.content = Optional.ofNullable(content);
            return this;
        }

        /**
         * The content of the message.
         */
        public Builder content(Optional<? extends List<MessageTextBlock>> content) {
            Utils.checkNotNull(content, "content");
            this.content = content;
            return this;
        }
        
        public Message build() {
            return new Message(
                role,
                content);
        }
    }
}
