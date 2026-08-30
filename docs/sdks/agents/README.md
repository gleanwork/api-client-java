# Agents

## Overview

### Available Operations

* [search](#search) - Search agents
* [get](#get) - Get agent
* [getSchemas](#getschemas) - Get agent schemas
* [createRun](#createrun) - Create agent run

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
                .agentId("<id>")
                .call();

        if (res.platformAgentGetResponse().isPresent()) {
            System.out.println(res.platformAgentGetResponse().get());
        }
    }
}
```

### Parameters

| Parameter                    | Type                         | Required                     | Description                  |
| ---------------------------- | ---------------------------- | ---------------------------- | ---------------------------- |
| `agentId`                    | *String*                     | :heavy_check_mark:           | ID of the agent to retrieve. |

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
                .agentId("<id>")
                .includeTools(false)
                .call();

        if (res.platformAgentSchemasResponse().isPresent()) {
            System.out.println(res.platformAgentSchemasResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                          | Type                                               | Required                                           | Description                                        |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| `agentId`                                          | *String*                                           | :heavy_check_mark:                                 | ID of the agent whose schemas should be retrieved. |
| `includeTools`                                     | *Optional\<Boolean>*                               | :heavy_minus_sign:                                 | Whether to include tool metadata in the response.  |

### Response

**[PlatformAgentsGetSchemasResponse](../../models/operations/PlatformAgentsGetSchemasResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## createRun

Execute an agent run. Set `stream` to true to receive server-sent events; otherwise the response contains the final agent messages.


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
                .agentId("<id>")
                .platformAgentRunCreateRequest(PlatformAgentRunCreateRequest.builder()
                    .messages(List.of(
                        PlatformMessage.builder()
                            .role(PlatformMessageRole.USER)
                            .content(List.of(
                                PlatformMessageTextBlock.builder()
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
| `agentId`                                                                                                               | *String*                                                                                                                | :heavy_check_mark:                                                                                                      | ID of the agent to run.                                                                                                 |                                                                                                                         |
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