# ChatStatus

The status of the Chat.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ChatStatus;

ChatStatus value = ChatStatus.SUCCESS;

// Open enum: use .of() to create instances from custom string values
ChatStatus custom = ChatStatus.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `SUCCESS`     | SUCCESS       |
| `ERROR`       | ERROR         |
| `IN_PROGRESS` | IN_PROGRESS   |
| `CANCELLED`   | CANCELLED     |