/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glean.api_client.glean_api_client.utils.SpeakeasyMetadata;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public class ListchatsRequest {

    /**
     * The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=timezoneOffset")
    private Optional<Long> timezoneOffset;

    @JsonCreator
    public ListchatsRequest(
            Optional<Long> timezoneOffset) {
        Utils.checkNotNull(timezoneOffset, "timezoneOffset");
        this.timezoneOffset = timezoneOffset;
    }
    
    public ListchatsRequest() {
        this(Optional.empty());
    }

    /**
     * The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.
     */
    @JsonIgnore
    public Optional<Long> timezoneOffset() {
        return timezoneOffset;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.
     */
    public ListchatsRequest withTimezoneOffset(long timezoneOffset) {
        Utils.checkNotNull(timezoneOffset, "timezoneOffset");
        this.timezoneOffset = Optional.ofNullable(timezoneOffset);
        return this;
    }

    /**
     * The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.
     */
    public ListchatsRequest withTimezoneOffset(Optional<Long> timezoneOffset) {
        Utils.checkNotNull(timezoneOffset, "timezoneOffset");
        this.timezoneOffset = timezoneOffset;
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
        ListchatsRequest other = (ListchatsRequest) o;
        return 
            Objects.deepEquals(this.timezoneOffset, other.timezoneOffset);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            timezoneOffset);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListchatsRequest.class,
                "timezoneOffset", timezoneOffset);
    }
    
    public final static class Builder {
 
        private Optional<Long> timezoneOffset = Optional.empty();
        
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
        
        public ListchatsRequest build() {
            return new ListchatsRequest(
                timezoneOffset);
        }
    }
}
