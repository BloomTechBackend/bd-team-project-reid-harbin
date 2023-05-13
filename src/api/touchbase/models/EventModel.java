package api.touchbase.models;

import java.util.List;

public class EventModel {
    private String eventId;
    private String eventOwnerId;
    private String eventDescription;
    private String eventType;
    private String eventDate;
    private String eventTimeRange;
    private List<String> eventFamilyMemberIds;

    public EventModel() {

    }

    public EventModel(Builder builder) {
        this.eventId = builder.eventId;
        this.eventOwnerId = builder.eventOwnerId;
        this.eventDescription = builder.eventDescription;
        this.eventType = builder.eventType;
        this.eventDate = builder.eventDate;
        this.eventTimeRange = builder.eventTimeRange;
        this.eventFamilyMemberIds = builder.eventFamilyMemberIds;
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
                ", eventTimeRange='" + eventTimeRange + '\'' +
                ", eventFamilyMemberNames=" + eventFamilyMemberIds +
                '}';
    }

    public static final class Builder {
        private String eventId;
        private String eventOwnerId;
        private String eventDescription;
        private String eventType;
        private String eventDate;
        private String eventTimeRange;
        private List<String> eventFamilyMemberIds;

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
        public Builder withEventTimeRange(String eventTimeRange) {
            this.eventTimeRange = eventTimeRange;
            return this;
        }
        public Builder withEventFamilyMemberNames(List<String> eventFamilyMemberNames) {
            this.eventFamilyMemberIds = eventFamilyMemberNames;
            return this;
        }

        public EventModel build() {
            return new EventModel(this);
        }
    }
}
