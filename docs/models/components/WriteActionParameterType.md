# WriteActionParameterType

The type of the value (e.g., integer, string, boolean, etc.)

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.WriteActionParameterType;

WriteActionParameterType value = WriteActionParameterType.UNKNOWN;

// Open enum: use .of() to create instances from custom string values
WriteActionParameterType custom = WriteActionParameterType.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `UNKNOWN` | UNKNOWN   |
| `INTEGER` | INTEGER   |
| `STRING`  | STRING    |
| `BOOLEAN` | BOOLEAN   |