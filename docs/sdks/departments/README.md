# Departments

## Overview

### Available Operations

* [list](#list) - List departments

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