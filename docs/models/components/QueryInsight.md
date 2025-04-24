# QueryInsight


## Fields

| Field                                                          | Type                                                           | Required                                                       | Description                                                    |
| -------------------------------------------------------------- | -------------------------------------------------------------- | -------------------------------------------------------------- | -------------------------------------------------------------- |
| `query`                                                        | *String*                                                       | :heavy_check_mark:                                             | The query string the information is about.                     |
| `searchCount`                                                  | [Optional\<CountInfo>](../../models/components/CountInfo.md)   | :heavy_minus_sign:                                             | N/A                                                            |
| `searchorCount`                                                | [Optional\<CountInfo>](../../models/components/CountInfo.md)   | :heavy_minus_sign:                                             | N/A                                                            |
| `searchWithClickCount`                                         | [Optional\<CountInfo>](../../models/components/CountInfo.md)   | :heavy_minus_sign:                                             | N/A                                                            |
| `clickCount`                                                   | [Optional\<CountInfo>](../../models/components/CountInfo.md)   | :heavy_minus_sign:                                             | N/A                                                            |
| `similarQueries`                                               | List\<[QueryInsight](../../models/components/QueryInsight.md)> | :heavy_minus_sign:                                             | list of similar queries to current one.                        |