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
 * CheckDocumentAccessRequest
 * 
 * <p>Describes the request body of the /checkdocumentaccess API call
 */
public class CheckDocumentAccessRequest {

    /**
     * Datasource of document to check access for.
     */
    @JsonProperty("datasource")
    private String datasource;

    /**
     * Object type of document to check access for.
     */
    @JsonProperty("objectType")
    private String objectType;

    /**
     * Glean Document ID to check access for.
     */
    @JsonProperty("docId")
    private String docId;

    /**
     * Email of user to check access for.
     */
    @JsonProperty("userEmail")
    private String userEmail;

    @JsonCreator
    public CheckDocumentAccessRequest(
            @JsonProperty("datasource") String datasource,
            @JsonProperty("objectType") String objectType,
            @JsonProperty("docId") String docId,
            @JsonProperty("userEmail") String userEmail) {
        Utils.checkNotNull(datasource, "datasource");
        Utils.checkNotNull(objectType, "objectType");
        Utils.checkNotNull(docId, "docId");
        Utils.checkNotNull(userEmail, "userEmail");
        this.datasource = datasource;
        this.objectType = objectType;
        this.docId = docId;
        this.userEmail = userEmail;
    }

    /**
     * Datasource of document to check access for.
     */
    @JsonIgnore
    public String datasource() {
        return datasource;
    }

    /**
     * Object type of document to check access for.
     */
    @JsonIgnore
    public String objectType() {
        return objectType;
    }

    /**
     * Glean Document ID to check access for.
     */
    @JsonIgnore
    public String docId() {
        return docId;
    }

    /**
     * Email of user to check access for.
     */
    @JsonIgnore
    public String userEmail() {
        return userEmail;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Datasource of document to check access for.
     */
    public CheckDocumentAccessRequest withDatasource(String datasource) {
        Utils.checkNotNull(datasource, "datasource");
        this.datasource = datasource;
        return this;
    }

    /**
     * Object type of document to check access for.
     */
    public CheckDocumentAccessRequest withObjectType(String objectType) {
        Utils.checkNotNull(objectType, "objectType");
        this.objectType = objectType;
        return this;
    }

    /**
     * Glean Document ID to check access for.
     */
    public CheckDocumentAccessRequest withDocId(String docId) {
        Utils.checkNotNull(docId, "docId");
        this.docId = docId;
        return this;
    }

    /**
     * Email of user to check access for.
     */
    public CheckDocumentAccessRequest withUserEmail(String userEmail) {
        Utils.checkNotNull(userEmail, "userEmail");
        this.userEmail = userEmail;
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
        CheckDocumentAccessRequest other = (CheckDocumentAccessRequest) o;
        return 
            Objects.deepEquals(this.datasource, other.datasource) &&
            Objects.deepEquals(this.objectType, other.objectType) &&
            Objects.deepEquals(this.docId, other.docId) &&
            Objects.deepEquals(this.userEmail, other.userEmail);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            datasource,
            objectType,
            docId,
            userEmail);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CheckDocumentAccessRequest.class,
                "datasource", datasource,
                "objectType", objectType,
                "docId", docId,
                "userEmail", userEmail);
    }
    
    public final static class Builder {
 
        private String datasource;
 
        private String objectType;
 
        private String docId;
 
        private String userEmail;
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Datasource of document to check access for.
         */
        public Builder datasource(String datasource) {
            Utils.checkNotNull(datasource, "datasource");
            this.datasource = datasource;
            return this;
        }

        /**
         * Object type of document to check access for.
         */
        public Builder objectType(String objectType) {
            Utils.checkNotNull(objectType, "objectType");
            this.objectType = objectType;
            return this;
        }

        /**
         * Glean Document ID to check access for.
         */
        public Builder docId(String docId) {
            Utils.checkNotNull(docId, "docId");
            this.docId = docId;
            return this;
        }

        /**
         * Email of user to check access for.
         */
        public Builder userEmail(String userEmail) {
            Utils.checkNotNull(userEmail, "userEmail");
            this.userEmail = userEmail;
            return this;
        }
        
        public CheckDocumentAccessRequest build() {
            return new CheckDocumentAccessRequest(
                datasource,
                objectType,
                docId,
                userEmail);
        }
    }
}
