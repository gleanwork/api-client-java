# StructuredLocation

Detailed location with information about country, state, city etc.


## Fields

| Field                                                     | Type                                                      | Required                                                  | Description                                               |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| `deskLocation`                                            | *Optional\<String>*                                       | :heavy_minus_sign:                                        | Desk number.                                              |
| `timezone`                                                | *Optional\<String>*                                       | :heavy_minus_sign:                                        | Location's timezone, e.g. UTC, PST.                       |
| `address`                                                 | *Optional\<String>*                                       | :heavy_minus_sign:                                        | Office address or name.                                   |
| `city`                                                    | *Optional\<String>*                                       | :heavy_minus_sign:                                        | Name of the city.                                         |
| `state`                                                   | *Optional\<String>*                                       | :heavy_minus_sign:                                        | State code.                                               |
| `region`                                                  | *Optional\<String>*                                       | :heavy_minus_sign:                                        | Region information, e.g. NORAM, APAC.                     |
| `zipCode`                                                 | *Optional\<String>*                                       | :heavy_minus_sign:                                        | ZIP Code for the address.                                 |
| `country`                                                 | *Optional\<String>*                                       | :heavy_minus_sign:                                        | Country name.                                             |
| `countryCode`                                             | *Optional\<String>*                                       | :heavy_minus_sign:                                        | Alpha-2 or Alpha-3 ISO 3166 country code, e.g. US or USA. |