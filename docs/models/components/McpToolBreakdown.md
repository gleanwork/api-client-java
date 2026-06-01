# McpToolBreakdown


## Fields

| Field                                                                    | Type                                                                     | Required                                                                 | Description                                                              |
| ------------------------------------------------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ |
| `tool`                                                                   | *Optional\<String>*                                                      | :heavy_minus_sign:                                                       | MCP tool name.                                                           |
| `totalCalls`                                                             | *Optional\<Long>*                                                        | :heavy_minus_sign:                                                       | Total number of MCP calls for this tool in the specified time period.    |
| `activeUsers`                                                            | *Optional\<Long>*                                                        | :heavy_minus_sign:                                                       | Total number of active users for this tool in the specified time period. |
| `hostApplications`                                                       | List\<*String*>                                                          | :heavy_minus_sign:                                                       | Host applications using this tool in the specified time period.          |