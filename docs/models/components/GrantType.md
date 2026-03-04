# GrantType

The type of grant type being used.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.GrantType;

GrantType value = GrantType.AUTH_CODE;

// Open enum: use .of() to create instances from custom string values
GrantType custom = GrantType.of("custom_value");
```


## Values

| Name                 | Value                |
| -------------------- | -------------------- |
| `AUTH_CODE`          | AUTH_CODE            |
| `CLIENT_CREDENTIALS` | CLIENT_CREDENTIALS   |