# PlatformListDepartmentsResponse

One page of departments.


## Fields

| Field                                                                             | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `results`                                                                         | List\<[PlatformDepartment](../../models/components/PlatformDepartment.md)>        | :heavy_check_mark:                                                                | The departments on this page, ordered by display_name and then by department_id.<br/> |
| `hasMore`                                                                         | *boolean*                                                                         | :heavy_check_mark:                                                                | Whether more departments are available after this page.                           |
| `nextCursor`                                                                      | *JsonNullable\<String>*                                                           | :heavy_minus_sign:                                                                | Opaque cursor for the next page; null or absent when has_more is false.           |
| `requestId`                                                                       | *String*                                                                          | :heavy_check_mark:                                                                | Request identifier for correlating this response.                                 |