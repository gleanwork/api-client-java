# InputOptionsTimePeriodType

Type of time period for which to run the report/policy. PAST_DAY is deprecated.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.InputOptionsTimePeriodType;

InputOptionsTimePeriodType value = InputOptionsTimePeriodType.ALL_TIME;

// Open enum: use .of() to create instances from custom string values
InputOptionsTimePeriodType custom = InputOptionsTimePeriodType.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `ALL_TIME`    | ALL_TIME      |
| `PAST_YEAR`   | PAST_YEAR     |
| `PAST_DAY`    | PAST_DAY      |
| `CUSTOM`      | CUSTOM        |
| `LAST_N_DAYS` | LAST_N_DAYS   |