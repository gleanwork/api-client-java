# McpServerBreakdown


## Fields

| Field                                                                      | Type                                                                       | Required                                                                   | Description                                                                |
| -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- |
| `server`                                                                   | *Optional\<String>*                                                        | :heavy_minus_sign:                                                         | MCP server name.                                                           |
| `totalCalls`                                                               | *Optional\<Long>*                                                          | :heavy_minus_sign:                                                         | Total number of MCP calls for this server in the specified time period.    |
| `activeUsers`                                                              | *Optional\<Long>*                                                          | :heavy_minus_sign:                                                         | Total number of active users for this server in the specified time period. |
| `hostApplications`                                                         | List\<*String*>                                                            | :heavy_minus_sign:                                                         | Host applications using this server in the specified time period.          |