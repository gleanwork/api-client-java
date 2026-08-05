# ImportAgentStatus

Outcome of the import for the target agent.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ImportAgentStatus;

ImportAgentStatus value = ImportAgentStatus.CREATED;

// Open enum: use .of() to create instances from custom string values
ImportAgentStatus custom = ImportAgentStatus.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `CREATED`       | CREATED         |
| `UPDATED`       | UPDATED         |
| `DRAFT_PREVIEW` | DRAFT_PREVIEW   |