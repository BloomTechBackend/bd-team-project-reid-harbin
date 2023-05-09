package api.touchbase.models;

import java.util.List;

public class FamilyModel {
    private String familyId;
    private String familyName;
    private String familyPassword;
    private List<String> familyEventDescriptions;

    public FamilyModel() {

    }

    public FamilyModel(Builder builder) {
        this.familyId = builder.familyId;
        this.familyName = builder.familyName;
        this.familyPassword = builder.familyPassword;
        this.familyEventDescriptions = builder.familyEventDescriptions;
    }

    @Override
    public String toString() {
        return "FamilyModel{" +
                "familyId='" + familyId + '\'' +
                ", familyName='" + familyName + '\'' +
                ", familyPassword='" + familyPassword + '\'' +
                ", familyEventDescriptions=" + familyEventDescriptions +
                '}';
    }

    public static final class Builder {
        private String familyId;
        private String familyName;
        private String familyPassword;
        private List<String> familyEventDescriptions;

        public static Builder builder() {
            return new Builder();
        }
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
        public Builder withFamilyEventDescriptions(String family) {
            this.familyEventDescriptions = familyEventDescriptions;
            return this;
        }

    }
}
