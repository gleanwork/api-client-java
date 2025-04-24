# Messages
(*client().messages()*)

## Overview

### Available Operations

* [get](#get) - Read messages

## get

Retrieves list of messages from messaging/chat datasources (e.g. Slack, Teams).

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.IdType;
import com.glean.api_client.models.components.MessagesRequest;
import com.glean.api_client.models.operations.MessagesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        MessagesResponse res = sdk.client().messages().get()
                .messagesRequest(MessagesRequest.builder()
                    .idType(IdType.CONVERSATION_ID)
                    .id("<id>")
                    .build())
                .call();

        if (res.messagesResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `messagesRequest`                                                                                                        | [MessagesRequest](../../models/components/MessagesRequest.md)                                                            | :heavy_check_mark:                                                                                                       | Includes request params such as the id for channel/message and direction.                                                |

### Response

**[MessagesResponse](../../models/operations/MessagesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |