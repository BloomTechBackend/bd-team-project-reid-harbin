package api.touchbase.models.results.family;

import api.touchbase.models.objects.FamilyModel;

public class GetFamilyResult {
    private FamilyModel family;

    public GetFamilyResult() {
    }

    public GetFamilyResult(Builder builder) {
        this.family = builder.family;
    }

    public FamilyModel getFamily() {
        return family;
    }

    public void setFamily(FamilyModel family) {
        this.family = family;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private FamilyModel family;

        public Builder withFamily(FamilyModel family) {
            this.family = family;
            return this;
        }

        public GetFamilyResult build() {
            return new GetFamilyResult(this);
        }
    }
}
