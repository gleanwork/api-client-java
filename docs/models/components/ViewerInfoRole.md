# ~~ViewerInfoRole~~

DEPRECATED - use permissions instead. Viewer's role on the specific document.

> :warning: **DEPRECATED**: Deprecated on 2026-02-05, removal scheduled for 2026-10-15: Use permissions instead.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ViewerInfoRole;

ViewerInfoRole value = ViewerInfoRole.ANSWER_MODERATOR;

// Open enum: use .of() to create instances from custom string values
ViewerInfoRole custom = ViewerInfoRole.of("custom_value");
```


## Values

| Name               | Value              |
| ------------------ | ------------------ |
| `ANSWER_MODERATOR` | ANSWER_MODERATOR   |
| `OWNER`            | OWNER              |
| `VIEWER`           | VIEWER             |