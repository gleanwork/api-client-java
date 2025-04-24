# Answers
(*client().answers()*)

## Overview

### Available Operations

* [create](#create) - Create Answer
* [delete](#delete) - Delete Answer
* [edit](#edit) - Update Answer
* [get](#get) - Read Answer
* [list](#list) - List Answers
* [preview](#preview) - Preview Answer
* [previewDraft](#previewdraft) - Preview draft Answer
* [updateLikes](#updatelikes) - Update Answer likes
* [~~createBoard~~](#createboard) - Create Answer Board :warning: **Deprecated**
* [~~deleteBoard~~](#deleteboard) - Delete Answer Board :warning: **Deprecated**
* [~~updateBoard~~](#updateboard) - Update Answer Board :warning: **Deprecated**
* [~~getBoard~~](#getboard) - Read Answer Board :warning: **Deprecated**
* [~~listBoards~~](#listboards) - List Answer Boards :warning: **Deprecated**

## create

Create a user-generated Answer that contains a question and answer.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.CreateanswerResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateanswerResponse res = sdk.client().answers().create()
                .createAnswerRequest(CreateAnswerRequest.builder()
                    .data(AnswerCreationData.builder()
                        .question("Why is the sky blue?")
                        .bodyText("From https://en.wikipedia.org/wiki/Diffuse_sky_radiation, the sky is blue because blue light is more strongly scattered than longer-wavelength light.")
                        .audienceFilters(List.of(
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
                        .addedRoles(List.of(
                            UserRoleSpecification.builder()
                                .role(UserRole.OWNER)
                                .person(Person.builder()
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
                                .build(),
                            UserRoleSpecification.builder()
                                .role(UserRole.VERIFIER)
                                .build()))
                        .removedRoles(List.of(
                            UserRoleSpecification.builder()
                                .role(UserRole.VERIFIER)
                                .build(),
                            UserRoleSpecification.builder()
                                .role(UserRole.ANSWER_MODERATOR)
                                .build(),
                            UserRoleSpecification.builder()
                                .role(UserRole.OWNER)
                                .build()))
                        .roles(List.of(
                            UserRoleSpecification.builder()
                                .role(UserRole.ANSWER_MODERATOR)
                                .build(),
                            UserRoleSpecification.builder()
                                .role(UserRole.OWNER)
                                .build(),
                            UserRoleSpecification.builder()
                                .role(UserRole.VERIFIER)
                                .build()))
                        .combinedAnswerText(StructuredTextMutableProperties.builder()
                            .text("From https://en.wikipedia.org/wiki/Diffuse_sky_radiation, the sky is blue because blue light is more strongly scattered than longer-wavelength light.")
                            .build())
                        .build())
                    .build())
                .call();

        if (res.answer().isPresent()) {
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
| `createAnswerRequest`                                                                                                    | [CreateAnswerRequest](../../models/components/CreateAnswerRequest.md)                                                    | :heavy_check_mark:                                                                                                       | CreateAnswer request                                                                                                     |

### Response

**[CreateanswerResponse](../../models/operations/CreateanswerResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## delete

Delete an existing user-generated Answer.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteAnswerRequest;
import com.glean.api_client.models.operations.DeleteanswerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteanswerResponse res = sdk.client().answers().delete()
                .deleteAnswerRequest(DeleteAnswerRequest.builder()
                    .id(3L)
                    .docId("ANSWERS_answer_3")
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
| `deleteAnswerRequest`                                                                                                    | [DeleteAnswerRequest](../../models/components/DeleteAnswerRequest.md)                                                    | :heavy_check_mark:                                                                                                       | DeleteAnswer request                                                                                                     |

### Response

**[DeleteanswerResponse](../../models/operations/DeleteanswerResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## edit

Update an existing user-generated Answer.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.EditanswerResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        EditanswerResponse res = sdk.client().answers().edit()
                .editAnswerRequest(EditAnswerRequest.builder()
                    .id(3L)
                    .docId("ANSWERS_answer_3")
                    .question("Why is the sky blue?")
                    .bodyText("From https://en.wikipedia.org/wiki/Diffuse_sky_radiation, the sky is blue because blue light is more strongly scattered than longer-wavelength light.")
                    .audienceFilters(List.of(
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
                    .addedRoles(List.of(
                        UserRoleSpecification.builder()
                            .role(UserRole.EDITOR)
                            .person(Person.builder()
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
                            .build()))
                    .removedRoles(List.of(
                        UserRoleSpecification.builder()
                            .role(UserRole.EDITOR)
                            .build()))
                    .roles(List.of(
                        UserRoleSpecification.builder()
                            .role(UserRole.ANSWER_MODERATOR)
                            .build(),
                        UserRoleSpecification.builder()
                            .role(UserRole.OWNER)
                            .build()))
                    .combinedAnswerText(StructuredTextMutableProperties.builder()
                        .text("From https://en.wikipedia.org/wiki/Diffuse_sky_radiation, the sky is blue because blue light is more strongly scattered than longer-wavelength light.")
                        .build())
                    .build())
                .call();

        if (res.answer().isPresent()) {
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
| `editAnswerRequest`                                                                                                      | [EditAnswerRequest](../../models/components/EditAnswerRequest.md)                                                        | :heavy_check_mark:                                                                                                       | EditAnswer request                                                                                                       |

### Response

**[EditanswerResponse](../../models/operations/EditanswerResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## get

Read the details of a particular Answer given its ID.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetAnswerRequest;
import com.glean.api_client.models.operations.GetanswerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetanswerResponse res = sdk.client().answers().get()
                .getAnswerRequest(GetAnswerRequest.builder()
                    .id(3L)
                    .docId("ANSWERS_answer_3")
                    .build())
                .call();

        if (res.getAnswerResponse().isPresent()) {
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
| `getAnswerRequest`                                                                                                       | [GetAnswerRequest](../../models/components/GetAnswerRequest.md)                                                          | :heavy_check_mark:                                                                                                       | GetAnswer request                                                                                                        |

### Response

**[GetanswerResponse](../../models/operations/GetanswerResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

List Answers created by the current user.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.ListAnswersRequest;
import com.glean.api_client.models.operations.ListanswersResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ListanswersResponse res = sdk.client().answers().list()
                .listAnswersRequest(ListAnswersRequest.builder()
                    .build())
                .call();

        if (res.listAnswersResponse().isPresent()) {
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
| `listAnswersRequest`                                                                                                     | [ListAnswersRequest](../../models/components/ListAnswersRequest.md)                                                      | :heavy_check_mark:                                                                                                       | ListAnswers request                                                                                                      |

### Response

**[ListanswersResponse](../../models/operations/ListanswersResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## preview

Generate a preview for a user-generated Answer that contains a question and answer.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.StructuredTextMutableProperties;
import com.glean.api_client.models.operations.PreviewanswerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PreviewanswerResponse res = sdk.client().answers().preview()
                .structuredTextMutableProperties(StructuredTextMutableProperties.builder()
                    .text("From https://en.wikipedia.org/wiki/Diffuse_sky_radiation, the sky is blue because blue light is more strongly scattered than longer-wavelength light.")
                    .build())
                .call();

        if (res.previewStructuredTextResponse().isPresent()) {
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
| `structuredTextMutableProperties`                                                                                        | [StructuredTextMutableProperties](../../models/components/StructuredTextMutableProperties.md)                            | :heavy_check_mark:                                                                                                       | PreviewAnswer request                                                                                                    |

### Response

**[PreviewanswerResponse](../../models/operations/PreviewanswerResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## previewDraft

Generate a preview for a user-generated answer from a draft.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.PreviewanswerdraftResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PreviewanswerdraftResponse res = sdk.client().answers().previewDraft()
                .previewUgcRequest(PreviewUgcRequest.builder()
                    .draft(UgcDraft.builder()
                        .announcement(AnnouncementMutableProperties.builder()
                            .body(StructuredText.builder()
                                .text("From https://en.wikipedia.org/wiki/Diffuse_sky_radiation, the sky is blue because blue light is more strongly scattered than longer-wavelength light.")
                                .structuredList(List.of())
                                .build())
                            .audienceFilters(List.of(
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
                        .answer(AnswerMutableProperties.builder()
                            .question("Why is the sky blue?")
                            .bodyText("From https://en.wikipedia.org/wiki/Diffuse_sky_radiation, the sky is blue because blue light is more strongly scattered than longer-wavelength light.")
                            .audienceFilters(List.of(
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
                            .addedRoles(List.of(
                                UserRoleSpecification.builder()
                                    .role(UserRole.ANSWER_MODERATOR)
                                    .person(Person.builder()
                                        .name("George Clooney")
                                        .obfuscatedId("abc123")
                                        .relatedDocuments(List.of())
                                        .metadata(PersonMetadata.builder()
                                            .type(PersonMetadataType.FULL_TIME)
                                            .title("Actor")
                                            .department("Movies")
                                            .email("george@example.com")
                                            .location("Hollywood, CA")
                                            .managementChain(List.of())
                                            .phone("6505551234")
                                            .photoUrl("https://example.com/george.jpg")
                                            .reports(List.of())
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
                                    .build()))
                            .removedRoles(List.of(
                                UserRoleSpecification.builder()
                                    .role(UserRole.OWNER)
                                    .build(),
                                UserRoleSpecification.builder()
                                    .role(UserRole.VIEWER)
                                    .build(),
                                UserRoleSpecification.builder()
                                    .role(UserRole.OWNER)
                                    .build()))
                            .roles(List.of(
                                UserRoleSpecification.builder()
                                    .role(UserRole.VIEWER)
                                    .build(),
                                UserRoleSpecification.builder()
                                    .role(UserRole.VIEWER)
                                    .build(),
                                UserRoleSpecification.builder()
                                    .role(UserRole.OWNER)
                                    .build()))
                            .build())
                        .build())
                    .build())
                .call();

        if (res.previewUgcResponse().isPresent()) {
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
| `previewUgcRequest`                                                                                                      | [PreviewUgcRequest](../../models/components/PreviewUgcRequest.md)                                                        | :heavy_check_mark:                                                                                                       | preview answer request                                                                                                   |

### Response

**[PreviewanswerdraftResponse](../../models/operations/PreviewanswerdraftResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## updateLikes

Update the likes for an existing user-generated Answer. Examples are liking or unliking the Answer.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.UpdateAnswerLikesRequest;
import com.glean.api_client.models.components.UpdateAnswerLikesRequestAction;
import com.glean.api_client.models.operations.UpdateanswerlikesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UpdateanswerlikesResponse res = sdk.client().answers().updateLikes()
                .updateAnswerLikesRequest(UpdateAnswerLikesRequest.builder()
                    .answerId(3L)
                    .action(UpdateAnswerLikesRequestAction.LIKE)
                    .answerDocId("ANSWERS_answer_3")
                    .build())
                .call();

        if (res.updateAnswerLikesResponse().isPresent()) {
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
| `updateAnswerLikesRequest`                                                                                               | [UpdateAnswerLikesRequest](../../models/components/UpdateAnswerLikesRequest.md)                                          | :heavy_check_mark:                                                                                                       | UpdateAnswerLikes request                                                                                                |

### Response

**[UpdateanswerlikesResponse](../../models/operations/UpdateanswerlikesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## ~~createBoard~~

Create a board of Answers.

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.CreateanswerboardResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateanswerboardResponse res = sdk.client().answers().createBoard()
                .collectionBaseMutableProperties(CollectionBaseMutableProperties.builder()
                    .name("<value>")
                    .addedRoles(List.of(
                        UserRoleSpecification.builder()
                            .role(UserRole.ANSWER_MODERATOR)
                            .person(Person.builder()
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
                            .build(),
                        UserRoleSpecification.builder()
                            .role(UserRole.OWNER)
                            .build()))
                    .removedRoles(List.of(
                        UserRoleSpecification.builder()
                            .role(UserRole.ANSWER_MODERATOR)
                            .build()))
                    .audienceFilters(List.of(
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
                .call();

        if (res.createAnswerBoardResponse().isPresent()) {
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
| `collectionBaseMutableProperties`                                                                                        | [CollectionBaseMutableProperties](../../models/components/CollectionBaseMutableProperties.md)                            | :heavy_check_mark:                                                                                                       | Answer Board content plus any additional metadata for the request.                                                       |

### Response

**[CreateanswerboardResponse](../../models/operations/CreateanswerboardResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## ~~deleteBoard~~

Delete an Answer Board given the Answer Board's ID. Multi-delete is not currently supported.

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteAnswerBoardsRequest;
import com.glean.api_client.models.operations.DeleteanswerboardsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteanswerboardsResponse res = sdk.client().answers().deleteBoard()
                .deleteAnswerBoardsRequest(DeleteAnswerBoardsRequest.builder()
                    .ids(List.of(
                        983393L))
                    .build())
                .call();

        if (res.deleteAnswerBoardsResponse().isPresent()) {
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
| `deleteAnswerBoardsRequest`                                                                                              | [DeleteAnswerBoardsRequest](../../models/components/DeleteAnswerBoardsRequest.md)                                        | :heavy_check_mark:                                                                                                       | DeleteAnswerBoards request                                                                                               |

### Response

**[DeleteanswerboardsResponse](../../models/operations/DeleteanswerboardsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## ~~updateBoard~~

Modifies the properties of an existing Answer Board.

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.EditanswerboardResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        EditanswerboardResponse res = sdk.client().answers().updateBoard()
                .editAnswerBoardRequest(EditAnswerBoardRequest.builder()
                    .name("<value>")
                    .id(892222L)
                    .addedRoles(List.of(
                        UserRoleSpecification.builder()
                            .role(UserRole.EDITOR)
                            .person(Person.builder()
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
                            .build()))
                    .removedRoles(List.of(
                        UserRoleSpecification.builder()
                            .role(UserRole.VIEWER)
                            .build()))
                    .audienceFilters(List.of(
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
                .call();

        if (res.editAnswerBoardResponse().isPresent()) {
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
| `editAnswerBoardRequest`                                                                                                 | [EditAnswerBoardRequest](../../models/components/EditAnswerBoardRequest.md)                                              | :heavy_check_mark:                                                                                                       | Answer Board content plus any additional metadata for the request.                                                       |

### Response

**[EditanswerboardResponse](../../models/operations/EditanswerboardResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## ~~getBoard~~

Read the details of an Answer Board given its ID. Does not fetch items in this Answer Board, use /listanswers instead.

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetAnswerBoardRequest;
import com.glean.api_client.models.operations.GetanswerboardResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetanswerboardResponse res = sdk.client().answers().getBoard()
                .getAnswerBoardRequest(GetAnswerBoardRequest.builder()
                    .id(643179L)
                    .build())
                .call();

        if (res.getAnswerBoardResponse().isPresent()) {
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
| `getAnswerBoardRequest`                                                                                                  | [GetAnswerBoardRequest](../../models/components/GetAnswerBoardRequest.md)                                                | :heavy_check_mark:                                                                                                       | GetAnswerBoard request                                                                                                   |

### Response

**[GetanswerboardResponse](../../models/operations/GetanswerboardResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## ~~listBoards~~

List all existing Answer Boards

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.ListAnswerBoardsRequest;
import com.glean.api_client.models.operations.ListanswerboardsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ListanswerboardsResponse res = sdk.client().answers().listBoards()
                .listAnswerBoardsRequest(ListAnswerBoardsRequest.builder()
                    .build())
                .call();

        if (res.listAnswerBoardsResponse().isPresent()) {
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
| `listAnswerBoardsRequest`                                                                                                | [ListAnswerBoardsRequest](../../models/components/ListAnswerBoardsRequest.md)                                            | :heavy_check_mark:                                                                                                       | ListAnswerBoards request                                                                                                 |

### Response

**[ListanswerboardsResponse](../../models/operations/ListanswerboardsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |