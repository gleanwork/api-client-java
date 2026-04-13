# DlpIssueStatus

Status of a DLP issue.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.DlpIssueStatus;

DlpIssueStatus value = DlpIssueStatus.OPEN;

// Open enum: use .of() to create instances from custom string values
DlpIssueStatus custom = DlpIssueStatus.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `OPEN`        | OPEN          |
| `CLOSED`      | CLOSED        |
| `IN_PROGRESS` | IN_PROGRESS   |
| `RESOLVED`    | RESOLVED      |