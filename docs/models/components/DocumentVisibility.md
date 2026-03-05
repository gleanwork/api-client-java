# DocumentVisibility

The level of visibility of the document as understood by our system.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.DocumentVisibility;

DocumentVisibility value = DocumentVisibility.PRIVATE;

// Open enum: use .of() to create instances from custom string values
DocumentVisibility custom = DocumentVisibility.of("custom_value");
```


## Values

| Name                         | Value                        |
| ---------------------------- | ---------------------------- |
| `PRIVATE`                    | PRIVATE                      |
| `SPECIFIC_PEOPLE_AND_GROUPS` | SPECIFIC_PEOPLE_AND_GROUPS   |
| `DOMAIN_LINK`                | DOMAIN_LINK                  |
| `DOMAIN_VISIBLE`             | DOMAIN_VISIBLE               |
| `PUBLIC_LINK`                | PUBLIC_LINK                  |
| `PUBLIC_VISIBLE`             | PUBLIC_VISIBLE               |