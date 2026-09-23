# PlatformAgentRunCancellationRequest

Request cooperative cancellation of a run owned by the caller.


## Fields

| Field                                                                     | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `runId`                                                                   | *String*                                                                  | :heavy_check_mark:                                                        | ID of the run to cancel. Must belong to the agent identified in the path. |