# PlatformAgentSkill

A skill defined inline in the agent. Reference a published skill through `dependencies` instead.



## Fields

| Field                                                                                              | Type                                                                                               | Required                                                                                           | Description                                                                                        |
| -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- |
| `displayName`                                                                                      | *String*                                                                                           | :heavy_check_mark:                                                                                 | Human-readable skill name.                                                                         |
| `mainContent`                                                                                      | *String*                                                                                           | :heavy_check_mark:                                                                                 | Main skill content, inlined from `SKILL.md`.                                                       |
| `files`                                                                                            | List\<[PlatformSkillSourcePreviewFile](../../models/components/PlatformSkillSourcePreviewFile.md)> | :heavy_minus_sign:                                                                                 | Additional files bundled in the skill folder.                                                      |