# Client.Verification

## Overview

### Available Operations

* [addReminder](#addreminder) - Create verification
* [list](#list) - List verifications
* [verify](#verify) - Update verification

## addReminder

Creates a verification reminder for the document. Users can create verification reminders from different product surfaces.

### Example Usage

<!-- UsageSnippet language="java" operationID="addverificationreminder" method="post" path="/rest/api/v1/addverificationreminder" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.ReminderRequest;
import com.glean.api_client.glean_api_client.models.operations.AddverificationreminderResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        AddverificationreminderResponse res = sdk.client().verification().addReminder()
                .reminderRequest(ReminderRequest.builder()
                    .documentId("<id>")
                    .build())
                .call();

        if (res.verification().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `reminderRequest`                                                                                                                                                                                   | [ReminderRequest](../../models/components/ReminderRequest.md)                                                                                                                                       | :heavy_check_mark:                                                                                                                                                                                  | Details about the reminder.                                                                                                                                                                         |

### Response

**[AddverificationreminderResponse](../../models/operations/AddverificationreminderResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

Returns the information to be rendered in verification dashboard. Includes information for each document owned by user regarding their verifications.

### Example Usage

<!-- UsageSnippet language="java" operationID="listverifications" method="post" path="/rest/api/v1/listverifications" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.ListverificationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
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

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `count`                                                                                                                                                                                             | *Optional\<Long>*                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                  | Maximum number of documents to return                                                                                                                                                               |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |

### Response

**[ListverificationsResponse](../../models/operations/ListverificationsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## verify

Verify documents to keep the knowledge up to date within customer corpus.

### Example Usage

<!-- UsageSnippet language="java" operationID="verify" method="post" path="/rest/api/v1/verify" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.VerifyRequest;
import com.glean.api_client.glean_api_client.models.operations.VerifyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        VerifyResponse res = sdk.client().verification().verify()
                .verifyRequest(VerifyRequest.builder()
                    .documentId("<id>")
                    .build())
                .call();

        if (res.verification().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `verifyRequest`                                                                                                                                                                                     | [VerifyRequest](../../models/components/VerifyRequest.md)                                                                                                                                           | :heavy_check_mark:                                                                                                                                                                                  | Details about the verification request.                                                                                                                                                             |

### Response

**[VerifyResponse](../../models/operations/VerifyResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |