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
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public class IndexingShortcut {

    /**
     * link text following the viewPrefix as entered by the user. For example, if the view prefix is `go/` and the shortened URL is `go/abc`, then `abc` is the inputAlias.
     */
    @JsonProperty("inputAlias")
    private String inputAlias;

    /**
     * A short, plain text blurb to help people understand the intent of the shortcut.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("description")
    private Optional<String> description;

    /**
     * destination URL for the shortcut.
     */
    @JsonProperty("destinationUrl")
    private String destinationUrl;

    /**
     * Email of the user who created this shortcut.
     */
    @JsonProperty("createdBy")
    private String createdBy;

    /**
     * The time the shortcut was created in epoch seconds.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("createTime")
    private Optional<Long> createTime;

    /**
     * Email of the user who last updated this shortcut.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("updatedBy")
    private Optional<String> updatedBy;

    /**
     * The time the shortcut was updated in epoch seconds.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("updateTime")
    private Optional<Long> updateTime;

    /**
     * Whether this shortcut is unlisted or not. Unlisted shortcuts are visible to author and admins only.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("unlisted")
    private Optional<Boolean> unlisted;

    /**
     * For variable shortcuts, contains the URL template; note, `destinationUrl` contains default URL.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("urlTemplate")
    private Optional<String> urlTemplate;

    @JsonCreator
    public IndexingShortcut(
            @JsonProperty("inputAlias") String inputAlias,
            @JsonProperty("description") Optional<String> description,
            @JsonProperty("destinationUrl") String destinationUrl,
            @JsonProperty("createdBy") String createdBy,
            @JsonProperty("createTime") Optional<Long> createTime,
            @JsonProperty("updatedBy") Optional<String> updatedBy,
            @JsonProperty("updateTime") Optional<Long> updateTime,
            @JsonProperty("unlisted") Optional<Boolean> unlisted,
            @JsonProperty("urlTemplate") Optional<String> urlTemplate) {
        Utils.checkNotNull(inputAlias, "inputAlias");
        Utils.checkNotNull(description, "description");
        Utils.checkNotNull(destinationUrl, "destinationUrl");
        Utils.checkNotNull(createdBy, "createdBy");
        Utils.checkNotNull(createTime, "createTime");
        Utils.checkNotNull(updatedBy, "updatedBy");
        Utils.checkNotNull(updateTime, "updateTime");
        Utils.checkNotNull(unlisted, "unlisted");
        Utils.checkNotNull(urlTemplate, "urlTemplate");
        this.inputAlias = inputAlias;
        this.description = description;
        this.destinationUrl = destinationUrl;
        this.createdBy = createdBy;
        this.createTime = createTime;
        this.updatedBy = updatedBy;
        this.updateTime = updateTime;
        this.unlisted = unlisted;
        this.urlTemplate = urlTemplate;
    }
    
    public IndexingShortcut(
            String inputAlias,
            String destinationUrl,
            String createdBy) {
        this(inputAlias, Optional.empty(), destinationUrl, createdBy, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * link text following the viewPrefix as entered by the user. For example, if the view prefix is `go/` and the shortened URL is `go/abc`, then `abc` is the inputAlias.
     */
    @JsonIgnore
    public String inputAlias() {
        return inputAlias;
    }

    /**
     * A short, plain text blurb to help people understand the intent of the shortcut.
     */
    @JsonIgnore
    public Optional<String> description() {
        return description;
    }

    /**
     * destination URL for the shortcut.
     */
    @JsonIgnore
    public String destinationUrl() {
        return destinationUrl;
    }

    /**
     * Email of the user who created this shortcut.
     */
    @JsonIgnore
    public String createdBy() {
        return createdBy;
    }

    /**
     * The time the shortcut was created in epoch seconds.
     */
    @JsonIgnore
    public Optional<Long> createTime() {
        return createTime;
    }

    /**
     * Email of the user who last updated this shortcut.
     */
    @JsonIgnore
    public Optional<String> updatedBy() {
        return updatedBy;
    }

    /**
     * The time the shortcut was updated in epoch seconds.
     */
    @JsonIgnore
    public Optional<Long> updateTime() {
        return updateTime;
    }

    /**
     * Whether this shortcut is unlisted or not. Unlisted shortcuts are visible to author and admins only.
     */
    @JsonIgnore
    public Optional<Boolean> unlisted() {
        return unlisted;
    }

    /**
     * For variable shortcuts, contains the URL template; note, `destinationUrl` contains default URL.
     */
    @JsonIgnore
    public Optional<String> urlTemplate() {
        return urlTemplate;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * link text following the viewPrefix as entered by the user. For example, if the view prefix is `go/` and the shortened URL is `go/abc`, then `abc` is the inputAlias.
     */
    public IndexingShortcut withInputAlias(String inputAlias) {
        Utils.checkNotNull(inputAlias, "inputAlias");
        this.inputAlias = inputAlias;
        return this;
    }

    /**
     * A short, plain text blurb to help people understand the intent of the shortcut.
     */
    public IndexingShortcut withDescription(String description) {
        Utils.checkNotNull(description, "description");
        this.description = Optional.ofNullable(description);
        return this;
    }

    /**
     * A short, plain text blurb to help people understand the intent of the shortcut.
     */
    public IndexingShortcut withDescription(Optional<String> description) {
        Utils.checkNotNull(description, "description");
        this.description = description;
        return this;
    }

    /**
     * destination URL for the shortcut.
     */
    public IndexingShortcut withDestinationUrl(String destinationUrl) {
        Utils.checkNotNull(destinationUrl, "destinationUrl");
        this.destinationUrl = destinationUrl;
        return this;
    }

    /**
     * Email of the user who created this shortcut.
     */
    public IndexingShortcut withCreatedBy(String createdBy) {
        Utils.checkNotNull(createdBy, "createdBy");
        this.createdBy = createdBy;
        return this;
    }

    /**
     * The time the shortcut was created in epoch seconds.
     */
    public IndexingShortcut withCreateTime(long createTime) {
        Utils.checkNotNull(createTime, "createTime");
        this.createTime = Optional.ofNullable(createTime);
        return this;
    }

    /**
     * The time the shortcut was created in epoch seconds.
     */
    public IndexingShortcut withCreateTime(Optional<Long> createTime) {
        Utils.checkNotNull(createTime, "createTime");
        this.createTime = createTime;
        return this;
    }

    /**
     * Email of the user who last updated this shortcut.
     */
    public IndexingShortcut withUpdatedBy(String updatedBy) {
        Utils.checkNotNull(updatedBy, "updatedBy");
        this.updatedBy = Optional.ofNullable(updatedBy);
        return this;
    }

    /**
     * Email of the user who last updated this shortcut.
     */
    public IndexingShortcut withUpdatedBy(Optional<String> updatedBy) {
        Utils.checkNotNull(updatedBy, "updatedBy");
        this.updatedBy = updatedBy;
        return this;
    }

    /**
     * The time the shortcut was updated in epoch seconds.
     */
    public IndexingShortcut withUpdateTime(long updateTime) {
        Utils.checkNotNull(updateTime, "updateTime");
        this.updateTime = Optional.ofNullable(updateTime);
        return this;
    }

    /**
     * The time the shortcut was updated in epoch seconds.
     */
    public IndexingShortcut withUpdateTime(Optional<Long> updateTime) {
        Utils.checkNotNull(updateTime, "updateTime");
        this.updateTime = updateTime;
        return this;
    }

    /**
     * Whether this shortcut is unlisted or not. Unlisted shortcuts are visible to author and admins only.
     */
    public IndexingShortcut withUnlisted(boolean unlisted) {
        Utils.checkNotNull(unlisted, "unlisted");
        this.unlisted = Optional.ofNullable(unlisted);
        return this;
    }

    /**
     * Whether this shortcut is unlisted or not. Unlisted shortcuts are visible to author and admins only.
     */
    public IndexingShortcut withUnlisted(Optional<Boolean> unlisted) {
        Utils.checkNotNull(unlisted, "unlisted");
        this.unlisted = unlisted;
        return this;
    }

    /**
     * For variable shortcuts, contains the URL template; note, `destinationUrl` contains default URL.
     */
    public IndexingShortcut withUrlTemplate(String urlTemplate) {
        Utils.checkNotNull(urlTemplate, "urlTemplate");
        this.urlTemplate = Optional.ofNullable(urlTemplate);
        return this;
    }

    /**
     * For variable shortcuts, contains the URL template; note, `destinationUrl` contains default URL.
     */
    public IndexingShortcut withUrlTemplate(Optional<String> urlTemplate) {
        Utils.checkNotNull(urlTemplate, "urlTemplate");
        this.urlTemplate = urlTemplate;
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
        IndexingShortcut other = (IndexingShortcut) o;
        return 
            Objects.deepEquals(this.inputAlias, other.inputAlias) &&
            Objects.deepEquals(this.description, other.description) &&
            Objects.deepEquals(this.destinationUrl, other.destinationUrl) &&
            Objects.deepEquals(this.createdBy, other.createdBy) &&
            Objects.deepEquals(this.createTime, other.createTime) &&
            Objects.deepEquals(this.updatedBy, other.updatedBy) &&
            Objects.deepEquals(this.updateTime, other.updateTime) &&
            Objects.deepEquals(this.unlisted, other.unlisted) &&
            Objects.deepEquals(this.urlTemplate, other.urlTemplate);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            inputAlias,
            description,
            destinationUrl,
            createdBy,
            createTime,
            updatedBy,
            updateTime,
            unlisted,
            urlTemplate);
    }
    
    @Override
    public String toString() {
        return Utils.toString(IndexingShortcut.class,
                "inputAlias", inputAlias,
                "description", description,
                "destinationUrl", destinationUrl,
                "createdBy", createdBy,
                "createTime", createTime,
                "updatedBy", updatedBy,
                "updateTime", updateTime,
                "unlisted", unlisted,
                "urlTemplate", urlTemplate);
    }
    
    public final static class Builder {
 
        private String inputAlias;
 
        private Optional<String> description = Optional.empty();
 
        private String destinationUrl;
 
        private String createdBy;
 
        private Optional<Long> createTime = Optional.empty();
 
        private Optional<String> updatedBy = Optional.empty();
 
        private Optional<Long> updateTime = Optional.empty();
 
        private Optional<Boolean> unlisted = Optional.empty();
 
        private Optional<String> urlTemplate = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * link text following the viewPrefix as entered by the user. For example, if the view prefix is `go/` and the shortened URL is `go/abc`, then `abc` is the inputAlias.
         */
        public Builder inputAlias(String inputAlias) {
            Utils.checkNotNull(inputAlias, "inputAlias");
            this.inputAlias = inputAlias;
            return this;
        }

        /**
         * A short, plain text blurb to help people understand the intent of the shortcut.
         */
        public Builder description(String description) {
            Utils.checkNotNull(description, "description");
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * A short, plain text blurb to help people understand the intent of the shortcut.
         */
        public Builder description(Optional<String> description) {
            Utils.checkNotNull(description, "description");
            this.description = description;
            return this;
        }

        /**
         * destination URL for the shortcut.
         */
        public Builder destinationUrl(String destinationUrl) {
            Utils.checkNotNull(destinationUrl, "destinationUrl");
            this.destinationUrl = destinationUrl;
            return this;
        }

        /**
         * Email of the user who created this shortcut.
         */
        public Builder createdBy(String createdBy) {
            Utils.checkNotNull(createdBy, "createdBy");
            this.createdBy = createdBy;
            return this;
        }

        /**
         * The time the shortcut was created in epoch seconds.
         */
        public Builder createTime(long createTime) {
            Utils.checkNotNull(createTime, "createTime");
            this.createTime = Optional.ofNullable(createTime);
            return this;
        }

        /**
         * The time the shortcut was created in epoch seconds.
         */
        public Builder createTime(Optional<Long> createTime) {
            Utils.checkNotNull(createTime, "createTime");
            this.createTime = createTime;
            return this;
        }

        /**
         * Email of the user who last updated this shortcut.
         */
        public Builder updatedBy(String updatedBy) {
            Utils.checkNotNull(updatedBy, "updatedBy");
            this.updatedBy = Optional.ofNullable(updatedBy);
            return this;
        }

        /**
         * Email of the user who last updated this shortcut.
         */
        public Builder updatedBy(Optional<String> updatedBy) {
            Utils.checkNotNull(updatedBy, "updatedBy");
            this.updatedBy = updatedBy;
            return this;
        }

        /**
         * The time the shortcut was updated in epoch seconds.
         */
        public Builder updateTime(long updateTime) {
            Utils.checkNotNull(updateTime, "updateTime");
            this.updateTime = Optional.ofNullable(updateTime);
            return this;
        }

        /**
         * The time the shortcut was updated in epoch seconds.
         */
        public Builder updateTime(Optional<Long> updateTime) {
            Utils.checkNotNull(updateTime, "updateTime");
            this.updateTime = updateTime;
            return this;
        }

        /**
         * Whether this shortcut is unlisted or not. Unlisted shortcuts are visible to author and admins only.
         */
        public Builder unlisted(boolean unlisted) {
            Utils.checkNotNull(unlisted, "unlisted");
            this.unlisted = Optional.ofNullable(unlisted);
            return this;
        }

        /**
         * Whether this shortcut is unlisted or not. Unlisted shortcuts are visible to author and admins only.
         */
        public Builder unlisted(Optional<Boolean> unlisted) {
            Utils.checkNotNull(unlisted, "unlisted");
            this.unlisted = unlisted;
            return this;
        }

        /**
         * For variable shortcuts, contains the URL template; note, `destinationUrl` contains default URL.
         */
        public Builder urlTemplate(String urlTemplate) {
            Utils.checkNotNull(urlTemplate, "urlTemplate");
            this.urlTemplate = Optional.ofNullable(urlTemplate);
            return this;
        }

        /**
         * For variable shortcuts, contains the URL template; note, `destinationUrl` contains default URL.
         */
        public Builder urlTemplate(Optional<String> urlTemplate) {
            Utils.checkNotNull(urlTemplate, "urlTemplate");
            this.urlTemplate = urlTemplate;
            return this;
        }
        
        public IndexingShortcut build() {
            return new IndexingShortcut(
                inputAlias,
                description,
                destinationUrl,
                createdBy,
                createTime,
                updatedBy,
                updateTime,
                unlisted,
                urlTemplate);
        }
    }
}
