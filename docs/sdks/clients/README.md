# Admin.Oauth.Clients

## Overview

### Available Operations

* [list](#list) - List OAuth clients

## list

List the static OAuth clients that admins created for this workspace, ordered by display_name and then by client_id. Dynamically registered clients and Glean's own clients, such as Glean Desktop, are not listed. A client is active when it is enabled. Inactive clients are left out unless an is_active filter includes the value "false". To set a usage limit for a client, send its ai_gateway.usage_client_id, not its client_id, to the usage APIs. The caller needs admin read or billing read permission.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-admin-oauth-clients-list" method="get" path="/api/admin/oauth/clients" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformAdminOauthClientsListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformAdminOauthClientsListResponse res = sdk.admin().oauth().clients().list()
                .pageSize(50L)
                .call();

        if (res.platformListOAuthClientsResponse().isPresent()) {
            System.out.println(res.platformListOAuthClientsResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                                         | Type                                                                                                                                                                                                                                                                                                                                                                                              | Required                                                                                                                                                                                                                                                                                                                                                                                          | Description                                                                                                                                                                                                                                                                                                                                                                                       |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `pageSize`                                                                                                                                                                                                                                                                                                                                                                                        | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                | Maximum number of clients to return. Defaults to 50. Maximum is 100.                                                                                                                                                                                                                                                                                                                              |
| `cursor`                                                                                                                                                                                                                                                                                                                                                                                          | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                | Opaque pagination cursor from a previous response. Send the same filters that the previous request used.<br/>                                                                                                                                                                                                                                                                                     |
| `filters`                                                                                                                                                                                                                                                                                                                                                                                         | List\<[PlatformOAuthClientFilter](../../models/components/PlatformOAuthClientFilter.md)>                                                                                                                                                                                                                                                                                                          | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                | JSON-encoded filters that choose which clients are returned. The only supported field is is_active, with the values "true" and "false" and the operator EQUALS. Multiple values OR within a filter. Multiple filters AND together. Without an is_active filter, only active clients are returned. To return active and inactive clients, send [{"field":"is_active","values":["true","false"]}].<br/> |

### Response

**[PlatformAdminOauthClientsListResponse](../../models/operations/PlatformAdminOauthClientsListResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |