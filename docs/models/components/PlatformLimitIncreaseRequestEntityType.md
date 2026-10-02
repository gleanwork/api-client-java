# PlatformLimitIncreaseRequestEntityType

Whether the request concerns a user or an agent.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformLimitIncreaseRequestEntityType;

PlatformLimitIncreaseRequestEntityType value = PlatformLimitIncreaseRequestEntityType.USER;

// Open enum: use .of() to create instances from custom string values
PlatformLimitIncreaseRequestEntityType custom = PlatformLimitIncreaseRequestEntityType.of("custom_value");
```


## Values

| Name    | Value   |
| ------- | ------- |
| `USER`  | USER    |
| `AGENT` | AGENT   |