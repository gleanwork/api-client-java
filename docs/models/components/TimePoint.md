# TimePoint


## Fields

| Field                                                                                 | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `epochSeconds`                                                                        | *Optional\<Long>*                                                                     | :heavy_minus_sign:                                                                    | Epoch seconds. Has precedence over daysFromNow.                                       |
| `daysFromNow`                                                                         | *Optional\<Long>*                                                                     | :heavy_minus_sign:                                                                    | The number of days from now. Specification relative to current time. Can be negative. |