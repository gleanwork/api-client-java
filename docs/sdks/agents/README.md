# Agents
(*client().agents()*)

## Overview

### Available Operations

* [retrieve](#retrieve) - Get Agent
* [retrieveSchemas](#retrieveschemas) - Get Agent Schemas
* [list](#list) - Search Agents
* [runStream](#runstream) - Create Run, Stream Output
* [run](#run) - Create Run, Wait for Output

## retrieve

Get an agent by ID. This endpoint implements the LangChain Agent Protocol, specifically part of the Agents stage (https://langchain-ai.github.io/agent-protocol/api.html#tag/agents/GET/agents/{agent_id}). It adheres to the standard contract defined for agent interoperability and can be used by agent runtimes that support the Agent Protocol.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.GetAgentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetAgentResponse res = sdk.client().agents().retrieve()
                .agentId("<id>")
                .call();

        if (res.agent().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                  | Type                                                                                                       | Required                                                                                                   | Description                                                                                                |
| ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| `timezoneOffset`                                                                                           | *Optional\<Long>*                                                                                          | :heavy_minus_sign:                                                                                         | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC. |
| `agentId`                                                                                                  | *String*                                                                                                   | :heavy_check_mark:                                                                                         | The ID of the agent.                                                                                       |

### Response

**[GetAgentResponse](../../models/operations/GetAgentResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieveSchemas

Get an agent's schemas by ID. This endpoint implements the LangChain Agent Protocol, specifically part of the Agents stage (https://langchain-ai.github.io/agent-protocol/api.html#tag/agents/GET/agents/{agent_id}/schemas). It adheres to the standard contract defined for agent interoperability and can be used by agent runtimes that support the Agent Protocol.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.GetAgentSchemasResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetAgentSchemasResponse res = sdk.client().agents().retrieveSchemas()
                .agentId("<id>")
                .call();

        if (res.agentSchemas().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                  | Type                                                                                                       | Required                                                                                                   | Description                                                                                                |
| ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| `timezoneOffset`                                                                                           | *Optional\<Long>*                                                                                          | :heavy_minus_sign:                                                                                         | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC. |
| `agentId`                                                                                                  | *String*                                                                                                   | :heavy_check_mark:                                                                                         | The ID of the agent.                                                                                       |

### Response

**[GetAgentSchemasResponse](../../models/operations/GetAgentSchemasResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

List Agents available in this service. This endpoint implements the LangChain Agent Protocol, specifically part of the Agents stage (https://langchain-ai.github.io/agent-protocol/api.html#tag/agents/POST/agents/search). It adheres to the standard contract defined for agent interoperability and can be used by agent runtimes that support the Agent Protocol.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.SearchAgentsRequest;
import com.glean.api_client.glean_api_client.models.operations.SearchAgentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        SearchAgentsRequest req = SearchAgentsRequest.builder()
                .build();

        SearchAgentsResponse res = sdk.client().agents().list()
                .request(req)
                .call();

        if (res.searchAgentsResponse().isPresent()) {
            // handle response
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

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## runStream

Creates and triggers a run of an agent. Streams the output in SSE format. This endpoint implements the LangChain Agent Protocol, specifically part of the Runs stage (https://langchain-ai.github.io/agent-protocol/api.html#tag/runs/POST/runs/stream). It adheres to the standard contract defined for agent interoperability and can be used by agent runtimes that support the Agent Protocol. Note that running agents that reference third party platform write actions is unsupported as it requires user confirmation.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.AgentRunCreate;
import com.glean.api_client.glean_api_client.models.operations.CreateAndStreamRunResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        AgentRunCreate req = AgentRunCreate.builder()
                .build();

        CreateAndStreamRunResponse res = sdk.client().agents().runStream()
                .request(req)
                .call();

        if (res.res().isPresent()) {
            // handle response
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

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## run

Creates and triggers a run of an agent. Waits for final output and then returns it. This endpoint implements the LangChain Agent Protocol, specifically part of the Runs stage (https://langchain-ai.github.io/agent-protocol/api.html#tag/runs/POST/runs/wait). It adheres to the standard contract defined for agent interoperability and can be used by agent runtimes that support the Agent Protocol. Note that running agents that reference third party platform write actions is unsupported as it requires user confirmation.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.AgentRunCreate;
import com.glean.api_client.glean_api_client.models.operations.CreateAndWaitRunResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        AgentRunCreate req = AgentRunCreate.builder()
                .build();

        CreateAndWaitRunResponse res = sdk.client().agents().run()
                .request(req)
                .call();

        if (res.agentRunWaitResponse().isPresent()) {
            // handle response
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