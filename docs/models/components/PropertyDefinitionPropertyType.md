# PropertyDefinitionPropertyType

The type of custom property - this governs the search and faceting behavior. Note that MULTIPICKLIST is not yet supported.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PropertyDefinitionPropertyType;

PropertyDefinitionPropertyType value = PropertyDefinitionPropertyType.TEXT;

// Open enum: use .of() to create instances from custom string values
PropertyDefinitionPropertyType custom = PropertyDefinitionPropertyType.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `TEXT`          | TEXT            |
| `DATE`          | DATE            |
| `INT`           | INT             |
| `USERID`        | USERID          |
| `PICKLIST`      | PICKLIST        |
| `TEXTLIST`      | TEXTLIST        |
| `MULTIPICKLIST` | MULTIPICKLIST   |