# ReferenceRange

Each text range from the response can correspond to an array of snippets from the citation source.


## Fields

| Field                                                                              | Type                                                                               | Required                                                                           | Description                                                                        |
| ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| `textRange`                                                                        | [Optional\<TextRange>](../../models/components/TextRange.md)                       | :heavy_minus_sign:                                                                 | A subsection of a given string to which some special formatting should be applied. |
| `snippets`                                                                         | List\<[SearchResultSnippet](../../models/components/SearchResultSnippet.md)>       | :heavy_minus_sign:                                                                 | N/A                                                                                |