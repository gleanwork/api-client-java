# DatasourceVisibility

The visibility of the datasource, an enum of VISIBLE_TO_ALL, VISIBLE_TO_TEST_GROUP, NOT_VISIBLE

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.DatasourceVisibility;

DatasourceVisibility value = DatasourceVisibility.ENABLED_FOR_ALL;

// Open enum: use .of() to create instances from custom string values
DatasourceVisibility custom = DatasourceVisibility.of("custom_value");
```


## Values

| Name                     | Value                    |
| ------------------------ | ------------------------ |
| `ENABLED_FOR_ALL`        | ENABLED_FOR_ALL          |
| `ENABLED_FOR_TEST_GROUP` | ENABLED_FOR_TEST_GROUP   |
| `NOT_ENABLED`            | NOT_ENABLED              |