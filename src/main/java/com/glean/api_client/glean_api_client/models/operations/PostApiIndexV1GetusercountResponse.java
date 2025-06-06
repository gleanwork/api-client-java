/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glean.api_client.glean_api_client.models.components.GetUserCountResponse;
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

public class PostApiIndexV1GetusercountResponse implements Response {

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
    private Optional<? extends GetUserCountResponse> getUserCountResponse;

    @JsonCreator
    public PostApiIndexV1GetusercountResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends GetUserCountResponse> getUserCountResponse) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(getUserCountResponse, "getUserCountResponse");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.getUserCountResponse = getUserCountResponse;
    }
    
    public PostApiIndexV1GetusercountResponse(
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
    public Optional<GetUserCountResponse> getUserCountResponse() {
        return (Optional<GetUserCountResponse>) getUserCountResponse;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * HTTP response content type for this operation
     */
    public PostApiIndexV1GetusercountResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public PostApiIndexV1GetusercountResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public PostApiIndexV1GetusercountResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * OK
     */
    public PostApiIndexV1GetusercountResponse withGetUserCountResponse(GetUserCountResponse getUserCountResponse) {
        Utils.checkNotNull(getUserCountResponse, "getUserCountResponse");
        this.getUserCountResponse = Optional.ofNullable(getUserCountResponse);
        return this;
    }

    /**
     * OK
     */
    public PostApiIndexV1GetusercountResponse withGetUserCountResponse(Optional<? extends GetUserCountResponse> getUserCountResponse) {
        Utils.checkNotNull(getUserCountResponse, "getUserCountResponse");
        this.getUserCountResponse = getUserCountResponse;
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
        PostApiIndexV1GetusercountResponse other = (PostApiIndexV1GetusercountResponse) o;
        return 
            Objects.deepEquals(this.contentType, other.contentType) &&
            Objects.deepEquals(this.statusCode, other.statusCode) &&
            Objects.deepEquals(this.rawResponse, other.rawResponse) &&
            Objects.deepEquals(this.getUserCountResponse, other.getUserCountResponse);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            contentType,
            statusCode,
            rawResponse,
            getUserCountResponse);
    }
    
    @Override
    public String toString() {
        return Utils.toString(PostApiIndexV1GetusercountResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "getUserCountResponse", getUserCountResponse);
    }
    
    public final static class Builder {
 
        private String contentType;
 
        private Integer statusCode;
 
        private HttpResponse<InputStream> rawResponse;
 
        private Optional<? extends GetUserCountResponse> getUserCountResponse = Optional.empty();
        
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
        public Builder getUserCountResponse(GetUserCountResponse getUserCountResponse) {
            Utils.checkNotNull(getUserCountResponse, "getUserCountResponse");
            this.getUserCountResponse = Optional.ofNullable(getUserCountResponse);
            return this;
        }

        /**
         * OK
         */
        public Builder getUserCountResponse(Optional<? extends GetUserCountResponse> getUserCountResponse) {
            Utils.checkNotNull(getUserCountResponse, "getUserCountResponse");
            this.getUserCountResponse = getUserCountResponse;
            return this;
        }
        
        public PostApiIndexV1GetusercountResponse build() {
            return new PostApiIndexV1GetusercountResponse(
                contentType,
                statusCode,
                rawResponse,
                getUserCountResponse);
        }
    }
}
