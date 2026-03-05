# ChatFile

Structure for file uploaded by a user for Chat.


## Fields

| Field                                                                      | Type                                                                       | Required                                                                   | Description                                                                | Example                                                                    |
| -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- |
| `id`                                                                       | *Optional\<String>*                                                        | :heavy_minus_sign:                                                         | Unique identifier of the file.                                             | FILE_1234                                                                  |
| `url`                                                                      | *Optional\<String>*                                                        | :heavy_minus_sign:                                                         | Url of the file.                                                           | www.google.com                                                             |
| `name`                                                                     | *Optional\<String>*                                                        | :heavy_minus_sign:                                                         | Name of the uploaded file.                                                 | sample.pdf                                                                 |
| `metadata`                                                                 | [Optional\<ChatFileMetadata>](../../models/components/ChatFileMetadata.md) | :heavy_minus_sign:                                                         | Metadata of a file uploaded by a user for Chat.                            |                                                                            |