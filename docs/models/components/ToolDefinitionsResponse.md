# ToolDefinitionsResponse


## Fields

| Field                                                              | Type                                                               | Required                                                           | Description                                                        |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| `tools`                                                            | List\<[ToolDefinition](../../models/components/ToolDefinition.md)> | :heavy_check_mark:                                                 | Definitions for the requested tools that exist on this server.     |
| `notFound`                                                         | List\<*String*>                                                    | :heavy_minus_sign:                                                 | Requested names that do not exist on this server.                  |