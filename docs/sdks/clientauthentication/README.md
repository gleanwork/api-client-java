# ClientAuthentication
(*client().authentication()*)

## Overview

### Available Operations

* [createToken](#createtoken) - Create authentication token

## createToken

Creates an authentication token for the authenticated user. These are
specifically intended to be used with the [Web SDK](https://developers.glean.com/web).

Note: The tokens generated from this endpoint are **not** valid tokens
for use with the Client API (e.g. `/rest/api/v1/*`).


### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.CreateauthtokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateauthtokenResponse res = sdk.client().authentication().createToken()
                .call();

        if (res.createAuthTokenResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[CreateauthtokenResponse](../../models/operations/CreateauthtokenResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |