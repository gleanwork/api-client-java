# Policies
(*client().governance().data().policies()*)

## Overview

### Available Operations

* [retrieve](#retrieve) - Gets specified Policy.
* [update](#update) - Updates an existing policy.
* [list](#list) - Lists policies.
* [create](#create) - Creates new policy.
* [download](#download) - Downloads violations CSV for policy.

## retrieve

Fetches the specified policy version, or the latest if no version is provided.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.GetpolicyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .apiToken("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        GetpolicyResponse res = sdk.client().governance().data().policies().retrieve()
                .id("<id>")
                .call();

        if (res.getDlpReportResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                  | Type                                                                                                                                                       | Required                                                                                                                                                   | Description                                                                                                                                                |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `id`                                                                                                                                                       | *String*                                                                                                                                                   | :heavy_check_mark:                                                                                                                                         | The id of the policy to fetch.                                                                                                                             |
| `version`                                                                                                                                                  | *Optional\<Long>*                                                                                                                                          | :heavy_minus_sign:                                                                                                                                         | The version of the policy to fetch. Each time a policy is updated, the older version is still stored. If this is left empty, the latest policy is fetched. |

### Response

**[GetpolicyResponse](../../models/operations/GetpolicyResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## update

Updates an existing policy.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.components.UpdateDlpReportRequest;
import com.glean.api_client.glean_api_client.models.operations.UpdatepolicyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .apiToken("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        UpdatepolicyResponse res = sdk.client().governance().data().policies().update()
                .id("<id>")
                .updateDlpReportRequest(UpdateDlpReportRequest.builder()
                    .build())
                .call();

        if (res.updateDlpReportResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `id`                                                                        | *String*                                                                    | :heavy_check_mark:                                                          | The id of the policy to fetch.                                              |
| `updateDlpReportRequest`                                                    | [UpdateDlpReportRequest](../../models/components/UpdateDlpReportRequest.md) | :heavy_check_mark:                                                          | N/A                                                                         |

### Response

**[UpdatepolicyResponse](../../models/operations/UpdatepolicyResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

Lists policies with filtering.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.GetpoliciesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .apiToken("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        GetpoliciesResponse res = sdk.client().governance().data().policies().list()
                .call();

        if (res.listDlpReportsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                 | Type                                                      | Required                                                  | Description                                               |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| `autoHide`                                                | *Optional\<Boolean>*                                      | :heavy_minus_sign:                                        | Filter to return reports with a given value of auto-hide. |
| `frequency`                                               | *Optional\<String>*                                       | :heavy_minus_sign:                                        | Filter to return reports with a given frequency.          |

### Response

**[GetpoliciesResponse](../../models/operations/GetpoliciesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## create

Creates a new policy with specified specifications and returns its id.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.CreateDlpReportRequest;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.CreatepolicyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .apiToken("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        CreateDlpReportRequest req = CreateDlpReportRequest.builder()
                .build();

        CreatepolicyResponse res = sdk.client().governance().data().policies().create()
                .request(req)
                .call();

        if (res.createDlpReportResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [CreateDlpReportRequest](../../models/shared/CreateDlpReportRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[CreatepolicyResponse](../../models/operations/CreatepolicyResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## download

Downloads CSV violations report for a specific policy id. This does not support continuous policies.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.DownloadpolicycsvResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .apiToken("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        DownloadpolicycsvResponse res = sdk.client().governance().data().policies().download()
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
| `id`                                             | *String*                                         | :heavy_check_mark:                               | The id of the policy to download violations for. |

### Response

**[DownloadpolicycsvResponse](../../models/operations/DownloadpolicycsvResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |