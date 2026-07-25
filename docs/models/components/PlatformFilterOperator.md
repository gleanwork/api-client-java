# PlatformFilterOperator

Supported filter operator.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformFilterOperator;

PlatformFilterOperator value = PlatformFilterOperator.EQUALS;

// Open enum: use .of() to create instances from custom string values
PlatformFilterOperator custom = PlatformFilterOperator.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `EQUALS`     | EQUALS       |
| `NOT_EQUALS` | NOT_EQUALS   |
| `GT`         | GT           |
| `GTE`        | GTE          |
| `LT`         | LT           |
| `LTE`        | LTE          |