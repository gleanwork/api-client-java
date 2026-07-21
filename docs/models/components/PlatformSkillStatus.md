# PlatformSkillStatus

Current skill status.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformSkillStatus;

PlatformSkillStatus value = PlatformSkillStatus.DRAFT;

// Open enum: use .of() to create instances from custom string values
PlatformSkillStatus custom = PlatformSkillStatus.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `DRAFT`    | DRAFT      |
| `ENABLED`  | ENABLED    |
| `DISABLED` | DISABLED   |