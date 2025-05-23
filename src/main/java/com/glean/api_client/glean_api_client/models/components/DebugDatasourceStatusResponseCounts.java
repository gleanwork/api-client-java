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

public class DebugDatasourceStatusResponseCounts {

    /**
     * A list of object types and corresponding upload counts
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("uploaded")
    private Optional<? extends List<DatasourceObjectTypeDocumentCountEntry>> uploaded;

    /**
     * The number of documents indexed, grouped by objectType
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("indexed")
    private Optional<? extends List<DatasourceObjectTypeDocumentCountEntry>> indexed;

    @JsonCreator
    public DebugDatasourceStatusResponseCounts(
            @JsonProperty("uploaded") Optional<? extends List<DatasourceObjectTypeDocumentCountEntry>> uploaded,
            @JsonProperty("indexed") Optional<? extends List<DatasourceObjectTypeDocumentCountEntry>> indexed) {
        Utils.checkNotNull(uploaded, "uploaded");
        Utils.checkNotNull(indexed, "indexed");
        this.uploaded = uploaded;
        this.indexed = indexed;
    }
    
    public DebugDatasourceStatusResponseCounts() {
        this(Optional.empty(), Optional.empty());
    }

    /**
     * A list of object types and corresponding upload counts
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<DatasourceObjectTypeDocumentCountEntry>> uploaded() {
        return (Optional<List<DatasourceObjectTypeDocumentCountEntry>>) uploaded;
    }

    /**
     * The number of documents indexed, grouped by objectType
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<DatasourceObjectTypeDocumentCountEntry>> indexed() {
        return (Optional<List<DatasourceObjectTypeDocumentCountEntry>>) indexed;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * A list of object types and corresponding upload counts
     */
    public DebugDatasourceStatusResponseCounts withUploaded(List<DatasourceObjectTypeDocumentCountEntry> uploaded) {
        Utils.checkNotNull(uploaded, "uploaded");
        this.uploaded = Optional.ofNullable(uploaded);
        return this;
    }

    /**
     * A list of object types and corresponding upload counts
     */
    public DebugDatasourceStatusResponseCounts withUploaded(Optional<? extends List<DatasourceObjectTypeDocumentCountEntry>> uploaded) {
        Utils.checkNotNull(uploaded, "uploaded");
        this.uploaded = uploaded;
        return this;
    }

    /**
     * The number of documents indexed, grouped by objectType
     */
    public DebugDatasourceStatusResponseCounts withIndexed(List<DatasourceObjectTypeDocumentCountEntry> indexed) {
        Utils.checkNotNull(indexed, "indexed");
        this.indexed = Optional.ofNullable(indexed);
        return this;
    }

    /**
     * The number of documents indexed, grouped by objectType
     */
    public DebugDatasourceStatusResponseCounts withIndexed(Optional<? extends List<DatasourceObjectTypeDocumentCountEntry>> indexed) {
        Utils.checkNotNull(indexed, "indexed");
        this.indexed = indexed;
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
        DebugDatasourceStatusResponseCounts other = (DebugDatasourceStatusResponseCounts) o;
        return 
            Objects.deepEquals(this.uploaded, other.uploaded) &&
            Objects.deepEquals(this.indexed, other.indexed);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            uploaded,
            indexed);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DebugDatasourceStatusResponseCounts.class,
                "uploaded", uploaded,
                "indexed", indexed);
    }
    
    public final static class Builder {
 
        private Optional<? extends List<DatasourceObjectTypeDocumentCountEntry>> uploaded = Optional.empty();
 
        private Optional<? extends List<DatasourceObjectTypeDocumentCountEntry>> indexed = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * A list of object types and corresponding upload counts
         */
        public Builder uploaded(List<DatasourceObjectTypeDocumentCountEntry> uploaded) {
            Utils.checkNotNull(uploaded, "uploaded");
            this.uploaded = Optional.ofNullable(uploaded);
            return this;
        }

        /**
         * A list of object types and corresponding upload counts
         */
        public Builder uploaded(Optional<? extends List<DatasourceObjectTypeDocumentCountEntry>> uploaded) {
            Utils.checkNotNull(uploaded, "uploaded");
            this.uploaded = uploaded;
            return this;
        }

        /**
         * The number of documents indexed, grouped by objectType
         */
        public Builder indexed(List<DatasourceObjectTypeDocumentCountEntry> indexed) {
            Utils.checkNotNull(indexed, "indexed");
            this.indexed = Optional.ofNullable(indexed);
            return this;
        }

        /**
         * The number of documents indexed, grouped by objectType
         */
        public Builder indexed(Optional<? extends List<DatasourceObjectTypeDocumentCountEntry>> indexed) {
            Utils.checkNotNull(indexed, "indexed");
            this.indexed = indexed;
            return this;
        }
        
        public DebugDatasourceStatusResponseCounts build() {
            return new DebugDatasourceStatusResponseCounts(
                uploaded,
                indexed);
        }
    }
}
