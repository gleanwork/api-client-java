# DlpSeverity

Severity levels for DLP findings and analyses. FALSE_POSITIVE ranks below LOW and marks analyses that concluded every flagged entity is a detector false positive.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.DlpSeverity;

DlpSeverity value = DlpSeverity.UNSPECIFIED;

// Open enum: use .of() to create instances from custom string values
DlpSeverity custom = DlpSeverity.of("custom_value");
```


## Values

| Name             | Value            |
| ---------------- | ---------------- |
| `UNSPECIFIED`    | UNSPECIFIED      |
| `LOW`            | LOW              |
| `MEDIUM`         | MEDIUM           |
| `HIGH`           | HIGH             |
| `FALSE_POSITIVE` | FALSE_POSITIVE   |