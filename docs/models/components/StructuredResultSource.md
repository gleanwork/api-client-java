# StructuredResultSource

Source context for this result. Possible values depend on the result type.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.StructuredResultSource;

StructuredResultSource value = StructuredResultSource.EXPERT_DETECTION;

// Open enum: use .of() to create instances from custom string values
StructuredResultSource custom = StructuredResultSource.of("custom_value");
```


## Values

| Name               | Value              |
| ------------------ | ------------------ |
| `EXPERT_DETECTION` | EXPERT_DETECTION   |
| `ENTITY_NLQ`       | ENTITY_NLQ         |
| `CALENDAR_EVENT`   | CALENDAR_EVENT     |
| `AGENT`            | AGENT              |