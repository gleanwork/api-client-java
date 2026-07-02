# PlatformProblemDetailCode

Stable machine-readable error code.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformProblemDetailCode;

PlatformProblemDetailCode value = PlatformProblemDetailCode.INVALID_REQUEST;

// Open enum: use .of() to create instances from custom string values
PlatformProblemDetailCode custom = PlatformProblemDetailCode.of("custom_value");
```


## Values

| Name                       | Value                      |
| -------------------------- | -------------------------- |
| `INVALID_REQUEST`          | invalid_request            |
| `MISSING_REQUIRED_FIELD`   | missing_required_field     |
| `INVALID_PARAMETER`        | invalid_parameter          |
| `INVALID_CURSOR`           | invalid_cursor             |
| `EXPIRED_CURSOR`           | expired_cursor             |
| `INVALID_FILTER`           | invalid_filter             |
| `INVALID_DATASOURCE`       | invalid_datasource         |
| `AUTHENTICATION_REQUIRED`  | authentication_required    |
| `TOKEN_EXPIRED`            | token_expired              |
| `INSUFFICIENT_PERMISSIONS` | insufficient_permissions   |
| `RESOURCE_NOT_FOUND`       | resource_not_found         |
| `METHOD_NOT_ALLOWED`       | method_not_allowed         |
| `REQUEST_TIMEOUT`          | request_timeout            |
| `CONFLICT`                 | conflict                   |
| `GONE`                     | gone                       |
| `UNPROCESSABLE_QUERY`      | unprocessable_query        |
| `RATE_LIMIT_EXCEEDED`      | rate_limit_exceeded        |
| `INTERNAL_ERROR`           | internal_error             |
| `SERVICE_UNAVAILABLE`      | service_unavailable        |