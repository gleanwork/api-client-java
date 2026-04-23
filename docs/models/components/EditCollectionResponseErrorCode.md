# EditCollectionResponseErrorCode

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.EditCollectionResponseErrorCode;

EditCollectionResponseErrorCode value = EditCollectionResponseErrorCode.NAME_EXISTS;

// Open enum: use .of() to create instances from custom string values
EditCollectionResponseErrorCode custom = EditCollectionResponseErrorCode.of("custom_value");
```


## Values

| Name                        | Value                       |
| --------------------------- | --------------------------- |
| `NAME_EXISTS`               | NAME_EXISTS                 |
| `NOT_FOUND`                 | NOT_FOUND                   |
| `COLLECTION_PINNED`         | COLLECTION_PINNED           |
| `CONCURRENT_HIERARCHY_EDIT` | CONCURRENT_HIERARCHY_EDIT   |
| `HEIGHT_VIOLATION`          | HEIGHT_VIOLATION            |
| `WIDTH_VIOLATION`           | WIDTH_VIOLATION             |
| `NO_PERMISSIONS`            | NO_PERMISSIONS              |
| `CORRUPT_ITEM`              | CORRUPT_ITEM                |