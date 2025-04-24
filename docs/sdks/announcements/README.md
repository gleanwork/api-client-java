# Announcements
(*client().announcements()*)

## Overview

### Available Operations

* [create](#create) - Create Announcement
* [createDraft](#createdraft) - Create draft Announcement
* [delete](#delete) - Delete Announcement
* [deleteDraft](#deletedraft) - Delete draft Announcement
* [get](#get) - Read Announcement
* [getDraft](#getdraft) - Read draft Announcement
* [list](#list) - List Announcements
* [preview](#preview) - Preview Announcement
* [previewDraft](#previewdraft) - Preview draft Announcement
* [publish](#publish) - Publish draft Announcement
* [unpublish](#unpublish) - Unpublish Announcement
* [update](#update) - Update Announcement
* [updateDraft](#updatedraft) - Update draft Announcement

## create

Create a textual announcement visible to some set of users based on department and location.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.CreateannouncementResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateannouncementResponse res = sdk.client().announcements().create()
                .createAnnouncementRequest(CreateAnnouncementRequest.builder()
                    .startTime(OffsetDateTime.parse("2024-06-17T07:14:55.338Z"))
                    .endTime(OffsetDateTime.parse("2024-11-30T17:06:07.804Z"))
                    .title("<value>")
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
                .call();

        if (res.announcement().isPresent()) {
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
| `createAnnouncementRequest`                                                                                              | [CreateAnnouncementRequest](../../models/components/CreateAnnouncementRequest.md)                                        | :heavy_check_mark:                                                                                                       | Announcement content                                                                                                     |

### Response

**[CreateannouncementResponse](../../models/operations/CreateannouncementResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## createDraft

Create a draft of a textual announcement visible to some set of users based on department and location.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.CreatedraftannouncementResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreatedraftannouncementResponse res = sdk.client().announcements().createDraft()
                .createDraftAnnouncementRequest(CreateDraftAnnouncementRequest.builder()
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
                .call();

        if (res.announcement().isPresent()) {
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
| `createDraftAnnouncementRequest`                                                                                         | [CreateDraftAnnouncementRequest](../../models/components/CreateDraftAnnouncementRequest.md)                              | :heavy_check_mark:                                                                                                       | Draft announcement content                                                                                               |

### Response

**[CreatedraftannouncementResponse](../../models/operations/CreatedraftannouncementResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## delete

Delete an existing user-generated announcement.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteAnnouncementRequest;
import com.glean.api_client.models.operations.DeleteannouncementResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteannouncementResponse res = sdk.client().announcements().delete()
                .deleteAnnouncementRequest(DeleteAnnouncementRequest.builder()
                    .id(545907L)
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
| `deleteAnnouncementRequest`                                                                                              | [DeleteAnnouncementRequest](../../models/components/DeleteAnnouncementRequest.md)                                        | :heavy_check_mark:                                                                                                       | Delete announcement request                                                                                              |

### Response

**[DeleteannouncementResponse](../../models/operations/DeleteannouncementResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## deleteDraft

Delete an existing user-generated draft Announcement.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.DeleteAnnouncementRequest;
import com.glean.api_client.models.operations.DeletedraftannouncementResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeletedraftannouncementResponse res = sdk.client().announcements().deleteDraft()
                .deleteAnnouncementRequest(DeleteAnnouncementRequest.builder()
                    .id(171443L)
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
| `deleteAnnouncementRequest`                                                                                              | [DeleteAnnouncementRequest](../../models/components/DeleteAnnouncementRequest.md)                                        | :heavy_check_mark:                                                                                                       | Delete draft announcement request                                                                                        |

### Response

**[DeletedraftannouncementResponse](../../models/operations/DeletedraftannouncementResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## get

Read the details of an Announcement given its ID.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetAnnouncementRequest;
import com.glean.api_client.models.operations.GetannouncementResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetannouncementResponse res = sdk.client().announcements().get()
                .getAnnouncementRequest(GetAnnouncementRequest.builder()
                    .id(700347L)
                    .build())
                .call();

        if (res.getAnnouncementResponse().isPresent()) {
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
| `getAnnouncementRequest`                                                                                                 | [GetAnnouncementRequest](../../models/components/GetAnnouncementRequest.md)                                              | :heavy_check_mark:                                                                                                       | GetAnnouncement request                                                                                                  |

### Response

**[GetannouncementResponse](../../models/operations/GetannouncementResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getDraft

Read the details of an existing user-generated draft Announcement.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.GetAnnouncementRequest;
import com.glean.api_client.models.operations.GetdraftannouncementResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetdraftannouncementResponse res = sdk.client().announcements().getDraft()
                .getAnnouncementRequest(GetAnnouncementRequest.builder()
                    .id(476509L)
                    .build())
                .call();

        if (res.getDraftAnnouncementResponse().isPresent()) {
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
| `getAnnouncementRequest`                                                                                                 | [GetAnnouncementRequest](../../models/components/GetAnnouncementRequest.md)                                              | :heavy_check_mark:                                                                                                       | Get draft announcement request                                                                                           |

### Response

**[GetdraftannouncementResponse](../../models/operations/GetdraftannouncementResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

List Announcement details for all Announcements matching the given criteria.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.ListAnnouncementsRequest;
import com.glean.api_client.models.operations.ListannouncementsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ListannouncementsResponse res = sdk.client().announcements().list()
                .listAnnouncementsRequest(ListAnnouncementsRequest.builder()
                    .build())
                .call();

        if (res.listAnnouncementsResponse().isPresent()) {
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
| `listAnnouncementsRequest`                                                                                               | [ListAnnouncementsRequest](../../models/components/ListAnnouncementsRequest.md)                                          | :heavy_check_mark:                                                                                                       | Includes request params for querying announcements.                                                                      |

### Response

**[ListannouncementsResponse](../../models/operations/ListannouncementsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## preview

Generate a preview for a user-generated Announcement from structured text.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.StructuredTextMutableProperties;
import com.glean.api_client.models.operations.PreviewannouncementResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PreviewannouncementResponse res = sdk.client().announcements().preview()
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
| `structuredTextMutableProperties`                                                                                        | [StructuredTextMutableProperties](../../models/components/StructuredTextMutableProperties.md)                            | :heavy_check_mark:                                                                                                       | preview structured text request                                                                                          |

### Response

**[PreviewannouncementResponse](../../models/operations/PreviewannouncementResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## previewDraft

Generates a preview for a user-generated Announcement from a draft.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.PreviewannouncementdraftResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PreviewannouncementdraftResponse res = sdk.client().announcements().previewDraft()
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
| `previewUgcRequest`                                                                                                      | [PreviewUgcRequest](../../models/components/PreviewUgcRequest.md)                                                        | :heavy_check_mark:                                                                                                       | preview announcement request                                                                                             |

### Response

**[PreviewannouncementdraftResponse](../../models/operations/PreviewannouncementdraftResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## publish

Promote a draft Announcement to be visible to others.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.PublishDraftAnnouncementRequest;
import com.glean.api_client.models.operations.PublishdraftannouncementResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PublishdraftannouncementResponse res = sdk.client().announcements().publish()
                .publishDraftAnnouncementRequest(PublishDraftAnnouncementRequest.builder()
                    .id(876134L)
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
| `publishDraftAnnouncementRequest`                                                                                        | [PublishDraftAnnouncementRequest](../../models/components/PublishDraftAnnouncementRequest.md)                            | :heavy_check_mark:                                                                                                       | Publish draft announcement content.                                                                                      |

### Response

**[PublishdraftannouncementResponse](../../models/operations/PublishdraftannouncementResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## unpublish

Unpublish an Announcement to hide it from users.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.UnpublishAnnouncementRequest;
import com.glean.api_client.models.operations.UnpublishannouncementResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UnpublishannouncementResponse res = sdk.client().announcements().unpublish()
                .unpublishAnnouncementRequest(UnpublishAnnouncementRequest.builder()
                    .id(195182L)
                    .build())
                .call();

        if (res.announcement().isPresent()) {
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
| `unpublishAnnouncementRequest`                                                                                           | [UnpublishAnnouncementRequest](../../models/components/UnpublishAnnouncementRequest.md)                                  | :heavy_check_mark:                                                                                                       | Unpublish announcement content.                                                                                          |

### Response

**[UnpublishannouncementResponse](../../models/operations/UnpublishannouncementResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## update

Update a textual announcement visible to some set of users based on department and location.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.UpdateannouncementResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UpdateannouncementResponse res = sdk.client().announcements().update()
                .updateAnnouncementRequest(UpdateAnnouncementRequest.builder()
                    .startTime(OffsetDateTime.parse("2025-07-28T19:04:48.565Z"))
                    .endTime(OffsetDateTime.parse("2024-10-16T10:52:42.015Z"))
                    .title("<value>")
                    .id(761625L)
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
                .call();

        if (res.announcement().isPresent()) {
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
| `updateAnnouncementRequest`                                                                                              | [UpdateAnnouncementRequest](../../models/components/UpdateAnnouncementRequest.md)                                        | :heavy_check_mark:                                                                                                       | Announcement content. Id need to be specified for the announcement.                                                      |

### Response

**[UpdateannouncementResponse](../../models/operations/UpdateannouncementResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## updateDraft

Update a textual Announcement visible to some set of users based on department and location.

### Example Usage

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.UpdatedraftannouncementResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UpdatedraftannouncementResponse res = sdk.client().announcements().updateDraft()
                .updateDraftAnnouncementRequest(UpdateDraftAnnouncementRequest.builder()
                    .draftId(758103L)
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
                .call();

        if (res.announcement().isPresent()) {
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
| `updateDraftAnnouncementRequest`                                                                                         | [UpdateDraftAnnouncementRequest](../../models/components/UpdateDraftAnnouncementRequest.md)                              | :heavy_check_mark:                                                                                                       | Draft announcement content. DraftId needs to be specified.                                                               |

### Response

**[UpdatedraftannouncementResponse](../../models/operations/UpdatedraftannouncementResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |