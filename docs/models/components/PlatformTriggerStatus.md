# PlatformTriggerStatus

Current trigger lifecycle state.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformTriggerStatus;

PlatformTriggerStatus value = PlatformTriggerStatus.ENABLED;

// Open enum: use .of() to create instances from custom string values
PlatformTriggerStatus custom = PlatformTriggerStatus.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `ENABLED`  | ENABLED    |
| `DISABLED` | DISABLED   |