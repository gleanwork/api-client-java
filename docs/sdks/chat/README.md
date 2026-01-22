# Client.Chat

## Overview

### Available Operations

* [create](#create) - Chat
* [deleteAll](#deleteall) - Deletes all saved Chats owned by a user
* [delete](#delete) - Deletes saved Chats
* [retrieve](#retrieve) - Retrieves a Chat
* [list](#list) - Retrieves all saved Chats
* [retrieveApplication](#retrieveapplication) - Gets the metadata for a custom Chat application
* [uploadFiles](#uploadfiles) - Upload files for Chat.
* [retrieveFiles](#retrievefiles) - Get files uploaded by a user for Chat.
* [deleteFiles](#deletefiles) - Delete files uploaded by a user for chat.
* [createStream](#createstream) - Chat

## create

Have a conversation with Glean AI.

### Example Usage

<!-- UsageSnippet language="java" operationID="chat" method="post" path="/rest/api/v1/chat" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.ChatResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        ChatResponse res = sdk.client().chat().create()
                .chatRequest(ChatRequest.builder()
                    .messages(List.of(
                        ChatMessage.builder()
                            .fragments(List.of(
                                ChatMessageFragment.builder()
                                    .text("What are the company holidays this year?")
                                    .build()))
                            .build()))
                    .build())
                .call();

        if (res.chatResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `timezoneOffset`                                                                                                                                                                                    | *Optional\<Long>*                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                  | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.                                                                                          |
| `chatRequest`                                                                                                                                                                                       | [ChatRequest](../../models/components/ChatRequest.md)                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                  | Includes chat history for Glean AI to respond to.                                                                                                                                                   |

### Response

**[ChatResponse](../../models/operations/ChatResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## deleteAll

Deletes all saved Chats a user has had and all their contained conversational content.

### Example Usage

<!-- UsageSnippet language="java" operationID="deleteallchats" method="post" path="/rest/api/v1/deleteallchats" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.DeleteallchatsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        DeleteallchatsResponse res = sdk.client().chat().deleteAll()
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `timezoneOffset`                                                                                                                                                                                    | *Optional\<Long>*                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                  | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.                                                                                          |

### Response

**[DeleteallchatsResponse](../../models/operations/DeleteallchatsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## delete

Deletes saved Chats and all their contained conversational content.

### Example Usage

<!-- UsageSnippet language="java" operationID="deletechats" method="post" path="/rest/api/v1/deletechats" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DeleteChatsRequest;
import com.glean.api_client.glean_api_client.models.operations.DeletechatsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        DeletechatsResponse res = sdk.client().chat().delete()
                .deleteChatsRequest(DeleteChatsRequest.builder()
                    .ids(List.of())
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `timezoneOffset`                                                                                                                                                                                    | *Optional\<Long>*                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                  | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.                                                                                          |
| `deleteChatsRequest`                                                                                                                                                                                | [DeleteChatsRequest](../../models/components/DeleteChatsRequest.md)                                                                                                                                 | :heavy_check_mark:                                                                                                                                                                                  | N/A                                                                                                                                                                                                 |

### Response

**[DeletechatsResponse](../../models/operations/DeletechatsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieve

Retrieves the chat history between Glean Assistant and the user for a given Chat.

### Example Usage

<!-- UsageSnippet language="java" operationID="getchat" method="post" path="/rest/api/v1/getchat" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.GetChatRequest;
import com.glean.api_client.glean_api_client.models.operations.GetchatResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetchatResponse res = sdk.client().chat().retrieve()
                .getChatRequest(GetChatRequest.builder()
                    .id("<id>")
                    .build())
                .call();

        if (res.getChatResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `timezoneOffset`                                                                                                                                                                                    | *Optional\<Long>*                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                  | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.                                                                                          |
| `getChatRequest`                                                                                                                                                                                    | [GetChatRequest](../../models/components/GetChatRequest.md)                                                                                                                                         | :heavy_check_mark:                                                                                                                                                                                  | N/A                                                                                                                                                                                                 |

### Response

**[GetchatResponse](../../models/operations/GetchatResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

Retrieves all the saved Chats between Glean Assistant and the user. The returned Chats contain only metadata and no conversational content.

### Example Usage

<!-- UsageSnippet language="java" operationID="listchats" method="post" path="/rest/api/v1/listchats" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.operations.ListchatsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        ListchatsResponse res = sdk.client().chat().list()
                .call();

        if (res.listChatsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `timezoneOffset`                                                                                                                                                                                    | *Optional\<Long>*                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                  | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.                                                                                          |

### Response

**[ListchatsResponse](../../models/operations/ListchatsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieveApplication

Gets the Chat application details for the specified application ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="getchatapplication" method="post" path="/rest/api/v1/getchatapplication" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.GetChatApplicationRequest;
import com.glean.api_client.glean_api_client.models.operations.GetchatapplicationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetchatapplicationResponse res = sdk.client().chat().retrieveApplication()
                .getChatApplicationRequest(GetChatApplicationRequest.builder()
                    .id("<id>")
                    .build())
                .call();

        if (res.getChatApplicationResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `timezoneOffset`                                                                                                                                                                                    | *Optional\<Long>*                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                  | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.                                                                                          |
| `getChatApplicationRequest`                                                                                                                                                                         | [GetChatApplicationRequest](../../models/components/GetChatApplicationRequest.md)                                                                                                                   | :heavy_check_mark:                                                                                                                                                                                  | N/A                                                                                                                                                                                                 |

### Response

**[GetchatapplicationResponse](../../models/operations/GetchatapplicationResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## uploadFiles

Upload files for Chat.

### Example Usage

<!-- UsageSnippet language="java" operationID="uploadchatfiles" method="post" path="/rest/api/v1/uploadchatfiles" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.File;
import com.glean.api_client.glean_api_client.models.components.UploadChatFilesRequest;
import com.glean.api_client.glean_api_client.models.operations.UploadchatfilesResponse;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.io.FileInputStream;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        UploadchatfilesResponse res = sdk.client().chat().uploadFiles()
                .uploadChatFilesRequest(UploadChatFilesRequest.builder()
                    .files(List.of(
                        File.builder()
                            .fileName("example.file")
                            .content(Utils.readBytesAndClose(new FileInputStream("example.file")))
                            .build()))
                    .build())
                .call();

    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `timezoneOffset`                                                                                                                                                                                    | *Optional\<Long>*                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                  | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.                                                                                          |
| `uploadChatFilesRequest`                                                                                                                                                                            | [UploadChatFilesRequest](../../models/components/UploadChatFilesRequest.md)                                                                                                                         | :heavy_check_mark:                                                                                                                                                                                  | N/A                                                                                                                                                                                                 |

### Response

**[UploadchatfilesResponse](../../models/operations/UploadchatfilesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieveFiles

Get files uploaded by a user for Chat.

### Example Usage

<!-- UsageSnippet language="java" operationID="getchatfiles" method="post" path="/rest/api/v1/getchatfiles" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.GetChatFilesRequest;
import com.glean.api_client.glean_api_client.models.operations.GetchatfilesResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        GetchatfilesResponse res = sdk.client().chat().retrieveFiles()
                .getChatFilesRequest(GetChatFilesRequest.builder()
                    .fileIds(List.of(
                        "<value 1>"))
                    .build())
                .call();

        if (res.getChatFilesResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `timezoneOffset`                                                                                                                                                                                    | *Optional\<Long>*                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                  | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.                                                                                          |
| `getChatFilesRequest`                                                                                                                                                                               | [GetChatFilesRequest](../../models/components/GetChatFilesRequest.md)                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                  | N/A                                                                                                                                                                                                 |

### Response

**[GetchatfilesResponse](../../models/operations/GetchatfilesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## deleteFiles

Delete files uploaded by a user for Chat.

### Example Usage

<!-- UsageSnippet language="java" operationID="deletechatfiles" method="post" path="/rest/api/v1/deletechatfiles" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.DeleteChatFilesRequest;
import com.glean.api_client.glean_api_client.models.operations.DeletechatfilesResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        DeletechatfilesResponse res = sdk.client().chat().deleteFiles()
                .deleteChatFilesRequest(DeleteChatFilesRequest.builder()
                    .fileIds(List.of(
                        "<value 1>",
                        "<value 2>",
                        "<value 3>"))
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                           | Type                                                                                                                                                                                                | Required                                                                                                                                                                                            | Description                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `locale`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                  | The client's preferred locale in rfc5646 format (e.g. `en`, `ja`, `pt-BR`). If omitted, the `Accept-Language` will be used. If not present or not supported, defaults to the closest match or `en`. |
| `timezoneOffset`                                                                                                                                                                                    | *Optional\<Long>*                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                  | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.                                                                                          |
| `deleteChatFilesRequest`                                                                                                                                                                            | [DeleteChatFilesRequest](../../models/components/DeleteChatFilesRequest.md)                                                                                                                         | :heavy_check_mark:                                                                                                                                                                                  | N/A                                                                                                                                                                                                 |

### Response

**[DeletechatfilesResponse](../../models/operations/DeletechatfilesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## createStream

Have a conversation with Glean AI.

### Example Usage

<!-- UsageSnippet language="java" operationID="chatStream" method="post" path="/rest/api/v1/chat#stream" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.ChatStreamResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        ChatStreamResponse res = sdk.client().chat().createStream()
                .chatRequest(ChatRequest.builder()
                    .messages(List.of(
                        ChatMessage.builder()
                            .fragments(List.of(
                                ChatMessageFragment.builder()
                                    .text("What are the company holidays this year?")
                                    .build()))
                            .build()))
                    .build())
                .call();

        if (res.chatRequestStream().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                  | Type                                                                                                       | Required                                                                                                   | Description                                                                                                |
| ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| `timezoneOffset`                                                                                           | *Optional\<Long>*                                                                                          | :heavy_minus_sign:                                                                                         | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC. |
| `chatRequest`                                                                                              | [ChatRequest](../../models/components/ChatRequest.md)                                                      | :heavy_check_mark:                                                                                         | Includes chat history for Glean AI to respond to.                                                          |

### Response

**[ChatStreamResponse](../../models/operations/ChatStreamResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |