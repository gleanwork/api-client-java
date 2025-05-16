# Insights
(*client().insights()*)

## Overview

### Available Operations

* [retrieve](#retrieve) - Read insights

## retrieve

Reads the aggregate information for each user, query, and content.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.InsightsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        InsightsRequest req = InsightsRequest.builder()
                .categories(List.of(
                    InsightsRequestCategory.COLLECTIONS,
                    InsightsRequestCategory.SHORTCUTS,
                    InsightsRequestCategory.ANNOUNCEMENTS))
                .build();

        InsightsResponse res = sdk.client().insights().retrieve()
                .request(req)
                .call();

        if (res.insightsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                 | Type                                                      | Required                                                  | Description                                               |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| `request`                                                 | [InsightsRequest](../../models/shared/InsightsRequest.md) | :heavy_check_mark:                                        | The request object to use for the request.                |

### Response

**[InsightsResponse](../../models/operations/InsightsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |