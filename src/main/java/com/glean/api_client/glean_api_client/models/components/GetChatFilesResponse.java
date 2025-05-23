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
import java.lang.SuppressWarnings;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class GetChatFilesResponse {

    /**
     * A map of file IDs to ChatFile structs.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("files")
    private Optional<? extends Map<String, ChatFile>> files;

    @JsonCreator
    public GetChatFilesResponse(
            @JsonProperty("files") Optional<? extends Map<String, ChatFile>> files) {
        Utils.checkNotNull(files, "files");
        this.files = files;
    }
    
    public GetChatFilesResponse() {
        this(Optional.empty());
    }

    /**
     * A map of file IDs to ChatFile structs.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Map<String, ChatFile>> files() {
        return (Optional<Map<String, ChatFile>>) files;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * A map of file IDs to ChatFile structs.
     */
    public GetChatFilesResponse withFiles(Map<String, ChatFile> files) {
        Utils.checkNotNull(files, "files");
        this.files = Optional.ofNullable(files);
        return this;
    }

    /**
     * A map of file IDs to ChatFile structs.
     */
    public GetChatFilesResponse withFiles(Optional<? extends Map<String, ChatFile>> files) {
        Utils.checkNotNull(files, "files");
        this.files = files;
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
        GetChatFilesResponse other = (GetChatFilesResponse) o;
        return 
            Objects.deepEquals(this.files, other.files);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            files);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetChatFilesResponse.class,
                "files", files);
    }
    
    public final static class Builder {
 
        private Optional<? extends Map<String, ChatFile>> files = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * A map of file IDs to ChatFile structs.
         */
        public Builder files(Map<String, ChatFile> files) {
            Utils.checkNotNull(files, "files");
            this.files = Optional.ofNullable(files);
            return this;
        }

        /**
         * A map of file IDs to ChatFile structs.
         */
        public Builder files(Optional<? extends Map<String, ChatFile>> files) {
            Utils.checkNotNull(files, "files");
            this.files = files;
            return this;
        }
        
        public GetChatFilesResponse build() {
            return new GetChatFilesResponse(
                files);
        }
    }
}
