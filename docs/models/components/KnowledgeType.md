# KnowledgeType

Indicates the kind of knowledge a tool would access or modify.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.KnowledgeType;

KnowledgeType value = KnowledgeType.NEUTRAL_KNOWLEDGE;

// Open enum: use .of() to create instances from custom string values
KnowledgeType custom = KnowledgeType.of("custom_value");
```


## Values

| Name                | Value               |
| ------------------- | ------------------- |
| `NEUTRAL_KNOWLEDGE` | NEUTRAL_KNOWLEDGE   |
| `COMPANY_KNOWLEDGE` | COMPANY_KNOWLEDGE   |
| `WORLD_KNOWLEDGE`   | WORLD_KNOWLEDGE     |