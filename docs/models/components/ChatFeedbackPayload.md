# ChatFeedbackPayload

Payload for chat feedback reporting. Required when template is `CHAT_FEEDBACK`.


## Fields

| Field                                                                          | Type                                                                           | Required                                                                       | Description                                                                    |
| ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ |
| `rating`                                                                       | *Optional\<String>*                                                            | :heavy_minus_sign:                                                             | Rating given to the conversation (currently either "upvoted" or "downvoted").  |
| `issues`                                                                       | List\<*String*>                                                                | :heavy_minus_sign:                                                             | The type(s) of issue being reported.                                           |
| `comments`                                                                     | *Optional\<String>*                                                            | :heavy_minus_sign:                                                             | Additional freeform comments provided by the reporter.                         |
| `previousMessages`                                                             | List\<*String*>                                                                | :heavy_minus_sign:                                                             | Previous messages in this conversation.                                        |
| `chatTranscript`                                                               | List\<[FeedbackChatExchange](../../models/components/FeedbackChatExchange.md)> | :heavy_minus_sign:                                                             | N/A                                                                            |