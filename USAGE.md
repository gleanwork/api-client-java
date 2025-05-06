<!-- Start SDK Example Usage [usage] -->
```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.ChatResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ChatResponse res = sdk.client().chat().create()
                .chatRequest(ChatRequest.builder()
                    .messages(List.of(
                        ChatMessage.builder()
                            .fragments(List.of(
                                ChatMessageFragment.builder()
                                    .text("What are the company holidays this year?")
                                    .build()))
                            .build()))
                    .build())
                .call();

        if (res.chatResponse().isPresent()) {
            // handle response
        }
    }
}
```

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.ChatStreamResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ChatStreamResponse res = sdk.client().chat().createStream()
                .chatRequest(ChatRequest.builder()
                    .messages(List.of(
                        ChatMessage.builder()
                            .fragments(List.of(
                                ChatMessageFragment.builder()
                                    .text("What are the company holidays this year?")
                                    .build()))
                            .build()))
                    .build())
                .call();

        if (res.chatRequestStream().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->