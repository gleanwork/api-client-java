# Images
(*client().images()*)

## Overview

### Available Operations

* [get](#get) - Get image
* [upload](#upload) - Upload images

## get

Serves images of various types (profile pic, background, UGC thumnail/content, etc).

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.operations.ImagesRequest;
import com.glean.api_client.models.operations.ImagesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ImagesRequest req = ImagesRequest.builder()
                .build();

        ImagesResponse res = sdk.client().images().get()
                .request(req)
                .call();

        if (res.responseStream().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                 | Type                                                      | Required                                                  | Description                                               |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| `request`                                                 | [ImagesRequest](../../models/operations/ImagesRequest.md) | :heavy_check_mark:                                        | The request object to use for the request.                |

### Response

**[ImagesResponse](../../models/operations/ImagesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## upload

Upload images for various types (profile pic, background, UGC thumnail/content, etc) with additional metadata.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.operations.UploadimageRequest;
import com.glean.api_client.models.operations.UploadimageResponse;
import java.lang.Exception;
import java.nio.charset.StandardCharsets;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UploadimageRequest req = UploadimageRequest.builder()
                .requestBody("0x8cc9e675ad".getBytes(StandardCharsets.UTF_8))
                .build();

        UploadimageResponse res = sdk.client().images().upload()
                .request(req)
                .call();

        if (res.uploadImageResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `request`                                                           | [UploadimageRequest](../../models/operations/UploadimageRequest.md) | :heavy_check_mark:                                                  | The request object to use for the request.                          |

### Response

**[UploadimageResponse](../../models/operations/UploadimageResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |