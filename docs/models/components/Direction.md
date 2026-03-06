# Direction

The direction of the results asked with respect to the reference timestamp. Missing field defaults to OLDER. Only applicable when using a message_id.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.Direction;

Direction value = Direction.OLDER;
```


## Values

| Name    | Value   |
| ------- | ------- |
| `OLDER` | OLDER   |
| `NEWER` | NEWER   |