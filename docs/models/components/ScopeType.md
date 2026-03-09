# ScopeType

Describes the scope for a ReadPermission, WritePermission, or GrantPermission object

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ScopeType;

ScopeType value = ScopeType.GLOBAL;

// Open enum: use .of() to create instances from custom string values
ScopeType custom = ScopeType.of("custom_value");
```


## Values

| Name     | Value    |
| -------- | -------- |
| `GLOBAL` | GLOBAL   |
| `OWN`    | OWN      |