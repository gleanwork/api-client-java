# PlatformIdpGroupFilter

A filter on one IdP group field.


## Fields

| Field                                                                                                  | Type                                                                                                   | Required                                                                                               | Description                                                                                            |
| ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ |
| `field`                                                                                                | *String*                                                                                               | :heavy_check_mark:                                                                                     | The IdP group field to filter on. The only supported field is provider_instance.<br/>                  |
| `values`                                                                                               | List\<*String*>                                                                                        | :heavy_check_mark:                                                                                     | The values to match. An IdP group matches when any value matches.                                      |
| `operator`                                                                                             | [Optional\<PlatformIdpGroupFilterOperator>](../../models/components/PlatformIdpGroupFilterOperator.md) | :heavy_minus_sign:                                                                                     | The only supported operator is EQUALS. Defaults to EQUALS.                                             |