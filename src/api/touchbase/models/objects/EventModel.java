package api.touchbase.models.objects;

import java.util.Set;

public class EventModel {
    private String eventId;
    private String eventOwnerId;
    private String eventDescription;
    private String eventType;
    private String eventDate;
    private String eventStartTime;
    private String eventEndTime;
    private Set<String> eventAttendingMemberNames;

    public EventModel() {

    }

    public EventModel(String eventId, String eventOwnerId, String eventDescription, String eventType, String eventDate,
                      String eventStartTime, String eventEndTime, Set<String> eventAttendingMemberNames) {
        this.eventId = eventId;
        this.eventOwnerId = eventOwnerId;
        this.eventDescription = eventDescription;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.eventAttendingMemberNames = eventAttendingMemberNames;
    }

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

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public Set<String> getEventAttendingMemberNames() {
        return eventAttendingMemberNames;
    }

    public void setEventAttendingMemberNames(Set<String> eventAttendingMemberNames) {
        this.eventAttendingMemberNames = eventAttendingMemberNames;
    }

    public EventModel(Builder builder) {
        this.eventId = builder.eventId;
        this.eventOwnerId = builder.eventOwnerId;
        this.eventDescription = builder.eventDescription;
        this.eventType = builder.eventType;
        this.eventDate = builder.eventDate;
        this.eventStartTime = builder.eventStartTime;
        this.eventEndTime = builder.eventEndTime;
        this.eventAttendingMemberNames = builder.eventAttendingMemberNames;
    }
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "eventId='" + eventId + '\'' +
                ", eventOwnerId='" + eventOwnerId + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventDate='" + eventDate + '\'' +
                '}';
    }

    public static class Builder {
        private String eventId;
        private String eventOwnerId;
        private String eventDescription;
        private String eventType;
        private String eventDate;
        private String eventStartTime;
        private String eventEndTime;
        private Set<String> eventAttendingMemberNames;

        public Builder withEventId(String eventId) {
            this.eventId = eventId;
            return this;
        }
        public Builder withOwnerId(String eventOwnerId) {
            this.eventOwnerId = eventOwnerId;
            return this;
        }
        public Builder withEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
            return this;
        }
        public Builder withEventType(String eventType) {
            this.eventType = eventType;
            return this;
        }
        public Builder withEventDate(String eventDate) {
            this.eventDate = eventDate;
            return this;
        }

        public Builder withEventAttendingMemberNames(Set<String> eventFamilyMemberNames) {
            this.eventAttendingMemberNames = eventFamilyMemberNames;
            return this;
        }

        public Builder withEventStartTime(String eventStartTime) {
            this.eventStartTime = eventStartTime;
            return this;
        }

        public Builder withEventEndTime(String eventEndTime) {
            this.eventEndTime = eventEndTime;
            return this;
        }

        public EventModel build() {
            return new EventModel(this);
        }
    }
}
