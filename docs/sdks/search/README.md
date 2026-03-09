# Client.Search

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

<!-- UsageSnippet language="java" operationID="adminsearch" method="post" path="/rest/api/v1/adminsearch" -->
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
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        AdminsearchResponse res = sdk.client().search().queryAsAdmin()
                .searchRequest(SearchRequest.builder()
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
                    .build())
                .call();

        if (res.searchResponse().isPresent()) {
            System.out.println(res.searchResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                 | Type                                                                                                                                                                                                                                                                                                                                                                      | Required                                                                                                                                                                                                                                                                                                                                                                  | Description                                                                                                                                                                                                                                                                                                                                                               | Example                                                                                                                                                                                                                                                                                                                                                                   |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                                                                                                                                                                                                  | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                       | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                        | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`.                                                                                                                                                                       |                                                                                                                                                                                                                                                                                                                                                                           |
| `searchRequest`                                                                                                                                                                                                                                                                                                                                                           | [SearchRequest](../../models/components/SearchRequest.md)                                                                                                                                                                                                                                                                                                                 | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                        | Admin search request                                                                                                                                                                                                                                                                                                                                                      | {<br/>"trackingToken": "trackingToken",<br/>"query": "vacation policy",<br/>"pageSize": 10,<br/>"requestOptions": {<br/>"facetFilters": [<br/>{<br/>"fieldName": "type",<br/>"values": [<br/>{<br/>"value": "article",<br/>"relationType": "EQUALS"<br/>},<br/>{<br/>"value": "document",<br/>"relationType": "EQUALS"<br/>}<br/>]<br/>},<br/>{<br/>"fieldName": "department",<br/>"values": [<br/>{<br/>"value": "engineering",<br/>"relationType": "EQUALS"<br/>}<br/>]<br/>}<br/>]<br/>}<br/>} |

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

<!-- UsageSnippet language="java" operationID="autocomplete" method="post" path="/rest/api/v1/autocomplete" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.AutocompleteRequest;
import com.glean.api_client.glean_api_client.models.operations.AutocompleteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        AutocompleteResponse res = sdk.client().search().autocomplete()
                .autocompleteRequest(AutocompleteRequest.builder()
                    .trackingToken("trackingToken")
                    .query("what is a que")
                    .datasource("GDRIVE")
                    .resultSize(10L)
                    .build())
                .call();

        if (res.autocompleteResponse().isPresent()) {
            System.out.println(res.autocompleteResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         | Example                                                                                                                                                                                             |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |                                                                                                                                                                                                     |
| `autocompleteRequest`                                                                                                                                                                               | [AutocompleteRequest](../../models/components/AutocompleteRequest.md)                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                  | Autocomplete request                                                                                                                                                                                | {<br/>"trackingToken": "trackingToken",<br/>"query": "what is a que",<br/>"datasource": "GDRIVE",<br/>"resultSize": 10<br/>}                                                                        |

### Response

**[AutocompleteResponse](../../models/operations/AutocompleteResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieveFeed

The personalized feed/home includes different types of contents including suggestions, recents, calendar events and many more.

### Example Usage

<!-- UsageSnippet language="java" operationID="feed" method="post" path="/rest/api/v1/feed" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.FeedRequest;
import com.glean.api_client.glean_api_client.models.operations.FeedResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        FeedResponse res = sdk.client().search().retrieveFeed()
                .feedRequest(FeedRequest.builder()
                    .timeoutMillis(5000L)
                    .build())
                .call();

        if (res.feedResponse().isPresent()) {
            System.out.println(res.feedResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `feedRequest`                                                                                                                                                                                       | [FeedRequest](../../models/components/FeedRequest.md)                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                  | Includes request params, client data and more for making user's feed.                                                                                                                               |

### Response

**[FeedResponse](../../models/operations/FeedResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## recommendations

Retrieve recommended documents for the given URL or Glean Document ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="recommendations" method="post" path="/rest/api/v1/recommendations" -->
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
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        RecommendationsResponse res = sdk.client().search().recommendations()
                .recommendationsRequest(RecommendationsRequest.builder()
                    .sourceDocument(Document.builder()
                        .containerDocument(Document.builder()
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
                                    .obfuscatedId("<id>")
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
                        .parentDocument(Document.builder()
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
                                    .obfuscatedId("<id>")
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
                            .containerDocument(Document.builder()
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
                                        .obfuscatedId("<id>")
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
                            .parentDocument(Document.builder()
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
                                        .obfuscatedId("<id>")
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
                    .build())
                .call();

        if (res.resultsResponse().isPresent()) {
            System.out.println(res.resultsResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `recommendationsRequest`                                                                                                                                                                            | [RecommendationsRequest](../../models/components/RecommendationsRequest.md)                                                                                                                         | :heavy_check_mark:                                                                                                                                                                                  | Recommendations request                                                                                                                                                                             |

### Response

**[RecommendationsResponse](../../models/operations/RecommendationsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## query

Retrieve results from the index for the given query and filters.

### Example Usage

<!-- UsageSnippet language="java" operationID="search" method="post" path="/rest/api/v1/search" -->
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
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        SearchResponse res = sdk.client().search().query()
                .searchRequest(SearchRequest.builder()
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
                    .build())
                .call();

        if (res.searchResponse().isPresent()) {
            System.out.println(res.searchResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                 | Type                                                                                                                                                                                                                                                                                                                                                                      | Required                                                                                                                                                                                                                                                                                                                                                                  | Description                                                                                                                                                                                                                                                                                                                                                               | Example                                                                                                                                                                                                                                                                                                                                                                   |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                                                                                                                                                                                                  | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                       | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                        | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`.                                                                                                                                                                       |                                                                                                                                                                                                                                                                                                                                                                           |
| `searchRequest`                                                                                                                                                                                                                                                                                                                                                           | [SearchRequest](../../models/components/SearchRequest.md)                                                                                                                                                                                                                                                                                                                 | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                        | Search request                                                                                                                                                                                                                                                                                                                                                            | {<br/>"trackingToken": "trackingToken",<br/>"query": "vacation policy",<br/>"pageSize": 10,<br/>"requestOptions": {<br/>"facetFilters": [<br/>{<br/>"fieldName": "type",<br/>"values": [<br/>{<br/>"value": "article",<br/>"relationType": "EQUALS"<br/>},<br/>{<br/>"value": "document",<br/>"relationType": "EQUALS"<br/>}<br/>]<br/>},<br/>{<br/>"fieldName": "department",<br/>"values": [<br/>{<br/>"value": "engineering",<br/>"relationType": "EQUALS"<br/>}<br/>]<br/>}<br/>]<br/>}<br/>} |

### Response

**[SearchResponse](../../models/operations/SearchResponse.md)**

### Errors

| Error Type                   | Status Code                  | Content Type                 |
| ---------------------------- | ---------------------------- | ---------------------------- |
| models/errors/GleanDataError | 403, 422                     | application/json             |
| models/errors/APIException   | 4XX, 5XX                     | \*/\*                        |