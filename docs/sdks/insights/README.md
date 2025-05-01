# Insights
(*client().insights()*)

## Overview

### Available Operations

* [get](#get) - Read insights

## get

Reads the aggregate information for each user, query, and content.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.InsightsRequest;
import com.glean.api_client.models.components.InsightsRequestCategory;
import com.glean.api_client.models.operations.InsightsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        InsightsResponse res = sdk.client().insights().get()
                .insightsRequest(InsightsRequest.builder()
                    .categories(List.of(
                        InsightsRequestCategory.CONTENT,
                        InsightsRequestCategory.CONTENT))
                    .build())
                .call();

        if (res.insightsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xGleanActAs`                                                                                                            | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `insightsRequest`                                                                                                        | [InsightsRequest](../../models/components/InsightsRequest.md)                                                            | :heavy_check_mark:                                                                                                       | Includes request params for insights dashboard data.                                                                     |

### Response

**[InsightsResponse](../../models/operations/InsightsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |