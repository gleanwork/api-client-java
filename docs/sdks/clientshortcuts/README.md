# ClientShortcuts
(*client().shortcuts()*)

## Overview

### Available Operations

* [create](#create) - Create shortcut
* [delete](#delete) - Delete shortcut
* [get](#get) - Read shortcut
* [list](#list) - List shortcuts
* [update](#update) - Update shortcut
* [upload](#upload) - Upload shortcuts

## create

Create a user-generated shortcut that contains an alias and destination URL.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.CreateshortcutResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateshortcutResponse res = sdk.client().shortcuts().create()
                .createShortcutRequest(CreateShortcutRequest.builder()
                    .data(ShortcutMutableProperties.builder()
                        .addedRoles(List.of(
                            UserRoleSpecification.builder()
                                .role(UserRole.OWNER)
                                .person(Person.builder()
                                    .name("George Clooney")
                                    .obfuscatedId("abc123")
                                    .relatedDocuments(List.of())
                                    .metadata(PersonMetadata.builder()
                                        .type(PersonMetadataType.FULL_TIME)
                                        .title("Actor")
                                        .department("Movies")
                                        .email("george@example.com")
                                        .location("Hollywood, CA")
                                        .phone("6505551234")
                                        .photoUrl("https://example.com/george.jpg")
                                        .startDate(LocalDate.parse("2000-01-23"))
                                        .datasourceProfile(List.of(
                                            DatasourceProfile.builder()
                                                .datasource("github")
                                                .handle("<value>")
                                                .build()))
                                        .querySuggestions(QuerySuggestionList.builder()
                                            .suggestions(List.of())
                                            .build())
                                        .inviteInfo(InviteInfo.builder()
                                            .invites(List.of())
                                            .build())
                                        .customFields(List.of())
                                        .badges(List.of(
                                            Badge.builder()
                                                .key("deployment_name_new_hire")
                                                .displayName("New hire")
                                                .iconConfig(IconConfig.builder()
                                                    .color("#343CED")
                                                    .key("person_icon")
                                                    .iconType(IconType.GLYPH)
                                                    .name("user")
                                                    .build())
                                                .build()))
                                        .build())
                                    .build())
                                .build(),
                            UserRoleSpecification.builder()
                                .role(UserRole.VERIFIER)
                                .build()))
                        .removedRoles(List.of(
                            UserRoleSpecification.builder()
                                .role(UserRole.VERIFIER)
                                .build(),
                            UserRoleSpecification.builder()
                                .role(UserRole.ANSWER_MODERATOR)
                                .build(),
                            UserRoleSpecification.builder()
                                .role(UserRole.OWNER)
                                .build()))
                        .build())
                    .build())
                .call();

        if (res.createShortcutResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xGleanActAs`                                                                                                            | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `createShortcutRequest`                                                                                                  | [CreateShortcutRequest](../../models/components/CreateShortcutRequest.md)                                                | :heavy_check_mark:                                                                                                       | CreateShortcut request                                                                                                   |

### Response

**[CreateshortcutResponse](../../models/operations/CreateshortcutResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## delete

Delete an existing user-generated shortcut.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteShortcutRequest;
import com.glean.api_client.models.operations.DeleteshortcutResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteshortcutResponse res = sdk.client().shortcuts().delete()
                .deleteShortcutRequest(DeleteShortcutRequest.builder()
                    .id(545907L)
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xGleanActAs`                                                                                                            | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `deleteShortcutRequest`                                                                                                  | [DeleteShortcutRequest](../../models/components/DeleteShortcutRequest.md)                                                | :heavy_check_mark:                                                                                                       | DeleteShortcut request                                                                                                   |

### Response

**[DeleteshortcutResponse](../../models/operations/DeleteshortcutResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## get

Read a particular shortcut's details given its ID.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetShortcutRequest;
import com.glean.api_client.models.components.GetShortcutRequestUnion;
import com.glean.api_client.models.operations.GetshortcutResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetshortcutResponse res = sdk.client().shortcuts().get()
                .getShortcutRequest(GetShortcutRequestUnion.of(GetShortcutRequest.builder()
                    .alias("<value>")
                    .build()))
                .call();

        if (res.getShortcutResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xGleanActAs`                                                                                                            | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `getShortcutRequest`                                                                                                     | [GetShortcutRequestUnion](../../models/components/GetShortcutRequestUnion.md)                                            | :heavy_check_mark:                                                                                                       | GetShortcut request                                                                                                      |

### Response

**[GetshortcutResponse](../../models/operations/GetshortcutResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

List shortcuts editable/owned by the currently authenticated user.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.ListshortcutsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ListshortcutsResponse res = sdk.client().shortcuts().list()
                .listShortcutsPaginatedRequest(ListShortcutsPaginatedRequest.builder()
                    .pageSize(10L)
                    .filters(List.of(
                        FacetFilter.builder()
                            .fieldName("type")
                            .values(List.of(
                                FacetFilterValue.builder()
                                    .value("Spreadsheet")
                                    .relationType(RelationType.EQUALS)
                                    .build(),
                                FacetFilterValue.builder()
                                    .value("Presentation")
                                    .relationType(RelationType.EQUALS)
                                    .build()))
                            .build()))
                    .build())
                .call();

        if (res.listShortcutsPaginatedResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xGleanActAs`                                                                                                            | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `listShortcutsPaginatedRequest`                                                                                          | [ListShortcutsPaginatedRequest](../../models/components/ListShortcutsPaginatedRequest.md)                                | :heavy_check_mark:                                                                                                       | Filters, sorters, paging params required for pagination                                                                  |

### Response

**[ListshortcutsResponse](../../models/operations/ListshortcutsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## update

Updates the shortcut with the given ID.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.UpdateshortcutResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UpdateshortcutResponse res = sdk.client().shortcuts().update()
                .updateShortcutRequest(UpdateShortcutRequest.builder()
                    .id(857478L)
                    .addedRoles(List.of(
                        UserRoleSpecification.builder()
                            .role(UserRole.EDITOR)
                            .person(Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .relatedDocuments(List.of())
                                .metadata(PersonMetadata.builder()
                                    .type(PersonMetadataType.FULL_TIME)
                                    .title("Actor")
                                    .department("Movies")
                                    .email("george@example.com")
                                    .location("Hollywood, CA")
                                    .phone("6505551234")
                                    .photoUrl("https://example.com/george.jpg")
                                    .startDate(LocalDate.parse("2000-01-23"))
                                    .datasourceProfile(List.of(
                                        DatasourceProfile.builder()
                                            .datasource("github")
                                            .handle("<value>")
                                            .build()))
                                    .querySuggestions(QuerySuggestionList.builder()
                                        .suggestions(List.of())
                                        .build())
                                    .inviteInfo(InviteInfo.builder()
                                        .invites(List.of())
                                        .build())
                                    .customFields(List.of())
                                    .badges(List.of(
                                        Badge.builder()
                                            .key("deployment_name_new_hire")
                                            .displayName("New hire")
                                            .iconConfig(IconConfig.builder()
                                                .color("#343CED")
                                                .key("person_icon")
                                                .iconType(IconType.GLYPH)
                                                .name("user")
                                                .build())
                                            .build()))
                                    .build())
                                .build())
                            .build(),
                        UserRoleSpecification.builder()
                            .role(UserRole.ANSWER_MODERATOR)
                            .build()))
                    .removedRoles(List.of(
                        UserRoleSpecification.builder()
                            .role(UserRole.EDITOR)
                            .build(),
                        UserRoleSpecification.builder()
                            .role(UserRole.ANSWER_MODERATOR)
                            .build()))
                    .build())
                .call();

        if (res.updateShortcutResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xGleanActAs`                                                                                                            | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `updateShortcutRequest`                                                                                                  | [UpdateShortcutRequest](../../models/components/UpdateShortcutRequest.md)                                                | :heavy_check_mark:                                                                                                       | Shortcut content. Id need to be specified for the shortcut.                                                              |

### Response

**[UpdateshortcutResponse](../../models/operations/UpdateshortcutResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## upload

Creates glean shortcuts for uploaded shortcuts info. Glean would host the shortcuts, and they can be managed in the knowledge tab once uploaded.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.Shortcut;
import com.glean.api_client.models.components.UploadShortcutsRequest;
import com.glean.api_client.models.operations.PostApiIndexV1UploadshortcutsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UploadShortcutsRequest req = UploadShortcutsRequest.builder()
                .uploadId("<id>")
                .shortcuts(List.of(
                    Shortcut.builder()
                        .inputAlias("<value>")
                        .destinationUrl("https://needy-harp.name")
                        .createdBy("<value>")
                        .build()))
                .build();

        PostApiIndexV1UploadshortcutsResponse res = sdk.client().shortcuts().upload()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [UploadShortcutsRequest](../../models/shared/UploadShortcutsRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[PostApiIndexV1UploadshortcutsResponse](../../models/operations/PostApiIndexV1UploadshortcutsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |