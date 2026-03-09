# ResponseStatus

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ResponseStatus;

ResponseStatus value = ResponseStatus.ACCEPTED;

// Open enum: use .of() to create instances from custom string values
ResponseStatus custom = ResponseStatus.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `ACCEPTED`    | ACCEPTED      |
| `DECLINED`    | DECLINED      |
| `NO_RESPONSE` | NO_RESPONSE   |
| `TENTATIVE`   | TENTATIVE     |