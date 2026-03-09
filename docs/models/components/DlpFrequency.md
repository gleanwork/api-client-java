# DlpFrequency

Interval between scans. DAILY is deprecated.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.DlpFrequency;

DlpFrequency value = DlpFrequency.ONCE;

// Open enum: use .of() to create instances from custom string values
DlpFrequency custom = DlpFrequency.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `ONCE`       | ONCE         |
| `DAILY`      | DAILY        |
| `WEEKLY`     | WEEKLY       |
| `CONTINUOUS` | CONTINUOUS   |
| `NONE`       | NONE         |