package api.touchbase.dynamodb.models;


import api.touchbase.EventType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.time.LocalDateTime;
import java.util.List;

@DynamoDBTable(tableName = "touchbase_events")
public class Event {
    private String eventId;
    private String eventFamilyId;
    private String eventOwnerId;
    private String description;
    private EventType eventType;
    private LocalDateTime eventDate;
    private LocalDateTime eventStartTime;
    private LocalDateTime eventEndTime;
    private List<String> eventAttendingMemberIds;

    @DynamoDBHashKey(attributeName = "eventFamilyId")
    public String getEventFamilyId() {
        return eventFamilyId;
    }

    public void setEventFamilyId(String eventFamilyId) {
        this.eventFamilyId = eventFamilyId;
    }

    @DynamoDBRangeKey(attributeName = "eventId")
    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @DynamoDBAttribute(attributeName = "eventOwnerId")
    public String getEventOwnerId() {
        return eventOwnerId;
    }

    public void setEventOwnerId(String eventOwnerId) {
        this.eventOwnerId = eventOwnerId;
    }

    @DynamoDBAttribute(attributeName = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDBAttribute(attributeName = "eventType")
    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @DynamoDBAttribute(attributeName = "eventDate")
    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    @DynamoDBAttribute(attributeName = "eventStartTime")
    public LocalDateTime getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(LocalDateTime eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    @DynamoDBAttribute(attributeName = "eventEndTime")
    public LocalDateTime getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(LocalDateTime eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    @DynamoDBAttribute(attributeName = "eventAttendingMemberIds")
    public List<String> getEventAttendingMemberIds() {
        return eventAttendingMemberIds;
    }

    public void setEventAttendingMemberIds(List<String> eventAttendingMemberIds) {
        this.eventAttendingMemberIds = eventAttendingMemberIds;
    }
}
