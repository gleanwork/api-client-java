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
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public class CategoryToResultSize {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("resultSize")
    private Optional<Long> resultSize;

    @JsonCreator
    public CategoryToResultSize(
            @JsonProperty("resultSize") Optional<Long> resultSize) {
        Utils.checkNotNull(resultSize, "resultSize");
        this.resultSize = resultSize;
    }
    
    public CategoryToResultSize() {
        this(Optional.empty());
    }

    @JsonIgnore
    public Optional<Long> resultSize() {
        return resultSize;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    public CategoryToResultSize withResultSize(long resultSize) {
        Utils.checkNotNull(resultSize, "resultSize");
        this.resultSize = Optional.ofNullable(resultSize);
        return this;
    }

    public CategoryToResultSize withResultSize(Optional<Long> resultSize) {
        Utils.checkNotNull(resultSize, "resultSize");
        this.resultSize = resultSize;
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
        CategoryToResultSize other = (CategoryToResultSize) o;
        return 
            Objects.deepEquals(this.resultSize, other.resultSize);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            resultSize);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CategoryToResultSize.class,
                "resultSize", resultSize);
    }
    
    public final static class Builder {
 
        private Optional<Long> resultSize = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder resultSize(long resultSize) {
            Utils.checkNotNull(resultSize, "resultSize");
            this.resultSize = Optional.ofNullable(resultSize);
            return this;
        }

        public Builder resultSize(Optional<Long> resultSize) {
            Utils.checkNotNull(resultSize, "resultSize");
            this.resultSize = resultSize;
            return this;
        }
        
        public CategoryToResultSize build() {
            return new CategoryToResultSize(
                resultSize);
        }
    }
}
