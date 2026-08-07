# AuthHeaderType

Defines the header structure for sending the API key or token to the server. Defaults to AUTHORIZATION_BEARER. Select the specific header format the server expects for transmitting the key.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.AuthHeaderType;

AuthHeaderType value = AuthHeaderType.AUTHORIZATION_BEARER;

// Open enum: use .of() to create instances from custom string values
AuthHeaderType custom = AuthHeaderType.of("custom_value");
```


## Values

| Name                    | Value                   |
| ----------------------- | ----------------------- |
| `AUTHORIZATION_BEARER`  | AUTHORIZATION_BEARER    |
| `AUTHORIZATION_TOKEN`   | AUTHORIZATION_TOKEN     |
| `AUTHORIZATION_API_KEY` | AUTHORIZATION_API_KEY   |
| `X_API_KEY`             | X_API_KEY               |