# LifeCycleEventEvent

Type of event

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.LifeCycleEventEvent;

LifeCycleEventEvent value = LifeCycleEventEvent.UPLOADED;

// Open enum: use .of() to create instances from custom string values
LifeCycleEventEvent custom = LifeCycleEventEvent.of("custom_value");
```


## Values

| Name                 | Value                |
| -------------------- | -------------------- |
| `UPLOADED`           | UPLOADED             |
| `INDEXED`            | INDEXED              |
| `DELETION_REQUESTED` | DELETION_REQUESTED   |
| `DELETED`            | DELETED              |