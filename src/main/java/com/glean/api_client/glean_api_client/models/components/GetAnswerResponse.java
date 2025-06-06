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
import java.util.Objects;
import java.util.Optional;

public class GetAnswerResponse {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("answerResult")
    private Optional<? extends AnswerResult> answerResult;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("error")
    private Optional<? extends GetAnswerError> error;

    @JsonCreator
    public GetAnswerResponse(
            @JsonProperty("answerResult") Optional<? extends AnswerResult> answerResult,
            @JsonProperty("error") Optional<? extends GetAnswerError> error) {
        Utils.checkNotNull(answerResult, "answerResult");
        Utils.checkNotNull(error, "error");
        this.answerResult = answerResult;
        this.error = error;
    }
    
    public GetAnswerResponse() {
        this(Optional.empty(), Optional.empty());
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<AnswerResult> answerResult() {
        return (Optional<AnswerResult>) answerResult;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetAnswerError> error() {
        return (Optional<GetAnswerError>) error;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    public GetAnswerResponse withAnswerResult(AnswerResult answerResult) {
        Utils.checkNotNull(answerResult, "answerResult");
        this.answerResult = Optional.ofNullable(answerResult);
        return this;
    }

    public GetAnswerResponse withAnswerResult(Optional<? extends AnswerResult> answerResult) {
        Utils.checkNotNull(answerResult, "answerResult");
        this.answerResult = answerResult;
        return this;
    }

    public GetAnswerResponse withError(GetAnswerError error) {
        Utils.checkNotNull(error, "error");
        this.error = Optional.ofNullable(error);
        return this;
    }

    public GetAnswerResponse withError(Optional<? extends GetAnswerError> error) {
        Utils.checkNotNull(error, "error");
        this.error = error;
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
        GetAnswerResponse other = (GetAnswerResponse) o;
        return 
            Objects.deepEquals(this.answerResult, other.answerResult) &&
            Objects.deepEquals(this.error, other.error);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            answerResult,
            error);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetAnswerResponse.class,
                "answerResult", answerResult,
                "error", error);
    }
    
    public final static class Builder {
 
        private Optional<? extends AnswerResult> answerResult = Optional.empty();
 
        private Optional<? extends GetAnswerError> error = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder answerResult(AnswerResult answerResult) {
            Utils.checkNotNull(answerResult, "answerResult");
            this.answerResult = Optional.ofNullable(answerResult);
            return this;
        }

        public Builder answerResult(Optional<? extends AnswerResult> answerResult) {
            Utils.checkNotNull(answerResult, "answerResult");
            this.answerResult = answerResult;
            return this;
        }

        public Builder error(GetAnswerError error) {
            Utils.checkNotNull(error, "error");
            this.error = Optional.ofNullable(error);
            return this;
        }

        public Builder error(Optional<? extends GetAnswerError> error) {
            Utils.checkNotNull(error, "error");
            this.error = error;
            return this;
        }
        
        public GetAnswerResponse build() {
            return new GetAnswerResponse(
                answerResult,
                error);
        }
    }
}
