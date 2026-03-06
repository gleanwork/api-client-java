# Client.Messages

## Overview

### Available Operations

* [retrieve](#retrieve) - Read messages

## retrieve

Retrieves list of messages from messaging/chat datasources (e.g. Slack, Teams).

### Example Usage

<!-- UsageSnippet language="java" operationID="messages" method="post" path="/rest/api/v1/messages" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.MessagesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        MessagesResponse res = sdk.client().messages().retrieve()
                .messagesRequest(MessagesRequest.builder()
                    .idType(IdType.CONVERSATION_ID)
                    .id("<id>")
                    .datasource(Datasource.GCHAT)
                    .build())
                .call();

        if (res.messagesResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `messagesRequest`                                                                                                                                                                                   | [MessagesRequest](../../models/components/MessagesRequest.md)                                                                                                                                       | :heavy_check_mark:                                                                                                                                                                                  | Includes request params such as the id for channel/message and direction.                                                                                                                           |

### Response

**[MessagesResponse](../../models/operations/MessagesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |