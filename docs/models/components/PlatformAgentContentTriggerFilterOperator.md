# PlatformAgentContentTriggerFilterOperator

Operator of a content trigger filter.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformAgentContentTriggerFilterOperator;

PlatformAgentContentTriggerFilterOperator value = PlatformAgentContentTriggerFilterOperator.IS_ONE_OF;

// Open enum: use .of() to create instances from custom string values
PlatformAgentContentTriggerFilterOperator custom = PlatformAgentContentTriggerFilterOperator.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `IS_ONE_OF`     | IS_ONE_OF       |
| `IS_NOT_ONE_OF` | IS_NOT_ONE_OF   |
| `CONTAINS`      | CONTAINS        |
| `FIELD_CHANGED` | FIELD_CHANGED   |