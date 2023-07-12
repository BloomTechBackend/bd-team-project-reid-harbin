package api.touchbase.models.objects;

import api.touchbase.dynamodb.models.Event;

import java.util.List;

public class FamilyModel {
    private String familyId;
    private String familyName;
    private String familyPassword;
    private List<String> familyMemberNames;
    private List<Event> familyEvents;

    public FamilyModel(String familyId, String familyName, String familyPassword,
                       List<String> familyMemberIds, List<Event> familyEvents) {
        this.familyId = familyId;
        this.familyName = familyName;
        this.familyPassword = familyPassword;
        this.familyMemberNames = familyMemberIds;
        this.familyEvents = familyEvents;
    }

    public FamilyModel() {

    }

    public FamilyModel(Builder builder) {
        this.familyId = builder.familyId;
        this.familyName = builder.familyName;
        this.familyPassword = builder.familyPassword;
        this.familyMemberNames = builder.familyMemberNames;
        this.familyEvents = builder.familyEvents;
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

    public List<String> getFamilyMemberNames() {
        return familyMemberNames;
    }

    public void setFamilyMemberNames(List<String> familyMemberIds) {
        this.familyMemberNames = familyMemberIds;
    }

    public List<Event> getFamilyEvents() {
        return familyEvents;
    }

    public void setFamilyEvents(List<Event> familyEvents) {
        this.familyEvents = familyEvents;
    }

    @Override
    public String toString() {
        return "FamilyModel{" +
                "familyId='" + familyId + '\'' +
                ", familyName='" + familyName + '\'' +
                ", familyPassword='" + familyPassword + '\'' +
                ", familyEventDescriptions=" + familyMemberNames +
                '}';
    }
    public static Builder builder() {
            return new Builder();
        }

    public static final class Builder {
        private String familyId;
        private String familyName;
        private String familyPassword;
        private List<String> familyMemberNames;
        private List<Event> familyEvents;

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
        public Builder withFamilyMemberNames(List<String> familyMemberNames) {
            this.familyMemberNames = familyMemberNames;
            return this;
        }
        public Builder withFamilyEvents(List<Event> familyEvents) {
            this.familyEvents = familyEvents;
            return this;
        }


        public FamilyModel build() {
            return new FamilyModel(this);
        }
    }
}
