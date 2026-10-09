# PlatformPersonType

Person employment status or account type.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformPersonType;

PlatformPersonType value = PlatformPersonType.FULL_TIME;

// Open enum: use .of() to create instances from custom string values
PlatformPersonType custom = PlatformPersonType.of("custom_value");
```


## Values

| Name              | Value             |
| ----------------- | ----------------- |
| `FULL_TIME`       | FULL_TIME         |
| `CONTRACTOR`      | CONTRACTOR        |
| `NON_EMPLOYEE`    | NON_EMPLOYEE      |
| `FORMER_EMPLOYEE` | FORMER_EMPLOYEE   |