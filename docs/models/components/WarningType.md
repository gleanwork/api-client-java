# WarningType

The type of the warning.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.WarningType;

WarningType value = WarningType.LONG_QUERY;

// Open enum: use .of() to create instances from custom string values
WarningType custom = WarningType.of("custom_value");
```


## Values

| Name                         | Value                        |
| ---------------------------- | ---------------------------- |
| `LONG_QUERY`                 | LONG_QUERY                   |
| `QUOTED_PUNCTUATION`         | QUOTED_PUNCTUATION           |
| `PUNCTUATION_ONLY`           | PUNCTUATION_ONLY             |
| `COPYPASTED_QUOTES`          | COPYPASTED_QUOTES            |
| `INVALID_OPERATOR`           | INVALID_OPERATOR             |
| `MAYBE_INVALID_FACET_QUERY`  | MAYBE_INVALID_FACET_QUERY    |
| `TOO_MANY_DATASOURCE_GROUPS` | TOO_MANY_DATASOURCE_GROUPS   |