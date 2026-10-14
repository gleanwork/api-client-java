# PlatformListIdpGroupsResponse

One page of IdP groups.


## Fields

| Field                                                                           | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `results`                                                                       | List\<[PlatformIdpGroup](../../models/components/PlatformIdpGroup.md)>          | :heavy_check_mark:                                                              | The IdP groups on this page, ordered by display_name and then by idp_group_id.<br/> |
| `hasMore`                                                                       | *boolean*                                                                       | :heavy_check_mark:                                                              | Whether more IdP groups are available after this page.                          |
| `nextCursor`                                                                    | *JsonNullable\<String>*                                                         | :heavy_minus_sign:                                                              | Opaque cursor for the next page; null or absent when has_more is false.         |
| `requestId`                                                                     | *String*                                                                        | :heavy_check_mark:                                                              | Request identifier for correlating this response.                               |