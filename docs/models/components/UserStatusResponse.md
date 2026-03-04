# UserStatusResponse

Describes the user status response body


## Fields

| Field                                                                      | Type                                                                       | Required                                                                   | Description                                                                | Example                                                                    |
| -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- |
| `isActiveUser`                                                             | *Optional\<Boolean>*                                                       | :heavy_minus_sign:                                                         | Whether the user is active or not                                          | true                                                                       |
| `uploadStatus`                                                             | [Optional\<UploadStatusEnum>](../../models/components/UploadStatusEnum.md) | :heavy_minus_sign:                                                         | Upload status, enum of NOT_UPLOADED, UPLOADED, STATUS_UNKNOWN              | UPLOADED                                                                   |
| `lastUploadedAt`                                                           | *Optional\<String>*                                                        | :heavy_minus_sign:                                                         | Time of last successful upload for the user, in ISO 8601 format            | 2021-08-06T17:58:01.000Z                                                   |