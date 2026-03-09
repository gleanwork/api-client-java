# UserRole

A user's role with respect to a specific document.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.UserRole;

UserRole value = UserRole.OWNER;

// Open enum: use .of() to create instances from custom string values
UserRole custom = UserRole.of("custom_value");
```


## Values

| Name               | Value              |
| ------------------ | ------------------ |
| `OWNER`            | OWNER              |
| `VIEWER`           | VIEWER             |
| `ANSWER_MODERATOR` | ANSWER_MODERATOR   |
| `EDITOR`           | EDITOR             |
| `VERIFIER`         | VERIFIER           |