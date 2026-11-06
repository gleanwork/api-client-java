# PlatformDocumentsBatchWarningContext


## Fields

| Field                                                                            | Type                                                                             | Required                                                                         | Description                                                                      |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `index`                                                                          | *long*                                                                           | :heavy_check_mark:                                                               | Zero-based index into document_specs.                                            |
| `documentId`                                                                     | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | Submitted document_id when the spec was an ID.                                   |
| `url`                                                                            | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | Submitted URL when the spec was a URL. Empty when the caller sent an empty url.<br/> |