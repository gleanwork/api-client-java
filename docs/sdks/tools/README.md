# Tools
(*client().tools()*)

## Overview

### Available Operations

* [list](#list) - List available tools
* [run](#run) - Execute the specified tool

## list

Returns a filtered set of available tools based on optional tool name parameters. If no filters are provided, all available tools are returned.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.GetRestApiV1ToolsListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetRestApiV1ToolsListResponse res = sdk.client().tools().list()
                .call();

        if (res.toolsListResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                 | Type                                      | Required                                  | Description                               |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| `toolNames`                               | List\<*String*>                           | :heavy_minus_sign:                        | Optional array of tool names to filter by |

### Response

**[GetRestApiV1ToolsListResponse](../../models/operations/GetRestApiV1ToolsListResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## run

Execute the specified tool with provided parameters

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.ToolsCallParameter;
import com.glean.api_client.glean_api_client.models.components.ToolsCallRequest;
import com.glean.api_client.glean_api_client.models.operations.PostRestApiV1ToolsCallResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ToolsCallRequest req = ToolsCallRequest.builder()
                .name("<value>")
                .parameters(Map.ofEntries(
                    Map.entry("key", ToolsCallParameter.builder()
                        .name("<value>")
                        .value("<value>")
                        .build())))
                .build();

        PostRestApiV1ToolsCallResponse res = sdk.client().tools().run()
                .request(req)
                .call();

        if (res.toolsCallResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                   | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `request`                                                   | [ToolsCallRequest](../../models/shared/ToolsCallRequest.md) | :heavy_check_mark:                                          | The request object to use for the request.                  |

### Response

**[PostRestApiV1ToolsCallResponse](../../models/operations/PostRestApiV1ToolsCallResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |