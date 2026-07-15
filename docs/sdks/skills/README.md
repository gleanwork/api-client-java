# Skills

## Overview

### Available Operations

* [list](#list) - List skills
* [retrieve](#retrieve) - Retrieve skill

## list

List skills available to the authenticated user.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-list" method="get" path="/api/skills" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillsListResponse res = sdk.skills().list()
                .call();

        if (res.platformSkillsListResponse().isPresent()) {
            System.out.println(res.platformSkillsListResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                          | Type                                               | Required                                           | Description                                        |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| `pageSize`                                         | *Optional\<Long>*                                  | :heavy_minus_sign:                                 | Maximum number of skills to return.                |
| `cursor`                                           | *Optional\<String>*                                | :heavy_minus_sign:                                 | Opaque pagination cursor from a previous response. |

### Response

**[PlatformSkillsListResponse](../../models/operations/PlatformSkillsListResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## retrieve

Retrieve metadata for a skill available to the authenticated user.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-get" method="get" path="/api/skills/{skill_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillsGetResponse res = sdk.skills().retrieve()
                .skillId("<id>")
                .call();

        if (res.platformSkillGetResponse().isPresent()) {
            System.out.println(res.platformSkillGetResponse().get());
        }
    }
}
```

### Parameters

| Parameter          | Type               | Required           | Description        |
| ------------------ | ------------------ | ------------------ | ------------------ |
| `skillId`          | *String*           | :heavy_check_mark: | Glean skill ID.    |

### Response

**[PlatformSkillsGetResponse](../../models/operations/PlatformSkillsGetResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |