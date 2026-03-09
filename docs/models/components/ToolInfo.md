# ToolInfo


## Fields

| Field                                                                                 | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `metadata`                                                                            | [Optional\<ToolMetadata>](../../models/components/ToolMetadata.md)                    | :heavy_minus_sign:                                                                    | The manifest for a tool that can be used to augment Glean Assistant.                  |
| `parameters`                                                                          | Map\<String, [WriteActionParameter](../../models/components/WriteActionParameter.md)> | :heavy_minus_sign:                                                                    | Parameters supported by the tool.                                                     |