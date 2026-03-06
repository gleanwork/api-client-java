# TeamStatus

whether this team is fully processed or there are still unprocessed operations that'll affect it

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.TeamStatus;

TeamStatus value = TeamStatus.PROCESSED;

// Open enum: use .of() to create instances from custom string values
TeamStatus custom = TeamStatus.of("custom_value");
```


## Values

| Name                  | Value                 |
| --------------------- | --------------------- |
| `PROCESSED`           | PROCESSED             |
| `QUEUED_FOR_CREATION` | QUEUED_FOR_CREATION   |
| `QUEUED_FOR_DELETION` | QUEUED_FOR_DELETION   |