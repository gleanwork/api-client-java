# SectionType

Type of the section. This defines how the section should be interpreted and rendered in the digest.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.SectionType;

SectionType value = SectionType.CHANNEL;

// Open enum: use .of() to create instances from custom string values
SectionType custom = SectionType.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `CHANNEL`  | CHANNEL    |
| `MENTIONS` | MENTIONS   |
| `TOPIC`    | TOPIC      |