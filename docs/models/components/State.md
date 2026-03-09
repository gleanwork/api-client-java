# State

The verification state for the document.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.State;

State value = State.UNVERIFIED;

// Open enum: use .of() to create instances from custom string values
State custom = State.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `UNVERIFIED` | UNVERIFIED   |
| `VERIFIED`   | VERIFIED     |
| `DEPRECATED` | DEPRECATED   |