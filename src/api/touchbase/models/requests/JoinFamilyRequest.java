package api.touchbase.models.requests;

public class JoinFamilyRequest {
    private String familyId;
    private String memberId;
    private String familyPassword;
    private String familyName;

    public JoinFamilyRequest() {

    }

    public JoinFamilyRequest(String familyId, String memberId, String familyPassword) {
        this.familyId = familyId;
        this.memberId = memberId;
        this.familyPassword = familyPassword;

    }

    public JoinFamilyRequest(Builder builder) {
        this.familyId = builder.familyId;
        this.memberId = builder.memberId;
        this.familyPassword = builder.familyPassword;
        this.familyName = builder.familyName;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getFamilyPassword() {
        return familyPassword;
    }

    public void setFamilyPassword(String familyPassword) {
        this.familyPassword = familyPassword;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private String familyId;
        private String memberId;
        private String familyPassword;
        private String familyName;

        public Builder withFamilyId(String familyId) {
            this.familyId = familyId;
            return this;
        }

        public Builder withMemberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder withFamilyPassword(String familyPassword) {
            this.familyPassword = familyPassword;
            return this;
        }

        public Builder withFamilyName(String familyName) {
            this.familyName = familyName;
            return this;
        }

        public JoinFamilyRequest build() {
            return new JoinFamilyRequest(this);
        }
    }
}
