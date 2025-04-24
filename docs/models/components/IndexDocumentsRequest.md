# IndexDocumentsRequest

Describes the request body of the /indexdocuments API call


## Fields

| Field                                                                      | Type                                                                       | Required                                                                   | Description                                                                |
| -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- |
| `uploadId`                                                                 | *Optional\<String>*                                                        | :heavy_minus_sign:                                                         | Optional id parameter to identify and track a batch of documents.          |
| `datasource`                                                               | *String*                                                                   | :heavy_check_mark:                                                         | Datasource of the documents                                                |
| `documents`                                                                | List\<[DocumentDefinition](../../models/components/DocumentDefinition.md)> | :heavy_check_mark:                                                         | Batch of documents being added/updated                                     |