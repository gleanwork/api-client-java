# ClientAuthentication
(*client().authentication()*)

## Overview

### Available Operations

* [createToken](#createtoken) - Create authentication token

## createToken

Creates an authentication token for the authenticated user.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.CreateauthtokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
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