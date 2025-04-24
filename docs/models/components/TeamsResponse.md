# TeamsResponse


## Fields

| Field                                                                | Type                                                                 | Required                                                             | Description                                                          |
| -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- |
| `results`                                                            | List\<[Team](../../models/components/Team.md)>                       | :heavy_minus_sign:                                                   | A Team and a deep copy of all its members for each ID in the request |
| `errors`                                                             | List\<*String*>                                                      | :heavy_minus_sign:                                                   | A list of IDs that could not be found.                               |