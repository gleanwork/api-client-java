# ChatFileStatus

Current status of the file.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ChatFileStatus;

ChatFileStatus value = ChatFileStatus.PROCESSING;

// Open enum: use .of() to create instances from custom string values
ChatFileStatus custom = ChatFileStatus.of("custom_value");
```


## Values

| Name                  | Value                 |
| --------------------- | --------------------- |
| `PROCESSING`          | PROCESSING            |
| `PROCESSED`           | PROCESSED             |
| `PARTIALLY_PROCESSED` | PARTIALLY_PROCESSED   |
| `FAILED`              | FAILED                |
| `DELETED`             | DELETED               |