# ChatResult


## Fields

| Field                                                                                       | Type                                                                                        | Required                                                                                    | Description                                                                                 |
| ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- |
| `chat`                                                                                      | [Optional\<Chat>](../../models/components/Chat.md)                                          | :heavy_minus_sign:                                                                          | A historical representation of a series of chat messages a user had with Glean Assistant.   |
| `trackingToken`                                                                             | *Optional\<String>*                                                                         | :heavy_minus_sign:                                                                          | An opaque token that represents this particular Chat. To be used for `/feedback` reporting. |