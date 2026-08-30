# Skills

## Overview

### Available Operations

* [create](#create) - Create skill
* [list](#list) - List skills
* [import_](#import_) - Import skills from GitHub
* [validate](#validate) - Validate skill bundle
* [previewSource](#previewsource) - Preview a GitHub skill source
* [update](#update) - Update skill
* [delete](#delete) - Delete skill
* [retrieve](#retrieve) - Retrieve skill
* [retrieveContent](#retrievecontent) - Download skill content
* [sync](#sync) - Sync a GitHub-imported skill
* [createVersion](#createversion) - Create skill version
* [listVersions](#listversions) - List skill versions
* [retrieveVersion](#retrieveversion) - Retrieve skill version
* [retrieveVersionContent](#retrieveversioncontent) - Download skill version content

## create

Create a skill from an uploaded SKILL.md, .zip, or .skill bundle. If the authenticated user already has a skill with the same name, the existing skill is superseded with a new version.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-create" method="post" path="/api/skills" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.PlatformSkillCreateRequest;
import com.glean.api_client.glean_api_client.models.components.PlatformSkillCreateRequestFile;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsCreateResponse;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.io.FileInputStream;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillCreateRequest req = PlatformSkillCreateRequest.builder()
                .file(PlatformSkillCreateRequestFile.builder()
                    .fileName("example.file")
                    .content(Utils.readBytesAndClose(new FileInputStream("example.file")))
                    .build())
                .build();

        PlatformSkillsCreateResponse res = sdk.skills().create()
                .request(req)
                .call();

    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [PlatformSkillCreateRequest](../../models/shared/PlatformSkillCreateRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[PlatformSkillsCreateResponse](../../models/operations/PlatformSkillsCreateResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 413, 429            | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## list

List skills available to the authenticated user.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-list" method="get" path="/api/skills" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillsListResponse res = sdk.skills().list()
                .call();

        if (res.platformSkillsListResponse().isPresent()) {
            System.out.println(res.platformSkillsListResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                          | Type                                               | Required                                           | Description                                        |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| `pageSize`                                         | *Optional\<Long>*                                  | :heavy_minus_sign:                                 | Maximum number of skills to return.                |
| `cursor`                                           | *Optional\<String>*                                | :heavy_minus_sign:                                 | Opaque pagination cursor from a previous response. |

### Response

**[PlatformSkillsListResponse](../../models/operations/PlatformSkillsListResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## import_

Import one or more skills selected from a GitHub source preview. Each source URL is fetched and persisted as an independent skill with source provenance. This operation does not create a durable source resource. The import is atomic: if any source cannot be fetched, validated, or persisted, no skills are created.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-import" method="post" path="/api/skills/import" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.PlatformSkillImportRequest;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsImportResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillImportRequest req = PlatformSkillImportRequest.builder()
                .sourceUrls(List.of(
                    "https://github.com/anthropics/skills/tree/main/skills/skill-creator"))
                .build();

        PlatformSkillsImportResponse res = sdk.skills().import_()
                .request(req)
                .call();

        if (res.platformSkillImportResponse().isPresent()) {
            System.out.println(res.platformSkillImportResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [PlatformSkillImportRequest](../../models/shared/PlatformSkillImportRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[PlatformSkillsImportResponse](../../models/operations/PlatformSkillsImportResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 408, 409, 413, 429            | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## validate

Validate a skill bundle without persisting it. Accepts a SKILL.md, .zip, or .skill upload and returns parsed metadata plus the normalized file layout.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-validate" method="post" path="/api/skills/validation" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.PlatformSkillValidationRequest;
import com.glean.api_client.glean_api_client.models.components.PlatformSkillValidationRequestFile;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsValidateResponse;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.io.FileInputStream;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillValidationRequest req = PlatformSkillValidationRequest.builder()
                .file(PlatformSkillValidationRequestFile.builder()
                    .fileName("example.file")
                    .content(Utils.readBytesAndClose(new FileInputStream("example.file")))
                    .build())
                .build();

        PlatformSkillsValidateResponse res = sdk.skills().validate()
                .request(req)
                .call();

    }
}
```

### Parameters

| Parameter                                                                               | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `request`                                                                               | [PlatformSkillValidationRequest](../../models/shared/PlatformSkillValidationRequest.md) | :heavy_check_mark:                                                                      | The request object to use for the request.                                              |

### Response

**[PlatformSkillsValidateResponse](../../models/operations/PlatformSkillsValidateResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 413, 429            | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## previewSource

Inspect a GitHub URL without persisting a source or any discovered skills. Set stream to true to receive repository scan progress as server-sent events; otherwise the response contains the completed preview.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-preview-source" method="post" path="/api/skills/sources/preview" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.PlatformSkillSourcePreviewRequest;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsPreviewSourceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillSourcePreviewRequest req = PlatformSkillSourcePreviewRequest.builder()
                .sourceUrl("https://github.com/anthropics/skills")
                .build();

        PlatformSkillsPreviewSourceResponse res = sdk.skills().previewSource()
                .request(req)
                .call();

        if (res.platformSkillSourcePreviewResponse().isPresent()) {
            System.out.println(res.platformSkillSourcePreviewResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                     | Type                                                                                          | Required                                                                                      | Description                                                                                   |
| --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| `request`                                                                                     | [PlatformSkillSourcePreviewRequest](../../models/shared/PlatformSkillSourcePreviewRequest.md) | :heavy_check_mark:                                                                            | The request object to use for the request.                                                    |

### Response

**[PlatformSkillsPreviewSourceResponse](../../models/operations/PlatformSkillsPreviewSourceResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 408, 413, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## update

Update mutable metadata for a skill. V1 supports enabling or disabling a skill without changing its content.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-update" method="patch" path="/api/skills/{skill_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.PlatformSkillUpdateRequest;
import com.glean.api_client.glean_api_client.models.components.PlatformSkillUpdateStatus;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsUpdateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillsUpdateResponse res = sdk.skills().update()
                .skillId("<id>")
                .platformSkillUpdateRequest(PlatformSkillUpdateRequest.builder()
                    .status(PlatformSkillUpdateStatus.ENABLED)
                    .build())
                .call();

        if (res.platformSkillUpdateResponse().isPresent()) {
            System.out.println(res.platformSkillUpdateResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                           | Type                                                                                | Required                                                                            | Description                                                                         | Example                                                                             |
| ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `skillId`                                                                           | *String*                                                                            | :heavy_check_mark:                                                                  | Glean skill ID.                                                                     |                                                                                     |
| `platformSkillUpdateRequest`                                                        | [PlatformSkillUpdateRequest](../../models/components/PlatformSkillUpdateRequest.md) | :heavy_check_mark:                                                                  | N/A                                                                                 | {<br/>"status": "ENABLED"<br/>}                                                     |

### Response

**[PlatformSkillsUpdateResponse](../../models/operations/PlatformSkillsUpdateResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 409, 413, 429       | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## delete

Delete a skill the authenticated caller is allowed to manage. This operation permanently removes all versions of the skill.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-delete" method="delete" path="/api/skills/{skill_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsDeleteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillsDeleteResponse res = sdk.skills().delete()
                .skillId("<id>")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter          | Type               | Required           | Description        |
| ------------------ | ------------------ | ------------------ | ------------------ |
| `skillId`          | *String*           | :heavy_check_mark: | Glean skill ID.    |

### Response

**[PlatformSkillsDeleteResponse](../../models/operations/PlatformSkillsDeleteResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## retrieve

Retrieve metadata for a skill available to the authenticated user.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-get" method="get" path="/api/skills/{skill_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillsGetResponse res = sdk.skills().retrieve()
                .skillId("<id>")
                .call();

        if (res.platformSkillGetResponse().isPresent()) {
            System.out.println(res.platformSkillGetResponse().get());
        }
    }
}
```

### Parameters

| Parameter          | Type               | Required           | Description        |
| ------------------ | ------------------ | ------------------ | ------------------ |
| `skillId`          | *String*           | :heavy_check_mark: | Glean skill ID.    |

### Response

**[PlatformSkillsGetResponse](../../models/operations/PlatformSkillsGetResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## retrieveContent

Download the latest installable bundle for a skill available to the authenticated user.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-get-content" method="get" path="/api/skills/{skill_id}/content" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsGetContentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillsGetContentResponse res = sdk.skills().retrieveContent()
                .skillId("<id>")
                .call();

        if (res.responseStream().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter          | Type               | Required           | Description        |
| ------------------ | ------------------ | ------------------ | ------------------ |
| `skillId`          | *String*           | :heavy_check_mark: | Glean skill ID.    |

### Response

**[PlatformSkillsGetContentResponse](../../models/operations/PlatformSkillsGetContentResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## sync

Refresh one GitHub-imported skill from its stored source URL. If the skill content has changed, this operation creates a new skill version. If the skill is no longer present upstream, the stored skill is left unchanged and must be deleted explicitly.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-sync" method="post" path="/api/skills/{skill_id}/sync" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsSyncResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillsSyncResponse res = sdk.skills().sync()
                .skillId("<id>")
                .call();

        if (res.platformSkillSyncResponse().isPresent()) {
            System.out.println(res.platformSkillSyncResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                | Type                                     | Required                                 | Description                              |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| `skillId`                                | *String*                                 | :heavy_check_mark:                       | ID of the GitHub-imported skill to sync. |

### Response

**[PlatformSkillsSyncResponse](../../models/operations/PlatformSkillsSyncResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 409, 413, 429       | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## createVersion

Create a new immutable version for an existing caller-managed skill from an uploaded SKILL.md, .zip, or .skill bundle.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-create-version" method="post" path="/api/skills/{skill_id}/versions" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.PlatformSkillVersionCreateRequest;
import com.glean.api_client.glean_api_client.models.components.PlatformSkillVersionCreateRequestFile;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsCreateVersionResponse;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.io.FileInputStream;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillsCreateVersionResponse res = sdk.skills().createVersion()
                .skillId("<id>")
                .platformSkillVersionCreateRequest(PlatformSkillVersionCreateRequest.builder()
                    .file(PlatformSkillVersionCreateRequestFile.builder()
                        .fileName("example.file")
                        .content(Utils.readBytesAndClose(new FileInputStream("example.file")))
                        .build())
                    .build())
                .call();

    }
}
```

### Parameters

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `skillId`                                                                                         | *String*                                                                                          | :heavy_check_mark:                                                                                | Glean skill ID.                                                                                   |
| `platformSkillVersionCreateRequest`                                                               | [PlatformSkillVersionCreateRequest](../../models/components/PlatformSkillVersionCreateRequest.md) | :heavy_check_mark:                                                                                | N/A                                                                                               |

### Response

**[PlatformSkillsCreateVersionResponse](../../models/operations/PlatformSkillsCreateVersionResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 409, 413, 429       | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## listVersions

List versions for a skill available to the authenticated user.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-list-versions" method="get" path="/api/skills/{skill_id}/versions" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsListVersionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillsListVersionsResponse res = sdk.skills().listVersions()
                .skillId("<id>")
                .call();

        if (res.platformSkillVersionsListResponse().isPresent()) {
            System.out.println(res.platformSkillVersionsListResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                          | Type                                               | Required                                           | Description                                        |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| `skillId`                                          | *String*                                           | :heavy_check_mark:                                 | Glean skill ID.                                    |
| `pageSize`                                         | *Optional\<Long>*                                  | :heavy_minus_sign:                                 | Maximum number of versions to return.              |
| `cursor`                                           | *Optional\<String>*                                | :heavy_minus_sign:                                 | Opaque pagination cursor from a previous response. |

### Response

**[PlatformSkillsListVersionsResponse](../../models/operations/PlatformSkillsListVersionsResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## retrieveVersion

Retrieve metadata for a skill version available to the authenticated user.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-get-version" method="get" path="/api/skills/{skill_id}/versions/{version}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsGetVersionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillsGetVersionResponse res = sdk.skills().retrieveVersion()
                .skillId("<id>")
                .version(495658L)
                .call();

        if (res.platformSkillVersionGetResponse().isPresent()) {
            System.out.println(res.platformSkillVersionGetResponse().get());
        }
    }
}
```

### Parameters

| Parameter             | Type                  | Required              | Description           |
| --------------------- | --------------------- | --------------------- | --------------------- |
| `skillId`             | *String*              | :heavy_check_mark:    | Glean skill ID.       |
| `version`             | *long*                | :heavy_check_mark:    | Major version number. |

### Response

**[PlatformSkillsGetVersionResponse](../../models/operations/PlatformSkillsGetVersionResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## retrieveVersionContent

Download the installable bundle for a skill version available to the authenticated user.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-skills-get-version-content" method="get" path="/api/skills/{skill_id}/versions/{version}/content" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformSkillsGetVersionContentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformSkillsGetVersionContentResponse res = sdk.skills().retrieveVersionContent()
                .skillId("<id>")
                .version(117760L)
                .call();

        if (res.responseStream().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter             | Type                  | Required              | Description           |
| --------------------- | --------------------- | --------------------- | --------------------- |
| `skillId`             | *String*              | :heavy_check_mark:    | Glean skill ID.       |
| `version`             | *long*                | :heavy_check_mark:    | Major version number. |

### Response

**[PlatformSkillsGetVersionContentResponse](../../models/operations/PlatformSkillsGetVersionContentResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |