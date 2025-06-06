/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glean.api_client.glean_api_client.models.components.GetDocumentVisibilityOverridesResponse;
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

public class GetdocvisibilityResponse implements Response {

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
     * The visibility status of documents
     */
    private Optional<? extends GetDocumentVisibilityOverridesResponse> getDocumentVisibilityOverridesResponse;

    @JsonCreator
    public GetdocvisibilityResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends GetDocumentVisibilityOverridesResponse> getDocumentVisibilityOverridesResponse) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(getDocumentVisibilityOverridesResponse, "getDocumentVisibilityOverridesResponse");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.getDocumentVisibilityOverridesResponse = getDocumentVisibilityOverridesResponse;
    }
    
    public GetdocvisibilityResponse(
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
     * The visibility status of documents
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetDocumentVisibilityOverridesResponse> getDocumentVisibilityOverridesResponse() {
        return (Optional<GetDocumentVisibilityOverridesResponse>) getDocumentVisibilityOverridesResponse;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * HTTP response content type for this operation
     */
    public GetdocvisibilityResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public GetdocvisibilityResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public GetdocvisibilityResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * The visibility status of documents
     */
    public GetdocvisibilityResponse withGetDocumentVisibilityOverridesResponse(GetDocumentVisibilityOverridesResponse getDocumentVisibilityOverridesResponse) {
        Utils.checkNotNull(getDocumentVisibilityOverridesResponse, "getDocumentVisibilityOverridesResponse");
        this.getDocumentVisibilityOverridesResponse = Optional.ofNullable(getDocumentVisibilityOverridesResponse);
        return this;
    }

    /**
     * The visibility status of documents
     */
    public GetdocvisibilityResponse withGetDocumentVisibilityOverridesResponse(Optional<? extends GetDocumentVisibilityOverridesResponse> getDocumentVisibilityOverridesResponse) {
        Utils.checkNotNull(getDocumentVisibilityOverridesResponse, "getDocumentVisibilityOverridesResponse");
        this.getDocumentVisibilityOverridesResponse = getDocumentVisibilityOverridesResponse;
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
        GetdocvisibilityResponse other = (GetdocvisibilityResponse) o;
        return 
            Objects.deepEquals(this.contentType, other.contentType) &&
            Objects.deepEquals(this.statusCode, other.statusCode) &&
            Objects.deepEquals(this.rawResponse, other.rawResponse) &&
            Objects.deepEquals(this.getDocumentVisibilityOverridesResponse, other.getDocumentVisibilityOverridesResponse);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            contentType,
            statusCode,
            rawResponse,
            getDocumentVisibilityOverridesResponse);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetdocvisibilityResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "getDocumentVisibilityOverridesResponse", getDocumentVisibilityOverridesResponse);
    }
    
    public final static class Builder {
 
        private String contentType;
 
        private Integer statusCode;
 
        private HttpResponse<InputStream> rawResponse;
 
        private Optional<? extends GetDocumentVisibilityOverridesResponse> getDocumentVisibilityOverridesResponse = Optional.empty();
        
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
         * The visibility status of documents
         */
        public Builder getDocumentVisibilityOverridesResponse(GetDocumentVisibilityOverridesResponse getDocumentVisibilityOverridesResponse) {
            Utils.checkNotNull(getDocumentVisibilityOverridesResponse, "getDocumentVisibilityOverridesResponse");
            this.getDocumentVisibilityOverridesResponse = Optional.ofNullable(getDocumentVisibilityOverridesResponse);
            return this;
        }

        /**
         * The visibility status of documents
         */
        public Builder getDocumentVisibilityOverridesResponse(Optional<? extends GetDocumentVisibilityOverridesResponse> getDocumentVisibilityOverridesResponse) {
            Utils.checkNotNull(getDocumentVisibilityOverridesResponse, "getDocumentVisibilityOverridesResponse");
            this.getDocumentVisibilityOverridesResponse = getDocumentVisibilityOverridesResponse;
            return this;
        }
        
        public GetdocvisibilityResponse build() {
            return new GetdocvisibilityResponse(
                contentType,
                statusCode,
                rawResponse,
                getDocumentVisibilityOverridesResponse);
        }
    }
}
