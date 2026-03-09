# RelationType

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.RelationType;

RelationType value = RelationType.EQUALS;

// Open enum: use .of() to create instances from custom string values
RelationType custom = RelationType.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `EQUALS`     | EQUALS       |
| `ID_EQUALS`  | ID_EQUALS    |
| `LT`         | LT           |
| `GT`         | GT           |
| `NOT_EQUALS` | NOT_EQUALS   |