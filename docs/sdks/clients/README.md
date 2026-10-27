# Admin.Oauth.Clients

## Overview

### Available Operations

* [list](#list) - List OAuth clients
* [get](#get) - Get an OAuth client

## list

List the static OAuth clients that admins created for this workspace, ordered by display_name and then by client_id. Dynamically registered clients and Glean's own clients, such as Glean Desktop, are not listed. A client is active when it is enabled. Inactive clients are left out unless an is_active filter includes the value "false". An is_ai_gateway_enabled filter returns only the clients that can call the Glean LLM Gateway, or only the clients that cannot. To set a usage limit for a client, send its ai_gateway.usage_client_id, not its client_id, to the usage APIs. The caller needs admin read or billing read permission.


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

| Parameter                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    | Type                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | Required                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `pageSize`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           | Maximum number of clients to return. Defaults to 50. Maximum is 100.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| `cursor`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           | Opaque pagination cursor from a previous response. Send the same filters that the previous request used.<br/>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| `filters`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    | List\<[PlatformOAuthClientFilter](../../models/components/PlatformOAuthClientFilter.md)>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           | JSON-encoded filters that choose which clients are returned. The supported fields are is_active and is_ai_gateway_enabled. Both take the values "true" and "false". The only supported operator is EQUALS. Multiple values OR within a filter. Multiple filters AND together. Without an is_active filter, only active clients are returned. To return active and inactive clients, send [{"field":"is_active","values":["true","false"]}]. An is_ai_gateway_enabled filter with the value "true" returns only the clients that have ai_gateway. The value "false" returns only the clients that do not. Without an is_ai_gateway_enabled filter, clients are returned whether or not they have ai_gateway.<br/> |

### Response

**[PlatformAdminOauthClientsListResponse](../../models/operations/PlatformAdminOauthClientsListResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## get

Get one static OAuth client that an admin created for this workspace. A client that an admin disabled is returned with is_active false. A deleted client, a dynamically registered client, one of Glean's own clients, such as Glean Desktop, and an unknown client_id all return 404. The path takes the OAuth client_id, not ai_gateway.usage_client_id. The caller needs admin read or billing read permission.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-admin-oauth-clients-get" method="get" path="/api/admin/oauth/clients/{client_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformAdminOauthClientsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformAdminOauthClientsGetResponse res = sdk.admin().oauth().clients().get()
                .clientId("{client_id}")
                .call();

        if (res.platformGetOAuthClientResponse().isPresent()) {
            System.out.println(res.platformGetOAuthClientResponse().get());
        }
    }
}
```

### Parameters

| Parameter                          | Type                               | Required                           | Description                        | Example                            |
| ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| `clientId`                         | *String*                           | :heavy_check_mark:                 | The OAuth client_id of the client. | {client_id}                        |

### Response

**[PlatformAdminOauthClientsGetResponse](../../models/operations/PlatformAdminOauthClientsGetResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |