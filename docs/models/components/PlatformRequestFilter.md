# PlatformRequestFilter

A status filter using the backend's status-IN matching.


## Fields

| Field                                                                            | Type                                                                             | Required                                                                         | Description                                                                      |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `field`                                                                          | *String*                                                                         | :heavy_check_mark:                                                               | Allowed field is status, spelled exactly in lowercase.                           |
| `values`                                                                         | List\<[PlatformRequestStatus](../../models/components/PlatformRequestStatus.md)> | :heavy_check_mark:                                                               | Status values to match with OR.                                                  |
| `operator`                                                                       | [Optional\<Operator>](../../models/components/Operator.md)                       | :heavy_minus_sign:                                                               | Only EQUALS is supported; defaults to EQUALS when omitted.                       |