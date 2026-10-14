# Admin.Usage

## Overview

### Available Operations

* [getSettings](#getsettings) - Get usage settings
* [updateSettings](#updatesettings) - Update usage settings

## getSettings

Retrieve workspace-wide policy from the same configuration used by Billing. Group resolution uses the configured policy and its backend defaults; business justification is currently optional. No per-user settings are read, and updated_at is omitted because no policy-update timestamp is available. Requires admin.usage.settings:read and permission to read workspace billing; a global administrator role is not required.


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

Assign workspace-wide usage policy. Assignment is currently unavailable until a writer to authoritative Billing configuration is integrated. The backend config platform.usageSettingsWritesEnabled is disabled by default; enabling it alone does not implement assignment, and an authorized request still returns 503 without changing configuration or persisting a second copy of policy. Requires admin.usage.settings:write and permission to edit workspace billing; a global administrator role is not required.


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