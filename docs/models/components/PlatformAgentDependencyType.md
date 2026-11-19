# PlatformAgentDependencyType

Type of a published artifact referenced as a dependency.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformAgentDependencyType;

PlatformAgentDependencyType value = PlatformAgentDependencyType.SKILL;

// Open enum: use .of() to create instances from custom string values
PlatformAgentDependencyType custom = PlatformAgentDependencyType.of("custom_value");
```


## Values

| Name    | Value   |
| ------- | ------- |
| `SKILL` | SKILL   |
| `AGENT` | AGENT   |