# UserReferenceDefinition

Describes how a user is referenced in a document. The user can be referenced by email or by a datasource specific id.


## Fields

| Field                                                                        | Type                                                                         | Required                                                                     | Description                                                                  |
| ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- |
| `email`                                                                      | *Optional\<String>*                                                          | :heavy_minus_sign:                                                           | N/A                                                                          |
| `datasourceUserId`                                                           | *Optional\<String>*                                                          | :heavy_minus_sign:                                                           | some datasources refer to the user by the datasource user id in the document |
| `name`                                                                       | *Optional\<String>*                                                          | :heavy_minus_sign:                                                           | N/A                                                                          |