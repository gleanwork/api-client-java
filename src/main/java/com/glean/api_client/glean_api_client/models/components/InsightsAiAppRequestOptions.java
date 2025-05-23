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
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class InsightsAiAppRequestOptions {

    /**
     * IDs of the AI Apps for which Insights should be returned. An empty array signifies all.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("aiAppIds")
    private Optional<? extends List<String>> aiAppIds;

    @JsonCreator
    public InsightsAiAppRequestOptions(
            @JsonProperty("aiAppIds") Optional<? extends List<String>> aiAppIds) {
        Utils.checkNotNull(aiAppIds, "aiAppIds");
        this.aiAppIds = aiAppIds;
    }
    
    public InsightsAiAppRequestOptions() {
        this(Optional.empty());
    }

    /**
     * IDs of the AI Apps for which Insights should be returned. An empty array signifies all.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<String>> aiAppIds() {
        return (Optional<List<String>>) aiAppIds;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * IDs of the AI Apps for which Insights should be returned. An empty array signifies all.
     */
    public InsightsAiAppRequestOptions withAiAppIds(List<String> aiAppIds) {
        Utils.checkNotNull(aiAppIds, "aiAppIds");
        this.aiAppIds = Optional.ofNullable(aiAppIds);
        return this;
    }

    /**
     * IDs of the AI Apps for which Insights should be returned. An empty array signifies all.
     */
    public InsightsAiAppRequestOptions withAiAppIds(Optional<? extends List<String>> aiAppIds) {
        Utils.checkNotNull(aiAppIds, "aiAppIds");
        this.aiAppIds = aiAppIds;
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
        InsightsAiAppRequestOptions other = (InsightsAiAppRequestOptions) o;
        return 
            Objects.deepEquals(this.aiAppIds, other.aiAppIds);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            aiAppIds);
    }
    
    @Override
    public String toString() {
        return Utils.toString(InsightsAiAppRequestOptions.class,
                "aiAppIds", aiAppIds);
    }
    
    public final static class Builder {
 
        private Optional<? extends List<String>> aiAppIds = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * IDs of the AI Apps for which Insights should be returned. An empty array signifies all.
         */
        public Builder aiAppIds(List<String> aiAppIds) {
            Utils.checkNotNull(aiAppIds, "aiAppIds");
            this.aiAppIds = Optional.ofNullable(aiAppIds);
            return this;
        }

        /**
         * IDs of the AI Apps for which Insights should be returned. An empty array signifies all.
         */
        public Builder aiAppIds(Optional<? extends List<String>> aiAppIds) {
            Utils.checkNotNull(aiAppIds, "aiAppIds");
            this.aiAppIds = aiAppIds;
            return this;
        }
        
        public InsightsAiAppRequestOptions build() {
            return new InsightsAiAppRequestOptions(
                aiAppIds);
        }
    }
}
