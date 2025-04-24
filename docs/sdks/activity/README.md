# Activity
(*client().activity()*)

## Overview

### Available Operations

* [report](#report) - Report document activity

## report

Report user activity that occurs on indexed documents such as viewing or editing. This signal improves search quality.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.ActivityResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        Activity req = Activity.builder()
                .events(List.of(
                    ActivityEvent.builder()
                        .action(ActivityEventAction.HISTORICAL_VIEW)
                        .timestamp(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                        .url("https://example.com/")
                        .build(),
                    ActivityEvent.builder()
                        .action(ActivityEventAction.SEARCH)
                        .timestamp(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                        .url("https://example.com/search?q=query")
                        .params(ActivityEventParams.builder()
                            .query("query")
                            .build())
                        .build(),
                    ActivityEvent.builder()
                        .action(ActivityEventAction.VIEW)
                        .timestamp(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                        .url("https://example.com/")
                        .params(ActivityEventParams.builder()
                            .duration(20L)
                            .referrer("https://example.com/document")
                            .build())
                        .build()))
                .build();

        ActivityResponse res = sdk.client().activity().report()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                   | Type                                        | Required                                    | Description                                 |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| `request`                                   | [Activity](../../models/shared/Activity.md) | :heavy_check_mark:                          | The request object to use for the request.  |

### Response

**[ActivityResponse](../../models/operations/ActivityResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |