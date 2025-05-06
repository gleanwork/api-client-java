# Collections
(*client().collections()*)

## Overview

### Available Operations

* [addItems](#additems) - Add Collection item
* [create](#create) - Create Collection
* [delete](#delete) - Delete Collection
* [deleteItem](#deleteitem) - Delete Collection item
* [update](#update) - Update Collection
* [updateItem](#updateitem) - Update Collection item
* [retrieve](#retrieve) - Read Collection
* [list](#list) - List Collections

## addItems

Add items to a Collection.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.AddCollectionItemsRequest;
import com.glean.api_client.models.operations.AddcollectionitemsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        AddCollectionItemsRequest req = AddCollectionItemsRequest.builder()
                .collectionId(6460.15)
                .build();

        AddcollectionitemsResponse res = sdk.client().collections().addItems()
                .request(req)
                .call();

        if (res.addCollectionItemsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `request`                                                                     | [AddCollectionItemsRequest](../../models/shared/AddCollectionItemsRequest.md) | :heavy_check_mark:                                                            | The request object to use for the request.                                    |

### Response

**[AddcollectionitemsResponse](../../models/operations/AddcollectionitemsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## create

Create a publicly visible (empty) Collection of documents.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.errors.CollectionError;
import com.glean.api_client.models.operations.CreatecollectionResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CollectionError, Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateCollectionRequest req = CreateCollectionRequest.builder()
                .name("<value>")
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
                .audienceFilters(List.of(
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

        CreatecollectionResponse res = sdk.client().collections().create()
                .request(req)
                .call();

        if (res.createCollectionResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [CreateCollectionRequest](../../models/shared/CreateCollectionRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[CreatecollectionResponse](../../models/operations/CreatecollectionResponse.md)**

### Errors

| Error Type                    | Status Code                   | Content Type                  |
| ----------------------------- | ----------------------------- | ----------------------------- |
| models/errors/CollectionError | 422                           | application/json              |
| models/errors/APIException    | 4XX, 5XX                      | \*/\*                         |

## delete

Delete a Collection given the Collection's ID.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteCollectionRequest;
import com.glean.api_client.models.errors.CollectionError;
import com.glean.api_client.models.operations.DeletecollectionResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CollectionError, Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteCollectionRequest req = DeleteCollectionRequest.builder()
                .ids(List.of(
                    698486L,
                    386564L))
                .build();

        DeletecollectionResponse res = sdk.client().collections().delete()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [DeleteCollectionRequest](../../models/shared/DeleteCollectionRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[DeletecollectionResponse](../../models/operations/DeletecollectionResponse.md)**

### Errors

| Error Type                    | Status Code                   | Content Type                  |
| ----------------------------- | ----------------------------- | ----------------------------- |
| models/errors/CollectionError | 422                           | application/json              |
| models/errors/APIException    | 4XX, 5XX                      | \*/\*                         |

## deleteItem

Delete a single item from a Collection.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteCollectionItemRequest;
import com.glean.api_client.models.operations.DeletecollectionitemResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteCollectionItemRequest req = DeleteCollectionItemRequest.builder()
                .collectionId(1357.59)
                .itemId("<id>")
                .build();

        DeletecollectionitemResponse res = sdk.client().collections().deleteItem()
                .request(req)
                .call();

        if (res.deleteCollectionItemResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [DeleteCollectionItemRequest](../../models/shared/DeleteCollectionItemRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[DeletecollectionitemResponse](../../models/operations/DeletecollectionitemResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## update

Update the properties of an existing Collection.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.errors.CollectionError;
import com.glean.api_client.models.operations.EditcollectionResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CollectionError, Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        EditCollectionRequest req = EditCollectionRequest.builder()
                .name("<value>")
                .id(720396L)
                .addedRoles(List.of(
                    UserRoleSpecification.builder()
                        .role(UserRole.ANSWER_MODERATOR)
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
                        .role(UserRole.EDITOR)
                        .build(),
                    UserRoleSpecification.builder()
                        .role(UserRole.ANSWER_MODERATOR)
                        .build()))
                .removedRoles(List.of(
                    UserRoleSpecification.builder()
                        .role(UserRole.ANSWER_MODERATOR)
                        .build()))
                .audienceFilters(List.of(
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

        EditcollectionResponse res = sdk.client().collections().update()
                .request(req)
                .call();

        if (res.editCollectionResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [EditCollectionRequest](../../models/shared/EditCollectionRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[EditcollectionResponse](../../models/operations/EditcollectionResponse.md)**

### Errors

| Error Type                    | Status Code                   | Content Type                  |
| ----------------------------- | ----------------------------- | ----------------------------- |
| models/errors/CollectionError | 422                           | application/json              |
| models/errors/APIException    | 4XX, 5XX                      | \*/\*                         |

## updateItem

Update the URL, Glean Document ID, description of an item within a Collection given its ID.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.EditCollectionItemRequest;
import com.glean.api_client.models.operations.EditcollectionitemResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        EditCollectionItemRequest req = EditCollectionItemRequest.builder()
                .collectionId(795203L)
                .itemId("<id>")
                .build();

        EditcollectionitemResponse res = sdk.client().collections().updateItem()
                .request(req)
                .call();

        if (res.editCollectionItemResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `request`                                                                     | [EditCollectionItemRequest](../../models/shared/EditCollectionItemRequest.md) | :heavy_check_mark:                                                            | The request object to use for the request.                                    |

### Response

**[EditcollectionitemResponse](../../models/operations/EditcollectionitemResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieve

Read the details of a Collection given its ID. Does not fetch items in this Collection.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetCollectionRequest;
import com.glean.api_client.models.operations.GetcollectionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetCollectionRequest req = GetCollectionRequest.builder()
                .id(700347L)
                .build();

        GetcollectionResponse res = sdk.client().collections().retrieve()
                .request(req)
                .call();

        if (res.getCollectionResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `request`                                                           | [GetCollectionRequest](../../models/shared/GetCollectionRequest.md) | :heavy_check_mark:                                                  | The request object to use for the request.                          |

### Response

**[GetcollectionResponse](../../models/operations/GetcollectionResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

List all existing Collections.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.ListCollectionsRequest;
import com.glean.api_client.models.operations.ListcollectionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ListCollectionsRequest req = ListCollectionsRequest.builder()
                .build();

        ListcollectionsResponse res = sdk.client().collections().list()
                .request(req)
                .call();

        if (res.listCollectionsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [ListCollectionsRequest](../../models/shared/ListCollectionsRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[ListcollectionsResponse](../../models/operations/ListcollectionsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |