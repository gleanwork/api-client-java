# PlatformAgentRunState

State of the persisted workflow execution. REQUIRES_INPUT is nonterminal.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformAgentRunState;

PlatformAgentRunState value = PlatformAgentRunState.QUEUED;

// Open enum: use .of() to create instances from custom string values
PlatformAgentRunState custom = PlatformAgentRunState.of("custom_value");
```


## Values

| Name             | Value            |
| ---------------- | ---------------- |
| `QUEUED`         | QUEUED           |
| `RUNNING`        | RUNNING          |
| `REQUIRES_INPUT` | REQUIRES_INPUT   |
| `SUCCEEDED`      | SUCCEEDED        |
| `FAILED`         | FAILED           |
| `CANCELLING`     | CANCELLING       |
| `CANCELLED`      | CANCELLED        |
| `EXPIRED`        | EXPIRED          |