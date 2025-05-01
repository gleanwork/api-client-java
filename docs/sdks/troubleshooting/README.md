# Troubleshooting
(*indexing().troubleshooting()*)

## Overview

### Available Operations

* [getDatasourceStatus](#getdatasourcestatus) - Beta: Get datasource status

* [postDocumentDebug](#postdocumentdebug) - Beta: Get document information

* [postDocumentsDebug](#postdocumentsdebug) - Beta: Get information of a batch of documents

* [debugUser](#debuguser) - Beta: Get user information

* [checkAccess](#checkaccess) - Check document access
* [~~getStatus~~](#getstatus) - Get document upload and indexing status :warning: **Deprecated**
* [~~getDocumentCount~~](#getdocumentcount) - Get document count :warning: **Deprecated**
* [~~getUserCount~~](#getusercount) - Get user count :warning: **Deprecated**

## getDatasourceStatus

Gather information about the datasource's overall status. Currently in beta, might undergo breaking changes without prior notice.

Tip: Refer to the [Troubleshooting tutorial](https://developers.glean.com/docs/indexing_api/indexing_api_troubleshooting/) for more information.


### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.operations.PostApiIndexV1DebugDatasourceStatusResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PostApiIndexV1DebugDatasourceStatusResponse res = sdk.indexing().troubleshooting().getDatasourceStatus()
                .datasource("<value>")
                .call();

        if (res.debugDatasourceStatusResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                               | Type                                    | Required                                | Description                             |
| --------------------------------------- | --------------------------------------- | --------------------------------------- | --------------------------------------- |
| `datasource`                            | *String*                                | :heavy_check_mark:                      | The datasource to get debug status for. |

### Response

**[PostApiIndexV1DebugDatasourceStatusResponse](../../models/operations/PostApiIndexV1DebugDatasourceStatusResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## postDocumentDebug

Gives various information that would help in debugging related to a particular document. Currently in beta, might undergo breaking changes without prior notice.

Tip: Refer to the [Troubleshooting tutorial](https://developers.glean.com/docs/indexing_api/indexing_api_troubleshooting/) for more information.


### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DebugDocumentRequest;
import com.glean.api_client.models.operations.PostApiIndexV1DebugDatasourceDocumentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PostApiIndexV1DebugDatasourceDocumentResponse res = sdk.indexing().troubleshooting().postDocumentDebug()
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

## postDocumentsDebug

Gives various information that would help in debugging related to a batch of documents. Currently in beta, might undergo breaking changes without prior notice.

Tip: Refer to the [Troubleshooting tutorial](https://developers.glean.com/docs/indexing_api/indexing_api_troubleshooting/) for more information.


### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DebugDocumentRequest;
import com.glean.api_client.models.components.DebugDocumentsRequest;
import com.glean.api_client.models.operations.PostApiIndexV1DebugDatasourceDocumentsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PostApiIndexV1DebugDatasourceDocumentsResponse res = sdk.indexing().troubleshooting().postDocumentsDebug()
                .datasource("<value>")
                .debugDocumentsRequest(DebugDocumentsRequest.builder()
                    .debugDocuments(List.of(
                        DebugDocumentRequest.builder()
                            .objectType("Article")
                            .docId("art123")
                            .build(),
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

## debugUser

Gives various information that would help in debugging related to a particular user. Currently in beta, might undergo breaking changes without prior notice.

Tip: Refer to the [Troubleshooting tutorial](https://developers.glean.com/docs/indexing_api/indexing_api_troubleshooting/) for more information.


### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DebugUserRequest;
import com.glean.api_client.models.operations.PostApiIndexV1DebugDatasourceUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PostApiIndexV1DebugDatasourceUserResponse res = sdk.indexing().troubleshooting().debugUser()
                .datasource("<value>")
                .debugUserRequest(DebugUserRequest.builder()
                    .email("u1@foo.com")
                    .build())
                .call();

        if (res.debugUserResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                       | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `datasource`                                                    | *String*                                                        | :heavy_check_mark:                                              | The datasource to which the user belongs                        |
| `debugUserRequest`                                              | [DebugUserRequest](../../models/components/DebugUserRequest.md) | :heavy_check_mark:                                              | N/A                                                             |

### Response

**[PostApiIndexV1DebugDatasourceUserResponse](../../models/operations/PostApiIndexV1DebugDatasourceUserResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## checkAccess

Check if a given user has access to access a document in a custom datasource

Tip: Refer to the [Troubleshooting tutorial](https://developers.glean.com/docs/indexing_api/indexing_api_troubleshooting/) for more information.


### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.CheckDocumentAccessRequest;
import com.glean.api_client.models.operations.PostApiIndexV1CheckdocumentaccessResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CheckDocumentAccessRequest req = CheckDocumentAccessRequest.builder()
                .datasource("<value>")
                .objectType("<value>")
                .docId("<id>")
                .userEmail("<value>")
                .build();

        PostApiIndexV1CheckdocumentaccessResponse res = sdk.indexing().troubleshooting().checkAccess()
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

## ~~getStatus~~

Intended for debugging/validation. Fetches the current upload and indexing status of documents.

Tip: Use [/debug/{datasource}/document](https://developers.glean.com/docs/indexing_api/indexing_api_troubleshooting/#debug-datasource-document) for richer information.


> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetDocumentStatusRequest;
import com.glean.api_client.models.operations.PostApiIndexV1GetdocumentstatusResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetDocumentStatusRequest req = GetDocumentStatusRequest.builder()
                .datasource("<value>")
                .objectType("<value>")
                .docId("<id>")
                .build();

        PostApiIndexV1GetdocumentstatusResponse res = sdk.indexing().troubleshooting().getStatus()
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

## ~~getDocumentCount~~

Fetches document count for the specified custom datasource.

Tip: Use [/debug/{datasource}/status](https://developers.glean.com/docs/indexing_api/indexing_api_troubleshooting/#debug-datasource-status) for richer information.


> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetDocumentCountRequest;
import com.glean.api_client.models.operations.PostApiIndexV1GetdocumentcountResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetDocumentCountRequest req = GetDocumentCountRequest.builder()
                .datasource("<value>")
                .build();

        PostApiIndexV1GetdocumentcountResponse res = sdk.indexing().troubleshooting().getDocumentCount()
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

## ~~getUserCount~~

Fetches user count for the specified custom datasource.

Tip: Use [/debug/{datasource}/status](https://developers.glean.com/docs/indexing_api/indexing_api_troubleshooting/#debug-datasource-status) for richer information.


> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetUserCountRequest;
import com.glean.api_client.models.operations.PostApiIndexV1GetusercountResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetUserCountRequest req = GetUserCountRequest.builder()
                .datasource("<value>")
                .build();

        PostApiIndexV1GetusercountResponse res = sdk.indexing().troubleshooting().getUserCount()
                .request(req)
                .call();

        if (res.getUserCountResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [GetUserCountRequest](../../models/shared/GetUserCountRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[PostApiIndexV1GetusercountResponse](../../models/operations/PostApiIndexV1GetusercountResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |