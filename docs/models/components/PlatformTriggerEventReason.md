# PlatformTriggerEventReason

Why the event fired.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformTriggerEventReason;

PlatformTriggerEventReason value = PlatformTriggerEventReason.CREATED;

// Open enum: use .of() to create instances from custom string values
PlatformTriggerEventReason custom = PlatformTriggerEventReason.of("custom_value");
```


## Values

| Name                     | Value                    |
| ------------------------ | ------------------------ |
| `CREATED`                | CREATED                  |
| `UPDATED`                | UPDATED                  |
| `DELETED`                | DELETED                  |
| `MEETS_CONDITION`        | MEETS_CONDITION          |
| `ASSIGNED`               | ASSIGNED                 |
| `UNASSIGNED`             | UNASSIGNED               |
| `LABELED`                | LABELED                  |
| `UNLABELED`              | UNLABELED                |
| `REVIEW_REQUESTED`       | REVIEW_REQUESTED         |
| `REVIEW_REQUEST_REMOVED` | REVIEW_REQUEST_REMOVED   |
| `READY_FOR_REVIEW`       | READY_FOR_REVIEW         |
| `CONVERTED_TO_DRAFT`     | CONVERTED_TO_DRAFT       |
| `WEBHOOK_UPDATED`        | WEBHOOK_UPDATED          |