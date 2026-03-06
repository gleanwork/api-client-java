# ConfigurationValue

A single configuration value, either a scalar or a list


## Fields

| Field                                                                                             | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `value`                                                                                           | *Optional\<String>*                                                                               | :heavy_minus_sign:                                                                                | The configuration value as a string. Only one of value or valueList should be populated.          |
| `valueList`                                                                                       | List\<*String*>                                                                                   | :heavy_minus_sign:                                                                                | The configuration value as a list of strings. Only one of value or valueList should be populated. |