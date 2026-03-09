# EntityType

The type of entity.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.EntityType;

EntityType value = EntityType.PERSON;

// Open enum: use .of() to create instances from custom string values
EntityType custom = EntityType.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `PERSON`   | PERSON     |
| `PROJECT`  | PROJECT    |
| `CUSTOMER` | CUSTOMER   |