# Admin.Agents

## Overview

### Available Operations

* [list](#list) - List all agents

## list

List every agent in the workspace, ordered by display_name and then by agent_id. Unlike agent search, the list does not depend on who an agent is shared with, so it includes private and disabled agents. Deleted agents are inactive and are left out unless an is_active filter includes the value "false". Use the agent_id of an active agent with other Platform APIs, for example as a usage limit target. A deleted agent is not a valid usage limit target. The caller must be able to read all agents, administer agents, or read workspace billing.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-admin-agents-list" method="get" path="/api/admin/agents" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformAdminAgentsListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformAdminAgentsListResponse res = sdk.admin().agents().list()
                .pageSize(50L)
                .call();

        if (res.platformListAdminAgentsResponse().isPresent()) {
            System.out.println(res.platformListAdminAgentsResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                                     | Type                                                                                                                                                                                                                                                                                                                                                                                          | Required                                                                                                                                                                                                                                                                                                                                                                                      | Description                                                                                                                                                                                                                                                                                                                                                                                   |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `pageSize`                                                                                                                                                                                                                                                                                                                                                                                    | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                             | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                            | Maximum number of agents to return. Defaults to 50. Maximum is 100.                                                                                                                                                                                                                                                                                                                           |
| `cursor`                                                                                                                                                                                                                                                                                                                                                                                      | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                           | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                            | Opaque pagination cursor from a previous response. Send the same filters that the previous request used.<br/>                                                                                                                                                                                                                                                                                 |
| `filters`                                                                                                                                                                                                                                                                                                                                                                                     | List\<[PlatformAdminAgentFilter](../../models/components/PlatformAdminAgentFilter.md)>                                                                                                                                                                                                                                                                                                        | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                            | JSON-encoded filters that choose which agents are returned. The only supported field is is_active, with the values "true" and "false" and the operator EQUALS. Multiple values OR within a filter. Multiple filters AND together. Without an is_active filter, only active agents are returned. To return active and deleted agents, send [{"field":"is_active","values":["true","false"]}].<br/> |

### Response

**[PlatformAdminAgentsListResponse](../../models/operations/PlatformAdminAgentsListResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |