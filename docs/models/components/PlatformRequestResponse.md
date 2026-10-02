# PlatformRequestResponse

Single authorized request with the enclosing response's trace identifier.


## Fields

| Field                                                                                   | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `request`                                                                               | [PlatformLimitIncreaseRequest](../../models/components/PlatformLimitIncreaseRequest.md) | :heavy_check_mark:                                                                      | Stored user or agent request, with optional resolution fields when available.           |
| `requestId`                                                                             | *String*                                                                                | :heavy_check_mark:                                                                      | Trace identifier, distinct from the resource ID.                                        |