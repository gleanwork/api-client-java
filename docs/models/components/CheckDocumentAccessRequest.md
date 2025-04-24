# CheckDocumentAccessRequest

Describes the request body of the /checkdocumentaccess API call


## Fields

| Field                                        | Type                                         | Required                                     | Description                                  |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| `datasource`                                 | *String*                                     | :heavy_check_mark:                           | Datasource of document to check access for.  |
| `objectType`                                 | *String*                                     | :heavy_check_mark:                           | Object type of document to check access for. |
| `docId`                                      | *String*                                     | :heavy_check_mark:                           | Glean Document ID to check access for.       |
| `userEmail`                                  | *String*                                     | :heavy_check_mark:                           | Email of user to check access for.           |