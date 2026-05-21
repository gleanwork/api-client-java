# Client.Agents

## Overview

### Available Operations

* [retrieve](#retrieve) - Retrieve an agent
* [retrieveSchemas](#retrieveschemas) - List an agent's schemas
* [list](#list) - Search agents
* [runStream](#runstream) - Create an agent run and stream the response
* [run](#run) - Create an agent run and wait for the response

## retrieve

Returns details of an [agent](https://developers.glean.com/agents/agents-api) created in the Agent Builder.

### Example Usage

<!-- UsageSnippet language="java" operationID="getAgent" method="get" path="/rest/api/v1/agents/{agent_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.ErrorResponse;
import com.glean.api_client.glean_api_client.models.operations.GetAgentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetAgentResponse res = sdk.client().agents().retrieve()
                .agentId("<id>")
                .call();

        if (res.agent().isPresent()) {
            System.out.println(res.agent().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `timezoneOffset`                                                                                                                                                                                    | *Optional\<Long>*                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                  | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.                                                                                          |
| `agentId`                                                                                                                                                                                           | *String*                                                                                                                                                                                            | :heavy_check_mark:                                                                                                                                                                                  | The ID of the agent.                                                                                                                                                                                |

### Response

**[GetAgentResponse](../../models/operations/GetAgentResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/json            |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## retrieveSchemas

Return [agent](https://developers.glean.com/agents/agents-api)'s input and output schemas. You can use these schemas to detect changes to an agent's input or output structure.

### Example Usage

<!-- UsageSnippet language="java" operationID="getAgentSchemas" method="get" path="/rest/api/v1/agents/{agent_id}/schemas" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.ErrorResponse;
import com.glean.api_client.glean_api_client.models.operations.GetAgentSchemasResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetAgentSchemasResponse res = sdk.client().agents().retrieveSchemas()
                .agentId("<id>")
                .call();

        if (res.agentSchemas().isPresent()) {
            System.out.println(res.agentSchemas().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `timezoneOffset`                                                                                                                                                                                    | *Optional\<Long>*                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                  | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.                                                                                          |
| `agentId`                                                                                                                                                                                           | *String*                                                                                                                                                                                            | :heavy_check_mark:                                                                                                                                                                                  | The ID of the agent.                                                                                                                                                                                |

### Response

**[GetAgentSchemasResponse](../../models/operations/GetAgentSchemasResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422                    | application/json            |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## list

Search for [agents](https://developers.glean.com/agents/agents-api) by agent name.

### Example Usage

<!-- UsageSnippet language="java" operationID="searchAgents" method="post" path="/rest/api/v1/agents/search" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.SearchAgentsRequest;
import com.glean.api_client.glean_api_client.models.errors.ErrorResponse;
import com.glean.api_client.glean_api_client.models.operations.SearchAgentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        SearchAgentsRequest req = SearchAgentsRequest.builder()
                .name("HR Policy Agent")
                .build();

        SearchAgentsResponse res = sdk.client().agents().list()
                .request(req)
                .call();

        if (res.searchAgentsResponse().isPresent()) {
            System.out.println(res.searchAgentsResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [SearchAgentsRequest](../../models/shared/SearchAgentsRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[SearchAgentsResponse](../../models/operations/SearchAgentsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422                    | application/json            |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## runStream

Executes an [agent](https://developers.glean.com/agents/agents-api) run and returns the result as a stream of server-sent events (SSE). **Note**: If the agent uses an input form trigger, all form fields (including optional fields) must be included in the `input` object.

### Example Usage

<!-- UsageSnippet language="java" operationID="createAndStreamRun" method="post" path="/rest/api/v1/agents/runs/stream" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.AgentRunCreate;
import com.glean.api_client.glean_api_client.models.components.Message;
import com.glean.api_client.glean_api_client.models.errors.ErrorResponse;
import com.glean.api_client.glean_api_client.models.operations.CreateAndStreamRunResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        AgentRunCreate req = AgentRunCreate.builder()
                .agentId("<id>")
                .messages(List.of(
                    Message.builder()
                        .role("USER")
                        .build()))
                .build();

        CreateAndStreamRunResponse res = sdk.client().agents().runStream()
                .request(req)
                .call();

        if (res.res().isPresent()) {
            System.out.println(res.res().get());
        }
    }
}
```

### Parameters

| Parameter                                               | Type                                                    | Required                                                | Description                                             |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| `request`                                               | [AgentRunCreate](../../models/shared/AgentRunCreate.md) | :heavy_check_mark:                                      | The request object to use for the request.              |

### Response

**[CreateAndStreamRunResponse](../../models/operations/CreateAndStreamRunResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 409, 422               | application/json            |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## run

Executes an [agent](https://developers.glean.com/agents/agents-api) run and returns the final response. **Note**: If the agent uses an input form trigger, all form fields (including optional fields) must be included in the `input` object.

### Example Usage

<!-- UsageSnippet language="java" operationID="createAndWaitRun" method="post" path="/rest/api/v1/agents/runs/wait" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.AgentRunCreate;
import com.glean.api_client.glean_api_client.models.components.Message;
import com.glean.api_client.glean_api_client.models.operations.CreateAndWaitRunResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        AgentRunCreate req = AgentRunCreate.builder()
                .agentId("<id>")
                .messages(List.of(
                    Message.builder()
                        .role("USER")
                        .build()))
                .build();

        CreateAndWaitRunResponse res = sdk.client().agents().run()
                .request(req)
                .call();

        if (res.agentRunWaitResponse().isPresent()) {
            System.out.println(res.agentRunWaitResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                               | Type                                                    | Required                                                | Description                                             |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| `request`                                               | [AgentRunCreate](../../models/shared/AgentRunCreate.md) | :heavy_check_mark:                                      | The request object to use for the request.              |

### Response

**[CreateAndWaitRunResponse](../../models/operations/CreateAndWaitRunResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |