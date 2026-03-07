# Relation

How this document relates to the including entity.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.Relation;

Relation value = Relation.ATTACHMENT;

// Open enum: use .of() to create instances from custom string values
Relation custom = Relation.of("custom_value");
```


## Values

| Name                    | Value                   |
| ----------------------- | ----------------------- |
| `ATTACHMENT`            | ATTACHMENT              |
| `CANONICAL`             | CANONICAL               |
| `CASE`                  | CASE                    |
| `CONTACT_LOWER`         | contact                 |
| `CONTACT_UPPER`         | CONTACT                 |
| `CONVERSATION_MESSAGES` | CONVERSATION_MESSAGES   |
| `EXPERT`                | EXPERT                  |
| `FROM`                  | FROM                    |
| `HIGHLIGHT`             | HIGHLIGHT               |
| `OPPORTUNITY_LOWER`     | opportunity             |
| `OPPORTUNITY_UPPER`     | OPPORTUNITY             |
| `RECENT`                | RECENT                  |
| `SOURCE`                | SOURCE                  |
| `TICKET`                | TICKET                  |
| `TRANSCRIPT`            | TRANSCRIPT              |
| `WITH`                  | WITH                    |