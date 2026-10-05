# PlatformSkillSyncResponse


## Fields

| Field                                                  | Type                                                   | Required                                               | Description                                            |
| ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ |
| `commitSha`                                            | *String*                                               | :heavy_check_mark:                                     | Git commit SHA now associated with the skill.          |
| `isUpdated`                                            | *boolean*                                              | :heavy_check_mark:                                     | Whether this request created a new skill version.      |
| `requestId`                                            | *String*                                               | :heavy_check_mark:                                     | Platform-generated request ID for support correlation. |