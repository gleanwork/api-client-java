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

/**
 * GeneratedAttachment
 * 
 * <p>These are attachments that aren't natively present on the event, and have been smartly suggested.
 */
public class GeneratedAttachment {

    /**
     * The name of method used to surface relevant data for a given calendar event.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("strategyName")
    private Optional<? extends EventStrategyName> strategyName;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("documents")
    private Optional<? extends List<Document>> documents;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("person")
    private Optional<? extends Person> person;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("customer")
    private Optional<? extends Customer> customer;

    /**
     * A list of links to external sources outside of Glean.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("externalLinks")
    private Optional<? extends List<StructuredLink>> externalLinks;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("content")
    private Optional<? extends List<GeneratedAttachmentContent>> content;

    @JsonCreator
    public GeneratedAttachment(
            @JsonProperty("strategyName") Optional<? extends EventStrategyName> strategyName,
            @JsonProperty("documents") Optional<? extends List<Document>> documents,
            @JsonProperty("person") Optional<? extends Person> person,
            @JsonProperty("customer") Optional<? extends Customer> customer,
            @JsonProperty("externalLinks") Optional<? extends List<StructuredLink>> externalLinks,
            @JsonProperty("content") Optional<? extends List<GeneratedAttachmentContent>> content) {
        Utils.checkNotNull(strategyName, "strategyName");
        Utils.checkNotNull(documents, "documents");
        Utils.checkNotNull(person, "person");
        Utils.checkNotNull(customer, "customer");
        Utils.checkNotNull(externalLinks, "externalLinks");
        Utils.checkNotNull(content, "content");
        this.strategyName = strategyName;
        this.documents = documents;
        this.person = person;
        this.customer = customer;
        this.externalLinks = externalLinks;
        this.content = content;
    }
    
    public GeneratedAttachment() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * The name of method used to surface relevant data for a given calendar event.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<EventStrategyName> strategyName() {
        return (Optional<EventStrategyName>) strategyName;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<Document>> documents() {
        return (Optional<List<Document>>) documents;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Person> person() {
        return (Optional<Person>) person;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Customer> customer() {
        return (Optional<Customer>) customer;
    }

    /**
     * A list of links to external sources outside of Glean.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<StructuredLink>> externalLinks() {
        return (Optional<List<StructuredLink>>) externalLinks;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<GeneratedAttachmentContent>> content() {
        return (Optional<List<GeneratedAttachmentContent>>) content;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The name of method used to surface relevant data for a given calendar event.
     */
    public GeneratedAttachment withStrategyName(EventStrategyName strategyName) {
        Utils.checkNotNull(strategyName, "strategyName");
        this.strategyName = Optional.ofNullable(strategyName);
        return this;
    }

    /**
     * The name of method used to surface relevant data for a given calendar event.
     */
    public GeneratedAttachment withStrategyName(Optional<? extends EventStrategyName> strategyName) {
        Utils.checkNotNull(strategyName, "strategyName");
        this.strategyName = strategyName;
        return this;
    }

    public GeneratedAttachment withDocuments(List<Document> documents) {
        Utils.checkNotNull(documents, "documents");
        this.documents = Optional.ofNullable(documents);
        return this;
    }

    public GeneratedAttachment withDocuments(Optional<? extends List<Document>> documents) {
        Utils.checkNotNull(documents, "documents");
        this.documents = documents;
        return this;
    }

    public GeneratedAttachment withPerson(Person person) {
        Utils.checkNotNull(person, "person");
        this.person = Optional.ofNullable(person);
        return this;
    }

    public GeneratedAttachment withPerson(Optional<? extends Person> person) {
        Utils.checkNotNull(person, "person");
        this.person = person;
        return this;
    }

    public GeneratedAttachment withCustomer(Customer customer) {
        Utils.checkNotNull(customer, "customer");
        this.customer = Optional.ofNullable(customer);
        return this;
    }

    public GeneratedAttachment withCustomer(Optional<? extends Customer> customer) {
        Utils.checkNotNull(customer, "customer");
        this.customer = customer;
        return this;
    }

    /**
     * A list of links to external sources outside of Glean.
     */
    public GeneratedAttachment withExternalLinks(List<StructuredLink> externalLinks) {
        Utils.checkNotNull(externalLinks, "externalLinks");
        this.externalLinks = Optional.ofNullable(externalLinks);
        return this;
    }

