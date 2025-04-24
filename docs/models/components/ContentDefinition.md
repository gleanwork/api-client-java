# ContentDefinition

Describes text content or base64 encoded binary content


## Fields

| Field                                                                                     | Type                                                                                      | Required                                                                                  | Description                                                                               |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `mimeType`                                                                                | *String*                                                                                  | :heavy_check_mark:                                                                        | N/A                                                                                       |
| `textContent`                                                                             | *Optional\<String>*                                                                       | :heavy_minus_sign:                                                                        | text content. Only one of textContent or binary content can be specified                  |
| `binaryContent`                                                                           | *Optional\<String>*                                                                       | :heavy_minus_sign:                                                                        | base64 encoded binary content. Only one of textContent or binary content can be specified |