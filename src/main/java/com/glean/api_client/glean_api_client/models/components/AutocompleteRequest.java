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
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AutocompleteRequest {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("trackingToken")
    private Optional<String> trackingToken;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("sessionInfo")
    private Optional<? extends SessionInfo> sessionInfo;

    /**
     * Partially typed query.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("query")
    private Optional<String> query;

    /**
     * Filter results to only those relevant to one or more datasources (e.g. jira, gdrive). Results are unfiltered if missing.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("datasourcesFilter")
    private Optional<? extends List<String>> datasourcesFilter;

    /**
     * Filter to only return results relevant to the given datasource.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("datasource")
    private Optional<String> datasource;

    /**
     * Filter to only return results of the given type(s). All types may be returned if omitted.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("resultTypes")
    private Optional<? extends List<AutocompleteRequestResultType>> resultTypes;

    /**
     * Maximum number of results to be returned. If no value is provided, the backend will cap at 200.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("resultSize")
    private Optional<Long> resultSize;

    /**
     * Auth tokens which may be used for federated results.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("authTokens")
    private Optional<? extends List<AuthToken>> authTokens;

    @JsonCreator
    public AutocompleteRequest(
            @JsonProperty("trackingToken") Optional<String> trackingToken,
            @JsonProperty("sessionInfo") Optional<? extends SessionInfo> sessionInfo,
            @JsonProperty("query") Optional<String> query,
            @JsonProperty("datasourcesFilter") Optional<? extends List<String>> datasourcesFilter,
            @JsonProperty("datasource") Optional<String> datasource,
            @JsonProperty("resultTypes") Optional<? extends List<AutocompleteRequestResultType>> resultTypes,
            @JsonProperty("resultSize") Optional<Long> resultSize,
            @JsonProperty("authTokens") Optional<? extends List<AuthToken>> authTokens) {
        Utils.checkNotNull(trackingToken, "trackingToken");
        Utils.checkNotNull(sessionInfo, "sessionInfo");
        Utils.checkNotNull(query, "query");
        Utils.checkNotNull(datasourcesFilter, "datasourcesFilter");
        Utils.checkNotNull(datasource, "datasource");
        Utils.checkNotNull(resultTypes, "resultTypes");
        Utils.checkNotNull(resultSize, "resultSize");
        Utils.checkNotNull(authTokens, "authTokens");
        this.trackingToken = trackingToken;
        this.sessionInfo = sessionInfo;
        this.query = query;
        this.datasourcesFilter = datasourcesFilter;
        this.datasource = datasource;
        this.resultTypes = resultTypes;
        this.resultSize = resultSize;
        this.authTokens = authTokens;
    }
    
    public AutocompleteRequest() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    @JsonIgnore
    public Optional<String> trackingToken() {
        return trackingToken;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<SessionInfo> sessionInfo() {
        return (Optional<SessionInfo>) sessionInfo;
    }

    /**
     * Partially typed query.
     */
    @JsonIgnore
    public Optional<String> query() {
        return query;
    }

    /**
     * Filter results to only those relevant to one or more datasources (e.g. jira, gdrive). Results are unfiltered if missing.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<String>> datasourcesFilter() {
        return (Optional<List<String>>) datasourcesFilter;
    }

    /**
     * Filter to only return results relevant to the given datasource.
     */
    @JsonIgnore
    public Optional<String> datasource() {
        return datasource;
    }

    /**
     * Filter to only return results of the given type(s). All types may be returned if omitted.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<AutocompleteRequestResultType>> resultTypes() {
        return (Optional<List<AutocompleteRequestResultType>>) resultTypes;
    }

    /**
     * Maximum number of results to be returned. If no value is provided, the backend will cap at 200.
     */
    @JsonIgnore
    public Optional<Long> resultSize() {
        return resultSize;
    }

    /**
     * Auth tokens which may be used for federated results.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<AuthToken>> authTokens() {
        return (Optional<List<AuthToken>>) authTokens;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    public AutocompleteRequest withTrackingToken(String trackingToken) {
        Utils.checkNotNull(trackingToken, "trackingToken");
        this.trackingToken = Optional.ofNullable(trackingToken);
        return this;
    }

    public AutocompleteRequest withTrackingToken(Optional<String> trackingToken) {
        Utils.checkNotNull(trackingToken, "trackingToken");
        this.trackingToken = trackingToken;
        return this;
    }

    public AutocompleteRequest withSessionInfo(SessionInfo sessionInfo) {
        Utils.checkNotNull(sessionInfo, "sessionInfo");
        this.sessionInfo = Optional.ofNullable(sessionInfo);
        return this;
    }

    public AutocompleteRequest withSessionInfo(Optional<? extends SessionInfo> sessionInfo) {
        Utils.checkNotNull(sessionInfo, "sessionInfo");
        this.sessionInfo = sessionInfo;
        return this;
    }

    /**
     * Partially typed query.
     */
    public AutocompleteRequest withQuery(String query) {
        Utils.checkNotNull(query, "query");
        this.query = Optional.ofNullable(query);
        return this;
    }

    /**
     * Partially typed query.
     */
    public AutocompleteRequest withQuery(Optional<String> query) {
        Utils.checkNotNull(query, "query");
        this.query = query;
        return this;
    }

    /**
     * Filter results to only those relevant to one or more datasources (e.g. jira, gdrive). Results are unfiltered if missing.
     */
    public AutocompleteRequest withDatasourcesFilter(List<String> datasourcesFilter) {
        Utils.checkNotNull(datasourcesFilter, "datasourcesFilter");
        this.datasourcesFilter = Optional.ofNullable(datasourcesFilter);
        return this;
    }

    /**
     * Filter results to only those relevant to one or more datasources (e.g. jira, gdrive). Results are unfiltered if missing.
     */
    public AutocompleteRequest withDatasourcesFilter(Optional<? extends List<String>> datasourcesFilter) {
        Utils.checkNotNull(datasourcesFilter, "datasourcesFilter");
        this.datasourcesFilter = datasourcesFilter;
        return this;
    }

    /**
     * Filter to only return results relevant to the given datasource.
     */
    public AutocompleteRequest withDatasource(String datasource) {
        Utils.checkNotNull(datasource, "datasource");
        this.datasource = Optional.ofNullable(datasource);
        return this;
    }

    /**
     * Filter to only return results relevant to the given datasource.
     */
    public AutocompleteRequest withDatasource(Optional<String> datasource) {
        Utils.checkNotNull(datasource, "datasource");
        this.datasource = datasource;
        return this;
    }

    /**
     * Filter to only return results of the given type(s). All types may be returned if omitted.
     */
    public AutocompleteRequest withResultTypes(List<AutocompleteRequestResultType> resultTypes) {
        Utils.checkNotNull(resultTypes, "resultTypes");
        this.resultTypes = Optional.ofNullable(resultTypes);
        return this;
    }

    /**
     * Filter to only return results of the given type(s). All types may be returned if omitted.
     */
    public AutocompleteRequest withResultTypes(Optional<? extends List<AutocompleteRequestResultType>> resultTypes) {
        Utils.checkNotNull(resultTypes, "resultTypes");
        this.resultTypes = resultTypes;
        return this;
    }

    /**
     * Maximum number of results to be returned. If no value is provided, the backend will cap at 200.
     */
    public AutocompleteRequest withResultSize(long resultSize) {
        Utils.checkNotNull(resultSize, "resultSize");
        this.resultSize = Optional.ofNullable(resultSize);
        return this;
    }

    /**
     * Maximum number of results to be returned. If no value is provided, the backend will cap at 200.
     */
    public AutocompleteRequest withResultSize(Optional<Long> resultSize) {
        Utils.checkNotNull(resultSize, "resultSize");
        this.resultSize = resultSize;
        return this;
    }

    /**
     * Auth tokens which may be used for federated results.
     */
    public AutocompleteRequest withAuthTokens(List<AuthToken> authTokens) {
        Utils.checkNotNull(authTokens, "authTokens");
        this.authTokens = Optional.ofNullable(authTokens);
        return this;
    }

    /**
     * Auth tokens which may be used for federated results.
     */
    public AutocompleteRequest withAuthTokens(Optional<? extends List<AuthToken>> authTokens) {
        Utils.checkNotNull(authTokens, "authTokens");
        this.authTokens = authTokens;
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
        AutocompleteRequest other = (AutocompleteRequest) o;
        return 
            Objects.deepEquals(this.trackingToken, other.trackingToken) &&
            Objects.deepEquals(this.sessionInfo, other.sessionInfo) &&
            Objects.deepEquals(this.query, other.query) &&
            Objects.deepEquals(this.datasourcesFilter, other.datasourcesFilter) &&
            Objects.deepEquals(this.datasource, other.datasource) &&
            Objects.deepEquals(this.resultTypes, other.resultTypes) &&
            Objects.deepEquals(this.resultSize, other.resultSize) &&
            Objects.deepEquals(this.authTokens, other.authTokens);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            trackingToken,
            sessionInfo,
            query,
            datasourcesFilter,
            datasource,
            resultTypes,
            resultSize,
            authTokens);
    }
    
    @Override
    public String toString() {
        return Utils.toString(AutocompleteRequest.class,
                "trackingToken", trackingToken,
                "sessionInfo", sessionInfo,
                "query", query,
                "datasourcesFilter", datasourcesFilter,
                "datasource", datasource,
                "resultTypes", resultTypes,
                "resultSize", resultSize,
                "authTokens", authTokens);
    }
    
    public final static class Builder {
 
        private Optional<String> trackingToken = Optional.empty();
 
        private Optional<? extends SessionInfo> sessionInfo = Optional.empty();
 
        private Optional<String> query = Optional.empty();
 
        private Optional<? extends List<String>> datasourcesFilter = Optional.empty();
 
        private Optional<String> datasource = Optional.empty();
 
        private Optional<? extends List<AutocompleteRequestResultType>> resultTypes = Optional.empty();
 
        private Optional<Long> resultSize = Optional.empty();
 
        private Optional<? extends List<AuthToken>> authTokens = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder trackingToken(String trackingToken) {
            Utils.checkNotNull(trackingToken, "trackingToken");
            this.trackingToken = Optional.ofNullable(trackingToken);
            return this;
        }

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

        /**
         * Partially typed query.
         */
        public Builder query(String query) {
            Utils.checkNotNull(query, "query");
            this.query = Optional.ofNullable(query);
            return this;
        }

        /**
         * Partially typed query.
         */
        public Builder query(Optional<String> query) {
            Utils.checkNotNull(query, "query");
            this.query = query;
            return this;
        }

        /**
         * Filter results to only those relevant to one or more datasources (e.g. jira, gdrive). Results are unfiltered if missing.
         */
        public Builder datasourcesFilter(List<String> datasourcesFilter) {
            Utils.checkNotNull(datasourcesFilter, "datasourcesFilter");
            this.datasourcesFilter = Optional.ofNullable(datasourcesFilter);
            return this;
        }

        /**
         * Filter results to only those relevant to one or more datasources (e.g. jira, gdrive). Results are unfiltered if missing.
         */
        public Builder datasourcesFilter(Optional<? extends List<String>> datasourcesFilter) {
            Utils.checkNotNull(datasourcesFilter, "datasourcesFilter");
            this.datasourcesFilter = datasourcesFilter;
            return this;
        }

        /**
         * Filter to only return results relevant to the given datasource.
         */
        public Builder datasource(String datasource) {
            Utils.checkNotNull(datasource, "datasource");
            this.datasource = Optional.ofNullable(datasource);
            return this;
        }

        /**
         * Filter to only return results relevant to the given datasource.
         */
        public Builder datasource(Optional<String> datasource) {
            Utils.checkNotNull(datasource, "datasource");
            this.datasource = datasource;
            return this;
        }

        /**
         * Filter to only return results of the given type(s). All types may be returned if omitted.
         */
        public Builder resultTypes(List<AutocompleteRequestResultType> resultTypes) {
            Utils.checkNotNull(resultTypes, "resultTypes");
            this.resultTypes = Optional.ofNullable(resultTypes);
            return this;
        }

        /**
         * Filter to only return results of the given type(s). All types may be returned if omitted.
         */
        public Builder resultTypes(Optional<? extends List<AutocompleteRequestResultType>> resultTypes) {
            Utils.checkNotNull(resultTypes, "resultTypes");
            this.resultTypes = resultTypes;
            return this;
        }

        /**
         * Maximum number of results to be returned. If no value is provided, the backend will cap at 200.
         */
        public Builder resultSize(long resultSize) {
            Utils.checkNotNull(resultSize, "resultSize");
            this.resultSize = Optional.ofNullable(resultSize);
            return this;
        }

        /**
         * Maximum number of results to be returned. If no value is provided, the backend will cap at 200.
         */
        public Builder resultSize(Optional<Long> resultSize) {
            Utils.checkNotNull(resultSize, "resultSize");
            this.resultSize = resultSize;
            return this;
        }

        /**
         * Auth tokens which may be used for federated results.
         */
        public Builder authTokens(List<AuthToken> authTokens) {
            Utils.checkNotNull(authTokens, "authTokens");
            this.authTokens = Optional.ofNullable(authTokens);
            return this;
        }

        /**
         * Auth tokens which may be used for federated results.
         */
        public Builder authTokens(Optional<? extends List<AuthToken>> authTokens) {
            Utils.checkNotNull(authTokens, "authTokens");
            this.authTokens = authTokens;
            return this;
        }
        
        public AutocompleteRequest build() {
            return new AutocompleteRequest(
                trackingToken,
                sessionInfo,
                query,
                datasourcesFilter,
                datasource,
                resultTypes,
                resultSize,
                authTokens);
        }
    }
}
