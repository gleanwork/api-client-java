# ~~SensitiveInfoTypeLikelihoodThreshold~~

> :warning: **DEPRECATED**: Deprecated on 2026-02-05, removal scheduled for 2026-10-15: Field is deprecated.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.SensitiveInfoTypeLikelihoodThreshold;

SensitiveInfoTypeLikelihoodThreshold value = SensitiveInfoTypeLikelihoodThreshold.LIKELY;

// Open enum: use .of() to create instances from custom string values
SensitiveInfoTypeLikelihoodThreshold custom = SensitiveInfoTypeLikelihoodThreshold.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `LIKELY`        | LIKELY          |
| `VERY_LIKELY`   | VERY_LIKELY     |
| `POSSIBLE`      | POSSIBLE        |
| `UNLIKELY`      | UNLIKELY        |
| `VERY_UNLIKELY` | VERY_UNLIKELY   |