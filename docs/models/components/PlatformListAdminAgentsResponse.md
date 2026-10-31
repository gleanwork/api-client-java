# PlatformListAdminAgentsResponse

One page of agents.


## Fields

| Field                                                                   | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `results`                                                               | List\<[PlatformAgent](../../models/components/PlatformAgent.md)>        | :heavy_check_mark:                                                      | The agents on this page, ordered by name and then by agent_id.          |
| `hasMore`                                                               | *boolean*                                                               | :heavy_check_mark:                                                      | Whether more agents are available after this page.                      |
| `nextCursor`                                                            | *JsonNullable\<String>*                                                 | :heavy_minus_sign:                                                      | Opaque cursor for the next page; null or absent when has_more is false. |
| `requestId`                                                             | *String*                                                                | :heavy_check_mark:                                                      | Request identifier for correlating this response.                       |