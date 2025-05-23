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

public class FeedEntry {

    /**
     * optional ID associated with a single feed entry (displayable_list_id)
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("entryId")
    private Optional<String> entryId;

    /**
     * Title for the result. Can be document title, event title and so on.
     */
    @JsonProperty("title")
    private String title;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("thumbnail")
    private Optional<? extends Thumbnail> thumbnail;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("createdBy")
    private Optional<? extends Person> createdBy;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("uiConfig")
    private Optional<? extends UiConfig> uiConfig;

    /**
     * Type of the justification.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("justificationType")
    private Optional<? extends JustificationType> justificationType;

    /**
     * Server side generated justification string if server provides one.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("justification")
    private Optional<String> justification;

    /**
     * An opaque token that represents this particular feed entry in this particular response. To be used for /feedback reporting.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("trackingToken")
    private Optional<String> trackingToken;

    /**
     * View URL for the entry if based on links that are not documents in Glean.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("viewUrl")
    private Optional<String> viewUrl;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("document")
    private Optional<? extends Document> document;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("event")
    private Optional<? extends CalendarEvent> event;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("announcement")
    private Optional<? extends Announcement> announcement;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("collection")
    private Optional<? extends Collection> collection;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("collectionItem")
    private Optional<? extends CollectionItem> collectionItem;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("person")
    private Optional<? extends Person> person;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("app")
    private Optional<? extends AppResult> app;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("promptTemplate")
    private Optional<? extends PromptTemplateResult> promptTemplate;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("workflow")
    private Optional<? extends WorkflowResult> workflow;

    /**
     * List of activity where each activity has user, action, timestamp.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("activities")
    private Optional<? extends List<UserActivity>> activities;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("documentVisitorCount")
    private Optional<? extends CountInfo> documentVisitorCount;

    @JsonCreator
    public FeedEntry(
            @JsonProperty("entryId") Optional<String> entryId,
            @JsonProperty("title") String title,
            @JsonProperty("thumbnail") Optional<? extends Thumbnail> thumbnail,
            @JsonProperty("createdBy") Optional<? extends Person> createdBy,
            @JsonProperty("uiConfig") Optional<? extends UiConfig> uiConfig,
            @JsonProperty("justificationType") Optional<? extends JustificationType> justificationType,
            @JsonProperty("justification") Optional<String> justification,
            @JsonProperty("trackingToken") Optional<String> trackingToken,
            @JsonProperty("viewUrl") Optional<String> viewUrl,
            @JsonProperty("document") Optional<? extends Document> document,
            @JsonProperty("event") Optional<? extends CalendarEvent> event,
            @JsonProperty("announcement") Optional<? extends Announcement> announcement,
            @JsonProperty("collection") Optional<? extends Collection> collection,
            @JsonProperty("collectionItem") Optional<? extends CollectionItem> collectionItem,
            @JsonProperty("person") Optional<? extends Person> person,
            @JsonProperty("app") Optional<? extends AppResult> app,
            @JsonProperty("promptTemplate") Optional<? extends PromptTemplateResult> promptTemplate,
            @JsonProperty("workflow") Optional<? extends WorkflowResult> workflow,
            @JsonProperty("activities") Optional<? extends List<UserActivity>> activities,
            @JsonProperty("documentVisitorCount") Optional<? extends CountInfo> documentVisitorCount) {
        Utils.checkNotNull(entryId, "entryId");
        Utils.checkNotNull(title, "title");
        Utils.checkNotNull(thumbnail, "thumbnail");
        Utils.checkNotNull(createdBy, "createdBy");
        Utils.checkNotNull(uiConfig, "uiConfig");
        Utils.checkNotNull(justificationType, "justificationType");
        Utils.checkNotNull(justification, "justification");
        Utils.checkNotNull(trackingToken, "trackingToken");
        Utils.checkNotNull(viewUrl, "viewUrl");
        Utils.checkNotNull(document, "document");
        Utils.checkNotNull(event, "event");
        Utils.checkNotNull(announcement, "announcement");
        Utils.checkNotNull(collection, "collection");
        Utils.checkNotNull(collectionItem, "collectionItem");
        Utils.checkNotNull(person, "person");
        Utils.checkNotNull(app, "app");
        Utils.checkNotNull(promptTemplate, "promptTemplate");
        Utils.checkNotNull(workflow, "workflow");
        Utils.checkNotNull(activities, "activities");
        Utils.checkNotNull(documentVisitorCount, "documentVisitorCount");
        this.entryId = entryId;
        this.title = title;
        this.thumbnail = thumbnail;
        this.createdBy = createdBy;
        this.uiConfig = uiConfig;
        this.justificationType = justificationType;
        this.justification = justification;
        this.trackingToken = trackingToken;
        this.viewUrl = viewUrl;
        this.document = document;
        this.event = event;
        this.announcement = announcement;
        this.collection = collection;
        this.collectionItem = collectionItem;
        this.person = person;
        this.app = app;
        this.promptTemplate = promptTemplate;
        this.workflow = workflow;
        this.activities = activities;
        this.documentVisitorCount = documentVisitorCount;
    }
    
    public FeedEntry(
            String title) {
        this(Optional.empty(), title, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * optional ID associated with a single feed entry (displayable_list_id)
     */
    @JsonIgnore
    public Optional<String> entryId() {
        return entryId;
    }

    /**
     * Title for the result. Can be document title, event title and so on.
     */
    @JsonIgnore
    public String title() {
        return title;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Thumbnail> thumbnail() {
        return (Optional<Thumbnail>) thumbnail;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Person> createdBy() {
        return (Optional<Person>) createdBy;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<UiConfig> uiConfig() {
        return (Optional<UiConfig>) uiConfig;
    }

    /**
     * Type of the justification.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<JustificationType> justificationType() {
        return (Optional<JustificationType>) justificationType;
    }

    /**
     * Server side generated justification string if server provides one.
     */
    @JsonIgnore
    public Optional<String> justification() {
        return justification;
    }

    /**
     * An opaque token that represents this particular feed entry in this particular response. To be used for /feedback reporting.
     */
    @JsonIgnore
    public Optional<String> trackingToken() {
        return trackingToken;
    }

    /**
     * View URL for the entry if based on links that are not documents in Glean.
     */
    @JsonIgnore
    public Optional<String> viewUrl() {
        return viewUrl;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Document> document() {
        return (Optional<Document>) document;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CalendarEvent> event() {
        return (Optional<CalendarEvent>) event;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Announcement> announcement() {
        return (Optional<Announcement>) announcement;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Collection> collection() {
        return (Optional<Collection>) collection;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CollectionItem> collectionItem() {
        return (Optional<CollectionItem>) collectionItem;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Person> person() {
        return (Optional<Person>) person;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<AppResult> app() {
        return (Optional<AppResult>) app;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<PromptTemplateResult> promptTemplate() {
        return (Optional<PromptTemplateResult>) promptTemplate;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<WorkflowResult> workflow() {
        return (Optional<WorkflowResult>) workflow;
    }

    /**
     * List of activity where each activity has user, action, timestamp.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<UserActivity>> activities() {
        return (Optional<List<UserActivity>>) activities;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CountInfo> documentVisitorCount() {
        return (Optional<CountInfo>) documentVisitorCount;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * optional ID associated with a single feed entry (displayable_list_id)
     */
    public FeedEntry withEntryId(String entryId) {
        Utils.checkNotNull(entryId, "entryId");
        this.entryId = Optional.ofNullable(entryId);
        return this;
    }

    /**
     * optional ID associated with a single feed entry (displayable_list_id)
     */
    public FeedEntry withEntryId(Optional<String> entryId) {
        Utils.checkNotNull(entryId, "entryId");
        this.entryId = entryId;
        return this;
    }

    /**
     * Title for the result. Can be document title, event title and so on.
     */
    public FeedEntry withTitle(String title) {
        Utils.checkNotNull(title, "title");
        this.title = title;
        return this;
    }

    public FeedEntry withThumbnail(Thumbnail thumbnail) {
        Utils.checkNotNull(thumbnail, "thumbnail");
        this.thumbnail = Optional.ofNullable(thumbnail);
        return this;
    }

    public FeedEntry withThumbnail(Optional<? extends Thumbnail> thumbnail) {
        Utils.checkNotNull(thumbnail, "thumbnail");
        this.thumbnail = thumbnail;
        return this;
    }

    public FeedEntry withCreatedBy(Person createdBy) {
        Utils.checkNotNull(createdBy, "createdBy");
        this.createdBy = Optional.ofNullable(createdBy);
        return this;
    }

    public FeedEntry withCreatedBy(Optional<? extends Person> createdBy) {
        Utils.checkNotNull(createdBy, "createdBy");
        this.createdBy = createdBy;
        return this;
    }

    public FeedEntry withUiConfig(UiConfig uiConfig) {
        Utils.checkNotNull(uiConfig, "uiConfig");
        this.uiConfig = Optional.ofNullable(uiConfig);
        return this;
    }

    public FeedEntry withUiConfig(Optional<? extends UiConfig> uiConfig) {
        Utils.checkNotNull(uiConfig, "uiConfig");
        this.uiConfig = uiConfig;
        return this;
    }

    /**
     * Type of the justification.
     */
    public FeedEntry withJustificationType(JustificationType justificationType) {
        Utils.checkNotNull(justificationType, "justificationType");
        this.justificationType = Optional.ofNullable(justificationType);
        return this;
    }

    /**
     * Type of the justification.
     */
    public FeedEntry withJustificationType(Optional<? extends JustificationType> justificationType) {
        Utils.checkNotNull(justificationType, "justificationType");
        this.justificationType = justificationType;
        return this;
    }

    /**
     * Server side generated justification string if server provides one.
     */
    public FeedEntry withJustification(String justification) {
        Utils.checkNotNull(justification, "justification");
        this.justification = Optional.ofNullable(justification);
        return this;
    }

    /**
     * Server side generated justification string if server provides one.
     */
    public FeedEntry withJustification(Optional<String> justification) {
        Utils.checkNotNull(justification, "justification");
        this.justification = justification;
        return this;
    }

    /**
     * An opaque token that represents this particular feed entry in this particular response. To be used for /feedback reporting.
     */
    public FeedEntry withTrackingToken(String trackingToken) {
        Utils.checkNotNull(trackingToken, "trackingToken");
        this.trackingToken = Optional.ofNullable(trackingToken);
        return this;
    }

    /**
     * An opaque token that represents this particular feed entry in this particular response. To be used for /feedback reporting.
     */
    public FeedEntry withTrackingToken(Optional<String> trackingToken) {
        Utils.checkNotNull(trackingToken, "trackingToken");
        this.trackingToken = trackingToken;
        return this;
    }

    /**
     * View URL for the entry if based on links that are not documents in Glean.
     */
    public FeedEntry withViewUrl(String viewUrl) {
        Utils.checkNotNull(viewUrl, "viewUrl");
        this.viewUrl = Optional.ofNullable(viewUrl);
        return this;
    }

    /**
     * View URL for the entry if based on links that are not documents in Glean.
     */
    public FeedEntry withViewUrl(Optional<String> viewUrl) {
        Utils.checkNotNull(viewUrl, "viewUrl");
        this.viewUrl = viewUrl;
        return this;
    }

    public FeedEntry withDocument(Document document) {
        Utils.checkNotNull(document, "document");
        this.document = Optional.ofNullable(document);
        return this;
    }

    public FeedEntry withDocument(Optional<? extends Document> document) {
        Utils.checkNotNull(document, "document");
        this.document = document;
        return this;
    }

    public FeedEntry withEvent(CalendarEvent event) {
        Utils.checkNotNull(event, "event");
        this.event = Optional.ofNullable(event);
        return this;
    }

    public FeedEntry withEvent(Optional<? extends CalendarEvent> event) {
        Utils.checkNotNull(event, "event");
        this.event = event;
        return this;
    }

    public FeedEntry withAnnouncement(Announcement announcement) {
        Utils.checkNotNull(announcement, "announcement");
        this.announcement = Optional.ofNullable(announcement);
        return this;
    }

    public FeedEntry withAnnouncement(Optional<? extends Announcement> announcement) {
        Utils.checkNotNull(announcement, "announcement");
        this.announcement = announcement;
        return this;
    }

    public FeedEntry withCollection(Collection collection) {
        Utils.checkNotNull(collection, "collection");
        this.collection = Optional.ofNullable(collection);
        return this;
    }

    public FeedEntry withCollection(Optional<? extends Collection> collection) {
        Utils.checkNotNull(collection, "collection");
        this.collection = collection;
        return this;
    }

    public FeedEntry withCollectionItem(CollectionItem collectionItem) {
        Utils.checkNotNull(collectionItem, "collectionItem");
        this.collectionItem = Optional.ofNullable(collectionItem);
        return this;
    }

    public FeedEntry withCollectionItem(Optional<? extends CollectionItem> collectionItem) {
        Utils.checkNotNull(collectionItem, "collectionItem");
        this.collectionItem = collectionItem;
        return this;
    }

    public FeedEntry withPerson(Person person) {
        Utils.checkNotNull(person, "person");
        this.person = Optional.ofNullable(person);
        return this;
    }

    public FeedEntry withPerson(Optional<? extends Person> person) {
        Utils.checkNotNull(person, "person");
        this.person = person;
        return this;
    }

    public FeedEntry withApp(AppResult app) {
        Utils.checkNotNull(app, "app");
        this.app = Optional.ofNullable(app);
        return this;
    }

    public FeedEntry withApp(Optional<? extends AppResult> app) {
        Utils.checkNotNull(app, "app");
        this.app = app;
        return this;
    }

    public FeedEntry withPromptTemplate(PromptTemplateResult promptTemplate) {
        Utils.checkNotNull(promptTemplate, "promptTemplate");
        this.promptTemplate = Optional.ofNullable(promptTemplate);
        return this;
    }

    public FeedEntry withPromptTemplate(Optional<? extends PromptTemplateResult> promptTemplate) {
        Utils.checkNotNull(promptTemplate, "promptTemplate");
        this.promptTemplate = promptTemplate;
        return this;
    }

    public FeedEntry withWorkflow(WorkflowResult workflow) {
        Utils.checkNotNull(workflow, "workflow");
        this.workflow = Optional.ofNullable(workflow);
        return this;
    }

    public FeedEntry withWorkflow(Optional<? extends WorkflowResult> workflow) {
        Utils.checkNotNull(workflow, "workflow");
        this.workflow = workflow;
        return this;
    }

    /**
     * List of activity where each activity has user, action, timestamp.
     */
    public FeedEntry withActivities(List<UserActivity> activities) {
        Utils.checkNotNull(activities, "activities");
        this.activities = Optional.ofNullable(activities);
        return this;
    }

    /**
     * List of activity where each activity has user, action, timestamp.
     */
    public FeedEntry withActivities(Optional<? extends List<UserActivity>> activities) {
        Utils.checkNotNull(activities, "activities");
        this.activities = activities;
        return this;
    }

    public FeedEntry withDocumentVisitorCount(CountInfo documentVisitorCount) {
        Utils.checkNotNull(documentVisitorCount, "documentVisitorCount");
        this.documentVisitorCount = Optional.ofNullable(documentVisitorCount);
        return this;
    }

    public FeedEntry withDocumentVisitorCount(Optional<? extends CountInfo> documentVisitorCount) {
        Utils.checkNotNull(documentVisitorCount, "documentVisitorCount");
        this.documentVisitorCount = documentVisitorCount;
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
        FeedEntry other = (FeedEntry) o;
        return 
            Objects.deepEquals(this.entryId, other.entryId) &&
            Objects.deepEquals(this.title, other.title) &&
            Objects.deepEquals(this.thumbnail, other.thumbnail) &&
            Objects.deepEquals(this.createdBy, other.createdBy) &&
            Objects.deepEquals(this.uiConfig, other.uiConfig) &&
            Objects.deepEquals(this.justificationType, other.justificationType) &&
            Objects.deepEquals(this.justification, other.justification) &&
            Objects.deepEquals(this.trackingToken, other.trackingToken) &&
            Objects.deepEquals(this.viewUrl, other.viewUrl) &&
            Objects.deepEquals(this.document, other.document) &&
            Objects.deepEquals(this.event, other.event) &&
            Objects.deepEquals(this.announcement, other.announcement) &&
            Objects.deepEquals(this.collection, other.collection) &&
            Objects.deepEquals(this.collectionItem, other.collectionItem) &&
            Objects.deepEquals(this.person, other.person) &&
            Objects.deepEquals(this.app, other.app) &&
            Objects.deepEquals(this.promptTemplate, other.promptTemplate) &&
            Objects.deepEquals(this.workflow, other.workflow) &&
            Objects.deepEquals(this.activities, other.activities) &&
            Objects.deepEquals(this.documentVisitorCount, other.documentVisitorCount);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            entryId,
            title,
            thumbnail,
            createdBy,
            uiConfig,
            justificationType,
            justification,
            trackingToken,
            viewUrl,
            document,
            event,
            announcement,
            collection,
            collectionItem,
            person,
            app,
            promptTemplate,
            workflow,
            activities,
            documentVisitorCount);
    }
    
    @Override
    public String toString() {
        return Utils.toString(FeedEntry.class,
                "entryId", entryId,
                "title", title,
                "thumbnail", thumbnail,
                "createdBy", createdBy,
                "uiConfig", uiConfig,
                "justificationType", justificationType,
                "justification", justification,
                "trackingToken", trackingToken,
                "viewUrl", viewUrl,
                "document", document,
                "event", event,
                "announcement", announcement,
                "collection", collection,
                "collectionItem", collectionItem,
                "person", person,
                "app", app,
                "promptTemplate", promptTemplate,
                "workflow", workflow,
                "activities", activities,
                "documentVisitorCount", documentVisitorCount);
    }
    
    public final static class Builder {
 
        private Optional<String> entryId = Optional.empty();
 
        private String title;
 
        private Optional<? extends Thumbnail> thumbnail = Optional.empty();
 
        private Optional<? extends Person> createdBy = Optional.empty();
 
        private Optional<? extends UiConfig> uiConfig = Optional.empty();
 
        private Optional<? extends JustificationType> justificationType = Optional.empty();
 
        private Optional<String> justification = Optional.empty();
 
        private Optional<String> trackingToken = Optional.empty();
 
        private Optional<String> viewUrl = Optional.empty();
 
        private Optional<? extends Document> document = Optional.empty();
 
        private Optional<? extends CalendarEvent> event = Optional.empty();
 
        private Optional<? extends Announcement> announcement = Optional.empty();
 
        private Optional<? extends Collection> collection = Optional.empty();
 
        private Optional<? extends CollectionItem> collectionItem = Optional.empty();
 
        private Optional<? extends Person> person = Optional.empty();
 
        private Optional<? extends AppResult> app = Optional.empty();
 
        private Optional<? extends PromptTemplateResult> promptTemplate = Optional.empty();
 
        private Optional<? extends WorkflowResult> workflow = Optional.empty();
 
        private Optional<? extends List<UserActivity>> activities = Optional.empty();
 
        private Optional<? extends CountInfo> documentVisitorCount = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * optional ID associated with a single feed entry (displayable_list_id)
         */
        public Builder entryId(String entryId) {
            Utils.checkNotNull(entryId, "entryId");
            this.entryId = Optional.ofNullable(entryId);
            return this;
        }

        /**
         * optional ID associated with a single feed entry (displayable_list_id)
         */
        public Builder entryId(Optional<String> entryId) {
            Utils.checkNotNull(entryId, "entryId");
            this.entryId = entryId;
            return this;
        }

        /**
         * Title for the result. Can be document title, event title and so on.
         */
        public Builder title(String title) {
            Utils.checkNotNull(title, "title");
            this.title = title;
            return this;
        }

        public Builder thumbnail(Thumbnail thumbnail) {
            Utils.checkNotNull(thumbnail, "thumbnail");
            this.thumbnail = Optional.ofNullable(thumbnail);
            return this;
        }

        public Builder thumbnail(Optional<? extends Thumbnail> thumbnail) {
            Utils.checkNotNull(thumbnail, "thumbnail");
            this.thumbnail = thumbnail;
            return this;
        }

        public Builder createdBy(Person createdBy) {
            Utils.checkNotNull(createdBy, "createdBy");
            this.createdBy = Optional.ofNullable(createdBy);
            return this;
        }

        public Builder createdBy(Optional<? extends Person> createdBy) {
            Utils.checkNotNull(createdBy, "createdBy");
            this.createdBy = createdBy;
            return this;
        }

        public Builder uiConfig(UiConfig uiConfig) {
            Utils.checkNotNull(uiConfig, "uiConfig");
            this.uiConfig = Optional.ofNullable(uiConfig);
            return this;
        }

        public Builder uiConfig(Optional<? extends UiConfig> uiConfig) {
            Utils.checkNotNull(uiConfig, "uiConfig");
            this.uiConfig = uiConfig;
            return this;
        }

        /**
         * Type of the justification.
         */
        public Builder justificationType(JustificationType justificationType) {
            Utils.checkNotNull(justificationType, "justificationType");
            this.justificationType = Optional.ofNullable(justificationType);
            return this;
        }

        /**
         * Type of the justification.
         */
        public Builder justificationType(Optional<? extends JustificationType> justificationType) {
            Utils.checkNotNull(justificationType, "justificationType");
            this.justificationType = justificationType;
            return this;
        }

        /**
         * Server side generated justification string if server provides one.
         */
        public Builder justification(String justification) {
            Utils.checkNotNull(justification, "justification");
            this.justification = Optional.ofNullable(justification);
            return this;
        }

        /**
         * Server side generated justification string if server provides one.
         */
        public Builder justification(Optional<String> justification) {
            Utils.checkNotNull(justification, "justification");
            this.justification = justification;
            return this;
        }

        /**
         * An opaque token that represents this particular feed entry in this particular response. To be used for /feedback reporting.
         */
        public Builder trackingToken(String trackingToken) {
            Utils.checkNotNull(trackingToken, "trackingToken");
            this.trackingToken = Optional.ofNullable(trackingToken);
            return this;
        }

        /**
         * An opaque token that represents this particular feed entry in this particular response. To be used for /feedback reporting.
         */
        public Builder trackingToken(Optional<String> trackingToken) {
            Utils.checkNotNull(trackingToken, "trackingToken");
            this.trackingToken = trackingToken;
            return this;
        }

        /**
         * View URL for the entry if based on links that are not documents in Glean.
         */
        public Builder viewUrl(String viewUrl) {
            Utils.checkNotNull(viewUrl, "viewUrl");
            this.viewUrl = Optional.ofNullable(viewUrl);
            return this;
        }

        /**
         * View URL for the entry if based on links that are not documents in Glean.
         */
        public Builder viewUrl(Optional<String> viewUrl) {
            Utils.checkNotNull(viewUrl, "viewUrl");
            this.viewUrl = viewUrl;
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

        public Builder event(CalendarEvent event) {
            Utils.checkNotNull(event, "event");
            this.event = Optional.ofNullable(event);
            return this;
        }

        public Builder event(Optional<? extends CalendarEvent> event) {
            Utils.checkNotNull(event, "event");
            this.event = event;
            return this;
        }

        public Builder announcement(Announcement announcement) {
            Utils.checkNotNull(announcement, "announcement");
            this.announcement = Optional.ofNullable(announcement);
            return this;
        }

        public Builder announcement(Optional<? extends Announcement> announcement) {
            Utils.checkNotNull(announcement, "announcement");
            this.announcement = announcement;
            return this;
        }

        public Builder collection(Collection collection) {
            Utils.checkNotNull(collection, "collection");
            this.collection = Optional.ofNullable(collection);
            return this;
        }

        public Builder collection(Optional<? extends Collection> collection) {
            Utils.checkNotNull(collection, "collection");
            this.collection = collection;
            return this;
        }

        public Builder collectionItem(CollectionItem collectionItem) {
            Utils.checkNotNull(collectionItem, "collectionItem");
            this.collectionItem = Optional.ofNullable(collectionItem);
            return this;
        }

        public Builder collectionItem(Optional<? extends CollectionItem> collectionItem) {
            Utils.checkNotNull(collectionItem, "collectionItem");
            this.collectionItem = collectionItem;
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

        public Builder app(AppResult app) {
            Utils.checkNotNull(app, "app");
            this.app = Optional.ofNullable(app);
            return this;
        }

        public Builder app(Optional<? extends AppResult> app) {
            Utils.checkNotNull(app, "app");
            this.app = app;
            return this;
        }

        public Builder promptTemplate(PromptTemplateResult promptTemplate) {
            Utils.checkNotNull(promptTemplate, "promptTemplate");
            this.promptTemplate = Optional.ofNullable(promptTemplate);
            return this;
        }

        public Builder promptTemplate(Optional<? extends PromptTemplateResult> promptTemplate) {
            Utils.checkNotNull(promptTemplate, "promptTemplate");
            this.promptTemplate = promptTemplate;
            return this;
        }

        public Builder workflow(WorkflowResult workflow) {
            Utils.checkNotNull(workflow, "workflow");
            this.workflow = Optional.ofNullable(workflow);
            return this;
        }

        public Builder workflow(Optional<? extends WorkflowResult> workflow) {
            Utils.checkNotNull(workflow, "workflow");
            this.workflow = workflow;
            return this;
        }

        /**
         * List of activity where each activity has user, action, timestamp.
         */
        public Builder activities(List<UserActivity> activities) {
            Utils.checkNotNull(activities, "activities");
            this.activities = Optional.ofNullable(activities);
            return this;
        }

        /**
         * List of activity where each activity has user, action, timestamp.
         */
        public Builder activities(Optional<? extends List<UserActivity>> activities) {
            Utils.checkNotNull(activities, "activities");
            this.activities = activities;
            return this;
        }

        public Builder documentVisitorCount(CountInfo documentVisitorCount) {
            Utils.checkNotNull(documentVisitorCount, "documentVisitorCount");
            this.documentVisitorCount = Optional.ofNullable(documentVisitorCount);
            return this;
        }

        public Builder documentVisitorCount(Optional<? extends CountInfo> documentVisitorCount) {
            Utils.checkNotNull(documentVisitorCount, "documentVisitorCount");
            this.documentVisitorCount = documentVisitorCount;
            return this;
        }
        
        public FeedEntry build() {
            return new FeedEntry(
                entryId,
                title,
                thumbnail,
                createdBy,
                uiConfig,
                justificationType,
                justification,
                trackingToken,
                viewUrl,
                document,
                event,
                announcement,
                collection,
                collectionItem,
                person,
                app,
                promptTemplate,
                workflow,
                activities,
                documentVisitorCount);
        }
    }
}
