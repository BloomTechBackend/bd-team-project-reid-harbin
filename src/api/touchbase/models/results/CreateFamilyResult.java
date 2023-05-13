package api.touchbase.models.results;

import api.touchbase.models.FamilyModel;
import api.touchbase.models.requests.CreateFamilyRequest;

public class CreateFamilyResult {
    private FamilyModel familyModel;

    public CreateFamilyResult() {
    }

    public CreateFamilyResult(FamilyModel familyModel) {
        this.familyModel = familyModel;
    }

    public CreateFamilyResult(Builder builder) {
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

        public CreateFamilyResult build() {
            return new CreateFamilyResult(this);
        }
    }
}
