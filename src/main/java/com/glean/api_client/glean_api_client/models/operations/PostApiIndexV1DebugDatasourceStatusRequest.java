/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glean.api_client.glean_api_client.utils.SpeakeasyMetadata;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class PostApiIndexV1DebugDatasourceStatusRequest {

    /**
     * The datasource to get debug status for.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=datasource")
    private String datasource;

    @JsonCreator
    public PostApiIndexV1DebugDatasourceStatusRequest(
            String datasource) {
        Utils.checkNotNull(datasource, "datasource");
        this.datasource = datasource;
    }

    /**
     * The datasource to get debug status for.
     */
    @JsonIgnore
    public String datasource() {
        return datasource;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The datasource to get debug status for.
     */
    public PostApiIndexV1DebugDatasourceStatusRequest withDatasource(String datasource) {
        Utils.checkNotNull(datasource, "datasource");
        this.datasource = datasource;
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
        PostApiIndexV1DebugDatasourceStatusRequest other = (PostApiIndexV1DebugDatasourceStatusRequest) o;
        return 
            Objects.deepEquals(this.datasource, other.datasource);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            datasource);
    }
    
    @Override
    public String toString() {
        return Utils.toString(PostApiIndexV1DebugDatasourceStatusRequest.class,
                "datasource", datasource);
    }
    
    public final static class Builder {
 
        private String datasource;
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The datasource to get debug status for.
         */
        public Builder datasource(String datasource) {
            Utils.checkNotNull(datasource, "datasource");
            this.datasource = datasource;
            return this;
        }
        
        public PostApiIndexV1DebugDatasourceStatusRequest build() {
            return new PostApiIndexV1DebugDatasourceStatusRequest(
                datasource);
        }
    }
}
