# DebugDocumentsResponseItem

Describes the response body of a single document in the /debug/{datasource}/documents API call


## Fields

| Field                                                                                | Type                                                                                 | Required                                                                             | Description                                                                          |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| `docId`                                                                              | *Optional\<String>*                                                                  | :heavy_minus_sign:                                                                   | Id of the document                                                                   |
| `objectType`                                                                         | *Optional\<String>*                                                                  | :heavy_minus_sign:                                                                   | objectType of the document                                                           |
| `debugInfo`                                                                          | [Optional\<DebugDocumentResponse>](../../models/components/DebugDocumentResponse.md) | :heavy_minus_sign:                                                                   | Describes the response body of the /debug/{datasource}/document API call             |