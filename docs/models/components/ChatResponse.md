# ChatResponse

A single response from the /chat backend.


## Fields

| Field                                                                | Type                                                                 | Required                                                             | Description                                                          | Example                                                              |
| -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- |
| `messages`                                                           | List\<[ChatMessage](../../models/components/ChatMessage.md)>         | :heavy_minus_sign:                                                   | N/A                                                                  |                                                                      |
| `chatId`                                                             | *Optional\<String>*                                                  | :heavy_minus_sign:                                                   | The id of the associated Chat the messages belong to, if one exists. |                                                                      |
| `followUpPrompts`                                                    | List\<*String*>                                                      | :heavy_minus_sign:                                                   | Follow-up prompts for the user to potentially use                    |                                                                      |
| `backendTimeMillis`                                                  | *Optional\<Long>*                                                    | :heavy_minus_sign:                                                   | Time in milliseconds the backend took to respond to the request.     | 1100                                                                 |
| `chatSessionTrackingToken`                                           | *Optional\<String>*                                                  | :heavy_minus_sign:                                                   | A token that is used to track the session.                           |                                                                      |