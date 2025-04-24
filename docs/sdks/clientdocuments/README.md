# ClientDocuments
(*client().documents()*)

## Overview

### Available Operations

* [getPermissions](#getpermissions) - Read document permissions
* [get](#get) - Read documents
* [getByFacets](#getbyfacets) - Read documents by facets
* [getAnalytics](#getanalytics) - Read document analytics

## getPermissions

Read the emails of all users who have access to the given document.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetDocPermissionsRequest;
import com.glean.api_client.models.operations.GetdocpermissionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetdocpermissionsResponse res = sdk.client().documents().getPermissions()
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

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `getDocPermissionsRequest`                                                                                               | [GetDocPermissionsRequest](../../models/components/GetDocPermissionsRequest.md)                                          | :heavy_check_mark:                                                                                                       | Document permissions request                                                                                             |

### Response

**[GetdocpermissionsResponse](../../models/operations/GetdocpermissionsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## get

Read the documents including metadata (does not include enhanced metadata via `/documentmetadata`) for the given list of Glean Document IDs or URLs specified in the request.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.operations.GetdocumentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetdocumentsResponse res = sdk.client().documents().get()
                .call();

        if (res.getDocumentsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `getDocumentsRequest`                                                                                                    | [Optional\<GetDocumentsRequest>](../../models/components/GetDocumentsRequest.md)                                         | :heavy_minus_sign:                                                                                                       | Information about documents requested.                                                                                   |

### Response

**[GetdocumentsResponse](../../models/operations/GetdocumentsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getByFacets

Read the documents including metadata (does not include enhanced metadata via `/documentmetadata`) macthing the given facet conditions.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.GetdocumentsbyfacetsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetdocumentsbyfacetsResponse res = sdk.client().documents().getByFacets()
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

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `getDocumentsByFacetsRequest`                                                                                            | [Optional\<GetDocumentsByFacetsRequest>](../../models/components/GetDocumentsByFacetsRequest.md)                         | :heavy_minus_sign:                                                                                                       | Information about facet conditions for documents to be retrieved.                                                        |

### Response

**[GetdocumentsbyfacetsResponse](../../models/operations/GetdocumentsbyfacetsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getAnalytics

Read the document analytics information for the given list of Glean Document IDs or URLs specified in the request

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.operations.GetdocumentanalyticsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetdocumentanalyticsResponse res = sdk.client().documents().getAnalytics()
                .call();

        if (res.getDocumentAnalyticsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `getDocumentAnalyticsRequest`                                                                                            | [Optional\<GetDocumentAnalyticsRequest>](../../models/components/GetDocumentAnalyticsRequest.md)                         | :heavy_minus_sign:                                                                                                       | Information about analytics requested.                                                                                   |

### Response

**[GetdocumentanalyticsResponse](../../models/operations/GetdocumentanalyticsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |