# Agents
(*client().agents()*)

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

Return [agent](https://developers.glean.com/agents/agents-api)'s input and output schemas. You can use these schemas to detect changes to an agent's input or output structure.

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

Search for [agents](https://developers.glean.com/agents/agents-api) by agent name.

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
                .name("HR Policy Agent")
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

Executes an [agent](https://developers.glean.com/agents/agents-api) run and returns the result as a stream of server-sent events (SSE).

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
                .agentId("<id>")
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

Executes an [agent](https://developers.glean.com/agents/agents-api) run and returns the final response.

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
                .agentId("<id>")
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