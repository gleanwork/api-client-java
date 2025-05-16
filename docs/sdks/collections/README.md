# Collections
(*client().collections()*)

## Overview

### Available Operations

* [addItems](#additems) - Add Collection item
* [create](#create) - Create Collection
* [delete](#delete) - Delete Collection
* [deleteItem](#deleteitem) - Delete Collection item
* [update](#update) - Update Collection
* [updateItem](#updateitem) - Update Collection item
* [retrieve](#retrieve) - Read Collection
* [list](#list) - List Collections

## addItems

Add items to a Collection.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.AddCollectionItemsRequest;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.AddcollectionitemsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        AddCollectionItemsRequest req = AddCollectionItemsRequest.builder()
                .collectionId(7742.68)
                .build();

        AddcollectionitemsResponse res = sdk.client().collections().addItems()
                .request(req)
                .call();

        if (res.addCollectionItemsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `request`                                                                     | [AddCollectionItemsRequest](../../models/shared/AddCollectionItemsRequest.md) | :heavy_check_mark:                                                            | The request object to use for the request.                                    |

### Response

**[AddcollectionitemsResponse](../../models/operations/AddcollectionitemsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## create

Create a publicly visible (empty) Collection of documents.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.errors.CollectionError;
import com.glean.api_client.glean_api_client.models.operations.CreatecollectionResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws CollectionError, Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        CreateCollectionRequest req = CreateCollectionRequest.builder()
                .name("<value>")
                .addedRoles(List.of(
                    UserRoleSpecification.builder()
                        .role(UserRole.VERIFIER)
                        .person(Person.builder()
                            .name("George Clooney")
                            .obfuscatedId("abc123")
                            .relatedDocuments(List.of(
                                RelatedDocuments.builder()
                                    .querySuggestion(QuerySuggestion.builder()
                                        .query("app:github type:pull author:mortimer")
                                        .searchProviderInfo(SearchProviderInfo.builder()
                                            .name("Google")
                                            .searchLinkUrlTemplate("https://www.google.com/search?q={query}&hl=en")
                                            .build())
                                        .label("Mortimer's PRs")
                                        .datasource("github")
                                        .requestOptions(SearchRequestOptions.builder()
                                            .facetBucketSize(977077L)
                                            .datasourceFilter("JIRA")
                                            .datasourcesFilter(List.of(
                                                "JIRA"))
                                            .queryOverridesFacetFilters(true)
                                            .facetFilters(List.of(
                                                FacetFilter.builder()
                                                    .fieldName("type")
                                                    .values(List.of(
                                                        FacetFilterValue.builder()
                                                            .value("Spreadsheet")
                                                            .relationType(RelationType.EQUALS)
                                                            .build(),
                                                        FacetFilterValue.builder()
                                                            .value("Presentation")
                                                            .relationType(RelationType.EQUALS)
                                                            .build()))
                                                    .build()))
                                            .facetFilterSets(List.of(
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build(),
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build(),
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build()))
                                            .authTokens(List.of(
                                                AuthToken.builder()
                                                    .accessToken("123abc")
                                                    .datasource("gmail")
                                                    .scope("email profile https://www.googleapis.com/auth/gmail.readonly")
                                                    .tokenType("Bearer")
                                                    .authUser("1")
                                                    .build()))
                                            .build())
                                        .ranges(List.of(
                                            TextRange.builder()
                                                .startIndex(86650L)
                                                .document(Document.builder()
                                                    .metadata(DocumentMetadata.builder()
                                                        .datasource("datasource")
                                                        .objectType("Feature Request")
                                                        .container("container")
                                                        .parentId("JIRA_EN-1337")
                                                        .mimeType("mimeType")
                                                        .documentId("documentId")
                                                        .createTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                                        .updateTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                                        .components(List.of(
                                                            "Backend",
                                                            "Networking"))
                                                        .status("[\"Done\"]")
                                                        .pins(List.of(
                                                            PinDocument.builder()
                                                                .documentId("<id>")
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .build()))
                                                        .collections(List.of(
                                                            Collection.builder()
                                                                .name("<value>")
                                                                .description("meaty dial elegantly while react")
                                                                .id(854591L)
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .items(List.of(
                                                                    CollectionItem.builder()
                                                                        .collectionId(697663L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(697663L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(697663L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build()))
                                                                .build()))
                                                        .interactions(DocumentInteractions.builder()
                                                            .reacts(List.of(
                                                                Reaction.builder()
                                                                    .build(),
                                                                Reaction.builder()
                                                                    .build()))
                                                            .shares(List.of(
                                                                Share.builder()
                                                                    .numDaysAgo(365776L)
                                                                    .build(),
                                                                Share.builder()
                                                                    .numDaysAgo(365776L)
                                                                    .build(),
                                                                Share.builder()
                                                                    .numDaysAgo(365776L)
                                                                    .build()))
                                                            .build())
                                                        .verification(Verification.builder()
                                                            .state(State.DEPRECATED)
                                                            .metadata(VerificationMetadata.builder()
                                                                .reminders(List.of(
                                                                    Reminder.builder()
                                                                        .assignee(Person.builder()
                                                                            .name("George Clooney")
                                                                            .obfuscatedId("abc123")
                                                                            .build())
                                                                        .remindAt(268615L)
                                                                        .build()))
                                                                .lastReminder(Reminder.builder()
                                                                    .assignee(Person.builder()
                                                                        .name("George Clooney")
                                                                        .obfuscatedId("abc123")
                                                                        .build())
                                                                    .remindAt(423482L)
                                                                    .build())
                                                                .build())
                                                            .build())
                                                        .shortcuts(List.of(
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build(),
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build(),
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build()))
                                                        .customData(Map.ofEntries(
                                                            Map.entry("someCustomField", CustomDataValue.builder()
                                                                .build())))
                                                        .build())
                                                    .build())
                                                .build()))
                                        .inputDetails(SearchRequestInputDetails.builder()
                                            .hasCopyPaste(true)
                                            .build())
                                        .build())
                                    .results(List.of(
                                        SearchResult.builder()
                                            .url("https://example.com/foo/bar")
                                            .title("title")
                                            .nativeAppUrl("slack://foo/bar")
                                            .snippets(List.of(
                                                SearchResultSnippet.builder()
                                                    .snippet("snippet")
                                                    .mimeType("mimeType")
                                                    .build()))
                                            .build()))
                                    .build(),
                                RelatedDocuments.builder()
                                    .querySuggestion(QuerySuggestion.builder()
                                        .query("app:github type:pull author:mortimer")
                                        .searchProviderInfo(SearchProviderInfo.builder()
                                            .name("Google")
                                            .searchLinkUrlTemplate("https://www.google.com/search?q={query}&hl=en")
                                            .build())
                                        .label("Mortimer's PRs")
                                        .datasource("github")
                                        .requestOptions(SearchRequestOptions.builder()
                                            .facetBucketSize(977077L)
                                            .datasourceFilter("JIRA")
                                            .datasourcesFilter(List.of(
                                                "JIRA"))
                                            .queryOverridesFacetFilters(true)
                                            .facetFilters(List.of(
                                                FacetFilter.builder()
                                                    .fieldName("type")
                                                    .values(List.of(
                                                        FacetFilterValue.builder()
                                                            .value("Spreadsheet")
                                                            .relationType(RelationType.EQUALS)
                                                            .build(),
                                                        FacetFilterValue.builder()
                                                            .value("Presentation")
                                                            .relationType(RelationType.EQUALS)
                                                            .build()))
                                                    .build()))
                                            .facetFilterSets(List.of(
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build(),
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build(),
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build()))
                                            .authTokens(List.of(
                                                AuthToken.builder()
                                                    .accessToken("123abc")
                                                    .datasource("gmail")
                                                    .scope("email profile https://www.googleapis.com/auth/gmail.readonly")
                                                    .tokenType("Bearer")
                                                    .authUser("1")
                                                    .build()))
                                            .build())
                                        .ranges(List.of(
                                            TextRange.builder()
                                                .startIndex(86650L)
                                                .document(Document.builder()
                                                    .metadata(DocumentMetadata.builder()
                                                        .datasource("datasource")
                                                        .objectType("Feature Request")
                                                        .container("container")
                                                        .parentId("JIRA_EN-1337")
                                                        .mimeType("mimeType")
                                                        .documentId("documentId")
                                                        .createTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                                        .updateTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                                        .components(List.of(
                                                            "Backend",
                                                            "Networking"))
                                                        .status("[\"Done\"]")
                                                        .pins(List.of(
                                                            PinDocument.builder()
                                                                .documentId("<id>")
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .build()))
                                                        .collections(List.of(
                                                            Collection.builder()
                                                                .name("<value>")
                                                                .description("meaty dial elegantly while react")
                                                                .id(854591L)
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .items(List.of(
                                                                    CollectionItem.builder()
                                                                        .collectionId(697663L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(697663L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(697663L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build()))
                                                                .build()))
                                                        .interactions(DocumentInteractions.builder()
                                                            .reacts(List.of(
                                                                Reaction.builder()
                                                                    .build(),
                                                                Reaction.builder()
                                                                    .build()))
                                                            .shares(List.of(
                                                                Share.builder()
                                                                    .numDaysAgo(365776L)
                                                                    .build(),
                                                                Share.builder()
                                                                    .numDaysAgo(365776L)
                                                                    .build(),
                                                                Share.builder()
                                                                    .numDaysAgo(365776L)
                                                                    .build()))
                                                            .build())
                                                        .verification(Verification.builder()
                                                            .state(State.DEPRECATED)
                                                            .metadata(VerificationMetadata.builder()
                                                                .reminders(List.of(
                                                                    Reminder.builder()
                                                                        .assignee(Person.builder()
                                                                            .name("George Clooney")
                                                                            .obfuscatedId("abc123")
                                                                            .build())
                                                                        .remindAt(268615L)
                                                                        .build()))
                                                                .lastReminder(Reminder.builder()
                                                                    .assignee(Person.builder()
                                                                        .name("George Clooney")
                                                                        .obfuscatedId("abc123")
                                                                        .build())
                                                                    .remindAt(423482L)
                                                                    .build())
                                                                .build())
                                                            .build())
                                                        .shortcuts(List.of(
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build(),
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build(),
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build()))
                                                        .customData(Map.ofEntries(
                                                            Map.entry("someCustomField", CustomDataValue.builder()
                                                                .build())))
                                                        .build())
                                                    .build())
                                                .build()))
                                        .inputDetails(SearchRequestInputDetails.builder()
                                            .hasCopyPaste(true)
                                            .build())
                                        .build())
                                    .results(List.of(
                                        SearchResult.builder()
                                            .url("https://example.com/foo/bar")
                                            .title("title")
                                            .nativeAppUrl("slack://foo/bar")
                                            .snippets(List.of(
                                                SearchResultSnippet.builder()
                                                    .snippet("snippet")
                                                    .mimeType("mimeType")
                                                    .build()))
                                            .build()))
                                    .build()))
                            .metadata(PersonMetadata.builder()
                                .type(PersonMetadataType.FULL_TIME)
                                .title("Actor")
                                .department("Movies")
                                .email("george@example.com")
                                .location("Hollywood, CA")
                                .phone("6505551234")
                                .photoUrl("https://example.com/george.jpg")
                                .startDate(LocalDate.parse("2000-01-23"))
                                .datasourceProfile(List.of(
                                    DatasourceProfile.builder()
                                        .datasource("github")
                                        .handle("<value>")
                                        .build(),
                                    DatasourceProfile.builder()
                                        .datasource("github")
                                        .handle("<value>")
                                        .build()))
                                .querySuggestions(QuerySuggestionList.builder()
                                    .suggestions(List.of(
                                        QuerySuggestion.builder()
                                            .query("app:github type:pull author:mortimer")
                                            .label("Mortimer's PRs")
                                            .datasource("github")
                                            .build()))
                                    .build())
                                .inviteInfo(InviteInfo.builder()
                                    .invites(List.of(
                                        ChannelInviteInfo.builder()
                                            .build(),
                                        ChannelInviteInfo.builder()
                                            .build()))
                                    .build())
                                .customFields(List.of(
                                    CustomFieldData.builder()
                                        .label("<value>")
                                        .values(List.of(
                                            CustomFieldValue.of(CustomFieldValueStr.builder()
                                                .build()),
                                            CustomFieldValue.of(CustomFieldValueStr.builder()
                                                .build()),
                                            CustomFieldValue.of(CustomFieldValueStr.builder()
                                                .build())))
                                        .build(),
                                    CustomFieldData.builder()
                                        .label("<value>")
                                        .values(List.of(
                                            CustomFieldValue.of(CustomFieldValueStr.builder()
                                                .build()),
                                            CustomFieldValue.of(CustomFieldValueStr.builder()
                                                .build()),
                                            CustomFieldValue.of(CustomFieldValueStr.builder()
                                                .build())))
                                        .build()))
                                .badges(List.of(
                                    Badge.builder()
                                        .key("deployment_name_new_hire")
                                        .displayName("New hire")
                                        .iconConfig(IconConfig.builder()
                                            .color("#343CED")
                                            .key("person_icon")
                                            .iconType(IconType.GLYPH)
                                            .name("user")
                                            .build())
                                        .build()))
                                .build())
                            .build())
                        .build()))
                .removedRoles(List.of(
                    UserRoleSpecification.builder()
                        .role(UserRole.VIEWER)
                        .person(Person.builder()
                            .name("George Clooney")
                            .obfuscatedId("abc123")
                            .metadata(PersonMetadata.builder()
                                .type(PersonMetadataType.FULL_TIME)
                                .title("Actor")
                                .department("Movies")
                                .email("george@example.com")
                                .location("Hollywood, CA")
                                .phone("6505551234")
                                .photoUrl("https://example.com/george.jpg")
                                .startDate(LocalDate.parse("2000-01-23"))
                                .datasourceProfile(List.of(
                                    DatasourceProfile.builder()
                                        .datasource("github")
                                        .handle("<value>")
                                        .build(),
                                    DatasourceProfile.builder()
                                        .datasource("github")
                                        .handle("<value>")
                                        .build()))
                                .querySuggestions(QuerySuggestionList.builder()
                                    .suggestions(List.of(
                                        QuerySuggestion.builder()
                                            .query("app:github type:pull author:mortimer")
                                            .label("Mortimer's PRs")
                                            .datasource("github")
                                            .build()))
                                    .build())
                                .inviteInfo(InviteInfo.builder()
                                    .invites(List.of(
                                        ChannelInviteInfo.builder()
                                            .build(),
                                        ChannelInviteInfo.builder()
                                            .build()))
                                    .build())
                                .badges(List.of(
                                    Badge.builder()
                                        .key("deployment_name_new_hire")
                                        .displayName("New hire")
                                        .iconConfig(IconConfig.builder()
                                            .color("#343CED")
                                            .key("person_icon")
                                            .iconType(IconType.GLYPH)
                                            .name("user")
                                            .build())
                                        .build()))
                                .build())
                            .build())
                        .build()))
                .audienceFilters(List.of(
                    FacetFilter.builder()
                        .fieldName("type")
                        .values(List.of(
                            FacetFilterValue.builder()
                                .value("Spreadsheet")
                                .relationType(RelationType.EQUALS)
                                .build(),
                            FacetFilterValue.builder()
                                .value("Presentation")
                                .relationType(RelationType.EQUALS)
                                .build()))
                        .build()))
                .build();

        CreatecollectionResponse res = sdk.client().collections().create()
                .request(req)
                .call();

        if (res.createCollectionResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [CreateCollectionRequest](../../models/shared/CreateCollectionRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[CreatecollectionResponse](../../models/operations/CreatecollectionResponse.md)**

### Errors

| Error Type                    | Status Code                   | Content Type                  |
| ----------------------------- | ----------------------------- | ----------------------------- |
| models/errors/CollectionError | 422                           | application/json              |
| models/errors/APIException    | 4XX, 5XX                      | \*/\*                         |

## delete

Delete a Collection given the Collection's ID.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DeleteCollectionRequest;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.errors.CollectionError;
import com.glean.api_client.glean_api_client.models.operations.DeletecollectionResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CollectionError, Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        DeleteCollectionRequest req = DeleteCollectionRequest.builder()
                .ids(List.of(
                    930352L,
                    156719L,
                    25102L))
                .build();

        DeletecollectionResponse res = sdk.client().collections().delete()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [DeleteCollectionRequest](../../models/shared/DeleteCollectionRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[DeletecollectionResponse](../../models/operations/DeletecollectionResponse.md)**

### Errors

| Error Type                    | Status Code                   | Content Type                  |
| ----------------------------- | ----------------------------- | ----------------------------- |
| models/errors/CollectionError | 422                           | application/json              |
| models/errors/APIException    | 4XX, 5XX                      | \*/\*                         |

## deleteItem

Delete a single item from a Collection.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DeleteCollectionItemRequest;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.DeletecollectionitemResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        DeleteCollectionItemRequest req = DeleteCollectionItemRequest.builder()
                .collectionId(6980.49)
                .itemId("<id>")
                .build();

        DeletecollectionitemResponse res = sdk.client().collections().deleteItem()
                .request(req)
                .call();

        if (res.deleteCollectionItemResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [DeleteCollectionItemRequest](../../models/shared/DeleteCollectionItemRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[DeletecollectionitemResponse](../../models/operations/DeletecollectionitemResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## update

Update the properties of an existing Collection.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.errors.CollectionError;
import com.glean.api_client.glean_api_client.models.operations.EditcollectionResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws CollectionError, Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        EditCollectionRequest req = EditCollectionRequest.builder()
                .name("<value>")
                .id(671264L)
                .addedRoles(List.of(
                    UserRoleSpecification.builder()
                        .role(UserRole.OWNER)
                        .person(Person.builder()
                            .name("George Clooney")
                            .obfuscatedId("abc123")
                            .relatedDocuments(List.of(
                                RelatedDocuments.builder()
                                    .querySuggestion(QuerySuggestion.builder()
                                        .query("app:github type:pull author:mortimer")
                                        .searchProviderInfo(SearchProviderInfo.builder()
                                            .name("Google")
                                            .searchLinkUrlTemplate("https://www.google.com/search?q={query}&hl=en")
                                            .build())
                                        .label("Mortimer's PRs")
                                        .datasource("github")
                                        .requestOptions(SearchRequestOptions.builder()
                                            .facetBucketSize(797260L)
                                            .datasourceFilter("JIRA")
                                            .datasourcesFilter(List.of(
                                                "JIRA"))
                                            .queryOverridesFacetFilters(true)
                                            .facetFilters(List.of(
                                                FacetFilter.builder()
                                                    .fieldName("type")
                                                    .values(List.of(
                                                        FacetFilterValue.builder()
                                                            .value("Spreadsheet")
                                                            .relationType(RelationType.EQUALS)
                                                            .build(),
                                                        FacetFilterValue.builder()
                                                            .value("Presentation")
                                                            .relationType(RelationType.EQUALS)
                                                            .build()))
                                                    .build()))
                                            .facetFilterSets(List.of(
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build(),
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build()))
                                            .authTokens(List.of(
                                                AuthToken.builder()
                                                    .accessToken("123abc")
                                                    .datasource("gmail")
                                                    .scope("email profile https://www.googleapis.com/auth/gmail.readonly")
                                                    .tokenType("Bearer")
                                                    .authUser("1")
                                                    .build()))
                                            .build())
                                        .ranges(List.of(
                                            TextRange.builder()
                                                .startIndex(932928L)
                                                .document(Document.builder()
                                                    .metadata(DocumentMetadata.builder()
                                                        .datasource("datasource")
                                                        .objectType("Feature Request")
                                                        .container("container")
                                                        .parentId("JIRA_EN-1337")
                                                        .mimeType("mimeType")
                                                        .documentId("documentId")
                                                        .createTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                                        .updateTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                                        .components(List.of(
                                                            "Backend",
                                                            "Networking"))
                                                        .status("[\"Done\"]")
                                                        .pins(List.of(
                                                            PinDocument.builder()
                                                                .documentId("<id>")
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .build(),
                                                            PinDocument.builder()
                                                                .documentId("<id>")
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .build()))
                                                        .collections(List.of(
                                                            Collection.builder()
                                                                .name("<value>")
                                                                .description("how by extroverted excess kissingly scruple yearningly")
                                                                .id(416110L)
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .items(List.of(
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build()))
                                                                .build(),
                                                            Collection.builder()
                                                                .name("<value>")
                                                                .description("how by extroverted excess kissingly scruple yearningly")
                                                                .id(416110L)
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .items(List.of(
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build()))
                                                                .build()))
                                                        .interactions(DocumentInteractions.builder()
                                                            .reacts(List.of(
                                                                Reaction.builder()
                                                                    .build(),
                                                                Reaction.builder()
                                                                    .build(),
                                                                Reaction.builder()
                                                                    .build()))
                                                            .shares(List.of(
                                                                Share.builder()
                                                                    .numDaysAgo(927933L)
                                                                    .build(),
                                                                Share.builder()
                                                                    .numDaysAgo(927933L)
                                                                    .build(),
                                                                Share.builder()
                                                                    .numDaysAgo(927933L)
                                                                    .build()))
                                                            .build())
                                                        .verification(Verification.builder()
                                                            .state(State.UNVERIFIED)
                                                            .metadata(VerificationMetadata.builder()
                                                                .reminders(List.of(
                                                                    Reminder.builder()
                                                                        .assignee(Person.builder()
                                                                            .name("George Clooney")
                                                                            .obfuscatedId("abc123")
                                                                            .build())
                                                                        .remindAt(353914L)
                                                                        .build(),
                                                                    Reminder.builder()
                                                                        .assignee(Person.builder()
                                                                            .name("George Clooney")
                                                                            .obfuscatedId("abc123")
                                                                            .build())
                                                                        .remindAt(353914L)
                                                                        .build()))
                                                                .lastReminder(Reminder.builder()
                                                                    .assignee(Person.builder()
                                                                        .name("George Clooney")
                                                                        .obfuscatedId("abc123")
                                                                        .build())
                                                                    .remindAt(314497L)
                                                                    .build())
                                                                .build())
                                                            .build())
                                                        .shortcuts(List.of(
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build(),
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build()))
                                                        .customData(Map.ofEntries(
                                                            Map.entry("someCustomField", CustomDataValue.builder()
                                                                .build())))
                                                        .build())
                                                    .build())
                                                .build()))
                                        .inputDetails(SearchRequestInputDetails.builder()
                                            .hasCopyPaste(true)
                                            .build())
                                        .build())
                                    .results(List.of(
                                        SearchResult.builder()
                                            .url("https://example.com/foo/bar")
                                            .title("title")
                                            .nativeAppUrl("slack://foo/bar")
                                            .snippets(List.of(
                                                SearchResultSnippet.builder()
                                                    .snippet("snippet")
                                                    .mimeType("mimeType")
                                                    .build()))
                                            .build()))
                                    .build(),
                                RelatedDocuments.builder()
                                    .querySuggestion(QuerySuggestion.builder()
                                        .query("app:github type:pull author:mortimer")
                                        .searchProviderInfo(SearchProviderInfo.builder()
                                            .name("Google")
                                            .searchLinkUrlTemplate("https://www.google.com/search?q={query}&hl=en")
                                            .build())
                                        .label("Mortimer's PRs")
                                        .datasource("github")
                                        .requestOptions(SearchRequestOptions.builder()
                                            .facetBucketSize(797260L)
                                            .datasourceFilter("JIRA")
                                            .datasourcesFilter(List.of(
                                                "JIRA"))
                                            .queryOverridesFacetFilters(true)
                                            .facetFilters(List.of(
                                                FacetFilter.builder()
                                                    .fieldName("type")
                                                    .values(List.of(
                                                        FacetFilterValue.builder()
                                                            .value("Spreadsheet")
                                                            .relationType(RelationType.EQUALS)
                                                            .build(),
                                                        FacetFilterValue.builder()
                                                            .value("Presentation")
                                                            .relationType(RelationType.EQUALS)
                                                            .build()))
                                                    .build()))
                                            .facetFilterSets(List.of(
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build(),
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build()))
                                            .authTokens(List.of(
                                                AuthToken.builder()
                                                    .accessToken("123abc")
                                                    .datasource("gmail")
                                                    .scope("email profile https://www.googleapis.com/auth/gmail.readonly")
                                                    .tokenType("Bearer")
                                                    .authUser("1")
                                                    .build()))
                                            .build())
                                        .ranges(List.of(
                                            TextRange.builder()
                                                .startIndex(932928L)
                                                .document(Document.builder()
                                                    .metadata(DocumentMetadata.builder()
                                                        .datasource("datasource")
                                                        .objectType("Feature Request")
                                                        .container("container")
                                                        .parentId("JIRA_EN-1337")
                                                        .mimeType("mimeType")
                                                        .documentId("documentId")
                                                        .createTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                                        .updateTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                                        .components(List.of(
                                                            "Backend",
                                                            "Networking"))
                                                        .status("[\"Done\"]")
                                                        .pins(List.of(
                                                            PinDocument.builder()
                                                                .documentId("<id>")
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .build(),
                                                            PinDocument.builder()
                                                                .documentId("<id>")
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .build()))
                                                        .collections(List.of(
                                                            Collection.builder()
                                                                .name("<value>")
                                                                .description("how by extroverted excess kissingly scruple yearningly")
                                                                .id(416110L)
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .items(List.of(
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build()))
                                                                .build(),
                                                            Collection.builder()
                                                                .name("<value>")
                                                                .description("how by extroverted excess kissingly scruple yearningly")
                                                                .id(416110L)
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .items(List.of(
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build()))
                                                                .build()))
                                                        .interactions(DocumentInteractions.builder()
                                                            .reacts(List.of(
                                                                Reaction.builder()
                                                                    .build(),
                                                                Reaction.builder()
                                                                    .build(),
                                                                Reaction.builder()
                                                                    .build()))
                                                            .shares(List.of(
                                                                Share.builder()
                                                                    .numDaysAgo(927933L)
                                                                    .build(),
                                                                Share.builder()
                                                                    .numDaysAgo(927933L)
                                                                    .build(),
                                                                Share.builder()
                                                                    .numDaysAgo(927933L)
                                                                    .build()))
                                                            .build())
                                                        .verification(Verification.builder()
                                                            .state(State.UNVERIFIED)
                                                            .metadata(VerificationMetadata.builder()
                                                                .reminders(List.of(
                                                                    Reminder.builder()
                                                                        .assignee(Person.builder()
                                                                            .name("George Clooney")
                                                                            .obfuscatedId("abc123")
                                                                            .build())
                                                                        .remindAt(353914L)
                                                                        .build(),
                                                                    Reminder.builder()
                                                                        .assignee(Person.builder()
                                                                            .name("George Clooney")
                                                                            .obfuscatedId("abc123")
                                                                            .build())
                                                                        .remindAt(353914L)
                                                                        .build()))
                                                                .lastReminder(Reminder.builder()
                                                                    .assignee(Person.builder()
                                                                        .name("George Clooney")
                                                                        .obfuscatedId("abc123")
                                                                        .build())
                                                                    .remindAt(314497L)
                                                                    .build())
                                                                .build())
                                                            .build())
                                                        .shortcuts(List.of(
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build(),
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build()))
                                                        .customData(Map.ofEntries(
                                                            Map.entry("someCustomField", CustomDataValue.builder()
                                                                .build())))
                                                        .build())
                                                    .build())
                                                .build()))
                                        .inputDetails(SearchRequestInputDetails.builder()
                                            .hasCopyPaste(true)
                                            .build())
                                        .build())
                                    .results(List.of(
                                        SearchResult.builder()
                                            .url("https://example.com/foo/bar")
                                            .title("title")
                                            .nativeAppUrl("slack://foo/bar")
                                            .snippets(List.of(
                                                SearchResultSnippet.builder()
                                                    .snippet("snippet")
                                                    .mimeType("mimeType")
                                                    .build()))
                                            .build()))
                                    .build(),
                                RelatedDocuments.builder()
                                    .querySuggestion(QuerySuggestion.builder()
                                        .query("app:github type:pull author:mortimer")
                                        .searchProviderInfo(SearchProviderInfo.builder()
                                            .name("Google")
                                            .searchLinkUrlTemplate("https://www.google.com/search?q={query}&hl=en")
                                            .build())
                                        .label("Mortimer's PRs")
                                        .datasource("github")
                                        .requestOptions(SearchRequestOptions.builder()
                                            .facetBucketSize(797260L)
                                            .datasourceFilter("JIRA")
                                            .datasourcesFilter(List.of(
                                                "JIRA"))
                                            .queryOverridesFacetFilters(true)
                                            .facetFilters(List.of(
                                                FacetFilter.builder()
                                                    .fieldName("type")
                                                    .values(List.of(
                                                        FacetFilterValue.builder()
                                                            .value("Spreadsheet")
                                                            .relationType(RelationType.EQUALS)
                                                            .build(),
                                                        FacetFilterValue.builder()
                                                            .value("Presentation")
                                                            .relationType(RelationType.EQUALS)
                                                            .build()))
                                                    .build()))
                                            .facetFilterSets(List.of(
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build(),
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build()))
                                            .authTokens(List.of(
                                                AuthToken.builder()
                                                    .accessToken("123abc")
                                                    .datasource("gmail")
                                                    .scope("email profile https://www.googleapis.com/auth/gmail.readonly")
                                                    .tokenType("Bearer")
                                                    .authUser("1")
                                                    .build()))
                                            .build())
                                        .ranges(List.of(
                                            TextRange.builder()
                                                .startIndex(932928L)
                                                .document(Document.builder()
                                                    .metadata(DocumentMetadata.builder()
                                                        .datasource("datasource")
                                                        .objectType("Feature Request")
                                                        .container("container")
                                                        .parentId("JIRA_EN-1337")
                                                        .mimeType("mimeType")
                                                        .documentId("documentId")
                                                        .createTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                                        .updateTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                                        .components(List.of(
                                                            "Backend",
                                                            "Networking"))
                                                        .status("[\"Done\"]")
                                                        .pins(List.of(
                                                            PinDocument.builder()
                                                                .documentId("<id>")
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .build(),
                                                            PinDocument.builder()
                                                                .documentId("<id>")
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .build()))
                                                        .collections(List.of(
                                                            Collection.builder()
                                                                .name("<value>")
                                                                .description("how by extroverted excess kissingly scruple yearningly")
                                                                .id(416110L)
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .items(List.of(
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build()))
                                                                .build(),
                                                            Collection.builder()
                                                                .name("<value>")
                                                                .description("how by extroverted excess kissingly scruple yearningly")
                                                                .id(416110L)
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .items(List.of(
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(959645L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build()))
                                                                .build()))
                                                        .interactions(DocumentInteractions.builder()
                                                            .reacts(List.of(
                                                                Reaction.builder()
                                                                    .build(),
                                                                Reaction.builder()
                                                                    .build(),
                                                                Reaction.builder()
                                                                    .build()))
                                                            .shares(List.of(
                                                                Share.builder()
                                                                    .numDaysAgo(927933L)
                                                                    .build(),
                                                                Share.builder()
                                                                    .numDaysAgo(927933L)
                                                                    .build(),
                                                                Share.builder()
                                                                    .numDaysAgo(927933L)
                                                                    .build()))
                                                            .build())
                                                        .verification(Verification.builder()
                                                            .state(State.UNVERIFIED)
                                                            .metadata(VerificationMetadata.builder()
                                                                .reminders(List.of(
                                                                    Reminder.builder()
                                                                        .assignee(Person.builder()
                                                                            .name("George Clooney")
                                                                            .obfuscatedId("abc123")
                                                                            .build())
                                                                        .remindAt(353914L)
                                                                        .build(),
                                                                    Reminder.builder()
                                                                        .assignee(Person.builder()
                                                                            .name("George Clooney")
                                                                            .obfuscatedId("abc123")
                                                                            .build())
                                                                        .remindAt(353914L)
                                                                        .build()))
                                                                .lastReminder(Reminder.builder()
                                                                    .assignee(Person.builder()
                                                                        .name("George Clooney")
                                                                        .obfuscatedId("abc123")
                                                                        .build())
                                                                    .remindAt(314497L)
                                                                    .build())
                                                                .build())
                                                            .build())
                                                        .shortcuts(List.of(
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build(),
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build()))
                                                        .customData(Map.ofEntries(
                                                            Map.entry("someCustomField", CustomDataValue.builder()
                                                                .build())))
                                                        .build())
                                                    .build())
                                                .build()))
                                        .inputDetails(SearchRequestInputDetails.builder()
                                            .hasCopyPaste(true)
                                            .build())
                                        .build())
                                    .results(List.of(
                                        SearchResult.builder()
                                            .url("https://example.com/foo/bar")
                                            .title("title")
                                            .nativeAppUrl("slack://foo/bar")
                                            .snippets(List.of(
                                                SearchResultSnippet.builder()
                                                    .snippet("snippet")
                                                    .mimeType("mimeType")
                                                    .build()))
                                            .build()))
                                    .build()))
                            .metadata(PersonMetadata.builder()
                                .type(PersonMetadataType.FULL_TIME)
                                .title("Actor")
                                .department("Movies")
                                .email("george@example.com")
                                .location("Hollywood, CA")
                                .phone("6505551234")
                                .photoUrl("https://example.com/george.jpg")
                                .startDate(LocalDate.parse("2000-01-23"))
                                .datasourceProfile(List.of(
                                    DatasourceProfile.builder()
                                        .datasource("github")
                                        .handle("<value>")
                                        .build(),
                                    DatasourceProfile.builder()
                                        .datasource("github")
                                        .handle("<value>")
                                        .build(),
                                    DatasourceProfile.builder()
                                        .datasource("github")
                                        .handle("<value>")
                                        .build()))
                                .querySuggestions(QuerySuggestionList.builder()
                                    .suggestions(List.of(
                                        QuerySuggestion.builder()
                                            .query("app:github type:pull author:mortimer")
                                            .label("Mortimer's PRs")
                                            .datasource("github")
                                            .build()))
                                    .build())
                                .inviteInfo(InviteInfo.builder()
                                    .invites(List.of(
                                        ChannelInviteInfo.builder()
                                            .build(),
                                        ChannelInviteInfo.builder()
                                            .build(),
                                        ChannelInviteInfo.builder()
                                            .build()))
                                    .build())
                                .customFields(List.of(
                                    CustomFieldData.builder()
                                        .label("<value>")
                                        .values(List.of(
                                            CustomFieldValue.of(CustomFieldValueStr.builder()
                                                .build()),
                                            CustomFieldValue.of(CustomFieldValueStr.builder()
                                                .build()),
                                            CustomFieldValue.of(CustomFieldValueStr.builder()
                                                .build())))
                                        .build()))
                                .badges(List.of(
                                    Badge.builder()
                                        .key("deployment_name_new_hire")
                                        .displayName("New hire")
                                        .iconConfig(IconConfig.builder()
                                            .color("#343CED")
                                            .key("person_icon")
                                            .iconType(IconType.GLYPH)
                                            .name("user")
                                            .build())
                                        .build()))
                                .build())
                            .build())
                        .build()))
                .removedRoles(List.of(
                    UserRoleSpecification.builder()
                        .role(UserRole.ANSWER_MODERATOR)
                        .person(Person.builder()
                            .name("George Clooney")
                            .obfuscatedId("abc123")
                            .metadata(PersonMetadata.builder()
                                .type(PersonMetadataType.FULL_TIME)
                                .title("Actor")
                                .department("Movies")
                                .email("george@example.com")
                                .location("Hollywood, CA")
                                .phone("6505551234")
                                .photoUrl("https://example.com/george.jpg")
                                .startDate(LocalDate.parse("2000-01-23"))
                                .datasourceProfile(List.of(
                                    DatasourceProfile.builder()
                                        .datasource("github")
                                        .handle("<value>")
                                        .build(),
                                    DatasourceProfile.builder()
                                        .datasource("github")
                                        .handle("<value>")
                                        .build(),
                                    DatasourceProfile.builder()
                                        .datasource("github")
                                        .handle("<value>")
                                        .build()))
                                .querySuggestions(QuerySuggestionList.builder()
                                    .suggestions(List.of(
                                        QuerySuggestion.builder()
                                            .query("app:github type:pull author:mortimer")
                                            .label("Mortimer's PRs")
                                            .datasource("github")
                                            .build()))
                                    .build())
                                .inviteInfo(InviteInfo.builder()
                                    .invites(List.of(
                                        ChannelInviteInfo.builder()
                                            .build(),
                                        ChannelInviteInfo.builder()
                                            .build(),
                                        ChannelInviteInfo.builder()
                                            .build()))
                                    .build())
                                .badges(List.of(
                                    Badge.builder()
                                        .key("deployment_name_new_hire")
                                        .displayName("New hire")
                                        .iconConfig(IconConfig.builder()
                                            .color("#343CED")
                                            .key("person_icon")
                                            .iconType(IconType.GLYPH)
                                            .name("user")
                                            .build())
                                        .build()))
                                .build())
                            .build())
                        .build()))
                .audienceFilters(List.of(
                    FacetFilter.builder()
                        .fieldName("type")
                        .values(List.of(
                            FacetFilterValue.builder()
                                .value("Spreadsheet")
                                .relationType(RelationType.EQUALS)
                                .build(),
                            FacetFilterValue.builder()
                                .value("Presentation")
                                .relationType(RelationType.EQUALS)
                                .build()))
                        .build()))
                .build();

        EditcollectionResponse res = sdk.client().collections().update()
                .request(req)
                .call();

        if (res.editCollectionResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [EditCollectionRequest](../../models/shared/EditCollectionRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[EditcollectionResponse](../../models/operations/EditcollectionResponse.md)**

### Errors

| Error Type                    | Status Code                   | Content Type                  |
| ----------------------------- | ----------------------------- | ----------------------------- |
| models/errors/CollectionError | 422                           | application/json              |
| models/errors/APIException    | 4XX, 5XX                      | \*/\*                         |

## updateItem

Update the URL, Glean Document ID, description of an item within a Collection given its ID.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.EditCollectionItemRequest;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.EditcollectionitemResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        EditCollectionItemRequest req = EditCollectionItemRequest.builder()
                .collectionId(142375L)
                .itemId("<id>")
                .build();

        EditcollectionitemResponse res = sdk.client().collections().updateItem()
                .request(req)
                .call();

        if (res.editCollectionItemResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `request`                                                                     | [EditCollectionItemRequest](../../models/shared/EditCollectionItemRequest.md) | :heavy_check_mark:                                                            | The request object to use for the request.                                    |

### Response

**[EditcollectionitemResponse](../../models/operations/EditcollectionitemResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieve

Read the details of a Collection given its ID. Does not fetch items in this Collection.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.GetCollectionRequest;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.GetcollectionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        GetCollectionRequest req = GetCollectionRequest.builder()
                .id(425335L)
                .build();

        GetcollectionResponse res = sdk.client().collections().retrieve()
                .request(req)
                .call();

        if (res.getCollectionResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `request`                                                           | [GetCollectionRequest](../../models/shared/GetCollectionRequest.md) | :heavy_check_mark:                                                  | The request object to use for the request.                          |

### Response

**[GetcollectionResponse](../../models/operations/GetcollectionResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

List all existing Collections.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.ListCollectionsRequest;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.ListcollectionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        ListCollectionsRequest req = ListCollectionsRequest.builder()
                .build();

        ListcollectionsResponse res = sdk.client().collections().list()
                .request(req)
                .call();

        if (res.listCollectionsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [ListCollectionsRequest](../../models/shared/ListCollectionsRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[ListcollectionsResponse](../../models/operations/ListcollectionsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |