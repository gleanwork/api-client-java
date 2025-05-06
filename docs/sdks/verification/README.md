# Verification
(*client().verification()*)

## Overview

### Available Operations

* [addReminder](#addreminder) - Create verification
* [list](#list) - List verifications
* [verify](#verify) - Update verification

## addReminder

Creates a verification reminder for the document. Users can create verification reminders from different product surfaces.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.ReminderRequest;
import com.glean.api_client.models.operations.AddverificationreminderResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ReminderRequest req = ReminderRequest.builder()
                .documentId("<id>")
                .build();

        AddverificationreminderResponse res = sdk.client().verification().addReminder()
                .request(req)
                .call();

        if (res.verification().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                 | Type                                                      | Required                                                  | Description                                               |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| `request`                                                 | [ReminderRequest](../../models/shared/ReminderRequest.md) | :heavy_check_mark:                                        | The request object to use for the request.                |

### Response

**[AddverificationreminderResponse](../../models/operations/AddverificationreminderResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

Returns the information to be rendered in verification dashboard. Includes information for each document owned by user regarding their verifications.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.operations.ListverificationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ListverificationsResponse res = sdk.client().verification().list()
                .call();

        if (res.verificationFeed().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                             | Type                                  | Required                              | Description                           |
| ------------------------------------- | ------------------------------------- | ------------------------------------- | ------------------------------------- |
| `count`                               | *Optional\<Long>*                     | :heavy_minus_sign:                    | Maximum number of documents to return |

### Response

**[ListverificationsResponse](../../models/operations/ListverificationsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## verify

Verify documents to keep the knowledge up to date within customer corpus.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.VerifyRequest;
import com.glean.api_client.models.operations.VerifyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        VerifyRequest req = VerifyRequest.builder()
                .documentId("<id>")
                .build();

        VerifyResponse res = sdk.client().verification().verify()
                .request(req)
                .call();

        if (res.verification().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                             | Type                                                  | Required                                              | Description                                           |
| ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- |
| `request`                                             | [VerifyRequest](../../models/shared/VerifyRequest.md) | :heavy_check_mark:                                    | The request object to use for the request.            |

### Response

**[VerifyResponse](../../models/operations/VerifyResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |