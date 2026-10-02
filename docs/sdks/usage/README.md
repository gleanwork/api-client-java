# Usage

## Overview

### Available Operations

* [createLimitIncreaseRequest](#createlimitincreaserequest) - Submit a personal limit-increase request
* [listLimitIncreaseRequests](#listlimitincreaserequests) - List personal limit-increase requests
* [getLimitIncreaseRequest](#getlimitincreaserequest) - Get a personal limit-increase request

## createLimitIncreaseRequest

Requires usage.limit_increase_requests:write. The target is the authenticated canonical user, and requester identity comes from authentication. The caller supplies the client and optional business justification. The server assigns the request identifier and current UTC month. Billing grants do not widen this route. This internal scaffold returns 503 without creating a request.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-usage-requests-create" method="post" path="/api/usage/limit-increase-requests" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.PlatformPersonalRequestCreate;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformUsageRequestsCreateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformPersonalRequestCreate req = PlatformPersonalRequestCreate.builder()
                .clientId("glean")
                .build();

        PlatformUsageRequestsCreateResponse res = sdk.usage().createLimitIncreaseRequest()
                .request(req)
                .call();

        if (res.platformRequestResponse().isPresent()) {
            System.out.println(res.platformRequestResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `request`                                                                             | [PlatformPersonalRequestCreate](../../models/shared/PlatformPersonalRequestCreate.md) | :heavy_check_mark:                                                                    | The request object to use for the request.                                            |

### Response

**[PlatformUsageRequestsCreateResponse](../../models/operations/PlatformUsageRequestsCreateResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 409, 413, 429       | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## listLimitIncreaseRequests

Requires usage.limit_increase_requests:read. The collection is limited to the authenticated canonical user's requests, including resolved requests. Cursors bind the filters and current authorization context; a billing grant cannot widen results. This internal scaffold returns 503 without reading requests.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-usage-requests-list" method="get" path="/api/usage/limit-increase-requests" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformUsageRequestsListResponse;
import java.lang.Exception;
import java.lang.Object;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformUsageRequestsListResponse res = sdk.usage().listLimitIncreaseRequests()
                .pageSize(20L)
                .call();

        if (res.platformRequestListResponse().isPresent()) {
            PlatformRequestListResponseUnion unionValue = res.platformRequestListResponse().get();
            Object raw = unionValue.value();
            if (raw instanceof PlatformRequestListResponse1) {
                PlatformRequestListResponse1 platformRequestListResponse1Value = (PlatformRequestListResponse1) raw;
                // Handle platformRequestListResponse1 variant
            } else if (raw instanceof PlatformRequestListResponse2) {
                PlatformRequestListResponse2 platformRequestListResponse2Value = (PlatformRequestListResponse2) raw;
                // Handle platformRequestListResponse2 variant
            } else {
                // Unknown or unsupported variant
            }
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `pageSize`                                                                       | *Optional\<Long>*                                                                | :heavy_minus_sign:                                                               | Maximum page size; defaults to 20 and cannot exceed 100.                         |
| `cursor`                                                                         | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | Opaque continuation bound to filters and current authorization.                  |
| `filters`                                                                        | List\<[PlatformRequestFilter](../../models/components/PlatformRequestFilter.md)> | :heavy_minus_sign:                                                               | Optional structured filters on request status.                                   |

### Response

**[PlatformUsageRequestsListResponse](../../models/operations/PlatformUsageRequestsListResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## getLimitIncreaseRequest

Requires usage.limit_increase_requests:read and the current user's request. Authorization precedes resource disclosure. This internal scaffold returns 503 without reading the request.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-usage-requests-get" method="get" path="/api/usage/limit-increase-requests/{request_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformUsageRequestsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformUsageRequestsGetResponse res = sdk.usage().getLimitIncreaseRequest()
                .requestId("{request_id}")
                .call();

        if (res.platformRequestResponse().isPresent()) {
            System.out.println(res.platformRequestResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                       | Type                                                            | Required                                                        | Description                                                     | Example                                                         |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `requestId`                                                     | *String*                                                        | :heavy_check_mark:                                              | Opaque personal request identifier; not an authorization grant. | {request_id}                                                    |

### Response

**[PlatformUsageRequestsGetResponse](../../models/operations/PlatformUsageRequestsGetResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |