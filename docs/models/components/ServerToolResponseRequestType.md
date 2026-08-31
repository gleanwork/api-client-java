# ServerToolResponseRequestType

The type of request made to the user.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ServerToolResponseRequestType;

ServerToolResponseRequestType value = ServerToolResponseRequestType.EXECUTION;

// Open enum: use .of() to create instances from custom string values
ServerToolResponseRequestType custom = ServerToolResponseRequestType.of("custom_value");
```


## Values

| Name                        | Value                       |
| --------------------------- | --------------------------- |
| `EXECUTION`                 | EXECUTION                   |
| `AUTHENTICATION_SUGGESTION` | AUTHENTICATION_SUGGESTION   |
| `VOTE_SUGGESTION`           | VOTE_SUGGESTION             |
| `SANDBOX_EGRESS`            | SANDBOX_EGRESS              |