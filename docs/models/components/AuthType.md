# AuthType

The type of authentication being used.
Use 'OAUTH_*' when Glean calls an external API (e.g., Jira) on behalf of a user to obtain an OAuth token.
'OAUTH_ADMIN' utilizes an admin token for external API calls on behalf all users.
'OAUTH_USER' uses individual user tokens for external API calls.
'DWD' refers to domain wide delegation.


## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.AuthType;

AuthType value = AuthType.NONE;

// Open enum: use .of() to create instances from custom string values
AuthType custom = AuthType.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `NONE`        | NONE          |
| `OAUTH_USER`  | OAUTH_USER    |
| `OAUTH_ADMIN` | OAUTH_ADMIN   |
| `API_KEY`     | API_KEY       |
| `BASIC_AUTH`  | BASIC_AUTH    |
| `DWD`         | DWD           |