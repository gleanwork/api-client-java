# Troubleshooting

## Overview

### Available Operations

* [postApiIndexV1DebugDatasourceDocumentEvents](#postapiindexv1debugdatasourcedocumentevents) - Beta: Get document lifecycle events


## postApiIndexV1DebugDatasourceDocumentEvents

Retrieves lifecycle events for a specific document including upload time, index times and deletions. Rate limited to 1 request per minute per datasource. Currently in beta, might undergo breaking changes without prior notice.


### Example Usage

<!-- UsageSnippet language="java" operationID="post_/api/index/v1/debug/{datasource}/document/events" method="post" path="/api/index/v1/debug/{datasource}/document/events" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DebugDocumentLifecycleRequest;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1DebugDatasourceDocumentEventsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PostApiIndexV1DebugDatasourceDocumentEventsResponse res = sdk.troubleshooting().postApiIndexV1DebugDatasourceDocumentEvents()
                .datasource("<value>")
                .debugDocumentLifecycleRequest(DebugDocumentLifecycleRequest.builder()
                    .objectType("Article")
                    .docId("art123")
                    .startDate("2025-05-01")
                    .maxEvents(50L)
                    .build())
                .call();

        if (res.debugDocumentLifecycleResponse().isPresent()) {
            System.out.println(res.debugDocumentLifecycleResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `datasource`                                                                              | *String*                                                                                  | :heavy_check_mark:                                                                        | The datasource to which the document belongs                                              |
| `debugDocumentLifecycleRequest`                                                           | [DebugDocumentLifecycleRequest](../../models/components/DebugDocumentLifecycleRequest.md) | :heavy_check_mark:                                                                        | N/A                                                                                       |

### Response

**[PostApiIndexV1DebugDatasourceDocumentEventsResponse](../../models/operations/PostApiIndexV1DebugDatasourceDocumentEventsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |