package api.touchbase.models.requests.family;

import java.util.List;

public class CreateEventRequest {
    private String familyId;
    private String eventOwnerName;
    private String eventType;
    private String eventDate;
    private String eventStartMeridian;
    private String eventEndMeridian;
    private String eventStartTime;
    private String eventEndTime;
    private String description;
    private List<String> eventAttendingMemberNames;

    public CreateEventRequest() {
    }

    public CreateEventRequest(String familyId, String eventOwnerId, String eventType, String eventDate,
                              String eventStartTime, String eventEndTime, String description,
                              List<String> eventAttendingMemberNames) {
        this.familyId = familyId;
        this.eventOwnerName = eventOwnerId;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.description = description;
        this.eventAttendingMemberNames = eventAttendingMemberNames;
    }

    public CreateEventRequest(Builder builder){
        this.familyId = builder.familyId;
        this.eventOwnerName = builder.eventOwnerName;
        this.description = builder.description;
        this.eventType = builder.eventType;
        this.eventDate = builder.eventDate;
        this.eventStartMeridian = builder.eventStartMeridian;
        this.eventEndMeridian = builder.eventEndMeridian;
        this.eventStartTime = builder.eventStartTime;
        this.eventEndTime = builder.eventEndTime;
        this.eventAttendingMemberNames = builder.eventAttendingMemberNames;
    }

    public String getEventOwnerName() {
        return eventOwnerName;
    }

    public void setEventOwnerName(String eventOwnerName) {
        this.eventOwnerName = eventOwnerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getEventStartMeridian() {
        return eventStartMeridian;
    }

    public void setEventStartMeridian(String eventStartMeridian) {
        this.eventStartMeridian = eventStartMeridian;
    }

    public String getEventEndMeridian() {
        return eventEndMeridian;
    }

    public void setEventEndMeridian(String eventEndMeridian) {
        this.eventEndMeridian = eventEndMeridian;
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

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public List<String> getEventAttendingMemberNames() {
        return eventAttendingMemberNames;
    }

    public void setEventAttendingMemberNames(List<String> eventAttendingMemberNames) {
        this.eventAttendingMemberNames = eventAttendingMemberNames;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String familyId;
        private String eventOwnerName;
        private String description;
        private String eventType;
        private String eventDate;
        private String eventStartMeridian;
        private String eventEndMeridian;
        private String eventStartTime;
        private String eventEndTime;
        private List<String> eventAttendingMemberNames;

        public Builder withFamilyId(String familyId) {
            this.familyId = familyId;
            return this;
        }

        public Builder withEventOwnerName(String eventOwnerName) {
            this.eventOwnerName = eventOwnerName;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
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

        public Builder withEventStartMeridian(String eventStartMeridian) {
            this.eventStartMeridian = eventStartMeridian;
            return this;
        }

        public Builder withEventEndMeridian(String eventEndMeridian) {
            this.eventEndMeridian = eventEndMeridian;
            return this;
        }

        public Builder withEventAttendingMemberNames(List<String> eventAttendingMemberNames) {
            this.eventAttendingMemberNames = eventAttendingMemberNames;
            return this;
        }

        public CreateEventRequest build() {
            return new CreateEventRequest(this);
        }
    }
}
