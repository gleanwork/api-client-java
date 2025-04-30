# Activities
(*client().activities()*)

## Overview

### Available Operations

* [reportActivity](#reportactivity) - Report client activity

## reportActivity

Report events that happen to results within a Glean client UI, such as search result views and clicks.  This signal improves search quality.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.Event;
import com.glean.api_client.models.components.Feedback;
import com.glean.api_client.models.operations.FeedbackResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        FeedbackResponse res = sdk.client().activities().reportActivity()
                .feedback1(Feedback.builder()
                    .trackingTokens(List.of(
                        "trackingTokens"))
                    .event(Event.VIEW)
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              | Example                                                                                                                  |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xGleanActAs`                                                                                                            | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |                                                                                                                          |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |                                                                                                                          |
| `feedbackQueryParameter`                                                                                                 | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | A URL encoded versions of Feedback. This is useful for requests.                                                         |                                                                                                                          |
| `feedback1`                                                                                                              | [Optional\<Feedback>](../../models/components/Feedback.md)                                                               | :heavy_minus_sign:                                                                                                       | N/A                                                                                                                      | {<br/>"trackingTokens": [<br/>"trackingTokens"<br/>],<br/>"event": "VIEW"<br/>}                                          |

### Response

**[FeedbackResponse](../../models/operations/FeedbackResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |