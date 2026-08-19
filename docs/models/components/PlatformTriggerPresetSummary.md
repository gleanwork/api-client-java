# PlatformTriggerPresetSummary


## Fields

| Field                                                | Type                                                 | Required                                             | Description                                          | Example                                              |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| `presetId`                                           | *String*                                             | :heavy_check_mark:                                   | ID of the preset. Pass this when creating a trigger. | jira_high_priority_bug                               |
| `datasource`                                         | *String*                                             | :heavy_check_mark:                                   | Datasource the preset fires on.                      | jira                                                 |
| `displayName`                                        | *String*                                             | :heavy_check_mark:                                   | Human-readable preset name.                          | High-priority Jira bugs                              |
| `description`                                        | *Optional\<String>*                                  | :heavy_minus_sign:                                   | Human-readable description of when the preset fires. | Fires when a high-priority bug is created.           |