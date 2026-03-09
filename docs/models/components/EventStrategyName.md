# EventStrategyName

The name of method used to surface relevant data for a given calendar event.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.EventStrategyName;

EventStrategyName value = EventStrategyName.CUSTOMER_CARD;

// Open enum: use .of() to create instances from custom string values
EventStrategyName custom = EventStrategyName.of("custom_value");
```


## Values

| Name                 | Value                |
| -------------------- | -------------------- |
| `CUSTOMER_CARD`      | customerCard         |
| `NEWS`               | news                 |
| `CALL`               | call                 |
| `EMAIL`              | email                |
| `MEETING_NOTES`      | meetingNotes         |
| `LINKED_IN`          | linkedIn             |
| `RELEVANT_DOCUMENTS` | relevantDocuments    |
| `CHAT_FOLLOW_UPS`    | chatFollowUps        |
| `CONVERSATIONS`      | conversations        |