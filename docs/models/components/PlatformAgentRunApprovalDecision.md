# PlatformAgentRunApprovalDecision

Approve or reject the invocation identified by a pending interaction ID.


## Fields

| Field                                                                              | Type                                                                               | Required                                                                           | Description                                                                        |
| ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| `interactionId`                                                                    | *String*                                                                           | :heavy_check_mark:                                                                 | The interaction_id returned in the run's pending_interactions.                     |
| `decision`                                                                         | [Decision](../../models/components/Decision.md)                                    | :heavy_check_mark:                                                                 | The decision for this invocation only. Rejection follows normal workflow behavior. |