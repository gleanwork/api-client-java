# AgentClientConfig

Describes the configurations that GleanChat has based on an AgentConfig.


## Fields

| Field                                                                         | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `agentConfig`                                                                 | [Optional\<AgentConfig>](../../models/components/AgentConfig.md)              | :heavy_minus_sign:                                                            | Describes the agent that executes the request.                                |
| `inputCharLimit`                                                              | *Optional\<Long>*                                                             | :heavy_minus_sign:                                                            | The character limit of an input to GleanChat under the specified AgentConfig. |