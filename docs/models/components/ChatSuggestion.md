# ChatSuggestion


## Fields

| Field                                                                   | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `query`                                                                 | *Optional\<String>*                                                     | :heavy_minus_sign:                                                      | The actionable chat query to run when the user selects this suggestion. |
| `cta`                                                                   | *Optional\<String>*                                                     | :heavy_minus_sign:                                                      | Button text to show for the suggestion action.                          |
| `feature`                                                               | *Optional\<String>*                                                     | :heavy_minus_sign:                                                      | Targeted Glean Chat feature for the suggestion.                         |
| `sourceDocumentIds`                                                     | List\<*String*>                                                         | :heavy_minus_sign:                                                      | Document IDs that grounded the suggestion.                              |