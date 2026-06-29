# CreateWorkflowRequest


## Fields

| Field                                             | Type                                              | Required                                          | Description                                       |
| ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- |
| `name`                                            | *Optional\<String>*                               | :heavy_minus_sign:                                | The name of the workflow.                         |
| `transient_`                                      | *Optional\<Boolean>*                              | :heavy_minus_sign:                                | Used to create a transient workflow.              |
| `parentWorkflowId`                                | *Optional\<String>*                               | :heavy_minus_sign:                                | id of the parent workflow for transient workflows |