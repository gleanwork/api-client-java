# PlatformAgentInputFieldType

Type of an agent input field.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformAgentInputFieldType;

PlatformAgentInputFieldType value = PlatformAgentInputFieldType.TEXT;

// Open enum: use .of() to create instances from custom string values
PlatformAgentInputFieldType custom = PlatformAgentInputFieldType.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `TEXT`     | TEXT       |
| `SELECT`   | SELECT     |
| `DATE`     | DATE       |
| `DOCUMENT` | DOCUMENT   |