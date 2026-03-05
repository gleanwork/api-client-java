# DocumentVisibilityOverrideOverride

The visibility-override state of the document.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.DocumentVisibilityOverrideOverride;

DocumentVisibilityOverrideOverride value = DocumentVisibilityOverrideOverride.NONE;

// Open enum: use .of() to create instances from custom string values
DocumentVisibilityOverrideOverride custom = DocumentVisibilityOverrideOverride.of("custom_value");
```


## Values

| Name                         | Value                        |
| ---------------------------- | ---------------------------- |
| `NONE`                       | NONE                         |
| `HIDE_FROM_ALL`              | HIDE_FROM_ALL                |
| `HIDE_FROM_GROUPS`           | HIDE_FROM_GROUPS             |
| `HIDE_FROM_ALL_EXCEPT_OWNER` | HIDE_FROM_ALL_EXCEPT_OWNER   |