# FeedbackChatExchange


## Fields

| Field                                                              | Type                                                               | Required                                                           | Description                                                        |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| `timestamp`                                                        | *Optional\<Long>*                                                  | :heavy_minus_sign:                                                 | Unix timestamp in millis for the chat request.                     |
| `agent`                                                            | *Optional\<String>*                                                | :heavy_minus_sign:                                                 | Either DEFAULT (company knowledge) or GPT (world knowledge).       |
| `userQuery`                                                        | *Optional\<String>*                                                | :heavy_minus_sign:                                                 | Initial query entered by the user.                                 |
| `searchQuery`                                                      | *Optional\<String>*                                                | :heavy_minus_sign:                                                 | Search query performed by the agent.                               |
| `resultDocuments`                                                  | List\<[ResultDocument](../../models/components/ResultDocument.md)> | :heavy_minus_sign:                                                 | List of documents read by the agent.                               |
| `response`                                                         | *Optional\<String>*                                                | :heavy_minus_sign:                                                 | N/A                                                                |