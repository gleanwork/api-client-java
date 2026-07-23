# Search

## Overview

### Available Operations

* [query](#query) - Search
* [listFilters](#listfilters) - List search filters

## query

Execute a search query and retrieve ranked results. This is the data retrieval variant of the search API and returns only results and pagination state. Structured filters accept the eleven exact lowercase public built-ins and free-form custom fields. Custom and unknown fields are forwarded without spelling, existence, type, ambiguity, or operator-compatibility validation, so behavior is backend-dependent.
Successful responses always include a non-nullable `warnings` array (`[]` when empty). When results are incomplete for the requested datasource scope, the response remains HTTP 200 with `results`, `has_more`, and `next_cursor` preserved and a `results_incomplete` warning. Query outcomes that cannot be honored return HTTP 422 `unprocessable_query` and suppress results and cursor; invalid inline operators may include a nested `/query` `invalid_filter` issue. Backend work and audit logging may already have occurred before such a 422 replaces a result-bearing response. Structural and representability failures remain HTTP 400. Rate limits return HTTP 429 with `Retry-After`. Temporary backend unavailability returns HTTP 503.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-search" method="post" path="/api/search" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.PlatformFilter;
import com.glean.api_client.glean_api_client.models.components.PlatformSearchRequest;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSearchResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSearchRequest req = PlatformSearchRequest.builder()
                .query("quarterly planning 2026")
                .datasources(List.of(
                    "confluence",
                    "google_drive"))
                .filters(List.of(
                    PlatformFilter.builder()
                        .field("type")
                        .values(List.of(
                            "spreadsheet",
                            "presentation"))
                        .build()))
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

Discover caller-visible datasources and common built-in filter fields that can be used with Platform Search. This is a best-effort common catalog, not an authoritative inventory of every field search may accept.
Without `query`, the response returns datasource rows and field metadata without executing search. With a nonblank `query`, exactly one `datasources` value is required and the response may include bounded, non-exhaustive facet values for matching public fields.


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

| Parameter                                                                                                                                   | Type                                                                                                                                        | Required                                                                                                                                    | Description                                                                                                                                 |
| ------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- |
| `datasources`                                                                                                                               | List\<*String*>                                                                                                                             | :heavy_minus_sign:                                                                                                                          | Restrict metadata to one or more canonical normalized datasource identifiers. With a nonblank `query`, exactly one datasource is required.<br/> |
| `query`                                                                                                                                     | *Optional\<String>*                                                                                                                         | :heavy_minus_sign:                                                                                                                          | Optional search query used to request bounded facet values for the selected datasource. When present it must be nonblank.<br/>              |

### Response

**[PlatformSearchFiltersResponse](../../models/operations/PlatformSearchFiltersResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |