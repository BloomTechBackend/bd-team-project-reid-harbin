package api.touchbase.models.requests.family;

public class GetFamilyRequest {
    private String familyId;

    public GetFamilyRequest() {
    }

    public GetFamilyRequest(String familyId) {
        this.familyId = familyId;
    }

    public GetFamilyRequest(Builder builder) {
        this.familyId = builder.familyId;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "GetFamilyRequest{" +
                "familyId='" + familyId + '\'' +
                '}';
    }

    public static final class Builder {
        private String familyId;

        private Builder() {

        }

        public Builder withFamilyId(String familyId) {
            this.familyId = familyId;
            return this;
        }

        public GetFamilyRequest build() {
            return new GetFamilyRequest(this);
        }
    }
}
