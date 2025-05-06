# ClientShortcuts
(*client().shortcuts()*)

## Overview

### Available Operations

* [create](#create) - Create shortcut
* [delete](#delete) - Delete shortcut
* [retrieve](#retrieve) - Read shortcut
* [list](#list) - List shortcuts
* [update](#update) - Update shortcut

## create

Create a user-generated shortcut that contains an alias and destination URL.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.CreateshortcutResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateShortcutRequest req = CreateShortcutRequest.builder()
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
                .build();

        CreateshortcutResponse res = sdk.client().shortcuts().create()
                .request(req)
                .call();

        if (res.createShortcutResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [CreateShortcutRequest](../../models/shared/CreateShortcutRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

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

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DeleteShortcutRequest;
import com.glean.api_client.glean_api_client.models.operations.DeleteshortcutResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteShortcutRequest req = DeleteShortcutRequest.builder()
                .id(545907L)
                .build();

        DeleteshortcutResponse res = sdk.client().shortcuts().delete()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [DeleteShortcutRequest](../../models/shared/DeleteShortcutRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[DeleteshortcutResponse](../../models/operations/DeleteshortcutResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieve

Read a particular shortcut's details given its ID.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.GetShortcutRequest;
import com.glean.api_client.glean_api_client.models.components.GetShortcutRequestUnion;
import com.glean.api_client.glean_api_client.models.operations.GetshortcutResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetShortcutRequestUnion req = GetShortcutRequestUnion.of(GetShortcutRequest.builder()
                .alias("<value>")
                .build());

        GetshortcutResponse res = sdk.client().shortcuts().retrieve()
                .request(req)
                .call();

        if (res.getShortcutResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [GetShortcutRequestUnion](../../models/shared/GetShortcutRequestUnion.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

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

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.ListshortcutsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ListShortcutsPaginatedRequest req = ListShortcutsPaginatedRequest.builder()
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
                .build();

        ListshortcutsResponse res = sdk.client().shortcuts().list()
                .request(req)
                .call();

        if (res.listShortcutsPaginatedResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `request`                                                                             | [ListShortcutsPaginatedRequest](../../models/shared/ListShortcutsPaginatedRequest.md) | :heavy_check_mark:                                                                    | The request object to use for the request.                                            |

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

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.UpdateshortcutResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UpdateShortcutRequest req = UpdateShortcutRequest.builder()
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
                .build();

        UpdateshortcutResponse res = sdk.client().shortcuts().update()
                .request(req)
                .call();

        if (res.updateShortcutResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [UpdateShortcutRequest](../../models/shared/UpdateShortcutRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[UpdateshortcutResponse](../../models/operations/UpdateshortcutResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |