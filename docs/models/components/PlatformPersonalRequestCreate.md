# PlatformPersonalRequestCreate

New request for the authenticated canonical user in the server's current UTC month.


## Fields

| Field                                                   | Type                                                    | Required                                                | Description                                             |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| `clientId`                                              | *String*                                                | :heavy_check_mark:                                      | Explicit spend client whose limit the request concerns. |
| `businessJustification`                                 | *Optional\<String>*                                     | :heavy_minus_sign:                                      | Optional explanation of why the increase is needed.     |