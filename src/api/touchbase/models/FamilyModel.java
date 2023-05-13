package api.touchbase.models;

import java.util.List;

public class FamilyModel {
    private String familyId;
    private String familyName;
    private String familyPassword;
    private List<String> familyMemberIds;

    public FamilyModel(String familyId, String familyName, String familyPassword, List<String> familyMemberIds) {
        this.familyId = familyId;
        this.familyName = familyName;
        this.familyPassword = familyPassword;
        this.familyMemberIds = familyMemberIds;
    }

    public FamilyModel() {

    }

    public FamilyModel(Builder builder) {
        this.familyId = builder.familyId;
        this.familyName = builder.familyName;
        this.familyPassword = builder.familyPassword;
        this.familyMemberIds = builder.familyMemberIds;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
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

    public List<String> getFamilyMemberIds() {
        return familyMemberIds;
    }

    public void setFamilyMemberIds(List<String> familyMemberIds) {
        this.familyMemberIds = familyMemberIds;
    }

    @Override
    public String toString() {
        return "FamilyModel{" +
                "familyId='" + familyId + '\'' +
                ", familyName='" + familyName + '\'' +
                ", familyPassword='" + familyPassword + '\'' +
                ", familyEventDescriptions=" + familyMemberIds +
                '}';
    }
    public static Builder builder() {
            return new Builder();
        }

    public static final class Builder {
        private String familyId;
        private String familyName;
        private String familyPassword;
        private List<String> familyMemberIds;

        public Builder withFamilyId(String familyId) {
            this.familyId = familyId;
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
        public Builder withFamilyMemberIds(List<String> familyMemberIds) {
            this.familyMemberIds = familyMemberIds;
            return this;
        }

        public FamilyModel build() {
            return new FamilyModel(this);
        }
    }
}
