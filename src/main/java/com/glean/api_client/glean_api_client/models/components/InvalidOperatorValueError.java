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
import java.util.Objects;
import java.util.Optional;

public class InvalidOperatorValueError {

    /**
     * The operator key that has an invalid value.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("key")
    private Optional<String> key;

    /**
     * The invalid operator value.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("value")
    private Optional<String> value;

    @JsonCreator
    public InvalidOperatorValueError(
            @JsonProperty("key") Optional<String> key,
            @JsonProperty("value") Optional<String> value) {
        Utils.checkNotNull(key, "key");
        Utils.checkNotNull(value, "value");
        this.key = key;
        this.value = value;
    }
    
    public InvalidOperatorValueError() {
        this(Optional.empty(), Optional.empty());
    }

    /**
     * The operator key that has an invalid value.
     */
    @JsonIgnore
    public Optional<String> key() {
        return key;
    }

    /**
     * The invalid operator value.
     */
    @JsonIgnore
    public Optional<String> value() {
        return value;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The operator key that has an invalid value.
     */
    public InvalidOperatorValueError withKey(String key) {
        Utils.checkNotNull(key, "key");
        this.key = Optional.ofNullable(key);
        return this;
    }

    /**
     * The operator key that has an invalid value.
     */
    public InvalidOperatorValueError withKey(Optional<String> key) {
        Utils.checkNotNull(key, "key");
        this.key = key;
        return this;
    }

    /**
     * The invalid operator value.
     */
    public InvalidOperatorValueError withValue(String value) {
        Utils.checkNotNull(value, "value");
        this.value = Optional.ofNullable(value);
        return this;
    }

    /**
     * The invalid operator value.
     */
    public InvalidOperatorValueError withValue(Optional<String> value) {
        Utils.checkNotNull(value, "value");
        this.value = value;
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
        InvalidOperatorValueError other = (InvalidOperatorValueError) o;
        return 
            Objects.deepEquals(this.key, other.key) &&
            Objects.deepEquals(this.value, other.value);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            key,
            value);
    }
    
    @Override
    public String toString() {
        return Utils.toString(InvalidOperatorValueError.class,
                "key", key,
                "value", value);
    }
    
    public final static class Builder {
 
        private Optional<String> key = Optional.empty();
 
        private Optional<String> value = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The operator key that has an invalid value.
         */
        public Builder key(String key) {
            Utils.checkNotNull(key, "key");
            this.key = Optional.ofNullable(key);
            return this;
        }

        /**
         * The operator key that has an invalid value.
         */
        public Builder key(Optional<String> key) {
            Utils.checkNotNull(key, "key");
            this.key = key;
            return this;
        }

        /**
         * The invalid operator value.
         */
        public Builder value(String value) {
            Utils.checkNotNull(value, "value");
            this.value = Optional.ofNullable(value);
            return this;
        }

        /**
         * The invalid operator value.
         */
        public Builder value(Optional<String> value) {
            Utils.checkNotNull(value, "value");
            this.value = value;
            return this;
        }
        
        public InvalidOperatorValueError build() {
            return new InvalidOperatorValueError(
                key,
                value);
        }
    }
}
