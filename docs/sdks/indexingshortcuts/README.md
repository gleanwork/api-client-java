# IndexingShortcuts
(*indexing().shortcuts()*)

## Overview

### Available Operations

* [bulkIndex](#bulkindex) - Bulk index external shortcuts
* [upload](#upload) - Upload shortcuts

## bulkIndex

Replaces all the currently indexed shortcuts using paginated batch API calls. Note that this endpoint is used for indexing shortcuts not hosted by Glean. If you want to upload shortcuts that would be hosted by Glean, please use the `/uploadshortcuts` endpoint. For information on what you can do with Golinks, which are Glean-hosted shortcuts, please refer to [this](https://help.glean.com/en/articles/5628838-how-go-links-work) page.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1BulkindexshortcutsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        BulkIndexShortcutsRequest req = BulkIndexShortcutsRequest.builder()
                .uploadId("<id>")
                .shortcuts(List.of(
                    ExternalShortcut.builder()
                        .inputAlias("<value>")
                        .destinationUrl("https://plump-tune-up.biz/")
                        .createdBy("<value>")
                        .intermediateUrl("https://lean-sightseeing.net")
                        .build(),
                    ExternalShortcut.builder()
                        .inputAlias("<value>")
                        .destinationUrl("https://plump-tune-up.biz/")
                        .createdBy("<value>")
                        .intermediateUrl("https://lean-sightseeing.net")
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

## upload

Creates glean shortcuts for uploaded shortcuts info. Glean would host the shortcuts, and they can be managed in the knowledge tab once uploaded.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1UploadshortcutsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        UploadShortcutsRequest req = UploadShortcutsRequest.builder()
                .uploadId("<id>")
                .shortcuts(List.of(
                    IndexingShortcut.builder()
                        .inputAlias("<value>")
                        .destinationUrl("https://majestic-pharmacopoeia.info/")
                        .createdBy("<value>")
                        .build(),
                    IndexingShortcut.builder()
                        .inputAlias("<value>")
                        .destinationUrl("https://majestic-pharmacopoeia.info/")
                        .createdBy("<value>")
                        .build(),
                    IndexingShortcut.builder()
                        .inputAlias("<value>")
                        .destinationUrl("https://majestic-pharmacopoeia.info/")
                        .createdBy("<value>")
                        .build()))
                .build();

        PostApiIndexV1UploadshortcutsResponse res = sdk.indexing().shortcuts().upload()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [UploadShortcutsRequest](../../models/shared/UploadShortcutsRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[PostApiIndexV1UploadshortcutsResponse](../../models/operations/PostApiIndexV1UploadshortcutsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |