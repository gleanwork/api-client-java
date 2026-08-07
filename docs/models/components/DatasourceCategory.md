# DatasourceCategory

The type of this datasource. It is an important signal for relevance and must be specified and cannot be UNCATEGORIZED. Please refer to [this](https://developers.glean.com/docs/indexing_api_datasource_category/) for more details.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.DatasourceCategory;

DatasourceCategory value = DatasourceCategory.UNCATEGORIZED;

// Open enum: use .of() to create instances from custom string values
DatasourceCategory custom = DatasourceCategory.of("custom_value");
```


## Values

| Name                    | Value                   |
| ----------------------- | ----------------------- |
| `UNCATEGORIZED`         | UNCATEGORIZED           |
| `TICKETS`               | TICKETS                 |
| `CRM`                   | CRM                     |
| `PUBLISHED_CONTENT`     | PUBLISHED_CONTENT       |
| `COLLABORATIVE_CONTENT` | COLLABORATIVE_CONTENT   |
| `QUESTION_ANSWER`       | QUESTION_ANSWER         |
| `MESSAGING`             | MESSAGING               |
| `CODE_REPOSITORY`       | CODE_REPOSITORY         |
| `CHANGE_MANAGEMENT`     | CHANGE_MANAGEMENT       |
| `PEOPLE`                | PEOPLE                  |
| `EMAIL`                 | EMAIL                   |
| `SSO`                   | SSO                     |
| `ATS`                   | ATS                     |
| `KNOWLEDGE_HUB`         | KNOWLEDGE_HUB           |
| `EXTERNAL_SHORTCUT`     | EXTERNAL_SHORTCUT       |
| `ENTITY`                | ENTITY                  |
| `CALENDAR`              | CALENDAR                |
| `AGENTS`                | AGENTS                  |
| `AI_CONVERSATION`       | AI_CONVERSATION         |
| `AI_ARTIFACT`           | AI_ARTIFACT             |