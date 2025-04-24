# DatasourceMembershipDefinition

describes the membership row of a group. Only one of memberUserId and memberGroupName can be specified.


## Fields

| Field                                                                 | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `groupName`                                                           | *String*                                                              | :heavy_check_mark:                                                    | The group for which the membership is specified                       |
| `memberUserId`                                                        | *Optional\<String>*                                                   | :heavy_minus_sign:                                                    | If the member is a user, then the email or datasource id for the user |
| `memberGroupName`                                                     | *Optional\<String>*                                                   | :heavy_minus_sign:                                                    | If the member is a group, then the name of the member group           |