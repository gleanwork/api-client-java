# FeedResultCategory

Category of the result, one of the requested categories in incoming request.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.FeedResultCategory;

FeedResultCategory value = FeedResultCategory.DOCUMENT_SUGGESTION;

// Open enum: use .of() to create instances from custom string values
FeedResultCategory custom = FeedResultCategory.of("custom_value");
```


## Values

| Name                                | Value                               |
| ----------------------------------- | ----------------------------------- |
| `DOCUMENT_SUGGESTION`               | DOCUMENT_SUGGESTION                 |
| `DOCUMENT_SUGGESTION_SCENARIO`      | DOCUMENT_SUGGESTION_SCENARIO        |
| `TRENDING_DOCUMENT`                 | TRENDING_DOCUMENT                   |
| `USE_CASE`                          | USE_CASE                            |
| `VERIFICATION_REMINDER`             | VERIFICATION_REMINDER               |
| `EVENT`                             | EVENT                               |
| `ANNOUNCEMENT`                      | ANNOUNCEMENT                        |
| `MENTION`                           | MENTION                             |
| `DATASOURCE_AFFINITY`               | DATASOURCE_AFFINITY                 |
| `RECENT`                            | RECENT                              |
| `COMPANY_RESOURCE`                  | COMPANY_RESOURCE                    |
| `EXPERIMENTAL`                      | EXPERIMENTAL                        |
| `PEOPLE_CELEBRATIONS`               | PEOPLE_CELEBRATIONS                 |
| `SOCIAL_LINK`                       | SOCIAL_LINK                         |
| `EXTERNAL_TASKS`                    | EXTERNAL_TASKS                      |
| `DISPLAYABLE_LIST`                  | DISPLAYABLE_LIST                    |
| `ZERO_STATE_CHAT_SUGGESTION`        | ZERO_STATE_CHAT_SUGGESTION          |
| `ZERO_STATE_CHAT_TOOL_SUGGESTION`   | ZERO_STATE_CHAT_TOOL_SUGGESTION     |
| `ZERO_STATE_WORKFLOW_CREATED_BY_ME` | ZERO_STATE_WORKFLOW_CREATED_BY_ME   |
| `ZERO_STATE_WORKFLOW_FAVORITES`     | ZERO_STATE_WORKFLOW_FAVORITES       |
| `ZERO_STATE_WORKFLOW_POPULAR`       | ZERO_STATE_WORKFLOW_POPULAR         |
| `ZERO_STATE_WORKFLOW_RECENT`        | ZERO_STATE_WORKFLOW_RECENT          |
| `ZERO_STATE_WORKFLOW_SUGGESTION`    | ZERO_STATE_WORKFLOW_SUGGESTION      |
| `PERSONALIZED_CHAT_SUGGESTION`      | PERSONALIZED_CHAT_SUGGESTION        |
| `DAILY_DIGEST`                      | DAILY_DIGEST                        |