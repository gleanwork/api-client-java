# Tools

## Overview

### Available Operations

* [getActionPackAuthStatus](#getactionpackauthstatus) - Get end-user authentication status for an action pack.
* [authorizeActionPack](#authorizeactionpack) - Start the OAuth authorization flow for an action pack.

## getActionPackAuthStatus

Reports whether the calling user is already authenticated against the third-party
tool backing the specified action pack. Intended for headless / server-driven clients
that render an "Authorize" prompt when the user has not yet consented to the tool.


### Example Usage

<!-- UsageSnippet language="java" operationID="getActionPackAuthStatus" method="get" path="/rest/api/v1/actions/actionpack/{actionPackId}/auth" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.GetActionPackAuthStatusResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetActionPackAuthStatusResponse res = sdk.tools().getActionPackAuthStatus()
                .actionPackId("<id>")
                .call();

        if (res.actionPackAuthStatusResponse().isPresent()) {
            System.out.println(res.actionPackAuthStatusResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                    | Type                                         | Required                                     | Description                                  |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| `actionPackId`                               | *String*                                     | :heavy_check_mark:                           | ID of the action pack to query or authorize. |

### Response

**[GetActionPackAuthStatusResponse](../../models/operations/GetActionPackAuthStatusResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## authorizeActionPack

Starts the third-party OAuth flow for the specified action pack and returns the
redirect URL that the client should navigate the end user to. After the OAuth
callback completes, the user's browser is redirected back to `returnUrl` with a
status query parameter (`?glean_action_auth=success|error&actionPackId=...`).

`returnUrl` must match the tenant's configured return URL allowlist; otherwise the
request is rejected with 400.


### Example Usage

<!-- UsageSnippet language="java" operationID="authorizeActionPack" method="post" path="/rest/api/v1/actions/actionpack/{actionPackId}/auth" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.AuthorizeActionPackRequest;
import com.glean.api_client.glean_api_client.models.operations.AuthorizeActionPackResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        AuthorizeActionPackResponse res = sdk.tools().authorizeActionPack()
                .actionPackId("<id>")
                .authorizeActionPackRequest(AuthorizeActionPackRequest.builder()
                    .returnUrl("https://merry-allocation.org/")
                    .build())
                .call();

        if (res.authorizeActionPackResponse().isPresent()) {
            System.out.println(res.authorizeActionPackResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                           | Type                                                                                | Required                                                                            | Description                                                                         |
| ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `actionPackId`                                                                      | *String*                                                                            | :heavy_check_mark:                                                                  | ID of the action pack to query or authorize.                                        |
| `authorizeActionPackRequest`                                                        | [AuthorizeActionPackRequest](../../models/components/AuthorizeActionPackRequest.md) | :heavy_check_mark:                                                                  | N/A                                                                                 |

### Response

**[AuthorizeActionPackResponse](../../models/operations/AuthorizeActionPackResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |