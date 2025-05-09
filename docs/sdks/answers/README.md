# Answers
(*client().answers()*)

## Overview

### Available Operations

* [create](#create) - Create Answer
* [delete](#delete) - Delete Answer
* [update](#update) - Update Answer
* [retrieve](#retrieve) - Read Answer
* [list](#list) - List Answers

## create

Create a user-generated Answer that contains a question and answer.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.CreateanswerResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateAnswerRequest req = CreateAnswerRequest.builder()
                .data(AnswerCreationData.builder()
                    .question("Why is the sky blue?")
                    .bodyText("From https://en.wikipedia.org/wiki/Diffuse_sky_radiation, the sky is blue because blue light is more strongly scattered than longer-wavelength light.")
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
                                                .facetBucketSize(134365L)
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
                                                    .startIndex(796474L)
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
                                                                    .description("fumigate convection though zowie")
                                                                    .id(496323L)
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
                                                                            .collectionId(782367L)
                                                                            .itemType(CollectionItemItemType.DOCUMENT)
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
                                                                        .numDaysAgo(219974L)
                                                                        .build(),
                                                                    Share.builder()
                                                                        .numDaysAgo(449221L)
                                                                        .build(),
                                                                    Share.builder()
                                                                        .numDaysAgo(427887L)
                                                                        .build()))
                                                                .build())
                                                            .verification(Verification.builder()
                                                                .state(State.VERIFIED)
                                                                .metadata(VerificationMetadata.builder()
                                                                    .reminders(List.of(
                                                                        Reminder.builder()
                                                                            .assignee(Person.builder()
                                                                                .name("George Clooney")
                                                                                .obfuscatedId("abc123")
                                                                                .build())
                                                                            .remindAt(491427L)
                                                                            .build()))
                                                                    .lastReminder(Reminder.builder()
                                                                        .assignee(Person.builder()
                                                                            .name("George Clooney")
                                                                            .obfuscatedId("abc123")
                                                                            .build())
                                                                        .remindAt(490420L)
                                                                        .build())
                                                                    .build())
                                                                .build())
                                                            .shortcuts(List.of(
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
                                                .facetBucketSize(45416L)
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
                                            .inputDetails(SearchRequestInputDetails.builder()
                                                .hasCopyPaste(true)
                                                .build())
                                            .build())
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
                                                .build()))
                                        .build())
                                    .customFields(List.of(
                                        CustomFieldData.builder()
                                            .label("<value>")
                                            .values(List.of(
                                                CustomFieldValue.of(CustomFieldValueStr.builder()
                                                    .build()),
                                                CustomFieldValue.of(CustomFieldValueStr.builder()
                                                    .build())))
                                            .build(),
                                        CustomFieldData.builder()
                                            .label("<value>")
                                            .values(List.of())
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
                            .build(),
                        UserRoleSpecification.builder()
                            .role(UserRole.VERIFIER)
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
                                            .build()))
                                    .querySuggestions(QuerySuggestionList.builder()
                                        .build())
                                    .inviteInfo(InviteInfo.builder()
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
                    .removedRoles(List.of(
                        UserRoleSpecification.builder()
                            .role(UserRole.VERIFIER)
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
                                            .build()))
                                    .querySuggestions(QuerySuggestionList.builder()
                                        .build())
                                    .inviteInfo(InviteInfo.builder()
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
                            .build(),
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
                                        .build())
                                    .inviteInfo(InviteInfo.builder()
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
                            .build(),
                        UserRoleSpecification.builder()
                            .role(UserRole.OWNER)
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
                                            .build()))
                                    .querySuggestions(QuerySuggestionList.builder()
                                        .build())
                                    .inviteInfo(InviteInfo.builder()
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
                    .roles(List.of(
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
                                            .build()))
                                    .querySuggestions(QuerySuggestionList.builder()
                                        .build())
                                    .inviteInfo(InviteInfo.builder()
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
                            .build(),
                        UserRoleSpecification.builder()
                            .role(UserRole.OWNER)
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
                                        .build())
                                    .inviteInfo(InviteInfo.builder()
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
                            .build(),
                        UserRoleSpecification.builder()
                            .role(UserRole.VERIFIER)
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
                                        .build())
                                    .inviteInfo(InviteInfo.builder()
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
                    .combinedAnswerText(StructuredTextMutableProperties.builder()
                        .text("From https://en.wikipedia.org/wiki/Diffuse_sky_radiation, the sky is blue because blue light is more strongly scattered than longer-wavelength light.")
                        .build())
                    .build())
                .build();

        CreateanswerResponse res = sdk.client().answers().create()
                .request(req)
                .call();

        if (res.answer().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [CreateAnswerRequest](../../models/shared/CreateAnswerRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[CreateanswerResponse](../../models/operations/CreateanswerResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## delete

Delete an existing user-generated Answer.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DeleteAnswerRequest;
import com.glean.api_client.glean_api_client.models.operations.DeleteanswerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteAnswerRequest req = DeleteAnswerRequest.builder()
                .id(3L)
                .docId("ANSWERS_answer_3")
                .build();

        DeleteanswerResponse res = sdk.client().answers().delete()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [DeleteAnswerRequest](../../models/shared/DeleteAnswerRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[DeleteanswerResponse](../../models/operations/DeleteanswerResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## update

Update an existing user-generated Answer.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.EditanswerResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        EditAnswerRequest req = EditAnswerRequest.builder()
                .id(3L)
                .docId("ANSWERS_answer_3")
                .question("Why is the sky blue?")
                .bodyText("From https://en.wikipedia.org/wiki/Diffuse_sky_radiation, the sky is blue because blue light is more strongly scattered than longer-wavelength light.")
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
                .addedRoles(List.of(
                    UserRoleSpecification.builder()
                        .role(UserRole.EDITOR)
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
                                            .facetBucketSize(149825L)
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
                                                .startIndex(700217L)
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
                                                                .description("about huzzah institute violin aw pillow abnegate memorable")
                                                                .id(384736L)
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
                                                                        .collectionId(670716L)
                                                                        .itemType(CollectionItemItemType.URL)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(793957L)
                                                                        .itemType(CollectionItemItemType.URL)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build()))
                                                                .build(),
                                                            Collection.builder()
                                                                .name("<value>")
                                                                .description("trouser twine because unnaturally card gallery among")
                                                                .id(818393L)
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
                                                            Collection.builder()
                                                                .name("<value>")
                                                                .description("zebra ugh exactly pfft once")
                                                                .id(29269L)
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
                                                                    .numDaysAgo(177137L)
                                                                    .build(),
                                                                Share.builder()
                                                                    .numDaysAgo(127401L)
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
                                                                        .remindAt(843043L)
                                                                        .build()))
                                                                .lastReminder(Reminder.builder()
                                                                    .assignee(Person.builder()
                                                                        .name("George Clooney")
                                                                        .obfuscatedId("abc123")
                                                                        .build())
                                                                    .remindAt(630893L)
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
                                            .facetBucketSize(862908L)
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
                                        .inputDetails(SearchRequestInputDetails.builder()
                                            .hasCopyPaste(true)
                                            .build())
                                        .build())
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
                        .role(UserRole.EDITOR)
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
                                    .build())
                                .inviteInfo(InviteInfo.builder()
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
                .roles(List.of(
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
                                        .build()))
                                .querySuggestions(QuerySuggestionList.builder()
                                    .build())
                                .inviteInfo(InviteInfo.builder()
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
                        .build(),
                    UserRoleSpecification.builder()
                        .role(UserRole.OWNER)
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
                                        .build()))
                                .querySuggestions(QuerySuggestionList.builder()
                                    .build())
                                .inviteInfo(InviteInfo.builder()
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
                .combinedAnswerText(StructuredTextMutableProperties.builder()
                    .text("From https://en.wikipedia.org/wiki/Diffuse_sky_radiation, the sky is blue because blue light is more strongly scattered than longer-wavelength light.")
                    .build())
                .build();

        EditanswerResponse res = sdk.client().answers().update()
                .request(req)
                .call();

        if (res.answer().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `request`                                                     | [EditAnswerRequest](../../models/shared/EditAnswerRequest.md) | :heavy_check_mark:                                            | The request object to use for the request.                    |

### Response

**[EditanswerResponse](../../models/operations/EditanswerResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieve

Read the details of a particular Answer given its ID.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.GetAnswerRequest;
import com.glean.api_client.glean_api_client.models.operations.GetanswerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetAnswerRequest req = GetAnswerRequest.builder()
                .id(3L)
                .docId("ANSWERS_answer_3")
                .build();

        GetanswerResponse res = sdk.client().answers().retrieve()
                .request(req)
                .call();

        if (res.getAnswerResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                   | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `request`                                                   | [GetAnswerRequest](../../models/shared/GetAnswerRequest.md) | :heavy_check_mark:                                          | The request object to use for the request.                  |

### Response

**[GetanswerResponse](../../models/operations/GetanswerResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

List Answers created by the current user.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.ListAnswersRequest;
import com.glean.api_client.glean_api_client.models.operations.ListanswersResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ListAnswersRequest req = ListAnswersRequest.builder()
                .build();

        ListanswersResponse res = sdk.client().answers().list()
                .request(req)
                .call();

        if (res.listAnswersResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                       | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `request`                                                       | [ListAnswersRequest](../../models/shared/ListAnswersRequest.md) | :heavy_check_mark:                                              | The request object to use for the request.                      |

### Response

**[ListanswersResponse](../../models/operations/ListanswersResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |