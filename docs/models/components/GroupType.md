# GroupType

The type of user group

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.GroupType;

GroupType value = GroupType.DEPARTMENT;

// Open enum: use .of() to create instances from custom string values
GroupType custom = GroupType.of("custom_value");
```


## Values

| Name             | Value            |
| ---------------- | ---------------- |
| `DEPARTMENT`     | DEPARTMENT       |
| `ALL`            | ALL              |
| `TEAM`           | TEAM             |
| `JOB_TITLE`      | JOB_TITLE        |
| `ROLE_TYPE`      | ROLE_TYPE        |
| `LOCATION`       | LOCATION         |
| `REGION`         | REGION           |
| `EXTERNAL_GROUP` | EXTERNAL_GROUP   |