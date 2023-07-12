package api.touchbase.models.results.family;

import api.touchbase.models.objects.FamilyModel;

public class JoinFamilyResult {
    private FamilyModel familyModel;

    public JoinFamilyResult() {
    }

    public JoinFamilyResult(FamilyModel familyModel) {
        this.familyModel = familyModel;
    }

    public JoinFamilyResult(Builder builder) {
        this.familyModel = builder.familyModel;
    }

    public FamilyModel getFamilyModel() {
        return familyModel;
    }

    public void setFamilyModel(FamilyModel familyModel) {
        this.familyModel = familyModel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        FamilyModel familyModel;

        public Builder withFamilyModel(FamilyModel familyModel) {
            this.familyModel = familyModel;
            return this;
        }

        public JoinFamilyResult build() {
            return new JoinFamilyResult(this);
        }
    }
}
