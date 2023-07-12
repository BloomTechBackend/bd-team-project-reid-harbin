package api.touchbase.models.results.family;

import api.touchbase.models.objects.FamilyModel;

public class CreateFamilyResult {
    private FamilyModel family;


    public CreateFamilyResult() {
    }

    public CreateFamilyResult(FamilyModel familyModel) {
        this.family = familyModel;
    }

    public CreateFamilyResult(Builder builder) {
        this.family = builder.familyModel;
    }

    public FamilyModel getFamilyModel() {
        return family;
    }

    public void setFamilyModel(FamilyModel familyModel) {
        this.family = familyModel;
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

        public CreateFamilyResult build() {
            return new CreateFamilyResult(this);
        }
    }
}
