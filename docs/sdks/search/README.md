# Search
(*client().search()*)

## Overview

### Available Operations

* [queryAsAdmin](#queryasadmin) - Search the index (admin)
* [autocomplete](#autocomplete) - Autocomplete
* [retrieveFeed](#retrievefeed) - Feed of documents and events
* [recommendations](#recommendations) - Recommend documents
* [query](#query) - Search

## queryAsAdmin

Retrieves results for search query without respect for permissions. This is available only to privileged users.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.errors.GleanDataError;
import com.glean.api_client.glean_api_client.models.operations.AdminsearchResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws GleanDataError, Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        SearchRequest req = SearchRequest.builder()
                .query("vacation policy")
                .trackingToken("trackingToken")
                .pageSize(10L)
                .requestOptions(SearchRequestOptions.builder()
                    .facetBucketSize(421489L)
                    .facetFilters(List.of(
                        FacetFilter.builder()
                            .fieldName("type")
                            .values(List.of(
                                FacetFilterValue.builder()
                                    .value("article")
                                    .relationType(RelationType.EQUALS)
                                    .build(),
                                FacetFilterValue.builder()
                                    .value("document")
                                    .relationType(RelationType.EQUALS)
                                    .build()))
                            .build(),
                        FacetFilter.builder()
                            .fieldName("department")
                            .values(List.of(
                                FacetFilterValue.builder()
                                    .value("engineering")
                                    .relationType(RelationType.EQUALS)
                                    .build()))
                            .build()))
                    .build())
                .build();

        AdminsearchResponse res = sdk.client().search().queryAsAdmin()
                .request(req)
                .call();

        if (res.searchResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                             | Type                                                  | Required                                              | Description                                           |
| ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- |
| `request`                                             | [SearchRequest](../../models/shared/SearchRequest.md) | :heavy_check_mark:                                    | The request object to use for the request.            |

### Response

**[AdminsearchResponse](../../models/operations/AdminsearchResponse.md)**

### Errors

| Error Type                   | Status Code                  | Content Type                 |
| ---------------------------- | ---------------------------- | ---------------------------- |
| models/errors/GleanDataError | 403, 422                     | application/json             |
| models/errors/APIException   | 4XX, 5XX                     | \*/\*                        |

## autocomplete

Retrieve query suggestions, operators and documents for the given partially typed query.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.AutocompleteRequest;
import com.glean.api_client.glean_api_client.models.operations.AutocompleteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        AutocompleteRequest req = AutocompleteRequest.builder()
                .trackingToken("trackingToken")
                .query("what is a que")
                .datasource("GDRIVE")
                .resultSize(10L)
                .build();

        AutocompleteResponse res = sdk.client().search().autocomplete()
                .request(req)
                .call();

        if (res.autocompleteResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [AutocompleteRequest](../../models/shared/AutocompleteRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[AutocompleteResponse](../../models/operations/AutocompleteResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieveFeed

The personalized feed/home includes different types of contents including suggestions, recents, calendar events and many more.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.FeedRequest;
import com.glean.api_client.glean_api_client.models.operations.FeedResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        FeedRequest req = FeedRequest.builder()
                .timeoutMillis(5000L)
                .build();

        FeedResponse res = sdk.client().search().retrieveFeed()
                .request(req)
                .call();

        if (res.feedResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                         | Type                                              | Required                                          | Description                                       |
| ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- |
| `request`                                         | [FeedRequest](../../models/shared/FeedRequest.md) | :heavy_check_mark:                                | The request object to use for the request.        |

### Response

**[FeedResponse](../../models/operations/FeedResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## recommendations

Retrieve recommended documents for the given URL or Glean Document ID.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.RecommendationsResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        RecommendationsRequest req = RecommendationsRequest.builder()
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
                            .name("name")
                            .obfuscatedId("abc123")
                            .build())
                        .components(List.of(
                            "Backend",
                            "Networking"))
                        .status("[\"Done\"]")
                        .customData(Map.ofEntries(
                            Map.entry("someCustomField", CustomDataValue.builder()
                                .build())))
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
                    .context(Document.builder()
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
                                .name("name")
                                .obfuscatedId("abc123")
                                .build())
                            .components(List.of(
                                "Backend",
                                "Networking"))
                            .status("[\"Done\"]")
                            .customData(Map.ofEntries(
                                Map.entry("someCustomField", CustomDataValue.builder()
                                    .build())))
                            .build())
                        .build())
                    .build())
                .build();

        RecommendationsResponse res = sdk.client().search().recommendations()
                .request(req)
                .call();

        if (res.resultsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [RecommendationsRequest](../../models/shared/RecommendationsRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[RecommendationsResponse](../../models/operations/RecommendationsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## query

Retrieve results from the index for the given query and filters.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.errors.GleanDataError;
import com.glean.api_client.glean_api_client.models.operations.SearchResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws GleanDataError, Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        SearchRequest req = SearchRequest.builder()
                .query("vacation policy")
                .trackingToken("trackingToken")
                .pageSize(10L)
                .requestOptions(SearchRequestOptions.builder()
                    .facetBucketSize(400611L)
                    .facetFilters(List.of(
                        FacetFilter.builder()
                            .fieldName("type")
                            .values(List.of(
                                FacetFilterValue.builder()
                                    .value("article")
                                    .relationType(RelationType.EQUALS)
                                    .build(),
                                FacetFilterValue.builder()
                                    .value("document")
                                    .relationType(RelationType.EQUALS)
                                    .build()))
                            .build(),
                        FacetFilter.builder()
                            .fieldName("department")
                            .values(List.of(
                                FacetFilterValue.builder()
                                    .value("engineering")
                                    .relationType(RelationType.EQUALS)
                                    .build()))
                            .build()))
                    .build())
                .build();

        SearchResponse res = sdk.client().search().query()
                .request(req)
                .call();

        if (res.searchResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                             | Type                                                  | Required                                              | Description                                           |
| ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- |
| `request`                                             | [SearchRequest](../../models/shared/SearchRequest.md) | :heavy_check_mark:                                    | The request object to use for the request.            |

### Response

**[SearchResponse](../../models/operations/SearchResponse.md)**

### Errors

| Error Type                   | Status Code                  | Content Type                 |
| ---------------------------- | ---------------------------- | ---------------------------- |
| models/errors/GleanDataError | 403, 422                     | application/json             |
| models/errors/APIException   | 4XX, 5XX                     | \*/\*                        |