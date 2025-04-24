# DatasourceUserDefinition

describes a user in the datasource


## Fields

| Field                                                            | Type                                                             | Required                                                         | Description                                                      |
| ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- |
| `email`                                                          | *String*                                                         | :heavy_check_mark:                                               | N/A                                                              |
| `userId`                                                         | *Optional\<String>*                                              | :heavy_minus_sign:                                               | To be supplied if the user id in the datasource is not the email |
| `name`                                                           | *String*                                                         | :heavy_check_mark:                                               | N/A                                                              |
| `isActive`                                                       | *Optional\<Boolean>*                                             | :heavy_minus_sign:                                               | set to false if the user is a former employee or a bot           |