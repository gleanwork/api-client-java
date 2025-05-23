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
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OperatorMetadata {

    @JsonProperty("name")
    private String name;

    /**
     * Whether this operator is supported by default or something that was created within a workplace app (e.g. custom jira field).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("isCustom")
    private Optional<Boolean> isCustom;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("operatorType")
    private Optional<? extends OperatorType> operatorType;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("helpText")
    private Optional<String> helpText;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("scopes")
    private Optional<? extends List<OperatorScope>> scopes;

    /**
     * Raw/canonical value of the operator. Only applies when result is an operator value.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("value")
    private Optional<String> value;

    /**
     * Human readable value of the operator that can be shown to the user. Only applies when result is an operator value.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("displayValue")
    private Optional<String> displayValue;

    @JsonCreator
    public OperatorMetadata(
            @JsonProperty("name") String name,
            @JsonProperty("isCustom") Optional<Boolean> isCustom,
            @JsonProperty("operatorType") Optional<? extends OperatorType> operatorType,
            @JsonProperty("helpText") Optional<String> helpText,
            @JsonProperty("scopes") Optional<? extends List<OperatorScope>> scopes,
            @JsonProperty("value") Optional<String> value,
            @JsonProperty("displayValue") Optional<String> displayValue) {
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(isCustom, "isCustom");
        Utils.checkNotNull(operatorType, "operatorType");
        Utils.checkNotNull(helpText, "helpText");
        Utils.checkNotNull(scopes, "scopes");
        Utils.checkNotNull(value, "value");
        Utils.checkNotNull(displayValue, "displayValue");
        this.name = name;
        this.isCustom = isCustom;
        this.operatorType = operatorType;
        this.helpText = helpText;
        this.scopes = scopes;
        this.value = value;
        this.displayValue = displayValue;
    }
    
    public OperatorMetadata(
            String name) {
        this(name, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    @JsonIgnore
    public String name() {
        return name;
    }

    /**
     * Whether this operator is supported by default or something that was created within a workplace app (e.g. custom jira field).
     */
    @JsonIgnore
    public Optional<Boolean> isCustom() {
        return isCustom;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<OperatorType> operatorType() {
        return (Optional<OperatorType>) operatorType;
    }

    @JsonIgnore
    public Optional<String> helpText() {
        return helpText;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<OperatorScope>> scopes() {
        return (Optional<List<OperatorScope>>) scopes;
    }

    /**
     * Raw/canonical value of the operator. Only applies when result is an operator value.
     */
    @JsonIgnore
    public Optional<String> value() {
        return value;
    }

    /**
     * Human readable value of the operator that can be shown to the user. Only applies when result is an operator value.
     */
    @JsonIgnore
    public Optional<String> displayValue() {
        return displayValue;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    public OperatorMetadata withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    /**
     * Whether this operator is supported by default or something that was created within a workplace app (e.g. custom jira field).
     */
    public OperatorMetadata withIsCustom(boolean isCustom) {
        Utils.checkNotNull(isCustom, "isCustom");
        this.isCustom = Optional.ofNullable(isCustom);
        return this;
    }

    /**
     * Whether this operator is supported by default or something that was created within a workplace app (e.g. custom jira field).
     */
    public OperatorMetadata withIsCustom(Optional<Boolean> isCustom) {
        Utils.checkNotNull(isCustom, "isCustom");
        this.isCustom = isCustom;
        return this;
    }

    public OperatorMetadata withOperatorType(OperatorType operatorType) {
        Utils.checkNotNull(operatorType, "operatorType");
        this.operatorType = Optional.ofNullable(operatorType);
        return this;
    }

    public OperatorMetadata withOperatorType(Optional<? extends OperatorType> operatorType) {
        Utils.checkNotNull(operatorType, "operatorType");
        this.operatorType = operatorType;
        return this;
    }

    public OperatorMetadata withHelpText(String helpText) {
        Utils.checkNotNull(helpText, "helpText");
        this.helpText = Optional.ofNullable(helpText);
        return this;
    }

    public OperatorMetadata withHelpText(Optional<String> helpText) {
        Utils.checkNotNull(helpText, "helpText");
        this.helpText = helpText;
        return this;
    }

    public OperatorMetadata withScopes(List<OperatorScope> scopes) {
        Utils.checkNotNull(scopes, "scopes");
        this.scopes = Optional.ofNullable(scopes);
        return this;
    }

    public OperatorMetadata withScopes(Optional<? extends List<OperatorScope>> scopes) {
        Utils.checkNotNull(scopes, "scopes");
        this.scopes = scopes;
        return this;
    }

    /**
     * Raw/canonical value of the operator. Only applies when result is an operator value.
     */
    public OperatorMetadata withValue(String value) {
        Utils.checkNotNull(value, "value");
        this.value = Optional.ofNullable(value);
        return this;
    }

    /**
     * Raw/canonical value of the operator. Only applies when result is an operator value.
     */
    public OperatorMetadata withValue(Optional<String> value) {
        Utils.checkNotNull(value, "value");
        this.value = value;
        return this;
    }

    /**
     * Human readable value of the operator that can be shown to the user. Only applies when result is an operator value.
     */
    public OperatorMetadata withDisplayValue(String displayValue) {
        Utils.checkNotNull(displayValue, "displayValue");
        this.displayValue = Optional.ofNullable(displayValue);
        return this;
    }

    /**
     * Human readable value of the operator that can be shown to the user. Only applies when result is an operator value.
     */
    public OperatorMetadata withDisplayValue(Optional<String> displayValue) {
        Utils.checkNotNull(displayValue, "displayValue");
        this.displayValue = displayValue;
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
        OperatorMetadata other = (OperatorMetadata) o;
        return 
            Objects.deepEquals(this.name, other.name) &&
            Objects.deepEquals(this.isCustom, other.isCustom) &&
            Objects.deepEquals(this.operatorType, other.operatorType) &&
            Objects.deepEquals(this.helpText, other.helpText) &&
            Objects.deepEquals(this.scopes, other.scopes) &&
            Objects.deepEquals(this.value, other.value) &&
            Objects.deepEquals(this.displayValue, other.displayValue);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            name,
            isCustom,
            operatorType,
            helpText,
            scopes,
            value,
            displayValue);
    }
    
    @Override
    public String toString() {
        return Utils.toString(OperatorMetadata.class,
                "name", name,
                "isCustom", isCustom,
                "operatorType", operatorType,
                "helpText", helpText,
                "scopes", scopes,
                "value", value,
                "displayValue", displayValue);
    }
    
    public final static class Builder {
 
        private String name;
 
        private Optional<Boolean> isCustom = Optional.empty();
 
        private Optional<? extends OperatorType> operatorType = Optional.empty();
 
        private Optional<String> helpText = Optional.empty();
 
        private Optional<? extends List<OperatorScope>> scopes = Optional.empty();
 
        private Optional<String> value = Optional.empty();
 
        private Optional<String> displayValue = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }

        /**
         * Whether this operator is supported by default or something that was created within a workplace app (e.g. custom jira field).
         */
        public Builder isCustom(boolean isCustom) {
            Utils.checkNotNull(isCustom, "isCustom");
            this.isCustom = Optional.ofNullable(isCustom);
            return this;
        }

        /**
         * Whether this operator is supported by default or something that was created within a workplace app (e.g. custom jira field).
         */
        public Builder isCustom(Optional<Boolean> isCustom) {
            Utils.checkNotNull(isCustom, "isCustom");
            this.isCustom = isCustom;
            return this;
        }

        public Builder operatorType(OperatorType operatorType) {
            Utils.checkNotNull(operatorType, "operatorType");
            this.operatorType = Optional.ofNullable(operatorType);
            return this;
        }

        public Builder operatorType(Optional<? extends OperatorType> operatorType) {
            Utils.checkNotNull(operatorType, "operatorType");
            this.operatorType = operatorType;
            return this;
        }

        public Builder helpText(String helpText) {
            Utils.checkNotNull(helpText, "helpText");
            this.helpText = Optional.ofNullable(helpText);
            return this;
        }

        public Builder helpText(Optional<String> helpText) {
            Utils.checkNotNull(helpText, "helpText");
            this.helpText = helpText;
            return this;
        }

        public Builder scopes(List<OperatorScope> scopes) {
            Utils.checkNotNull(scopes, "scopes");
            this.scopes = Optional.ofNullable(scopes);
            return this;
        }

        public Builder scopes(Optional<? extends List<OperatorScope>> scopes) {
            Utils.checkNotNull(scopes, "scopes");
            this.scopes = scopes;
            return this;
        }

        /**
         * Raw/canonical value of the operator. Only applies when result is an operator value.
         */
        public Builder value(String value) {
            Utils.checkNotNull(value, "value");
            this.value = Optional.ofNullable(value);
            return this;
        }

        /**
         * Raw/canonical value of the operator. Only applies when result is an operator value.
         */
        public Builder value(Optional<String> value) {
            Utils.checkNotNull(value, "value");
            this.value = value;
            return this;
        }

        /**
         * Human readable value of the operator that can be shown to the user. Only applies when result is an operator value.
         */
        public Builder displayValue(String displayValue) {
            Utils.checkNotNull(displayValue, "displayValue");
            this.displayValue = Optional.ofNullable(displayValue);
            return this;
        }

        /**
         * Human readable value of the operator that can be shown to the user. Only applies when result is an operator value.
         */
        public Builder displayValue(Optional<String> displayValue) {
            Utils.checkNotNull(displayValue, "displayValue");
            this.displayValue = displayValue;
            return this;
        }
        
        public OperatorMetadata build() {
            return new OperatorMetadata(
                name,
                isCustom,
                operatorType,
                helpText,
                scopes,
                value,
                displayValue);
        }
    }
}
