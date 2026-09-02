# Chat

## Overview

### Available Operations

* [create](#create) - Create a chat response
* [createStream](#createstream) - SDK-only logical operation. HTTP clients must call the base path; the URL fragment is not sent. Create a chat response

## create

Run an assistant turn. Set `stream` to true to receive server-sent events; otherwise the response is a typed JSON response object.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-chat-create" method="post" path="/api/chat" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformChatCreateRequest req = PlatformChatCreateRequest.builder()
                .input(PlatformChatCreateInput.of("What is our parental leave policy?"))
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

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [PlatformChatCreateRequest](../../models/operations/PlatformChatCreateRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[PlatformChatCreateResponse](../../models/operations/PlatformChatCreateResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 413, 422, 429       | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## createStream

SDK-only logical operation. HTTP clients must call the base path; the URL fragment is not sent. Run an assistant turn. Set `stream` to true to receive server-sent events; otherwise the response is a typed JSON response object.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-chat-create-stream" method="post" path="/api/chat#stream" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.PlatformChatStreamEventServerSentEvent;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.*;
import com.glean.api_client.glean_api_client.utils.EventStream;
import java.lang.Exception;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformChatCreateStreamRequest req = PlatformChatCreateStreamRequest.builder()
                .input(PlatformChatCreateStreamInput.of("What is our parental leave policy?"))
                .build();

        PlatformChatCreateStreamResponse res = sdk.chat().createStream()
                .request(req)
                .call();

        // handle event stream, must be closed after use!
        try (EventStream<PlatformChatStreamEventServerSentEvent> events = res.events()) {
            // Option 1: Use for-each loop
            for (PlatformChatStreamEventServerSentEvent event : events) {
                System.out.println(event);
            }

            // Option 2: Use Stream API
            try (Stream<PlatformChatStreamEventServerSentEvent> stream = events.stream()) {
                 stream.forEach(System.out::println);
            }
        }
    }
}
```

### Parameters

| Parameter                                                                                     | Type                                                                                          | Required                                                                                      | Description                                                                                   |
| --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| `request`                                                                                     | [PlatformChatCreateStreamRequest](../../models/operations/PlatformChatCreateStreamRequest.md) | :heavy_check_mark:                                                                            | The request object to use for the request.                                                    |

### Response

**[PlatformChatCreateStreamResponse](../../models/operations/PlatformChatCreateStreamResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 413, 422, 429       | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |