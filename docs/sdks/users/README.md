# Users

## Overview

### Available Operations

* [list](#list) - List users

## list

List the users in the Glean directory, ordered by display_name and then by user_id. The list includes the same people as the Glean People directory. Filter by name, email, manager_id, or department_id to find specific users. Use the returned user_id values with other Platform APIs, for example as usage limit targets.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-users-list" method="get" path="/api/users" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformUsersListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformUsersListResponse res = sdk.users().list()
                .pageSize(50L)
                .call();

        if (res.platformListUsersResponse().isPresent()) {
            System.out.println(res.platformListUsersResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                                    | Type                                                                                                                                                                                                                                                                                                                                                                                         | Required                                                                                                                                                                                                                                                                                                                                                                                     | Description                                                                                                                                                                                                                                                                                                                                                                                  |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `pageSize`                                                                                                                                                                                                                                                                                                                                                                                   | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                            | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                           | Maximum number of users to return. Defaults to 50. Maximum is 100.                                                                                                                                                                                                                                                                                                                           |
| `cursor`                                                                                                                                                                                                                                                                                                                                                                                     | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                          | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                           | Opaque pagination cursor from a previous response. Send the same filters that the previous request used.<br/>                                                                                                                                                                                                                                                                                |
| `filters`                                                                                                                                                                                                                                                                                                                                                                                    | List\<[PlatformUserFilter](../../models/components/PlatformUserFilter.md)>                                                                                                                                                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                           | JSON-encoded filters that choose which users are returned. The supported fields are name, email, manager_id, and department_id, each with the operator EQUALS. Multiple values OR within a filter. Multiple filters AND together. Each field may appear in only one filter. A value that matches no user, such as an unknown email or department_id, returns no users rather than an error.<br/> |
| `include`                                                                                                                                                                                                                                                                                                                                                                                    | List\<[PlatformUserInclude](../../models/components/PlatformUserInclude.md)>                                                                                                                                                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                           | Optional fields to add to each user. Each value only adds fields; it does not change which users are returned.<br/>                                                                                                                                                                                                                                                                          |

### Response

**[PlatformUsersListResponse](../../models/operations/PlatformUsersListResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |