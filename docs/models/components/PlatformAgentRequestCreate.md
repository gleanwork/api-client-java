# PlatformAgentRequestCreate

New client-scoped request for an editable agent in the server's current UTC month.


## Fields

| Field                                                     | Type                                                      | Required                                                  | Description                                               |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| `agentId`                                                 | *String*                                                  | :heavy_check_mark:                                        | Identifier of the agent whose limit the request concerns. |
| `clientId`                                                | *String*                                                  | :heavy_check_mark:                                        | Explicit spend client whose limit the request concerns.   |
| `businessJustification`                                   | *Optional\<String>*                                       | :heavy_minus_sign:                                        | Optional explanation of why the increase is needed.       |