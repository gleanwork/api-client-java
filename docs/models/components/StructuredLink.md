# StructuredLink

The display configuration for a link.


## Fields

| Field                                                                             | Type                                                                              | Required                                                                          | Description                                                                       | Example                                                                           |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `name`                                                                            | *Optional\<String>*                                                               | :heavy_minus_sign:                                                                | The display name for the link                                                     |                                                                                   |
| `url`                                                                             | *Optional\<String>*                                                               | :heavy_minus_sign:                                                                | The URL for the link.                                                             |                                                                                   |
| `iconConfig`                                                                      | [Optional\<IconConfig>](../../models/components/IconConfig.md)                    | :heavy_minus_sign:                                                                | Defines how to render an icon                                                     | {<br/>"color": "#343CED",<br/>"key": "person_icon",<br/>"iconType": "GLYPH",<br/>"name": "user"<br/>} |