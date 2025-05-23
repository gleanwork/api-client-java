# AgentRunCreate

Payload for creating a run.


## Fields

| Field                                                | Type                                                 | Required                                             | Description                                          |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| `agentId`                                            | *Optional\<String>*                                  | :heavy_minus_sign:                                   | The ID of the agent to run.                          |
| `input`                                              | Map\<String, *Object*>                               | :heavy_minus_sign:                                   | The input to the agent.                              |
| `messages`                                           | List\<[Message](../../models/components/Message.md)> | :heavy_minus_sign:                                   | The messages to pass an input to the agent.          |