# Datasource
(*indexing().datasource()*)

## Overview

### Available Operations

* [status](#status) - Beta: Get datasource status


## status

Gather information about the datasource's overall status. Currently in beta, might undergo breaking changes without prior notice.

Tip: Refer to the [Troubleshooting tutorial](https://developers.glean.com/docs/indexing_api/indexing_api_troubleshooting/) for more information.


### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.operations.PostApiIndexV1DebugDatasourceStatusResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
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