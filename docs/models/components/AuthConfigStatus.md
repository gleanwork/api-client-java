# AuthConfigStatus

Auth status of the tool.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.AuthConfigStatus;

AuthConfigStatus value = AuthConfigStatus.AWAITING_AUTH;

// Open enum: use .of() to create instances from custom string values
AuthConfigStatus custom = AuthConfigStatus.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `AWAITING_AUTH` | AWAITING_AUTH   |
| `AUTHORIZED`    | AUTHORIZED      |
| `AUTH_DISABLED` | AUTH_DISABLED   |