# VersionSource

Provenance recorded on the staged commit or published version this import produces. Doesn't change the agent's management mode (workflowSource). GIT: synced from a Git repository. USER: uploaded by a user. Defaults to USER when omitted. Ignored for transient imports.


## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.VersionSource;

VersionSource value = VersionSource.GIT;
```


## Values

| Name   | Value  |
| ------ | ------ |
| `GIT`  | GIT    |
| `USER` | USER   |