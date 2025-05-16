# Reports
(*client().governance().data().reports()*)

## Overview

### Available Operations

* [create](#create) - Creates new one-time report.
* [download](#download) - Downloads violations CSV for report.
* [status](#status) - Fetches report run status.

## create

Creates a new one-time report and executes its batch job.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.components.UpdateDlpConfigRequest;
import com.glean.api_client.glean_api_client.models.operations.CreatereportResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        UpdateDlpConfigRequest req = UpdateDlpConfigRequest.builder()
                .build();

        CreatereportResponse res = sdk.client().governance().data().reports().create()
                .request(req)
                .call();

        if (res.updateDlpConfigResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [UpdateDlpConfigRequest](../../models/shared/UpdateDlpConfigRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[CreatereportResponse](../../models/operations/CreatereportResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## download

Downloads CSV violations report for a specific report id.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.DownloadreportcsvResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        DownloadreportcsvResponse res = sdk.client().governance().data().reports().download()
                .id("<id>")
                .call();

        if (res.res().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                        | Type                                             | Required                                         | Description                                      |
| ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ |
| `id`                                             | *String*                                         | :heavy_check_mark:                               | The id of the report to download violations for. |

### Response

**[DownloadreportcsvResponse](../../models/operations/DownloadreportcsvResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## status

Fetches the status of the run corresponding to the report-id.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.GetreportstatusResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        GetreportstatusResponse res = sdk.client().governance().data().reports().status()
                .id("<id>")
                .call();

        if (res.reportStatusResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                   | Type                                        | Required                                    | Description                                 |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| `id`                                        | *String*                                    | :heavy_check_mark:                          | The id of the report to get run status for. |

### Response

**[GetreportstatusResponse](../../models/operations/GetreportstatusResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |