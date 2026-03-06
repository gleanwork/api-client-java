# AnnouncementChannel

This determines whether this is a Social Feed post or a regular announcement.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.AnnouncementChannel;

AnnouncementChannel value = AnnouncementChannel.MAIN;

// Open enum: use .of() to create instances from custom string values
AnnouncementChannel custom = AnnouncementChannel.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `MAIN`        | MAIN          |
| `SOCIAL_FEED` | SOCIAL_FEED   |