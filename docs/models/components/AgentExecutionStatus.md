# AgentExecutionStatus

The status of the run. One of 'error', 'success'.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.AgentExecutionStatus;

AgentExecutionStatus value = AgentExecutionStatus.ERROR;

// Open enum: use .of() to create instances from custom string values
AgentExecutionStatus custom = AgentExecutionStatus.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `ERROR`   | error     |
| `SUCCESS` | success   |