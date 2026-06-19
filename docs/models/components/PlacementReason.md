# PlacementReason

Placement source for ranked feed results. ORGANIC means the card was emitted by normal feed ranking. PROMO means the card was inserted by the homepage cards promo framework.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlacementReason;

PlacementReason value = PlacementReason.ORGANIC;

// Open enum: use .of() to create instances from custom string values
PlacementReason custom = PlacementReason.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `ORGANIC` | ORGANIC   |
| `PROMO`   | PROMO     |