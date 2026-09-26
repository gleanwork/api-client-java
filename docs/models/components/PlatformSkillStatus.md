# PlatformSkillStatus

The caller's effective activation. The owner sees the skill's stored status. Another caller sees their personal setting, or DISABLED when they have none. DRAFT is the stored draft state and is not set by update. Effective activation may also reflect workspace governance policy.


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