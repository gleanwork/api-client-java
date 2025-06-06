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
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ShortcutMutableProperties {

    /**
     * Link text following go/ prefix as entered by the user.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("inputAlias")
    private Optional<String> inputAlias;

    /**
     * Destination URL for the shortcut.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("destinationUrl")
    private Optional<String> destinationUrl;

    /**
     * Glean Document ID for the URL, if known.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("destinationDocumentId")
    private Optional<String> destinationDocumentId;

    /**
     * A short, plain text blurb to help people understand the intent of the shortcut.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("description")
    private Optional<String> description;

    /**
     * Whether this shortcut is unlisted or not. Unlisted shortcuts are visible to author + admins only.
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

    /**
     * A list of user roles added for the Shortcut.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("addedRoles")
    private Optional<? extends List<UserRoleSpecification>> addedRoles;

    /**
     * A list of user roles removed for the Shortcut.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("removedRoles")
    private Optional<? extends List<UserRoleSpecification>> removedRoles;

    @JsonCreator
    public ShortcutMutableProperties(
            @JsonProperty("inputAlias") Optional<String> inputAlias,
            @JsonProperty("destinationUrl") Optional<String> destinationUrl,
            @JsonProperty("destinationDocumentId") Optional<String> destinationDocumentId,
            @JsonProperty("description") Optional<String> description,
            @JsonProperty("unlisted") Optional<Boolean> unlisted,
            @JsonProperty("urlTemplate") Optional<String> urlTemplate,
            @JsonProperty("addedRoles") Optional<? extends List<UserRoleSpecification>> addedRoles,
            @JsonProperty("removedRoles") Optional<? extends List<UserRoleSpecification>> removedRoles) {
        Utils.checkNotNull(inputAlias, "inputAlias");
        Utils.checkNotNull(destinationUrl, "destinationUrl");
        Utils.checkNotNull(destinationDocumentId, "destinationDocumentId");
        Utils.checkNotNull(description, "description");
        Utils.checkNotNull(unlisted, "unlisted");
        Utils.checkNotNull(urlTemplate, "urlTemplate");
        Utils.checkNotNull(addedRoles, "addedRoles");
        Utils.checkNotNull(removedRoles, "removedRoles");
        this.inputAlias = inputAlias;
        this.destinationUrl = destinationUrl;
        this.destinationDocumentId = destinationDocumentId;
        this.description = description;
        this.unlisted = unlisted;
        this.urlTemplate = urlTemplate;
        this.addedRoles = addedRoles;
        this.removedRoles = removedRoles;
    }
    
    public ShortcutMutableProperties() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * Link text following go/ prefix as entered by the user.
     */
    @JsonIgnore
    public Optional<String> inputAlias() {
        return inputAlias;
    }

    /**
     * Destination URL for the shortcut.
     */
    @JsonIgnore
    public Optional<String> destinationUrl() {
        return destinationUrl;
    }

    /**
     * Glean Document ID for the URL, if known.
     */
    @JsonIgnore
    public Optional<String> destinationDocumentId() {
        return destinationDocumentId;
    }

    /**
     * A short, plain text blurb to help people understand the intent of the shortcut.
     */
    @JsonIgnore
    public Optional<String> description() {
        return description;
    }

    /**
     * Whether this shortcut is unlisted or not. Unlisted shortcuts are visible to author + admins only.
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

    /**
     * A list of user roles added for the Shortcut.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<UserRoleSpecification>> addedRoles() {
        return (Optional<List<UserRoleSpecification>>) addedRoles;
    }

    /**
     * A list of user roles removed for the Shortcut.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<UserRoleSpecification>> removedRoles() {
        return (Optional<List<UserRoleSpecification>>) removedRoles;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Link text following go/ prefix as entered by the user.
     */
    public ShortcutMutableProperties withInputAlias(String inputAlias) {
        Utils.checkNotNull(inputAlias, "inputAlias");
        this.inputAlias = Optional.ofNullable(inputAlias);
        return this;
    }

    /**
     * Link text following go/ prefix as entered by the user.
     */
    public ShortcutMutableProperties withInputAlias(Optional<String> inputAlias) {
        Utils.checkNotNull(inputAlias, "inputAlias");
        this.inputAlias = inputAlias;
        return this;
    }

    /**
     * Destination URL for the shortcut.
     */
    public ShortcutMutableProperties withDestinationUrl(String destinationUrl) {
        Utils.checkNotNull(destinationUrl, "destinationUrl");
        this.destinationUrl = Optional.ofNullable(destinationUrl);
        return this;
    }

    /**
     * Destination URL for the shortcut.
     */
    public ShortcutMutableProperties withDestinationUrl(Optional<String> destinationUrl) {
        Utils.checkNotNull(destinationUrl, "destinationUrl");
        this.destinationUrl = destinationUrl;
        return this;
    }

    /**
     * Glean Document ID for the URL, if known.
     */
    public ShortcutMutableProperties withDestinationDocumentId(String destinationDocumentId) {
        Utils.checkNotNull(destinationDocumentId, "destinationDocumentId");
        this.destinationDocumentId = Optional.ofNullable(destinationDocumentId);
        return this;
    }

    /**
     * Glean Document ID for the URL, if known.
     */
    public ShortcutMutableProperties withDestinationDocumentId(Optional<String> destinationDocumentId) {
        Utils.checkNotNull(destinationDocumentId, "destinationDocumentId");
        this.destinationDocumentId = destinationDocumentId;
        return this;
    }

    /**
     * A short, plain text blurb to help people understand the intent of the shortcut.
     */
    public ShortcutMutableProperties withDescription(String description) {
        Utils.checkNotNull(description, "description");
        this.description = Optional.ofNullable(description);
        return this;
    }

    /**
     * A short, plain text blurb to help people understand the intent of the shortcut.
     */
    public ShortcutMutableProperties withDescription(Optional<String> description) {
        Utils.checkNotNull(description, "description");
        this.description = description;
        return this;
    }

    /**
     * Whether this shortcut is unlisted or not. Unlisted shortcuts are visible to author + admins only.
     */
    public ShortcutMutableProperties withUnlisted(boolean unlisted) {
        Utils.checkNotNull(unlisted, "unlisted");
        this.unlisted = Optional.ofNullable(unlisted);
        return this;
    }

    /**
     * Whether this shortcut is unlisted or not. Unlisted shortcuts are visible to author + admins only.
     */
    public ShortcutMutableProperties withUnlisted(Optional<Boolean> unlisted) {
        Utils.checkNotNull(unlisted, "unlisted");
        this.unlisted = unlisted;
        return this;
    }

    /**
     * For variable shortcuts, contains the URL template; note, `destinationUrl` contains default URL.
     */
    public ShortcutMutableProperties withUrlTemplate(String urlTemplate) {
        Utils.checkNotNull(urlTemplate, "urlTemplate");
        this.urlTemplate = Optional.ofNullable(urlTemplate);
        return this;
    }

    /**
     * For variable shortcuts, contains the URL template; note, `destinationUrl` contains default URL.
     */
    public ShortcutMutableProperties withUrlTemplate(Optional<String> urlTemplate) {
        Utils.checkNotNull(urlTemplate, "urlTemplate");
        this.urlTemplate = urlTemplate;
        return this;
    }

    /**
     * A list of user roles added for the Shortcut.
     */
    public ShortcutMutableProperties withAddedRoles(List<UserRoleSpecification> addedRoles) {
        Utils.checkNotNull(addedRoles, "addedRoles");
        this.addedRoles = Optional.ofNullable(addedRoles);
        return this;
    }

    /**
     * A list of user roles added for the Shortcut.
     */
    public ShortcutMutableProperties withAddedRoles(Optional<? extends List<UserRoleSpecification>> addedRoles) {
        Utils.checkNotNull(addedRoles, "addedRoles");
        this.addedRoles = addedRoles;
        return this;
    }

    /**
     * A list of user roles removed for the Shortcut.
     */
    public ShortcutMutableProperties withRemovedRoles(List<UserRoleSpecification> removedRoles) {
        Utils.checkNotNull(removedRoles, "removedRoles");
        this.removedRoles = Optional.ofNullable(removedRoles);
        return this;
    }

    /**
     * A list of user roles removed for the Shortcut.
     */
    public ShortcutMutableProperties withRemovedRoles(Optional<? extends List<UserRoleSpecification>> removedRoles) {
        Utils.checkNotNull(removedRoles, "removedRoles");
        this.removedRoles = removedRoles;
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
        ShortcutMutableProperties other = (ShortcutMutableProperties) o;
        return 
            Objects.deepEquals(this.inputAlias, other.inputAlias) &&
            Objects.deepEquals(this.destinationUrl, other.destinationUrl) &&
            Objects.deepEquals(this.destinationDocumentId, other.destinationDocumentId) &&
            Objects.deepEquals(this.description, other.description) &&
            Objects.deepEquals(this.unlisted, other.unlisted) &&
            Objects.deepEquals(this.urlTemplate, other.urlTemplate) &&
            Objects.deepEquals(this.addedRoles, other.addedRoles) &&
            Objects.deepEquals(this.removedRoles, other.removedRoles);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            inputAlias,
            destinationUrl,
            destinationDocumentId,
            description,
            unlisted,
            urlTemplate,
            addedRoles,
            removedRoles);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ShortcutMutableProperties.class,
                "inputAlias", inputAlias,
                "destinationUrl", destinationUrl,
                "destinationDocumentId", destinationDocumentId,
                "description", description,
                "unlisted", unlisted,
                "urlTemplate", urlTemplate,
                "addedRoles", addedRoles,
                "removedRoles", removedRoles);
    }
    
    public final static class Builder {
 
        private Optional<String> inputAlias = Optional.empty();
 
        private Optional<String> destinationUrl = Optional.empty();
 
        private Optional<String> destinationDocumentId = Optional.empty();
 
        private Optional<String> description = Optional.empty();
 
        private Optional<Boolean> unlisted = Optional.empty();
 
        private Optional<String> urlTemplate = Optional.empty();
 
        private Optional<? extends List<UserRoleSpecification>> addedRoles = Optional.empty();
 
        private Optional<? extends List<UserRoleSpecification>> removedRoles = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Link text following go/ prefix as entered by the user.
         */
        public Builder inputAlias(String inputAlias) {
            Utils.checkNotNull(inputAlias, "inputAlias");
            this.inputAlias = Optional.ofNullable(inputAlias);
            return this;
        }

        /**
         * Link text following go/ prefix as entered by the user.
         */
        public Builder inputAlias(Optional<String> inputAlias) {
            Utils.checkNotNull(inputAlias, "inputAlias");
            this.inputAlias = inputAlias;
            return this;
        }

        /**
         * Destination URL for the shortcut.
         */
        public Builder destinationUrl(String destinationUrl) {
            Utils.checkNotNull(destinationUrl, "destinationUrl");
            this.destinationUrl = Optional.ofNullable(destinationUrl);
            return this;
        }

        /**
         * Destination URL for the shortcut.
         */
        public Builder destinationUrl(Optional<String> destinationUrl) {
            Utils.checkNotNull(destinationUrl, "destinationUrl");
            this.destinationUrl = destinationUrl;
            return this;
        }

        /**
         * Glean Document ID for the URL, if known.
         */
        public Builder destinationDocumentId(String destinationDocumentId) {
            Utils.checkNotNull(destinationDocumentId, "destinationDocumentId");
            this.destinationDocumentId = Optional.ofNullable(destinationDocumentId);
            return this;
        }

        /**
         * Glean Document ID for the URL, if known.
         */
        public Builder destinationDocumentId(Optional<String> destinationDocumentId) {
            Utils.checkNotNull(destinationDocumentId, "destinationDocumentId");
            this.destinationDocumentId = destinationDocumentId;
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
         * Whether this shortcut is unlisted or not. Unlisted shortcuts are visible to author + admins only.
         */
        public Builder unlisted(boolean unlisted) {
            Utils.checkNotNull(unlisted, "unlisted");
            this.unlisted = Optional.ofNullable(unlisted);
            return this;
        }

        /**
         * Whether this shortcut is unlisted or not. Unlisted shortcuts are visible to author + admins only.
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

        /**
         * A list of user roles added for the Shortcut.
         */
        public Builder addedRoles(List<UserRoleSpecification> addedRoles) {
            Utils.checkNotNull(addedRoles, "addedRoles");
            this.addedRoles = Optional.ofNullable(addedRoles);
            return this;
        }

        /**
         * A list of user roles added for the Shortcut.
         */
        public Builder addedRoles(Optional<? extends List<UserRoleSpecification>> addedRoles) {
            Utils.checkNotNull(addedRoles, "addedRoles");
            this.addedRoles = addedRoles;
            return this;
        }

        /**
         * A list of user roles removed for the Shortcut.
         */
        public Builder removedRoles(List<UserRoleSpecification> removedRoles) {
            Utils.checkNotNull(removedRoles, "removedRoles");
            this.removedRoles = Optional.ofNullable(removedRoles);
            return this;
        }

        /**
         * A list of user roles removed for the Shortcut.
         */
        public Builder removedRoles(Optional<? extends List<UserRoleSpecification>> removedRoles) {
            Utils.checkNotNull(removedRoles, "removedRoles");
            this.removedRoles = removedRoles;
            return this;
        }
        
        public ShortcutMutableProperties build() {
            return new ShortcutMutableProperties(
                inputAlias,
                destinationUrl,
                destinationDocumentId,
                description,
                unlisted,
                urlTemplate,
                addedRoles,
                removedRoles);
        }
    }
}
