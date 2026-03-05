# ActivityEnum

Activity e.g. search, home page visit or all.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ActivityEnum;

ActivityEnum value = ActivityEnum.ALL;

// Open enum: use .of() to create instances from custom string values
ActivityEnum custom = ActivityEnum.of("custom_value");
```


## Values

| Name     | Value    |
| -------- | -------- |
| `ALL`    | ALL      |
| `SEARCH` | SEARCH   |