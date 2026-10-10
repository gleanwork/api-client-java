# PlatformListUsersResponse

One page of users.


## Fields

| Field                                                                   | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `results`                                                               | List\<[PlatformUser](../../models/components/PlatformUser.md)>          | :heavy_check_mark:                                                      | The users on this page, ordered by display_name and then by user_id.    |
| `hasMore`                                                               | *boolean*                                                               | :heavy_check_mark:                                                      | Whether more users are available after this page.                       |
| `nextCursor`                                                            | *JsonNullable\<String>*                                                 | :heavy_minus_sign:                                                      | Opaque cursor for the next page; null or absent when has_more is false. |
| `requestId`                                                             | *String*                                                                | :heavy_check_mark:                                                      | Request identifier for correlating this response.                       |