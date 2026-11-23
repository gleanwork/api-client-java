# PlatformAgentTriggerType

Invocation mode of the agent.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformAgentTriggerType;

PlatformAgentTriggerType value = PlatformAgentTriggerType.CHAT_MESSAGE;

// Open enum: use .of() to create instances from custom string values
PlatformAgentTriggerType custom = PlatformAgentTriggerType.of("custom_value");
```


## Values

| Name              | Value             |
| ----------------- | ----------------- |
| `CHAT_MESSAGE`    | CHAT_MESSAGE      |
| `INPUT_FORM`      | INPUT_FORM        |
| `CONTENT_TRIGGER` | CONTENT_TRIGGER   |