# AgentConfig

Describes the agent that executes the request.


## Fields

| Field                                                                                                 | Type                                                                                                  | Required                                                                                              | Description                                                                                           |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `agent`                                                                                               | [Optional\<AgentEnum>](../../models/components/AgentEnum.md)                                          | :heavy_minus_sign:                                                                                    | Name of the agent.                                                                                    |
| `toolSets`                                                                                            | [Optional\<ToolSets>](../../models/components/ToolSets.md)                                            | :heavy_minus_sign:                                                                                    | The types of tools that the agent is allowed to use. Only works with FAST and ADVANCED `agent` values |
| `mode`                                                                                                | [Optional\<Mode>](../../models/components/Mode.md)                                                    | :heavy_minus_sign:                                                                                    | Top level modes to run GleanChat in.                                                                  |