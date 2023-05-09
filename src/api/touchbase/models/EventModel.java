package api.touchbase.models;

import java.util.List;

public class EventModel {
    private String eventId;
    private String eventOwner;
    private String eventDescription;
    private String eventType;
    private String eventDate;
    private String eventStartTime;
    private String eventEndTime;
    private List<String> eventFamilyMemberNames;

    public EventModel() {

    }

    public EventModel(Builder builder) {
        this.eventId = builder.eventId;
        this.eventOwner = builder.eventOwnerId;
        this.eventDescription = builder.eventDescription;
        this.eventType = builder.eventType;
        this.eventDate = builder.eventDate;
        this.eventStartTime = builder.eventStartTime;
        this.eventEndTime = builder.eventEndTime;
        this.eventFamilyMemberNames = builder.eventFamilyMemberNames;
    }
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "eventId='" + eventId + '\'' +
                ", eventOwnerId='" + eventOwner + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", eventStartTime='" + eventStartTime + '\'' +
                ", eventEndTime='" + eventEndTime + '\'' +
                ", eventFamilyMemberNames=" + eventFamilyMemberNames +
                '}';
    }

    public static final class Builder {
        private String eventId;
        private String eventOwnerId;
        private String eventDescription;
        private String eventType;
        private String eventDate;
        private String eventStartTime;
        private String eventEndTime;
        private List<String> eventFamilyMemberNames;

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
        public Builder withEventStartTime(String eventStartTime) {
            this.eventStartTime = eventStartTime;
            return this;
        }
        public Builder withEventEndTime(String eventEndTime) {
            this.eventEndTime = eventEndTime;
            return this;
        }
        public Builder withEventFamilyMemberNames(List<String> eventFamilyMemberNames) {
            this.eventFamilyMemberNames = eventFamilyMemberNames;
            return this;
        }
    }
}
