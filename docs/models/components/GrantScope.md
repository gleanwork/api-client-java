# GrantScope

Scope of the approval grant. Only applicable when isGranted is true and requestType is EXECUTION.


## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.GrantScope;

GrantScope value = GrantScope.CURRENT_REQUEST;

// Open enum: use .of() to create instances from custom string values
GrantScope custom = GrantScope.of("custom_value");
```


## Values

| Name              | Value             |
| ----------------- | ----------------- |
| `CURRENT_REQUEST` | CURRENT_REQUEST   |
| `CURRENT_SESSION` | CURRENT_SESSION   |
| `ALWAYS`          | ALWAYS            |