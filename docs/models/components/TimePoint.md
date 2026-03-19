# TimePoint


## Fields

| Field                                                     | Type                                                      | Required                                                  | Description                                               |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| `epochSeconds`                                            | *Optional\<Long>*                                         | :heavy_minus_sign:                                        | Epoch seconds. Has precedence over daysFromNow.           |
| `daysFromNow`                                             | *Optional\<Long>*                                         | :heavy_minus_sign:                                        | Number of days in the past, relative to the current date. |