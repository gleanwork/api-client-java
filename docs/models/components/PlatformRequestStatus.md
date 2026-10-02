# PlatformRequestStatus

Stored request state.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformRequestStatus;

PlatformRequestStatus value = PlatformRequestStatus.PENDING;

// Open enum: use .of() to create instances from custom string values
PlatformRequestStatus custom = PlatformRequestStatus.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `PENDING`  | PENDING    |
| `APPROVED` | APPROVED   |
| `DENIED`   | DENIED     |