    /**
     * A list of links to external sources outside of Glean.
     */
    public GeneratedAttachment withExternalLinks(Optional<? extends List<StructuredLink>> externalLinks) {
        Utils.checkNotNull(externalLinks, "externalLinks");
        this.externalLinks = externalLinks;
        return this;
    }

    public GeneratedAttachment withContent(List<GeneratedAttachmentContent> content) {
        Utils.checkNotNull(content, "content");
        this.content = Optional.ofNullable(content);
        return this;
    }

    public GeneratedAttachment withContent(Optional<? extends List<GeneratedAttachmentContent>> content) {
        Utils.checkNotNull(content, "content");
        this.content = content;
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
        GeneratedAttachment other = (GeneratedAttachment) o;
        return 
            Objects.deepEquals(this.strategyName, other.strategyName) &&
            Objects.deepEquals(this.documents, other.documents) &&
            Objects.deepEquals(this.person, other.person) &&
            Objects.deepEquals(this.customer, other.customer) &&
            Objects.deepEquals(this.externalLinks, other.externalLinks) &&
            Objects.deepEquals(this.content, other.content);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            strategyName,
            documents,
            person,
            customer,
            externalLinks,
            content);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GeneratedAttachment.class,
                "strategyName", strategyName,
                "documents", documents,
                "person", person,
                "customer", customer,
                "externalLinks", externalLinks,
                "content", content);
    }
    
    public final static class Builder {
 
        private Optional<? extends EventStrategyName> strategyName = Optional.empty();
 
        private Optional<? extends List<Document>> documents = Optional.empty();
 
        private Optional<? extends Person> person = Optional.empty();
 
        private Optional<? extends Customer> customer = Optional.empty();
 
        private Optional<? extends List<StructuredLink>> externalLinks = Optional.empty();
 
        private Optional<? extends List<GeneratedAttachmentContent>> content = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The name of method used to surface relevant data for a given calendar event.
         */
        public Builder strategyName(EventStrategyName strategyName) {
            Utils.checkNotNull(strategyName, "strategyName");
            this.strategyName = Optional.ofNullable(strategyName);
            return this;
        }

        /**
         * The name of method used to surface relevant data for a given calendar event.
         */
        public Builder strategyName(Optional<? extends EventStrategyName> strategyName) {
            Utils.checkNotNull(strategyName, "strategyName");
            this.strategyName = strategyName;
            return this;
        }

        public Builder documents(List<Document> documents) {
            Utils.checkNotNull(documents, "documents");
            this.documents = Optional.ofNullable(documents);
            return this;
        }

        public Builder documents(Optional<? extends List<Document>> documents) {
            Utils.checkNotNull(documents, "documents");
            this.documents = documents;
            return this;
        }

        public Builder person(Person person) {
            Utils.checkNotNull(person, "person");
            this.person = Optional.ofNullable(person);
            return this;
        }

        public Builder person(Optional<? extends Person> person) {
            Utils.checkNotNull(person, "person");
            this.person = person;
            return this;
        }

        public Builder customer(Customer customer) {
            Utils.checkNotNull(customer, "customer");
            this.customer = Optional.ofNullable(customer);
            return this;
        }

        public Builder customer(Optional<? extends Customer> customer) {
            Utils.checkNotNull(customer, "customer");
            this.customer = customer;
            return this;
        }

        /**
         * A list of links to external sources outside of Glean.
         */
        public Builder externalLinks(List<StructuredLink> externalLinks) {
            Utils.checkNotNull(externalLinks, "externalLinks");
            this.externalLinks = Optional.ofNullable(externalLinks);
            return this;
        }

        /**
         * A list of links to external sources outside of Glean.
         */
        public Builder externalLinks(Optional<? extends List<StructuredLink>> externalLinks) {
            Utils.checkNotNull(externalLinks, "externalLinks");
            this.externalLinks = externalLinks;
            return this;
        }

        public Builder content(List<GeneratedAttachmentContent> content) {
            Utils.checkNotNull(content, "content");
            this.content = Optional.ofNullable(content);
            return this;
        }

        public Builder content(Optional<? extends List<GeneratedAttachmentContent>> content) {
            Utils.checkNotNull(content, "content");
            this.content = content;
            return this;
        }
        
        public GeneratedAttachment build() {
            return new GeneratedAttachment(
                strategyName,
                documents,
                person,
                customer,
                externalLinks,
                content);
        }
    }
}
