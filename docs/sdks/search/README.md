# Search

## Overview

### Available Operations

* [query](#query) - Search

## query

Execute a search query and retrieve ranked results. This is the data retrieval variant of the search API and returns only results and pagination state.


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
                .datasourceInstances(List.of(
                    "slack_acme",
                    "slack_eu"))
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
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 413, 429            | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |