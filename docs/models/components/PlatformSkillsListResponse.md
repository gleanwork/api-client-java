# PlatformSkillsListResponse


## Fields

| Field                                                                 | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `skills`                                                              | List\<[PlatformSkill](../../models/components/PlatformSkill.md)>      | :heavy_check_mark:                                                    | Skills available to the user.                                         |
| `hasMore`                                                             | *boolean*                                                             | :heavy_check_mark:                                                    | Whether additional results are available.                             |
| `nextCursor`                                                          | *Optional\<String>*                                                   | :heavy_check_mark:                                                    | Cursor for the next page, or null when no more results are available. |
| `requestId`                                                           | *String*                                                              | :heavy_check_mark:                                                    | Platform-generated request ID for support correlation.                |