# DebugDocumentResponse

Describes the response body of the /debug/{datasource}/document API call


## Fields

| Field                                                                                                | Type                                                                                                 | Required                                                                                             | Description                                                                                          |
| ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| `status`                                                                                             | [Optional\<DocumentStatusResponse>](../../models/components/DocumentStatusResponse.md)               | :heavy_minus_sign:                                                                                   | Describes the document status response body                                                          |
| `uploadedPermissions`                                                                                | [Optional\<DocumentPermissionsDefinition>](../../models/components/DocumentPermissionsDefinition.md) | :heavy_minus_sign:                                                                                   | describes the access control details of the document                                                 |