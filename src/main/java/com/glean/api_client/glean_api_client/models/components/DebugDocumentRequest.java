/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * DebugDocumentRequest
 * 
 * <p>Describes the request body of the /debug/{datasource}/document API call.
 */
public class DebugDocumentRequest {

    /**
     * Object type of the document to get the status for.
     */
    @JsonProperty("objectType")
    private String objectType;

    /**
     * Glean Document ID within the datasource to get the status for.
     */
    @JsonProperty("docId")
    private String docId;

    @JsonCreator
    public DebugDocumentRequest(
            @JsonProperty("objectType") String objectType,
            @JsonProperty("docId") String docId) {
        Utils.checkNotNull(objectType, "objectType");
        Utils.checkNotNull(docId, "docId");
        this.objectType = objectType;
        this.docId = docId;
    }

    /**
     * Object type of the document to get the status for.
     */
    @JsonIgnore
    public String objectType() {
        return objectType;
    }

    /**
     * Glean Document ID within the datasource to get the status for.
     */
    @JsonIgnore
    public String docId() {
        return docId;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Object type of the document to get the status for.
     */
    public DebugDocumentRequest withObjectType(String objectType) {
        Utils.checkNotNull(objectType, "objectType");
        this.objectType = objectType;
        return this;
    }

    /**
     * Glean Document ID within the datasource to get the status for.
     */
    public DebugDocumentRequest withDocId(String docId) {
        Utils.checkNotNull(docId, "docId");
        this.docId = docId;
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
        DebugDocumentRequest other = (DebugDocumentRequest) o;
        return 
            Objects.deepEquals(this.objectType, other.objectType) &&
            Objects.deepEquals(this.docId, other.docId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            objectType,
            docId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DebugDocumentRequest.class,
                "objectType", objectType,
                "docId", docId);
    }
    
    public final static class Builder {
 
        private String objectType;
 
        private String docId;
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Object type of the document to get the status for.
         */
        public Builder objectType(String objectType) {
            Utils.checkNotNull(objectType, "objectType");
            this.objectType = objectType;
            return this;
        }

        /**
         * Glean Document ID within the datasource to get the status for.
         */
        public Builder docId(String docId) {
            Utils.checkNotNull(docId, "docId");
            this.docId = docId;
            return this;
        }
        
        public DebugDocumentRequest build() {
            return new DebugDocumentRequest(
                objectType,
                docId);
        }
    }
}
