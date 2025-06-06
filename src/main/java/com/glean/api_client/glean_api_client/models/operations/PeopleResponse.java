/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

public class PeopleResponse implements Response {

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
    private Optional<? extends com.glean.api_client.glean_api_client.models.components.PeopleResponse> peopleResponse;

    @JsonCreator
    public PeopleResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends com.glean.api_client.glean_api_client.models.components.PeopleResponse> peopleResponse) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(peopleResponse, "peopleResponse");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.peopleResponse = peopleResponse;
    }
    
    public PeopleResponse(
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
    public Optional<com.glean.api_client.glean_api_client.models.components.PeopleResponse> peopleResponse() {
        return (Optional<com.glean.api_client.glean_api_client.models.components.PeopleResponse>) peopleResponse;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * HTTP response content type for this operation
     */
    public PeopleResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public PeopleResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public PeopleResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * OK
     */
    public PeopleResponse withPeopleResponse(com.glean.api_client.glean_api_client.models.components.PeopleResponse peopleResponse) {
        Utils.checkNotNull(peopleResponse, "peopleResponse");
        this.peopleResponse = Optional.ofNullable(peopleResponse);
        return this;
    }

    /**
     * OK
     */
    public PeopleResponse withPeopleResponse(Optional<? extends com.glean.api_client.glean_api_client.models.components.PeopleResponse> peopleResponse) {
        Utils.checkNotNull(peopleResponse, "peopleResponse");
        this.peopleResponse = peopleResponse;
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
        PeopleResponse other = (PeopleResponse) o;
        return 
            Objects.deepEquals(this.contentType, other.contentType) &&
            Objects.deepEquals(this.statusCode, other.statusCode) &&
            Objects.deepEquals(this.rawResponse, other.rawResponse) &&
            Objects.deepEquals(this.peopleResponse, other.peopleResponse);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            contentType,
            statusCode,
            rawResponse,
            peopleResponse);
    }
    
    @Override
    public String toString() {
        return Utils.toString(PeopleResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "peopleResponse", peopleResponse);
    }
    
    public final static class Builder {
 
        private String contentType;
 
        private Integer statusCode;
 
        private HttpResponse<InputStream> rawResponse;
 
        private Optional<? extends com.glean.api_client.glean_api_client.models.components.PeopleResponse> peopleResponse = Optional.empty();
        
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
        public Builder peopleResponse(com.glean.api_client.glean_api_client.models.components.PeopleResponse peopleResponse) {
            Utils.checkNotNull(peopleResponse, "peopleResponse");
            this.peopleResponse = Optional.ofNullable(peopleResponse);
            return this;
        }

        /**
         * OK
         */
        public Builder peopleResponse(Optional<? extends com.glean.api_client.glean_api_client.models.components.PeopleResponse> peopleResponse) {
            Utils.checkNotNull(peopleResponse, "peopleResponse");
            this.peopleResponse = peopleResponse;
            return this;
        }
        
        public PeopleResponse build() {
            return new PeopleResponse(
                contentType,
                statusCode,
                rawResponse,
                peopleResponse);
        }
    }
}
