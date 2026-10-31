# PlatformOAuthClientSupportedApp

An app that an LLM Gateway client is set up for.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformOAuthClientSupportedApp;

PlatformOAuthClientSupportedApp value = PlatformOAuthClientSupportedApp.CLAUDE_CODE;

// Open enum: use .of() to create instances from custom string values
PlatformOAuthClientSupportedApp custom = PlatformOAuthClientSupportedApp.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `CLAUDE_CODE` | CLAUDE_CODE   |
| `CODEX`       | CODEX         |