# ExportInfoStatus

The status of the export

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ExportInfoStatus;

ExportInfoStatus value = ExportInfoStatus.PENDING;

// Open enum: use .of() to create instances from custom string values
ExportInfoStatus custom = ExportInfoStatus.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `PENDING`   | PENDING     |
| `COMPLETED` | COMPLETED   |
| `FAILED`    | FAILED      |