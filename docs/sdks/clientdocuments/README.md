# ClientDocuments
(*client().documents()*)

## Overview

### Available Operations

* [retrievePermissions](#retrievepermissions) - Read document permissions
* [retrieve](#retrieve) - Read documents
* [retrieveByFacets](#retrievebyfacets) - Read documents by facets
* [summarize](#summarize) - Summarize documents

## retrievePermissions

Read the emails of all users who have access to the given document.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.GetDocPermissionsRequest;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.GetdocpermissionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        GetDocPermissionsRequest req = GetDocPermissionsRequest.builder()
                .build();

        GetdocpermissionsResponse res = sdk.client().documents().retrievePermissions()
                .request(req)
                .call();

        if (res.getDocPermissionsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [GetDocPermissionsRequest](../../models/shared/GetDocPermissionsRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[GetdocpermissionsResponse](../../models/operations/GetdocpermissionsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieve

Read the documents including metadata (does not include enhanced metadata via `/documentmetadata`) for the given list of Glean Document IDs or URLs specified in the request.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.GetdocumentsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        GetDocumentsRequest req = GetDocumentsRequest.builder()
                .documentSpecs(List.of(
                    DocumentSpecUnion.of(DocumentSpec1.builder()
                        .build())))
                .build();

        GetdocumentsResponse res = sdk.client().documents().retrieve()
                .request(req)
                .call();

        if (res.getDocumentsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [GetDocumentsRequest](../../models/shared/GetDocumentsRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[GetdocumentsResponse](../../models/operations/GetdocumentsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieveByFacets

Read the documents including metadata (does not include enhanced metadata via `/documentmetadata`) macthing the given facet conditions.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.GetdocumentsbyfacetsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        GetDocumentsByFacetsRequest req = GetDocumentsByFacetsRequest.builder()
                .filterSets(List.of(
                    FacetFilterSet.builder()
                        .filters(List.of(
                            FacetFilter.builder()
                                .fieldName("type")
                                .values(List.of(
                                    FacetFilterValue.builder()
                                        .value("Spreadsheet")
                                        .relationType(RelationType.EQUALS)
                                        .build(),
                                    FacetFilterValue.builder()
                                        .value("Presentation")
                                        .relationType(RelationType.EQUALS)
                                        .build()))
                                .build()))
                        .build(),
                    FacetFilterSet.builder()
                        .filters(List.of(
                            FacetFilter.builder()
                                .fieldName("type")
                                .values(List.of(
                                    FacetFilterValue.builder()
                                        .value("Spreadsheet")
                                        .relationType(RelationType.EQUALS)
                                        .build(),
                                    FacetFilterValue.builder()
                                        .value("Presentation")
                                        .relationType(RelationType.EQUALS)
                                        .build()))
                                .build()))
                        .build()))
                .build();

        GetdocumentsbyfacetsResponse res = sdk.client().documents().retrieveByFacets()
                .request(req)
                .call();

        if (res.getDocumentsByFacetsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [GetDocumentsByFacetsRequest](../../models/shared/GetDocumentsByFacetsRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[GetdocumentsbyfacetsResponse](../../models/operations/GetdocumentsbyfacetsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## summarize

Generate an AI summary of the requested documents.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.SummarizeResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        SummarizeRequest req = SummarizeRequest.builder()
                .documentSpecs(List.of(
                    DocumentSpecUnion.of(DocumentSpec1.builder()
                        .build()),
                    DocumentSpecUnion.of(DocumentSpec1.builder()
                        .build()),
                    DocumentSpecUnion.of(DocumentSpec1.builder()
                        .build())))
                .build();

        SummarizeResponse res = sdk.client().documents().summarize()
                .request(req)
                .call();

        if (res.summarizeResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                   | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `request`                                                   | [SummarizeRequest](../../models/shared/SummarizeRequest.md) | :heavy_check_mark:                                          | The request object to use for the request.                  |

### Response

**[SummarizeResponse](../../models/operations/SummarizeResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |