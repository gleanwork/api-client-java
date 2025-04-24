# DisplayableLists
(*client().displayableLists()*)

## Overview

### Available Operations

* [create](#create) - Create displayable lists
* [delete](#delete) - Delete displayable lists
* [get](#get) - Read displayable lists
* [update](#update) - Update displayable lists

## create

Create one or more lists that can be display on the home page.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.CreatedisplayablelistsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreatedisplayablelistsResponse res = sdk.client().displayableLists().create()
                .createDisplayableListsRequest(CreateDisplayableListsRequest.builder()
                    .items(List.of(
                        DisplayableList.builder()
                            .config(DisplayableListConfig.builder()
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
                            .build()))
                    .build())
                .call();

        if (res.createDisplayableListsResponse().isPresent()) {
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
| `createDisplayableListsRequest`                                                                                          | [CreateDisplayableListsRequest](../../models/components/CreateDisplayableListsRequest.md)                                | :heavy_check_mark:                                                                                                       | Create new displayable lists                                                                                             |

### Response

**[CreatedisplayablelistsResponse](../../models/operations/CreatedisplayablelistsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## delete

Delete one or more displayable lists.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteDisplayableListsRequest;
import com.glean.api_client.models.operations.DeletedisplayablelistsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeletedisplayablelistsResponse res = sdk.client().displayableLists().delete()
                .deleteDisplayableListsRequest(DeleteDisplayableListsRequest.builder()
                    .ids(List.of(
                        698486,
                        386564))
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
| `deleteDisplayableListsRequest`                                                                                          | [DeleteDisplayableListsRequest](../../models/components/DeleteDisplayableListsRequest.md)                                | :heavy_check_mark:                                                                                                       | Updated version of the displayable list configs.                                                                         |

### Response

**[DeletedisplayablelistsResponse](../../models/operations/DeletedisplayablelistsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## get

Read the details of the displayable lists with the given IDs.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetDisplayableListsRequest;
import com.glean.api_client.models.operations.GetdisplayablelistsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetdisplayablelistsResponse res = sdk.client().displayableLists().get()
                .getDisplayableListsRequest(GetDisplayableListsRequest.builder()
                    .ids(List.of(
                        558834,
                        544221))
                    .build())
                .call();

        if (res.getDisplayableListsResponse().isPresent()) {
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
| `getDisplayableListsRequest`                                                                                             | [GetDisplayableListsRequest](../../models/components/GetDisplayableListsRequest.md)                                      | :heavy_check_mark:                                                                                                       | N/A                                                                                                                      |

### Response

**[GetdisplayablelistsResponse](../../models/operations/GetdisplayablelistsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## update

Update one or more displayable lists with all fields from request fields.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.UpdatedisplayablelistsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UpdatedisplayablelistsResponse res = sdk.client().displayableLists().update()
                .updateDisplayableListsRequest(UpdateDisplayableListsRequest.builder()
                    .items(List.of(
                        DisplayableList.builder()
                            .config(DisplayableListConfig.builder()
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
                            .build(),
                        DisplayableList.builder()
                            .config(DisplayableListConfig.builder()
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
                            .build(),
                        DisplayableList.builder()
                            .config(DisplayableListConfig.builder()
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
                            .build()))
                    .build())
                .call();

        if (res.updateDisplayableListsResponse().isPresent()) {
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
| `updateDisplayableListsRequest`                                                                                          | [UpdateDisplayableListsRequest](../../models/components/UpdateDisplayableListsRequest.md)                                | :heavy_check_mark:                                                                                                       | Updated version of the displayable list configs.                                                                         |

### Response

**[UpdatedisplayablelistsResponse](../../models/operations/UpdatedisplayablelistsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |