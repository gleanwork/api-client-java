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
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

public class RecommendationsRequest {

    /**
     * The ISO 8601 timestamp associated with the client request.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("timestamp")
    private Optional<OffsetDateTime> timestamp;

    /**
     * A previously received trackingToken for a search associated with the same query. Useful for more requests and requests for other tabs.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("trackingToken")
    private Optional<String> trackingToken;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("sessionInfo")
    private Optional<? extends SessionInfo> sessionInfo;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("sourceDocument")
    private Optional<? extends Document> sourceDocument;

    /**
     * Hint to the server about how many results to send back. Server may return less or more. Structured results and clustered results don't count towards pageSize.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("pageSize")
    private Optional<Long> pageSize;

    /**
     * Hint to the server about how many characters long a snippet may be. Server may return less or more.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("maxSnippetSize")
    private Optional<Long> maxSnippetSize;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("recommendationDocumentSpec")
    private Optional<? extends DocumentSpecUnion> recommendationDocumentSpec;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("requestOptions")
    private Optional<? extends RecommendationsRequestOptions> requestOptions;

    @JsonCreator
    public RecommendationsRequest(
            @JsonProperty("timestamp") Optional<OffsetDateTime> timestamp,
            @JsonProperty("trackingToken") Optional<String> trackingToken,
            @JsonProperty("sessionInfo") Optional<? extends SessionInfo> sessionInfo,
            @JsonProperty("sourceDocument") Optional<? extends Document> sourceDocument,
            @JsonProperty("pageSize") Optional<Long> pageSize,
            @JsonProperty("maxSnippetSize") Optional<Long> maxSnippetSize,
            @JsonProperty("recommendationDocumentSpec") Optional<? extends DocumentSpecUnion> recommendationDocumentSpec,
            @JsonProperty("requestOptions") Optional<? extends RecommendationsRequestOptions> requestOptions) {
        Utils.checkNotNull(timestamp, "timestamp");
        Utils.checkNotNull(trackingToken, "trackingToken");
        Utils.checkNotNull(sessionInfo, "sessionInfo");
        Utils.checkNotNull(sourceDocument, "sourceDocument");
        Utils.checkNotNull(pageSize, "pageSize");
        Utils.checkNotNull(maxSnippetSize, "maxSnippetSize");
        Utils.checkNotNull(recommendationDocumentSpec, "recommendationDocumentSpec");
        Utils.checkNotNull(requestOptions, "requestOptions");
        this.timestamp = timestamp;
        this.trackingToken = trackingToken;
        this.sessionInfo = sessionInfo;
        this.sourceDocument = sourceDocument;
        this.pageSize = pageSize;
        this.maxSnippetSize = maxSnippetSize;
        this.recommendationDocumentSpec = recommendationDocumentSpec;
        this.requestOptions = requestOptions;
    }
    
    public RecommendationsRequest() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * The ISO 8601 timestamp associated with the client request.
     */
    @JsonIgnore
    public Optional<OffsetDateTime> timestamp() {
        return timestamp;
    }

    /**
     * A previously received trackingToken for a search associated with the same query. Useful for more requests and requests for other tabs.
     */
    @JsonIgnore
    public Optional<String> trackingToken() {
        return trackingToken;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<SessionInfo> sessionInfo() {
        return (Optional<SessionInfo>) sessionInfo;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Document> sourceDocument() {
        return (Optional<Document>) sourceDocument;
    }

    /**
     * Hint to the server about how many results to send back. Server may return less or more. Structured results and clustered results don't count towards pageSize.
     */
    @JsonIgnore
    public Optional<Long> pageSize() {
        return pageSize;
    }

    /**
     * Hint to the server about how many characters long a snippet may be. Server may return less or more.
     */
    @JsonIgnore
    public Optional<Long> maxSnippetSize() {
        return maxSnippetSize;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<DocumentSpecUnion> recommendationDocumentSpec() {
        return (Optional<DocumentSpecUnion>) recommendationDocumentSpec;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<RecommendationsRequestOptions> requestOptions() {
        return (Optional<RecommendationsRequestOptions>) requestOptions;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The ISO 8601 timestamp associated with the client request.
     */
    public RecommendationsRequest withTimestamp(OffsetDateTime timestamp) {
        Utils.checkNotNull(timestamp, "timestamp");
        this.timestamp = Optional.ofNullable(timestamp);
        return this;
    }

    /**
     * The ISO 8601 timestamp associated with the client request.
     */
    public RecommendationsRequest withTimestamp(Optional<OffsetDateTime> timestamp) {
        Utils.checkNotNull(timestamp, "timestamp");
        this.timestamp = timestamp;
        return this;
    }

    /**
     * A previously received trackingToken for a search associated with the same query. Useful for more requests and requests for other tabs.
     */
    public RecommendationsRequest withTrackingToken(String trackingToken) {
        Utils.checkNotNull(trackingToken, "trackingToken");
        this.trackingToken = Optional.ofNullable(trackingToken);
        return this;
    }

    /**
     * A previously received trackingToken for a search associated with the same query. Useful for more requests and requests for other tabs.
     */
    public RecommendationsRequest withTrackingToken(Optional<String> trackingToken) {
        Utils.checkNotNull(trackingToken, "trackingToken");
        this.trackingToken = trackingToken;
        return this;
    }

    public RecommendationsRequest withSessionInfo(SessionInfo sessionInfo) {
        Utils.checkNotNull(sessionInfo, "sessionInfo");
        this.sessionInfo = Optional.ofNullable(sessionInfo);
        return this;
    }

    public RecommendationsRequest withSessionInfo(Optional<? extends SessionInfo> sessionInfo) {
        Utils.checkNotNull(sessionInfo, "sessionInfo");
        this.sessionInfo = sessionInfo;
        return this;
    }

    public RecommendationsRequest withSourceDocument(Document sourceDocument) {
        Utils.checkNotNull(sourceDocument, "sourceDocument");
        this.sourceDocument = Optional.ofNullable(sourceDocument);
        return this;
    }

    public RecommendationsRequest withSourceDocument(Optional<? extends Document> sourceDocument) {
        Utils.checkNotNull(sourceDocument, "sourceDocument");
        this.sourceDocument = sourceDocument;
        return this;
    }

    /**
     * Hint to the server about how many results to send back. Server may return less or more. Structured results and clustered results don't count towards pageSize.
     */
    public RecommendationsRequest withPageSize(long pageSize) {
        Utils.checkNotNull(pageSize, "pageSize");
        this.pageSize = Optional.ofNullable(pageSize);
        return this;
    }

    /**
     * Hint to the server about how many results to send back. Server may return less or more. Structured results and clustered results don't count towards pageSize.
     */
    public RecommendationsRequest withPageSize(Optional<Long> pageSize) {
        Utils.checkNotNull(pageSize, "pageSize");
        this.pageSize = pageSize;
        return this;
    }

    /**
     * Hint to the server about how many characters long a snippet may be. Server may return less or more.
     */
    public RecommendationsRequest withMaxSnippetSize(long maxSnippetSize) {
        Utils.checkNotNull(maxSnippetSize, "maxSnippetSize");
        this.maxSnippetSize = Optional.ofNullable(maxSnippetSize);
        return this;
    }

    /**
     * Hint to the server about how many characters long a snippet may be. Server may return less or more.
     */
    public RecommendationsRequest withMaxSnippetSize(Optional<Long> maxSnippetSize) {
        Utils.checkNotNull(maxSnippetSize, "maxSnippetSize");
        this.maxSnippetSize = maxSnippetSize;
        return this;
    }

    public RecommendationsRequest withRecommendationDocumentSpec(DocumentSpecUnion recommendationDocumentSpec) {
        Utils.checkNotNull(recommendationDocumentSpec, "recommendationDocumentSpec");
        this.recommendationDocumentSpec = Optional.ofNullable(recommendationDocumentSpec);
        return this;
    }

    public RecommendationsRequest withRecommendationDocumentSpec(Optional<? extends DocumentSpecUnion> recommendationDocumentSpec) {
        Utils.checkNotNull(recommendationDocumentSpec, "recommendationDocumentSpec");
        this.recommendationDocumentSpec = recommendationDocumentSpec;
        return this;
    }

    public RecommendationsRequest withRequestOptions(RecommendationsRequestOptions requestOptions) {
        Utils.checkNotNull(requestOptions, "requestOptions");
        this.requestOptions = Optional.ofNullable(requestOptions);
        return this;
    }

    public RecommendationsRequest withRequestOptions(Optional<? extends RecommendationsRequestOptions> requestOptions) {
        Utils.checkNotNull(requestOptions, "requestOptions");
        this.requestOptions = requestOptions;
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
        RecommendationsRequest other = (RecommendationsRequest) o;
        return 
            Objects.deepEquals(this.timestamp, other.timestamp) &&
            Objects.deepEquals(this.trackingToken, other.trackingToken) &&
            Objects.deepEquals(this.sessionInfo, other.sessionInfo) &&
            Objects.deepEquals(this.sourceDocument, other.sourceDocument) &&
            Objects.deepEquals(this.pageSize, other.pageSize) &&
            Objects.deepEquals(this.maxSnippetSize, other.maxSnippetSize) &&
            Objects.deepEquals(this.recommendationDocumentSpec, other.recommendationDocumentSpec) &&
            Objects.deepEquals(this.requestOptions, other.requestOptions);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            timestamp,
            trackingToken,
            sessionInfo,
            sourceDocument,
            pageSize,
            maxSnippetSize,
            recommendationDocumentSpec,
            requestOptions);
    }
    
    @Override
    public String toString() {
        return Utils.toString(RecommendationsRequest.class,
                "timestamp", timestamp,
                "trackingToken", trackingToken,
                "sessionInfo", sessionInfo,
                "sourceDocument", sourceDocument,
                "pageSize", pageSize,
                "maxSnippetSize", maxSnippetSize,
                "recommendationDocumentSpec", recommendationDocumentSpec,
                "requestOptions", requestOptions);
    }
    
    public final static class Builder {
 
        private Optional<OffsetDateTime> timestamp = Optional.empty();
 
        private Optional<String> trackingToken = Optional.empty();
 
        private Optional<? extends SessionInfo> sessionInfo = Optional.empty();
 
        private Optional<? extends Document> sourceDocument = Optional.empty();
 
        private Optional<Long> pageSize = Optional.empty();
 
        private Optional<Long> maxSnippetSize = Optional.empty();
 
        private Optional<? extends DocumentSpecUnion> recommendationDocumentSpec = Optional.empty();
 
        private Optional<? extends RecommendationsRequestOptions> requestOptions = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The ISO 8601 timestamp associated with the client request.
         */
        public Builder timestamp(OffsetDateTime timestamp) {
            Utils.checkNotNull(timestamp, "timestamp");
            this.timestamp = Optional.ofNullable(timestamp);
            return this;
        }

        /**
         * The ISO 8601 timestamp associated with the client request.
         */
        public Builder timestamp(Optional<OffsetDateTime> timestamp) {
            Utils.checkNotNull(timestamp, "timestamp");
            this.timestamp = timestamp;
            return this;
        }

        /**
         * A previously received trackingToken for a search associated with the same query. Useful for more requests and requests for other tabs.
         */
        public Builder trackingToken(String trackingToken) {
            Utils.checkNotNull(trackingToken, "trackingToken");
            this.trackingToken = Optional.ofNullable(trackingToken);
            return this;
        }

        /**
         * A previously received trackingToken for a search associated with the same query. Useful for more requests and requests for other tabs.
         */
        public Builder trackingToken(Optional<String> trackingToken) {
            Utils.checkNotNull(trackingToken, "trackingToken");
            this.trackingToken = trackingToken;
            return this;
        }

        public Builder sessionInfo(SessionInfo sessionInfo) {
            Utils.checkNotNull(sessionInfo, "sessionInfo");
            this.sessionInfo = Optional.ofNullable(sessionInfo);
            return this;
        }

        public Builder sessionInfo(Optional<? extends SessionInfo> sessionInfo) {
            Utils.checkNotNull(sessionInfo, "sessionInfo");
            this.sessionInfo = sessionInfo;
            return this;
        }

        public Builder sourceDocument(Document sourceDocument) {
            Utils.checkNotNull(sourceDocument, "sourceDocument");
            this.sourceDocument = Optional.ofNullable(sourceDocument);
            return this;
        }

        public Builder sourceDocument(Optional<? extends Document> sourceDocument) {
            Utils.checkNotNull(sourceDocument, "sourceDocument");
            this.sourceDocument = sourceDocument;
            return this;
        }

        /**
         * Hint to the server about how many results to send back. Server may return less or more. Structured results and clustered results don't count towards pageSize.
         */
        public Builder pageSize(long pageSize) {
            Utils.checkNotNull(pageSize, "pageSize");
            this.pageSize = Optional.ofNullable(pageSize);
            return this;
        }

        /**
         * Hint to the server about how many results to send back. Server may return less or more. Structured results and clustered results don't count towards pageSize.
         */
        public Builder pageSize(Optional<Long> pageSize) {
            Utils.checkNotNull(pageSize, "pageSize");
            this.pageSize = pageSize;
            return this;
        }

        /**
         * Hint to the server about how many characters long a snippet may be. Server may return less or more.
         */
        public Builder maxSnippetSize(long maxSnippetSize) {
            Utils.checkNotNull(maxSnippetSize, "maxSnippetSize");
            this.maxSnippetSize = Optional.ofNullable(maxSnippetSize);
            return this;
        }

        /**
         * Hint to the server about how many characters long a snippet may be. Server may return less or more.
         */
        public Builder maxSnippetSize(Optional<Long> maxSnippetSize) {
            Utils.checkNotNull(maxSnippetSize, "maxSnippetSize");
            this.maxSnippetSize = maxSnippetSize;
            return this;
        }

        public Builder recommendationDocumentSpec(DocumentSpecUnion recommendationDocumentSpec) {
            Utils.checkNotNull(recommendationDocumentSpec, "recommendationDocumentSpec");
            this.recommendationDocumentSpec = Optional.ofNullable(recommendationDocumentSpec);
            return this;
        }

        public Builder recommendationDocumentSpec(Optional<? extends DocumentSpecUnion> recommendationDocumentSpec) {
            Utils.checkNotNull(recommendationDocumentSpec, "recommendationDocumentSpec");
            this.recommendationDocumentSpec = recommendationDocumentSpec;
            return this;
        }

        public Builder requestOptions(RecommendationsRequestOptions requestOptions) {
            Utils.checkNotNull(requestOptions, "requestOptions");
            this.requestOptions = Optional.ofNullable(requestOptions);
            return this;
        }

        public Builder requestOptions(Optional<? extends RecommendationsRequestOptions> requestOptions) {
            Utils.checkNotNull(requestOptions, "requestOptions");
            this.requestOptions = requestOptions;
            return this;
        }
        
        public RecommendationsRequest build() {
            return new RecommendationsRequest(
                timestamp,
                trackingToken,
                sessionInfo,
                sourceDocument,
                pageSize,
                maxSnippetSize,
                recommendationDocumentSpec,
                requestOptions);
        }
    }
}
