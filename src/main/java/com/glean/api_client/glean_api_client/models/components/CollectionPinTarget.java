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
import java.util.Objects;
import java.util.Optional;

public class CollectionPinTarget {

    /**
     * Categories a Collection can be pinned to.
     */
    @JsonProperty("category")
    private CollectionPinnableCategories category;

    /**
     * Optional. If category supports values, then the additional value for the category e.g. department name for DEPARTMENT_RESOURCE, team name/id for TEAM_RESOURCE and so on.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("value")
    private Optional<String> value;

    /**
     * What targets can a Collection be pinned to.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("target")
    private Optional<? extends CollectionPinnableTargets> target;

    @JsonCreator
    public CollectionPinTarget(
            @JsonProperty("category") CollectionPinnableCategories category,
            @JsonProperty("value") Optional<String> value,
            @JsonProperty("target") Optional<? extends CollectionPinnableTargets> target) {
        Utils.checkNotNull(category, "category");
        Utils.checkNotNull(value, "value");
        Utils.checkNotNull(target, "target");
        this.category = category;
        this.value = value;
        this.target = target;
    }
    
    public CollectionPinTarget(
            CollectionPinnableCategories category) {
        this(category, Optional.empty(), Optional.empty());
    }

    /**
     * Categories a Collection can be pinned to.
     */
    @JsonIgnore
    public CollectionPinnableCategories category() {
        return category;
    }

    /**
     * Optional. If category supports values, then the additional value for the category e.g. department name for DEPARTMENT_RESOURCE, team name/id for TEAM_RESOURCE and so on.
     */
    @JsonIgnore
    public Optional<String> value() {
        return value;
    }

    /**
     * What targets can a Collection be pinned to.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CollectionPinnableTargets> target() {
        return (Optional<CollectionPinnableTargets>) target;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Categories a Collection can be pinned to.
     */
    public CollectionPinTarget withCategory(CollectionPinnableCategories category) {
        Utils.checkNotNull(category, "category");
        this.category = category;
        return this;
    }

    /**
     * Optional. If category supports values, then the additional value for the category e.g. department name for DEPARTMENT_RESOURCE, team name/id for TEAM_RESOURCE and so on.
     */
    public CollectionPinTarget withValue(String value) {
        Utils.checkNotNull(value, "value");
        this.value = Optional.ofNullable(value);
        return this;
    }

    /**
     * Optional. If category supports values, then the additional value for the category e.g. department name for DEPARTMENT_RESOURCE, team name/id for TEAM_RESOURCE and so on.
     */
    public CollectionPinTarget withValue(Optional<String> value) {
        Utils.checkNotNull(value, "value");
        this.value = value;
        return this;
    }

    /**
     * What targets can a Collection be pinned to.
     */
    public CollectionPinTarget withTarget(CollectionPinnableTargets target) {
        Utils.checkNotNull(target, "target");
        this.target = Optional.ofNullable(target);
        return this;
    }

    /**
     * What targets can a Collection be pinned to.
     */
    public CollectionPinTarget withTarget(Optional<? extends CollectionPinnableTargets> target) {
        Utils.checkNotNull(target, "target");
        this.target = target;
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
        CollectionPinTarget other = (CollectionPinTarget) o;
        return 
            Objects.deepEquals(this.category, other.category) &&
            Objects.deepEquals(this.value, other.value) &&
            Objects.deepEquals(this.target, other.target);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            category,
            value,
            target);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CollectionPinTarget.class,
                "category", category,
                "value", value,
                "target", target);
    }
    
    public final static class Builder {
 
        private CollectionPinnableCategories category;
 
        private Optional<String> value = Optional.empty();
 
        private Optional<? extends CollectionPinnableTargets> target = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Categories a Collection can be pinned to.
         */
        public Builder category(CollectionPinnableCategories category) {
            Utils.checkNotNull(category, "category");
            this.category = category;
            return this;
        }

        /**
         * Optional. If category supports values, then the additional value for the category e.g. department name for DEPARTMENT_RESOURCE, team name/id for TEAM_RESOURCE and so on.
         */
        public Builder value(String value) {
            Utils.checkNotNull(value, "value");
            this.value = Optional.ofNullable(value);
            return this;
        }

        /**
         * Optional. If category supports values, then the additional value for the category e.g. department name for DEPARTMENT_RESOURCE, team name/id for TEAM_RESOURCE and so on.
         */
        public Builder value(Optional<String> value) {
            Utils.checkNotNull(value, "value");
            this.value = value;
            return this;
        }

        /**
         * What targets can a Collection be pinned to.
         */
        public Builder target(CollectionPinnableTargets target) {
            Utils.checkNotNull(target, "target");
            this.target = Optional.ofNullable(target);
            return this;
        }

        /**
         * What targets can a Collection be pinned to.
         */
        public Builder target(Optional<? extends CollectionPinnableTargets> target) {
            Utils.checkNotNull(target, "target");
            this.target = target;
            return this;
        }
        
        public CollectionPinTarget build() {
            return new CollectionPinTarget(
                category,
                value,
                target);
        }
    }
}
