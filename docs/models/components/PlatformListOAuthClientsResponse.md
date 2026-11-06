# PlatformListOAuthClientsResponse

One page of OAuth clients.


## Fields

| Field                                                                        | Type                                                                         | Required                                                                     | Description                                                                  |
| ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- |
| `results`                                                                    | List\<[PlatformOAuthClient](../../models/components/PlatformOAuthClient.md)> | :heavy_check_mark:                                                           | The clients on this page, ordered by display_name and then by client_id.     |
| `hasMore`                                                                    | *boolean*                                                                    | :heavy_check_mark:                                                           | Whether more clients are available after this page.                          |
| `nextCursor`                                                                 | *JsonNullable\<String>*                                                      | :heavy_minus_sign:                                                           | Opaque cursor for the next page; null or absent when has_more is false.      |
| `requestId`                                                                  | *String*                                                                     | :heavy_check_mark:                                                           | Request identifier for correlating this response.                            |