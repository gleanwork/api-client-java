# CollectionPinnableTargets

What targets can a Collection be pinned to.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.CollectionPinnableTargets;

CollectionPinnableTargets value = CollectionPinnableTargets.RESOURCE_CARD;

// Open enum: use .of() to create instances from custom string values
CollectionPinnableTargets custom = CollectionPinnableTargets.of("custom_value");
```


## Values

| Name                | Value               |
| ------------------- | ------------------- |
| `RESOURCE_CARD`     | RESOURCE_CARD       |
| `TEAM_PROFILE_PAGE` | TEAM_PROFILE_PAGE   |