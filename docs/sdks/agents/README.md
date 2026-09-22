# Agents

## Overview

### Available Operations

* [search](#search) - Search agents
* [get](#get) - Get agent
* [getSchemas](#getschemas) - Get agent schemas
* [createRun](#createrun) - Create agent run
* [getRun](#getrun) - Get agent run

## search

Search agents available to the authenticated user by agent name.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-agents-search" method="post" path="/api/agents/search" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.PlatformAgentsSearchRequest;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformAgentsSearchResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformAgentsSearchRequest req = PlatformAgentsSearchRequest.builder()
                .name("HR Policy Agent")
                .build();

        PlatformAgentsSearchResponse res = sdk.agents().search()
                .request(req)
                .call();

        if (res.platformAgentsSearchResponse().isPresent()) {
            System.out.println(res.platformAgentsSearchResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [PlatformAgentsSearchRequest](../../models/shared/PlatformAgentsSearchRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[PlatformAgentsSearchResponse](../../models/operations/PlatformAgentsSearchResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 413, 429            | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## get

Retrieve details for an agent available to the authenticated user.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-agents-get" method="get" path="/api/agents/{agent_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformAgentsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformAgentsGetResponse res = sdk.agents().get()
                .agentId("{agent_id}")
                .call();

        if (res.platformAgentGetResponse().isPresent()) {
            System.out.println(res.platformAgentGetResponse().get());
        }
    }
}
```

### Parameters

| Parameter                    | Type                         | Required                     | Description                  | Example                      |
| ---------------------------- | ---------------------------- | ---------------------------- | ---------------------------- | ---------------------------- |
| `agentId`                    | *String*                     | :heavy_check_mark:           | ID of the agent to retrieve. | {agent_id}                   |

### Response

**[PlatformAgentsGetResponse](../../models/operations/PlatformAgentsGetResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## getSchemas

Retrieve an agent's input and output JSON schemas.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-agents-get-schemas" method="get" path="/api/agents/{agent_id}/schemas" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformAgentsGetSchemasResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformAgentsGetSchemasResponse res = sdk.agents().getSchemas()
                .agentId("{agent_id}")
                .includeTools(false)
                .call();

        if (res.platformAgentSchemasResponse().isPresent()) {
            System.out.println(res.platformAgentSchemasResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                          | Type                                               | Required                                           | Description                                        | Example                                            |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| `agentId`                                          | *String*                                           | :heavy_check_mark:                                 | ID of the agent whose schemas should be retrieved. | {agent_id}                                         |
| `includeTools`                                     | *Optional\<Boolean>*                               | :heavy_minus_sign:                                 | Whether to include tool metadata in the response.  |                                                    |

### Response

**[PlatformAgentsGetSchemasResponse](../../models/operations/PlatformAgentsGetSchemasResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## createRun

Execute an agent run. By default, set `stream` to true to receive server-sent events; otherwise the response contains the final agent messages. Set `execution_mode` to `DURABLE` to persist a new run and return its initial snapshot with HTTP 201 without waiting for execution. Poll the agent-scoped GET run endpoint for progress. Durable execution continues after an HTTP disconnect, but is not automatically resumed after a QE restart or crash. An active turn becomes overdue more than 40 minutes after acceptance (a 30-minute execution timeout plus 10 minutes of grace). The next GET of the run marks the overdue turn FAILED without replay; there is no periodic sweep. Without a GET, the stored run can remain RUNNING. Failure does not prove that external tool work has stopped. Paused runs are not expired. Each POST creates a new run; retrying a POST can create another execution. A run tracks one workflow execution; automatic background-subagent wake turns are separate executions, not continuations tracked by this run ID.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-agents-create-run" method="post" path="/api/agents/{agent_id}/runs" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.errors.PlatformUnauthorizedAgentToolsProblemException;
import com.glean.api_client.glean_api_client.models.operations.PlatformAgentsCreateRunResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PlatformUnauthorizedAgentToolsProblemException, PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformAgentsCreateRunResponse res = sdk.agents().createRun()
                .agentId("{agent_id}")
                .platformAgentRunCreateRequest(PlatformAgentRunCreateRequest.builder()
                    .messages(List.of(
                        PlatformMessageInput.builder()
                            .role(PlatformMessageRole.USER)
                            .content(List.of(
                                PlatformMessageTextBlockInput.builder()
                                    .text("What is our parental leave policy?")
                                    .type(PlatformContentType.TEXT)
                                    .build()))
                            .build()))
                    .build())
                .call();

        if (res.platformAgentRunWaitResponse().isPresent()) {
            System.out.println(res.platformAgentRunWaitResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                               | Type                                                                                                                    | Required                                                                                                                | Description                                                                                                             | Example                                                                                                                 |
| ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- |
| `agentId`                                                                                                               | *String*                                                                                                                | :heavy_check_mark:                                                                                                      | ID of the agent to run.                                                                                                 | {agent_id}                                                                                                              |
| `platformAgentRunCreateRequest`                                                                                         | [PlatformAgentRunCreateRequest](../../models/components/PlatformAgentRunCreateRequest.md)                               | :heavy_check_mark:                                                                                                      | N/A                                                                                                                     | {<br/>"messages": [<br/>{<br/>"role": "USER",<br/>"content": [<br/>{<br/>"text": "What is our parental leave policy?",<br/>"type": "text"<br/>}<br/>]<br/>}<br/>]<br/>} |

### Response

**[PlatformAgentsCreateRunResponse](../../models/operations/PlatformAgentsCreateRunResponse.md)**

### Errors

| Error Type                                                   | Status Code                                                  | Content Type                                                 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| models/errors/PlatformUnauthorizedAgentToolsProblemException | 422                                                          | application/problem+json                                     |
| models/errors/PlatformProblemDetailException                 | 400, 401, 403, 404, 408, 409, 413, 429                       | application/problem+json                                     |
| models/errors/PlatformProblemDetailException                 | 500, 503                                                     | application/problem+json                                     |
| models/errors/APIException                                   | 4XX, 5XX                                                     | \*/\*                                                        |

## getRun

Retrieve a persisted workflow execution owned by the authenticated user. The run must belong to the specified agent, and the user must still have access to that agent. Unknown runs, runs owned by another user, and mismatched agent/run identifiers return 404. Requires the agents.run scope. Executions without a persisted workflow record are not available through this endpoint.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-agents-get-run" method="get" path="/api/agents/{agent_id}/runs/{run_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformAgentsGetRunResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformAgentsGetRunResponse res = sdk.agents().getRun()
                .agentId("{agent_id}")
                .runId("{run_id}")
                .call();

        if (res.platformAgentRunResponse().isPresent()) {
            System.out.println(res.platformAgentRunResponse().get());
        }
    }
}
```

### Parameters

| Parameter                          | Type                               | Required                           | Description                        | Example                            |
| ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| `agentId`                          | *String*                           | :heavy_check_mark:                 | ID of the agent that owns the run. | {agent_id}                         |
| `runId`                            | *String*                           | :heavy_check_mark:                 | ID of the durable run to retrieve. | {run_id}                           |

### Response

**[PlatformAgentsGetRunResponse](../../models/operations/PlatformAgentsGetRunResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |