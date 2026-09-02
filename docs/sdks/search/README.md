# Search

## Overview

### Available Operations

* [query](#query) - Search
* [listFilters](#listfilters) - List search filters

## query

Search your organization's connected content and return ranked document results with cursor pagination. Use `GET /api/search/filters` to discover datasource identifiers and common filter fields. Built-in filter names are validated; other field names are accepted as custom filters and behavior depends on your Glean configuration and connected sources.
Errors: HTTP 422 `unprocessable_query` returns no `results` or `next_cursor`. See `warnings` on the response for non-blocking issues such as partially available results. Not every query issue produces a warning or error.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-search" method="post" path="/api/search" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.PlatformSearchRequest;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSearchResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSearchRequest req = PlatformSearchRequest.builder()
                .query("quarterly planning 2026")
                .build();

        PlatformSearchResponse res = sdk.search().query()
                .request(req)
                .call();

        if (res.platformSearchResponse().isPresent()) {
            System.out.println(res.platformSearchResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [PlatformSearchRequest](../../models/shared/PlatformSearchRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[PlatformSearchResponse](../../models/operations/PlatformSearchResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 413, 422, 429       | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## listFilters

List datasources and common built-in filter fields visible to the authenticated user. This is a best-effort catalog, not an exhaustive list of every filter search accepts.
Without `query`, returns field metadata only and does not run a search. With a nonblank `query`, provide exactly one `datasources` value to request suggested filter values for that query; no documents are returned and this endpoint does not include warning objects. See `FilterFieldInfo.values` for limitations on suggested values. Rate-limited requests return HTTP 429 with `Retry-After`; temporary backend unavailability returns HTTP 503.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-search-filters" method="get" path="/api/search/filters" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSearchFiltersResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSearchFiltersResponse res = sdk.search().listFilters()
                .call();

        if (res.platformSearchFiltersResponse().isPresent()) {
            System.out.println(res.platformSearchFiltersResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                  | Type                                                                                                                                                                                                                                       | Required                                                                                                                                                                                                                                   | Description                                                                                                                                                                                                                                |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `datasources`                                                                                                                                                                                                                              | List\<*String*>                                                                                                                                                                                                                            | :heavy_minus_sign:                                                                                                                                                                                                                         | Restrict metadata to one or more datasource identifiers as returned by this endpoint (for example, `jira`). With a nonblank `query`, exactly one datasource is required. Unknown or inaccessible identifiers return `invalid_datasource`.<br/> |
| `query`                                                                                                                                                                                                                                    | *Optional\<String>*                                                                                                                                                                                                                        | :heavy_minus_sign:                                                                                                                                                                                                                         | Optional search query that requests suggested filter values for the selected datasource. Must be nonblank when present. Triggers a search for facet values only; does not return documents.<br/>                                           |

### Response

**[PlatformSearchFiltersResponse](../../models/operations/PlatformSearchFiltersResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |