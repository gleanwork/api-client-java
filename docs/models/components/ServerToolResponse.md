# ServerToolResponse

Response to a server tool request. The applicable fields depend on requestType:

For EXECUTION requests:
- isGranted: whether tool execution is approved
- reason: optional explanation

For AUTHENTICATION_SUGGESTION requests:
- isGranted: whether auth completed successfully (true=connected, false=skipped)
- authContext: contains serverId or actionPackId for identifying the authenticated entity
- reason: optional explanation for skip

For VOTE_SUGGESTION requests:
- voted: whether the user voted for this tool

For SANDBOX_EGRESS requests:
- isGranted: whether the sandbox egress call is approved



## Fields

| Field                                                                                              | Type                                                                                               | Required                                                                                           | Description                                                                                        |
| -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- |
| `requestType`                                                                                      | [ServerToolResponseRequestType](../../models/components/ServerToolResponseRequestType.md)          | :heavy_check_mark:                                                                                 | The type of request made to the user.                                                              |
| `requestId`                                                                                        | *String*                                                                                           | :heavy_check_mark:                                                                                 | Unique identifier for this request.                                                                |
| `isGranted`                                                                                        | *Optional\<Boolean>*                                                                               | :heavy_minus_sign:                                                                                 | Whether tool request is granted (indicates approval for execution, or completion for auth).        |
| `grantScope`                                                                                       | [Optional\<GrantScope>](../../models/components/GrantScope.md)                                     | :heavy_minus_sign:                                                                                 | Scope of the approval grant. Only applicable when isGranted is true and requestType is EXECUTION.<br/> |
| `authContext`                                                                                      | [Optional\<AuthContext>](../../models/components/AuthContext.md)                                   | :heavy_minus_sign:                                                                                 | Context for authentication responses, containing identifiers for the entity being authenticated.<br/> |