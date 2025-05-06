# Answers
(*client().answers()*)

## Overview

### Available Operations

* [create](#create) - Create Answer
* [delete](#delete) - Delete Answer
* [update](#update) - Update Answer
* [retrieve](#retrieve) - Read Answer
* [list](#list) - List Answers

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

        CreateAnswerRequest req = CreateAnswerRequest.builder()
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
                .build();

        CreateanswerResponse res = sdk.client().answers().create()
                .request(req)
                .call();

        if (res.answer().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [CreateAnswerRequest](../../models/shared/CreateAnswerRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

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

        DeleteAnswerRequest req = DeleteAnswerRequest.builder()
                .id(3L)
                .docId("ANSWERS_answer_3")
                .build();

        DeleteanswerResponse res = sdk.client().answers().delete()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [DeleteAnswerRequest](../../models/shared/DeleteAnswerRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[DeleteanswerResponse](../../models/operations/DeleteanswerResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## update

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

        EditAnswerRequest req = EditAnswerRequest.builder()
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
                .build();

        EditanswerResponse res = sdk.client().answers().update()
                .request(req)
                .call();

        if (res.answer().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `request`                                                     | [EditAnswerRequest](../../models/shared/EditAnswerRequest.md) | :heavy_check_mark:                                            | The request object to use for the request.                    |

### Response

**[EditanswerResponse](../../models/operations/EditanswerResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## retrieve

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

        GetAnswerRequest req = GetAnswerRequest.builder()
                .id(3L)
                .docId("ANSWERS_answer_3")
                .build();

        GetanswerResponse res = sdk.client().answers().retrieve()
                .request(req)
                .call();

        if (res.getAnswerResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                   | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `request`                                                   | [GetAnswerRequest](../../models/shared/GetAnswerRequest.md) | :heavy_check_mark:                                          | The request object to use for the request.                  |

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

        ListAnswersRequest req = ListAnswersRequest.builder()
                .build();

        ListanswersResponse res = sdk.client().answers().list()
                .request(req)
                .call();

        if (res.listAnswersResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                       | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `request`                                                       | [ListAnswersRequest](../../models/shared/ListAnswersRequest.md) | :heavy_check_mark:                                              | The request object to use for the request.                      |

### Response

**[ListanswersResponse](../../models/operations/ListanswersResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |