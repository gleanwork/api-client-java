# UpdateType

Optional type classification for the update.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.UpdateType;

UpdateType value = UpdateType.ACTIONABLE;

// Open enum: use .of() to create instances from custom string values
UpdateType custom = UpdateType.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `ACTIONABLE`  | ACTIONABLE    |
| `INFORMATIVE` | INFORMATIVE   |