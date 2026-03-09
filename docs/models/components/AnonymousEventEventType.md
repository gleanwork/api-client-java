# AnonymousEventEventType

The nature of the event, for example "out of office".

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.AnonymousEventEventType;

AnonymousEventEventType value = AnonymousEventEventType.DEFAULT;

// Open enum: use .of() to create instances from custom string values
AnonymousEventEventType custom = AnonymousEventEventType.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `DEFAULT`       | DEFAULT         |
| `OUT_OF_OFFICE` | OUT_OF_OFFICE   |