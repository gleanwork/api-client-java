# Summarize
(*client().summarize()*)

## Overview

### Available Operations

* [generate](#generate) - Summarize documents

## generate

Generate an AI summary of the requested documents.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.SummarizeResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        SummarizeResponse res = sdk.client().summarize().generate()
                .summarizeRequest(SummarizeRequest.builder()
                    .documentSpecs(List.of(
                        DocumentSpecUnion.of(DocumentSpec1.builder()
                            .build()),
                        DocumentSpecUnion.of(DocumentSpec1.builder()
                            .build())))
                    .build())
                .call();

        if (res.summarizeResponse().isPresent()) {
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
| `summarizeRequest`                                                                                                       | [SummarizeRequest](../../models/components/SummarizeRequest.md)                                                          | :heavy_check_mark:                                                                                                       | Includes request params such as the query and specs of the documents to summarize.                                       |

### Response

**[SummarizeResponse](../../models/operations/SummarizeResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |