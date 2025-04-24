# InviteRequest

A request to send an invite to the specified user[s]


## Fields

| Field                                                                                | Type                                                                                 | Required                                                                             | Description                                                                          |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| `channel`                                                                            | [Optional\<CommunicationChannel>](../../models/components/CommunicationChannel.md)   | :heavy_minus_sign:                                                                   | N/A                                                                                  |
| `template`                                                                           | [Optional\<CommunicationTemplate>](../../models/components/CommunicationTemplate.md) | :heavy_minus_sign:                                                                   | The type of email to send                                                            |
| `recipients`                                                                         | List\<[Person](../../models/components/Person.md)>                                   | :heavy_minus_sign:                                                                   | The people who should receive this invite                                            |
| `recipientFilters`                                                                   | [Optional\<PeopleFilters>](../../models/components/PeopleFilters.md)                 | :heavy_minus_sign:                                                                   | N/A                                                                                  |