# Chat

## Overview

### Available Operations

* [create](#create) - Create a chat response

## create

Run an assistant turn. Set `stream` to true to receive server-sent events; otherwise the response is a typed JSON response object.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-chat-create" method="post" path="/api/chat" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.Input;
import com.glean.api_client.glean_api_client.models.components.PlatformChatCreateRequest;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformChatCreateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformChatCreateRequest req = PlatformChatCreateRequest.builder()
                .input(Input.of("<value>"))
                .build();

        PlatformChatCreateResponse res = sdk.chat().create()
                .request(req)
                .call();

        if (res.platformChatCompletedResponse().isPresent()) {
            System.out.println(res.platformChatCompletedResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `request`                                                                     | [PlatformChatCreateRequest](../../models/shared/PlatformChatCreateRequest.md) | :heavy_check_mark:                                                            | The request object to use for the request.                                    |

### Response

**[PlatformChatCreateResponse](../../models/operations/PlatformChatCreateResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 413, 422, 429       | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |