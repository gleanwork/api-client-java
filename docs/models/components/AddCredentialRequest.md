# AddCredentialRequest


## Fields

| Field                                                            | Type                                                             | Required                                                         | Description                                                      |
| ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- |
| `datasource`                                                     | *Optional\<String>*                                              | :heavy_minus_sign:                                               | the datasource the credential applies to                         |
| `datasourceInstance`                                             | *Optional\<String>*                                              | :heavy_minus_sign:                                               | the datasource instance the credential applies to                |
| `user`                                                           | *Optional\<String>*                                              | :heavy_minus_sign:                                               | the user info (email or username for example) for the credential |
| `token`                                                          | *Optional\<String>*                                              | :heavy_minus_sign:                                               | the token part of the credential (password, apiToken etc)        |
| `metadata`                                                       | *Optional\<String>*                                              | :heavy_minus_sign:                                               | any metadata associated with the user credential                 |