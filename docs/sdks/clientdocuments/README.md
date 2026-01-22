# Client.Documents

## Overview

### Available Operations

* [retrievePermissions](#retrievepermissions) - Read document permissions
* [retrieve](#retrieve) - Read documents
* [retrieveByFacets](#retrievebyfacets) - Read documents by facets
* [summarize](#summarize) - Summarize documents

## retrievePermissions

Read the emails of all users who have access to the given document.

### Example Usage

<!-- UsageSnippet language="java" operationID="getdocpermissions" method="post" path="/rest/api/v1/getdocpermissions" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.GetDocPermissionsRequest;
import com.glean.api_client.glean_api_client.models.operations.GetdocpermissionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetdocpermissionsResponse res = sdk.client().documents().retrievePermissions()
                .getDocPermissionsRequest(GetDocPermissionsRequest.builder()
                    .build())
                .call();

        if (res.getDocPermissionsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `getDocPermissionsRequest`                                                                                                                                                                          | [GetDocPermissionsRequest](../../models/components/GetDocPermissionsRequest.md)                                                                                                                     | :heavy_check_mark:                                                                                                                                                                                  | Document permissions request                                                                                                                                                                        |

### Response

**[GetdocpermissionsResponse](../../models/operations/GetdocpermissionsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieve

Read the documents including metadata (does not include enhanced metadata via `/documentmetadata`) for the given list of Glean Document IDs or URLs specified in the request.

### Example Usage

<!-- UsageSnippet language="java" operationID="getdocuments" method="post" path="/rest/api/v1/getdocuments" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.GetdocumentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetdocumentsResponse res = sdk.client().documents().retrieve()
                .call();

        if (res.getDocumentsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `getDocumentsRequest`                                                                                                                                                                               | [Optional\<GetDocumentsRequest>](../../models/components/GetDocumentsRequest.md)                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                  | Information about documents requested.                                                                                                                                                              |

### Response

**[GetdocumentsResponse](../../models/operations/GetdocumentsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieveByFacets

Read the documents including metadata (does not include enhanced metadata via `/documentmetadata`) macthing the given facet conditions.

### Example Usage

<!-- UsageSnippet language="java" operationID="getdocumentsbyfacets" method="post" path="/rest/api/v1/getdocumentsbyfacets" -->
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
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetdocumentsbyfacetsResponse res = sdk.client().documents().retrieveByFacets()
                .getDocumentsByFacetsRequest(GetDocumentsByFacetsRequest.builder()
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
                    .build())
                .call();

        if (res.getDocumentsByFacetsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `getDocumentsByFacetsRequest`                                                                                                                                                                       | [Optional\<GetDocumentsByFacetsRequest>](../../models/components/GetDocumentsByFacetsRequest.md)                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                  | Information about facet conditions for documents to be retrieved.                                                                                                                                   |

### Response

**[GetdocumentsbyfacetsResponse](../../models/operations/GetdocumentsbyfacetsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## summarize

Generate an AI summary of the requested documents.

### Example Usage

<!-- UsageSnippet language="java" operationID="summarize" method="post" path="/rest/api/v1/summarize" -->
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
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        SummarizeResponse res = sdk.client().documents().summarize()
                .summarizeRequest(SummarizeRequest.builder()
                    .documentSpecs(List.of(
                        DocumentSpecUnion.of(DocumentSpec4.builder()
                            .ugcType(DocumentSpecUgcType2.CHATS)
                            .ugcId("<id>")
                            .build()),
                        DocumentSpecUnion.of(DocumentSpec4.builder()
                            .ugcType(DocumentSpecUgcType2.CHATS)
                            .ugcId("<id>")
                            .build()),
                        DocumentSpecUnion.of(DocumentSpec2.builder()
                            .id("<id>")
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

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `summarizeRequest`                                                                                                                                                                                  | [SummarizeRequest](../../models/components/SummarizeRequest.md)                                                                                                                                     | :heavy_check_mark:                                                                                                                                                                                  | Includes request params such as the query and specs of the documents to summarize.                                                                                                                  |

### Response

**[SummarizeResponse](../../models/operations/SummarizeResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |