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
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;

/**
 * Badge
 * 
 * <p>Displays a user's accomplishment or milestone
 */
public class Badge {

    /**
     * An auto generated unique identifier.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("key")
    private Optional<String> key;

    /**
     * The badge name displayed to users
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("displayName")
    private Optional<String> displayName;

    /**
     * Defines how to render an icon
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("iconConfig")
    private Optional<? extends IconConfig> iconConfig;

    /**
     * The badge should be shown on the PersonAttribution
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("pinned")
    private Optional<Boolean> pinned;

    @JsonCreator
    public Badge(
            @JsonProperty("key") Optional<String> key,
            @JsonProperty("displayName") Optional<String> displayName,
            @JsonProperty("iconConfig") Optional<? extends IconConfig> iconConfig,
            @JsonProperty("pinned") Optional<Boolean> pinned) {
        Utils.checkNotNull(key, "key");
        Utils.checkNotNull(displayName, "displayName");
        Utils.checkNotNull(iconConfig, "iconConfig");
        Utils.checkNotNull(pinned, "pinned");
        this.key = key;
        this.displayName = displayName;
        this.iconConfig = iconConfig;
        this.pinned = pinned;
    }
    
    public Badge() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * An auto generated unique identifier.
     */
    @JsonIgnore
    public Optional<String> key() {
        return key;
    }

    /**
     * The badge name displayed to users
     */
    @JsonIgnore
    public Optional<String> displayName() {
        return displayName;
    }

    /**
     * Defines how to render an icon
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<IconConfig> iconConfig() {
        return (Optional<IconConfig>) iconConfig;
    }

    /**
     * The badge should be shown on the PersonAttribution
     */
    @JsonIgnore
    public Optional<Boolean> pinned() {
        return pinned;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * An auto generated unique identifier.
     */
    public Badge withKey(String key) {
        Utils.checkNotNull(key, "key");
        this.key = Optional.ofNullable(key);
        return this;
    }

    /**
     * An auto generated unique identifier.
     */
    public Badge withKey(Optional<String> key) {
        Utils.checkNotNull(key, "key");
        this.key = key;
        return this;
    }

    /**
     * The badge name displayed to users
     */
    public Badge withDisplayName(String displayName) {
        Utils.checkNotNull(displayName, "displayName");
        this.displayName = Optional.ofNullable(displayName);
        return this;
    }

    /**
     * The badge name displayed to users
     */
    public Badge withDisplayName(Optional<String> displayName) {
        Utils.checkNotNull(displayName, "displayName");
        this.displayName = displayName;
        return this;
    }

    /**
     * Defines how to render an icon
     */
    public Badge withIconConfig(IconConfig iconConfig) {
        Utils.checkNotNull(iconConfig, "iconConfig");
        this.iconConfig = Optional.ofNullable(iconConfig);
        return this;
    }

    /**
     * Defines how to render an icon
     */
    public Badge withIconConfig(Optional<? extends IconConfig> iconConfig) {
        Utils.checkNotNull(iconConfig, "iconConfig");
        this.iconConfig = iconConfig;
        return this;
    }

    /**
     * The badge should be shown on the PersonAttribution
     */
    public Badge withPinned(boolean pinned) {
        Utils.checkNotNull(pinned, "pinned");
        this.pinned = Optional.ofNullable(pinned);
        return this;
    }

    /**
     * The badge should be shown on the PersonAttribution
     */
    public Badge withPinned(Optional<Boolean> pinned) {
        Utils.checkNotNull(pinned, "pinned");
        this.pinned = pinned;
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
        Badge other = (Badge) o;
        return 
            Objects.deepEquals(this.key, other.key) &&
            Objects.deepEquals(this.displayName, other.displayName) &&
            Objects.deepEquals(this.iconConfig, other.iconConfig) &&
            Objects.deepEquals(this.pinned, other.pinned);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            key,
            displayName,
            iconConfig,
            pinned);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Badge.class,
                "key", key,
                "displayName", displayName,
                "iconConfig", iconConfig,
                "pinned", pinned);
    }
    
    public final static class Builder {
 
        private Optional<String> key = Optional.empty();
 
        private Optional<String> displayName = Optional.empty();
 
        private Optional<? extends IconConfig> iconConfig = Optional.empty();
 
        private Optional<Boolean> pinned = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * An auto generated unique identifier.
         */
        public Builder key(String key) {
            Utils.checkNotNull(key, "key");
            this.key = Optional.ofNullable(key);
            return this;
        }

        /**
         * An auto generated unique identifier.
         */
        public Builder key(Optional<String> key) {
            Utils.checkNotNull(key, "key");
            this.key = key;
            return this;
        }

        /**
         * The badge name displayed to users
         */
        public Builder displayName(String displayName) {
            Utils.checkNotNull(displayName, "displayName");
            this.displayName = Optional.ofNullable(displayName);
            return this;
        }

        /**
         * The badge name displayed to users
         */
        public Builder displayName(Optional<String> displayName) {
            Utils.checkNotNull(displayName, "displayName");
            this.displayName = displayName;
            return this;
        }

        /**
         * Defines how to render an icon
         */
        public Builder iconConfig(IconConfig iconConfig) {
            Utils.checkNotNull(iconConfig, "iconConfig");
            this.iconConfig = Optional.ofNullable(iconConfig);
            return this;
        }

        /**
         * Defines how to render an icon
         */
        public Builder iconConfig(Optional<? extends IconConfig> iconConfig) {
            Utils.checkNotNull(iconConfig, "iconConfig");
            this.iconConfig = iconConfig;
            return this;
        }

        /**
         * The badge should be shown on the PersonAttribution
         */
        public Builder pinned(boolean pinned) {
            Utils.checkNotNull(pinned, "pinned");
            this.pinned = Optional.ofNullable(pinned);
            return this;
        }

        /**
         * The badge should be shown on the PersonAttribution
         */
        public Builder pinned(Optional<Boolean> pinned) {
            Utils.checkNotNull(pinned, "pinned");
            this.pinned = pinned;
            return this;
        }
        
        public Badge build() {
            return new Badge(
                key,
                displayName,
                iconConfig,
                pinned);
        }
    }
}
