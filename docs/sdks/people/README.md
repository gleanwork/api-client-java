# People
(*indexing().people()*)

## Overview

### Available Operations

* [index](#index) - Index employee
* [bulkIndexEmployees](#bulkindexemployees) - Bulk index employees
* [~~bulkIndex~~](#bulkindex) - Bulk index employees :warning: **Deprecated**
* [processAllEmployeesAndTeams](#processallemployeesandteams) - Schedules the processing of uploaded employees and teams
* [delete](#delete) - Delete employee
* [indexTeam](#indexteam) - Index team
* [deleteTeam](#deleteteam) - Delete team
* [bulkIndexTeams](#bulkindexteams) - Bulk index teams

## index

Adds an employee or updates information about an employee

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.PostApiIndexV1IndexemployeeResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        IndexEmployeeRequest req = IndexEmployeeRequest.builder()
                .employee(EmployeeInfoDefinition.builder()
                    .email("Santos.Turcotte@yahoo.com")
                    .department("<value>")
                    .datasourceProfiles(List.of(
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

## bulkIndexEmployees

Replaces all the currently indexed employees using paginated batch API calls. Please refer to the [bulk indexing](https://developers.glean.com/docs/indexing_api_bulk_indexing/#bulk-upload-model) documentation for an explanation of how to use bulk endpoints.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.BulkIndexEmployeesRequest;
import com.glean.api_client.models.operations.PostApiIndexV1BulkindexemployeesResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        BulkIndexEmployeesRequest req = BulkIndexEmployeesRequest.builder()
                .uploadId("<id>")
                .employees(List.of())
                .build();

        PostApiIndexV1BulkindexemployeesResponse res = sdk.indexing().people().bulkIndexEmployees()
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

## ~~bulkIndex~~

Bulk upload details of all the employees. This deletes all employees uploaded in the prior batch. SOON TO BE DEPRECATED in favor of /bulkindexemployees.

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.PostApiIndexV1IndexemployeelistResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        IndexEmployeeListRequest req = IndexEmployeeListRequest.builder()
                .employees(List.of(
                    IndexEmployeeRequest.builder()
                        .employee(EmployeeInfoDefinition.builder()
                            .email("Kiera_Bashirian18@yahoo.com")
                            .department("<value>")
                            .datasourceProfiles(List.of(
                                DatasourceProfile.builder()
                                    .datasource("github")
                                    .handle("<value>")
                                    .build(),
                                DatasourceProfile.builder()
                                    .datasource("github")
                                    .handle("<value>")
                                    .build()))
                            .build())
                        .build(),
                    IndexEmployeeRequest.builder()
                        .employee(EmployeeInfoDefinition.builder()
                            .email("Madie_Hayes48@gmail.com")
                            .department("<value>")
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
                        .build()))
                .build();

        PostApiIndexV1IndexemployeelistResponse res = sdk.indexing().people().bulkIndex()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [IndexEmployeeListRequest](../../models/shared/IndexEmployeeListRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[PostApiIndexV1IndexemployeelistResponse](../../models/operations/PostApiIndexV1IndexemployeelistResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## processAllEmployeesAndTeams

Schedules the immediate processing of employees and teams uploaded through the indexing API. By default all uploaded people data will be processed asynchronously but this API can be used to schedule its processing on demand.


### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.operations.PostApiIndexV1ProcessallemployeesandteamsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
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

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteEmployeeRequest;
import com.glean.api_client.models.operations.PostApiIndexV1DeleteemployeeResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
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

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.PostApiIndexV1IndexteamResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        IndexTeamRequest req = IndexTeamRequest.builder()
                .team(TeamInfoDefinition.builder()
                    .id("<id>")
                    .name("<value>")
                    .members(List.of(
                        TeamMember.builder()
                            .email("Rachelle20@yahoo.com")
                            .build(),
                        TeamMember.builder()
                            .email("Rebeka.Gerhold@hotmail.com")
                            .build(),
                        TeamMember.builder()
                            .email("Jace86@yahoo.com")
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

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteTeamRequest;
import com.glean.api_client.models.operations.PostApiIndexV1DeleteteamResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
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

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.BulkIndexTeamsRequest;
import com.glean.api_client.models.operations.PostApiIndexV1BulkindexteamsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        BulkIndexTeamsRequest req = BulkIndexTeamsRequest.builder()
                .uploadId("<id>")
                .teams(List.of())
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