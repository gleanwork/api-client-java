# CustomerMetadata


## Fields

| Field                                                                       | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `datasourceId`                                                              | *Optional\<String>*                                                         | :heavy_minus_sign:                                                          | The user visible id of the salesforce customer account.                     |
| `customData`                                                                | Map\<String, [CustomDataValue](../../models/components/CustomDataValue.md)> | :heavy_minus_sign:                                                          | Custom fields specific to individual datasources                            |