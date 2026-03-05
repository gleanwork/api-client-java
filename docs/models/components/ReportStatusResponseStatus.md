# ReportStatusResponseStatus

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ReportStatusResponseStatus;

ReportStatusResponseStatus value = ReportStatusResponseStatus.PENDING;

// Open enum: use .of() to create instances from custom string values
ReportStatusResponseStatus custom = ReportStatusResponseStatus.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `PENDING`    | PENDING      |
| `SUCCESS`    | SUCCESS      |
| `FAILURE`    | FAILURE      |
| `CANCELLED`  | CANCELLED    |
| `CANCELLING` | CANCELLING   |
| `ACTIVE`     | ACTIVE       |