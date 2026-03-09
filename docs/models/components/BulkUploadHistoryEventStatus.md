# BulkUploadHistoryEventStatus

The status of the upload, an enum of ACTIVE, SUCCESSFUL

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.BulkUploadHistoryEventStatus;

BulkUploadHistoryEventStatus value = BulkUploadHistoryEventStatus.ACTIVE;

// Open enum: use .of() to create instances from custom string values
BulkUploadHistoryEventStatus custom = BulkUploadHistoryEventStatus.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `ACTIVE`     | ACTIVE       |
| `SUCCESSFUL` | SUCCESSFUL   |