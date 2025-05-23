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

public class AppResult {

    /**
     * The app or other repository type this represents
     */
    @JsonProperty("datasource")
    private String datasource;

    /**
     * The datasource-specific type of the document (e.g. for Jira issues, this is the issue type such as Bug or Feature Request).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("docType")
    private Optional<String> docType;

    /**
     * Mimetype is used to differentiate between sub applications from a datasource (e.g. Sheets, Docs from Gdrive)
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("mimeType")
    private Optional<String> mimeType;

    /**
     * If there is available icon URL.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("iconUrl")
    private Optional<String> iconUrl;

    @JsonCreator
    public AppResult(
            @JsonProperty("datasource") String datasource,
            @JsonProperty("docType") Optional<String> docType,
            @JsonProperty("mimeType") Optional<String> mimeType,
            @JsonProperty("iconUrl") Optional<String> iconUrl) {
        Utils.checkNotNull(datasource, "datasource");
        Utils.checkNotNull(docType, "docType");
        Utils.checkNotNull(mimeType, "mimeType");
        Utils.checkNotNull(iconUrl, "iconUrl");
        this.datasource = datasource;
        this.docType = docType;
        this.mimeType = mimeType;
        this.iconUrl = iconUrl;
    }
    
    public AppResult(
            String datasource) {
        this(datasource, Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * The app or other repository type this represents
     */
    @JsonIgnore
    public String datasource() {
        return datasource;
    }

    /**
     * The datasource-specific type of the document (e.g. for Jira issues, this is the issue type such as Bug or Feature Request).
     */
    @JsonIgnore
    public Optional<String> docType() {
        return docType;
    }

    /**
     * Mimetype is used to differentiate between sub applications from a datasource (e.g. Sheets, Docs from Gdrive)
     */
    @JsonIgnore
    public Optional<String> mimeType() {
        return mimeType;
    }

    /**
     * If there is available icon URL.
     */
    @JsonIgnore
    public Optional<String> iconUrl() {
        return iconUrl;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The app or other repository type this represents
     */
    public AppResult withDatasource(String datasource) {
        Utils.checkNotNull(datasource, "datasource");
        this.datasource = datasource;
        return this;
    }

    /**
     * The datasource-specific type of the document (e.g. for Jira issues, this is the issue type such as Bug or Feature Request).
     */
    public AppResult withDocType(String docType) {
        Utils.checkNotNull(docType, "docType");
        this.docType = Optional.ofNullable(docType);
        return this;
    }

    /**
     * The datasource-specific type of the document (e.g. for Jira issues, this is the issue type such as Bug or Feature Request).
     */
    public AppResult withDocType(Optional<String> docType) {
        Utils.checkNotNull(docType, "docType");
        this.docType = docType;
        return this;
    }

    /**
     * Mimetype is used to differentiate between sub applications from a datasource (e.g. Sheets, Docs from Gdrive)
     */
    public AppResult withMimeType(String mimeType) {
        Utils.checkNotNull(mimeType, "mimeType");
        this.mimeType = Optional.ofNullable(mimeType);
        return this;
    }

    /**
     * Mimetype is used to differentiate between sub applications from a datasource (e.g. Sheets, Docs from Gdrive)
     */
    public AppResult withMimeType(Optional<String> mimeType) {
        Utils.checkNotNull(mimeType, "mimeType");
        this.mimeType = mimeType;
        return this;
    }

    /**
     * If there is available icon URL.
     */
    public AppResult withIconUrl(String iconUrl) {
        Utils.checkNotNull(iconUrl, "iconUrl");
        this.iconUrl = Optional.ofNullable(iconUrl);
        return this;
    }

    /**
     * If there is available icon URL.
     */
    public AppResult withIconUrl(Optional<String> iconUrl) {
        Utils.checkNotNull(iconUrl, "iconUrl");
        this.iconUrl = iconUrl;
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
        AppResult other = (AppResult) o;
        return 
            Objects.deepEquals(this.datasource, other.datasource) &&
            Objects.deepEquals(this.docType, other.docType) &&
            Objects.deepEquals(this.mimeType, other.mimeType) &&
            Objects.deepEquals(this.iconUrl, other.iconUrl);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            datasource,
            docType,
            mimeType,
            iconUrl);
    }
    
    @Override
    public String toString() {
        return Utils.toString(AppResult.class,
                "datasource", datasource,
                "docType", docType,
                "mimeType", mimeType,
                "iconUrl", iconUrl);
    }
    
    public final static class Builder {
 
        private String datasource;
 
        private Optional<String> docType = Optional.empty();
 
        private Optional<String> mimeType = Optional.empty();
 
        private Optional<String> iconUrl = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The app or other repository type this represents
         */
        public Builder datasource(String datasource) {
            Utils.checkNotNull(datasource, "datasource");
            this.datasource = datasource;
            return this;
        }

        /**
         * The datasource-specific type of the document (e.g. for Jira issues, this is the issue type such as Bug or Feature Request).
         */
        public Builder docType(String docType) {
            Utils.checkNotNull(docType, "docType");
            this.docType = Optional.ofNullable(docType);
            return this;
        }

        /**
         * The datasource-specific type of the document (e.g. for Jira issues, this is the issue type such as Bug or Feature Request).
         */
        public Builder docType(Optional<String> docType) {
            Utils.checkNotNull(docType, "docType");
            this.docType = docType;
            return this;
        }

        /**
         * Mimetype is used to differentiate between sub applications from a datasource (e.g. Sheets, Docs from Gdrive)
         */
        public Builder mimeType(String mimeType) {
            Utils.checkNotNull(mimeType, "mimeType");
            this.mimeType = Optional.ofNullable(mimeType);
            return this;
        }

        /**
         * Mimetype is used to differentiate between sub applications from a datasource (e.g. Sheets, Docs from Gdrive)
         */
        public Builder mimeType(Optional<String> mimeType) {
            Utils.checkNotNull(mimeType, "mimeType");
            this.mimeType = mimeType;
            return this;
        }

        /**
         * If there is available icon URL.
         */
        public Builder iconUrl(String iconUrl) {
            Utils.checkNotNull(iconUrl, "iconUrl");
            this.iconUrl = Optional.ofNullable(iconUrl);
            return this;
        }

        /**
         * If there is available icon URL.
         */
        public Builder iconUrl(Optional<String> iconUrl) {
            Utils.checkNotNull(iconUrl, "iconUrl");
            this.iconUrl = iconUrl;
            return this;
        }
        
        public AppResult build() {
            return new AppResult(
                datasource,
                docType,
                mimeType,
                iconUrl);
        }
    }
}
