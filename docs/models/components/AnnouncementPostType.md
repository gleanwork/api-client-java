# AnnouncementPostType

This determines whether this is an external-link post or a regular announcement post. TEXT - Regular announcement that can contain rich text. LINK - Announcement that is linked to an external site.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.AnnouncementPostType;

AnnouncementPostType value = AnnouncementPostType.TEXT;

// Open enum: use .of() to create instances from custom string values
AnnouncementPostType custom = AnnouncementPostType.of("custom_value");
```


## Values

| Name   | Value  |
| ------ | ------ |
| `TEXT` | TEXT   |
| `LINK` | LINK   |