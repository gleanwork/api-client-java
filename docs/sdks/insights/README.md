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

        InsightsResponse res = sdk.client().insights().retrieve()
                .insightsRequest(InsightsRequest.builder()
                    .build())
                .call();

        if (res.insightsResponse().isPresent()) {
            System.out.println(res.insightsResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `insightsRequest`                                                                                                                                                                                   | [InsightsRequest](../../models/components/InsightsRequest.md)                                                                                                                                       | :heavy_check_mark:                                                                                                                                                                                  | Includes request parameters for insights requests.                                                                                                                                                  |

### Response

**[InsightsResponse](../../models/operations/InsightsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |