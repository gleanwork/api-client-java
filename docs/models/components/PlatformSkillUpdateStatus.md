# PlatformSkillUpdateStatus

Activation to apply for the authenticated caller. For the owner, this updates the skill's stored status. For any other caller, it updates only that caller's setting.


## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformSkillUpdateStatus;

PlatformSkillUpdateStatus value = PlatformSkillUpdateStatus.ENABLED;
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `ENABLED`  | ENABLED    |
| `DISABLED` | DISABLED   |