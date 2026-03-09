# Scope

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.Scope;

Scope value = Scope.APP_CARD;

// Open enum: use .of() to create instances from custom string values
Scope custom = Scope.of("custom_value");
```


## Values

| Name                       | Value                      |
| -------------------------- | -------------------------- |
| `APP_CARD`                 | APP_CARD                   |
| `AUTOCOMPLETE_EXACT_MATCH` | AUTOCOMPLETE_EXACT_MATCH   |
| `AUTOCOMPLETE_FUZZY_MATCH` | AUTOCOMPLETE_FUZZY_MATCH   |
| `AUTOCOMPLETE_ZERO_QUERY`  | AUTOCOMPLETE_ZERO_QUERY    |
| `NEW_TAB_PAGE`             | NEW_TAB_PAGE               |