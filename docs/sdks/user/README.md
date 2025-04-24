# User
(*client().user()*)

## Overview

### Available Operations

* [addCredential](#addcredential) - Create credentials
* [deleteQueryHistory](#deletequeryhistory) - Delete query history
* [invite](#invite) - Send invitation
* [getPublicConfig](#getpublicconfig) - Read public client configuration
* [removeCredential](#removecredential) - Delete credentials
* [sendSupportEmail](#sendsupportemail) - Send support email

## addCredential

API to save a user's credentials. Used for Confluence restricted pages and Tableau per-user auth, for example

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.AddCredentialRequest;
import com.glean.api_client.models.operations.AddcredentialResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        AddcredentialResponse res = sdk.client().user().addCredential()
                .addCredentialRequest(AddCredentialRequest.builder()
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
| `addCredentialRequest`                                                                                                   | [AddCredentialRequest](../../models/components/AddCredentialRequest.md)                                                  | :heavy_check_mark:                                                                                                       | Credential content                                                                                                       |

### Response

**[AddcredentialResponse](../../models/operations/AddcredentialResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## deleteQueryHistory

Remove one or more queries from a user's query history.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteQueryHistoryRequest;
import com.glean.api_client.models.operations.DeletequeryhistoryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeletequeryhistoryResponse res = sdk.client().user().deleteQueryHistory()
                .deleteQueryHistoryRequest(DeleteQueryHistoryRequest.builder()
                    .build())
                .call();

        if (res.deleteQueryHistoryResponse().isPresent()) {
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
| `deleteQueryHistoryRequest`                                                                                              | [DeleteQueryHistoryRequest](../../models/components/DeleteQueryHistoryRequest.md)                                        | :heavy_check_mark:                                                                                                       | Delete query history request                                                                                             |

### Response

**[DeletequeryhistoryResponse](../../models/operations/DeletequeryhistoryResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## invite

Invites people to Glean via email or Slack

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.InviteResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        InviteResponse res = sdk.client().user().invite()
                .inviteRequest(InviteRequest.builder()
                    .recipients(List.of(
                        Person.builder()
                            .name("George Clooney")
                            .obfuscatedId("abc123")
                            .build()))
                    .recipientFilters(PeopleFilters.builder()
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
                        .build())
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
| `inviteRequest`                                                                                                          | [InviteRequest](../../models/components/InviteRequest.md)                                                                | :heavy_check_mark:                                                                                                       | Invite request                                                                                                           |

### Response

**[InviteResponse](../../models/operations/InviteResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getPublicConfig

Read configuration information such as the company name, logo and etc that is public and is not considered as PII.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.operations.PublicconfigResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PublicconfigResponse res = sdk.client().user().getPublicConfig()
                .call();

        if (res.clientConfig().isPresent()) {
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
| `publicConfigRequest`                                                                                                    | [Optional\<PublicConfigRequest>](../../models/components/PublicConfigRequest.md)                                         | :heavy_minus_sign:                                                                                                       | Public Config request                                                                                                    |

### Response

**[PublicconfigResponse](../../models/operations/PublicconfigResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## removeCredential

Delete a user's credentials. Used for Confluence restricted pages and Tableau per-user auth, for example

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.RemoveCredentialRequest;
import com.glean.api_client.models.operations.RemovecredentialResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        RemovecredentialResponse res = sdk.client().user().removeCredential()
                .removeCredentialRequest(RemoveCredentialRequest.builder()
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
| `removeCredentialRequest`                                                                                                | [RemoveCredentialRequest](../../models/components/RemoveCredentialRequest.md)                                            | :heavy_check_mark:                                                                                                       | Credential content                                                                                                       |

### Response

**[RemovecredentialResponse](../../models/operations/RemovecredentialResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## sendSupportEmail

Sends a support email based on a template to the Glean support team.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.SupportEmailResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        SupportEmailResponse res = sdk.client().user().sendSupportEmail()
                .emailRequest(EmailRequest.builder()
                    .emailTemplate(CommunicationTemplate.ONBOARDING_TIPS)
                    .recipients(List.of(
                        Person.builder()
                            .name("George Clooney")
                            .obfuscatedId("abc123")
                            .build()))
                    .ccRecipients(List.of(
                        Person.builder()
                            .name("George Clooney")
                            .obfuscatedId("abc123")
                            .build()))
                    .recipientFilters(PeopleFilters.builder()
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
                        .build())
                    .senders(List.of(
                        Person.builder()
                            .name("George Clooney")
                            .obfuscatedId("abc123")
                            .build()))
                    .documents(List.of(
                        Document.builder()
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
                                                .build(),
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
                                    .state(State.DEPRECATED)
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
                                            .remindAt(631645L)
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
                            .build(),
                        Document.builder()
                            .build()))
                    .feedbackPayload(FeedbackPayload.builder()
                        .customJson("{\"comment\": \"glean is awesome!\", \"sender\": \"happycustomer@customer.com\"}")
                        .build())
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
| `emailRequest`                                                                                                           | [EmailRequest](../../models/components/EmailRequest.md)                                                                  | :heavy_check_mark:                                                                                                       | Support request                                                                                                          |

### Response

**[SupportEmailResponse](../../models/operations/SupportEmailResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |