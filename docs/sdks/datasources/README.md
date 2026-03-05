# Datasources

## Overview

Manage datasources.

### Available Operations

* [getDatasourceInstanceConfiguration](#getdatasourceinstanceconfiguration) - Get datasource instance configuration
* [updateDatasourceInstanceConfiguration](#updatedatasourceinstanceconfiguration) - Update datasource instance configuration

## getDatasourceInstanceConfiguration

Gets the greenlisted configuration values for a datasource instance. Returns only configuration keys that are exposed via the public API greenlist.


### Example Usage

<!-- UsageSnippet language="java" operationID="getDatasourceInstanceConfiguration" method="get" path="/rest/api/v1/configure/datasources/{datasourceId}/instances/{instanceId}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.ErrorResponse;
import com.glean.api_client.glean_api_client.models.operations.GetDatasourceInstanceConfigurationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetDatasourceInstanceConfigurationResponse res = sdk.datasources().getDatasourceInstanceConfiguration()
                .datasourceId("o365sharepoint")
                .instanceId("o365sharepoint_abc123")
                .call();

        if (res.datasourceConfigurationResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                            | Type                                                 | Required                                             | Description                                          | Example                                              |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| `datasourceId`                                       | *String*                                             | :heavy_check_mark:                                   | The datasource type identifier (e.g. o365sharepoint) | o365sharepoint                                       |
| `instanceId`                                         | *String*                                             | :heavy_check_mark:                                   | The datasource instance identifier                   | o365sharepoint_abc123                                |

### Response

**[GetDatasourceInstanceConfigurationResponse](../../models/operations/GetDatasourceInstanceConfigurationResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 403, 404               | application/json            |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## updateDatasourceInstanceConfiguration

Updates the greenlisted configuration values for a datasource instance. Only configuration keys that are exposed via the public API greenlist may be set. Returns the full greenlisted configuration after the update is applied.


### Example Usage

<!-- UsageSnippet language="java" operationID="updateDatasourceInstanceConfiguration" method="patch" path="/rest/api/v1/configure/datasources/{datasourceId}/instances/{instanceId}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DatasourceInstanceConfiguration;
import com.glean.api_client.glean_api_client.models.components.UpdateDatasourceConfigurationRequest;
import com.glean.api_client.glean_api_client.models.errors.ErrorResponse;
import com.glean.api_client.glean_api_client.models.operations.UpdateDatasourceInstanceConfigurationResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        UpdateDatasourceInstanceConfigurationResponse res = sdk.datasources().updateDatasourceInstanceConfiguration()
                .datasourceId("o365sharepoint")
                .instanceId("o365sharepoint_abc123")
                .updateDatasourceConfigurationRequest(UpdateDatasourceConfigurationRequest.builder()
                    .configuration(DatasourceInstanceConfiguration.builder()
                        .values(Map.ofEntries(
                        ))
                        .build())
                    .build())
                .call();

        if (res.datasourceConfigurationResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                               | Type                                                                                                    | Required                                                                                                | Description                                                                                             | Example                                                                                                 |
| ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| `datasourceId`                                                                                          | *String*                                                                                                | :heavy_check_mark:                                                                                      | The datasource type identifier (e.g. o365sharepoint)                                                    | o365sharepoint                                                                                          |
| `instanceId`                                                                                            | *String*                                                                                                | :heavy_check_mark:                                                                                      | The datasource instance identifier                                                                      | o365sharepoint_abc123                                                                                   |
| `updateDatasourceConfigurationRequest`                                                                  | [UpdateDatasourceConfigurationRequest](../../models/components/UpdateDatasourceConfigurationRequest.md) | :heavy_check_mark:                                                                                      | N/A                                                                                                     |                                                                                                         |

### Response

**[UpdateDatasourceInstanceConfigurationResponse](../../models/operations/UpdateDatasourceInstanceConfigurationResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 403, 404               | application/json            |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |