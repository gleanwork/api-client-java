# Chat
(*client().chat()*)

## Overview

### Available Operations

* [ask](#ask) - Detect and answer questions
* [start](#start) - Chat
* [deleteAll](#deleteall) - Deletes all saved Chats owned by a user
* [delete](#delete) - Deletes saved Chats
* [get](#get) - Retrieves a Chat
* [list](#list) - Retrieves all saved Chats
* [getApplication](#getapplication) - Gets the metadata for a custom Chat application
* [uploadFiles](#uploadfiles) - Upload files for Chat.
* [getFiles](#getfiles) - Get files uploaded by a user for Chat.
* [deleteFiles](#deletefiles) - Delete files uploaded by a user for chat.

## ask

Classify a query as information seeking or not. If so, generate an AI answer and/or provide relevant documents. Useful for integrating into existing chat interfaces.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.errors.ErrorInfo;
import com.glean.api_client.models.operations.AskResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorInfo, Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        AskResponse res = sdk.client().chat().ask()
                .askRequest(AskRequest.builder()
                    .searchRequest(SearchRequest.builder()
                        .query("vacation policy")
                        .trackingToken("trackingToken")
                        .sourceDocument(Document.builder()
                            .metadata(DocumentMetadata.builder()
                                .datasource("datasource")
                                .objectType("Feature Request")
                                .container("container")
                                .parentId("JIRA_EN-1337")
                                .mimeType("mimeType")
                                .documentId("documentId")
                                .createTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                .updateTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                .author(Person.builder()
                                    .name("George Clooney")
                                    .obfuscatedId("abc123")
                                    .relatedDocuments(List.of())
                                    .metadata(PersonMetadata.builder()
                                        .type(PersonMetadataType.FULL_TIME)
                                        .title("Actor")
                                        .department("Movies")
                                        .email("george@example.com")
                                        .location("Hollywood, CA")
                                        .phone("6505551234")
                                        .photoUrl("https://example.com/george.jpg")
                                        .startDate(LocalDate.parse("2000-01-23"))
                                        .datasourceProfile(List.of(
                                            DatasourceProfile.builder()
                                                .datasource("github")
                                                .handle("<value>")
                                                .build()))
                                        .querySuggestions(QuerySuggestionList.builder()
                                            .suggestions(List.of())
                                            .build())
                                        .inviteInfo(InviteInfo.builder()
                                            .invites(List.of())
                                            .build())
                                        .customFields(List.of())
                                        .badges(List.of(
                                            Badge.builder()
                                                .key("deployment_name_new_hire")
                                                .displayName("New hire")
                                                .iconConfig(IconConfig.builder()
                                                    .color("#343CED")
                                                    .key("person_icon")
                                                    .iconType(IconType.GLYPH)
                                                    .name("user")
                                                    .build())
                                                .build()))
                                        .build())
                                    .build())
                                .owner(Person.builder()
                                    .name("George Clooney")
                                    .obfuscatedId("abc123")
                                    .build())
                                .mentionedPeople(List.of())
                                .components(List.of(
                                    "Backend",
                                    "Networking"))
                                .status("[\"Done\"]")
                                .pins(List.of())
                                .assignedTo(Person.builder()
                                    .name("George Clooney")
                                    .obfuscatedId("abc123")
                                    .build())
                                .updatedBy(Person.builder()
                                    .name("George Clooney")
                                    .obfuscatedId("abc123")
                                    .build())
                                .collections(List.of())
                                .interactions(DocumentInteractions.builder()
                                    .reacts(List.of())
                                    .shares(List.of())
                                    .build())
                                .verification(Verification.builder()
                                    .state(State.UNVERIFIED)
                                    .metadata(VerificationMetadata.builder()
                                        .lastVerifier(Person.builder()
                                            .name("George Clooney")
                                            .obfuscatedId("abc123")
                                            .build())
                                        .reminders(List.of())
                                        .lastReminder(Reminder.builder()
                                            .assignee(Person.builder()
                                                .name("George Clooney")
                                                .obfuscatedId("abc123")
                                                .build())
                                            .remindAt(892381L)
                                            .requestor(Person.builder()
                                                .name("George Clooney")
                                                .obfuscatedId("abc123")
                                                .build())
                                            .build())
                                        .candidateVerifiers(List.of())
                                        .build())
                                    .build())
                                .customData(Map.ofEntries(
                                    Map.entry("someCustomField", CustomDataValue.builder()
                                        .build())))
                                .contactPerson(Person.builder()
                                    .name("George Clooney")
                                    .obfuscatedId("abc123")
                                    .build())
                                .build())
                            .build())
                        .pageSize(100L)
                        .maxSnippetSize(400L)
                        .inputDetails(SearchRequestInputDetails.builder()
                            .hasCopyPaste(true)
                            .build())
                        .requestOptions(SearchRequestOptions.builder()
                            .facetBucketSize(132988L)
                            .datasourceFilter("JIRA")
                            .datasourcesFilter(List.of(
                                "JIRA"))
                            .queryOverridesFacetFilters(true)
                            .facetFilters(List.of(
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
                            .facetFilterSets(List.of(
                                FacetFilterSet.builder()
                                    .filters(List.of(
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
                                    .build()))
                            .authTokens(List.of(
                                AuthToken.builder()
                                    .accessToken("123abc")
                                    .datasource("gmail")
                                    .scope("email profile https://www.googleapis.com/auth/gmail.readonly")
                                    .tokenType("Bearer")
                                    .authUser("1")
                                    .build()))
                            .build())
                        .timeoutMillis(5000L)
                        .people(List.of(
                            Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .build()))
                        .build())
                    .build())
                .call();

        if (res.askResponse().isPresent()) {
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
| `askRequest`                                                                                                             | [Optional\<AskRequest>](../../models/components/AskRequest.md)                                                           | :heavy_minus_sign:                                                                                                       | Ask request                                                                                                              |

### Response

**[AskResponse](../../models/operations/AskResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorInfo    | 403, 422                   | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## start

Have a conversation with Glean AI.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.ChatResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ChatResponse res = sdk.client().chat().start()
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

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `timezoneOffset`                                                                                                         | *Optional\<Long>*                                                                                                        | :heavy_minus_sign:                                                                                                       | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.               |
| `chatRequest`                                                                                                            | [ChatRequest](../../models/components/ChatRequest.md)                                                                    | :heavy_check_mark:                                                                                                       | Includes chat history for Glean AI to respond to.                                                                        |

### Response

**[ChatResponse](../../models/operations/ChatResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## deleteAll

Deletes all saved Chats a user has had and all their contained conversational content.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.operations.DeleteallchatsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteallchatsResponse res = sdk.client().chat().deleteAll()
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `timezoneOffset`                                                                                                         | *Optional\<Long>*                                                                                                        | :heavy_minus_sign:                                                                                                       | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.               |

### Response

**[DeleteallchatsResponse](../../models/operations/DeleteallchatsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## delete

Deletes saved Chats and all their contained conversational content.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteChatsRequest;
import com.glean.api_client.models.operations.DeletechatsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeletechatsResponse res = sdk.client().chat().delete()
                .deleteChatsRequest(DeleteChatsRequest.builder()
                    .ids(List.of(
                        "<value>",
                        "<value>"))
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `timezoneOffset`                                                                                                         | *Optional\<Long>*                                                                                                        | :heavy_minus_sign:                                                                                                       | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.               |
| `deleteChatsRequest`                                                                                                     | [DeleteChatsRequest](../../models/components/DeleteChatsRequest.md)                                                      | :heavy_check_mark:                                                                                                       | N/A                                                                                                                      |

### Response

**[DeletechatsResponse](../../models/operations/DeletechatsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## get

Retrieves the chat history between Glean Assistant and the user for a given Chat.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetChatRequest;
import com.glean.api_client.models.operations.GetchatResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetchatResponse res = sdk.client().chat().get()
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

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `timezoneOffset`                                                                                                         | *Optional\<Long>*                                                                                                        | :heavy_minus_sign:                                                                                                       | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.               |
| `getChatRequest`                                                                                                         | [GetChatRequest](../../models/components/GetChatRequest.md)                                                              | :heavy_check_mark:                                                                                                       | N/A                                                                                                                      |

### Response

**[GetchatResponse](../../models/operations/GetchatResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

Retrieves all the saved Chats between Glean Assistant and the user. The returned Chats contain only metadata and no conversational content.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.operations.ListchatsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
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

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `timezoneOffset`                                                                                                         | *Optional\<Long>*                                                                                                        | :heavy_minus_sign:                                                                                                       | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.               |

### Response

**[ListchatsResponse](../../models/operations/ListchatsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getApplication

Gets the Chat application details for the specified application ID.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetChatApplicationRequest;
import com.glean.api_client.models.operations.GetchatapplicationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetchatapplicationResponse res = sdk.client().chat().getApplication()
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

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `timezoneOffset`                                                                                                         | *Optional\<Long>*                                                                                                        | :heavy_minus_sign:                                                                                                       | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.               |
| `getChatApplicationRequest`                                                                                              | [GetChatApplicationRequest](../../models/components/GetChatApplicationRequest.md)                                        | :heavy_check_mark:                                                                                                       | N/A                                                                                                                      |

### Response

**[GetchatapplicationResponse](../../models/operations/GetchatapplicationResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## uploadFiles

Upload files for Chat.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.UploadChatFilesRequest;
import com.glean.api_client.models.operations.UploadchatfilesResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UploadchatfilesResponse res = sdk.client().chat().uploadFiles()
                .uploadChatFilesRequest(UploadChatFilesRequest.builder()
                    .files(List.of())
                    .build())
                .call();

        if (res.uploadChatFilesResponse().isPresent()) {
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
| `timezoneOffset`                                                                                                         | *Optional\<Long>*                                                                                                        | :heavy_minus_sign:                                                                                                       | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.               |
| `uploadChatFilesRequest`                                                                                                 | [UploadChatFilesRequest](../../models/components/UploadChatFilesRequest.md)                                              | :heavy_check_mark:                                                                                                       | N/A                                                                                                                      |

### Response

**[UploadchatfilesResponse](../../models/operations/UploadchatfilesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getFiles

Get files uploaded by a user for Chat.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetChatFilesRequest;
import com.glean.api_client.models.operations.GetchatfilesResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetchatfilesResponse res = sdk.client().chat().getFiles()
                .getChatFilesRequest(GetChatFilesRequest.builder()
                    .fileIds(List.of(
                        "<value>",
                        "<value>"))
                    .build())
                .call();

        if (res.getChatFilesResponse().isPresent()) {
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
| `timezoneOffset`                                                                                                         | *Optional\<Long>*                                                                                                        | :heavy_minus_sign:                                                                                                       | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.               |
| `getChatFilesRequest`                                                                                                    | [GetChatFilesRequest](../../models/components/GetChatFilesRequest.md)                                                    | :heavy_check_mark:                                                                                                       | N/A                                                                                                                      |

### Response

**[GetchatfilesResponse](../../models/operations/GetchatfilesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## deleteFiles

Delete files uploaded by a user for Chat.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteChatFilesRequest;
import com.glean.api_client.models.operations.DeletechatfilesResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeletechatfilesResponse res = sdk.client().chat().deleteFiles()
                .deleteChatFilesRequest(DeleteChatFilesRequest.builder()
                    .fileIds(List.of(
                        "<value>"))
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `xScioActas`                                                                                                             | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Email address of a user on whose behalf the request is intended to be made (should be non-empty only for global tokens). |
| `xGleanAuthType`                                                                                                         | *Optional\<String>*                                                                                                      | :heavy_minus_sign:                                                                                                       | Auth type being used to access the endpoint (should be non-empty only for global tokens).                                |
| `timezoneOffset`                                                                                                         | *Optional\<Long>*                                                                                                        | :heavy_minus_sign:                                                                                                       | The offset of the client's timezone in minutes from UTC. e.g. PDT is -420 because it's 7 hours behind UTC.               |
| `deleteChatFilesRequest`                                                                                                 | [DeleteChatFilesRequest](../../models/components/DeleteChatFilesRequest.md)                                              | :heavy_check_mark:                                                                                                       | N/A                                                                                                                      |

### Response

**[DeletechatfilesResponse](../../models/operations/DeletechatfilesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |