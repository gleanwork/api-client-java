# AgentRun

Payload for creating a run.


## Fields

| Field                                                                              | Type                                                                               | Required                                                                           | Description                                                                        |
| ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| `agentId`                                                                          | *Optional\<String>*                                                                | :heavy_minus_sign:                                                                 | The ID of the agent to run.                                                        |
| `input`                                                                            | [Optional\<AgentRunInput>](../../models/components/AgentRunInput.md)               | :heavy_minus_sign:                                                                 | The input to the agent.                                                            |
| `messages`                                                                         | List\<[Message](../../models/components/Message.md)>                               | :heavy_minus_sign:                                                                 | The messages to pass an input to the agent.                                        |
| `status`                                                                           | [Optional\<AgentExecutionStatus>](../../models/components/AgentExecutionStatus.md) | :heavy_minus_sign:                                                                 | The status of the run. One of 'error', 'success'.                                  |