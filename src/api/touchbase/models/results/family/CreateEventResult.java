package api.touchbase.models.results.family;

import api.touchbase.models.objects.FamilyModel;

public class CreateEventResult {
    private FamilyModel family;

    public CreateEventResult() {

    }

    public CreateEventResult(FamilyModel family) {
        this.family = family;
    }

    public CreateEventResult(Builder builder) {
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

        public Builder withFamilyModel(FamilyModel family) {
            this.family = family;
            return this;
        }

        public CreateEventResult build() {
            return new CreateEventResult(this);
        }
    }
}
