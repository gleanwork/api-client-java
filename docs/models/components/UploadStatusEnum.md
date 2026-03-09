# UploadStatusEnum

Upload status, enum of NOT_UPLOADED, UPLOADED, STATUS_UNKNOWN

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.UploadStatusEnum;

UploadStatusEnum value = UploadStatusEnum.UPLOADED;

// Open enum: use .of() to create instances from custom string values
UploadStatusEnum custom = UploadStatusEnum.of("custom_value");
```


## Values

| Name             | Value            |
| ---------------- | ---------------- |
| `UPLOADED`       | UPLOADED         |
| `NOT_UPLOADED`   | NOT_UPLOADED     |
| `STATUS_UNKNOWN` | STATUS_UNKNOWN   |