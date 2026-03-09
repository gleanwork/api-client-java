# DlpSeverity

Severity levels for DLP findings and analyses.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.DlpSeverity;

DlpSeverity value = DlpSeverity.UNSPECIFIED;

// Open enum: use .of() to create instances from custom string values
DlpSeverity custom = DlpSeverity.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `UNSPECIFIED` | UNSPECIFIED   |
| `LOW`         | LOW           |
| `MEDIUM`      | MEDIUM        |
| `HIGH`        | HIGH          |