# Client.Entities

## Overview

### Available Operations

* [list](#list) - List entities
* [readPeople](#readpeople) - Read people

## list

List some set of details for all entities that fit the given criteria and return in the requested order. Does not support negation in filters, assumes relation type EQUALS. There is a limit of 10000 entities that can be retrieved via this endpoint, except when using FULL_DIRECTORY request type for people entities.

### Example Usage

<!-- UsageSnippet language="java" operationID="listentities" method="post" path="/rest/api/v1/listentities" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.ListentitiesResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        ListentitiesResponse res = sdk.client().entities().list()
                .listEntitiesRequest(ListEntitiesRequest.builder()
                    .filter(List.of(
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
                    .pageSize(100L)
                    .build())
                .call();

        if (res.listEntitiesResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `listEntitiesRequest`                                                                                                                                                                               | [ListEntitiesRequest](../../models/components/ListEntitiesRequest.md)                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                  | List people request                                                                                                                                                                                 |

### Response

**[ListentitiesResponse](../../models/operations/ListentitiesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## readPeople

Read people details for the given IDs.

### Example Usage

<!-- UsageSnippet language="java" operationID="people" method="post" path="/rest/api/v1/people" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.PeopleRequest;
import com.glean.api_client.glean_api_client.models.operations.PeopleResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PeopleResponse res = sdk.client().entities().readPeople()
                .peopleRequest(PeopleRequest.builder()
                    .obfuscatedIds(List.of(
                        "abc123",
                        "abc456"))
                    .build())
                .call();

        if (res.peopleResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         | Example                                                                                                                                                                                             |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |                                                                                                                                                                                                     |
| `peopleRequest`                                                                                                                                                                                     | [PeopleRequest](../../models/components/PeopleRequest.md)                                                                                                                                           | :heavy_check_mark:                                                                                                                                                                                  | People request                                                                                                                                                                                      | {<br/>"obfuscatedIds": [<br/>"abc123",<br/>"abc456"<br/>]<br/>}                                                                                                                                     |

### Response

**[PeopleResponse](../../models/operations/PeopleResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |