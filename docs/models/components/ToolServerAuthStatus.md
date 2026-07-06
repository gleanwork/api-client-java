# ToolServerAuthStatus

Authentication status for the calling user.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ToolServerAuthStatus;

ToolServerAuthStatus value = ToolServerAuthStatus.AWAITING_AUTH;

// Open enum: use .of() to create instances from custom string values
ToolServerAuthStatus custom = ToolServerAuthStatus.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `AWAITING_AUTH` | AWAITING_AUTH   |
| `AUTHORIZED`    | AUTHORIZED      |