/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glean.api_client.glean_api_client.models.components.EditCollectionItemResponse;
import com.glean.api_client.glean_api_client.utils.Response;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.io.InputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.Optional;

public class EditcollectionitemResponse implements Response {

    /**
     * HTTP response content type for this operation
     */
    private String contentType;

    /**
     * HTTP response status code for this operation
     */
    private int statusCode;

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    private HttpResponse<InputStream> rawResponse;

    /**
     * OK
     */
    private Optional<? extends EditCollectionItemResponse> editCollectionItemResponse;

    @JsonCreator
    public EditcollectionitemResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends EditCollectionItemResponse> editCollectionItemResponse) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(editCollectionItemResponse, "editCollectionItemResponse");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.editCollectionItemResponse = editCollectionItemResponse;
    }
    
    public EditcollectionitemResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse) {
        this(contentType, statusCode, rawResponse, Optional.empty());
    }

    /**
     * HTTP response content type for this operation
     */
    @JsonIgnore
    public String contentType() {
        return contentType;
    }

    /**
     * HTTP response status code for this operation
     */
    @JsonIgnore
    public int statusCode() {
        return statusCode;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    @JsonIgnore
    public HttpResponse<InputStream> rawResponse() {
        return rawResponse;
    }

    /**
     * OK
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<EditCollectionItemResponse> editCollectionItemResponse() {
        return (Optional<EditCollectionItemResponse>) editCollectionItemResponse;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * HTTP response content type for this operation
     */
    public EditcollectionitemResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public EditcollectionitemResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public EditcollectionitemResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * OK
     */
    public EditcollectionitemResponse withEditCollectionItemResponse(EditCollectionItemResponse editCollectionItemResponse) {
        Utils.checkNotNull(editCollectionItemResponse, "editCollectionItemResponse");
        this.editCollectionItemResponse = Optional.ofNullable(editCollectionItemResponse);
        return this;
    }

    /**
     * OK
     */
    public EditcollectionitemResponse withEditCollectionItemResponse(Optional<? extends EditCollectionItemResponse> editCollectionItemResponse) {
        Utils.checkNotNull(editCollectionItemResponse, "editCollectionItemResponse");
        this.editCollectionItemResponse = editCollectionItemResponse;
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
        EditcollectionitemResponse other = (EditcollectionitemResponse) o;
        return 
            Objects.deepEquals(this.contentType, other.contentType) &&
            Objects.deepEquals(this.statusCode, other.statusCode) &&
            Objects.deepEquals(this.rawResponse, other.rawResponse) &&
            Objects.deepEquals(this.editCollectionItemResponse, other.editCollectionItemResponse);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            contentType,
            statusCode,
            rawResponse,
            editCollectionItemResponse);
    }
    
    @Override
    public String toString() {
        return Utils.toString(EditcollectionitemResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "editCollectionItemResponse", editCollectionItemResponse);
    }
    
    public final static class Builder {
 
        private String contentType;
 
        private Integer statusCode;
 
        private HttpResponse<InputStream> rawResponse;
 
        private Optional<? extends EditCollectionItemResponse> editCollectionItemResponse = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * HTTP response content type for this operation
         */
        public Builder contentType(String contentType) {
            Utils.checkNotNull(contentType, "contentType");
            this.contentType = contentType;
            return this;
        }

        /**
         * HTTP response status code for this operation
         */
        public Builder statusCode(int statusCode) {
            Utils.checkNotNull(statusCode, "statusCode");
            this.statusCode = statusCode;
            return this;
        }

        /**
         * Raw HTTP response; suitable for custom response parsing
         */
        public Builder rawResponse(HttpResponse<InputStream> rawResponse) {
            Utils.checkNotNull(rawResponse, "rawResponse");
            this.rawResponse = rawResponse;
            return this;
        }

        /**
         * OK
         */
        public Builder editCollectionItemResponse(EditCollectionItemResponse editCollectionItemResponse) {
            Utils.checkNotNull(editCollectionItemResponse, "editCollectionItemResponse");
            this.editCollectionItemResponse = Optional.ofNullable(editCollectionItemResponse);
            return this;
        }

        /**
         * OK
         */
        public Builder editCollectionItemResponse(Optional<? extends EditCollectionItemResponse> editCollectionItemResponse) {
            Utils.checkNotNull(editCollectionItemResponse, "editCollectionItemResponse");
            this.editCollectionItemResponse = editCollectionItemResponse;
            return this;
        }
        
        public EditcollectionitemResponse build() {
            return new EditcollectionitemResponse(
                contentType,
                statusCode,
                rawResponse,
                editCollectionItemResponse);
        }
    }
}
