# AccessRequestPermissionDeniedResponseException


## Fields

| Field                                                  | Type                                                   | Required                                               | Description                                            | Example                                                |
| ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ |
| `errorType`                                            | [ErrorType](../../models/errors/ErrorType.md)          | :heavy_check_mark:                                     | N/A                                                    |                                                        |
| `createdBy`                                            | [Person](../../models/components/Person.md)            | :heavy_check_mark:                                     | N/A                                                    | {<br/>"name": "George Clooney",<br/>"obfuscatedId": "abc123"<br/>} |
| `requestableRoles`                                     | List\<[UserRole](../../models/components/UserRole.md)> | :heavy_check_mark:                                     | N/A                                                    |                                                        |
| `hasPendingRequest`                                    | *boolean*                                              | :heavy_check_mark:                                     | N/A                                                    |                                                        |