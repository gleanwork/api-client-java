# IndexingShortcuts
(*indexing().shortcuts()*)

## Overview

### Available Operations

* [bulkIndex](#bulkindex) - Bulk index external shortcuts

## bulkIndex

Replaces all the currently indexed shortcuts using paginated batch API calls. Note that this endpoint is used for indexing shortcuts not hosted by Glean. If you want to upload shortcuts that would be hosted by Glean, please use the `/uploadshortcuts` endpoint. For information on what you can do with Golinks, which are Glean-hosted shortcuts, please refer to [this](https://help.glean.com/en/articles/5628838-how-go-links-work) page.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.BulkIndexShortcutsRequest;
import com.glean.api_client.models.components.ExternalShortcut;
import com.glean.api_client.models.operations.PostApiIndexV1BulkindexshortcutsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        BulkIndexShortcutsRequest req = BulkIndexShortcutsRequest.builder()
                .uploadId("<id>")
                .shortcuts(List.of(
                    ExternalShortcut.builder()
                        .inputAlias("<value>")
                        .destinationUrl("https://only-juggernaut.com/")
                        .createdBy("<value>")
                        .intermediateUrl("https://descriptive-electronics.name")
                        .build()))
                .build();

        PostApiIndexV1BulkindexshortcutsResponse res = sdk.indexing().shortcuts().bulkIndex()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `request`                                                                     | [BulkIndexShortcutsRequest](../../models/shared/BulkIndexShortcutsRequest.md) | :heavy_check_mark:                                                            | The request object to use for the request.                                    |

### Response

**[PostApiIndexV1BulkindexshortcutsResponse](../../models/operations/PostApiIndexV1BulkindexshortcutsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |