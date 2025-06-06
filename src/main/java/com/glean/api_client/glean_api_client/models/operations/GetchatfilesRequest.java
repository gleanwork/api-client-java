/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glean.api_client.glean_api_client.models.components.GetChatFilesRequest;
import com.glean.api_client.glean_api_client.utils.SpeakeasyMetadata;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public class GetchatfilesRequest {

    /**
     * The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=timezoneOffset")
    private Optional<Long> timezoneOffset;

    @SpeakeasyMetadata("request:mediaType=application/json")
    private GetChatFilesRequest getChatFilesRequest;

    @JsonCreator
    public GetchatfilesRequest(
            Optional<Long> timezoneOffset,
            GetChatFilesRequest getChatFilesRequest) {
        Utils.checkNotNull(timezoneOffset, "timezoneOffset");
        Utils.checkNotNull(getChatFilesRequest, "getChatFilesRequest");
        this.timezoneOffset = timezoneOffset;
        this.getChatFilesRequest = getChatFilesRequest;
    }
    
    public GetchatfilesRequest(
            GetChatFilesRequest getChatFilesRequest) {
        this(Optional.empty(), getChatFilesRequest);
    }

    /**
     * The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.
     */
    @JsonIgnore
    public Optional<Long> timezoneOffset() {
        return timezoneOffset;
    }

    @JsonIgnore
    public GetChatFilesRequest getChatFilesRequest() {
        return getChatFilesRequest;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.
     */
    public GetchatfilesRequest withTimezoneOffset(long timezoneOffset) {
        Utils.checkNotNull(timezoneOffset, "timezoneOffset");
        this.timezoneOffset = Optional.ofNullable(timezoneOffset);
        return this;
    }

    /**
     * The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.
     */
    public GetchatfilesRequest withTimezoneOffset(Optional<Long> timezoneOffset) {
        Utils.checkNotNull(timezoneOffset, "timezoneOffset");
        this.timezoneOffset = timezoneOffset;
        return this;
    }

    public GetchatfilesRequest withGetChatFilesRequest(GetChatFilesRequest getChatFilesRequest) {
        Utils.checkNotNull(getChatFilesRequest, "getChatFilesRequest");
        this.getChatFilesRequest = getChatFilesRequest;
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
        GetchatfilesRequest other = (GetchatfilesRequest) o;
        return 
            Objects.deepEquals(this.timezoneOffset, other.timezoneOffset) &&
            Objects.deepEquals(this.getChatFilesRequest, other.getChatFilesRequest);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            timezoneOffset,
            getChatFilesRequest);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetchatfilesRequest.class,
                "timezoneOffset", timezoneOffset,
                "getChatFilesRequest", getChatFilesRequest);
    }
    
    public final static class Builder {
 
        private Optional<Long> timezoneOffset = Optional.empty();
 
        private GetChatFilesRequest getChatFilesRequest;
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.
         */
        public Builder timezoneOffset(long timezoneOffset) {
            Utils.checkNotNull(timezoneOffset, "timezoneOffset");
            this.timezoneOffset = Optional.ofNullable(timezoneOffset);
            return this;
        }

        /**
         * The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.
         */
        public Builder timezoneOffset(Optional<Long> timezoneOffset) {
            Utils.checkNotNull(timezoneOffset, "timezoneOffset");
            this.timezoneOffset = timezoneOffset;
            return this;
        }

        public Builder getChatFilesRequest(GetChatFilesRequest getChatFilesRequest) {
            Utils.checkNotNull(getChatFilesRequest, "getChatFilesRequest");
            this.getChatFilesRequest = getChatFilesRequest;
            return this;
        }
        
        public GetchatfilesRequest build() {
            return new GetchatfilesRequest(
                timezoneOffset,
                getChatFilesRequest);
        }
    }
}
