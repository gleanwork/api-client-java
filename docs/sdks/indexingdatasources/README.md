# Indexing.Datasources

## Overview

### Available Operations

* [add](#add) - Add or update datasource
* [retrieveConfig](#retrieveconfig) - Get datasource config
* [submit](#submit) - Submit datasource data

## add

Add or update a custom datasource and its schema.

### Example Usage

<!-- UsageSnippet language="java" operationID="post_/api/index/v1/adddatasource" method="post" path="/api/index/v1/adddatasource" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1AdddatasourceResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        CustomDatasourceConfig req = CustomDatasourceConfig.builder()
                .name("<value>")
                .urlRegex("https://example-company.datasource.com/.*")
                .quicklinks(List.of(
                    Quicklink.builder()
                        .iconConfig(IconConfig.builder()
                            .color("#343CED")
                            .key("person_icon")
                            .iconType(IconType.GLYPH)
                            .name("user")
                            .build())
                        .build()))
                .build();

        PostApiIndexV1AdddatasourceResponse res = sdk.indexing().datasources().add()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [CustomDatasourceConfig](../../models/shared/CustomDatasourceConfig.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[PostApiIndexV1AdddatasourceResponse](../../models/operations/PostApiIndexV1AdddatasourceResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieveConfig

Fetches the datasource config for the specified custom datasource.

### Example Usage

<!-- UsageSnippet language="java" operationID="post_/api/index/v1/getdatasourceconfig" method="post" path="/api/index/v1/getdatasourceconfig" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.GetDatasourceConfigRequest;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1GetdatasourceconfigResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetDatasourceConfigRequest req = GetDatasourceConfigRequest.builder()
                .datasource("<value>")
                .build();

        PostApiIndexV1GetdatasourceconfigResponse res = sdk.indexing().datasources().retrieveConfig()
                .request(req)
                .call();

        if (res.customDatasourceConfig().isPresent()) {
            System.out.println(res.customDatasourceConfig().get());
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [GetDatasourceConfigRequest](../../models/shared/GetDatasourceConfigRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[PostApiIndexV1GetdatasourceconfigResponse](../../models/operations/PostApiIndexV1GetdatasourceconfigResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## submit

Validates and asynchronously processes a datasource-specific submission.

### Example Usage

<!-- UsageSnippet language="java" operationID="post_/rest/api/index/submissions/{datasourceInstance}/{type}" method="post" path="/rest/api/index/submissions/{datasourceInstance}/{type}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.ErrorInfoResponse;
import com.glean.api_client.glean_api_client.models.operations.PostRestApiIndexSubmissionsDatasourceInstanceTypeResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorInfoResponse, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PostRestApiIndexSubmissionsDatasourceInstanceTypeResponse res = sdk.indexing().datasources().submit()
                .datasourceInstance("<value>")
                .type("<value>")
                .requestBody(Map.ofEntries(
                    Map.entry("key", "<value>"),
                    Map.entry("key1", "<value>"),
                    Map.entry("key2", "<value>")))
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter                                              | Type                                                   | Required                                               | Description                                            |
| ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ |
| `datasourceInstance`                                   | *String*                                               | :heavy_check_mark:                                     | Datasource instance that should process the submission |
| `type`                                                 | *String*                                               | :heavy_check_mark:                                     | Submission type registered for the datasource          |
| `requestBody`                                          | Map\<String, *Object*>                                 | :heavy_check_mark:                                     | N/A                                                    |
| `serverURL`                                            | *String*                                               | :heavy_minus_sign:                                     | An optional server URL to use.                         |

### Response

**[PostRestApiIndexSubmissionsDatasourceInstanceTypeResponse](../../models/operations/PostRestApiIndexSubmissionsDatasourceInstanceTypeResponse.md)**

### Errors

| Error Type                      | Status Code                     | Content Type                    |
| ------------------------------- | ------------------------------- | ------------------------------- |
| models/errors/ErrorInfoResponse | 400, 401, 404                   | application/json                |
| models/errors/ErrorInfoResponse | 500                             | application/json                |
| models/errors/APIException      | 4XX, 5XX                        | \*/\*                           |