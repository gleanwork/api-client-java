# ConnectorType

The source from which document content was pulled, e.g. an API crawl or browser history

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.ConnectorType;

ConnectorType value = ConnectorType.API_CRAWL;

// Open enum: use .of() to create instances from custom string values
ConnectorType custom = ConnectorType.of("custom_value");
```


## Values

| Name               | Value              |
| ------------------ | ------------------ |
| `API_CRAWL`        | API_CRAWL          |
| `BROWSER_CRAWL`    | BROWSER_CRAWL      |
| `BROWSER_HISTORY`  | BROWSER_HISTORY    |
| `BUILTIN`          | BUILTIN            |
| `FEDERATED_SEARCH` | FEDERATED_SEARCH   |
| `PUSH_API`         | PUSH_API           |
| `WEB_CRAWL`        | WEB_CRAWL          |
| `NATIVE_HISTORY`   | NATIVE_HISTORY     |