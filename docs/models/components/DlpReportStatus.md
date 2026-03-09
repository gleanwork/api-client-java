# DlpReportStatus

The status of the policy/report. Only ACTIVE status will be picked for scans.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.DlpReportStatus;

DlpReportStatus value = DlpReportStatus.ACTIVE;

// Open enum: use .of() to create instances from custom string values
DlpReportStatus custom = DlpReportStatus.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `ACTIVE`    | ACTIVE      |
| `INACTIVE`  | INACTIVE    |
| `CANCELLED` | CANCELLED   |
| `NONE`      | NONE        |