# ResponseHint

Hints for the response content.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ResponseHint;

ResponseHint value = ResponseHint.ALL_RESULT_COUNTS;

// Open enum: use .of() to create instances from custom string values
ResponseHint custom = ResponseHint.of("custom_value");
```


## Values

| Name                  | Value                 |
| --------------------- | --------------------- |
| `ALL_RESULT_COUNTS`   | ALL_RESULT_COUNTS     |
| `FACET_RESULTS`       | FACET_RESULTS         |
| `QUERY_METADATA`      | QUERY_METADATA        |
| `RESULTS`             | RESULTS               |
| `SPELLCHECK_METADATA` | SPELLCHECK_METADATA   |