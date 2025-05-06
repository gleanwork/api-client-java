# Pins
(*client().pins()*)

## Overview

### Available Operations

* [update](#update) - Update pin
* [retrieve](#retrieve) - Read pin
* [list](#list) - List pins
* [create](#create) - Create pin
* [remove](#remove) - Delete pin

## update

Update an existing user-generated pin.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.EditpinResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        EditPinRequest req = EditPinRequest.builder()
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

        EditpinResponse res = sdk.client().pins().update()
                .request(req)
                .call();

        if (res.pinDocument().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                               | Type                                                    | Required                                                | Description                                             |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| `request`                                               | [EditPinRequest](../../models/shared/EditPinRequest.md) | :heavy_check_mark:                                      | The request object to use for the request.              |

### Response

**[EditpinResponse](../../models/operations/EditpinResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieve

Read pin details given its ID.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetPinRequest;
import com.glean.api_client.models.operations.GetpinResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetPinRequest req = GetPinRequest.builder()
                .build();

        GetpinResponse res = sdk.client().pins().retrieve()
                .request(req)
                .call();

        if (res.getPinResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                             | Type                                                  | Required                                              | Description                                           |
| ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- |
| `request`                                             | [GetPinRequest](../../models/shared/GetPinRequest.md) | :heavy_check_mark:                                    | The request object to use for the request.            |

### Response

**[GetpinResponse](../../models/operations/GetpinResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

Lists all pins.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.operations.ListpinsRequest;
import com.glean.api_client.models.operations.ListpinsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ListpinsRequest req = ListpinsRequest.builder()
                .build();

        ListpinsResponse res = sdk.client().pins().list()
                .request(req)
                .call();

        if (res.listPinsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `request`                                                     | [ListpinsRequest](../../models/operations/ListpinsRequest.md) | :heavy_check_mark:                                            | The request object to use for the request.                    |

### Response

**[ListpinsResponse](../../models/operations/ListpinsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## create

Pin a document as a result for a given search query.Pin results that are known to be a good match.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.PinResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PinRequest req = PinRequest.builder()
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

        PinResponse res = sdk.client().pins().create()
                .request(req)
                .call();

        if (res.pinDocument().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                       | Type                                            | Required                                        | Description                                     |
| ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- |
| `request`                                       | [PinRequest](../../models/shared/PinRequest.md) | :heavy_check_mark:                              | The request object to use for the request.      |

### Response

**[PinResponse](../../models/operations/PinResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## remove

Unpin a previously pinned result.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.Unpin;
import com.glean.api_client.models.operations.UnpinResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        Unpin req = Unpin.builder()
                .build();

        UnpinResponse res = sdk.client().pins().remove()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                  | Type                                       | Required                                   | Description                                |
| ------------------------------------------ | ------------------------------------------ | ------------------------------------------ | ------------------------------------------ |
| `request`                                  | [Unpin](../../models/shared/Unpin.md)      | :heavy_check_mark:                         | The request object to use for the request. |

### Response

**[UnpinResponse](../../models/operations/UnpinResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |