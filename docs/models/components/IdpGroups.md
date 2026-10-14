# IdpGroups

How to resolve effective usage limits when a user belongs to multiple IdP groups.


## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.IdpGroups;

IdpGroups value = IdpGroups.HIGHEST;

// Open enum: use .of() to create instances from custom string values
IdpGroups custom = IdpGroups.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `HIGHEST` | HIGHEST   |
| `LOWEST`  | LOWEST    |