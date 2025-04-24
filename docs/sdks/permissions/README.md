# Permissions
(*indexing().permissions()*)

## Overview

### Available Operations

* [updatePermissions](#updatepermissions) - Update document permissions
* [indexUser](#indexuser) - Index user
* [bulkIndexUsers](#bulkindexusers) - Bulk index users
* [indexGroup](#indexgroup) - Index group
* [bulkIndexGroups](#bulkindexgroups) - Bulk index groups
* [indexMembership](#indexmembership) - Index membership
* [bulkIndexMemberships](#bulkindexmemberships) - Bulk index memberships for a group
* [processMemberships](#processmemberships) - Schedules the processing of group memberships
* [deleteUser](#deleteuser) - Delete user
* [deleteGroup](#deletegroup) - Delete group
* [deleteMembership](#deletemembership) - Delete membership
* [authorizeBetaUsers](#authorizebetausers) - Beta users

## updatePermissions

Updates the permissions for a given document without modifying document content. **This endpoint is not yet generally available. Please contact Glean support to enable this feature.**

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DocumentPermissionsDefinition;
import com.glean.api_client.models.components.UpdatePermissionsRequest;
import com.glean.api_client.models.operations.PostApiIndexV1UpdatepermissionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UpdatePermissionsRequest req = UpdatePermissionsRequest.builder()
                .datasource("<value>")
                .permissions(DocumentPermissionsDefinition.builder()
                    .build())
                .build();

        PostApiIndexV1UpdatepermissionsResponse res = sdk.indexing().permissions().updatePermissions()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [UpdatePermissionsRequest](../../models/shared/UpdatePermissionsRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[PostApiIndexV1UpdatepermissionsResponse](../../models/operations/PostApiIndexV1UpdatepermissionsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## indexUser

Adds a datasource user or updates an existing user.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DatasourceUserDefinition;
import com.glean.api_client.models.components.IndexUserRequest;
import com.glean.api_client.models.operations.PostApiIndexV1IndexuserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        IndexUserRequest req = IndexUserRequest.builder()
                .datasource("<value>")
                .user(DatasourceUserDefinition.builder()
                    .email("Elroy38@gmail.com")
                    .name("<value>")
                    .build())
                .build();

        PostApiIndexV1IndexuserResponse res = sdk.indexing().permissions().indexUser()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                   | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `request`                                                   | [IndexUserRequest](../../models/shared/IndexUserRequest.md) | :heavy_check_mark:                                          | The request object to use for the request.                  |

### Response

**[PostApiIndexV1IndexuserResponse](../../models/operations/PostApiIndexV1IndexuserResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## bulkIndexUsers

Replaces the users in a datasource using paginated batch API calls. Please refer to the [bulk indexing](https://developers.glean.com/docs/indexing_api_bulk_indexing/#bulk-upload-model) documentation for an explanation of how to use bulk endpoints.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.BulkIndexUsersRequest;
import com.glean.api_client.models.components.DatasourceUserDefinition;
import com.glean.api_client.models.operations.PostApiIndexV1BulkindexusersResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        BulkIndexUsersRequest req = BulkIndexUsersRequest.builder()
                .uploadId("<id>")
                .datasource("<value>")
                .users(List.of(
                    DatasourceUserDefinition.builder()
                        .email("Nola85@hotmail.com")
                        .name("<value>")
                        .build(),
                    DatasourceUserDefinition.builder()
                        .email("Francisca44@hotmail.com")
                        .name("<value>")
                        .build(),
                    DatasourceUserDefinition.builder()
                        .email("Georgiana_Fadel-Boyle@yahoo.com")
                        .name("<value>")
                        .build()))
                .build();

        PostApiIndexV1BulkindexusersResponse res = sdk.indexing().permissions().bulkIndexUsers()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [BulkIndexUsersRequest](../../models/shared/BulkIndexUsersRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[PostApiIndexV1BulkindexusersResponse](../../models/operations/PostApiIndexV1BulkindexusersResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## indexGroup

Add or update a group in the datasource.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DatasourceGroupDefinition;
import com.glean.api_client.models.components.IndexGroupRequest;
import com.glean.api_client.models.operations.PostApiIndexV1IndexgroupResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        IndexGroupRequest req = IndexGroupRequest.builder()
                .datasource("<value>")
                .group(DatasourceGroupDefinition.builder()
                    .name("<value>")
                    .build())
                .build();

        PostApiIndexV1IndexgroupResponse res = sdk.indexing().permissions().indexGroup()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `request`                                                     | [IndexGroupRequest](../../models/shared/IndexGroupRequest.md) | :heavy_check_mark:                                            | The request object to use for the request.                    |

### Response

**[PostApiIndexV1IndexgroupResponse](../../models/operations/PostApiIndexV1IndexgroupResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## bulkIndexGroups

Replaces the groups in a datasource using paginated batch API calls. Please refer to the [bulk indexing](https://developers.glean.com/docs/indexing_api_bulk_indexing/#bulk-upload-model) documentation for an explanation of how to use bulk endpoints.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.BulkIndexGroupsRequest;
import com.glean.api_client.models.components.DatasourceGroupDefinition;
import com.glean.api_client.models.operations.PostApiIndexV1BulkindexgroupsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        BulkIndexGroupsRequest req = BulkIndexGroupsRequest.builder()
                .uploadId("<id>")
                .datasource("<value>")
                .groups(List.of(
                    DatasourceGroupDefinition.builder()
                        .name("<value>")
                        .build(),
                    DatasourceGroupDefinition.builder()
                        .name("<value>")
                        .build()))
                .build();

        PostApiIndexV1BulkindexgroupsResponse res = sdk.indexing().permissions().bulkIndexGroups()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [BulkIndexGroupsRequest](../../models/shared/BulkIndexGroupsRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[PostApiIndexV1BulkindexgroupsResponse](../../models/operations/PostApiIndexV1BulkindexgroupsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## indexMembership

Add the memberships of a group in the datasource.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DatasourceMembershipDefinition;
import com.glean.api_client.models.components.IndexMembershipRequest;
import com.glean.api_client.models.operations.PostApiIndexV1IndexmembershipResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        IndexMembershipRequest req = IndexMembershipRequest.builder()
                .datasource("<value>")
                .membership(DatasourceMembershipDefinition.builder()
                    .groupName("<value>")
                    .build())
                .build();

        PostApiIndexV1IndexmembershipResponse res = sdk.indexing().permissions().indexMembership()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [IndexMembershipRequest](../../models/shared/IndexMembershipRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[PostApiIndexV1IndexmembershipResponse](../../models/operations/PostApiIndexV1IndexmembershipResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## bulkIndexMemberships

Replaces the memberships for a group in a datasource using paginated batch API calls. Please refer to the [bulk indexing](https://developers.glean.com/docs/indexing_api_bulk_indexing/#bulk-upload-model) documentation for an explanation of how to use bulk endpoints.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.BulkIndexMembershipsRequest;
import com.glean.api_client.models.components.DatasourceBulkMembershipDefinition;
import com.glean.api_client.models.operations.PostApiIndexV1BulkindexmembershipsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        BulkIndexMembershipsRequest req = BulkIndexMembershipsRequest.builder()
                .uploadId("<id>")
                .datasource("<value>")
                .memberships(List.of(
                    DatasourceBulkMembershipDefinition.builder()
                        .build(),
                    DatasourceBulkMembershipDefinition.builder()
                        .build(),
                    DatasourceBulkMembershipDefinition.builder()
                        .build()))
                .build();

        PostApiIndexV1BulkindexmembershipsResponse res = sdk.indexing().permissions().bulkIndexMemberships()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [BulkIndexMembershipsRequest](../../models/shared/BulkIndexMembershipsRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[PostApiIndexV1BulkindexmembershipsResponse](../../models/operations/PostApiIndexV1BulkindexmembershipsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## processMemberships

Schedules the immediate processing of all group memberships uploaded through the indexing API. By default the uploaded group memberships will be processed asynchronously but this API can be used to schedule processing of all memberships on demand.


### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.ProcessAllMembershipsRequest;
import com.glean.api_client.models.operations.PostApiIndexV1ProcessallmembershipsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ProcessAllMembershipsRequest req = ProcessAllMembershipsRequest.builder()
                .build();

        PostApiIndexV1ProcessallmembershipsResponse res = sdk.indexing().permissions().processMemberships()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                           | Type                                                                                | Required                                                                            | Description                                                                         |
| ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `request`                                                                           | [ProcessAllMembershipsRequest](../../models/shared/ProcessAllMembershipsRequest.md) | :heavy_check_mark:                                                                  | The request object to use for the request.                                          |

### Response

**[PostApiIndexV1ProcessallmembershipsResponse](../../models/operations/PostApiIndexV1ProcessallmembershipsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## deleteUser

Delete the user from the datasource. Silently succeeds if user is not present.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteUserRequest;
import com.glean.api_client.models.operations.PostApiIndexV1DeleteuserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteUserRequest req = DeleteUserRequest.builder()
                .datasource("<value>")
                .email("Estrella.Robel56@gmail.com")
                .build();

        PostApiIndexV1DeleteuserResponse res = sdk.indexing().permissions().deleteUser()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `request`                                                     | [DeleteUserRequest](../../models/shared/DeleteUserRequest.md) | :heavy_check_mark:                                            | The request object to use for the request.                    |

### Response

**[PostApiIndexV1DeleteuserResponse](../../models/operations/PostApiIndexV1DeleteuserResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## deleteGroup

Delete group from the datasource. Silently succeeds if group is not present.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteGroupRequest;
import com.glean.api_client.models.operations.PostApiIndexV1DeletegroupResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteGroupRequest req = DeleteGroupRequest.builder()
                .datasource("<value>")
                .groupName("<value>")
                .build();

        PostApiIndexV1DeletegroupResponse res = sdk.indexing().permissions().deleteGroup()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                       | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `request`                                                       | [DeleteGroupRequest](../../models/shared/DeleteGroupRequest.md) | :heavy_check_mark:                                              | The request object to use for the request.                      |

### Response

**[PostApiIndexV1DeletegroupResponse](../../models/operations/PostApiIndexV1DeletegroupResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## deleteMembership

Delete membership to a group in the specified datasource. Silently succeeds if membership is not present.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DatasourceMembershipDefinition;
import com.glean.api_client.models.components.DeleteMembershipRequest;
import com.glean.api_client.models.operations.PostApiIndexV1DeletemembershipResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteMembershipRequest req = DeleteMembershipRequest.builder()
                .datasource("<value>")
                .membership(DatasourceMembershipDefinition.builder()
                    .groupName("<value>")
                    .build())
                .build();

        PostApiIndexV1DeletemembershipResponse res = sdk.indexing().permissions().deleteMembership()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [DeleteMembershipRequest](../../models/shared/DeleteMembershipRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[PostApiIndexV1DeletemembershipResponse](../../models/operations/PostApiIndexV1DeletemembershipResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## authorizeBetaUsers

Allow the datasource be visible to the specified beta users. The default behaviour is datasource being visible to all users if it is enabled and not visible to any user if it is not enabled.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GreenlistUsersRequest;
import com.glean.api_client.models.operations.PostApiIndexV1BetausersResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GreenlistUsersRequest req = GreenlistUsersRequest.builder()
                .datasource("<value>")
                .emails(List.of(
                    "Margaret94@gmail.com",
                    "Jerel_Wilkinson39@yahoo.com"))
                .build();

        PostApiIndexV1BetausersResponse res = sdk.indexing().permissions().authorizeBetaUsers()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [GreenlistUsersRequest](../../models/shared/GreenlistUsersRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[PostApiIndexV1BetausersResponse](../../models/operations/PostApiIndexV1BetausersResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |