# Indexing.CustomMetadata

## Overview

### Available Operations

* [upsert](#upsert) - Add or update custom metadata
* [delete](#delete) - Remove custom metadata
* [getSchema](#getschema) - Retrieve metadata schema
* [upsertSchema](#upsertschema) - Create or update metadata schema
* [deleteSchema](#deleteschema) - Remove metadata schema

## upsert

Associates custom metadata with a specific document. Custom metadata enables you to enrich documents with additional structured information that can be used for search, filtering, and faceting.

### Example Usage

<!-- UsageSnippet language="java" operationID="put_/rest/api/index/document/{docId}/custom-metadata/{groupName}" method="put" path="/rest/api/index/document/{docId}/custom-metadata/{groupName}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.CustomMetadataPutRequest;
import com.glean.api_client.glean_api_client.models.errors.ErrorInfoResponse;
import com.glean.api_client.glean_api_client.models.operations.PutRestApiIndexDocumentDocIdCustomMetadataGroupNameResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorInfoResponse, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PutRestApiIndexDocumentDocIdCustomMetadataGroupNameResponse res = sdk.indexing().customMetadata().upsert()
                .docId("<id>")
                .groupName("<value>")
                .customMetadataPutRequest(CustomMetadataPutRequest.builder()
                    .customMetadata(List.of())
                    .build())
                .call();

        if (res.successResponse().isPresent()) {
            System.out.println(res.successResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `docId`                                                                         | *String*                                                                        | :heavy_check_mark:                                                              | Unique Glean identifier of the document                                         |
| `groupName`                                                                     | *String*                                                                        | :heavy_check_mark:                                                              | Name of the metadata group as specified while adding schema                     |
| `customMetadataPutRequest`                                                      | [CustomMetadataPutRequest](../../models/components/CustomMetadataPutRequest.md) | :heavy_check_mark:                                                              | N/A                                                                             |
| `serverURL`                                                                     | *String*                                                                        | :heavy_minus_sign:                                                              | An optional server URL to use.                                                  |

### Response

**[PutRestApiIndexDocumentDocIdCustomMetadataGroupNameResponse](../../models/operations/PutRestApiIndexDocumentDocIdCustomMetadataGroupNameResponse.md)**

### Errors

| Error Type                      | Status Code                     | Content Type                    |
| ------------------------------- | ------------------------------- | ------------------------------- |
| models/errors/ErrorInfoResponse | 400, 401, 404, 429              | application/json                |
| models/errors/ErrorInfoResponse | 500                             | application/json                |
| models/errors/APIException      | 4XX, 5XX                        | \*/\*                           |

## delete

Removes all custom metadata for the specified metadata group from a document.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete_/rest/api/index/document/{docId}/custom-metadata/{groupName}" method="delete" path="/rest/api/index/document/{docId}/custom-metadata/{groupName}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.ErrorInfoResponse;
import com.glean.api_client.glean_api_client.models.operations.DeleteRestApiIndexDocumentDocIdCustomMetadataGroupNameResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorInfoResponse, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        DeleteRestApiIndexDocumentDocIdCustomMetadataGroupNameResponse res = sdk.indexing().customMetadata().delete()
                .docId("<id>")
                .groupName("<value>")
                .call();

        if (res.successResponse().isPresent()) {
            System.out.println(res.successResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                   | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `docId`                                                     | *String*                                                    | :heavy_check_mark:                                          | Unique Glean identifier of the document                     |
| `groupName`                                                 | *String*                                                    | :heavy_check_mark:                                          | Name of the metadata group as specified while adding schema |
| `serverURL`                                                 | *String*                                                    | :heavy_minus_sign:                                          | An optional server URL to use.                              |

### Response

**[DeleteRestApiIndexDocumentDocIdCustomMetadataGroupNameResponse](../../models/operations/DeleteRestApiIndexDocumentDocIdCustomMetadataGroupNameResponse.md)**

### Errors

| Error Type                      | Status Code                     | Content Type                    |
| ------------------------------- | ------------------------------- | ------------------------------- |
| models/errors/ErrorInfoResponse | 400, 401, 404, 429              | application/json                |
| models/errors/ErrorInfoResponse | 500                             | application/json                |
| models/errors/APIException      | 4XX, 5XX                        | \*/\*                           |

## getSchema

Retrieves the current schema definition for a metadata group.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_/rest/api/index/custom-metadata/schema/{groupName}" method="get" path="/rest/api/index/custom-metadata/schema/{groupName}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.ErrorInfoResponse;
import com.glean.api_client.glean_api_client.models.operations.GetRestApiIndexCustomMetadataSchemaGroupNameResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorInfoResponse, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetRestApiIndexCustomMetadataSchemaGroupNameResponse res = sdk.indexing().customMetadata().getSchema()
                .groupName("<value>")
                .call();

        if (res.customMetadataSchema().isPresent()) {
            System.out.println(res.customMetadataSchema().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `groupName`                       | *String*                          | :heavy_check_mark:                | Name of the metadata group schema |
| `serverURL`                       | *String*                          | :heavy_minus_sign:                | An optional server URL to use.    |

### Response

**[GetRestApiIndexCustomMetadataSchemaGroupNameResponse](../../models/operations/GetRestApiIndexCustomMetadataSchemaGroupNameResponse.md)**

### Errors

| Error Type                      | Status Code                     | Content Type                    |
| ------------------------------- | ------------------------------- | ------------------------------- |
| models/errors/ErrorInfoResponse | 401, 404, 429                   | application/json                |
| models/errors/ErrorInfoResponse | 500                             | application/json                |
| models/errors/APIException      | 4XX, 5XX                        | \*/\*                           |

## upsertSchema

Defines or updates the schema for a metadata group. Schemas should be defined before indexing metadata.

### Example Usage

<!-- UsageSnippet language="java" operationID="put_/rest/api/index/custom-metadata/schema/{groupName}" method="put" path="/rest/api/index/custom-metadata/schema/{groupName}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.CustomMetadataSchema;
import com.glean.api_client.glean_api_client.models.errors.ErrorInfoResponse;
import com.glean.api_client.glean_api_client.models.operations.PutRestApiIndexCustomMetadataSchemaGroupNameResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorInfoResponse, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PutRestApiIndexCustomMetadataSchemaGroupNameResponse res = sdk.indexing().customMetadata().upsertSchema()
                .groupName("<value>")
                .customMetadataSchema(CustomMetadataSchema.builder()
                    .metadataKeys(List.of())
                    .build())
                .call();

        if (res.successResponse().isPresent()) {
            System.out.println(res.successResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `groupName`                                                             | *String*                                                                | :heavy_check_mark:                                                      | Name of the metadata group schema                                       |
| `customMetadataSchema`                                                  | [CustomMetadataSchema](../../models/components/CustomMetadataSchema.md) | :heavy_check_mark:                                                      | N/A                                                                     |
| `serverURL`                                                             | *String*                                                                | :heavy_minus_sign:                                                      | An optional server URL to use.                                          |

### Response

**[PutRestApiIndexCustomMetadataSchemaGroupNameResponse](../../models/operations/PutRestApiIndexCustomMetadataSchemaGroupNameResponse.md)**

### Errors

| Error Type                      | Status Code                     | Content Type                    |
| ------------------------------- | ------------------------------- | ------------------------------- |
| models/errors/ErrorInfoResponse | 400, 401, 409, 429              | application/json                |
| models/errors/ErrorInfoResponse | 500                             | application/json                |
| models/errors/APIException      | 4XX, 5XX                        | \*/\*                           |

## deleteSchema

Deletes the schema definition for a metadata group. This does not delete existing metadata values on documents.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete_/rest/api/index/custom-metadata/schema/{groupName}" method="delete" path="/rest/api/index/custom-metadata/schema/{groupName}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.ErrorInfoResponse;
import com.glean.api_client.glean_api_client.models.operations.DeleteRestApiIndexCustomMetadataSchemaGroupNameResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorInfoResponse, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        DeleteRestApiIndexCustomMetadataSchemaGroupNameResponse res = sdk.indexing().customMetadata().deleteSchema()
                .groupName("<value>")
                .call();

        if (res.successResponse().isPresent()) {
            System.out.println(res.successResponse().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `groupName`                       | *String*                          | :heavy_check_mark:                | Name of the metadata group schema |
| `serverURL`                       | *String*                          | :heavy_minus_sign:                | An optional server URL to use.    |

### Response

**[DeleteRestApiIndexCustomMetadataSchemaGroupNameResponse](../../models/operations/DeleteRestApiIndexCustomMetadataSchemaGroupNameResponse.md)**

### Errors

| Error Type                      | Status Code                     | Content Type                    |
| ------------------------------- | ------------------------------- | ------------------------------- |
| models/errors/ErrorInfoResponse | 400, 401, 404, 429              | application/json                |
| models/errors/ErrorInfoResponse | 500                             | application/json                |
| models/errors/APIException      | 4XX, 5XX                        | \*/\*                           |