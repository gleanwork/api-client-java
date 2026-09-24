# PlatformSkillSourcePreviewStreamError

Terminal failure event carrying the failure as a problem detail.


## Fields

| Field                                                                                                             | Type                                                                                                              | Required                                                                                                          | Description                                                                                                       |
| ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| `type`                                                                                                            | [PlatformSkillSourcePreviewStreamErrorType](../../models/components/PlatformSkillSourcePreviewStreamErrorType.md) | :heavy_check_mark:                                                                                                | Event type, also sent as the SSE `event` name.                                                                    |
| `error`                                                                                                           | [PlatformUnauthorizedAgentToolsProblem](../../models/components/PlatformUnauthorizedAgentToolsProblem.md)         | :heavy_check_mark:                                                                                                | Problem detail extended with `authentication_suggestions` naming each tool the caller must authorize.             |