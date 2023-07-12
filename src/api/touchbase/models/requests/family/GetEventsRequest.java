package api.touchbase.models.requests.family;

public class GetEventsRequest {
    private String familyId;
    private String familyMemberId;

    public GetEventsRequest() {
    }

    public GetEventsRequest(String familyId) {
        this.familyId = familyId;
    }

    public GetEventsRequest(String familyId, String familyMemberId) {
        this.familyId = familyId;
        this.familyMemberId = familyMemberId;
    }

    public String getFamilyMemberId() {
        return familyMemberId;
    }

    public void setFamilyMemberId(String familyMemberId) {
        this.familyMemberId = familyMemberId;
    }

    public GetEventsRequest(Builder builder) {
        this.familyMemberId = builder.familyMemberId;
        this.familyId = builder.familyId;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String familyId;
        private String familyMemberId;

        public Builder withFamilyId(String familyId) {
            this.familyId = familyId;
            return this;
        }

        public Builder withFamilyMemberId(String familyMemberId) {
            this.familyMemberId = familyMemberId;
            return this;
        }

        public GetEventsRequest build() {
            return new GetEventsRequest(this);
        }
    }
}
