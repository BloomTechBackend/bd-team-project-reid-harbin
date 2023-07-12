# [TouchBase] Design Document

## Instructions

*Save a copy of this template for your team in the same folder that contains
this template.*

*Replace italicized text (including this text!) with details of the design you
are proposing for your team project. (Your replacement text shouldn't be in
italics)*

*You should take a look at the example design document in the same folder as
this template for more guidance on the types of information to capture, and the
level of detail to aim for.*

## *Project Title* Design

## 1. Problem Statement

Physical family planners are not an efficient way to communicate family events. The planner can get hard to read when 
there are multiple events and times scribbled out and updated. Family planners have a limited amount of space to write 
down events which can cause a family memberId to leave out important information if there isn't much room.
Finally, if the planner is not nearby, it will be hard for a family memberId to plan events around what is on the 
planner.

## 2. Top Questions to Resolve in Review

*List the most important questions you have about your design, or things that
you are still debating internally that you might like help working through.*

1. Should there be a separate lambda function that handles sending out a notification(s) when event details or a family
   details get updated?
   
2. Should events be accessible by their index in the Events List or by a unique Id?

3. Should I have a public model for Notifications if it is stored inside the members database?



## 3. Use Cases

*This is where we work backwards from the customer and define what our customers
would like to do (and why). You may also include use cases for yourselves, or
for the organization providing the product to customers.*

As a TouchBase customer I want to...

U1. Create a "Member" account that will represent me.
 
U2. Create a "Family" family members can join and post their upcoming events.
 
U3. View the upcoming events family members created.
 
U4. Create an event with the start and end time, date, type, and a description.
 
U5. Delete an event that has been cancelled.
 
U6. Update an event's details I created when plans change.
 
U7. Add myself to an event another family memberId created.
 
U8. See who is attending an event.
 
U9. Be notified if an update occurs to an event I am involved in.

U10. Delete notifications I have read.

## 4. Project Scope

*Clarify which parts of the problem you intend to solve. It helps reviewers know
what questions to ask to make sure you are solving for what you say and stops
discussions from getting sidetracked by aspects you do not intend to handle in
your design.*




### 4.1. In Scope

*Which parts of the problem defined in Sections 1 and 3 will you solve with this
design?*

* Creating, retrieving, and deleting a memberId
* Creating or joining a family group
* Generating notifications when a memberId joins a family based on updates to events
* Generating notifications based on updates to events
* Generating random Ids for families, members, and events.
* Retrieving and deleting notifications from a memberId's list of notifications
* Creating and removing events from a family's list of events
* Updating an event's details
* Adding or removing a memberId to an event
* Ordering the list of events from the closest date and time to the farthest


### 4.2. Out of Scope

*Based on your problem description in Sections 1 and 3, are there any aspects
you are not planning to solve? Do potential expansions or related problems occur
to you that you want to explicitly say you are not worrying about now? Feel free
to put anything here that you think your team can't accomplish in the unit, but
would love to do with more time.*

* Automatically deleting out of date events
* Notifying the user if they have joined an event that conflicts with one they have already joined
* The ability to retrieve events associated with a specific family memberId through the API
* Attaching a family owner to manage the family account for family account management
* Updating memberId account details



# 5. Proposed Architecture Overview

*Describe broadly how you are proposing to solve for the requirements you
described in Section 3.*

*This may include class diagram(s) showing what components you are planning to
build.*

*You should argue why this architecture (organization of components) is
reasonable. That is, why it represents a good data flow and a good separation of
concerns. Where applicable, argue why this architecture satisfies the stated
requirements.*

# 6. API

## 6.1. Public Models

MemberModel, EventModel, and NotificationModel.

```
// MemberModel

String memberId;
String memberName;
String memberFamilyId;
List<Notification> memberNotifications;
```
```
// FamilyModel

String familyId;
List<String> familyMemberNamesToMemberIds;
List<Event> familyEvents;
```

```
// EventModel

String eventId;
String eventOwnerId;
String eventDescription;
String eventType;
String eventStartMeridian;
String eventEndMeridian;
LocalDate eventDate;
LocalTime eventStartTime;
LocalTime eventEndTime;
Set<String> eventAttendingMemberIds;
```

```
// NotificationModel

String notificationHeadline;
String notificationDescription;
String notificationSenderName;
String notificationDate;
```



## 6.2. API Endpoints

### /member
> GET
> * Accepts a memberName and memberPassword to log a memberId into their account
> * The provided memberPassword is hashed and validated against the password associated with the provided memberName
>   (given the account exists)
> * Returns the associated memberId 
>   * Names and passwords that are blank or null throw `InvalidInputException`
>   * If there is no Member with the provided name throws `MemberNotFoundException`
>   * Passwords that are not associated with the memberName throw a `InvalidPasswordException`


> POST
> * Accepts a memberName and memberPassword to create a Member Account.
> * memberPassword gets salted, peppered, and then hashed before it is saved to the database
>   list, and the memberId's name.
> * A randomly generated Id is generated for the user
> * A Notifications list is created containing a Welcome Message from touchbase
> * Returns the associated memberId
>   * A blank or null password will throw an `InvalidInputException`
>   * A Blank or null Username will throw an `InvalidInputException`
>   * Username is already in use that matches the request name will throw a `UsernameTakenException`
>   * A password containing invalid characters or is null will throw an `InvalidPasswordException`
>   



### /member/{memberId}
> GET
> * Accepts a memberId to get account details
> * returns the associated MemberModel
>   * A null memberId and a memberId that does not exist in the database throws `MemberNotFoundException`


> DELETE
> * Accepts a memberId to delete a Member's account
### /member/{memberId}/notifications

> GET
> * gets a Member's list of notifications
 

> PUT
> * Removes a notification in the Member's list of notifications when given the proper notification Id.

### /family
> POST 


> PUT

### /family/{familyId}/events
> GET


> POST


> PUT


> DELETE

# 7. Tables

## touchbase_members
- AttributeName: "memberId"
  - AttributeType: "S"

 
- AttributeName: "memberFamilyId"
  - AttributeType: "S"


- AttributeName: "memberName"
  - AttributeType: "S"


- AttributeName: "memberPassword"
  - AttributeType: "S"


- AttributeName: "memberPasswordSalt"
  - AttributeType: "S"


- AttributeName: "memberNotifications"
  - AttributeType: "S"

## touchbase_families
- AttributeName: "familyId"
  - AttributeType: "S"


- AttributeName: "familyName"
  - AttributeType: "S"


- AttributeName: "familyPassword"
  - AttributeType: "S"


- AttributeName: "familyEvents"
   - AttributeType: "S"


- AttributeName: "familyMemberNamesToMemberIds"
  - AttributeType: "S"

# 8. Pages

*Include mock-ups of the web pages you expect to build. These can be as
sophisticated as mockups/wireframes using drawing software, or as simple as
hand-drawn pictures that represent the key customer-facing components of the
pages. It should be clear what the interactions will be on the page, especially
where customers enter and submit data. You may want to accompany the mockups
with some description of behaviors of the page (e.g. “When customer submits the
submit-dog-photo button, the customer is sent to the doggie detail page”)*



*Define the DynamoDB tables you will need for the data your service will use. It
may be helpful to first think of what objects your service will need, then
translate that to a table structure, like with the *`Playlist` POJO* versus the
`playlists` table in the Unit 3 project.*
