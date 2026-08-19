# Triggers

## Overview

### Available Operations

* [create](#create) - Create trigger
* [list](#list) - List triggers
* [get](#get) - Get trigger
* [update](#update) - Update trigger
* [delete](#delete) - Delete trigger
* [searchEvents](#searchevents) - Search events for a trigger
* [listPresets](#listpresets) - List trigger presets
* [getPreset](#getpreset) - Get trigger preset
* [listPresetInputValues](#listpresetinputvalues) - Search trigger preset input values
* [searchPresetEvents](#searchpresetevents) - Search events for a trigger preset

## create

Create a trigger from a preset and return it with its signing secret.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-triggers-create" method="post" path="/api/triggers" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformTriggersCreateResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformTriggerCreateRequest req = PlatformTriggerCreateRequest.builder()
                .presetId("jira_high_priority_bug")
                .delivery(PlatformTriggerDelivery.builder()
                    .webhookUrl("https://customer.app/webhook")
                    .auth(PlatformTriggerAuth.builder()
                        .type(PlatformTriggerAuthType.BEARER)
                        .secret("a8f5f167f44f4964e6c998dee827110c")
                        .build())
                    .build())
                .description("High-priority Jira bugs in the Engineering project")
                .inputs(Map.ofEntries(
                    Map.entry("project", "ENG")))
                .build();

        PlatformTriggersCreateResponse res = sdk.triggers().create()
                .request(req)
                .call();

        if (res.platformTriggerCreateResponse().isPresent()) {
            System.out.println(res.platformTriggerCreateResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                           | Type                                                                                | Required                                                                            | Description                                                                         |
| ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `request`                                                                           | [PlatformTriggerCreateRequest](../../models/shared/PlatformTriggerCreateRequest.md) | :heavy_check_mark:                                                                  | The request object to use for the request.                                          |

### Response

**[PlatformTriggersCreateResponse](../../models/operations/PlatformTriggersCreateResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 409, 413, 429       | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## list

List triggers owned by the authenticated caller.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-triggers-list" method="get" path="/api/triggers" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformTriggersListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformTriggersListResponse res = sdk.triggers().list()
                .pageSize(50L)
                .call();

        if (res.platformTriggerListResponse().isPresent()) {
            System.out.println(res.platformTriggerListResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                          | Type                                               | Required                                           | Description                                        |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| `pageSize`                                         | *Optional\<Long>*                                  | :heavy_minus_sign:                                 | Maximum number of triggers to return.              |
| `cursor`                                           | *Optional\<String>*                                | :heavy_minus_sign:                                 | Opaque pagination cursor from a previous response. |

### Response

**[PlatformTriggersListResponse](../../models/operations/PlatformTriggersListResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 408, 429                      | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## get

Retrieve a trigger owned by the authenticated caller.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-triggers-get" method="get" path="/api/triggers/{trigger_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformTriggersGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformTriggersGetResponse res = sdk.triggers().get()
                .triggerId("<id>")
                .call();

        if (res.platformTriggerGetResponse().isPresent()) {
            System.out.println(res.platformTriggerGetResponse().get());
        }
    }
}
```

### Parameters

| Parameter                      | Type                           | Required                       | Description                    |
| ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ |
| `triggerId`                    | *String*                       | :heavy_check_mark:             | ID of the trigger to retrieve. |

### Response

**[PlatformTriggersGetResponse](../../models/operations/PlatformTriggersGetResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## update

Update a trigger.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-triggers-update" method="patch" path="/api/triggers/{trigger_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformTriggersUpdateResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformTriggersUpdateResponse res = sdk.triggers().update()
                .triggerId("<id>")
                .platformTriggerUpdateRequest(PlatformTriggerUpdateRequest.builder()
                    .status(PlatformTriggerStatus.ENABLED)
                    .description("High-priority Jira bugs in the Engineering project")
                    .inputs(Map.ofEntries(
                        Map.entry("project", "ENG")))
                    .delivery(PlatformTriggerDelivery.builder()
                        .webhookUrl("https://customer.app/webhook")
                        .auth(PlatformTriggerAuth.builder()
                            .type(PlatformTriggerAuthType.BEARER)
                            .secret("a8f5f167f44f4964e6c998dee827110c")
                            .build())
                        .build())
                    .build())
                .call();

        if (res.platformTriggerGetResponse().isPresent()) {
            System.out.println(res.platformTriggerGetResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                               | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `triggerId`                                                                             | *String*                                                                                | :heavy_check_mark:                                                                      | ID of the trigger to update.                                                            |
| `platformTriggerUpdateRequest`                                                          | [PlatformTriggerUpdateRequest](../../models/components/PlatformTriggerUpdateRequest.md) | :heavy_check_mark:                                                                      | N/A                                                                                     |

### Response

**[PlatformTriggersUpdateResponse](../../models/operations/PlatformTriggersUpdateResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 413, 429            | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## delete

Delete a trigger.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-triggers-delete" method="delete" path="/api/triggers/{trigger_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformTriggersDeleteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformTriggersDeleteResponse res = sdk.triggers().delete()
                .triggerId("<id>")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                    | Type                         | Required                     | Description                  |
| ---------------------------- | ---------------------------- | ---------------------------- | ---------------------------- |
| `triggerId`                  | *String*                     | :heavy_check_mark:           | ID of the trigger to delete. |

### Response

**[PlatformTriggersDeleteResponse](../../models/operations/PlatformTriggersDeleteResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## searchEvents

Search recent content events an existing trigger matches. Read-only — no webhook delivery is made. Covers the last seven days.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-triggers-events-search" method="post" path="/api/triggers/{trigger_id}/events/search" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformTriggersEventsSearchResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformTriggersEventsSearchResponse res = sdk.triggers().searchEvents()
                .triggerId("<id>")
                .call();

        if (res.platformTriggerEventSearchResponse().isPresent()) {
            System.out.println(res.platformTriggerEventSearchResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                    | Type                                                                                                         | Required                                                                                                     | Description                                                                                                  |
| ------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------ |
| `triggerId`                                                                                                  | *String*                                                                                                     | :heavy_check_mark:                                                                                           | ID of the trigger whose events to search.                                                                    |
| `platformTriggerEventSearchRequest`                                                                          | [Optional\<PlatformTriggerEventSearchRequest>](../../models/components/PlatformTriggerEventSearchRequest.md) | :heavy_minus_sign:                                                                                           | N/A                                                                                                          |

### Response

**[PlatformTriggersEventsSearchResponse](../../models/operations/PlatformTriggersEventsSearchResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 413, 429            | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## listPresets

List the trigger presets available to the caller. A preset is a curated content-trigger template (e.g. a new Jira ticket) which is passed when creating a trigger.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-trigger-presets-list" method="get" path="/api/trigger-presets" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformTriggerPresetsListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformTriggerPresetsListResponse res = sdk.triggers().listPresets()
                .pageSize(50L)
                .call();

        if (res.platformTriggerPresetListResponse().isPresent()) {
            System.out.println(res.platformTriggerPresetListResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                        | Type                                                             | Required                                                         | Description                                                      |
| ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- |
| `datasource`                                                     | *Optional\<String>*                                              | :heavy_minus_sign:                                               | Restrict results to presets for a single datasource (e.g. jira). |
| `pageSize`                                                       | *Optional\<Long>*                                                | :heavy_minus_sign:                                               | Maximum number of presets to return.                             |
| `cursor`                                                         | *Optional\<String>*                                              | :heavy_minus_sign:                                               | Opaque pagination cursor from a previous response.               |

### Response

**[PlatformTriggerPresetsListResponse](../../models/operations/PlatformTriggerPresetsListResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 408, 429                      | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## getPreset

Retrieve a single trigger preset by id.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-trigger-presets-get" method="get" path="/api/trigger-presets/{preset_id}" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformTriggerPresetsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformTriggerPresetsGetResponse res = sdk.triggers().getPreset()
                .presetId("<id>")
                .call();

        if (res.platformTriggerPresetGetResponse().isPresent()) {
            System.out.println(res.platformTriggerPresetGetResponse().get());
        }
    }
}
```

### Parameters

| Parameter                     | Type                          | Required                      | Description                   |
| ----------------------------- | ----------------------------- | ----------------------------- | ----------------------------- |
| `presetId`                    | *String*                      | :heavy_check_mark:            | ID of the preset to retrieve. |

### Response

**[PlatformTriggerPresetsGetResponse](../../models/operations/PlatformTriggerPresetsGetResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## listPresetInputValues

Return up to 300 selectable values for a single picklist input on a preset. Results are intended for typeahead selection and are not cursor-paginated. When `is_truncated` is true, refine `query` to narrow the result set.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-trigger-presets-input-values-list" method="get" path="/api/trigger-presets/{preset_id}/input-values" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformTriggerPresetsInputValuesListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformTriggerPresetsInputValuesListResponse res = sdk.triggers().listPresetInputValues()
                .presetId("<id>")
                .field("<value>")
                .call();

        if (res.platformTriggerPresetInputValueListResponse().isPresent()) {
            System.out.println(res.platformTriggerPresetInputValueListResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                            | Type                                                                                                                 | Required                                                                                                             | Description                                                                                                          |
| -------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------- |
| `presetId`                                                                                                           | *String*                                                                                                             | :heavy_check_mark:                                                                                                   | ID of the preset the input belongs to.                                                                               |
| `field`                                                                                                              | *String*                                                                                                             | :heavy_check_mark:                                                                                                   | Field identifier of the input whose values to list.                                                                  |
| `query`                                                                                                              | *Optional\<String>*                                                                                                  | :heavy_minus_sign:                                                                                                   | Prefix filter over the input's option values, for typeahead. Matching is on the option value, not its display name.<br/> |

### Response

**[PlatformTriggerPresetsInputValuesListResponse](../../models/operations/PlatformTriggerPresetsInputValuesListResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 429                 | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## searchPresetEvents

Search recent content events an unsaved trigger built from this preset would match, to preview it before creating the trigger. Read-only — no trigger is created and no webhook delivery is made. Covers the last seven days.


### Example Usage

<!-- UsageSnippet language="java" operationID="platform-trigger-presets-events-search" method="post" path="/api/trigger-presets/{preset_id}/events/search" -->
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.PlatformTriggerPresetEventSearchRequest;
import com.glean.api_client.glean_api_client.models.errors.PlatformProblemDetailException;
import com.glean.api_client.glean_api_client.models.operations.PlatformTriggerPresetsEventsSearchResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws PlatformProblemDetailException, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();

        PlatformTriggerPresetsEventsSearchResponse res = sdk.triggers().searchPresetEvents()
                .presetId("<id>")
                .platformTriggerPresetEventSearchRequest(PlatformTriggerPresetEventSearchRequest.builder()
                    .inputs(Map.ofEntries(
                        Map.entry("TITLE", "checkout outage")))
                    .build())
                .call();

        if (res.platformTriggerEventSearchResponse().isPresent()) {
            System.out.println(res.platformTriggerEventSearchResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `presetId`                                                                                                               | *String*                                                                                                                 | :heavy_check_mark:                                                                                                       | ID of the preset to preview.                                                                                             |
| `platformTriggerPresetEventSearchRequest`                                                                                | [Optional\<PlatformTriggerPresetEventSearchRequest>](../../models/components/PlatformTriggerPresetEventSearchRequest.md) | :heavy_minus_sign:                                                                                                       | N/A                                                                                                                      |

### Response

**[PlatformTriggerPresetsEventsSearchResponse](../../models/operations/PlatformTriggerPresetsEventsSearchResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PlatformProblemDetailException | 400, 401, 403, 404, 408, 413, 429            | application/problem+json                     |
| models/errors/PlatformProblemDetailException | 500, 503                                     | application/problem+json                     |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |