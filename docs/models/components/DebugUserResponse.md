# DebugUserResponse

Describes the response body of the /debug/{datasource}/user API call


## Fields

| Field                                                                                    | Type                                                                                     | Required                                                                                 | Description                                                                              |
| ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- |
| `status`                                                                                 | [Optional\<UserStatusResponse>](../../models/components/UserStatusResponse.md)           | :heavy_minus_sign:                                                                       | Describes the user status response body                                                  |
| `uploadedGroups`                                                                         | List\<[DatasourceGroupDefinition](../../models/components/DatasourceGroupDefinition.md)> | :heavy_minus_sign:                                                                       | List of groups the user is a member of, as uploaded via permissions API.                 |