# PlatformSkillSourcePreviewFailureCode

Stable machine-readable reason a discovered entry was excluded.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformSkillSourcePreviewFailureCode;

PlatformSkillSourcePreviewFailureCode value = PlatformSkillSourcePreviewFailureCode.INVALID_SKILL;

// Open enum: use .of() to create instances from custom string values
PlatformSkillSourcePreviewFailureCode custom = PlatformSkillSourcePreviewFailureCode.of("custom_value");
```


## Values

| Name                 | Value                |
| -------------------- | -------------------- |
| `INVALID_SKILL`      | INVALID_SKILL        |
| `SKILL_FETCH_FAILED` | SKILL_FETCH_FAILED   |