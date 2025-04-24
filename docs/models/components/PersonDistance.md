# PersonDistance


## Fields

| Field                                                                                | Type                                                                                 | Required                                                                             | Description                                                                          |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| `name`                                                                               | *String*                                                                             | :heavy_check_mark:                                                                   | The display name.                                                                    |
| `obfuscatedId`                                                                       | *String*                                                                             | :heavy_check_mark:                                                                   | An opaque identifier that can be used to request metadata for a Person.              |
| `distance`                                                                           | *float*                                                                              | :heavy_check_mark:                                                                   | Distance to person, refer to PeopleDistance pipeline on interpretation of the value. |