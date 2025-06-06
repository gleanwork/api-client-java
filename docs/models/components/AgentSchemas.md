# AgentSchemas

Defines the structure and properties of an agent.


## Fields

| Field                                                   | Type                                                    | Required                                                | Description                                             | Example                                                 |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| `agentId`                                               | *String*                                                | :heavy_check_mark:                                      | The ID of the agent.                                    | mho4lwzylcozgoc2                                        |
| `inputSchema`                                           | [InputSchema](../../models/components/InputSchema.md)   | :heavy_check_mark:                                      | The schema for the agent input. In JSON Schema format.  |                                                         |
| `outputSchema`                                          | [OutputSchema](../../models/components/OutputSchema.md) | :heavy_check_mark:                                      | The schema for the agent output. In JSON Schema format. |                                                         |