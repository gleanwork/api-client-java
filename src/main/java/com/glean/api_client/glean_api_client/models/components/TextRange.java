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
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;

/**
 * TextRange
 * 
 * <p>A subsection of a given string to which some special formatting should be applied.
 */
public class TextRange {

    /**
     * The inclusive start index of the range.
     */
    @JsonProperty("startIndex")
    private long startIndex;

    /**
     * The exclusive end index of the range.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("endIndex")
    private Optional<Long> endIndex;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("type")
    private Optional<? extends TextRangeType> type;

    /**
     * The URL associated with the range, if applicable. For example, the linked URL for a LINK range.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("url")
    private Optional<String> url;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("document")
    private Optional<? extends Document> document;

    @JsonCreator
    public TextRange(
            @JsonProperty("startIndex") long startIndex,
            @JsonProperty("endIndex") Optional<Long> endIndex,
            @JsonProperty("type") Optional<? extends TextRangeType> type,
            @JsonProperty("url") Optional<String> url,
            @JsonProperty("document") Optional<? extends Document> document) {
        Utils.checkNotNull(startIndex, "startIndex");
        Utils.checkNotNull(endIndex, "endIndex");
        Utils.checkNotNull(type, "type");
        Utils.checkNotNull(url, "url");
        Utils.checkNotNull(document, "document");
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.type = type;
        this.url = url;
        this.document = document;
    }
    
    public TextRange(
            long startIndex) {
        this(startIndex, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * The inclusive start index of the range.
     */
    @JsonIgnore
    public long startIndex() {
        return startIndex;
    }

    /**
     * The exclusive end index of the range.
     */
    @JsonIgnore
    public Optional<Long> endIndex() {
        return endIndex;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<TextRangeType> type() {
        return (Optional<TextRangeType>) type;
    }

    /**
     * The URL associated with the range, if applicable. For example, the linked URL for a LINK range.
     */
    @JsonIgnore
    public Optional<String> url() {
        return url;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Document> document() {
        return (Optional<Document>) document;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The inclusive start index of the range.
     */
    public TextRange withStartIndex(long startIndex) {
        Utils.checkNotNull(startIndex, "startIndex");
        this.startIndex = startIndex;
        return this;
    }

    /**
     * The exclusive end index of the range.
     */
    public TextRange withEndIndex(long endIndex) {
        Utils.checkNotNull(endIndex, "endIndex");
        this.endIndex = Optional.ofNullable(endIndex);
        return this;
    }

    /**
     * The exclusive end index of the range.
     */
    public TextRange withEndIndex(Optional<Long> endIndex) {
        Utils.checkNotNull(endIndex, "endIndex");
        this.endIndex = endIndex;
        return this;
    }

    public TextRange withType(TextRangeType type) {
        Utils.checkNotNull(type, "type");
        this.type = Optional.ofNullable(type);
        return this;
    }

    public TextRange withType(Optional<? extends TextRangeType> type) {
        Utils.checkNotNull(type, "type");
        this.type = type;
        return this;
    }

    /**
     * The URL associated with the range, if applicable. For example, the linked URL for a LINK range.
     */
    public TextRange withUrl(String url) {
        Utils.checkNotNull(url, "url");
        this.url = Optional.ofNullable(url);
        return this;
    }

    /**
     * The URL associated with the range, if applicable. For example, the linked URL for a LINK range.
     */
    public TextRange withUrl(Optional<String> url) {
        Utils.checkNotNull(url, "url");
        this.url = url;
        return this;
    }

    public TextRange withDocument(Document document) {
        Utils.checkNotNull(document, "document");
        this.document = Optional.ofNullable(document);
        return this;
    }

    public TextRange withDocument(Optional<? extends Document> document) {
        Utils.checkNotNull(document, "document");
        this.document = document;
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
        TextRange other = (TextRange) o;
        return 
            Objects.deepEquals(this.startIndex, other.startIndex) &&
            Objects.deepEquals(this.endIndex, other.endIndex) &&
            Objects.deepEquals(this.type, other.type) &&
            Objects.deepEquals(this.url, other.url) &&
            Objects.deepEquals(this.document, other.document);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            startIndex,
            endIndex,
            type,
            url,
            document);
    }
    
    @Override
    public String toString() {
        return Utils.toString(TextRange.class,
                "startIndex", startIndex,
                "endIndex", endIndex,
                "type", type,
                "url", url,
                "document", document);
    }
    
    public final static class Builder {
 
        private Long startIndex;
 
        private Optional<Long> endIndex = Optional.empty();
 
        private Optional<? extends TextRangeType> type = Optional.empty();
 
        private Optional<String> url = Optional.empty();
 
        private Optional<? extends Document> document = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The inclusive start index of the range.
         */
        public Builder startIndex(long startIndex) {
            Utils.checkNotNull(startIndex, "startIndex");
            this.startIndex = startIndex;
            return this;
        }

        /**
         * The exclusive end index of the range.
         */
        public Builder endIndex(long endIndex) {
            Utils.checkNotNull(endIndex, "endIndex");
            this.endIndex = Optional.ofNullable(endIndex);
            return this;
        }

        /**
         * The exclusive end index of the range.
         */
        public Builder endIndex(Optional<Long> endIndex) {
            Utils.checkNotNull(endIndex, "endIndex");
            this.endIndex = endIndex;
            return this;
        }

        public Builder type(TextRangeType type) {
            Utils.checkNotNull(type, "type");
            this.type = Optional.ofNullable(type);
            return this;
        }

        public Builder type(Optional<? extends TextRangeType> type) {
            Utils.checkNotNull(type, "type");
            this.type = type;
            return this;
        }

        /**
         * The URL associated with the range, if applicable. For example, the linked URL for a LINK range.
         */
        public Builder url(String url) {
            Utils.checkNotNull(url, "url");
            this.url = Optional.ofNullable(url);
            return this;
        }

        /**
         * The URL associated with the range, if applicable. For example, the linked URL for a LINK range.
         */
        public Builder url(Optional<String> url) {
            Utils.checkNotNull(url, "url");
            this.url = url;
            return this;
        }

        public Builder document(Document document) {
            Utils.checkNotNull(document, "document");
            this.document = Optional.ofNullable(document);
            return this;
        }

        public Builder document(Optional<? extends Document> document) {
            Utils.checkNotNull(document, "document");
            this.document = document;
            return this;
        }
        
        public TextRange build() {
            return new TextRange(
                startIndex,
                endIndex,
                type,
                url,
                document);
        }
    }
}
