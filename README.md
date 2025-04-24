# openapi

Developer-friendly & type-safe Java SDK specifically catered to leverage *openapi* API.

<div align="left">
    <a href="https://www.speakeasy.com/?utm_source=openapi&utm_campaign=java"><img src="https://custom-icon-badges.demolab.com/badge/-Built%20By%20Speakeasy-212015?style=for-the-badge&logoColor=FBE331&logo=speakeasy&labelColor=545454" /></a>
    <a href="https://mit-license.org/">
        <img src="https://img.shields.io/badge/License-MIT-blue.svg" style="width: 100px; height: 28px;" />
    </a>
</div>


<br /><br />
> [!IMPORTANT]
> This SDK is not yet ready for production use. To complete setup please follow the steps outlined in your [workspace](https://app.speakeasy.com/org/glean-el2/sdk). Delete this section before > publishing to a package manager.

<!-- Start Summary [summary] -->
## Summary

Glean API: # Introduction
In addition to the data sources that Glean has built-in support for, Glean also provides a REST API that enables customers to put arbitrary content in the search index. This is useful, for example, for doing permissions-aware search over content in internal tools that reside on-prem as well as for searching over applications that Glean does not currently support first class. In addition these APIs allow the customer to push organization data (people info, organization structure etc) into Glean.

# Usage guidelines
This API is evolving fast. Glean will provide advance notice of any planned backwards incompatible changes along
with a 6-month sunset period for anything that requires developers to adopt the new versions.
<!-- End Summary [summary] -->

<!-- Start Table of Contents [toc] -->
## Table of Contents
<!-- $toc-max-depth=2 -->
* [openapi](#openapi)
* [Usage guidelines](#usage-guidelines)
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
implementation 'com.glean:api-client:0.0.1'
```

Maven:
```xml
<dependency>
    <groupId>com.glean</groupId>
    <artifactId>api-client</artifactId>
    <version>0.0.1</version>
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

For request and response logging (especially json bodies) use:
```java
SpeakeasyHTTPClient.setDebugLogging(true); // experimental API only (may change without warning)
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
WARNING: This should only used for temporary debugging purposes. Leaving this option on in a production system could expose credentials/secrets in logs. <i>Authorization</i> headers are redacted by default and there is the ability to specify redacted header names via `SpeakeasyHTTPClient.setRedactedHeaders`.

Another option is to set the System property `-Djdk.httpclient.HttpClient.log=all`. However, this second option does not log bodies.
<!-- End SDK Installation [installation] -->

<!-- Start SDK Example Usage [usage] -->
## SDK Example Usage

### Example

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.ActivityResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
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
<!-- End SDK Example Usage [usage] -->

<!-- Start Authentication [security] -->
## Authentication

### Per-Client Security Schemes

This SDK supports the following security scheme globally:

| Name         | Type | Scheme      |
| ------------ | ---- | ----------- |
| `bearerAuth` | http | HTTP Bearer |

To authenticate with the API the `bearerAuth` parameter must be set when initializing the SDK client instance. For example:
```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.ActivityResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
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

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>

### [agents()](docs/sdks/agents/README.md)

* [runagent](docs/sdks/agents/README.md#runagent) - Runs an Agent.
* [listagents](docs/sdks/agents/README.md#listagents) - Lists all agents.
* [getagentinputs](docs/sdks/agents/README.md#getagentinputs) - Gets the inputs to an agent.

### [client()](docs/sdks/client/README.md)


#### [client().activities()](docs/sdks/activities/README.md)

* [reportActivity](docs/sdks/activities/README.md#reportactivity) - Report client activity

#### [client().activity()](docs/sdks/activity/README.md)

* [report](docs/sdks/activity/README.md#report) - Report document activity

#### [client().announcements()](docs/sdks/announcements/README.md)

* [create](docs/sdks/announcements/README.md#create) - Create Announcement
* [createDraft](docs/sdks/announcements/README.md#createdraft) - Create draft Announcement
* [delete](docs/sdks/announcements/README.md#delete) - Delete Announcement
* [deleteDraft](docs/sdks/announcements/README.md#deletedraft) - Delete draft Announcement
* [get](docs/sdks/announcements/README.md#get) - Read Announcement
* [getDraft](docs/sdks/announcements/README.md#getdraft) - Read draft Announcement
* [list](docs/sdks/announcements/README.md#list) - List Announcements
* [preview](docs/sdks/announcements/README.md#preview) - Preview Announcement
* [previewDraft](docs/sdks/announcements/README.md#previewdraft) - Preview draft Announcement
* [publish](docs/sdks/announcements/README.md#publish) - Publish draft Announcement
* [unpublish](docs/sdks/announcements/README.md#unpublish) - Unpublish Announcement
* [update](docs/sdks/announcements/README.md#update) - Update Announcement
* [updateDraft](docs/sdks/announcements/README.md#updatedraft) - Update draft Announcement

#### [client().answers()](docs/sdks/answers/README.md)

* [create](docs/sdks/answers/README.md#create) - Create Answer
* [delete](docs/sdks/answers/README.md#delete) - Delete Answer
* [edit](docs/sdks/answers/README.md#edit) - Update Answer
* [get](docs/sdks/answers/README.md#get) - Read Answer
* [list](docs/sdks/answers/README.md#list) - List Answers
* [preview](docs/sdks/answers/README.md#preview) - Preview Answer
* [previewDraft](docs/sdks/answers/README.md#previewdraft) - Preview draft Answer
* [updateLikes](docs/sdks/answers/README.md#updatelikes) - Update Answer likes
* [~~createBoard~~](docs/sdks/answers/README.md#createboard) - Create Answer Board :warning: **Deprecated**
* [~~deleteBoard~~](docs/sdks/answers/README.md#deleteboard) - Delete Answer Board :warning: **Deprecated**
* [~~updateBoard~~](docs/sdks/answers/README.md#updateboard) - Update Answer Board :warning: **Deprecated**
* [~~getBoard~~](docs/sdks/answers/README.md#getboard) - Read Answer Board :warning: **Deprecated**
* [~~listBoards~~](docs/sdks/answers/README.md#listboards) - List Answer Boards :warning: **Deprecated**

#### [client().authentication()](docs/sdks/clientauthentication/README.md)

* [createAnonymousToken](docs/sdks/clientauthentication/README.md#createanonymoustoken) - Create anonymous token
* [createToken](docs/sdks/clientauthentication/README.md#createtoken) - Create authentication token

#### [client().calendar()](docs/sdks/calendar/README.md)

* [getEvents](docs/sdks/calendar/README.md#getevents) - Read events

#### [client().chat()](docs/sdks/chat/README.md)

* [ask](docs/sdks/chat/README.md#ask) - Detect and answer questions
* [start](docs/sdks/chat/README.md#start) - Chat
* [deleteAll](docs/sdks/chat/README.md#deleteall) - Deletes all saved Chats owned by a user
* [delete](docs/sdks/chat/README.md#delete) - Deletes saved Chats
* [get](docs/sdks/chat/README.md#get) - Retrieves a Chat
* [list](docs/sdks/chat/README.md#list) - Retrieves all saved Chats
* [getApplication](docs/sdks/chat/README.md#getapplication) - Gets the metadata for a custom Chat application
* [uploadFiles](docs/sdks/chat/README.md#uploadfiles) - Upload files for Chat.
* [getFiles](docs/sdks/chat/README.md#getfiles) - Get files uploaded by a user for Chat.
* [deleteFiles](docs/sdks/chat/README.md#deletefiles) - Delete files uploaded by a user for chat.

#### [client().collections()](docs/sdks/collections/README.md)

* [addItems](docs/sdks/collections/README.md#additems) - Add Collection item
* [create](docs/sdks/collections/README.md#create) - Create Collection
* [delete](docs/sdks/collections/README.md#delete) - Delete Collection
* [deleteItem](docs/sdks/collections/README.md#deleteitem) - Delete Collection item
* [update](docs/sdks/collections/README.md#update) - Update Collection
* [editItem](docs/sdks/collections/README.md#edititem) - Update Collection item
* [edit](docs/sdks/collections/README.md#edit) - Update document Collections
* [get](docs/sdks/collections/README.md#get) - Read Collection
* [list](docs/sdks/collections/README.md#list) - List Collections
* [moveItem](docs/sdks/collections/README.md#moveitem) - Move Collection item
* [pin](docs/sdks/collections/README.md#pin) - Pin Collection

#### [client().displayableLists()](docs/sdks/displayablelists/README.md)

* [create](docs/sdks/displayablelists/README.md#create) - Create displayable lists
* [delete](docs/sdks/displayablelists/README.md#delete) - Delete displayable lists
* [get](docs/sdks/displayablelists/README.md#get) - Read displayable lists
* [update](docs/sdks/displayablelists/README.md#update) - Update displayable lists

#### [client().documents()](docs/sdks/clientdocuments/README.md)

* [getPermissions](docs/sdks/clientdocuments/README.md#getpermissions) - Read document permissions
* [get](docs/sdks/clientdocuments/README.md#get) - Read documents
* [getByFacets](docs/sdks/clientdocuments/README.md#getbyfacets) - Read documents by facets
* [getAnalytics](docs/sdks/clientdocuments/README.md#getanalytics) - Read document analytics

#### [client().entities()](docs/sdks/entities/README.md)

* [list](docs/sdks/entities/README.md#list) - List entities
* [readPeople](docs/sdks/entities/README.md#readpeople) - Read people
* [getTeams](docs/sdks/entities/README.md#getteams) - Read teams

#### [client().images()](docs/sdks/images/README.md)

* [get](docs/sdks/images/README.md#get) - Get image
* [upload](docs/sdks/images/README.md#upload) - Upload images

#### [client().insights()](docs/sdks/insights/README.md)

* [get](docs/sdks/insights/README.md#get) - Read insights

#### [client().messages()](docs/sdks/messages/README.md)

* [get](docs/sdks/messages/README.md#get) - Read messages

#### [client().pins()](docs/sdks/pins/README.md)

* [edit](docs/sdks/pins/README.md#edit) - Update pin
* [get](docs/sdks/pins/README.md#get) - Read pin
* [list](docs/sdks/pins/README.md#list) - List pins
* [create](docs/sdks/pins/README.md#create) - Create pin
* [remove](docs/sdks/pins/README.md#remove) - Delete pin

#### [client().search()](docs/sdks/search/README.md)

* [admin](docs/sdks/search/README.md#admin) - Search the index (admin)
* [autocomplete](docs/sdks/search/README.md#autocomplete) - Autocomplete
* [getFeed](docs/sdks/search/README.md#getfeed) - Feed of documents and events
* [suggestPeople](docs/sdks/search/README.md#suggestpeople) - Suggest people
* [suggestPeopleAdmin](docs/sdks/search/README.md#suggestpeopleadmin) - Suggest people (admin)
* [recommendations](docs/sdks/search/README.md#recommendations) - Recommend documents
* [execute](docs/sdks/search/README.md#execute) - Search

#### [client().shortcuts()](docs/sdks/clientshortcuts/README.md)

* [create](docs/sdks/clientshortcuts/README.md#create) - Create shortcut
* [delete](docs/sdks/clientshortcuts/README.md#delete) - Delete shortcut
* [get](docs/sdks/clientshortcuts/README.md#get) - Read shortcut
* [getSimilar](docs/sdks/clientshortcuts/README.md#getsimilar) - Get similar shortcuts
* [list](docs/sdks/clientshortcuts/README.md#list) - List shortcuts
* [preview](docs/sdks/clientshortcuts/README.md#preview) - Preview shortcut
* [update](docs/sdks/clientshortcuts/README.md#update) - Update shortcut
* [upload](docs/sdks/clientshortcuts/README.md#upload) - Upload shortcuts

#### [client().summarize()](docs/sdks/summarize/README.md)

* [generate](docs/sdks/summarize/README.md#generate) - Summarize documents

#### [client().tools()](docs/sdks/tools/README.md)

* [executeAction](docs/sdks/tools/README.md#executeaction) - Execute Action Tool

#### [client().user()](docs/sdks/user/README.md)

* [addCredential](docs/sdks/user/README.md#addcredential) - Create credentials
* [deleteQueryHistory](docs/sdks/user/README.md#deletequeryhistory) - Delete query history
* [invite](docs/sdks/user/README.md#invite) - Send invitation
* [getPublicConfig](docs/sdks/user/README.md#getpublicconfig) - Read public client configuration
* [removeCredential](docs/sdks/user/README.md#removecredential) - Delete credentials
* [sendSupportEmail](docs/sdks/user/README.md#sendsupportemail) - Send support email

#### [client().verification()](docs/sdks/verification/README.md)

* [addReminder](docs/sdks/verification/README.md#addreminder) - Create verification
* [list](docs/sdks/verification/README.md#list) - List verifications
* [verify](docs/sdks/verification/README.md#verify) - Update verification


### [indexing()](docs/sdks/indexing/README.md)


#### [indexing().authentication()](docs/sdks/indexingauthentication/README.md)

* [rotateToken](docs/sdks/indexingauthentication/README.md#rotatetoken) - Rotate token

#### [indexing().datasources()](docs/sdks/datasources/README.md)

* [add](docs/sdks/datasources/README.md#add) - Add or update datasource
* [getConfig](docs/sdks/datasources/README.md#getconfig) - Get datasource config

#### [indexing().documents()](docs/sdks/indexingdocuments/README.md)

* [addOrUpdate](docs/sdks/indexingdocuments/README.md#addorupdate) - Index document
* [index](docs/sdks/indexingdocuments/README.md#index) - Index documents
* [bulkIndex](docs/sdks/indexingdocuments/README.md#bulkindex) - Bulk index documents
* [processAll](docs/sdks/indexingdocuments/README.md#processall) - Schedules the processing of uploaded documents
* [delete](docs/sdks/indexingdocuments/README.md#delete) - Delete document

#### [indexing().people()](docs/sdks/people/README.md)

* [index](docs/sdks/people/README.md#index) - Index employee
* [bulkIndexEmployees](docs/sdks/people/README.md#bulkindexemployees) - Bulk index employees
* [~~bulkIndex~~](docs/sdks/people/README.md#bulkindex) - Bulk index employees :warning: **Deprecated**
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

#### [indexing().troubleshooting()](docs/sdks/troubleshooting/README.md)

* [getDatasourceStatus](docs/sdks/troubleshooting/README.md#getdatasourcestatus) - Beta: Get datasource status

* [postDocumentDebug](docs/sdks/troubleshooting/README.md#postdocumentdebug) - Beta: Get document information

* [postDocumentsDebug](docs/sdks/troubleshooting/README.md#postdocumentsdebug) - Beta: Get information of a batch of documents

* [debugUser](docs/sdks/troubleshooting/README.md#debuguser) - Beta: Get user information

* [checkAccess](docs/sdks/troubleshooting/README.md#checkaccess) - Check document access
* [~~getStatus~~](docs/sdks/troubleshooting/README.md#getstatus) - Get document upload and indexing status :warning: **Deprecated**
* [~~getDocumentCount~~](docs/sdks/troubleshooting/README.md#getdocumentcount) - Get document count :warning: **Deprecated**
* [~~getUserCount~~](docs/sdks/troubleshooting/README.md#getusercount) - Get user count :warning: **Deprecated**

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.

By default, an API error will throw a `models/errors/APIException` exception. When custom error responses are specified for an operation, the SDK may also throw their associated exception. You can refer to respective *Errors* tables in SDK docs for more details on possible exception types for each operation. For example, the `ask` method throws the following exceptions:

| Error Type                 | Status Code | Content Type     |
| -------------------------- | ----------- | ---------------- |
| models/errors/ErrorInfo    | 403, 422    | application/json |
| models/errors/APIException | 4XX, 5XX    | \*/\*            |

### Example

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.errors.ErrorInfo;
import com.glean.api_client.models.operations.AskResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorInfo, Exception {

        Glean sdk = Glean.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        AskResponse res = sdk.client().chat().ask()
                .askRequest(AskRequest.builder()
                    .searchRequest(SearchRequest.builder()
                        .query("vacation policy")
                        .trackingToken("trackingToken")
                        .sourceDocument(Document.builder()
                            .metadata(DocumentMetadata.builder()
                                .datasource("datasource")
                                .objectType("Feature Request")
                                .container("container")
                                .parentId("JIRA_EN-1337")
                                .mimeType("mimeType")
                                .documentId("documentId")
                                .createTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                .updateTime(OffsetDateTime.parse("2000-01-23T04:56:07.000Z"))
                                .author(Person.builder()
                                    .name("George Clooney")
                                    .obfuscatedId("abc123")
                                    .relatedDocuments(List.of())
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
                                                .build()))
                                        .querySuggestions(QuerySuggestionList.builder()
                                            .suggestions(List.of())
                                            .build())
                                        .inviteInfo(InviteInfo.builder()
                                            .invites(List.of())
                                            .build())
                                        .customFields(List.of())
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
                                .owner(Person.builder()
                                    .name("George Clooney")
                                    .obfuscatedId("abc123")
                                    .build())
                                .mentionedPeople(List.of())
                                .components(List.of(
                                    "Backend",
                                    "Networking"))
                                .status("[\"Done\"]")
                                .pins(List.of())
                                .assignedTo(Person.builder()
                                    .name("George Clooney")
                                    .obfuscatedId("abc123")
                                    .build())
                                .updatedBy(Person.builder()
                                    .name("George Clooney")
                                    .obfuscatedId("abc123")
                                    .build())
                                .collections(List.of())
                                .interactions(DocumentInteractions.builder()
                                    .reacts(List.of())
                                    .shares(List.of())
                                    .build())
                                .verification(Verification.builder()
                                    .state(State.UNVERIFIED)
                                    .metadata(VerificationMetadata.builder()
                                        .lastVerifier(Person.builder()
                                            .name("George Clooney")
                                            .obfuscatedId("abc123")
                                            .build())
                                        .reminders(List.of())
                                        .lastReminder(Reminder.builder()
                                            .assignee(Person.builder()
                                                .name("George Clooney")
                                                .obfuscatedId("abc123")
                                                .build())
                                            .remindAt(892381L)
                                            .requestor(Person.builder()
                                                .name("George Clooney")
                                                .obfuscatedId("abc123")
                                                .build())
                                            .build())
                                        .candidateVerifiers(List.of())
                                        .build())
                                    .build())
                                .customData(Map.ofEntries(
                                    Map.entry("someCustomField", CustomDataValue.builder()
                                        .build())))
                                .contactPerson(Person.builder()
                                    .name("George Clooney")
                                    .obfuscatedId("abc123")
                                    .build())
                                .build())
                            .build())
                        .pageSize(100L)
                        .maxSnippetSize(400L)
                        .inputDetails(SearchRequestInputDetails.builder()
                            .hasCopyPaste(true)
                            .build())
                        .requestOptions(SearchRequestOptions.builder()
                            .facetBucketSize(132988L)
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
                        .timeoutMillis(5000L)
                        .people(List.of(
                            Person.builder()
                                .name("George Clooney")
                                .obfuscatedId("abc123")
                                .build()))
                        .build())
                    .build())
                .call();

        if (res.askResponse().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Server Variables

The default server `https://{domain}-be.glean.com` contains variables and is set to `https://domain-be.glean.com` by default. To override default values, the following builder methods are available when initializing the SDK client instance:

| Variable | BuilderMethod           | Default    | Description                                                              |
| -------- | ----------------------- | ---------- | ------------------------------------------------------------------------ |
| `domain` | `domain(String domain)` | `"domain"` | Email domain (without extension) that determines the deployment backend. |

#### Example

```java
package hello.world;

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.ActivityResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .domain("scared-pearl.biz")
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
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

import com.glean.api_client.Glean;
import com.glean.api_client.models.components.*;
import com.glean.api_client.models.operations.ActivityResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Glean sdk = Glean.builder()
                .serverURL("https://domain-be.glean.com")
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
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
