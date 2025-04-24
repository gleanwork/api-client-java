# FileUploadConfig

Configuration settings for the chat file upload feature


## Fields

| Field                                                         | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `enabled`                                                     | *Optional\<Boolean>*                                          | :heavy_minus_sign:                                            | Whether file upload for Chat is enabled for the deployment    |
| `maxFileCount`                                                | *Optional\<Long>*                                             | :heavy_minus_sign:                                            | Maximum number of files that can be uploaded in a single turn |
| `maxFileSize`                                                 | *Optional\<Long>*                                             | :heavy_minus_sign:                                            | Maximum file size, in bytes, that is allowed for upload       |
| `uploadTimeoutSeconds`                                        | *Optional\<Long>*                                             | :heavy_minus_sign:                                            | Timeout in seconds for polling the file upload status         |