# PlatformOAuthTokenEndpointAuthMethod

How an OAuth client authenticates to the token endpoint.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformOAuthTokenEndpointAuthMethod;

PlatformOAuthTokenEndpointAuthMethod value = PlatformOAuthTokenEndpointAuthMethod.CLIENT_SECRET_BASIC;

// Open enum: use .of() to create instances from custom string values
PlatformOAuthTokenEndpointAuthMethod custom = PlatformOAuthTokenEndpointAuthMethod.of("custom_value");
```


## Values

| Name                  | Value                 |
| --------------------- | --------------------- |
| `CLIENT_SECRET_BASIC` | CLIENT_SECRET_BASIC   |
| `CLIENT_SECRET_POST`  | CLIENT_SECRET_POST    |
| `NO_AUTHENTICATION`   | NO_AUTHENTICATION     |
| `PRIVATE_KEY_JWT`     | PRIVATE_KEY_JWT       |
| `TLS_CLIENT_AUTH`     | TLS_CLIENT_AUTH       |