# PlatformAgentRunWaitResponse


## Fields

| Field                                                                      | Type                                                                       | Required                                                                   | Description                                                                |
| -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- |
| `run`                                                                      | [Optional\<PlatformAgentRun>](../../models/components/PlatformAgentRun.md) | :heavy_minus_sign:                                                         | N/A                                                                        |
| `messages`                                                                 | List\<[PlatformMessage](../../models/components/PlatformMessage.md)>       | :heavy_minus_sign:                                                         | Messages returned by the completed run.                                    |
| `requestId`                                                                | *String*                                                                   | :heavy_check_mark:                                                         | Platform-generated request ID for support correlation.                     |