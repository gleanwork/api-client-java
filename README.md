# api-client-java

The Glean Java SDK provides convenient access to the Glean REST API for Java 8+. It includes POJOs for all API models, fluent builders for requests, and supports both synchronous and asynchronous execution using standard HTTP clients.
<!-- No Summary [summary] -->

## Unified SDK Architecture

This SDK combines both the Client and Indexing API namespaces into a single unified package:

- **Client API**: Used for search, retrieval, and end-user interactions with Glean content
- **Indexing API**: Used for indexing content, permissions, and other administrative operations

Each namespace has its own authentication requirements and access patterns. While they serve different purposes, having them in a single SDK provides a consistent developer experience across all Glean API interactions.

```java
// Example of accessing Client namespace
Glean glean = Glean.builder()
        .apiToken("client-token")
        .instance("instance-name")
        .build();
glean.client().search().query()
        .searchRequest(SearchRequest.builder().query("search term").build())
        .call();

// Example of accessing Indexing namespace 
Glean glean = Glean.builder()
        .apiToken("indexing-token")
        .instance("instance-name")
        .build();
glean.indexing().documents().index()
        .request(DocumentBulkIndexRequest.builder() /* document data */ .build())
        .call();
```

Remember that each namespace requires its own authentication token type as described in the [Authentication Methods](#authentication-methods) section.

<!-- Start Table of Contents [toc] -->
## Table of Contents
<!-- $toc-max-depth=2 -->
* [api-client-java](#api-client-java)
  * [Unified SDK Architecture](#unified-sdk-architecture)
  * [SDK Installation](#sdk-installation)
  * [SDK Example Usage](#sdk-example-usage)
  * [Authentication](#authentication)
  * [Available Resources and Operations](#available-resources-and-operations)
  * [Error Handling](#error-handling)
  * [Server Selection](#server-selection)
* [Development](#development)
  * [Maturity](#maturity)
  * [Contributions](#contributions)

<!-- End Table of Contents [toc] -->

<!-- Start SDK Installation [installation] -->
## SDK Installation

### Getting started

JDK 11 or later is required.

The samples below show how a published SDK artifact is used:

Gradle:
```groovy
implementation 'com.glean.api-client:glean-api-client:0.6.0'
```

Maven:
```xml
<dependency>
    <groupId>com.glean.api-client</groupId>
    <artifactId>glean-api-client</artifactId>
    <version>0.6.0</version>
</dependency>
```

### How to build
After cloning the git repository to your file system you can build the SDK artifact from source to the `build` directory by running `./gradlew build` on *nix systems or `gradlew.bat` on Windows systems.

If you wish to build from source and publish the SDK artifact to your local Maven repository (on your filesystem) then use the following command (after cloning the git repo locally):

On *nix:
```bash
./gradlew publishToMavenLocal -Pskip.signing
```
On Windows:
```bash
gradlew.bat publishToMavenLocal -Pskip.signing
```

### Logging
A logging framework/facade has not yet been adopted but is under consideration.

For request and response logging (especially json bodies), call `enableHTTPDebugLogging(boolean)` on the SDK builder like so:
```java
SDK.builder()
    .enableHTTPDebugLogging(true)
    .build();
```
Example output:
```
Sending request: http://localhost:35123/bearer#global GET
Request headers: {Accept=[application/json], Authorization=[******], Client-Level-Header=[added by client], Idempotency-Key=[some-key], x-speakeasy-user-agent=[speakeasy-sdk/java 0.0.1 internal 0.1.0 org.openapis.openapi]}
Received response: (GET http://localhost:35123/bearer#global) 200
Response headers: {access-control-allow-credentials=[true], access-control-allow-origin=[*], connection=[keep-alive], content-length=[50], content-type=[application/json], date=[Wed, 09 Apr 2025 01:43:29 GMT], server=[gunicorn/19.9.0]}
Response body:
{
  "authenticated": true, 
  "token": "global"
}
```
__WARNING__: This should only used for temporary debugging purposes. Leaving this option on in a production system could expose credentials/secrets in logs. <i>Authorization</i> headers are redacted by default and there is the ability to specify redacted header names via `SpeakeasyHTTPClient.setRedactedHeaders`.

__NOTE__: This is a convenience method that calls `HTTPClient.enableDebugLogging()`. The `SpeakeasyHTTPClient` honors this setting. If you are using a custom HTTP client, it is up to the custom client to honor this setting.

Another option is to set the System property `-Djdk.httpclient.HttpClient.log=all`. However, this second option does not log bodies.
<!-- End SDK Installation [installation] -->

<!-- Start SDK Example Usage [usage] -->
## SDK Example Usage

### Example 1

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.ChatResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ChatResponse res = sdk.client().chat().create()
                .chatRequest(ChatRequest.builder()
                    .messages(List.of(
                        ChatMessage.builder()
                            .fragments(List.of(
                                ChatMessageFragment.builder()
                                    .text("What are the company holidays this year?")
                                    .build()))
                            .build()))
                    .build())
                .call();

        if (res.chatResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Example 2

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.ChatStreamResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ChatStreamResponse res = sdk.client().chat().createStream()
                .chatRequest(ChatRequest.builder()
                    .messages(List.of(
                        ChatMessage.builder()
                            .fragments(List.of(
                                ChatMessageFragment.builder()
                                    .text("What are the company holidays this year?")
                                    .build()))
                            .build()))
                    .build())
                .call();

        if (res.chatRequestStream().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->

<!-- Start Authentication [security] -->
## Authentication

### Per-Client Security Schemes

This SDK supports the following security scheme globally:

| Name       | Type | Scheme      | Environment Variable |
| ---------- | ---- | ----------- | -------------------- |
| `apiToken` | http | HTTP Bearer | `GLEAN_API_TOKEN`    |

To authenticate with the API the `apiToken` parameter must be set when initializing the SDK client instance. For example:
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.ActivityResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        Activity req = Activity.builder()
                .events(List.of(
                    ActivityEvent.builder()
                        .action(ActivityEventAction.HISTORICAL_VIEW)
                        .timestamp(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                        .url("https://example.com/")
                        .build(),
                    ActivityEvent.builder()
                        .action(ActivityEventAction.SEARCH)
                        .timestamp(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                        .url("https://example.com/search?q=query")
                        .params(ActivityEventParams.builder()
                            .query("query")
                            .build())
                        .build(),
                    ActivityEvent.builder()
                        .action(ActivityEventAction.VIEW)
                        .timestamp(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                        .url("https://example.com/")
                        .params(ActivityEventParams.builder()
                            .duration(20L)
                            .referrer("https://example.com/document")
                            .build())
                        .build()))
                .build();

        ActivityResponse res = sdk.client().activity().report()
                .request(req)
                .call();

        // handle response
    }
}
```
<!-- End Authentication [security] -->

### Authentication Methods

Glean supports different authentication methods depending on which API namespace you're using:

#### Client Namespace

The Client namespace supports two authentication methods:

1. **Manually Provisioned API Tokens**
   - Can be created by an Admin or a user with the API Token Creator role
   - Used for server-to-server integrations

2. **OAuth**
   - Requires OAuth setup to be completed by an Admin
   - Used for user-based authentication flows

#### Indexing Namespace

The Indexing namespace supports only one authentication method:

1. **Manually Provisioned API Tokens**
   - Can be created by an Admin or a user with the API Token Creator role
   - Used for secure document indexing operations

> [!IMPORTANT]
> Client tokens **will not work** for Indexing operations, and Indexing tokens **will not work** for Client operations. You must use the appropriate token type for the namespace you're accessing.

For more information on obtaining the appropriate token type, please contact your Glean administrator.

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>

### [client()](docs/sdks/client/README.md)


#### [client().activity()](docs/sdks/activity/README.md)

* [report](docs/sdks/activity/README.md#report) - Report document activity
* [feedback](docs/sdks/activity/README.md#feedback) - Report client activity

#### [client().agents()](docs/sdks/agents/README.md)

* [retrieve](docs/sdks/agents/README.md#retrieve) - Retrieve an agent
* [retrieveSchemas](docs/sdks/agents/README.md#retrieveschemas) - List an agent's schemas
* [list](docs/sdks/agents/README.md#list) - Search agents
* [runStream](docs/sdks/agents/README.md#runstream) - Create an agent run and stream the response
* [run](docs/sdks/agents/README.md#run) - Create an agent run and wait for the response

#### [client().announcements()](docs/sdks/announcements/README.md)

* [create](docs/sdks/announcements/README.md#create) - Create Announcement
* [delete](docs/sdks/announcements/README.md#delete) - Delete Announcement
* [update](docs/sdks/announcements/README.md#update) - Update Announcement

#### [client().answers()](docs/sdks/answers/README.md)

* [create](docs/sdks/answers/README.md#create) - Create Answer
* [delete](docs/sdks/answers/README.md#delete) - Delete Answer
* [update](docs/sdks/answers/README.md#update) - Update Answer
* [retrieve](docs/sdks/answers/README.md#retrieve) - Read Answer
* [list](docs/sdks/answers/README.md#list) - List Answers

#### [client().authentication()](docs/sdks/clientauthentication/README.md)

* [createToken](docs/sdks/clientauthentication/README.md#createtoken) - Create authentication token

#### [client().chat()](docs/sdks/chat/README.md)

* [create](docs/sdks/chat/README.md#create) - Chat
* [deleteAll](docs/sdks/chat/README.md#deleteall) - Deletes all saved Chats owned by a user
* [delete](docs/sdks/chat/README.md#delete) - Deletes saved Chats
* [retrieve](docs/sdks/chat/README.md#retrieve) - Retrieves a Chat
* [list](docs/sdks/chat/README.md#list) - Retrieves all saved Chats
* [retrieveApplication](docs/sdks/chat/README.md#retrieveapplication) - Gets the metadata for a custom Chat application
* [uploadFiles](docs/sdks/chat/README.md#uploadfiles) - Upload files for Chat.
* [retrieveFiles](docs/sdks/chat/README.md#retrievefiles) - Get files uploaded by a user for Chat.
* [deleteFiles](docs/sdks/chat/README.md#deletefiles) - Delete files uploaded by a user for chat.
* [createStream](docs/sdks/chat/README.md#createstream) - Chat

#### [client().collections()](docs/sdks/collections/README.md)

* [addItems](docs/sdks/collections/README.md#additems) - Add Collection item
* [create](docs/sdks/collections/README.md#create) - Create Collection
* [delete](docs/sdks/collections/README.md#delete) - Delete Collection
* [deleteItem](docs/sdks/collections/README.md#deleteitem) - Delete Collection item
* [update](docs/sdks/collections/README.md#update) - Update Collection
* [updateItem](docs/sdks/collections/README.md#updateitem) - Update Collection item
* [retrieve](docs/sdks/collections/README.md#retrieve) - Read Collection
* [list](docs/sdks/collections/README.md#list) - List Collections

#### [client().documents()](docs/sdks/clientdocuments/README.md)

* [retrievePermissions](docs/sdks/clientdocuments/README.md#retrievepermissions) - Read document permissions
* [retrieve](docs/sdks/clientdocuments/README.md#retrieve) - Read documents
* [retrieveByFacets](docs/sdks/clientdocuments/README.md#retrievebyfacets) - Read documents by facets
* [summarize](docs/sdks/clientdocuments/README.md#summarize) - Summarize documents

#### [client().entities()](docs/sdks/entities/README.md)

* [list](docs/sdks/entities/README.md#list) - List entities
* [readPeople](docs/sdks/entities/README.md#readpeople) - Read people

#### [client().governance().data().policies()](docs/sdks/policies/README.md)

* [retrieve](docs/sdks/policies/README.md#retrieve) - Gets specified policy
* [update](docs/sdks/policies/README.md#update) - Updates an existing policy
* [list](docs/sdks/policies/README.md#list) - Lists policies
* [create](docs/sdks/policies/README.md#create) - Creates new policy
* [download](docs/sdks/policies/README.md#download) - Downloads violations CSV for policy

#### [client().governance().data().reports()](docs/sdks/reports/README.md)

* [create](docs/sdks/reports/README.md#create) - Creates new one-time report
* [download](docs/sdks/reports/README.md#download) - Downloads violations CSV for report
* [status](docs/sdks/reports/README.md#status) - Fetches report run status

#### [client().governance().documents().visibilityoverrides()](docs/sdks/visibilityoverrides/README.md)

* [list](docs/sdks/visibilityoverrides/README.md#list) - Fetches documents visibility
* [create](docs/sdks/visibilityoverrides/README.md#create) - Hide or unhide docs

#### [client().insights()](docs/sdks/insights/README.md)

* [retrieve](docs/sdks/insights/README.md#retrieve) - Read insights

#### [client().messages()](docs/sdks/messages/README.md)

* [retrieve](docs/sdks/messages/README.md#retrieve) - Read messages

#### [client().pins()](docs/sdks/pins/README.md)

* [update](docs/sdks/pins/README.md#update) - Update pin
* [retrieve](docs/sdks/pins/README.md#retrieve) - Read pin
* [list](docs/sdks/pins/README.md#list) - List pins
* [create](docs/sdks/pins/README.md#create) - Create pin
* [remove](docs/sdks/pins/README.md#remove) - Delete pin

#### [client().search()](docs/sdks/search/README.md)

* [queryAsAdmin](docs/sdks/search/README.md#queryasadmin) - Search the index (admin)
* [autocomplete](docs/sdks/search/README.md#autocomplete) - Autocomplete
* [retrieveFeed](docs/sdks/search/README.md#retrievefeed) - Feed of documents and events
* [recommendations](docs/sdks/search/README.md#recommendations) - Recommend documents
* [query](docs/sdks/search/README.md#query) - Search

#### [client().shortcuts()](docs/sdks/clientshortcuts/README.md)

* [create](docs/sdks/clientshortcuts/README.md#create) - Create shortcut
* [delete](docs/sdks/clientshortcuts/README.md#delete) - Delete shortcut
* [retrieve](docs/sdks/clientshortcuts/README.md#retrieve) - Read shortcut
* [list](docs/sdks/clientshortcuts/README.md#list) - List shortcuts
* [update](docs/sdks/clientshortcuts/README.md#update) - Update shortcut

#### [client().tools()](docs/sdks/tools/README.md)

* [list](docs/sdks/tools/README.md#list) - List available tools
* [run](docs/sdks/tools/README.md#run) - Execute the specified tool

#### [client().verification()](docs/sdks/verification/README.md)

* [addReminder](docs/sdks/verification/README.md#addreminder) - Create verification
* [list](docs/sdks/verification/README.md#list) - List verifications
* [verify](docs/sdks/verification/README.md#verify) - Update verification


### [indexing()](docs/sdks/indexing/README.md)


#### [indexing().authentication()](docs/sdks/indexingauthentication/README.md)

* [rotateToken](docs/sdks/indexingauthentication/README.md#rotatetoken) - Rotate token

#### [indexing().datasource()](docs/sdks/datasource/README.md)

* [status](docs/sdks/datasource/README.md#status) - Beta: Get datasource status


#### [indexing().datasources()](docs/sdks/datasources/README.md)

* [add](docs/sdks/datasources/README.md#add) - Add or update datasource
* [retrieveConfig](docs/sdks/datasources/README.md#retrieveconfig) - Get datasource config

#### [indexing().documents()](docs/sdks/indexingdocuments/README.md)

* [addOrUpdate](docs/sdks/indexingdocuments/README.md#addorupdate) - Index document
* [index](docs/sdks/indexingdocuments/README.md#index) - Index documents
* [bulkIndex](docs/sdks/indexingdocuments/README.md#bulkindex) - Bulk index documents
* [processAll](docs/sdks/indexingdocuments/README.md#processall) - Schedules the processing of uploaded documents
* [delete](docs/sdks/indexingdocuments/README.md#delete) - Delete document
* [debug](docs/sdks/indexingdocuments/README.md#debug) - Beta: Get document information

* [debugMany](docs/sdks/indexingdocuments/README.md#debugmany) - Beta: Get information of a batch of documents

* [checkAccess](docs/sdks/indexingdocuments/README.md#checkaccess) - Check document access
* [~~status~~](docs/sdks/indexingdocuments/README.md#status) - Get document upload and indexing status :warning: **Deprecated**
* [~~count~~](docs/sdks/indexingdocuments/README.md#count) - Get document count :warning: **Deprecated**

#### [indexing().people()](docs/sdks/people/README.md)

* [debug](docs/sdks/people/README.md#debug) - Beta: Get user information

* [~~count~~](docs/sdks/people/README.md#count) - Get user count :warning: **Deprecated**
* [index](docs/sdks/people/README.md#index) - Index employee
* [bulkIndex](docs/sdks/people/README.md#bulkindex) - Bulk index employees
* [processAllEmployeesAndTeams](docs/sdks/people/README.md#processallemployeesandteams) - Schedules the processing of uploaded employees and teams
* [delete](docs/sdks/people/README.md#delete) - Delete employee
* [indexTeam](docs/sdks/people/README.md#indexteam) - Index team
* [deleteTeam](docs/sdks/people/README.md#deleteteam) - Delete team
* [bulkIndexTeams](docs/sdks/people/README.md#bulkindexteams) - Bulk index teams

#### [indexing().permissions()](docs/sdks/permissions/README.md)

* [updatePermissions](docs/sdks/permissions/README.md#updatepermissions) - Update document permissions
* [indexUser](docs/sdks/permissions/README.md#indexuser) - Index user
* [bulkIndexUsers](docs/sdks/permissions/README.md#bulkindexusers) - Bulk index users
* [indexGroup](docs/sdks/permissions/README.md#indexgroup) - Index group
* [bulkIndexGroups](docs/sdks/permissions/README.md#bulkindexgroups) - Bulk index groups
* [indexMembership](docs/sdks/permissions/README.md#indexmembership) - Index membership
* [bulkIndexMemberships](docs/sdks/permissions/README.md#bulkindexmemberships) - Bulk index memberships for a group
* [processMemberships](docs/sdks/permissions/README.md#processmemberships) - Schedules the processing of group memberships
* [deleteUser](docs/sdks/permissions/README.md#deleteuser) - Delete user
* [deleteGroup](docs/sdks/permissions/README.md#deletegroup) - Delete group
* [deleteMembership](docs/sdks/permissions/README.md#deletemembership) - Delete membership
* [authorizeBetaUsers](docs/sdks/permissions/README.md#authorizebetausers) - Beta users

#### [indexing().shortcuts()](docs/sdks/indexingshortcuts/README.md)

* [bulkIndex](docs/sdks/indexingshortcuts/README.md#bulkindex) - Bulk index external shortcuts
* [upload](docs/sdks/indexingshortcuts/README.md#upload) - Upload shortcuts

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.

By default, an API error will throw a `models/errors/APIException` exception. When custom error responses are specified for an operation, the SDK may also throw their associated exception. You can refer to respective *Errors* tables in SDK docs for more details on possible exception types for each operation. For example, the `create` method throws the following exceptions:

| Error Type                    | Status Code | Content Type     |
| ----------------------------- | ----------- | ---------------- |
| models/errors/CollectionError | 422         | application/json |
| models/errors/APIException    | 4XX, 5XX    | \*/\*            |

### Example

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.errors.CollectionError;
import com.glean.api_client.glean_api_client.models.operations.CreatecollectionResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws CollectionError, Exception {

        Glean sdk = Glean.builder()
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateCollectionRequest req = CreateCollectionRequest.builder()
                .name("<value>")
                .addedRoles(List.of(
                    UserRoleSpecification.builder()
                        .role(UserRole.VERIFIER)
                        .person(Person.builder()
                            .name("George Clooney")
                            .obfuscatedId("abc123")
                            .relatedDocuments(List.of(
                                RelatedDocuments.builder()
                                    .querySuggestion(QuerySuggestion.builder()
                                        .query("app:github type:pull author:mortimer")
                                        .searchProviderInfo(SearchProviderInfo.builder()
                                            .name("Google")
                                            .searchLinkUrlTemplate("https://www.google.com/search?q={query}&hl=en")
                                            .build())
                                        .label("Mortimer's PRs")
                                        .datasource("github")
                                        .requestOptions(SearchRequestOptions.builder()
                                            .facetBucketSize(977077L)
                                            .datasourceFilter("JIRA")
                                            .datasourcesFilter(List.of(
                                                "JIRA"))
                                            .queryOverridesFacetFilters(true)
                                            .facetFilters(List.of(
                                                FacetFilter.builder()
                                                    .fieldName("type")
                                                    .values(List.of(
                                                        FacetFilterValue.builder()
                                                            .value("Spreadsheet")
                                                            .relationType(RelationType.EQUALS)
                                                            .build(),
                                                        FacetFilterValue.builder()
                                                            .value("Presentation")
                                                            .relationType(RelationType.EQUALS)
                                                            .build()))
                                                    .build()))
                                            .facetFilterSets(List.of(
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build(),
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build(),
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build()))
                                            .authTokens(List.of(
                                                AuthToken.builder()
                                                    .accessToken("123abc")
                                                    .datasource("gmail")
                                                    .scope("email profile https://www.googleapis.com/auth/gmail.readonly")
                                                    .tokenType("Bearer")
                                                    .authUser("1")
                                                    .build()))
                                            .build())
                                        .ranges(List.of(
                                            TextRange.builder()
                                                .startIndex(86650L)
                                                .document(Document.builder()
                                                    .metadata(DocumentMetadata.builder()
                                                        .datasource("datasource")
                                                        .objectType("Feature Request")
                                                        .container("container")
                                                        .parentId("JIRA_EN-1337")
                                                        .mimeType("mimeType")
                                                        .documentId("documentId")
                                                        .createTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                                        .updateTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                                        .components(List.of(
                                                            "Backend",
                                                            "Networking"))
                                                        .status("[\"Done\"]")
                                                        .pins(List.of(
                                                            PinDocument.builder()
                                                                .documentId("<id>")
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .build()))
                                                        .collections(List.of(
                                                            Collection.builder()
                                                                .name("<value>")
                                                                .description("meaty dial elegantly while react")
                                                                .id(854591L)
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .items(List.of(
                                                                    CollectionItem.builder()
                                                                        .collectionId(697663L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(697663L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(697663L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build()))
                                                                .build()))
                                                        .interactions(DocumentInteractions.builder()
                                                            .reacts(List.of(
                                                                Reaction.builder()
                                                                    .build(),
                                                                Reaction.builder()
                                                                    .build()))
                                                            .shares(List.of(
                                                                Share.builder()
                                                                    .numDaysAgo(365776L)
                                                                    .build(),
                                                                Share.builder()
                                                                    .numDaysAgo(365776L)
                                                                    .build(),
                                                                Share.builder()
                                                                    .numDaysAgo(365776L)
                                                                    .build()))
                                                            .build())
                                                        .verification(Verification.builder()
                                                            .state(State.DEPRECATED)
                                                            .metadata(VerificationMetadata.builder()
                                                                .reminders(List.of(
                                                                    Reminder.builder()
                                                                        .assignee(Person.builder()
                                                                            .name("George Clooney")
                                                                            .obfuscatedId("abc123")
                                                                            .build())
                                                                        .remindAt(268615L)
                                                                        .build()))
                                                                .lastReminder(Reminder.builder()
                                                                    .assignee(Person.builder()
                                                                        .name("George Clooney")
                                                                        .obfuscatedId("abc123")
                                                                        .build())
                                                                    .remindAt(423482L)
                                                                    .build())
                                                                .build())
                                                            .build())
                                                        .shortcuts(List.of(
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build(),
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build(),
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build()))
                                                        .customData(Map.ofEntries(
                                                            Map.entry("someCustomField", CustomDataValue.builder()
                                                                .build())))
                                                        .build())
                                                    .build())
                                                .build()))
                                        .inputDetails(SearchRequestInputDetails.builder()
                                            .hasCopyPaste(true)
                                            .build())
                                        .build())
                                    .results(List.of(
                                        SearchResult.builder()
                                            .url("https://example.com/foo/bar")
                                            .title("title")
                                            .nativeAppUrl("slack://foo/bar")
                                            .snippets(List.of(
                                                SearchResultSnippet.builder()
                                                    .snippet("snippet")
                                                    .mimeType("mimeType")
                                                    .build()))
                                            .build()))
                                    .build(),
                                RelatedDocuments.builder()
                                    .querySuggestion(QuerySuggestion.builder()
                                        .query("app:github type:pull author:mortimer")
                                        .searchProviderInfo(SearchProviderInfo.builder()
                                            .name("Google")
                                            .searchLinkUrlTemplate("https://www.google.com/search?q={query}&hl=en")
                                            .build())
                                        .label("Mortimer's PRs")
                                        .datasource("github")
                                        .requestOptions(SearchRequestOptions.builder()
                                            .facetBucketSize(977077L)
                                            .datasourceFilter("JIRA")
                                            .datasourcesFilter(List.of(
                                                "JIRA"))
                                            .queryOverridesFacetFilters(true)
                                            .facetFilters(List.of(
                                                FacetFilter.builder()
                                                    .fieldName("type")
                                                    .values(List.of(
                                                        FacetFilterValue.builder()
                                                            .value("Spreadsheet")
                                                            .relationType(RelationType.EQUALS)
                                                            .build(),
                                                        FacetFilterValue.builder()
                                                            .value("Presentation")
                                                            .relationType(RelationType.EQUALS)
                                                            .build()))
                                                    .build()))
                                            .facetFilterSets(List.of(
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build(),
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build(),
                                                FacetFilterSet.builder()
                                                    .filters(List.of(
                                                        FacetFilter.builder()
                                                            .fieldName("type")
                                                            .values(List.of(
                                                                FacetFilterValue.builder()
                                                                    .value("Spreadsheet")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build(),
                                                                FacetFilterValue.builder()
                                                                    .value("Presentation")
                                                                    .relationType(RelationType.EQUALS)
                                                                    .build()))
                                                            .build()))
                                                    .build()))
                                            .authTokens(List.of(
                                                AuthToken.builder()
                                                    .accessToken("123abc")
                                                    .datasource("gmail")
                                                    .scope("email profile https://www.googleapis.com/auth/gmail.readonly")
                                                    .tokenType("Bearer")
                                                    .authUser("1")
                                                    .build()))
                                            .build())
                                        .ranges(List.of(
                                            TextRange.builder()
                                                .startIndex(86650L)
                                                .document(Document.builder()
                                                    .metadata(DocumentMetadata.builder()
                                                        .datasource("datasource")
                                                        .objectType("Feature Request")
                                                        .container("container")
                                                        .parentId("JIRA_EN-1337")
                                                        .mimeType("mimeType")
                                                        .documentId("documentId")
                                                        .createTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                                        .updateTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                                        .components(List.of(
                                                            "Backend",
                                                            "Networking"))
                                                        .status("[\"Done\"]")
                                                        .pins(List.of(
                                                            PinDocument.builder()
                                                                .documentId("<id>")
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .build()))
                                                        .collections(List.of(
                                                            Collection.builder()
                                                                .name("<value>")
                                                                .description("meaty dial elegantly while react")
                                                                .id(854591L)
                                                                .audienceFilters(List.of(
                                                                    FacetFilter.builder()
                                                                        .fieldName("type")
                                                                        .values(List.of(
                                                                            FacetFilterValue.builder()
                                                                                .value("Spreadsheet")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build(),
                                                                            FacetFilterValue.builder()
                                                                                .value("Presentation")
                                                                                .relationType(RelationType.EQUALS)
                                                                                .build()))
                                                                        .build()))
                                                                .items(List.of(
                                                                    CollectionItem.builder()
                                                                        .collectionId(697663L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(697663L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build(),
                                                                    CollectionItem.builder()
                                                                        .collectionId(697663L)
                                                                        .itemType(CollectionItemItemType.TEXT)
                                                                        .shortcut(Shortcut.builder()
                                                                            .inputAlias("<value>")
                                                                            .build())
                                                                        .build()))
                                                                .build()))
                                                        .interactions(DocumentInteractions.builder()
                                                            .reacts(List.of(
                                                                Reaction.builder()
                                                                    .build(),
                                                                Reaction.builder()
                                                                    .build()))
                                                            .shares(List.of(
                                                                Share.builder()
                                                                    .numDaysAgo(365776L)
                                                                    .build(),
                                                                Share.builder()
                                                                    .numDaysAgo(365776L)
                                                                    .build(),
                                                                Share.builder()
                                                                    .numDaysAgo(365776L)
                                                                    .build()))
                                                            .build())
                                                        .verification(Verification.builder()
                                                            .state(State.DEPRECATED)
                                                            .metadata(VerificationMetadata.builder()
                                                                .reminders(List.of(
                                                                    Reminder.builder()
                                                                        .assignee(Person.builder()
                                                                            .name("George Clooney")
                                                                            .obfuscatedId("abc123")
                                                                            .build())
                                                                        .remindAt(268615L)
                                                                        .build()))
                                                                .lastReminder(Reminder.builder()
                                                                    .assignee(Person.builder()
                                                                        .name("George Clooney")
                                                                        .obfuscatedId("abc123")
                                                                        .build())
                                                                    .remindAt(423482L)
                                                                    .build())
                                                                .build())
                                                            .build())
                                                        .shortcuts(List.of(
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build(),
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build(),
                                                            Shortcut.builder()
                                                                .inputAlias("<value>")
                                                                .build()))
                                                        .customData(Map.ofEntries(
                                                            Map.entry("someCustomField", CustomDataValue.builder()
                                                                .build())))
                                                        .build())
                                                    .build())
                                                .build()))
                                        .inputDetails(SearchRequestInputDetails.builder()
                                            .hasCopyPaste(true)
                                            .build())
                                        .build())
                                    .results(List.of(
                                        SearchResult.builder()
                                            .url("https://example.com/foo/bar")
                                            .title("title")
                                            .nativeAppUrl("slack://foo/bar")
                                            .snippets(List.of(
                                                SearchResultSnippet.builder()
                                                    .snippet("snippet")
                                                    .mimeType("mimeType")
                                                    .build()))
                                            .build()))
                                    .build()))
                            .metadata(PersonMetadata.builder()
                                .type(PersonMetadataType.FULL_TIME)
                                .title("Actor")
                                .department("Movies")
                                .email("george@example.com")
                                .location("Hollywood, CA")
                                .phone("6505551234")
                                .photoUrl("https://example.com/george.jpg")
                                .startDate(LocalDate.parse("2000-01-23"))
                                .datasourceProfile(List.of(
                                    DatasourceProfile.builder()
                                        .datasource("github")
                                        .handle("<value>")
                                        .build(),
                                    DatasourceProfile.builder()
                                        .datasource("github")
                                        .handle("<value>")
                                        .build()))
                                .querySuggestions(QuerySuggestionList.builder()
                                    .suggestions(List.of(
                                        QuerySuggestion.builder()
                                            .query("app:github type:pull author:mortimer")
                                            .label("Mortimer's PRs")
                                            .datasource("github")
                                            .build()))
                                    .build())
                                .inviteInfo(InviteInfo.builder()
                                    .invites(List.of(
                                        ChannelInviteInfo.builder()
                                            .build(),
                                        ChannelInviteInfo.builder()
                                            .build()))
                                    .build())
                                .customFields(List.of(
                                    CustomFieldData.builder()
                                        .label("<value>")
                                        .values(List.of(
                                            CustomFieldValue.of(CustomFieldValueStr.builder()
                                                .build()),
                                            CustomFieldValue.of(CustomFieldValueStr.builder()
                                                .build()),
                                            CustomFieldValue.of(CustomFieldValueStr.builder()
                                                .build())))
                                        .build(),
                                    CustomFieldData.builder()
                                        .label("<value>")
                                        .values(List.of(
                                            CustomFieldValue.of(CustomFieldValueStr.builder()
                                                .build()),
                                            CustomFieldValue.of(CustomFieldValueStr.builder()
                                                .build()),
                                            CustomFieldValue.of(CustomFieldValueStr.builder()
                                                .build())))
                                        .build()))
                                .badges(List.of(
                                    Badge.builder()
                                        .key("deployment_name_new_hire")
                                        .displayName("New hire")
                                        .iconConfig(IconConfig.builder()
                                            .color("#343CED")
                                            .key("person_icon")
                                            .iconType(IconType.GLYPH)
                                            .name("user")
                                            .build())
                                        .build()))
                                .build())
                            .build())
                        .build()))
                .removedRoles(List.of(
                    UserRoleSpecification.builder()
                        .role(UserRole.VIEWER)
                        .person(Person.builder()
                            .name("George Clooney")
                            .obfuscatedId("abc123")
                            .metadata(PersonMetadata.builder()
                                .type(PersonMetadataType.FULL_TIME)
                                .title("Actor")
                                .department("Movies")
                                .email("george@example.com")
                                .location("Hollywood, CA")
                                .phone("6505551234")
                                .photoUrl("https://example.com/george.jpg")
                                .startDate(LocalDate.parse("2000-01-23"))
                                .datasourceProfile(List.of(
                                    DatasourceProfile.builder()
                                        .datasource("github")
                                        .handle("<value>")
                                        .build(),
                                    DatasourceProfile.builder()
                                        .datasource("github")
                                        .handle("<value>")
                                        .build()))
                                .querySuggestions(QuerySuggestionList.builder()
                                    .suggestions(List.of(
                                        QuerySuggestion.builder()
                                            .query("app:github type:pull author:mortimer")
                                            .label("Mortimer's PRs")
                                            .datasource("github")
                                            .build()))
                                    .build())
                                .inviteInfo(InviteInfo.builder()
                                    .invites(List.of(
                                        ChannelInviteInfo.builder()
                                            .build(),
                                        ChannelInviteInfo.builder()
                                            .build()))
                                    .build())
                                .badges(List.of(
                                    Badge.builder()
                                        .key("deployment_name_new_hire")
                                        .displayName("New hire")
                                        .iconConfig(IconConfig.builder()
                                            .color("#343CED")
                                            .key("person_icon")
                                            .iconType(IconType.GLYPH)
                                            .name("user")
                                            .build())
                                        .build()))
                                .build())
                            .build())
                        .build()))
                .audienceFilters(List.of(
                    FacetFilter.builder()
                        .fieldName("type")
                        .values(List.of(
                            FacetFilterValue.builder()
                                .value("Spreadsheet")
                                .relationType(RelationType.EQUALS)
                                .build(),
                            FacetFilterValue.builder()
                                .value("Presentation")
                                .relationType(RelationType.EQUALS)
                                .build()))
                        .build()))
                .build();

        CreatecollectionResponse res = sdk.client().collections().create()
                .request(req)
                .call();

        if (res.createCollectionResponse().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Server Variables

The default server `https://{instance}-be.glean.com` contains variables and is set to `https://instance-name-be.glean.com` by default. To override default values, the following builder methods are available when initializing the SDK client instance:

| Variable   | BuilderMethod               | Default           | Description                                                                                            |
| ---------- | --------------------------- | ----------------- | ------------------------------------------------------------------------------------------------------ |
| `instance` | `instance(String instance)` | `"instance-name"` | The instance name (typically the email domain without the TLD) that determines the deployment backend. |

#### Example

```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.ActivityResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .instance("<value>")
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        Activity req = Activity.builder()
                .events(List.of(
                    ActivityEvent.builder()
                        .action(ActivityEventAction.HISTORICAL_VIEW)
                        .timestamp(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                        .url("https://example.com/")
                        .build(),
                    ActivityEvent.builder()
                        .action(ActivityEventAction.SEARCH)
                        .timestamp(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                        .url("https://example.com/search?q=query")
                        .params(ActivityEventParams.builder()
                            .query("query")
                            .build())
                        .build(),
                    ActivityEvent.builder()
                        .action(ActivityEventAction.VIEW)
                        .timestamp(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                        .url("https://example.com/")
                        .params(ActivityEventParams.builder()
                            .duration(20L)
                            .referrer("https://example.com/document")
                            .build())
                        .build()))
                .build();

        ActivityResponse res = sdk.client().activity().report()
                .request(req)
                .call();

        // handle response
    }
}
```

### Override Server URL Per-Client

The default server can be overridden globally using the `.serverURL(String serverUrl)` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.ActivityResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .serverURL("https://instance-name-be.glean.com")
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        Activity req = Activity.builder()
                .events(List.of(
                    ActivityEvent.builder()
                        .action(ActivityEventAction.HISTORICAL_VIEW)
                        .timestamp(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                        .url("https://example.com/")
                        .build(),
                    ActivityEvent.builder()
                        .action(ActivityEventAction.SEARCH)
                        .timestamp(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                        .url("https://example.com/search?q=query")
                        .params(ActivityEventParams.builder()
                            .query("query")
                            .build())
                        .build(),
                    ActivityEvent.builder()
                        .action(ActivityEventAction.VIEW)
                        .timestamp(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                        .url("https://example.com/")
                        .params(ActivityEventParams.builder()
                            .duration(20L)
                            .referrer("https://example.com/document")
                            .build())
                        .build()))
                .build();

        ActivityResponse res = sdk.client().activity().report()
                .request(req)
                .call();

        // handle response
    }
}
```
<!-- End Server Selection [server] -->

<!-- Placeholder for Future Speakeasy SDK Sections -->

# Development

## Maturity

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning usage
to a specific package version. This way, you can install the same version each time without breaking changes unless you are intentionally
looking for the latest version.

## Contributions

While we value open-source contributions to this SDK, this library is generated programmatically. Any manual changes added to internal files will be overwritten on the next generation. 
We look forward to hearing your feedback. Feel free to open a PR or an issue with a proof of concept and we'll do our best to include it in a future release. 

### SDK Created by [Speakeasy](https://www.speakeasy.com/?utm_source=openapi&utm_campaign=java)
