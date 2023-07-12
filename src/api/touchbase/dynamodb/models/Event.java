package api.touchbase.dynamodb.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class Event {
    private String eventId;
    private String eventOwnerId;
    private String eventDescription;
    private String eventType;
    private String eventStartMeridian;
    private String eventEndMeridian;
    private LocalDate eventDate;
    private LocalTime eventStartTime;
    private LocalTime eventEndTime;
    private Set<String> eventAttendingMemberNames;


    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventOwnerId() {
        return eventOwnerId;
    }

    public void setEventOwnerId(String eventOwnerId) {
        this.eventOwnerId = eventOwnerId;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventStartMeridian() {
        return eventStartMeridian;
    }

    public void setEventStartMeridian(String eventStartMeridian) {
        this.eventStartMeridian = eventStartMeridian;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(LocalTime eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public LocalTime getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(LocalTime eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public Set<String> getEventAttendingMemberNames() {
        return eventAttendingMemberNames;
    }

    public void setEventAttendingMemberNames(Set<String> eventAttendingMemberNames) {
        this.eventAttendingMemberNames = eventAttendingMemberNames;
    }

    public String getEventEndMeridian() {
        return eventEndMeridian;
    }

    public void setEventEndMeridian(String eventEndMeridian) {
        this.eventEndMeridian = eventEndMeridian;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", eventOwnerId='" + eventOwnerId + '\'' +
                ", description='" + eventDescription + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventDate=" + eventDate +
                ", eventStartTime=" + eventStartTime +
                ", eventEndTime=" + eventEndTime +
                ", eventAttendingMemberIds=" + eventAttendingMemberNames +
                '}';
    }
}
