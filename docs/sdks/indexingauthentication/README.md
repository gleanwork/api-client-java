# IndexingAuthentication
(*indexing().authentication()*)

## Overview

### Available Operations

* [rotateToken](#rotatetoken) - Rotate token

## rotateToken

Rotates the secret value inside the Indexing API token and returns the new raw secret. All other properties of the token are unchanged. In order to rotate the secret value, include the token as the bearer token in the `/rotatetoken` request. Please refer to [Token rotation](https://developers.glean.com/docs/indexing_api_token_rotation/) documentation for more information.

### Example Usage

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.Security;
import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1RotatetokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .security(Security.builder()
                    .actAsBearerToken("<YOUR_API_KEY_HERE>")
                    .build())
            .build();

        PostApiIndexV1RotatetokenResponse res = sdk.indexing().authentication().rotateToken()
                .call();

        if (res.rotateTokenResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[PostApiIndexV1RotatetokenResponse](../../models/operations/PostApiIndexV1RotatetokenResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |