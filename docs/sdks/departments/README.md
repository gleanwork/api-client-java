# Departments

## Overview

### Available Operations

* [list](#list) - List departments
* [get](#get) - Get a department

## list

List the departments in the Glean directory, ordered by display_name and then by department_id. The list includes every department that at least one user belongs to or that a usage limit names, so a caller can show the name of a department that a usage limit still names after its users leave it. Department names are exact, so names that differ only by case are different departments.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-departments-list" method="get" path="/api/departments" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformDepartmentsListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformDepartmentsListResponse res = sdk.departments().list()
                .pageSize(50L)
                .call();

        if (res.platformListDepartmentsResponse().isPresent()) {
            System.out.println(res.platformListDepartmentsResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                | Type                                                                     | Required                                                                 | Description                                                              |
| ------------------------------------------------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ |
| `pageSize`                                                               | *Optional\<Long>*                                                        | :heavy_minus_sign:                                                       | Maximum number of departments to return. Defaults to 50. Maximum is 100. |
| `cursor`                                                                 | *Optional\<String>*                                                      | :heavy_minus_sign:                                                       | Opaque pagination cursor from a previous response.                       |

### Response

**[PlatformDepartmentsListResponse](../../models/operations/PlatformDepartmentsListResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## get

Get one department by its department_id. The department can be any department that the list returns, including one that only a usage limit names. A department_id that is not valid, or that no user and no usage limit uses, returns 404 resource_not_found. A department_id comes from the exact department name, so a renamed department gets a new ID, and a name that is used again gets its old ID back.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-departments-get" method="get" path="/api/departments/{department_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformDepartmentsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformDepartmentsGetResponse res = sdk.departments().get()
                .departmentId("{department_id}")
                .call();

        if (res.platformGetDepartmentResponse().isPresent()) {
            System.out.println(res.platformGetDepartmentResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                    | Type                                                                                                                         | Required                                                                                                                     | Description                                                                                                                  | Example                                                                                                                      |
| ---------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------- |
| `departmentId`                                                                                                               | *String*                                                                                                                     | :heavy_check_mark:                                                                                                           | The department_id from a list departments response or from a user's department. IDs are opaque. Do not parse or build them.<br/> | {department_id}                                                                                                              |

### Response

**[PlatformDepartmentsGetResponse](../../models/operations/PlatformDepartmentsGetResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |