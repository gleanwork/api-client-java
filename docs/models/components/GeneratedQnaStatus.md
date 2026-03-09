# GeneratedQnaStatus

Status of backend generating the answer

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.GeneratedQnaStatus;

GeneratedQnaStatus value = GeneratedQnaStatus.COMPUTING;

// Open enum: use .of() to create instances from custom string values
GeneratedQnaStatus custom = GeneratedQnaStatus.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `COMPUTING` | COMPUTING   |
| `DISABLED`  | DISABLED    |
| `FAILED`    | FAILED      |
| `NO_ANSWER` | NO_ANSWER   |
| `SKIPPED`   | SKIPPED     |
| `STREAMING` | STREAMING   |
| `SUCCEEDED` | SUCCEEDED   |
| `TIMEOUT`   | TIMEOUT     |