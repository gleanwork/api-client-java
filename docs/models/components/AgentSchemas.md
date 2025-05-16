# AgentSchemas

Defines the structure and properties of an agent.


## Fields

| Field                                                   | Type                                                    | Required                                                | Description                                             |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| `agentId`                                               | *String*                                                | :heavy_check_mark:                                      | The ID of the agent.                                    |
| `inputSchema`                                           | [InputSchema](../../models/components/InputSchema.md)   | :heavy_check_mark:                                      | The schema for the agent input. In JSON Schema format.  |
| `outputSchema`                                          | [OutputSchema](../../models/components/OutputSchema.md) | :heavy_check_mark:                                      | The schema for the agent output. In JSON Schema format. |