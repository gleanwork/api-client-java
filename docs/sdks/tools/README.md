# Tools

## Overview

### Available Operations

* [getActionAuthStatus](#getactionauthstatus) - Get end-user authentication status for an action pack.
* [authorizeAction](#authorizeaction) - Start the OAuth authorization flow for an action pack.

## getActionAuthStatus

Reports whether the calling user is already authenticated against the third-party
tool backing the specified action pack. Intended for headless / server-driven clients
that render an "Authorize" prompt when the user has not yet consented to the tool.


### Example Usage

<!-- UsageSnippet language="java" operationID="getActionAuthStatus" method="get" path="/rest/api/v1/actions/{actionPackId}/auth" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.GetActionAuthStatusResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetActionAuthStatusResponse res = sdk.tools().getActionAuthStatus()
                .actionPackId("<id>")
                .call();

        if (res.actionAuthStatusResponse().isPresent()) {
            System.out.println(res.actionAuthStatusResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                    | Type                                         | Required                                     | Description                                  |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| `actionPackId`                               | *String*                                     | :heavy_check_mark:                           | ID of the action pack to query or authorize. |

### Response

**[GetActionAuthStatusResponse](../../models/operations/GetActionAuthStatusResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## authorizeAction

Starts the third-party OAuth flow for the specified action pack and returns the
redirect URL that the client should navigate the end user to. After the OAuth
callback completes, the user's browser is redirected back to `returnUrl` with a
status query parameter (`?glean_action_auth=success|error&actionPackId=...`).

`returnUrl` must match the tenant's configured return URL allowlist; otherwise the
request is rejected with 400.


### Example Usage

<!-- UsageSnippet language="java" operationID="authorizeAction" method="post" path="/rest/api/v1/actions/{actionPackId}/auth" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.AuthorizeActionRequest;
import com.glean.api_client.glean_api_client.models.operations.AuthorizeActionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        AuthorizeActionResponse res = sdk.tools().authorizeAction()
                .actionPackId("<id>")
                .authorizeActionRequest(AuthorizeActionRequest.builder()
                    .returnUrl("https://irresponsible-trick.name/")
                    .build())
                .call();

        if (res.authorizeActionResponse().isPresent()) {
            System.out.println(res.authorizeActionResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `actionPackId`                                                              | *String*                                                                    | :heavy_check_mark:                                                          | ID of the action pack to query or authorize.                                |
| `authorizeActionRequest`                                                    | [AuthorizeActionRequest](../../models/components/AuthorizeActionRequest.md) | :heavy_check_mark:                                                          | N/A                                                                         |

### Response

**[AuthorizeActionResponse](../../models/operations/AuthorizeActionResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |