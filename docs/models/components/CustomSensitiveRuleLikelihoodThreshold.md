# CustomSensitiveRuleLikelihoodThreshold

Likelihood threshold for BUILT_IN infotypes (e.g., LIKELY, VERY_LIKELY). Only applicable for BUILT_IN type.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.CustomSensitiveRuleLikelihoodThreshold;

CustomSensitiveRuleLikelihoodThreshold value = CustomSensitiveRuleLikelihoodThreshold.LIKELY;

// Open enum: use .of() to create instances from custom string values
CustomSensitiveRuleLikelihoodThreshold custom = CustomSensitiveRuleLikelihoodThreshold.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `LIKELY`        | LIKELY          |
| `VERY_LIKELY`   | VERY_LIKELY     |
| `POSSIBLE`      | POSSIBLE        |
| `UNLIKELY`      | UNLIKELY        |
| `VERY_UNLIKELY` | VERY_UNLIKELY   |