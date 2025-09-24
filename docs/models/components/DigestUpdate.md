# DigestUpdate


## Fields

| Field                                                                  | Type                                                                   | Required                                                               | Description                                                            |
| ---------------------------------------------------------------------- | ---------------------------------------------------------------------- | ---------------------------------------------------------------------- | ---------------------------------------------------------------------- |
| `url`                                                                  | *Optional\<String>*                                                    | :heavy_minus_sign:                                                     | URL link to the content or document.                                   |
| `title`                                                                | *Optional\<String>*                                                    | :heavy_minus_sign:                                                     | Title or headline of the update.                                       |
| `datasource`                                                           | *Optional\<String>*                                                    | :heavy_minus_sign:                                                     | Name or identifier of the data source (e.g., slack, confluence, etc.). |
| `summary`                                                              | *Optional\<String>*                                                    | :heavy_minus_sign:                                                     | Brief summary or description of the update content.                    |
| `type`                                                                 | [Optional\<UpdateType>](../../models/components/UpdateType.md)         | :heavy_minus_sign:                                                     | Optional type classification for the update.                           |