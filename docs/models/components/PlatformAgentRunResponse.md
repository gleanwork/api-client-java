# PlatformAgentRunResponse

Persisted agent run snapshot with a request ID for support correlation.


## Fields

| Field                                                                                                | Type                                                                                                 | Required                                                                                             | Description                                                                                          |
| ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| `run`                                                                                                | [PlatformDurableAgentRun](../../models/components/PlatformDurableAgentRun.md)                        | :heavy_check_mark:                                                                                   | Agent run state, pending tool approvals, and output available independently of the creation request. |
| `requestId`                                                                                          | *String*                                                                                             | :heavy_check_mark:                                                                                   | Platform-generated request ID for support correlation.                                               |