# LastScanStatus

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.LastScanStatus;

LastScanStatus value = LastScanStatus.PENDING;

// Open enum: use .of() to create instances from custom string values
LastScanStatus custom = LastScanStatus.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `PENDING`    | PENDING      |
| `SUCCESS`    | SUCCESS      |
| `FAILURE`    | FAILURE      |
| `CANCELLED`  | CANCELLED    |
| `CANCELLING` | CANCELLING   |
| `ACTIVE`     | ACTIVE       |