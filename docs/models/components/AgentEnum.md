# AgentEnum

Name of the agent.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.AgentEnum;

AgentEnum value = AgentEnum.DEFAULT;

// Open enum: use .of() to create instances from custom string values
AgentEnum custom = AgentEnum.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `DEFAULT`   | DEFAULT     |
| `GPT`       | GPT         |
| `UNIVERSAL` | UNIVERSAL   |
| `FAST`      | FAST        |
| `ADVANCED`  | ADVANCED    |
| `AUTO`      | AUTO        |