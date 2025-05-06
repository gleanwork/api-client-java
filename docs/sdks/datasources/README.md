# Datasources
(*indexing().datasources()*)

## Overview

### Available Operations

* [add](#add) - Add or update datasource
* [retrieveConfig](#retrieveconfig) - Get datasource config

## add

Add or update a custom datasource and its schema.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.PostApiIndexV1AdddatasourceResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
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
                        .build(),
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

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetDatasourceConfigRequest;
import com.glean.api_client.models.operations.PostApiIndexV1GetdatasourceconfigResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetDatasourceConfigRequest req = GetDatasourceConfigRequest.builder()
                .datasource("<value>")
                .build();

        PostApiIndexV1GetdatasourceconfigResponse res = sdk.indexing().datasources().retrieveConfig()
                .request(req)
                .call();

        if (res.customDatasourceConfig().isPresent()) {
            // handle response
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