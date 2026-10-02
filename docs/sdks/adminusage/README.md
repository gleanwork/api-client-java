# Admin.Usage

## Overview

### Available Operations

* [getSettings](#getsettings) - Get usage settings
* [updateSettings](#updatesettings) - Update usage settings
* [createLimitIncreaseRequest](#createlimitincreaserequest) - Submit an editable-agent limit-increase request
* [listLimitIncreaseRequests](#listlimitincreaserequests) - List the billing limit-increase request queue
* [getLimitIncreaseRequest](#getlimitincreaserequest) - Get a billing limit-increase request

## getSettings

Retrieve workspace-wide usage settings. Requires admin.usage.settings:read and permission to read workspace billing; a global administrator role is not required.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-admin-usage-settings-get" method="get" path="/api/admin/usage/settings" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformAdminUsageSettingsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformAdminUsageSettingsGetResponse res = sdk.admin().usage().getSettings()
                .call();

        if (res.platformUsageSettingsResponse().isPresent()) {
            System.out.println(res.platformUsageSettingsResponse().get());
        }
    }
}
```

### Response

**[PlatformAdminUsageSettingsGetResponse](../../models/operations/PlatformAdminUsageSettingsGetResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## updateSettings

Partially update workspace-wide usage settings. Requires admin.usage.settings:write and permission to edit workspace billing; a global administrator role is not required.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-admin-usage-settings-update" method="patch" path="/api/admin/usage/settings" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformAdminUsageSettingsUpdateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformUsageSettingsUpdateRequestUnion req = PlatformUsageSettingsUpdateRequestUnion.of(PlatformUsageSettingsUpdateRequest1.builder()
                .multipleMembershipResolution(PlatformMultipleMembershipResolutionSettings.builder()
                    .perMember(PlatformPerMemberSettings.builder()
                        .idpGroups(IdpGroups.HIGHEST)
                        .build())
                    .build())
                .limitIncreaseRequests(PlatformLimitIncreaseRequestSettings.builder()
                    .businessJustification(BusinessJustification.REQUIRED)
                    .build())
                .build());

        PlatformAdminUsageSettingsUpdateResponse res = sdk.admin().usage().updateSettings()
                .request(req)
                .call();

        if (res.platformUsageSettingsResponse().isPresent()) {
            System.out.println(res.platformUsageSettingsResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                 | Type                                                                                                      | Required                                                                                                  | Description                                                                                               |
| --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                 | [PlatformUsageSettingsUpdateRequestUnion](../../models/shared/PlatformUsageSettingsUpdateRequestUnion.md) | :heavy_check_mark:                                                                                        | The request object to use for the request.                                                                |

### Response

**[PlatformAdminUsageSettingsUpdateResponse](../../models/operations/PlatformAdminUsageSettingsUpdateResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 413, 429            | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## createLimitIncreaseRequest

Requires usage.limit_increase_requests:write, the same scope as personal creation, and current edit permission on the agent, not billing permissions. The caller supplies the agent, client, and optional business justification. Requester identity comes from authentication; the server assigns the request identifier and current UTC month. This internal scaffold returns 503 without creating a request.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-admin-usage-requests-create" method="post" path="/api/admin/usage/limit-increase-requests" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.PlatformAgentRequestCreate;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformAdminUsageRequestsCreateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformAgentRequestCreate req = PlatformAgentRequestCreate.builder()
                .agentId("{agent_id}")
                .clientId("glean")
                .build();

        PlatformAdminUsageRequestsCreateResponse res = sdk.admin().usage().createLimitIncreaseRequest()
                .request(req)
                .call();

        if (res.platformRequestResponse().isPresent()) {
            System.out.println(res.platformRequestResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [PlatformAgentRequestCreate](../../models/shared/PlatformAgentRequestCreate.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[PlatformAdminUsageRequestsCreateResponse](../../models/operations/PlatformAdminUsageRequestsCreateResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 409, 413, 429       | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## listLimitIncreaseRequests

Requires admin.usage.limit_increase_requests:read and current workspace billing read permission. Agent ownership is not queue access. Cursors bind filters and current authorization context. This internal scaffold returns 503, not a successful empty page.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-admin-usage-requests-list" method="get" path="/api/admin/usage/limit-increase-requests" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformAdminUsageRequestsListResponse;
import java.lang.Exception;
import java.lang.Object;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformAdminUsageRequestsListResponse res = sdk.admin().usage().listLimitIncreaseRequests()
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

**[PlatformAdminUsageRequestsListResponse](../../models/operations/PlatformAdminUsageRequestsListResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## getLimitIncreaseRequest

Requires admin.usage.limit_increase_requests:read. Authorization precedes resource disclosure. This internal scaffold returns 503 without reading the request.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-admin-usage-requests-get" method="get" path="/api/admin/usage/limit-increase-requests/{request_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformAdminUsageRequestsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformAdminUsageRequestsGetResponse res = sdk.admin().usage().getLimitIncreaseRequest()
                .requestId("{request_id}")
                .call();

        if (res.platformRequestResponse().isPresent()) {
            System.out.println(res.platformRequestResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                              | Type                                                   | Required                                               | Description                                            | Example                                                |
| ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ |
| `requestId`                                            | *String*                                               | :heavy_check_mark:                                     | Opaque request identifier; not an authorization grant. | {request_id}                                           |

### Response

**[PlatformAdminUsageRequestsGetResponse](../../models/operations/PlatformAdminUsageRequestsGetResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |