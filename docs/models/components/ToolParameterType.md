# ToolParameterType

Parameter type (string, number, boolean, object, array)

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ToolParameterType;

ToolParameterType value = ToolParameterType.STRING;

// Open enum: use .of() to create instances from custom string values
ToolParameterType custom = ToolParameterType.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `STRING`  | string    |
| `NUMBER`  | number    |
| `BOOLEAN` | boolean   |
| `OBJECT`  | object    |
| `ARRAY`   | array     |