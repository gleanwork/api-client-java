# AgentCapabilities

Describes features that the agent supports. example: {
  "ap.io.messages": true,
  "ap.io.streaming": true
}


## Fields

| Field                                                                                                                         | Type                                                                                                                          | Required                                                                                                                      | Description                                                                                                                   |
| ----------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------- |
| `apIoMessages`                                                                                                                | *Optional\<Boolean>*                                                                                                          | :heavy_minus_sign:                                                                                                            | Whether the agent supports messages as an input. If true, you'll pass `messages` as an input when running the agent.          |
| `apIoStreaming`                                                                                                               | *Optional\<Boolean>*                                                                                                          | :heavy_minus_sign:                                                                                                            | Whether the agent supports streaming output. If true, you you can stream agent ouput. All agents currently support streaming. |
| `additionalProperties`                                                                                                        | Map\<String, *Object*>                                                                                                        | :heavy_minus_sign:                                                                                                            | N/A                                                                                                                           |