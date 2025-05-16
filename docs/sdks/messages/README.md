# Messages
(*client().messages()*)

## Overview

### Available Operations

* [retrieve](#retrieve) - Read messages

## retrieve

Retrieves list of messages from messaging/chat datasources (e.g. Slack, Teams).

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.MessagesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        MessagesRequest req = MessagesRequest.builder()
                .idType(IdType.CONVERSATION_ID)
                .id("<id>")
                .build();

        MessagesResponse res = sdk.client().messages().retrieve()
                .request(req)
                .call();

        if (res.messagesResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                 | Type                                                      | Required                                                  | Description                                               |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| `request`                                                 | [MessagesRequest](../../models/shared/MessagesRequest.md) | :heavy_check_mark:                                        | The request object to use for the request.                |

### Response

**[MessagesResponse](../../models/operations/MessagesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |