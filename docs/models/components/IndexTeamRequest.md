# IndexTeamRequest

Info about a team and optional version for that info


## Fields

| Field                                                                              | Type                                                                               | Required                                                                           | Description                                                                        |
| ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| `team`                                                                             | [TeamInfoDefinition](../../models/components/TeamInfoDefinition.md)                | :heavy_check_mark:                                                                 | Information about an employee's team                                               |
| `version`                                                                          | *Optional\<Long>*                                                                  | :heavy_minus_sign:                                                                 | Version number for the team object. If absent or 0 then no version checks are done |