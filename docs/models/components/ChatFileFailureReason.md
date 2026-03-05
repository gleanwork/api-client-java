# ChatFileFailureReason

Reason for failed status.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ChatFileFailureReason;

ChatFileFailureReason value = ChatFileFailureReason.PARSE_FAILED;

// Open enum: use .of() to create instances from custom string values
ChatFileFailureReason custom = ChatFileFailureReason.of("custom_value");
```


## Values

| Name                            | Value                           |
| ------------------------------- | ------------------------------- |
| `PARSE_FAILED`                  | PARSE_FAILED                    |
| `AV_SCAN_FAILED`                | AV_SCAN_FAILED                  |
| `FILE_TOO_SMALL`                | FILE_TOO_SMALL                  |
| `FILE_TOO_LARGE`                | FILE_TOO_LARGE                  |
| `FILE_EXTENSION_UNSUPPORTED`    | FILE_EXTENSION_UNSUPPORTED      |
| `FILE_METADATA_VALIDATION_FAIL` | FILE_METADATA_VALIDATION_FAIL   |
| `FILE_PROCESSING_TIMED_OUT`     | FILE_PROCESSING_TIMED_OUT       |
| `OAUTH_NEEDED`                  | OAUTH_NEEDED                    |
| `URL_FETCH_FAILED`              | URL_FETCH_FAILED                |
| `EMPTY_CONTENT`                 | EMPTY_CONTENT                   |
| `AUTH_REQUIRED`                 | AUTH_REQUIRED                   |