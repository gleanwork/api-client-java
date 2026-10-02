# PlatformRequestScope

Increase for the stored request month or an ongoing standing-rule increase.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformRequestScope;

PlatformRequestScope value = PlatformRequestScope.PERIOD;

// Open enum: use .of() to create instances from custom string values
PlatformRequestScope custom = PlatformRequestScope.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `PERIOD`  | PERIOD    |
| `ONGOING` | ONGOING   |