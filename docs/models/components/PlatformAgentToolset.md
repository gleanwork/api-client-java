# PlatformAgentToolset

A tool provider and the subset of its tools available to the agent.


## Fields

| Field                                                                                    | Type                                                                                     | Required                                                                                 | Description                                                                              |
| ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- |
| `toolProviderId`                                                                         | *String*                                                                                 | :heavy_check_mark:                                                                       | ID of the tool provider, or `native` for built-in Glean tools.                           |
| `selectedTools`                                                                          | List\<[PlatformAgentSelectedTool](../../models/components/PlatformAgentSelectedTool.md)> | :heavy_minus_sign:                                                                       | Tools from the provider that are exposed to the agent.                                   |
| `customisationData`                                                                      | [Optional\<CustomisationData>](../../models/components/CustomisationData.md)             | :heavy_minus_sign:                                                                       | Settings applied to every tool in this provider entry.                                   |