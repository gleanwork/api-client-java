# Client.Governance.Data.Findings

## Overview

### Available Operations

* [create](#create) - Creates findings export
* [list](#list) - Lists findings exports
* [download](#download) - Downloads findings export
* [delete](#delete) - Deletes findings export

## create

Creates a new DLP findings export job.

### Example Usage

<!-- UsageSnippet language="java" operationID="createfindingsexport" method="post" path="/rest/api/v1/governance/data/findings/exports" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DlpExportFindingsRequest;
import com.glean.api_client.glean_api_client.models.operations.CreatefindingsexportResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        DlpExportFindingsRequest req = DlpExportFindingsRequest.builder()
                .build();

        CreatefindingsexportResponse res = sdk.client().governance().data().findings().create()
                .request(req)
                .call();

        if (res.exportInfo().isPresent()) {
            System.out.println(res.exportInfo().get());
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [DlpExportFindingsRequest](../../models/shared/DlpExportFindingsRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[CreatefindingsexportResponse](../../models/operations/CreatefindingsexportResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

Lists all DLP findings exports.

### Example Usage

<!-- UsageSnippet language="java" operationID="listfindingsexports" method="get" path="/rest/api/v1/governance/data/findings/exports" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.ListfindingsexportsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        ListfindingsexportsResponse res = sdk.client().governance().data().findings().list()
                .call();

        if (res.listDlpFindingsExportsResponse().isPresent()) {
            System.out.println(res.listDlpFindingsExportsResponse().get());
        }
    }
}
```

### Response

**[ListfindingsexportsResponse](../../models/operations/ListfindingsexportsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## download

Downloads a DLP findings export as a CSV file.

### Example Usage

<!-- UsageSnippet language="java" operationID="downloadfindingsexport" method="get" path="/rest/api/v1/governance/data/findings/exports/{id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.DownloadfindingsexportResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        DownloadfindingsexportResponse res = sdk.client().governance().data().findings().download()
                .id("<id>")
                .call();

        if (res.res().isPresent()) {
            System.out.println(res.res().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `id`                              | *String*                          | :heavy_check_mark:                | The ID of the export to download. |

### Response

**[DownloadfindingsexportResponse](../../models/operations/DownloadfindingsexportResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## delete

Deletes a DLP findings export.

### Example Usage

<!-- UsageSnippet language="java" operationID="deletefindingsexport" method="delete" path="/rest/api/v1/governance/data/findings/exports/{id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.DeletefindingsexportResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        DeletefindingsexportResponse res = sdk.client().governance().data().findings().delete()
                .id(741945L)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                       | Type                            | Required                        | Description                     |
| ------------------------------- | ------------------------------- | ------------------------------- | ------------------------------- |
| `id`                            | *long*                          | :heavy_check_mark:              | The ID of the export to delete. |

### Response

**[DeletefindingsexportResponse](../../models/operations/DeletefindingsexportResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |