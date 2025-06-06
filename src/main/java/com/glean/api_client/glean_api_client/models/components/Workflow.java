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

public class Workflow {

    /**
     * The name of the workflow.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("name")
    private Optional<String> name;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("author")
    private Optional<? extends Person> author;

    /**
     * Server Unix timestamp of the creation time.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("createTimestamp")
    private Optional<Long> createTimestamp;

    /**
     * Server Unix timestamp of the last update time.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("lastUpdateTimestamp")
    private Optional<Long> lastUpdateTimestamp;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("lastUpdatedBy")
    private Optional<? extends Person> lastUpdatedBy;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("permissions")
    private Optional<? extends ObjectPermissions> permissions;

    /**
     * The ID of the workflow.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("id")
    private Optional<String> id;

    @JsonCreator
    public Workflow(
            @JsonProperty("name") Optional<String> name,
            @JsonProperty("author") Optional<? extends Person> author,
            @JsonProperty("createTimestamp") Optional<Long> createTimestamp,
            @JsonProperty("lastUpdateTimestamp") Optional<Long> lastUpdateTimestamp,
            @JsonProperty("lastUpdatedBy") Optional<? extends Person> lastUpdatedBy,
            @JsonProperty("permissions") Optional<? extends ObjectPermissions> permissions,
            @JsonProperty("id") Optional<String> id) {
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(author, "author");
        Utils.checkNotNull(createTimestamp, "createTimestamp");
        Utils.checkNotNull(lastUpdateTimestamp, "lastUpdateTimestamp");
        Utils.checkNotNull(lastUpdatedBy, "lastUpdatedBy");
        Utils.checkNotNull(permissions, "permissions");
        Utils.checkNotNull(id, "id");
        this.name = name;
        this.author = author;
        this.createTimestamp = createTimestamp;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
        this.lastUpdatedBy = lastUpdatedBy;
        this.permissions = permissions;
        this.id = id;
    }
    
    public Workflow() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * The name of the workflow.
     */
    @JsonIgnore
    public Optional<String> name() {
        return name;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Person> author() {
        return (Optional<Person>) author;
    }

    /**
     * Server Unix timestamp of the creation time.
     */
    @JsonIgnore
    public Optional<Long> createTimestamp() {
        return createTimestamp;
    }

    /**
     * Server Unix timestamp of the last update time.
     */
    @JsonIgnore
    public Optional<Long> lastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Person> lastUpdatedBy() {
        return (Optional<Person>) lastUpdatedBy;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ObjectPermissions> permissions() {
        return (Optional<ObjectPermissions>) permissions;
    }

    /**
     * The ID of the workflow.
     */
    @JsonIgnore
    public Optional<String> id() {
        return id;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The name of the workflow.
     */
    public Workflow withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = Optional.ofNullable(name);
        return this;
    }

    /**
     * The name of the workflow.
     */
    public Workflow withName(Optional<String> name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    public Workflow withAuthor(Person author) {
        Utils.checkNotNull(author, "author");
        this.author = Optional.ofNullable(author);
        return this;
    }

    public Workflow withAuthor(Optional<? extends Person> author) {
        Utils.checkNotNull(author, "author");
        this.author = author;
        return this;
    }

    /**
     * Server Unix timestamp of the creation time.
     */
    public Workflow withCreateTimestamp(long createTimestamp) {
        Utils.checkNotNull(createTimestamp, "createTimestamp");
        this.createTimestamp = Optional.ofNullable(createTimestamp);
        return this;
    }

    /**
     * Server Unix timestamp of the creation time.
     */
    public Workflow withCreateTimestamp(Optional<Long> createTimestamp) {
        Utils.checkNotNull(createTimestamp, "createTimestamp");
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * Server Unix timestamp of the last update time.
     */
    public Workflow withLastUpdateTimestamp(long lastUpdateTimestamp) {
        Utils.checkNotNull(lastUpdateTimestamp, "lastUpdateTimestamp");
        this.lastUpdateTimestamp = Optional.ofNullable(lastUpdateTimestamp);
        return this;
    }

    /**
     * Server Unix timestamp of the last update time.
     */
    public Workflow withLastUpdateTimestamp(Optional<Long> lastUpdateTimestamp) {
        Utils.checkNotNull(lastUpdateTimestamp, "lastUpdateTimestamp");
        this.lastUpdateTimestamp = lastUpdateTimestamp;
        return this;
    }

    public Workflow withLastUpdatedBy(Person lastUpdatedBy) {
        Utils.checkNotNull(lastUpdatedBy, "lastUpdatedBy");
        this.lastUpdatedBy = Optional.ofNullable(lastUpdatedBy);
        return this;
    }

    public Workflow withLastUpdatedBy(Optional<? extends Person> lastUpdatedBy) {
        Utils.checkNotNull(lastUpdatedBy, "lastUpdatedBy");
        this.lastUpdatedBy = lastUpdatedBy;
        return this;
    }

    public Workflow withPermissions(ObjectPermissions permissions) {
        Utils.checkNotNull(permissions, "permissions");
        this.permissions = Optional.ofNullable(permissions);
        return this;
    }

    public Workflow withPermissions(Optional<? extends ObjectPermissions> permissions) {
        Utils.checkNotNull(permissions, "permissions");
        this.permissions = permissions;
        return this;
    }

    /**
     * The ID of the workflow.
     */
    public Workflow withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = Optional.ofNullable(id);
        return this;
    }

    /**
     * The ID of the workflow.
     */
    public Workflow withId(Optional<String> id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
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
        Workflow other = (Workflow) o;
        return 
            Objects.deepEquals(this.name, other.name) &&
            Objects.deepEquals(this.author, other.author) &&
            Objects.deepEquals(this.createTimestamp, other.createTimestamp) &&
            Objects.deepEquals(this.lastUpdateTimestamp, other.lastUpdateTimestamp) &&
            Objects.deepEquals(this.lastUpdatedBy, other.lastUpdatedBy) &&
            Objects.deepEquals(this.permissions, other.permissions) &&
            Objects.deepEquals(this.id, other.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            name,
            author,
            createTimestamp,
            lastUpdateTimestamp,
            lastUpdatedBy,
            permissions,
            id);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Workflow.class,
                "name", name,
                "author", author,
                "createTimestamp", createTimestamp,
                "lastUpdateTimestamp", lastUpdateTimestamp,
                "lastUpdatedBy", lastUpdatedBy,
                "permissions", permissions,
                "id", id);
    }
    
    public final static class Builder {
 
        private Optional<String> name = Optional.empty();
 
        private Optional<? extends Person> author = Optional.empty();
 
        private Optional<Long> createTimestamp = Optional.empty();
 
        private Optional<Long> lastUpdateTimestamp = Optional.empty();
 
        private Optional<? extends Person> lastUpdatedBy = Optional.empty();
 
        private Optional<? extends ObjectPermissions> permissions = Optional.empty();
 
        private Optional<String> id = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The name of the workflow.
         */
        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = Optional.ofNullable(name);
            return this;
        }

        /**
         * The name of the workflow.
         */
        public Builder name(Optional<String> name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }

        public Builder author(Person author) {
            Utils.checkNotNull(author, "author");
            this.author = Optional.ofNullable(author);
            return this;
        }

        public Builder author(Optional<? extends Person> author) {
            Utils.checkNotNull(author, "author");
            this.author = author;
            return this;
        }

        /**
         * Server Unix timestamp of the creation time.
         */
        public Builder createTimestamp(long createTimestamp) {
            Utils.checkNotNull(createTimestamp, "createTimestamp");
            this.createTimestamp = Optional.ofNullable(createTimestamp);
            return this;
        }

        /**
         * Server Unix timestamp of the creation time.
         */
        public Builder createTimestamp(Optional<Long> createTimestamp) {
            Utils.checkNotNull(createTimestamp, "createTimestamp");
            this.createTimestamp = createTimestamp;
            return this;
        }

        /**
         * Server Unix timestamp of the last update time.
         */
        public Builder lastUpdateTimestamp(long lastUpdateTimestamp) {
            Utils.checkNotNull(lastUpdateTimestamp, "lastUpdateTimestamp");
            this.lastUpdateTimestamp = Optional.ofNullable(lastUpdateTimestamp);
            return this;
        }

        /**
         * Server Unix timestamp of the last update time.
         */
        public Builder lastUpdateTimestamp(Optional<Long> lastUpdateTimestamp) {
            Utils.checkNotNull(lastUpdateTimestamp, "lastUpdateTimestamp");
            this.lastUpdateTimestamp = lastUpdateTimestamp;
            return this;
        }

        public Builder lastUpdatedBy(Person lastUpdatedBy) {
            Utils.checkNotNull(lastUpdatedBy, "lastUpdatedBy");
            this.lastUpdatedBy = Optional.ofNullable(lastUpdatedBy);
            return this;
        }

        public Builder lastUpdatedBy(Optional<? extends Person> lastUpdatedBy) {
            Utils.checkNotNull(lastUpdatedBy, "lastUpdatedBy");
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder permissions(ObjectPermissions permissions) {
            Utils.checkNotNull(permissions, "permissions");
            this.permissions = Optional.ofNullable(permissions);
            return this;
        }

        public Builder permissions(Optional<? extends ObjectPermissions> permissions) {
            Utils.checkNotNull(permissions, "permissions");
            this.permissions = permissions;
            return this;
        }

        /**
         * The ID of the workflow.
         */
        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = Optional.ofNullable(id);
            return this;
        }

        /**
         * The ID of the workflow.
         */
        public Builder id(Optional<String> id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }
        
        public Workflow build() {
            return new Workflow(
                name,
                author,
                createTimestamp,
                lastUpdateTimestamp,
                lastUpdatedBy,
                permissions,
                id);
        }
    }
}
