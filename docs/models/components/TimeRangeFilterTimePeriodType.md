# TimeRangeFilterTimePeriodType

The type of time period for which to filter findings.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.TimeRangeFilterTimePeriodType;

TimeRangeFilterTimePeriodType value = TimeRangeFilterTimePeriodType.PAST_DAY;

// Open enum: use .of() to create instances from custom string values
TimeRangeFilterTimePeriodType custom = TimeRangeFilterTimePeriodType.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `PAST_DAY`   | PAST_DAY     |
| `PAST_WEEK`  | PAST_WEEK    |
| `PAST_MONTH` | PAST_MONTH   |
| `PAST_YEAR`  | PAST_YEAR    |
| `CUSTOM`     | CUSTOM       |