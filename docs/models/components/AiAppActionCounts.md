# AiAppActionCounts

Map from action to frequency.


## Fields

| Field                                                                   | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `totalSlackbotResponses`                                                | *Optional\<Long>*                                                       | :heavy_minus_sign:                                                      | Total number of Slackbot responses, both proactive and reactive.        |
| `totalSlackbotResponsesShared`                                          | *Optional\<Long>*                                                       | :heavy_minus_sign:                                                      | Total number of Slackbot responses shared publicly (upvoted).           |
| `totalSlackbotResponsesNotHelpful`                                      | *Optional\<Long>*                                                       | :heavy_minus_sign:                                                      | Total number of Slackbot responses rejected as not helpful (downvoted). |
| `totalChatMessages`                                                     | *Optional\<Long>*                                                       | :heavy_minus_sign:                                                      | Total number of Chat messages sent in requested period.                 |
| `totalUpvotes`                                                          | *Optional\<Long>*                                                       | :heavy_minus_sign:                                                      | Total number of Chat messages which received upvotes by the user.       |
| `totalDownvotes`                                                        | *Optional\<Long>*                                                       | :heavy_minus_sign:                                                      | Total number of Chat messages which received downvotes by the user.     |
| `additionalProperties`                                                  | Map\<String, *long*>                                                    | :heavy_minus_sign:                                                      | N/A                                                                     |