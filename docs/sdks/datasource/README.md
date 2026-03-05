# Indexing.Datasource

## Overview

### Available Operations

* [status](#status) - Beta: Get datasource status


## status

Gather information about the datasource's overall status. Currently in beta, might undergo breaking changes without prior notice.

Tip: Refer to the [Troubleshooting tutorial](https://developers.glean.com/indexing/debugging/datasource-config) for more information.


### Example Usage

<!-- UsageSnippet language="java" operationID="post_/api/index/v1/debug/{datasource}/status" method="post" path="/api/index/v1/debug/{datasource}/status" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1DebugDatasourceStatusResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PostApiIndexV1DebugDatasourceStatusResponse res = sdk.indexing().datasource().status()
                .datasource("<value>")
                .call();

        if (res.debugDatasourceStatusResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                               | Type                                    | Required                                | Description                             |
| --------------------------------------- | --------------------------------------- | --------------------------------------- | --------------------------------------- |
| `datasource`                            | *String*                                | :heavy_check_mark:                      | The datasource to get debug status for. |

### Response

**[PostApiIndexV1DebugDatasourceStatusResponse](../../models/operations/PostApiIndexV1DebugDatasourceStatusResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |