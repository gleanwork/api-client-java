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

public class ToolsListResponse {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("tools")
    private Optional<? extends List<Tool>> tools;

    @JsonCreator
    public ToolsListResponse(
            @JsonProperty("tools") Optional<? extends List<Tool>> tools) {
        Utils.checkNotNull(tools, "tools");
        this.tools = tools;
    }
    
    public ToolsListResponse() {
        this(Optional.empty());
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<Tool>> tools() {
        return (Optional<List<Tool>>) tools;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    public ToolsListResponse withTools(List<Tool> tools) {
        Utils.checkNotNull(tools, "tools");
        this.tools = Optional.ofNullable(tools);
        return this;
    }

    public ToolsListResponse withTools(Optional<? extends List<Tool>> tools) {
        Utils.checkNotNull(tools, "tools");
        this.tools = tools;
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
        ToolsListResponse other = (ToolsListResponse) o;
        return 
            Objects.deepEquals(this.tools, other.tools);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            tools);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ToolsListResponse.class,
                "tools", tools);
    }
    
    public final static class Builder {
 
        private Optional<? extends List<Tool>> tools = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder tools(List<Tool> tools) {
            Utils.checkNotNull(tools, "tools");
            this.tools = Optional.ofNullable(tools);
            return this;
        }

        public Builder tools(Optional<? extends List<Tool>> tools) {
            Utils.checkNotNull(tools, "tools");
            this.tools = tools;
            return this;
        }
        
        public ToolsListResponse build() {
            return new ToolsListResponse(
                tools);
        }
    }
}
