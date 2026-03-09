# UserActivityAction

The action for the activity

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.UserActivityAction;

UserActivityAction value = UserActivityAction.ADD;

// Open enum: use .of() to create instances from custom string values
UserActivityAction custom = UserActivityAction.of("custom_value");
```


## Values

| Name           | Value          |
| -------------- | -------------- |
| `ADD`          | ADD            |
| `ADD_REMINDER` | ADD_REMINDER   |
| `CLICK`        | CLICK          |
| `COMMENT`      | COMMENT        |
| `DELETE`       | DELETE         |
| `DISMISS`      | DISMISS        |
| `EDIT`         | EDIT           |
| `MENTION`      | MENTION        |
| `MOVE`         | MOVE           |
| `OTHER`        | OTHER          |
| `RESTORE`      | RESTORE        |
| `UNKNOWN`      | UNKNOWN        |
| `VERIFY`       | VERIFY         |
| `VIEW`         | VIEW           |