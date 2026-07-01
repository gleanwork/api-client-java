# PlatformSearchResponse


## Fields

| Field                                                              | Type                                                               | Required                                                           | Description                                                        |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| `results`                                                          | List\<[PlatformResult](../../models/components/PlatformResult.md)> | :heavy_check_mark:                                                 | Ordered list of search results.                                    |
| `hasMore`                                                          | *boolean*                                                          | :heavy_check_mark:                                                 | Indicates whether additional pages of results are available.       |
| `nextCursor`                                                       | *Optional\<String>*                                                | :heavy_check_mark:                                                 | Opaque token to pass as `cursor` in the next request.              |
| `requestId`                                                        | *String*                                                           | :heavy_check_mark:                                                 | Platform-generated request ID for support correlation.             |