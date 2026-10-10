# PlatformUserFilter

A filter on one user field.


## Fields

| Field                                                                                          | Type                                                                                           | Required                                                                                       | Description                                                                                    |
| ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- |
| `field`                                                                                        | *String*                                                                                       | :heavy_check_mark:                                                                             | The user field to filter on. The only supported field is is_active.                            |
| `values`                                                                                       | List\<*String*>                                                                                | :heavy_check_mark:                                                                             | The values to match. A user matches when any value matches.                                    |
| `operator`                                                                                     | [Optional\<PlatformUserFilterOperator>](../../models/components/PlatformUserFilterOperator.md) | :heavy_minus_sign:                                                                             | The only supported operator is EQUALS. Defaults to EQUALS.                                     |