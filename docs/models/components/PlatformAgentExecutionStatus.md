# PlatformAgentExecutionStatus

Status of the agent run.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformAgentExecutionStatus;

PlatformAgentExecutionStatus value = PlatformAgentExecutionStatus.ERROR;

// Open enum: use .of() to create instances from custom string values
PlatformAgentExecutionStatus custom = PlatformAgentExecutionStatus.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `ERROR`   | error     |
| `SUCCESS` | success   |