# ResponseMetadata

Metadata about the response (e.g., latency, token count).


## Fields

| Field                                                | Type                                                 | Required                                             | Description                                          |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| `latencyMs`                                          | *Optional\<Long>*                                    | :heavy_minus_sign:                                   | Time taken to generate the response in milliseconds. |
| `tokenCount`                                         | *Optional\<Long>*                                    | :heavy_minus_sign:                                   | Number of tokens in the response.                    |
| `modelUsed`                                          | *Optional\<String>*                                  | :heavy_minus_sign:                                   | The specific model version used.                     |