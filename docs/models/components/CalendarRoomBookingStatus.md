# CalendarRoomBookingStatus

The current booking status of the room resource associated with an event.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.CalendarRoomBookingStatus;

CalendarRoomBookingStatus value = CalendarRoomBookingStatus.NONE;

// Open enum: use .of() to create instances from custom string values
CalendarRoomBookingStatus custom = CalendarRoomBookingStatus.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `NONE`     | NONE       |
| `ACCEPTED` | ACCEPTED   |
| `DECLINED` | DECLINED   |
| `PENDING`  | PENDING    |