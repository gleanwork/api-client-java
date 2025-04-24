# AddCollectionItemsRequest


## Fields

| Field                                                                                  | Type                                                                                   | Required                                                                               | Description                                                                            |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `collectionId`                                                                         | *double*                                                                               | :heavy_check_mark:                                                                     | The ID of the Collection to add items to.                                              |
| `addedCollectionItemDescriptors`                                                       | List\<[CollectionItemDescriptor](../../models/components/CollectionItemDescriptor.md)> | :heavy_minus_sign:                                                                     | The CollectionItemDescriptors of the items being added.                                |