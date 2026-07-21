# PlatformSkillSyncStatus

Current external-source sync status.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformSkillSyncStatus;

PlatformSkillSyncStatus value = PlatformSkillSyncStatus.UP_TO_DATE;

// Open enum: use .of() to create instances from custom string values
PlatformSkillSyncStatus custom = PlatformSkillSyncStatus.of("custom_value");
```


## Values

| Name               | Value              |
| ------------------ | ------------------ |
| `UP_TO_DATE`       | UP_TO_DATE         |
| `UPDATE_AVAILABLE` | UPDATE_AVAILABLE   |
| `SYNC_FAILED`      | SYNC_FAILED        |