# PlatformUsageRequestsListRequest


## Fields

| Field                                                                            | Type                                                                             | Required                                                                         | Description                                                                      |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `pageSize`                                                                       | *Optional\<Long>*                                                                | :heavy_minus_sign:                                                               | Maximum page size; defaults to 20 and cannot exceed 100.                         |
| `cursor`                                                                         | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | Opaque continuation bound to filters and current authorization.                  |
| `filters`                                                                        | List\<[PlatformRequestFilter](../../models/components/PlatformRequestFilter.md)> | :heavy_minus_sign:                                                               | Optional structured filters on request status.                                   |