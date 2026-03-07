# CreateAuthTokenResponse


## Fields

| Field                                                                                | Type                                                                                 | Required                                                                             | Description                                                                          |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| `token`                                                                              | *String*                                                                             | :heavy_check_mark:                                                                   | An authentication token that can be passed to any endpoint via Bearer Authentication |
| `expirationTime`                                                                     | *long*                                                                               | :heavy_check_mark:                                                                   | Unix timestamp for when this token expires (in seconds since epoch UTC).             |