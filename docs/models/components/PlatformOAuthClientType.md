# PlatformOAuthClientType

Whether an OAuth client can keep a secret.

## Example Usage

```java
import com.glean.api_client.glean_api_client.models.components.PlatformOAuthClientType;

PlatformOAuthClientType value = PlatformOAuthClientType.CONFIDENTIAL;

// Open enum: use .of() to create instances from custom string values
PlatformOAuthClientType custom = PlatformOAuthClientType.of("custom_value");
```


## Values

| Name           | Value          |
| -------------- | -------------- |
| `CONFIDENTIAL` | CONFIDENTIAL   |
| `PUBLIC`       | PUBLIC         |