# CustomMetadataPropertyDefinitionPropertyType

The type of metadata key. This governs the search and faceting behavior.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.CustomMetadataPropertyDefinitionPropertyType;

CustomMetadataPropertyDefinitionPropertyType value = CustomMetadataPropertyDefinitionPropertyType.TEXT;

// Open enum: use .of() to create instances from custom string values
CustomMetadataPropertyDefinitionPropertyType custom = CustomMetadataPropertyDefinitionPropertyType.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `TEXT`          | TEXT            |
| `PICKLIST`      | PICKLIST        |
| `TEXTLIST`      | TEXTLIST        |
| `MULTIPICKLIST` | MULTIPICKLIST   |