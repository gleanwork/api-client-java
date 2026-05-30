# InsightsOverviewRequest


## Fields

| Field                                                                              | Type                                                                               | Required                                                                           | Description                                                                        |
| ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| `departments`                                                                      | List\<*String*>                                                                    | :heavy_minus_sign:                                                                 | Departments for which Insights are requested.                                      |
| `managerEmails`                                                                    | List\<*String*>                                                                    | :heavy_minus_sign:                                                                 | Manager emails whose teams should be filtered for. Empty array means no filtering. |
| `dayRange`                                                                         | [Optional\<Period>](../../models/components/Period.md)                             | :heavy_minus_sign:                                                                 | N/A                                                                                |