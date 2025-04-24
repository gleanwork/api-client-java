# DlpReportData

Dlp report metadata which is used to construct report email


## Fields

| Field                                                                                     | Type                                                                                      | Required                                                                                  | Description                                                                               |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `frequency`                                                                               | [Optional\<Frequency>](../../models/components/Frequency.md)                              | :heavy_minus_sign:                                                                        | The frequency of the report                                                               |
| `requestTime`                                                                             | [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html) | :heavy_minus_sign:                                                                        | The time the report was requested, applicable only for one time reports                   |
| `reportName`                                                                              | *Optional\<String>*                                                                       | :heavy_minus_sign:                                                                        | N/A                                                                                       |
| `status`                                                                                  | [Optional\<DlpSimpleResult>](../../models/components/DlpSimpleResult.md)                  | :heavy_minus_sign:                                                                        | N/A                                                                                       |