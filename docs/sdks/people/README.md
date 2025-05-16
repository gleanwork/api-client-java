# People
(*indexing().people()*)

## Overview

### Available Operations

* [debug](#debug) - Beta: Get user information

* [~~count~~](#count) - Get user count :warning: **Deprecated**
* [index](#index) - Index employee
* [bulkIndex](#bulkindex) - Bulk index employees
* [processAllEmployeesAndTeams](#processallemployeesandteams) - Schedules the processing of uploaded employees and teams
* [delete](#delete) - Delete employee
* [indexTeam](#indexteam) - Index team
* [deleteTeam](#deleteteam) - Delete team
* [bulkIndexTeams](#bulkindexteams) - Bulk index teams

## debug

Gives various information that would help in debugging related to a particular user. Currently in beta, might undergo breaking changes without prior notice.

Tip: Refer to the [Troubleshooting tutorial](https://developers.glean.com/docs/indexing_api/indexing_api_troubleshooting/) for more information.


### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DebugUserRequest;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1DebugDatasourceUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        PostApiIndexV1DebugDatasourceUserResponse res = sdk.indexing().people().debug()
                .datasource("<value>")
                .debugUserRequest(DebugUserRequest.builder()
                    .email("u1@foo.com")
                    .build())
                .call();

        if (res.debugUserResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                       | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `datasource`                                                    | *String*                                                        | :heavy_check_mark:                                              | The datasource to which the user belongs                        |
| `debugUserRequest`                                              | [DebugUserRequest](../../models/components/DebugUserRequest.md) | :heavy_check_mark:                                              | N/A                                                             |

### Response

**[PostApiIndexV1DebugDatasourceUserResponse](../../models/operations/PostApiIndexV1DebugDatasourceUserResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## ~~count~~

Fetches user count for the specified custom datasource.

Tip: Use [/debug/{datasource}/status](https://developers.glean.com/docs/indexing_api/indexing_api_troubleshooting/#debug-datasource-status) for richer information.


> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.GetUserCountRequest;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1GetusercountResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        GetUserCountRequest req = GetUserCountRequest.builder()
                .datasource("<value>")
                .build();

        PostApiIndexV1GetusercountResponse res = sdk.indexing().people().count()
                .request(req)
                .call();

        if (res.getUserCountResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [GetUserCountRequest](../../models/shared/GetUserCountRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[PostApiIndexV1GetusercountResponse](../../models/operations/PostApiIndexV1GetusercountResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## index

Adds an employee or updates information about an employee

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1IndexemployeeResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        IndexEmployeeRequest req = IndexEmployeeRequest.builder()
                .employee(EmployeeInfoDefinition.builder()
                    .email("Jerrold_Hermann@hotmail.com")
                    .department("<value>")
                    .datasourceProfiles(List.of(
                        DatasourceProfile.builder()
                            .datasource("github")
                            .handle("<value>")
                            .build()))
                    .build())
                .build();

        PostApiIndexV1IndexemployeeResponse res = sdk.indexing().people().index()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `request`                                                           | [IndexEmployeeRequest](../../models/shared/IndexEmployeeRequest.md) | :heavy_check_mark:                                                  | The request object to use for the request.                          |

### Response

**[PostApiIndexV1IndexemployeeResponse](../../models/operations/PostApiIndexV1IndexemployeeResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## bulkIndex

Replaces all the currently indexed employees using paginated batch API calls. Please refer to the [bulk indexing](https://developers.glean.com/docs/indexing_api_bulk_indexing/#bulk-upload-model) documentation for an explanation of how to use bulk endpoints.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1BulkindexemployeesResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        BulkIndexEmployeesRequest req = BulkIndexEmployeesRequest.builder()
                .uploadId("<id>")
                .employees(List.of(
                    EmployeeInfoDefinition.builder()
                        .email("Robin.Stoltenberg@yahoo.com")
                        .department("<value>")
                        .datasourceProfiles(List.of(
                            DatasourceProfile.builder()
                                .datasource("github")
                                .handle("<value>")
                                .build()))
                        .build(),
                    EmployeeInfoDefinition.builder()
                        .email("Robin.Stoltenberg@yahoo.com")
                        .department("<value>")
                        .datasourceProfiles(List.of(
                            DatasourceProfile.builder()
                                .datasource("github")
                                .handle("<value>")
                                .build()))
                        .build(),
                    EmployeeInfoDefinition.builder()
                        .email("Robin.Stoltenberg@yahoo.com")
                        .department("<value>")
                        .datasourceProfiles(List.of(
                            DatasourceProfile.builder()
                                .datasource("github")
                                .handle("<value>")
                                .build()))
                        .build()))
                .build();

        PostApiIndexV1BulkindexemployeesResponse res = sdk.indexing().people().bulkIndex()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `request`                                                                     | [BulkIndexEmployeesRequest](../../models/shared/BulkIndexEmployeesRequest.md) | :heavy_check_mark:                                                            | The request object to use for the request.                                    |

### Response

**[PostApiIndexV1BulkindexemployeesResponse](../../models/operations/PostApiIndexV1BulkindexemployeesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## processAllEmployeesAndTeams

Schedules the immediate processing of employees and teams uploaded through the indexing API. By default all uploaded people data will be processed asynchronously but this API can be used to schedule its processing on demand.


### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1ProcessallemployeesandteamsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        PostApiIndexV1ProcessallemployeesandteamsResponse res = sdk.indexing().people().processAllEmployeesAndTeams()
                .call();

        // handle response
    }
}
```

### Response

**[PostApiIndexV1ProcessallemployeesandteamsResponse](../../models/operations/PostApiIndexV1ProcessallemployeesandteamsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## delete

Delete an employee. Silently succeeds if employee is not present.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DeleteEmployeeRequest;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1DeleteemployeeResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        DeleteEmployeeRequest req = DeleteEmployeeRequest.builder()
                .employeeEmail("<value>")
                .build();

        PostApiIndexV1DeleteemployeeResponse res = sdk.indexing().people().delete()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [DeleteEmployeeRequest](../../models/shared/DeleteEmployeeRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[PostApiIndexV1DeleteemployeeResponse](../../models/operations/PostApiIndexV1DeleteemployeeResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## indexTeam

Adds a team or updates information about a team

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1IndexteamResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        IndexTeamRequest req = IndexTeamRequest.builder()
                .team(TeamInfoDefinition.builder()
                    .id("<id>")
                    .name("<value>")
                    .members(List.of(
                        TeamMember.builder()
                            .email("Nasir.Hilll73@hotmail.com")
                            .build()))
                    .datasourceProfiles(List.of(
                        DatasourceProfile.builder()
                            .datasource("github")
                            .handle("<value>")
                            .build(),
                        DatasourceProfile.builder()
                            .datasource("github")
                            .handle("<value>")
                            .build(),
                        DatasourceProfile.builder()
                            .datasource("github")
                            .handle("<value>")
                            .build()))
                    .build())
                .build();

        PostApiIndexV1IndexteamResponse res = sdk.indexing().people().indexTeam()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                   | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `request`                                                   | [IndexTeamRequest](../../models/shared/IndexTeamRequest.md) | :heavy_check_mark:                                          | The request object to use for the request.                  |

### Response

**[PostApiIndexV1IndexteamResponse](../../models/operations/PostApiIndexV1IndexteamResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## deleteTeam

Delete a team based on provided id.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DeleteTeamRequest;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1DeleteteamResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        DeleteTeamRequest req = DeleteTeamRequest.builder()
                .id("<id>")
                .build();

        PostApiIndexV1DeleteteamResponse res = sdk.indexing().people().deleteTeam()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `request`                                                     | [DeleteTeamRequest](../../models/shared/DeleteTeamRequest.md) | :heavy_check_mark:                                            | The request object to use for the request.                    |

### Response

**[PostApiIndexV1DeleteteamResponse](../../models/operations/PostApiIndexV1DeleteteamResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## bulkIndexTeams

Replaces all the currently indexed teams using paginated batch API calls. Please refer to the [bulk indexing](https://developers.glean.com/docs/indexing_api_bulk_indexing/#bulk-upload-model) documentation for an explanation of how to use bulk endpoints.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1BulkindexteamsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        BulkIndexTeamsRequest req = BulkIndexTeamsRequest.builder()
                .uploadId("<id>")
                .teams(List.of(
                    TeamInfoDefinition.builder()
                        .id("<id>")
                        .name("<value>")
                        .members(List.of())
                        .datasourceProfiles(List.of(
                            DatasourceProfile.builder()
                                .datasource("github")
                                .handle("<value>")
                                .build(),
                            DatasourceProfile.builder()
                                .datasource("github")
                                .handle("<value>")
                                .build()))
                        .build(),
                    TeamInfoDefinition.builder()
                        .id("<id>")
                        .name("<value>")
                        .members(List.of())
                        .datasourceProfiles(List.of(
                            DatasourceProfile.builder()
                                .datasource("github")
                                .handle("<value>")
                                .build(),
                            DatasourceProfile.builder()
                                .datasource("github")
                                .handle("<value>")
                                .build()))
                        .build(),
                    TeamInfoDefinition.builder()
                        .id("<id>")
                        .name("<value>")
                        .members(List.of())
                        .datasourceProfiles(List.of(
                            DatasourceProfile.builder()
                                .datasource("github")
                                .handle("<value>")
                                .build(),
                            DatasourceProfile.builder()
                                .datasource("github")
                                .handle("<value>")
                                .build()))
                        .build()))
                .build();

        PostApiIndexV1BulkindexteamsResponse res = sdk.indexing().people().bulkIndexTeams()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [BulkIndexTeamsRequest](../../models/shared/BulkIndexTeamsRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[PostApiIndexV1BulkindexteamsResponse](../../models/operations/PostApiIndexV1BulkindexteamsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |