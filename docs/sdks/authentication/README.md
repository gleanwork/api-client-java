# Authentication

## Overview

Manage indexing API tokens.

### Available Operations

* [checkdatasourceauth](#checkdatasourceauth) - Check datasource authorization

## checkdatasourceauth

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

        CheckdatasourceauthResponse res = sdk.authentication().checkdatasourceauth()
                .call();

        if (res.checkDatasourceAuthResponse().isPresent()) {
            // handle response
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