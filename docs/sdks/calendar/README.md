# Calendar
(*client().calendar()*)

## Overview

### Available Operations

* [getEvents](#getevents) - Read events

## getEvents

Read detailed information about the given event ids.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.AuthToken;
import com.glean.api_client.models.components.GetEventsRequest;
import com.glean.api_client.models.operations.GeteventsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GeteventsResponse res = sdk.client().calendar().getEvents()
                .getEventsRequest(GetEventsRequest.builder()
                    .ids(List.of())
                    .authTokens(List.of(
                        AuthToken.builder()
                            .accessToken("123abc")
                            .datasource("gmail")
                            .scope("email profile https://www.googleapis.com/auth/gmail.readonly")
                            .tokenType("Bearer")
                            .authUser("1")
                            .build()))
                    .build())
                .call();

        if (res.getEventsResponse().isPresent()) {
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
| `getEventsRequest`                                                                                                       | [GetEventsRequest](../../models/components/GetEventsRequest.md)                                                          | :heavy_check_mark:                                                                                                       | GetEvents request                                                                                                        |

### Response

**[GeteventsResponse](../../models/operations/GeteventsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |