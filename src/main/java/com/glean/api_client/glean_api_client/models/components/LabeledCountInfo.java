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

public class LabeledCountInfo {

    /**
     * Label for the included count information.
     */
    @JsonProperty("label")
    private String label;

    /**
     * List of data points for counts for a given date period.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("countInfo")
    private Optional<? extends List<CountInfo>> countInfo;

    @JsonCreator
    public LabeledCountInfo(
            @JsonProperty("label") String label,
            @JsonProperty("countInfo") Optional<? extends List<CountInfo>> countInfo) {
        Utils.checkNotNull(label, "label");
        Utils.checkNotNull(countInfo, "countInfo");
        this.label = label;
        this.countInfo = countInfo;
    }
    
    public LabeledCountInfo(
            String label) {
        this(label, Optional.empty());
    }

    /**
     * Label for the included count information.
     */
    @JsonIgnore
    public String label() {
        return label;
    }

    /**
     * List of data points for counts for a given date period.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<CountInfo>> countInfo() {
        return (Optional<List<CountInfo>>) countInfo;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Label for the included count information.
     */
    public LabeledCountInfo withLabel(String label) {
        Utils.checkNotNull(label, "label");
        this.label = label;
        return this;
    }

    /**
     * List of data points for counts for a given date period.
     */
    public LabeledCountInfo withCountInfo(List<CountInfo> countInfo) {
        Utils.checkNotNull(countInfo, "countInfo");
        this.countInfo = Optional.ofNullable(countInfo);
        return this;
    }

    /**
     * List of data points for counts for a given date period.
     */
    public LabeledCountInfo withCountInfo(Optional<? extends List<CountInfo>> countInfo) {
        Utils.checkNotNull(countInfo, "countInfo");
        this.countInfo = countInfo;
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
        LabeledCountInfo other = (LabeledCountInfo) o;
        return 
            Objects.deepEquals(this.label, other.label) &&
            Objects.deepEquals(this.countInfo, other.countInfo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            label,
            countInfo);
    }
    
    @Override
    public String toString() {
        return Utils.toString(LabeledCountInfo.class,
                "label", label,
                "countInfo", countInfo);
    }
    
    public final static class Builder {
 
        private String label;
 
        private Optional<? extends List<CountInfo>> countInfo = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Label for the included count information.
         */
        public Builder label(String label) {
            Utils.checkNotNull(label, "label");
            this.label = label;
            return this;
        }

        /**
         * List of data points for counts for a given date period.
         */
        public Builder countInfo(List<CountInfo> countInfo) {
            Utils.checkNotNull(countInfo, "countInfo");
            this.countInfo = Optional.ofNullable(countInfo);
            return this;
        }

        /**
         * List of data points for counts for a given date period.
         */
        public Builder countInfo(Optional<? extends List<CountInfo>> countInfo) {
            Utils.checkNotNull(countInfo, "countInfo");
            this.countInfo = countInfo;
            return this;
        }
        
        public LabeledCountInfo build() {
            return new LabeledCountInfo(
                label,
                countInfo);
        }
    }
}
