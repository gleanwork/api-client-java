# PlatformOAuthGrantType

An OAuth grant type.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformOAuthGrantType;

PlatformOAuthGrantType value = PlatformOAuthGrantType.AUTHORIZATION_CODE;

// Open enum: use .of() to create instances from custom string values
PlatformOAuthGrantType custom = PlatformOAuthGrantType.of("custom_value");
```


## Values

| Name                 | Value                |
| -------------------- | -------------------- |
| `AUTHORIZATION_CODE` | AUTHORIZATION_CODE   |
| `CLIENT_CREDENTIALS` | CLIENT_CREDENTIALS   |
| `REFRESH_TOKEN`      | REFRESH_TOKEN        |
| `DEVICE_CODE`        | DEVICE_CODE          |
| `TOKEN_EXCHANGE`     | TOKEN_EXCHANGE       |
| `JWT_BEARER`         | JWT_BEARER           |