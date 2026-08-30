# ServerToolRequestRequestType

The type of request made to the user.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ServerToolRequestRequestType;

ServerToolRequestRequestType value = ServerToolRequestRequestType.EXECUTION;

// Open enum: use .of() to create instances from custom string values
ServerToolRequestRequestType custom = ServerToolRequestRequestType.of("custom_value");
```


## Values

| Name                        | Value                       |
| --------------------------- | --------------------------- |
| `EXECUTION`                 | EXECUTION                   |
| `AUTHENTICATION_SUGGESTION` | AUTHENTICATION_SUGGESTION   |
| `VOTE_SUGGESTION`           | VOTE_SUGGESTION             |
| `SANDBOX_EGRESS`            | SANDBOX_EGRESS              |