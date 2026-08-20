# PlatformTriggerPresetEventSearchRequest


## Fields

| Field                                                       | Type                                                        | Required                                                    | Description                                                 | Example                                                     |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `inputs`                                                    | Map\<String, *String*>                                      | :heavy_minus_sign:                                          | Values for the preset's input fields, keyed by field name.<br/> | {<br/>"repository": "acme/payments-api"<br/>}               |
| `pageSize`                                                  | *Optional\<Long>*                                           | :heavy_minus_sign:                                          | Maximum number of events to return.                         |                                                             |