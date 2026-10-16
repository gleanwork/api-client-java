# Documents

## Overview

### Available Operations

* [getByUrl](#getbyurl) - Get document by URL
* [getById](#getbyid) - Get document by ID
* [batch](#batch) - Batch get documents

## getByUrl

Retrieve one permission-visible indexed document by URL. The url is the lookup key that Platform search returns. Many URLs can resolve to one document. The response is a single document, not a list. The returned url is the permalink and may differ from the submitted URL. Gmail and Outlook search results and chat citations carry caller-specific IDs that get document by ID cannot resolve, so retrieve them by URL here. A Gmail or Outlook URL that Platform search returned can still return 404, as it can with legacy getdocuments. Retrieving search results is best-effort parity with legacy getdocuments. Federated results and go-link shortcut documents are not retrievable in this release.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-documents-get-by-url" method="get" path="/api/documents" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformDocumentsGetByUrlResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformDocumentsGetByUrlResponse res = sdk.documents().getByUrl()
                .url("{url}")
                .call();

        if (res.platformDocumentGetResponse().isPresent()) {
            System.out.println(res.platformDocumentGetResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                           | Type                                                                                                                                | Required                                                                                                                            | Description                                                                                                                         | Example                                                                                                                             |
| ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- |
| `url`                                                                                                                               | *String*                                                                                                                            | :heavy_check_mark:                                                                                                                  | URL of the document to retrieve.                                                                                                    | {url}                                                                                                                               |
| `include`                                                                                                                           | List\<[PlatformDocumentInclude](../../models/components/PlatformDocumentInclude.md)>                                                | :heavy_minus_sign:                                                                                                                  | Optional field groups to add to each found document. Each value only adds fields; it does not change which documents are returned.<br/> |                                                                                                                                     |

### Response

**[PlatformDocumentsGetByUrlResponse](../../models/operations/PlatformDocumentsGetByUrlResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## getById

Retrieve one permission-visible indexed document by its Glean store ID. Gmail and Outlook search results and chat citations can carry caller-specific IDs that this operation cannot resolve. Try get document by URL for those documents. URL lookup does not resolve every Gmail or Outlook result.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-documents-get" method="get" path="/api/documents/{document_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformDocumentsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformDocumentsGetResponse res = sdk.documents().getById()
                .documentId("{document_id}")
                .call();

        if (res.platformDocumentGetResponse().isPresent()) {
            System.out.println(res.platformDocumentGetResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                           | Type                                                                                                                                | Required                                                                                                                            | Description                                                                                                                         | Example                                                                                                                             |
| ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- |
| `documentId`                                                                                                                        | *String*                                                                                                                            | :heavy_check_mark:                                                                                                                  | Indexed Glean store ID. For a Gmail or Outlook citation with a caller-specific ID, try get document by URL instead.<br/>            | {document_id}                                                                                                                       |
| `include`                                                                                                                           | List\<[PlatformDocumentInclude](../../models/components/PlatformDocumentInclude.md)>                                                | :heavy_minus_sign:                                                                                                                  | Optional field groups to add to each found document. Each value only adds fields; it does not change which documents are returned.<br/> |                                                                                                                                     |

### Response

**[PlatformDocumentsGetResponse](../../models/operations/PlatformDocumentsGetResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## batch

Retrieve up to 100 permission-visible indexed documents by URL or document_id. Found items are in results. Complete misses are warnings correlated by index. Incomplete store work fails the whole request. Retrieving search results is best-effort parity with legacy getdocuments. Gmail and Outlook caller-specific citation IDs are not accepted as document_id selectors. Use URL selectors for them. A Gmail or Outlook URL can still return a resource_not_found warning. Federated results and go-link shortcut documents are not retrievable in this release.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-documents-batch" method="post" path="/api/documents/batch" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformDocumentsBatchResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformDocumentsBatchRequest req = PlatformDocumentsBatchRequest.builder()
                .documentSpecs(List.of(
                    PlatformDocumentsBatchRequestDocumentSpec.of(PlatformDocumentsBatchSpecById.builder()
                        .documentId("{document_id}")
                        .build()),
                    PlatformDocumentsBatchRequestDocumentSpec.of(PlatformDocumentsBatchSpecByUrl.builder()
                        .url("https://company.atlassian.net/wiki/spaces/ENG/pages/12345")
                        .build())))
                .build();

        PlatformDocumentsBatchResponse res = sdk.documents().batch()
                .request(req)
                .call();

        if (res.platformDocumentsBatchResponse().isPresent()) {
            System.out.println(res.platformDocumentsBatchResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `request`                                                                             | [PlatformDocumentsBatchRequest](../../models/shared/PlatformDocumentsBatchRequest.md) | :heavy_check_mark:                                                                    | The request object to use for the request.                                            |

### Response

**[PlatformDocumentsBatchResponse](../../models/operations/PlatformDocumentsBatchResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 413, 429            | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |