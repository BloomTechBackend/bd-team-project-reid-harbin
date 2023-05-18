package api.touchbase.dynamodb.models;


import api.touchbase.EventType;
import api.touchbase.converters.LocalDateConverter;
import api.touchbase.converters.LocalTimeConverter;
import api.touchbase.converters.StringListConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@DynamoDBTable(tableName = "touchbase_events")
public class Event {
    private String eventId;
    private String eventFamilyId;
    private String eventOwnerId;
    private String description;
    private String eventType;
    private LocalDate eventDate;
    private LocalTime eventStartTime;
    private LocalTime eventEndTime;
    private List<String> eventAttendingMemberIds;

    @DynamoDBHashKey(attributeName = "familyId")
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
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    @DynamoDBAttribute(attributeName = "eventDate")
    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    @DynamoDBTypeConverted(converter = LocalTimeConverter.class)
    @DynamoDBAttribute(attributeName = "eventStartTime")
    public LocalTime getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(LocalTime eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    @DynamoDBTypeConverted(converter = LocalTimeConverter.class)
    @DynamoDBAttribute(attributeName = "eventEndTime")
    public LocalTime getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(LocalTime eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    @DynamoDBTypeConverted(converter = StringListConverter.class)
    @DynamoDBAttribute(attributeName = "eventAttendingMemberIds")
    public List<String> getEventAttendingMemberIds() {
        return eventAttendingMemberIds;
    }

    public void setEventAttendingMemberIds(List<String> eventAttendingMemberIds) {
        this.eventAttendingMemberIds = eventAttendingMemberIds;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", eventFamilyId='" + eventFamilyId + '\'' +
                ", eventOwnerId='" + eventOwnerId + '\'' +
                ", description='" + description + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventDate=" + eventDate +
                ", eventStartTime=" + eventStartTime +
                ", eventEndTime=" + eventEndTime +
                ", eventAttendingMemberIds=" + eventAttendingMemberIds +
                '}';
    }
}
