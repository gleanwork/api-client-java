# Indexing.Documents

## Overview

### Available Operations

* [addOrUpdate](#addorupdate) - Index document
* [index](#index) - Index documents
* [bulkIndex](#bulkindex) - Bulk index documents
* [processAll](#processall) - Schedules the processing of uploaded documents
* [delete](#delete) - Delete document
* [debug](#debug) - Beta: Get document information

* [debugMany](#debugmany) - Beta: Get information of a batch of documents

* [checkAccess](#checkaccess) - Check document access
* [~~status~~](#status) - Get document upload and indexing status :warning: **Deprecated**
* [~~count~~](#count) - Get document count :warning: **Deprecated**

## addOrUpdate

Adds a document to the index or updates an existing document.

### Example Usage

<!-- UsageSnippet language="java" operationID="post_/api/index/v1/indexdocument" method="post" path="/api/index/v1/indexdocument" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DocumentDefinition;
import com.glean.api_client.glean_api_client.models.components.IndexDocumentRequest;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1IndexdocumentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
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

Adds or updates multiple documents in the index. Please refer to the [bulk indexing](https://developers.glean.com/indexing/documents/bulk-indexing/choosing-indexdocuments-vs-bulkindexdocuments) documentation for an explanation of when to use this endpoint.

### Example Usage

<!-- UsageSnippet language="java" operationID="post_/api/index/v1/indexdocuments" method="post" path="/api/index/v1/indexdocuments" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.IndexDocumentsRequest;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1IndexdocumentsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        IndexDocumentsRequest req = IndexDocumentsRequest.builder()
                .datasource("<value>")
                .documents(List.of())
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

Replaces the documents in a datasource using paginated batch API calls. Please refer to the [bulk indexing](https://developers.glean.com/indexing/documents/bulk-upload-model) documentation for an explanation of how to use bulk endpoints.

### Example Usage

<!-- UsageSnippet language="java" operationID="post_/api/index/v1/bulkindexdocuments" method="post" path="/api/index/v1/bulkindexdocuments" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.BulkIndexDocumentsRequest;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1BulkindexdocumentsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        BulkIndexDocumentsRequest req = BulkIndexDocumentsRequest.builder()
                .uploadId("<id>")
                .datasource("<value>")
                .documents(List.of())
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

<!-- UsageSnippet language="java" operationID="post_/api/index/v1/processalldocuments" method="post" path="/api/index/v1/processalldocuments" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1ProcessalldocumentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PostApiIndexV1ProcessalldocumentsResponse res = sdk.indexing().documents().processAll()
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

<!-- UsageSnippet language="java" operationID="post_/api/index/v1/deletedocument" method="post" path="/api/index/v1/deletedocument" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DeleteDocumentRequest;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1DeletedocumentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
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

## debug

Gives various information that would help in debugging related to a particular document. Currently in beta, might undergo breaking changes without prior notice.

Tip: Refer to the [Troubleshooting tutorial](https://developers.glean.com/indexing/debugging/datasource-config) for more information.


### Example Usage

<!-- UsageSnippet language="java" operationID="post_/api/index/v1/debug/{datasource}/document" method="post" path="/api/index/v1/debug/{datasource}/document" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DebugDocumentRequest;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1DebugDatasourceDocumentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PostApiIndexV1DebugDatasourceDocumentResponse res = sdk.indexing().documents().debug()
                .datasource("<value>")
                .debugDocumentRequest(DebugDocumentRequest.builder()
                    .objectType("Article")
                    .docId("art123")
                    .build())
                .call();

        if (res.debugDocumentResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `datasource`                                                            | *String*                                                                | :heavy_check_mark:                                                      | The datasource to which the document belongs                            |
| `debugDocumentRequest`                                                  | [DebugDocumentRequest](../../models/components/DebugDocumentRequest.md) | :heavy_check_mark:                                                      | N/A                                                                     |

### Response

**[PostApiIndexV1DebugDatasourceDocumentResponse](../../models/operations/PostApiIndexV1DebugDatasourceDocumentResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## debugMany

Gives various information that would help in debugging related to a batch of documents. Currently in beta, might undergo breaking changes without prior notice.

Tip: Refer to the [Troubleshooting tutorial](https://developers.glean.com/indexing/debugging/datasource-config) for more information.


### Example Usage

<!-- UsageSnippet language="java" operationID="post_/api/index/v1/debug/{datasource}/documents" method="post" path="/api/index/v1/debug/{datasource}/documents" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DebugDocumentRequest;
import com.glean.api_client.glean_api_client.models.components.DebugDocumentsRequest;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1DebugDatasourceDocumentsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PostApiIndexV1DebugDatasourceDocumentsResponse res = sdk.indexing().documents().debugMany()
                .datasource("<value>")
                .debugDocumentsRequest(DebugDocumentsRequest.builder()
                    .debugDocuments(List.of(
                        DebugDocumentRequest.builder()
                            .objectType("Article")
                            .docId("art123")
                            .build()))
                    .build())
                .call();

        if (res.debugDocumentsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `datasource`                                                              | *String*                                                                  | :heavy_check_mark:                                                        | The datasource to which the document belongs                              |
| `debugDocumentsRequest`                                                   | [DebugDocumentsRequest](../../models/components/DebugDocumentsRequest.md) | :heavy_check_mark:                                                        | N/A                                                                       |

### Response

**[PostApiIndexV1DebugDatasourceDocumentsResponse](../../models/operations/PostApiIndexV1DebugDatasourceDocumentsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## checkAccess

Check if a given user has access to access a document in a custom datasource

Tip: Refer to the [Troubleshooting tutorial](https://developers.glean.com/indexing/debugging/datasource-config) for more information.


### Example Usage

<!-- UsageSnippet language="java" operationID="post_/api/index/v1/checkdocumentaccess" method="post" path="/api/index/v1/checkdocumentaccess" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.CheckDocumentAccessRequest;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1CheckdocumentaccessResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        CheckDocumentAccessRequest req = CheckDocumentAccessRequest.builder()
                .datasource("<value>")
                .objectType("<value>")
                .docId("<id>")
                .userEmail("<value>")
                .build();

        PostApiIndexV1CheckdocumentaccessResponse res = sdk.indexing().documents().checkAccess()
                .request(req)
                .call();

        if (res.checkDocumentAccessResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [CheckDocumentAccessRequest](../../models/shared/CheckDocumentAccessRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[PostApiIndexV1CheckdocumentaccessResponse](../../models/operations/PostApiIndexV1CheckdocumentaccessResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## ~~status~~

Intended for debugging/validation. Fetches the current upload and indexing status of documents.

Tip: Use [/debug/{datasource}/document](https://developers.glean.com/indexing/debugging/datasource-document) for richer information.


> :warning: **DEPRECATED**: Deprecated on 2026-02-03, removal scheduled for 2026-10-15: Endpoint is deprecated.

### Example Usage

<!-- UsageSnippet language="java" operationID="post_/api/index/v1/getdocumentstatus" method="post" path="/api/index/v1/getdocumentstatus" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.GetDocumentStatusRequest;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1GetdocumentstatusResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetDocumentStatusRequest req = GetDocumentStatusRequest.builder()
                .datasource("<value>")
                .objectType("<value>")
                .docId("<id>")
                .build();

        PostApiIndexV1GetdocumentstatusResponse res = sdk.indexing().documents().status()
                .request(req)
                .call();

        if (res.getDocumentStatusResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [GetDocumentStatusRequest](../../models/shared/GetDocumentStatusRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[PostApiIndexV1GetdocumentstatusResponse](../../models/operations/PostApiIndexV1GetdocumentstatusResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## ~~count~~

Fetches document count for the specified custom datasource.

Tip: Use [/debug/{datasource}/status](https://developers.glean.com/indexing/debugging/datasource-status) for richer information.


> :warning: **DEPRECATED**: Deprecated on 2026-02-03, removal scheduled for 2026-10-15: Endpoint is deprecated.

### Example Usage

<!-- UsageSnippet language="java" operationID="post_/api/index/v1/getdocumentcount" method="post" path="/api/index/v1/getdocumentcount" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.GetDocumentCountRequest;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1GetdocumentcountResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetDocumentCountRequest req = GetDocumentCountRequest.builder()
                .datasource("<value>")
                .build();

        PostApiIndexV1GetdocumentcountResponse res = sdk.indexing().documents().count()
                .request(req)
                .call();

        if (res.getDocumentCountResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [GetDocumentCountRequest](../../models/shared/GetDocumentCountRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[PostApiIndexV1GetdocumentcountResponse](../../models/operations/PostApiIndexV1GetdocumentcountResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |