# Admin.Idpgroups

## Overview

### Available Operations

* [list](#list) - List IdP groups
* [get](#get) - Get an IdP group

## list

List the identity provider (IdP) groups that Glean loads from the directory, ordered by display_name and then by idp_group_id. Use idp_group_id to name a group in other Platform APIs. An IdP group is active when Glean loaded it from the directory. An IdP group is inactive when only a usage limit names it, for example after the group was removed from the identity provider. Inactive IdP groups are left out unless an is_active filter includes the value "false". Usage limits apply only to IdP groups from the datasource instance that the usage settings select, so use the provider_instance filter to list only those groups. Internal O365 ownership groups and SharePoint groups are left out. The caller must be able to read the workspace configuration or the workspace billing.


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

| Parameter                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | Type                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      | Required                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `pageSize`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        | Maximum number of IdP groups to return. Defaults to 50. Maximum is 100.                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| `cursor`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        | Opaque pagination cursor from a previous response. Send the same filters that the previous request used.<br/>                                                                                                                                                                                                                                                                                                                                                                                                                             |
| `filters`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | List\<[PlatformIdpGroupFilter](../../models/components/PlatformIdpGroupFilter.md)>                                                                                                                                                                                                                                                                                                                                                                                                                                                        | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        | JSON-encoded filters that choose which IdP groups are returned. The supported fields are is_active, with the values "true" and "false", and provider_instance, with datasource instance names such as "okta". provider_instance values match without case. The only supported operator is EQUALS. Multiple values OR within a filter. Multiple filters AND together. Without an is_active filter, only active IdP groups are returned. To return active and inactive IdP groups, send [{"field":"is_active","values":["true","false"]}].<br/> |

### Response

**[PlatformAdminIdpGroupsListResponse](../../models/operations/PlatformAdminIdpGroupsListResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## get

Get one identity provider (IdP) group by its idp_group_id. Inactive IdP groups are returned, so a caller can still show a group after it was removed from the identity provider. An IdP group is active when Glean loaded it from the directory. An IdP group is inactive when only a usage limit names it, for example after the group was removed from the identity provider. An idp_group_id that is not valid, or that names no group that the list returns, returns 404 resource_not_found. The caller must be able to read the workspace configuration or the workspace billing.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-admin-idp-groups-get" method="get" path="/api/admin/idp-groups/{idp_group_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformAdminIdpGroupsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformAdminIdpGroupsGetResponse res = sdk.admin().idpgroups().get()
                .idpGroupId("{idp_group_id}")
                .call();

        if (res.platformGetIdpGroupResponse().isPresent()) {
            System.out.println(res.platformGetIdpGroupResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                    | Type                                                                                                                                                                         | Required                                                                                                                                                                     | Description                                                                                                                                                                  | Example                                                                                                                                                                      |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `idpGroupId`                                                                                                                                                                 | *String*                                                                                                                                                                     | :heavy_check_mark:                                                                                                                                                           | The idp_group_id from a list IdP groups response. IDs are opaque. Do not parse or build them. The group_id in usage limit responses is not an idp_group_id and returns 404.<br/> | {idp_group_id}                                                                                                                                                               |

### Response

**[PlatformAdminIdpGroupsGetResponse](../../models/operations/PlatformAdminIdpGroupsGetResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |