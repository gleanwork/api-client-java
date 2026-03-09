# CustomSensitiveRuleType

Type of the custom sensitive rule.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.CustomSensitiveRuleType;

CustomSensitiveRuleType value = CustomSensitiveRuleType.REGEX;

// Open enum: use .of() to create instances from custom string values
CustomSensitiveRuleType custom = CustomSensitiveRuleType.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `REGEX`     | REGEX       |
| `TERM`      | TERM        |
| `INFO_TYPE` | INFO_TYPE   |