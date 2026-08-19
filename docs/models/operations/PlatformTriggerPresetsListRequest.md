# PlatformTriggerPresetsListRequest


## Fields

| Field                                                              | Type                                                               | Required                                                           | Description                                                        |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| `datasource`                                                       | *Optional\<String>*                                                | :heavy_minus_sign:                                                 | Restrict results to presets for a single datasource (e.g. github). |
| `pageSize`                                                         | *Optional\<Long>*                                                  | :heavy_minus_sign:                                                 | Maximum number of presets to return.                               |
| `cursor`                                                           | *Optional\<String>*                                                | :heavy_minus_sign:                                                 | Opaque pagination cursor from a previous response.                 |