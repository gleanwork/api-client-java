# PlatformAgentRunMessageEventData

Payload for the Agents SSE event `message`.


## Fields

| Field                                                                                            | Type                                                                                             | Required                                                                                         | Description                                                                                      |
| ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ |
| `messages`                                                                                       | List\<[PlatformAgentRunStreamMessage](../../models/components/PlatformAgentRunStreamMessage.md)> | :heavy_check_mark:                                                                               | Messages emitted by the running agent in this event.                                             |