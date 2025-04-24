# Collections
(*client().collections()*)

## Overview

### Available Operations

* [addItems](#additems) - Add Collection item
* [create](#create) - Create Collection
* [delete](#delete) - Delete Collection
* [deleteItem](#deleteitem) - Delete Collection item
* [update](#update) - Update Collection
* [editItem](#edititem) - Update Collection item
* [edit](#edit) - Update document Collections
* [get](#get) - Read Collection
* [list](#list) - List Collections
* [moveItem](#moveitem) - Move Collection item
* [pin](#pin) - Pin Collection

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
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        AddcollectionitemsResponse res = sdk.client().collections().addItems()
                .addCollectionItemsRequest(AddCollectionItemsRequest.builder()
                    .collectionId(6460.15)
                    .build())
                .call();

        if (res.addCollectionItemsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `addCollectionItemsRequest`                                                                                              | [AddCollectionItemsRequest](../../models/components/AddCollectionItemsRequest.md)                                        | :heavy_check_mark:                                                                                                       | Data describing the add operation.                                                                                       |

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
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreatecollectionResponse res = sdk.client().collections().create()
                .createCollectionRequest(CreateCollectionRequest.builder()
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
                    .build())
                .call();

        if (res.createCollectionResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `createCollectionRequest`                                                                                                | [CreateCollectionRequest](../../models/components/CreateCollectionRequest.md)                                            | :heavy_check_mark:                                                                                                       | Collection content plus any additional metadata for the request.                                                         |

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
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeletecollectionResponse res = sdk.client().collections().delete()
                .deleteCollectionRequest(DeleteCollectionRequest.builder()
                    .ids(List.of(
                        698486L,
                        386564L))
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `deleteCollectionRequest`                                                                                                | [DeleteCollectionRequest](../../models/components/DeleteCollectionRequest.md)                                            | :heavy_check_mark:                                                                                                       | DeleteCollection request                                                                                                 |

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
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeletecollectionitemResponse res = sdk.client().collections().deleteItem()
                .deleteCollectionItemRequest(DeleteCollectionItemRequest.builder()
                    .collectionId(1357.59)
                    .itemId("<id>")
                    .build())
                .call();

        if (res.deleteCollectionItemResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `deleteCollectionItemRequest`                                                                                            | [DeleteCollectionItemRequest](../../models/components/DeleteCollectionItemRequest.md)                                    | :heavy_check_mark:                                                                                                       | Data describing the delete operation.                                                                                    |

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
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        EditcollectionResponse res = sdk.client().collections().update()
                .editCollectionRequest(EditCollectionRequest.builder()
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
                    .build())
                .call();

        if (res.editCollectionResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `editCollectionRequest`                                                                                                  | [EditCollectionRequest](../../models/components/EditCollectionRequest.md)                                                | :heavy_check_mark:                                                                                                       | Collection content plus any additional metadata for the request.                                                         |

### Response

**[EditcollectionResponse](../../models/operations/EditcollectionResponse.md)**

### Errors

| Error Type                    | Status Code                   | Content Type                  |
| ----------------------------- | ----------------------------- | ----------------------------- |
| models/errors/CollectionError | 422                           | application/json              |
| models/errors/APIException    | 4XX, 5XX                      | \*/\*                         |

## editItem

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
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        EditcollectionitemResponse res = sdk.client().collections().editItem()
                .editCollectionItemRequest(EditCollectionItemRequest.builder()
                    .collectionId(795203L)
                    .itemId("<id>")
                    .build())
                .call();

        if (res.editCollectionItemResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `editCollectionItemRequest`                                                                                              | [EditCollectionItemRequest](../../models/components/EditCollectionItemRequest.md)                                        | :heavy_check_mark:                                                                                                       | Edit Collection Items request                                                                                            |

### Response

**[EditcollectionitemResponse](../../models/operations/EditcollectionitemResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## edit

Update the Collections that a document belongs to.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.EditDocumentCollectionsRequest;
import com.glean.api_client.models.operations.EditdocumentcollectionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        EditdocumentcollectionsResponse res = sdk.client().collections().edit()
                .editDocumentCollectionsRequest(EditDocumentCollectionsRequest.builder()
                    .build())
                .call();

        if (res.editDocumentCollectionsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `editDocumentCollectionsRequest`                                                                                         | [EditDocumentCollectionsRequest](../../models/components/EditDocumentCollectionsRequest.md)                              | :heavy_check_mark:                                                                                                       | Data describing the edit operation.                                                                                      |

### Response

**[EditdocumentcollectionsResponse](../../models/operations/EditdocumentcollectionsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## get

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
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetcollectionResponse res = sdk.client().collections().get()
                .getCollectionRequest(GetCollectionRequest.builder()
                    .id(700347L)
                    .build())
                .call();

        if (res.getCollectionResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `getCollectionRequest`                                                                                                   | [GetCollectionRequest](../../models/components/GetCollectionRequest.md)                                                  | :heavy_check_mark:                                                                                                       | GetCollection request                                                                                                    |

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
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ListcollectionsResponse res = sdk.client().collections().list()
                .listCollectionsRequest(ListCollectionsRequest.builder()
                    .build())
                .call();

        if (res.listCollectionsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `listCollectionsRequest`                                                                                                 | [ListCollectionsRequest](../../models/components/ListCollectionsRequest.md)                                              | :heavy_check_mark:                                                                                                       | ListCollections request                                                                                                  |

### Response

**[ListcollectionsResponse](../../models/operations/ListcollectionsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## moveItem

Reorder a Collection by moving a CollectionItem below another CollectionItem.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.MoveCollectionItemRequest;
import com.glean.api_client.models.operations.MovecollectionitemResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        MovecollectionitemResponse res = sdk.client().collections().moveItem()
                .moveCollectionItemRequest(MoveCollectionItemRequest.builder()
                    .collectionId(451684L)
                    .itemId("<id>")
                    .build())
                .call();

        if (res.moveCollectionItemResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `moveCollectionItemRequest`                                                                                              | [MoveCollectionItemRequest](../../models/components/MoveCollectionItemRequest.md)                                        | :heavy_check_mark:                                                                                                       | MoveCollectionItems request                                                                                              |

### Response

**[MovecollectionitemResponse](../../models/operations/MovecollectionitemResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## pin

Given the Collection id and category, pins the Collection to the home page for all company users.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.PinCollectionRequest;
import com.glean.api_client.models.operations.PincollectionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PincollectionResponse res = sdk.client().collections().pin()
                .pinCollectionRequest(PinCollectionRequest.builder()
                    .build())
                .call();

        if (res.getCollectionResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `pinCollectionRequest`                                                                                                   | [PinCollectionRequest](../../models/components/PinCollectionRequest.md)                                                  | :heavy_check_mark:                                                                                                       | PinCollection request                                                                                                    |

### Response

**[PincollectionResponse](../../models/operations/PincollectionResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |