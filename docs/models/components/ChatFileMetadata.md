# ChatFileMetadata

Metadata of a file uploaded by a user for Chat.


## Fields

| Field                                                                                | Type                                                                                 | Required                                                                             | Description                                                                          |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| `status`                                                                             | [Optional\<ChatFileStatus>](../../models/components/ChatFileStatus.md)               | :heavy_minus_sign:                                                                   | Current status of the file.                                                          |
| `uploadTime`                                                                         | *Optional\<Long>*                                                                    | :heavy_minus_sign:                                                                   | Upload time, in epoch seconds.                                                       |
| `processedSize`                                                                      | *Optional\<Long>*                                                                    | :heavy_minus_sign:                                                                   | Size of the processed file in bytes.                                                 |
| `failureReason`                                                                      | [Optional\<ChatFileFailureReason>](../../models/components/ChatFileFailureReason.md) | :heavy_minus_sign:                                                                   | Reason for failed status.                                                            |
| `mimeType`                                                                           | *Optional\<String>*                                                                  | :heavy_minus_sign:                                                                   | MIME type of the file.                                                               |