# PersonToTeamRelationshipRelationship

The team member's relationship to the team. This defaults to MEMBER if not set.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PersonToTeamRelationshipRelationship;

PersonToTeamRelationshipRelationship value = PersonToTeamRelationshipRelationship.MEMBER;

// Open enum: use .of() to create instances from custom string values
PersonToTeamRelationshipRelationship custom = PersonToTeamRelationshipRelationship.of("custom_value");
```


## Values

| Name               | Value              |
| ------------------ | ------------------ |
| `MEMBER`           | MEMBER             |
| `MANAGER`          | MANAGER            |
| `LEAD`             | LEAD               |
| `POINT_OF_CONTACT` | POINT_OF_CONTACT   |
| `OTHER`            | OTHER              |