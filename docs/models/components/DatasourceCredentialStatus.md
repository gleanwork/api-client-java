# DatasourceCredentialStatus

Lifecycle state of the credentials installed for a datasource instance. Mirrors the internal admin Status enum so the handler can surface the same health signals already tracked today. EXPIRING_SOON is represented as VALID_WITH_WARNINGS (with detail in `message`); EXPIRED is surfaced as INVALID plus a non-null `expiresAt` in the past.


## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.DatasourceCredentialStatus;

DatasourceCredentialStatus value = DatasourceCredentialStatus.VALID;

// Open enum: use .of() to create instances from custom string values
DatasourceCredentialStatus custom = DatasourceCredentialStatus.of("custom_value");
```


## Values

| Name                  | Value                 |
| --------------------- | --------------------- |
| `VALID`               | VALID                 |
| `VALID_WITH_WARNINGS` | VALID_WITH_WARNINGS   |
| `VALIDATING`          | VALIDATING            |
| `INVALID`             | INVALID               |
| `MISSING`             | MISSING               |