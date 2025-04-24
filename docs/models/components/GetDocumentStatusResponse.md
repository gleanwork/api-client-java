# GetDocumentStatusResponse

Describes the response body of the /getdocumentstatus API call


## Fields

| Field                                                         | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `uploadStatus`                                                | *Optional\<String>*                                           | :heavy_minus_sign:                                            | Upload status, enum of NOT_UPLOADED, UPLOADED, STATUS_UNKNOWN |
| `lastUploadedAt`                                              | *Optional\<Long>*                                             | :heavy_minus_sign:                                            | Time of last successful upload, in epoch seconds              |
| `indexingStatus`                                              | *Optional\<String>*                                           | :heavy_minus_sign:                                            | Indexing status, enum of NOT_INDEXED, INDEXED, STATUS_UNKNOWN |
| `lastIndexedAt`                                               | *Optional\<Long>*                                             | :heavy_minus_sign:                                            | Time of last successful indexing, in epoch seconds            |