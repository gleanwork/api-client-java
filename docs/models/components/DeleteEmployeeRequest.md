# DeleteEmployeeRequest

Describes the request body of the /deleteemployee API call


## Fields

| Field                                                                                                           | Type                                                                                                            | Required                                                                                                        | Description                                                                                                     |
| --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- |
| `version`                                                                                                       | *Optional\<Long>*                                                                                               | :heavy_minus_sign:                                                                                              | Version number for document for optimistic concurrency control. If absent or 0 then no version checks are done. |
| `employeeEmail`                                                                                                 | *String*                                                                                                        | :heavy_check_mark:                                                                                              | The deleted employee's email                                                                                    |