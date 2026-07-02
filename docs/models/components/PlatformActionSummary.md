# PlatformActionSummary


## Fields

| Field                                              | Type                                               | Required                                           | Description                                        |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| `toolId`                                           | *String*                                           | :heavy_check_mark:                                 | Unique identifier of the action.                   |
| `displayName`                                      | *String*                                           | :heavy_check_mark:                                 | Display name of the action.                        |
| `type`                                             | *Optional\<String>*                                | :heavy_minus_sign:                                 | Tool type.                                         |
| `authType`                                         | *Optional\<String>*                                | :heavy_minus_sign:                                 | Authentication type required by the action.        |
| `writeActionType`                                  | *Optional\<String>*                                | :heavy_minus_sign:                                 | Write-action execution type.                       |
| `isSetupFinished`                                  | *Optional\<Boolean>*                               | :heavy_minus_sign:                                 | Whether this action has been fully configured.     |
| `dataSource`                                       | *Optional\<String>*                                | :heavy_minus_sign:                                 | Kind of knowledge the action accesses or modifies. |