# Admin.Idpgroups

## Overview

### Available Operations

* [list](#list) - List IdP groups

## list

List the identity provider (IdP) groups that Glean loads from the directory, ordered by display_name and then by idp_group_id. Use idp_group_id to name a group in other Platform APIs. Usage limits apply only to IdP groups from the datasource instance that the usage settings select, so use the provider_instance filter to list only those groups. Internal O365 ownership groups and SharePoint groups are left out. The caller must be able to read the workspace configuration or the workspace billing.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-admin-idp-groups-list" method="get" path="/api/admin/idp-groups" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformAdminIdpGroupsListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformAdminIdpGroupsListResponse res = sdk.admin().idpgroups().list()
                .pageSize(50L)
                .call();

        if (res.platformListIdpGroupsResponse().isPresent()) {
            System.out.println(res.platformListIdpGroupsResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                             | Type                                                                                                                                                                                                                                                                                                                  | Required                                                                                                                                                                                                                                                                                                              | Description                                                                                                                                                                                                                                                                                                           |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `pageSize`                                                                                                                                                                                                                                                                                                            | *Optional\<Long>*                                                                                                                                                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                    | Maximum number of IdP groups to return. Defaults to 50. Maximum is 100.                                                                                                                                                                                                                                               |
| `cursor`                                                                                                                                                                                                                                                                                                              | *Optional\<String>*                                                                                                                                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                    | Opaque pagination cursor from a previous response. Send the same filters that the previous request used.<br/>                                                                                                                                                                                                         |
| `filters`                                                                                                                                                                                                                                                                                                             | List\<[PlatformIdpGroupFilter](../../models/components/PlatformIdpGroupFilter.md)>                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                    | JSON-encoded filters that choose which IdP groups are returned. The only supported field is provider_instance, with datasource instance names such as "okta". provider_instance values match without case. The only supported operator is EQUALS. Multiple values OR within a filter. Multiple filters AND together.<br/> |

### Response

**[PlatformAdminIdpGroupsListResponse](../../models/operations/PlatformAdminIdpGroupsListResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |