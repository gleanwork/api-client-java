# PlatformSkillsListVersionsRequest


## Fields

| Field                                              | Type                                               | Required                                           | Description                                        |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| `skillId`                                          | *String*                                           | :heavy_check_mark:                                 | Glean skill ID.                                    |
| `pageSize`                                         | *Optional\<Long>*                                  | :heavy_minus_sign:                                 | Maximum number of versions to return.              |
| `cursor`                                           | *Optional\<String>*                                | :heavy_minus_sign:                                 | Opaque pagination cursor from a previous response. |