# Client.Tools

## Overview

### Available Operations

* [list](#list) - List available tools
* [run](#run) - Execute the specified tool
* [retrieveActionPackAuthStatus](#retrieveactionpackauthstatus) - Get end-user authentication status for an action pack.
* [authorizeActionPack](#authorizeactionpack) - Start the OAuth authorization flow for an action pack.
* [retrieveToolServerAuthStatus](#retrievetoolserverauthstatus) - Get end-user authentication status for a tool server.
* [authorizeToolServer](#authorizetoolserver) - Start the OAuth authorization flow for a tool server.
* [getToolServerTools](#gettoolservertools) - Get tool definitions from a tool server.

## list

Returns a filtered set of available tools based on optional tool name parameters. If no filters are provided, all available tools are returned.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_/rest/api/v1/tools/list" method="get" path="/rest/api/v1/tools/list" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.GetRestApiV1ToolsListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetRestApiV1ToolsListResponse res = sdk.client().tools().list()
                .call();

        if (res.toolsListResponse().isPresent()) {
            System.out.println(res.toolsListResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                 | Type                                      | Required                                  | Description                               |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| `toolNames`                               | List\<*String*>                           | :heavy_minus_sign:                        | Optional array of tool names to filter by |

### Response

**[GetRestApiV1ToolsListResponse](../../models/operations/GetRestApiV1ToolsListResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## run

Execute the specified tool with provided parameters

### Example Usage

<!-- UsageSnippet language="java" operationID="post_/rest/api/v1/tools/call" method="post" path="/rest/api/v1/tools/call" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.ToolsCallParameter;
import com.glean.api_client.glean_api_client.models.components.ToolsCallRequest;
import com.glean.api_client.glean_api_client.models.operations.PostRestApiV1ToolsCallResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        ToolsCallRequest req = ToolsCallRequest.builder()
                .name("<value>")
                .parameters(Map.ofEntries(
                    Map.entry("key", ToolsCallParameter.builder()
                        .name("<value>")
                        .value("<value>")
                        .build())))
                .build();

        PostRestApiV1ToolsCallResponse res = sdk.client().tools().run()
                .request(req)
                .call();

        if (res.toolsCallResponse().isPresent()) {
            System.out.println(res.toolsCallResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                   | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `request`                                                   | [ToolsCallRequest](../../models/shared/ToolsCallRequest.md) | :heavy_check_mark:                                          | The request object to use for the request.                  |

### Response

**[PostRestApiV1ToolsCallResponse](../../models/operations/PostRestApiV1ToolsCallResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieveActionPackAuthStatus

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

        GetActionPackAuthStatusResponse res = sdk.client().tools().retrieveActionPackAuthStatus()
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

        AuthorizeActionPackResponse res = sdk.client().tools().authorizeActionPack()
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

## retrieveToolServerAuthStatus

Returns display information and the calling user's current authentication status
for the specified tool server.


### Example Usage

<!-- UsageSnippet language="java" operationID="getToolServerAuthStatus" method="get" path="/rest/api/v1/tool-servers/{serverId}/auth" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.GetToolServerAuthStatusResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetToolServerAuthStatusResponse res = sdk.client().tools().retrieveToolServerAuthStatus()
                .serverId("<id>")
                .call();

        if (res.toolServerAuthStatusResponse().isPresent()) {
            System.out.println(res.toolServerAuthStatusResponse().get());
        }
    }
}
```

### Parameters

| Parameter                             | Type                                  | Required                              | Description                           |
| ------------------------------------- | ------------------------------------- | ------------------------------------- | ------------------------------------- |
| `serverId`                            | *String*                              | :heavy_check_mark:                    | Unique identifier of the tool server. |

### Response

**[GetToolServerAuthStatusResponse](../../models/operations/GetToolServerAuthStatusResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## authorizeToolServer

Initiates the third-party OAuth flow for the specified tool server and returns the
authorization URL that the client should navigate the end user to. After the OAuth
callback completes, the user's browser is redirected back to `returnUrl` with query
parameters indicating the result.

`returnUrl` must match the tenant's configured return URL allowlist; otherwise the
request is rejected with 400.


### Example Usage

<!-- UsageSnippet language="java" operationID="authorizeToolServer" method="post" path="/rest/api/v1/tool-servers/{serverId}/auth" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.AuthorizeToolServerRequest;
import com.glean.api_client.glean_api_client.models.operations.AuthorizeToolServerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        AuthorizeToolServerResponse res = sdk.client().tools().authorizeToolServer()
                .serverId("<id>")
                .authorizeToolServerRequest(AuthorizeToolServerRequest.builder()
                    .returnUrl("https://lucky-disadvantage.com")
                    .build())
                .call();

        if (res.authorizeToolServerResponse().isPresent()) {
            System.out.println(res.authorizeToolServerResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                           | Type                                                                                | Required                                                                            | Description                                                                         |
| ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `serverId`                                                                          | *String*                                                                            | :heavy_check_mark:                                                                  | Unique identifier of the tool server.                                               |
| `authorizeToolServerRequest`                                                        | [AuthorizeToolServerRequest](../../models/components/AuthorizeToolServerRequest.md) | :heavy_check_mark:                                                                  | N/A                                                                                 |

### Response

**[AuthorizeToolServerResponse](../../models/operations/AuthorizeToolServerResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getToolServerTools

Returns the name, description and JSON input schema for the named tools on the
specified tool server. Works for both action packs and MCP servers.

`toolNames` is required. Names that do not exist on the server are returned in
`notFound` rather than failing the request, so a single bad name does not force
callers into one-at-a-time retries. Matching is case-insensitive and treats `-`
and `_` as equivalent.

Native tools are not served; `serverId=native` returns 404.


### Example Usage

<!-- UsageSnippet language="java" operationID="getToolServerTools" method="get" path="/rest/api/v1/tool-servers/{serverId}/tools" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.GetToolServerToolsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetToolServerToolsResponse res = sdk.client().tools().getToolServerTools()
                .serverId("<id>")
                .toolNames(List.of(
                    "<value 1>",
                    "<value 2>",
                    "<value 3>"))
                .call();

        if (res.toolDefinitionsResponse().isPresent()) {
            System.out.println(res.toolDefinitionsResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                          | Type                                               | Required                                           | Description                                        |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| `serverId`                                         | *String*                                           | :heavy_check_mark:                                 | Unique identifier of the tool server.              |
| `toolNames`                                        | List\<*String*>                                    | :heavy_check_mark:                                 | Tool names to look up on this server. Maximum 100. |

### Response

**[GetToolServerToolsResponse](../../models/operations/GetToolServerToolsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |