# ClusterTypeEnum

The reason for inclusion of clusteredResults.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ClusterTypeEnum;

ClusterTypeEnum value = ClusterTypeEnum.SIMILAR;

// Open enum: use .of() to create instances from custom string values
ClusterTypeEnum custom = ClusterTypeEnum.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `SIMILAR`       | SIMILAR         |
| `FRESHNESS`     | FRESHNESS       |
| `TITLE`         | TITLE           |
| `CONTENT`       | CONTENT         |
| `NONE`          | NONE            |
| `THREAD_REPLY`  | THREAD_REPLY    |
| `THREAD_ROOT`   | THREAD_ROOT     |
| `PREFIX`        | PREFIX          |
| `SUFFIX`        | SUFFIX          |
| `AUTHOR_PREFIX` | AUTHOR_PREFIX   |
| `AUTHOR_SUFFIX` | AUTHOR_SUFFIX   |