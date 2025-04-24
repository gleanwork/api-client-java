# IndexingDocuments
(*indexing().documents()*)

## Overview

### Available Operations

* [addOrUpdate](#addorupdate) - Index document
* [index](#index) - Index documents
* [bulkIndex](#bulkindex) - Bulk index documents
* [processAll](#processall) - Schedules the processing of uploaded documents
* [delete](#delete) - Delete document

## addOrUpdate

Adds a document to the index or updates an existing document.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DocumentDefinition;
import com.glean.api_client.models.components.IndexDocumentRequest;
import com.glean.api_client.models.operations.PostApiIndexV1IndexdocumentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        IndexDocumentRequest req = IndexDocumentRequest.builder()
                .document(DocumentDefinition.builder()
                    .datasource("<value>")
                    .build())
                .build();

        PostApiIndexV1IndexdocumentResponse res = sdk.indexing().documents().addOrUpdate()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `request`                                                           | [IndexDocumentRequest](../../models/shared/IndexDocumentRequest.md) | :heavy_check_mark:                                                  | The request object to use for the request.                          |

### Response

**[PostApiIndexV1IndexdocumentResponse](../../models/operations/PostApiIndexV1IndexdocumentResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## index

Adds or updates multiple documents in the index. Please refer to the [bulk indexing](https://developers.glean.com/docs/indexing_api_bulk_indexing/#choosing-indexdocuments-vs-bulkindexdocuments) documentation for an explanation of when to use this endpoint.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DocumentDefinition;
import com.glean.api_client.models.components.IndexDocumentsRequest;
import com.glean.api_client.models.operations.PostApiIndexV1IndexdocumentsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        IndexDocumentsRequest req = IndexDocumentsRequest.builder()
                .datasource("<value>")
                .documents(List.of(
                    DocumentDefinition.builder()
                        .datasource("<value>")
                        .build()))
                .build();

        PostApiIndexV1IndexdocumentsResponse res = sdk.indexing().documents().index()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [IndexDocumentsRequest](../../models/shared/IndexDocumentsRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[PostApiIndexV1IndexdocumentsResponse](../../models/operations/PostApiIndexV1IndexdocumentsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## bulkIndex

Replaces the documents in a datasource using paginated batch API calls. Please refer to the [bulk indexing](https://developers.glean.com/docs/indexing_api_bulk_indexing/#bulk-upload-model) documentation for an explanation of how to use bulk endpoints.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.BulkIndexDocumentsRequest;
import com.glean.api_client.models.components.DocumentDefinition;
import com.glean.api_client.models.operations.PostApiIndexV1BulkindexdocumentsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        BulkIndexDocumentsRequest req = BulkIndexDocumentsRequest.builder()
                .uploadId("<id>")
                .datasource("<value>")
                .documents(List.of(
                    DocumentDefinition.builder()
                        .datasource("<value>")
                        .build()))
                .build();

        PostApiIndexV1BulkindexdocumentsResponse res = sdk.indexing().documents().bulkIndex()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `request`                                                                     | [BulkIndexDocumentsRequest](../../models/shared/BulkIndexDocumentsRequest.md) | :heavy_check_mark:                                                            | The request object to use for the request.                                    |

### Response

**[PostApiIndexV1BulkindexdocumentsResponse](../../models/operations/PostApiIndexV1BulkindexdocumentsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## processAll

Schedules the immediate processing of documents uploaded through the indexing API. By default the uploaded documents will be processed asynchronously but this API can be used to schedule processing of all documents on demand.

If a `datasource` parameter is specified, processing is limited to that custom datasource. Without it, processing applies to all documents across all custom datasources.
#### Rate Limits
This endpoint is rate-limited to one usage every 3 hours. Exceeding this limit results in a 429 response code. Here's how the rate limit works:
1. Calling `/processalldocuments` for datasource `foo` prevents another call for `foo` for 3 hours.
2. Calling `/processalldocuments` for datasource `foo` doesn't affect immediate calls for `bar`.
3. Calling `/processalldocuments` for all datasources prevents any datasource calls for 3 hours.
4. Calling `/processalldocuments` for datasource `foo` doesn't affect immediate calls for all datasources.

For more frequent document processing, contact Glean support.


### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.ProcessAllDocumentsRequest;
import com.glean.api_client.models.operations.PostApiIndexV1ProcessalldocumentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ProcessAllDocumentsRequest req = ProcessAllDocumentsRequest.builder()
                .build();

        PostApiIndexV1ProcessalldocumentsResponse res = sdk.indexing().documents().processAll()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [ProcessAllDocumentsRequest](../../models/shared/ProcessAllDocumentsRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[PostApiIndexV1ProcessalldocumentsResponse](../../models/operations/PostApiIndexV1ProcessalldocumentsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## delete

Deletes the specified document from the index. Succeeds if document is not present.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteDocumentRequest;
import com.glean.api_client.models.operations.PostApiIndexV1DeletedocumentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteDocumentRequest req = DeleteDocumentRequest.builder()
                .datasource("<value>")
                .objectType("<value>")
                .id("<id>")
                .build();

        PostApiIndexV1DeletedocumentResponse res = sdk.indexing().documents().delete()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [DeleteDocumentRequest](../../models/shared/DeleteDocumentRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[PostApiIndexV1DeletedocumentResponse](../../models/operations/PostApiIndexV1DeletedocumentResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |