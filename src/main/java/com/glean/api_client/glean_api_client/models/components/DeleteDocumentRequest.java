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
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * DeleteDocumentRequest
 * 
 * <p>Describes the request body of the /deletedocument API call
 */
public class DeleteDocumentRequest {

    /**
     * Version number for document for optimistic concurrency control. If absent or 0 then no version checks are done.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("version")
    private Optional<Long> version;

    /**
     * datasource of the document
     */
    @JsonProperty("datasource")
    private String datasource;

    /**
     * object type of the document
     */
    @JsonProperty("objectType")
    private String objectType;

    /**
     * The id of the document
     */
    @JsonProperty("id")
    private String id;

    @JsonCreator
    public DeleteDocumentRequest(
            @JsonProperty("version") Optional<Long> version,
            @JsonProperty("datasource") String datasource,
            @JsonProperty("objectType") String objectType,
            @JsonProperty("id") String id) {
        Utils.checkNotNull(version, "version");
        Utils.checkNotNull(datasource, "datasource");
        Utils.checkNotNull(objectType, "objectType");
        Utils.checkNotNull(id, "id");
        this.version = version;
        this.datasource = datasource;
        this.objectType = objectType;
        this.id = id;
    }
    
    public DeleteDocumentRequest(
            String datasource,
            String objectType,
            String id) {
        this(Optional.empty(), datasource, objectType, id);
    }

    /**
     * Version number for document for optimistic concurrency control. If absent or 0 then no version checks are done.
     */
    @JsonIgnore
    public Optional<Long> version() {
        return version;
    }

    /**
     * datasource of the document
     */
    @JsonIgnore
    public String datasource() {
        return datasource;
    }

    /**
     * object type of the document
     */
    @JsonIgnore
    public String objectType() {
        return objectType;
    }

    /**
     * The id of the document
     */
    @JsonIgnore
    public String id() {
        return id;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Version number for document for optimistic concurrency control. If absent or 0 then no version checks are done.
     */
    public DeleteDocumentRequest withVersion(long version) {
        Utils.checkNotNull(version, "version");
        this.version = Optional.ofNullable(version);
        return this;
    }

    /**
     * Version number for document for optimistic concurrency control. If absent or 0 then no version checks are done.
     */
    public DeleteDocumentRequest withVersion(Optional<Long> version) {
        Utils.checkNotNull(version, "version");
        this.version = version;
        return this;
    }

    /**
     * datasource of the document
     */
    public DeleteDocumentRequest withDatasource(String datasource) {
        Utils.checkNotNull(datasource, "datasource");
        this.datasource = datasource;
        return this;
    }

    /**
     * object type of the document
     */
    public DeleteDocumentRequest withObjectType(String objectType) {
        Utils.checkNotNull(objectType, "objectType");
        this.objectType = objectType;
        return this;
    }

    /**
     * The id of the document
     */
    public DeleteDocumentRequest withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
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
        DeleteDocumentRequest other = (DeleteDocumentRequest) o;
        return 
            Objects.deepEquals(this.version, other.version) &&
            Objects.deepEquals(this.datasource, other.datasource) &&
            Objects.deepEquals(this.objectType, other.objectType) &&
            Objects.deepEquals(this.id, other.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            version,
            datasource,
            objectType,
            id);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DeleteDocumentRequest.class,
                "version", version,
                "datasource", datasource,
                "objectType", objectType,
                "id", id);
    }
    
    public final static class Builder {
 
        private Optional<Long> version = Optional.empty();
 
        private String datasource;
 
        private String objectType;
 
        private String id;
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Version number for document for optimistic concurrency control. If absent or 0 then no version checks are done.
         */
        public Builder version(long version) {
            Utils.checkNotNull(version, "version");
            this.version = Optional.ofNullable(version);
            return this;
        }

        /**
         * Version number for document for optimistic concurrency control. If absent or 0 then no version checks are done.
         */
        public Builder version(Optional<Long> version) {
            Utils.checkNotNull(version, "version");
            this.version = version;
            return this;
        }

        /**
         * datasource of the document
         */
        public Builder datasource(String datasource) {
            Utils.checkNotNull(datasource, "datasource");
            this.datasource = datasource;
            return this;
        }

        /**
         * object type of the document
         */
        public Builder objectType(String objectType) {
            Utils.checkNotNull(objectType, "objectType");
            this.objectType = objectType;
            return this;
        }

        /**
         * The id of the document
         */
        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }
        
        public DeleteDocumentRequest build() {
            return new DeleteDocumentRequest(
                version,
                datasource,
                objectType,
                id);
        }
    }
}
