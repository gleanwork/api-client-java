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
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;

/**
 * CustomProperty
 * 
 * <p>Describes the custom properties of the object.
 */
public class CustomProperty {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("name")
    private Optional<String> name;

    /**
     * Must either be a string or an array of strings. An integer, boolean, etc. is not valid. When OpenAPI Generator supports `oneOf`, we can semantically enforce this.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("value")
    private Optional<? extends Object> value;

    @JsonCreator
    public CustomProperty(
            @JsonProperty("name") Optional<String> name,
            @JsonProperty("value") Optional<? extends Object> value) {
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(value, "value");
        this.name = name;
        this.value = value;
    }
    
    public CustomProperty() {
        this(Optional.empty(), Optional.empty());
    }

    @JsonIgnore
    public Optional<String> name() {
        return name;
    }

    /**
     * Must either be a string or an array of strings. An integer, boolean, etc. is not valid. When OpenAPI Generator supports `oneOf`, we can semantically enforce this.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Object> value() {
        return (Optional<Object>) value;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    public CustomProperty withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = Optional.ofNullable(name);
        return this;
    }

    public CustomProperty withName(Optional<String> name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    /**
     * Must either be a string or an array of strings. An integer, boolean, etc. is not valid. When OpenAPI Generator supports `oneOf`, we can semantically enforce this.
     */
    public CustomProperty withValue(Object value) {
        Utils.checkNotNull(value, "value");
        this.value = Optional.ofNullable(value);
        return this;
    }

    /**
     * Must either be a string or an array of strings. An integer, boolean, etc. is not valid. When OpenAPI Generator supports `oneOf`, we can semantically enforce this.
     */
    public CustomProperty withValue(Optional<? extends Object> value) {
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
        CustomProperty other = (CustomProperty) o;
        return 
            Objects.deepEquals(this.name, other.name) &&
            Objects.deepEquals(this.value, other.value);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            name,
            value);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CustomProperty.class,
                "name", name,
                "value", value);
    }
    
    public final static class Builder {
 
        private Optional<String> name = Optional.empty();
 
        private Optional<? extends Object> value = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = Optional.ofNullable(name);
            return this;
        }

        public Builder name(Optional<String> name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }

        /**
         * Must either be a string or an array of strings. An integer, boolean, etc. is not valid. When OpenAPI Generator supports `oneOf`, we can semantically enforce this.
         */
        public Builder value(Object value) {
            Utils.checkNotNull(value, "value");
            this.value = Optional.ofNullable(value);
            return this;
        }

        /**
         * Must either be a string or an array of strings. An integer, boolean, etc. is not valid. When OpenAPI Generator supports `oneOf`, we can semantically enforce this.
         */
        public Builder value(Optional<? extends Object> value) {
            Utils.checkNotNull(value, "value");
            this.value = value;
            return this;
        }
        
        public CustomProperty build() {
            return new CustomProperty(
                name,
                value);
        }
    }
}
