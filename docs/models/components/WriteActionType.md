# WriteActionType

Valid only for write actions. Represents the type of write action. REDIRECT - The client renders the URL which contains information for carrying out the action. EXECUTION - Send a request to an external server and execute the action. MCP - Send a tools/call request to an MCP server to execute the action.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.WriteActionType;

WriteActionType value = WriteActionType.REDIRECT;

// Open enum: use .of() to create instances from custom string values
WriteActionType custom = WriteActionType.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `REDIRECT`  | REDIRECT    |
| `EXECUTION` | EXECUTION   |
| `MCP`       | MCP         |