# AuthStatus

The per-user authorization status for a datasource.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.AuthStatus;

AuthStatus value = AuthStatus.DISABLED;

// Open enum: use .of() to create instances from custom string values
AuthStatus custom = AuthStatus.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `DISABLED`      | DISABLED        |
| `AWAITING_AUTH` | AWAITING_AUTH   |
| `AUTHORIZED`    | AUTHORIZED      |
| `STALE_OAUTH`   | STALE_OAUTH     |
| `SEG_MIGRATION` | SEG_MIGRATION   |