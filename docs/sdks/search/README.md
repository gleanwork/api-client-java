# Search
(*client().search()*)

## Overview

### Available Operations

* [admin](#admin) - Search the index (admin)
* [autocomplete](#autocomplete) - Autocomplete
* [getFeed](#getfeed) - Feed of documents and events
* [suggestPeople](#suggestpeople) - Suggest people
* [suggestPeopleAdmin](#suggestpeopleadmin) - Suggest people (admin)
* [recommendations](#recommendations) - Recommend documents
* [execute](#execute) - Search

## admin

Retrieves results for search query without respect for permissions. This is available only to privileged users.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.errors.ErrorInfo;
import com.glean.api_client.models.operations.AdminsearchResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorInfo, Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        AdminsearchResponse res = sdk.client().search().admin()
                .searchRequest(SearchRequest.builder()
                    .query("vacation policy")
                    .trackingToken("trackingToken")
                    .sourceDocument(Document.builder()
                        .metadata(DocumentMetadata.builder()
                            .datasource("datasource")
                            .objectType("Feature Request")
                            .container("container")
                            .parentId("JIRA_EN-1337")
                            .mimeType("mimeType")
                            .documentId("documentId")
                            .createTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                            .updateTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                            .author(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .relatedDocuments(List.of())
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
                                        .suggestions(List.of())
                                        .build())
                                    .inviteInfo(InviteInfo.builder()
                                        .invites(List.of())
                                        .build())
                                    .customFields(List.of())
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
                            .owner(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .build())
                            .mentionedPeople(List.of())
                            .components(List.of(
                                "Backend",
                                "Networking"))
                            .status("[\"Done\"]")
                            .pins(List.of())
                            .assignedTo(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .build())
                            .updatedBy(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .build())
                            .collections(List.of())
                            .interactions(DocumentInteractions.builder()
                                .reacts(List.of())
                                .shares(List.of())
                                .build())
                            .verification(Verification.builder()
                                .state(State.VERIFIED)
                                .metadata(VerificationMetadata.builder()
                                    .lastVerifier(Person.builder()
                                        .name("George Clooney")
                                        .obfuscatedId("abc123")
                                        .build())
                                    .reminders(List.of())
                                    .lastReminder(Reminder.builder()
                                        .assignee(Person.builder()
                                            .name("George Clooney")
                                            .obfuscatedId("abc123")
                                            .build())
                                        .remindAt(333878L)
                                        .requestor(Person.builder()
                                            .name("George Clooney")
                                            .obfuscatedId("abc123")
                                            .build())
                                        .build())
                                    .candidateVerifiers(List.of())
                                    .build())
                                .build())
                            .customData(Map.ofEntries(
                                Map.entry("someCustomField", CustomDataValue.builder()
                                    .build())))
                            .contactPerson(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .build())
                            .build())
                        .build())
                    .pageSize(100L)
                    .maxSnippetSize(400L)
                    .inputDetails(SearchRequestInputDetails.builder()
                        .hasCopyPaste(true)
                        .build())
                    .requestOptions(SearchRequestOptions.builder()
                        .facetBucketSize(226218L)
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
                    .timeoutMillis(5000L)
                    .people(List.of(
                        Person.builder()
                            .name("George Clooney")
                            .obfuscatedId("abc123")
                            .build()))
                    .build())
                .call();

        if (res.searchResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                 | Type                                                                                                                                                                                                                                                                                                                                                                      | Required                                                                                                                                                                                                                                                                                                                                                                  | Description                                                                                                                                                                                                                                                                                                                                                               | Example                                                                                                                                                                                                                                                                                                                                                                   |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `xScioActas`                                                                                                                                                                                                                                                                                                                                                              | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                       | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                        | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens).                                                                                                                                                                                                                                                  |                                                                                                                                                                                                                                                                                                                                                                           |
| `xGleanAuthType`                                                                                                                                                                                                                                                                                                                                                          | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                       | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                        | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                                                                                                                                                                                                                                                                 |                                                                                                                                                                                                                                                                                                                                                                           |
| `searchRequest`                                                                                                                                                                                                                                                                                                                                                           | [Optional\<SearchRequest>](../../models/components/SearchRequest.md)                                                                                                                                                                                                                                                                                                      | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                        | Admin search request                                                                                                                                                                                                                                                                                                                                                      | {<br/>"trackingToken": "trackingToken",<br/>"query": "vacation policy",<br/>"pageSize": 10,<br/>"requestOptions": {<br/>"facetFilters": [<br/>{<br/>"fieldName": "type",<br/>"values": [<br/>{<br/>"value": "article",<br/>"relationType": "EQUALS"<br/>},<br/>{<br/>"value": "document",<br/>"relationType": "EQUALS"<br/>}<br/>]<br/>},<br/>{<br/>"fieldName": "department",<br/>"values": [<br/>{<br/>"value": "engineering",<br/>"relationType": "EQUALS"<br/>}<br/>]<br/>}<br/>]<br/>}<br/>} |

### Response

**[AdminsearchResponse](../../models/operations/AdminsearchResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorInfo    | 403, 422                   | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## autocomplete

Retrieve query suggestions, operators and documents for the given partially typed query.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.AuthToken;
import com.glean.api_client.models.components.AutocompleteRequest;
import com.glean.api_client.models.operations.AutocompleteResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        AutocompleteResponse res = sdk.client().search().autocomplete()
                .autocompleteRequest(AutocompleteRequest.builder()
                    .trackingToken("trackingToken")
                    .query("San Fra")
                    .datasource("GDRIVE")
                    .resultSize(10L)
                    .authTokens(List.of(
                        AuthToken.builder()
                            .accessToken("123abc")
                            .datasource("gmail")
                            .scope("email profile https://www.googleapis.com/auth/gmail.readonly")
                            .tokenType("Bearer")
                            .authUser("1")
                            .build()))
                    .build())
                .call();

        if (res.autocompleteResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              | Example                                                                                                                  |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |                                                                                                                          |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |                                                                                                                          |
| `autocompleteRequest`                                                                                                    | [AutocompleteRequest](../../models/components/AutocompleteRequest.md)                                                    | :heavy_check_mark:                                                                                                       | Autocomplete request                                                                                                     | {<br/>"trackingToken": "trackingToken",<br/>"query": "what is a que",<br/>"datasource": "GDRIVE",<br/>"resultSize": 10<br/>} |

### Response

**[AutocompleteResponse](../../models/operations/AutocompleteResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getFeed

The personalized feed/home includes different types of contents including suggestions, recents, calendar events and many more.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.FeedRequest;
import com.glean.api_client.models.operations.FeedResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        FeedResponse res = sdk.client().search().getFeed()
                .feedRequest(FeedRequest.builder()
                    .timeoutMillis(5000L)
                    .build())
                .call();

        if (res.feedResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `feedRequest`                                                                                                            | [FeedRequest](../../models/components/FeedRequest.md)                                                                    | :heavy_check_mark:                                                                                                       | Includes request params, client data and more for making user's feed.                                                    |

### Response

**[FeedResponse](../../models/operations/FeedResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## suggestPeople

Retrieves a list of suggested people for given type. Includes information about the persons.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.PeopleSuggestRequest;
import com.glean.api_client.models.components.PeopleSuggestionCategory;
import com.glean.api_client.models.operations.PeoplesuggestResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PeoplesuggestResponse res = sdk.client().search().suggestPeople()
                .peopleSuggestRequest(PeopleSuggestRequest.builder()
                    .categories(List.of(
                        PeopleSuggestionCategory.INVITE_NONUSERS,
                        PeopleSuggestionCategory.INVITE_NONUSERS))
                    .build())
                .call();

        if (res.peopleSuggestResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `peopleSuggestRequest`                                                                                                   | [PeopleSuggestRequest](../../models/components/PeopleSuggestRequest.md)                                                  | :heavy_check_mark:                                                                                                       | Includes request params for type of suggestions.                                                                         |

### Response

**[PeoplesuggestResponse](../../models/operations/PeoplesuggestResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## suggestPeopleAdmin

Returns a list of suggested people for given type for admin's view. Includes information about the persons.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.PeopleSuggestRequest;
import com.glean.api_client.models.components.PeopleSuggestionCategory;
import com.glean.api_client.models.operations.PeoplesuggestadminResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PeoplesuggestadminResponse res = sdk.client().search().suggestPeopleAdmin()
                .peopleSuggestRequest(PeopleSuggestRequest.builder()
                    .categories(List.of(
                        PeopleSuggestionCategory.INVITE_NONUSERS))
                    .build())
                .call();

        if (res.peopleSuggestResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `peopleSuggestRequest`                                                                                                   | [PeopleSuggestRequest](../../models/components/PeopleSuggestRequest.md)                                                  | :heavy_check_mark:                                                                                                       | Includes request params for type of suggestions.                                                                         |

### Response

**[PeoplesuggestadminResponse](../../models/operations/PeoplesuggestadminResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## recommendations

Retrieve recommended documents for the given URL or Glean Document ID.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.RecommendationsResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        RecommendationsResponse res = sdk.client().search().recommendations()
                .recommendationsRequest(RecommendationsRequest.builder()
                    .sourceDocument(Document.builder()
                        .metadata(DocumentMetadata.builder()
                            .datasource("datasource")
                            .objectType("Feature Request")
                            .container("container")
                            .parentId("JIRA_EN-1337")
                            .mimeType("mimeType")
                            .documentId("documentId")
                            .createTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                            .updateTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                            .author(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .relatedDocuments(List.of())
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
                                        .suggestions(List.of())
                                        .build())
                                    .inviteInfo(InviteInfo.builder()
                                        .invites(List.of())
                                        .build())
                                    .customFields(List.of())
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
                            .owner(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .build())
                            .mentionedPeople(List.of())
                            .components(List.of(
                                "Backend",
                                "Networking"))
                            .status("[\"Done\"]")
                            .pins(List.of())
                            .assignedTo(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .build())
                            .updatedBy(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .build())
                            .collections(List.of())
                            .interactions(DocumentInteractions.builder()
                                .reacts(List.of())
                                .shares(List.of())
                                .build())
                            .verification(Verification.builder()
                                .state(State.VERIFIED)
                                .metadata(VerificationMetadata.builder()
                                    .lastVerifier(Person.builder()
                                        .name("George Clooney")
                                        .obfuscatedId("abc123")
                                        .build())
                                    .reminders(List.of())
                                    .lastReminder(Reminder.builder()
                                        .assignee(Person.builder()
                                            .name("George Clooney")
                                            .obfuscatedId("abc123")
                                            .build())
                                        .remindAt(986764L)
                                        .requestor(Person.builder()
                                            .name("George Clooney")
                                            .obfuscatedId("abc123")
                                            .build())
                                        .build())
                                    .candidateVerifiers(List.of())
                                    .build())
                                .build())
                            .customData(Map.ofEntries(
                                Map.entry("someCustomField", CustomDataValue.builder()
                                    .build())))
                            .contactPerson(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .build())
                            .build())
                        .build())
                    .pageSize(100L)
                    .maxSnippetSize(400L)
                    .requestOptions(RecommendationsRequestOptions.builder()
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
                                .build()))
                        .context(Document.builder()
                            .build())
                        .build())
                    .build())
                .call();

        if (res.resultsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `recommendationsRequest`                                                                                                 | [Optional\<RecommendationsRequest>](../../models/components/RecommendationsRequest.md)                                   | :heavy_minus_sign:                                                                                                       | Recommendations request                                                                                                  |

### Response

**[RecommendationsResponse](../../models/operations/RecommendationsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## execute

Retrieve results from the index for the given query and filters.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.errors.ErrorInfo;
import com.glean.api_client.models.operations.SearchResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorInfo, Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        SearchResponse res = sdk.client().search().execute()
                .searchRequest(SearchRequest.builder()
                    .query("vacation policy")
                    .trackingToken("trackingToken")
                    .sourceDocument(Document.builder()
                        .metadata(DocumentMetadata.builder()
                            .datasource("datasource")
                            .objectType("Feature Request")
                            .container("container")
                            .parentId("JIRA_EN-1337")
                            .mimeType("mimeType")
                            .documentId("documentId")
                            .createTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                            .updateTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                            .author(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .relatedDocuments(List.of())
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
                                        .suggestions(List.of())
                                        .build())
                                    .inviteInfo(InviteInfo.builder()
                                        .invites(List.of())
                                        .build())
                                    .customFields(List.of())
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
                            .owner(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .build())
                            .mentionedPeople(List.of())
                            .components(List.of(
                                "Backend",
                                "Networking"))
                            .status("[\"Done\"]")
                            .pins(List.of())
                            .assignedTo(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .build())
                            .updatedBy(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .build())
                            .collections(List.of())
                            .interactions(DocumentInteractions.builder()
                                .reacts(List.of())
                                .shares(List.of())
                                .build())
                            .verification(Verification.builder()
                                .state(State.UNVERIFIED)
                                .metadata(VerificationMetadata.builder()
                                    .lastVerifier(Person.builder()
                                        .name("George Clooney")
                                        .obfuscatedId("abc123")
                                        .build())
                                    .reminders(List.of())
                                    .lastReminder(Reminder.builder()
                                        .assignee(Person.builder()
                                            .name("George Clooney")
                                            .obfuscatedId("abc123")
                                            .build())
                                        .remindAt(675445L)
                                        .requestor(Person.builder()
                                            .name("George Clooney")
                                            .obfuscatedId("abc123")
                                            .build())
                                        .build())
                                    .candidateVerifiers(List.of())
                                    .build())
                                .build())
                            .customData(Map.ofEntries(
                                Map.entry("someCustomField", CustomDataValue.builder()
                                    .build())))
                            .contactPerson(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .build())
                            .build())
                        .build())
                    .pageSize(100L)
                    .maxSnippetSize(400L)
                    .inputDetails(SearchRequestInputDetails.builder()
                        .hasCopyPaste(true)
                        .build())
                    .requestOptions(SearchRequestOptions.builder()
                        .facetBucketSize(653619L)
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
                    .timeoutMillis(5000L)
                    .people(List.of(
                        Person.builder()
                            .name("George Clooney")
                            .obfuscatedId("abc123")
                            .build()))
                    .build())
                .call();

        if (res.searchResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                 | Type                                                                                                                                                                                                                                                                                                                                                                      | Required                                                                                                                                                                                                                                                                                                                                                                  | Description                                                                                                                                                                                                                                                                                                                                                               | Example                                                                                                                                                                                                                                                                                                                                                                   |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `xScioActas`                                                                                                                                                                                                                                                                                                                                                              | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                       | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                        | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens).                                                                                                                                                                                                                                                  |                                                                                                                                                                                                                                                                                                                                                                           |
| `xGleanAuthType`                                                                                                                                                                                                                                                                                                                                                          | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                       | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                        | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                                                                                                                                                                                                                                                                 |                                                                                                                                                                                                                                                                                                                                                                           |
| `searchRequest`                                                                                                                                                                                                                                                                                                                                                           | [Optional\<SearchRequest>](../../models/components/SearchRequest.md)                                                                                                                                                                                                                                                                                                      | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                        | Search request                                                                                                                                                                                                                                                                                                                                                            | {<br/>"trackingToken": "trackingToken",<br/>"query": "vacation policy",<br/>"pageSize": 10,<br/>"requestOptions": {<br/>"facetFilters": [<br/>{<br/>"fieldName": "type",<br/>"values": [<br/>{<br/>"value": "article",<br/>"relationType": "EQUALS"<br/>},<br/>{<br/>"value": "document",<br/>"relationType": "EQUALS"<br/>}<br/>]<br/>},<br/>{<br/>"fieldName": "department",<br/>"values": [<br/>{<br/>"value": "engineering",<br/>"relationType": "EQUALS"<br/>}<br/>]<br/>}<br/>]<br/>}<br/>} |

### Response

**[SearchResponse](../../models/operations/SearchResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorInfo    | 403, 422                   | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |