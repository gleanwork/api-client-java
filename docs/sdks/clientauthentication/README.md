# Client.Authentication

## Overview

### Available Operations

* [checkDatasourceAuth](#checkdatasourceauth) - Check datasource authorization
* [createToken](#createtoken) - Create authentication token

## checkDatasourceAuth

Returns all datasource instances that require per-user OAuth authorization
for the authenticated user, along with a transient auth token that can be
appended to auth URLs to complete OAuth flows.

Clients construct the full OAuth URL by combining the backend base URL,
the `authUrlRelativePath` from each instance, and the transient auth token:
`<backend>/<authUrlRelativePath>?transient_auth_token=<token>`.


### Example Usage

<!-- UsageSnippet language="java" operationID="checkdatasourceauth" method="post" path="/rest/api/v1/checkdatasourceauth" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.CheckdatasourceauthResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        CheckdatasourceauthResponse res = sdk.client().authentication().checkDatasourceAuth()
                .call();

        if (res.checkDatasourceAuthResponse().isPresent()) {
            System.out.println(res.checkDatasourceAuthResponse().get());
        }
    }
}
```

### Response

**[CheckdatasourceauthResponse](../../models/operations/CheckdatasourceauthResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## createToken

Creates an authentication token for the authenticated user. These are
specifically intended to be used with the [Web SDK](https://developers.glean.com/web).

Note: The tokens generated from this endpoint are **not** valid tokens
for use with the Client API (e.g. `/rest/api/v1/*`).


### Example Usage

<!-- UsageSnippet language="java" operationID="createauthtoken" method="post" path="/rest/api/v1/createauthtoken" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.CreateauthtokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        CreateauthtokenResponse res = sdk.client().authentication().createToken()
                .call();

        if (res.createAuthTokenResponse().isPresent()) {
            System.out.println(res.createAuthTokenResponse().get());
        }
    }
}
```

### Response

**[CreateauthtokenResponse](../../models/operations/CreateauthtokenResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |