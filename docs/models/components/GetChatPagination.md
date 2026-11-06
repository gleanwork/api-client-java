# GetChatPagination

Pagination cursors and page flags for a getchat message page.


## Fields

| Field                                                                     | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `startCursor`                                                             | *Optional\<String>*                                                       | :heavy_minus_sign:                                                        | Cursor of the first (oldest) returned message. Omitted for an empty page. |
| `endCursor`                                                               | *Optional\<String>*                                                       | :heavy_minus_sign:                                                        | Cursor of the last (newest) returned message. Omitted for an empty page.  |
| `hasNextPage`                                                             | *boolean*                                                                 | :heavy_check_mark:                                                        | Whether visible messages exist after endCursor in chronological order.    |
| `hasPreviousPage`                                                         | *boolean*                                                                 | :heavy_check_mark:                                                        | Whether visible messages exist before startCursor in chronological order. |