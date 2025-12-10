# Client.Insights

## Overview

### Available Operations

* [retrieve](#retrieve) - Get insights

## retrieve

Gets the aggregate usage insights data displayed in the Insights Dashboards.

### Example Usage

<!-- UsageSnippet language="java" operationID="insights" method="post" path="/rest/api/v1/insights" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.InsightsRequest;
import com.glean.api_client.glean_api_client.models.operations.InsightsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        InsightsRequest req = InsightsRequest.builder()
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