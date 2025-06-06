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
import java.util.Objects;
import java.util.Optional;

public class DocumentSpec1 {

    /**
     * The URL of the document.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("url")
    private Optional<String> url;

    @JsonCreator
    public DocumentSpec1(
            @JsonProperty("url") Optional<String> url) {
        Utils.checkNotNull(url, "url");
        this.url = url;
    }
    
    public DocumentSpec1() {
        this(Optional.empty());
    }

    /**
     * The URL of the document.
     */
    @JsonIgnore
    public Optional<String> url() {
        return url;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The URL of the document.
     */
    public DocumentSpec1 withUrl(String url) {
        Utils.checkNotNull(url, "url");
        this.url = Optional.ofNullable(url);
        return this;
    }

    /**
     * The URL of the document.
     */
    public DocumentSpec1 withUrl(Optional<String> url) {
        Utils.checkNotNull(url, "url");
        this.url = url;
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
        DocumentSpec1 other = (DocumentSpec1) o;
        return 
            Objects.deepEquals(this.url, other.url);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            url);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DocumentSpec1.class,
                "url", url);
    }
    
    public final static class Builder {
 
        private Optional<String> url = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The URL of the document.
         */
        public Builder url(String url) {
            Utils.checkNotNull(url, "url");
            this.url = Optional.ofNullable(url);
            return this;
        }

        /**
         * The URL of the document.
         */
        public Builder url(Optional<String> url) {
            Utils.checkNotNull(url, "url");
            this.url = url;
            return this;
        }
        
        public DocumentSpec1 build() {
            return new DocumentSpec1(
                url);
        }
    }
}
