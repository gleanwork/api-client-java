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
        .serverURL("https://mycompany-be.glean.com")
        .build();
glean.client().search().query()
        .searchRequest(SearchRequest.builder().query("search term").build())
        .call();

// Example of accessing Indexing namespace
Glean glean = Glean.builder()
        .apiToken("indexing-token")
        .serverURL("https://mycompany-be.glean.com")
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
  * [Asynchronous Support](#asynchronous-support)
  * [Authentication](#authentication)
  * [Available Resources and Operations](#available-resources-and-operations)
  * [Error Handling](#error-handling)
  * [Server Selection](#server-selection)
  * [Custom HTTP Client](#custom-http-client)
  * [Debugging](#debugging)
  * [Experimental Features and Deprecation Testing](#experimental-features-and-deprecation-testing)
  * [Jackson Configuration](#jackson-configuration)
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
implementation 'com.glean.api-client:glean-api-client:0.12.29'
```

Maven:
```xml
<dependency>
    <groupId>com.glean.api-client</groupId>
    <artifactId>glean-api-client</artifactId>
    <version>0.12.29</version>
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
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
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
            System.out.println(res.chatResponse().get());
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
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
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
            System.out.println(res.chatRequestStream().get());
        }
    }
}
```
#### Asynchronous Call
An asynchronous SDK client is also available that returns a [`CompletableFuture<T>`][comp-fut]. See [Asynchronous Support](#asynchronous-support) for more details on async benefits and reactive library integration.
```java
package hello.world;

import com.glean.api_client.glean_api_client.AsyncGlean;
import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.*;
import com.glean.api_client.glean_api_client.models.operations.async.ActivityResponse;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Application {

    public static void main(String[] args) {

        AsyncGlean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build()
            .async();

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

        CompletableFuture<ActivityResponse> resFut = sdk.client().activity().report()
                .request(req)
                .call();

        // handle response
    }
}
```

[comp-fut]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html

#### Union Consumption Patterns

When a response field is a union model:

- Discriminated unions: branch on the discriminator (`switch`) and then narrow to the concrete type.
- Non-discriminated unions: use generated accessors (for example `string()`, `asLong()`, `simpleObject()`) to determine the active variant.

For full model-specific examples (including Java 11/16/21 variants), see each union model's **Supported Types** section in the generated model docs.
<!-- End SDK Example Usage [usage] -->

<!-- Start Asynchronous Support [async-support] -->
## Asynchronous Support

The SDK provides comprehensive asynchronous support using Java's [`CompletableFuture<T>`][comp-fut] and [Reactive Streams `Publisher<T>`][reactive-streams] APIs. This design makes no assumptions about your choice of reactive toolkit, allowing seamless integration with any reactive library.

<details>
<summary>Why Use Async?</summary>

Asynchronous operations provide several key benefits:

- **Non-blocking I/O**: Your threads stay free for other work while operations are in flight
- **Better resource utilization**: Handle more concurrent operations with fewer threads
- **Improved scalability**: Build highly responsive applications that can handle thousands of concurrent requests
- **Reactive integration**: Works seamlessly with reactive streams and backpressure handling

</details>

<details>
<summary>Reactive Library Integration</summary>

The SDK returns [Reactive Streams `Publisher<T>`][reactive-streams] instances for operations dealing with streams involving multiple I/O interactions. We use Reactive Streams instead of JDK Flow API to provide broader compatibility with the reactive ecosystem, as most reactive libraries natively support Reactive Streams.

**Why Reactive Streams over JDK Flow?**
- **Broader ecosystem compatibility**: Most reactive libraries (Project Reactor, RxJava, Akka Streams, etc.) natively support Reactive Streams
- **Industry standard**: Reactive Streams is the de facto standard for reactive programming in Java
- **Better interoperability**: Seamless integration without additional adapters for most use cases

**Integration with Popular Libraries:**
- **Project Reactor**: Use `Flux.from(publisher)` to convert to Reactor types
- **RxJava**: Use `Flowable.fromPublisher(publisher)` for RxJava integration
- **Akka Streams**: Use `Source.fromPublisher(publisher)` for Akka Streams integration
- **Vert.x**: Use `ReadStream.fromPublisher(vertx, publisher)` for Vert.x reactive streams
- **Mutiny**: Use `Multi.createFrom().publisher(publisher)` for Quarkus Mutiny integration

**For JDK Flow API Integration:**
If you need JDK Flow API compatibility (e.g., for Quarkus/Mutiny 2), you can use adapters:
```java
// Convert Reactive Streams Publisher to Flow Publisher
Flow.Publisher<T> flowPublisher = FlowAdapters.toFlowPublisher(reactiveStreamsPublisher);

// Convert Flow Publisher to Reactive Streams Publisher
Publisher<T> reactiveStreamsPublisher = FlowAdapters.toPublisher(flowPublisher);
```

For standard single-response operations, the SDK returns `CompletableFuture<T>` for straightforward async execution.

</details>

<details>
<summary>Supported Operations</summary>

Async support is available for:

- **[Server-sent Events](#server-sent-event-streaming)**: Stream real-time events with Reactive Streams `Publisher<T>`
- **[JSONL Streaming](#jsonl-streaming)**: Process streaming JSON lines asynchronously
- **[Pagination](#pagination)**: Iterate through paginated results using `callAsPublisher()` and `callAsPublisherUnwrapped()`
- **[File Uploads](#file-uploads)**: Upload files asynchronously with progress tracking
- **[File Downloads](#file-downloads)**: Download files asynchronously with streaming support
- **[Standard Operations](#example)**: All regular API calls return `CompletableFuture<T>` for async execution

</details>

[comp-fut]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html
[reactive-streams]: https://www.reactive-streams.org/
<!-- End Asynchronous Support [async-support] -->

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
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
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

### [Authentication](docs/sdks/authentication/README.md)

* [checkdatasourceauth](docs/sdks/authentication/README.md#checkdatasourceauth) - Check datasource authorization

### [Client.Activity](docs/sdks/activity/README.md)

* [report](docs/sdks/activity/README.md#report) - Report document activity
* [feedback](docs/sdks/activity/README.md#feedback) - Report client activity

### [Client.Agents](docs/sdks/agents/README.md)

* [retrieve](docs/sdks/agents/README.md#retrieve) - Retrieve an agent
* [retrieveSchemas](docs/sdks/agents/README.md#retrieveschemas) - List an agent's schemas
* [list](docs/sdks/agents/README.md#list) - Search agents
* [runStream](docs/sdks/agents/README.md#runstream) - Create an agent run and stream the response
* [run](docs/sdks/agents/README.md#run) - Create an agent run and wait for the response

### [Client.Announcements](docs/sdks/announcements/README.md)

* [create](docs/sdks/announcements/README.md#create) - Create Announcement
* [delete](docs/sdks/announcements/README.md#delete) - Delete Announcement
* [update](docs/sdks/announcements/README.md#update) - Update Announcement

### [Client.Answers](docs/sdks/answers/README.md)

* [create](docs/sdks/answers/README.md#create) - Create Answer
* [delete](docs/sdks/answers/README.md#delete) - Delete Answer
* [update](docs/sdks/answers/README.md#update) - Update Answer
* [retrieve](docs/sdks/answers/README.md#retrieve) - Read Answer
* [~~list~~](docs/sdks/answers/README.md#list) - List Answers :warning: **Deprecated**

### [Client.Authentication](docs/sdks/clientauthentication/README.md)

* [createToken](docs/sdks/clientauthentication/README.md#createtoken) - Create authentication token

### [Client.Chat](docs/sdks/chat/README.md)

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

### [Client.Collections](docs/sdks/collections/README.md)

* [addItems](docs/sdks/collections/README.md#additems) - Add Collection item
* [create](docs/sdks/collections/README.md#create) - Create Collection
* [delete](docs/sdks/collections/README.md#delete) - Delete Collection
* [deleteItem](docs/sdks/collections/README.md#deleteitem) - Delete Collection item
* [update](docs/sdks/collections/README.md#update) - Update Collection
* [updateItem](docs/sdks/collections/README.md#updateitem) - Update Collection item
* [retrieve](docs/sdks/collections/README.md#retrieve) - Read Collection
* [list](docs/sdks/collections/README.md#list) - List Collections

### [Client.Documents](docs/sdks/clientdocuments/README.md)

* [retrievePermissions](docs/sdks/clientdocuments/README.md#retrievepermissions) - Read document permissions
* [retrieve](docs/sdks/clientdocuments/README.md#retrieve) - Read documents
* [retrieveByFacets](docs/sdks/clientdocuments/README.md#retrievebyfacets) - Read documents by facets
* [summarize](docs/sdks/clientdocuments/README.md#summarize) - Summarize documents

### [Client.Entities](docs/sdks/entities/README.md)

* [list](docs/sdks/entities/README.md#list) - List entities
* [readPeople](docs/sdks/entities/README.md#readpeople) - Read people

### [Client.Governance.Data.Policies](docs/sdks/policies/README.md)

* [retrieve](docs/sdks/policies/README.md#retrieve) - Gets specified policy
* [update](docs/sdks/policies/README.md#update) - Updates an existing policy
* [list](docs/sdks/policies/README.md#list) - Lists policies
* [create](docs/sdks/policies/README.md#create) - Creates new policy
* [download](docs/sdks/policies/README.md#download) - Downloads violations CSV for policy

### [Client.Governance.Data.Reports](docs/sdks/reports/README.md)

* [create](docs/sdks/reports/README.md#create) - Creates new one-time report
* [download](docs/sdks/reports/README.md#download) - Downloads violations CSV for report
* [status](docs/sdks/reports/README.md#status) - Fetches report run status

### [Client.Governance.Documents.Visibilityoverrides](docs/sdks/visibilityoverrides/README.md)

* [list](docs/sdks/visibilityoverrides/README.md#list) - Fetches documents visibility
* [create](docs/sdks/visibilityoverrides/README.md#create) - Hide or unhide docs

### [Client.Insights](docs/sdks/insights/README.md)

* [retrieve](docs/sdks/insights/README.md#retrieve) - Get insights

### [Client.Messages](docs/sdks/messages/README.md)

* [retrieve](docs/sdks/messages/README.md#retrieve) - Read messages

### [Client.Pins](docs/sdks/pins/README.md)

* [update](docs/sdks/pins/README.md#update) - Update pin
* [retrieve](docs/sdks/pins/README.md#retrieve) - Read pin
* [list](docs/sdks/pins/README.md#list) - List pins
* [create](docs/sdks/pins/README.md#create) - Create pin
* [remove](docs/sdks/pins/README.md#remove) - Delete pin

### [Client.Search](docs/sdks/search/README.md)

* [queryAsAdmin](docs/sdks/search/README.md#queryasadmin) - Search the index (admin)
* [autocomplete](docs/sdks/search/README.md#autocomplete) - Autocomplete
* [retrieveFeed](docs/sdks/search/README.md#retrievefeed) - Feed of documents and events
* [recommendations](docs/sdks/search/README.md#recommendations) - Recommend documents
* [query](docs/sdks/search/README.md#query) - Search

### [Client.Shortcuts](docs/sdks/clientshortcuts/README.md)

* [create](docs/sdks/clientshortcuts/README.md#create) - Create shortcut
* [delete](docs/sdks/clientshortcuts/README.md#delete) - Delete shortcut
* [retrieve](docs/sdks/clientshortcuts/README.md#retrieve) - Read shortcut
* [list](docs/sdks/clientshortcuts/README.md#list) - List shortcuts
* [update](docs/sdks/clientshortcuts/README.md#update) - Update shortcut

### [Client.Tools](docs/sdks/tools/README.md)

* [list](docs/sdks/tools/README.md#list) - List available tools
* [run](docs/sdks/tools/README.md#run) - Execute the specified tool

### [Client.Verification](docs/sdks/verification/README.md)

* [addReminder](docs/sdks/verification/README.md#addreminder) - Create verification
* [list](docs/sdks/verification/README.md#list) - List verifications
* [verify](docs/sdks/verification/README.md#verify) - Update verification

### [Datasources](docs/sdks/datasources/README.md)

* [getDatasourceInstanceConfiguration](docs/sdks/datasources/README.md#getdatasourceinstanceconfiguration) - Get datasource instance configuration
* [updateDatasourceInstanceConfiguration](docs/sdks/datasources/README.md#updatedatasourceinstanceconfiguration) - Update datasource instance configuration

### [Governance](docs/sdks/governance/README.md)

* [createfindingsexport](docs/sdks/governance/README.md#createfindingsexport) - Creates findings export
* [listfindingsexports](docs/sdks/governance/README.md#listfindingsexports) - Lists findings exports
* [downloadfindingsexport](docs/sdks/governance/README.md#downloadfindingsexport) - Downloads findings export
* [deletefindingsexport](docs/sdks/governance/README.md#deletefindingsexport) - Deletes findings export

### [Indexing.Authentication](docs/sdks/indexingauthentication/README.md)

* [rotateToken](docs/sdks/indexingauthentication/README.md#rotatetoken) - Rotate token

### [Indexing.Datasource](docs/sdks/datasource/README.md)

* [status](docs/sdks/datasource/README.md#status) - Beta: Get datasource status


### [Indexing.Datasources](docs/sdks/indexingdatasources/README.md)

* [add](docs/sdks/indexingdatasources/README.md#add) - Add or update datasource
* [retrieveConfig](docs/sdks/indexingdatasources/README.md#retrieveconfig) - Get datasource config

### [Indexing.Documents](docs/sdks/indexingdocuments/README.md)

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

### [Indexing.People](docs/sdks/people/README.md)

* [debug](docs/sdks/people/README.md#debug) - Beta: Get user information

* [~~count~~](docs/sdks/people/README.md#count) - Get user count :warning: **Deprecated**
* [index](docs/sdks/people/README.md#index) - Index employee
* [~~bulkIndex~~](docs/sdks/people/README.md#bulkindex) - Bulk index employees :warning: **Deprecated**
* [processAllEmployeesAndTeams](docs/sdks/people/README.md#processallemployeesandteams) - Schedules the processing of uploaded employees and teams
* [delete](docs/sdks/people/README.md#delete) - Delete employee
* [indexTeam](docs/sdks/people/README.md#indexteam) - Index team
* [deleteTeam](docs/sdks/people/README.md#deleteteam) - Delete team
* [bulkIndexTeams](docs/sdks/people/README.md#bulkindexteams) - Bulk index teams

### [Indexing.Permissions](docs/sdks/permissions/README.md)

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

### [Indexing.Shortcuts](docs/sdks/indexingshortcuts/README.md)

* [bulkIndex](docs/sdks/indexingshortcuts/README.md#bulkindex) - Bulk index external shortcuts
* [upload](docs/sdks/indexingshortcuts/README.md#upload) - Upload shortcuts

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.


[`GleanError`](./src/main/java/models/errors/GleanError.java) is the base class for all HTTP error responses. It has the following properties:

| Method           | Type                        | Description                                                              |
| ---------------- | --------------------------- | ------------------------------------------------------------------------ |
| `message()`      | `String`                    | Error message                                                            |
| `code()`         | `int`                       | HTTP response status code eg `404`                                       |
| `headers`        | `Map<String, List<String>>` | HTTP response headers                                                    |
| `body()`         | `byte[]`                    | HTTP body as a byte array. Can be empty array if no body is returned.    |
| `bodyAsString()` | `String`                    | HTTP body as a UTF-8 string. Can be empty string if no body is returned. |
| `rawResponse()`  | `HttpResponse<?>`           | Raw HTTP response (body already read and not available for re-read)      |

### Example
```java
package hello.world;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.errors.ErrorResponse;
import com.glean.api_client.glean_api_client.models.errors.GleanError;
import com.glean.api_client.glean_api_client.models.operations.GetAgentResponse;
import java.io.UncheckedIOException;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
            .build();
        try {

            GetAgentResponse res = sdk.client().agents().retrieve()
                    .agentId("<id>")
                    .call();

            if (res.agent().isPresent()) {
                System.out.println(res.agent().get());
            }
        } catch (GleanError ex) { // all SDK exceptions inherit from GleanError

            // ex.ToString() provides a detailed error message including
            // HTTP status code, headers, and error payload (if any)
            System.out.println(ex);

            // Base exception fields
            var rawResponse = ex.rawResponse();
            var headers = ex.headers();
            var contentType = headers.first("Content-Type");
            int statusCode = ex.code();
            Optional<byte[]> responseBody = ex.body();

            // different error subclasses may be thrown 
            // depending on the service call
            if (ex instanceof ErrorResponse) {
                var e = (ErrorResponse) ex;
                // Check error data fields
                e.data().ifPresent(payload -> {
                      Optional<String> message = payload.message();
                });
            }

            // An underlying cause may be provided. If the error payload 
            // cannot be deserialized then the deserialization exception 
            // will be set as the cause.
            if (ex.getCause() != null) {
                var cause = ex.getCause();
            }
        } catch (UncheckedIOException ex) {
            // handle IO error (connection, timeout, etc)
        }    }
}
```

### Error Classes
**Primary error:**
* [`GleanError`](./src/main/java/models/errors/GleanError.java): The base class for HTTP error responses.

<details><summary>Less common errors (9)</summary>

<br />

**Network errors:**
* `java.io.IOException` (always wrapped by `java.io.UncheckedIOException`). Commonly encountered subclasses of
`IOException` include `java.net.ConnectException`, `java.net.SocketTimeoutException`, `EOFException` (there are
many more subclasses in the JDK platform).

**Inherit from [`GleanError`](./src/main/java/models/errors/GleanError.java)**:
* [`com.glean.api_client.glean_api_client.models.errors.ErrorResponse`](./src/main/java/models/errors/com.glean.api_client.glean_api_client.models.errors.ErrorResponse.java): Error response returned for failed requests. Applicable to 6 of 116 methods.*
* [`com.glean.api_client.glean_api_client.models.errors.CollectionError`](./src/main/java/models/errors/com.glean.api_client.glean_api_client.models.errors.CollectionError.java): Semantic error. Status code `422`. Applicable to 3 of 116 methods.*
* [`com.glean.api_client.glean_api_client.models.errors.GleanDataError`](./src/main/java/models/errors/com.glean.api_client.glean_api_client.models.errors.GleanDataError.java): Forbidden. Applicable to 2 of 116 methods.*


</details>

\* Check [the method documentation](#available-resources-and-operations) to see if the error is applicable.
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
                .serverIndex(0)
                .instance("<value>")
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
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
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
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

<!-- Start Custom HTTP Client [http-client] -->
## Custom HTTP Client

The Java SDK makes API calls using an `HTTPClient` that wraps the native
[HttpClient](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html). This
client provides the ability to attach hooks around the request lifecycle that can be used to modify the request or handle
errors and response.

The `HTTPClient` interface allows you to either use the default `SpeakeasyHTTPClient` that comes with the SDK,
or provide your own custom implementation with customized configuration such as custom executors, SSL context,
connection pools, and other HTTP client settings.

The interface provides synchronous (`send`) methods and asynchronous (`sendAsync`) methods. The `sendAsync` method
is used to power the async SDK methods and returns a `CompletableFuture<HttpResponse<Blob>>` for non-blocking operations.

The following example shows how to add a custom header and handle errors:

```java
import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.utils.HTTPClient;
import com.glean.api_client.glean_api_client.utils.SpeakeasyHTTPClient;
import com.glean.api_client.glean_api_client.utils.Utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.InputStream;
import java.time.Duration;

public class Application {
    public static void main(String[] args) {
        // Create a custom HTTP client with hooks
        HTTPClient httpClient = new HTTPClient() {
            private final HTTPClient defaultClient = new SpeakeasyHTTPClient();
            
            @Override
            public HttpResponse<InputStream> send(HttpRequest request) throws IOException, URISyntaxException, InterruptedException {
                // Add custom header and timeout using Utils.copy()
                HttpRequest modifiedRequest = Utils.copy(request)
                    .header("x-custom-header", "custom value")
                    .timeout(Duration.ofSeconds(30))
                    .build();
                    
                try {
                    HttpResponse<InputStream> response = defaultClient.send(modifiedRequest);
                    // Log successful response
                    System.out.println("Request successful: " + response.statusCode());
                    return response;
                } catch (Exception error) {
                    // Log error
                    System.err.println("Request failed: " + error.getMessage());
                    throw error;
                }
            }
        };

        Glean sdk = Glean.builder()
            .client(httpClient)
            .build();
    }
}
```

<details>
<summary>Custom HTTP Client Configuration</summary>

You can also provide a completely custom HTTP client with your own configuration:

```java
import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.utils.HTTPClient;
import com.glean.api_client.glean_api_client.utils.Blob;
import com.glean.api_client.glean_api_client.utils.ResponseWithBody;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.InputStream;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.CompletableFuture;

public class Application {
    public static void main(String[] args) {
        // Custom HTTP client with custom configuration
        HTTPClient customHttpClient = new HTTPClient() {
            private final HttpClient client = HttpClient.newBuilder()
                .executor(Executors.newFixedThreadPool(10))
                .connectTimeout(Duration.ofSeconds(30))
                // .sslContext(customSslContext) // Add custom SSL context if needed
                .build();

            @Override
            public HttpResponse<InputStream> send(HttpRequest request) throws IOException, URISyntaxException, InterruptedException {
                return client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            }

            @Override
            public CompletableFuture<HttpResponse<Blob>> sendAsync(HttpRequest request) {
                // Convert response to HttpResponse<Blob> for async operations
                return client.sendAsync(request, HttpResponse.BodyHandlers.ofPublisher())
                    .thenApply(resp -> new ResponseWithBody<>(resp, Blob::from));
            }
        };

        Glean sdk = Glean.builder()
            .client(customHttpClient)
            .build();
    }
}
```

</details>

You can also enable debug logging on the default `SpeakeasyHTTPClient`:

```java
import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.utils.SpeakeasyHTTPClient;

public class Application {
    public static void main(String[] args) {
        SpeakeasyHTTPClient httpClient = new SpeakeasyHTTPClient();
        httpClient.enableDebugLogging(true);

        Glean sdk = Glean.builder()
            .client(httpClient)
            .build();
    }
}
```
<!-- End Custom HTTP Client [http-client] -->

<!-- Start Debugging [debug] -->
## Debugging

### Debug

You can setup your SDK to emit debug logs for SDK requests and responses.

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
__WARNING__: This logging should only be used for temporary debugging purposes. Leaving this option on in a production system could expose credentials/secrets in logs. <i>Authorization</i> headers are redacted by default and there is the ability to specify redacted header names via `SpeakeasyHTTPClient.setRedactedHeaders`.

__NOTE__: This is a convenience method that calls `HTTPClient.enableDebugLogging()`. The `SpeakeasyHTTPClient` honors this setting. If you are using a custom HTTP client, it is up to the custom client to honor this setting.


Another option is to set the System property `-Djdk.httpclient.HttpClient.log=all`. However, this second option does not log bodies.
<!-- End Debugging [debug] -->

## Experimental Features and Deprecation Testing

The SDK provides options to test upcoming API changes before they become the default behavior. This is useful for:

- **Testing experimental features** before they are generally available
- **Preparing for deprecations** by excluding deprecated endpoints ahead of their removal

### Configuration Options

You can configure these options either via environment variables or SDK constructor options:

#### Using Environment Variables

```bash
# Set environment variables before running your application
export X_GLEAN_EXCLUDE_DEPRECATED_AFTER="2026-10-15"
export X_GLEAN_INCLUDE_EXPERIMENTAL="true"
```

```java
// Environment variables are automatically read by the SDK
Glean glean = Glean.builder()
        .apiToken(System.getenv("GLEAN_API_TOKEN"))
        .serverURL("https://mycompany-be.glean.com")
        .build();
```

#### Using GleanBuilder (regen-safe)

```java
import com.glean.api_client.glean_api_client.hooks.GleanBuilder;

Glean glean = GleanBuilder.create()
        .apiToken(System.getenv("GLEAN_API_TOKEN"))
        .serverURL("https://mycompany-be.glean.com")
        .excludeDeprecatedAfter("2026-10-15")
        .includeExperimental(true)
        .build();
```

> **Note:** `GleanBuilder` is preserved across SDK regenerations. Generated builder options may change or be removed by regeneration.

### Option Reference

| Option | Environment Variable | Type | Description |
| ------ | -------------------- | ---- | ----------- |
| `excludeDeprecatedAfter` | `X_GLEAN_EXCLUDE_DEPRECATED_AFTER` | `String` (date) | Exclude API endpoints that will be deprecated after this date (format: `YYYY-MM-DD`). Use this to test your integration against upcoming deprecations. |
| `includeExperimental` | `X_GLEAN_INCLUDE_EXPERIMENTAL` | `boolean` | When `true`, enables experimental API features that are not yet generally available. Use this to preview and test new functionality. |

> **Note:** Environment variables take precedence over SDK constructor options when both are set.

> **Warning:** Experimental features may change or be removed without notice. Do not rely on experimental features in production environments.

<!-- Start Jackson Configuration [jackson] -->
## Jackson Configuration

The SDK ships with a pre-configured Jackson [`ObjectMapper`][jackson-databind] accessible via
`JSON.getMapper()`. It is set up with type modules, strict deserializers, and the feature flags
needed for full SDK compatibility (including ISO-8601 `OffsetDateTime` serialization):

```java
import com.glean.api_client.glean_api_client.utils.JSON;

String json = JSON.getMapper().writeValueAsString(response);
```

To compose with your own `ObjectMapper`, register the provided `GleanApiClientJacksonModule`, which
bundles all the same modules and feature flags as a single plug-and-play module:

```java
import com.glean.api_client.glean_api_client.utils.GleanApiClientJacksonModule;
import com.fasterxml.jackson.databind.ObjectMapper;

ObjectMapper myMapper = new ObjectMapper()
    .registerModule(new GleanApiClientJacksonModule());

String json = myMapper.writeValueAsString(response);
```

[jackson-databind]: https://github.com/FasterXML/jackson-databind
[jackson-jsr310]: https://github.com/FasterXML/jackson-modules-java8/tree/master/datetime
<!-- End Jackson Configuration [jackson] -->

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
