# Tools
(*client().tools()*)

## Overview

### Available Operations

* [executeAction](#executeaction) - Execute Action Tool

## executeAction

Executes an Action tool with the specified parameters.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.ExecuteActionToolRequest;
import com.glean.api_client.models.operations.ExecuteactiontoolResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ExecuteactiontoolResponse res = sdk.client().tools().executeAction()
                .executeActionToolRequest(ExecuteActionToolRequest.builder()
                    .name("<value>")
                    .build())
                .call();

        if (res.executeActionToolResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                  | Type                                                                                                       | Required                                                                                                   | Description                                                                                                |
| ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| `timezoneOffset`                                                                                           | *Optional\<Long>*                                                                                          | :heavy_minus_sign:                                                                                         | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC. |
| `executeActionToolRequest`                                                                                 | [ExecuteActionToolRequest](../../models/components/ExecuteActionToolRequest.md)                            | :heavy_check_mark:                                                                                         | Execute Action Tool request                                                                                |

### Response

**[ExecuteactiontoolResponse](../../models/operations/ExecuteactiontoolResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |