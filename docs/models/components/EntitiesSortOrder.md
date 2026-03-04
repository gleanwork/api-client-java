# EntitiesSortOrder

Different ways of sorting entities

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.EntitiesSortOrder;

EntitiesSortOrder value = EntitiesSortOrder.ENTITY_NAME;

// Open enum: use .of() to create instances from custom string values
EntitiesSortOrder custom = EntitiesSortOrder.of("custom_value");
```


## Values

| Name             | Value            |
| ---------------- | ---------------- |
| `ENTITY_NAME`    | ENTITY_NAME      |
| `FIRST_NAME`     | FIRST_NAME       |
| `LAST_NAME`      | LAST_NAME        |
| `ORG_SIZE_COUNT` | ORG_SIZE_COUNT   |
| `START_DATE`     | START_DATE       |
| `TEAM_SIZE`      | TEAM_SIZE        |
| `RELEVANCE`      | RELEVANCE        |