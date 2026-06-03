# Chat

## Overview

### Available Operations

* [getChatFile](#getchatfile) - Download a chat file

## getChatFile

Download the raw content of a file generated or uploaded during a chat session (for example, an image produced by the assistant). Returns the file bytes with a Content-Type header matching the file's MIME type.


### Example Usage

<!-- UsageSnippet language="java" operationID="getChatFile" method="get" path="/rest/api/v1/chat-files/{fileId}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.GetChatFileResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetChatFileResponse res = sdk.chat().getChatFile()
                .fileId("<id>")
                .call();

        if (res.responseStream().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                  | Type                                                                                                                       | Required                                                                                                                   | Description                                                                                                                |
| -------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- |
| `fileId`                                                                                                                   | *String*                                                                                                                   | :heavy_check_mark:                                                                                                         | Identifier of the chat file to download.                                                                                   |
| `preview`                                                                                                                  | *Optional\<Boolean>*                                                                                                       | :heavy_minus_sign:                                                                                                         | When true and the file is a PDF, the response is served inline (Content-Disposition: inline) instead of as an attachment.<br/> |

### Response

**[GetChatFileResponse](../../models/operations/GetChatFileResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |