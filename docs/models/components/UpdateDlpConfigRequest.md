# UpdateDlpConfigRequest


## Fields

| Field                                                                           | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `config`                                                                        | [Optional\<DlpConfig>](../../models/components/DlpConfig.md)                    | :heavy_minus_sign:                                                              | Detailed configuration of what documents and sensitive content will be scanned. |
| `frequency`                                                                     | *Optional\<String>*                                                             | :heavy_minus_sign:                                                              | Only "ONCE" is supported for reports.                                           |