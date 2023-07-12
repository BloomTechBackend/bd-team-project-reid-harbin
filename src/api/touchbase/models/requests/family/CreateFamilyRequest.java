package api.touchbase.models.requests.family;

public class CreateFamilyRequest {
    private String familyCreatorId;
    private String familyName;
    private String familyPassword;

    public CreateFamilyRequest() {

    }

    public CreateFamilyRequest(String familyCreatorId, String familyName, String familyPassword) {
        this.familyCreatorId = familyCreatorId;
        this.familyName = familyName;
        this.familyPassword = familyPassword;
    }

    public CreateFamilyRequest(Builder builder) {
        this.familyCreatorId = builder.familyCreatorId;
        this.familyName = builder.familyName;
        this.familyPassword = builder.familyPassword;
    }

    public Builder builder() {
        return new Builder();
    }

    public String getFamilyCreatorId() {
        return familyCreatorId;
    }

    public void setFamilyCreatorId(String familyCreatorId) {
        this.familyCreatorId = familyCreatorId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyPassword() {
        return familyPassword;
    }

    public void setFamilyPassword(String familyPassword) {
        this.familyPassword = familyPassword;
    }

    public static final class Builder {
        private String familyCreatorId;
        private String familyName;
        private String familyPassword;

        public Builder withFamilyCreatorId(String familyCreatorId) {
            this.familyCreatorId = familyCreatorId;
            return this;
        }
        public Builder withFamilyName(String familyName) {
            this.familyName = familyName;
            return this;
        }
        public Builder withFamilyPassword(String familyPassword) {
            this.familyPassword = familyPassword;
            return this;
        }

        public CreateFamilyRequest build() {
            return new CreateFamilyRequest(this);
        }
    }
}
