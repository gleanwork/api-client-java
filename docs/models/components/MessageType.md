# MessageType

Semantically groups content of a certain type. It can be used for purposes such as differential UI treatment. USER authored messages should be of type CONTENT and do not need `messageType` specified.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.MessageType;

MessageType value = MessageType.UPDATE;

// Open enum: use .of() to create instances from custom string values
MessageType custom = MessageType.of("custom_value");
```


## Values

| Name              | Value             |
| ----------------- | ----------------- |
| `UPDATE`          | UPDATE            |
| `CONTENT`         | CONTENT           |
| `CONTEXT`         | CONTEXT           |
| `CONTROL`         | CONTROL           |
| `CONTROL_START`   | CONTROL_START     |
| `CONTROL_FINISH`  | CONTROL_FINISH    |
| `CONTROL_CANCEL`  | CONTROL_CANCEL    |
| `CONTROL_RETRY`   | CONTROL_RETRY     |
| `CONTROL_UNKNOWN` | CONTROL_UNKNOWN   |
| `DEBUG`           | DEBUG             |
| `DEBUG_EXTERNAL`  | DEBUG_EXTERNAL    |
| `ERROR`           | ERROR             |
| `HEADING`         | HEADING           |
| `WARNING`         | WARNING           |
| `SERVER_TOOL`     | SERVER_TOOL       |