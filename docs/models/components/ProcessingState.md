# ProcessingState

The current state of the upload, an enum of UNAVAILABLE, UPLOAD STARTED, UPLOAD IN PROGRESS, UPLOAD COMPLETED, DELETION PAUSED, INDEXING COMPLETED

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ProcessingState;

ProcessingState value = ProcessingState.UNAVAILABLE;

// Open enum: use .of() to create instances from custom string values
ProcessingState custom = ProcessingState.of("custom_value");
```


## Values

| Name                 | Value                |
| -------------------- | -------------------- |
| `UNAVAILABLE`        | UNAVAILABLE          |
| `UPLOAD_STARTED`     | UPLOAD STARTED       |
| `UPLOAD_IN_PROGRESS` | UPLOAD IN PROGRESS   |
| `UPLOAD_COMPLETED`   | UPLOAD COMPLETED     |
| `DELETION_PAUSED`    | DELETION PAUSED      |
| `INDEXING_COMPLETED` | INDEXING COMPLETED   |