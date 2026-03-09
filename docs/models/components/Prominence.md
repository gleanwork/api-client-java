# Prominence

The level of visual distinction that should be given to a result.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.Prominence;

Prominence value = Prominence.HERO;

// Open enum: use .of() to create instances from custom string values
Prominence custom = Prominence.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `HERO`     | HERO       |
| `PROMOTED` | PROMOTED   |
| `STANDARD` | STANDARD   |