package api.touchbase.models.requests.family;

public class JoinEventRequest {
    private String memberId;
    private String familyId;
    private  String eventId;

    public JoinEventRequest() {
    }

    public JoinEventRequest(String memberId, String familyId, String eventId) {
        this.memberId = memberId;
        this.familyId = familyId;
        this.eventId = eventId;
    }

    public JoinEventRequest(Builder builder) {
        this.memberId = builder.memberId;
        this.familyId = builder.familyId;
        this.eventId = builder.eventId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String memberId;
        private String familyId;
        private  String eventId;

        public Builder withMemberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder withFamilyId(String familyId) {
            this.familyId = familyId;
            return this;
        }

        public Builder withEventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public JoinEventRequest build() {
            return new JoinEventRequest(this);
        }
    }
}
