# BusinessJustification

Whether a business justification is required when requesting a usage limit increase.


## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.BusinessJustification;

BusinessJustification value = BusinessJustification.OPTIONAL;

// Open enum: use .of() to create instances from custom string values
BusinessJustification custom = BusinessJustification.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `OPTIONAL` | OPTIONAL   |
| `REQUIRED` | REQUIRED   |