package api.touchbase.models.results.family;

import api.touchbase.models.objects.EventModel;

import java.util.List;

public class GetEventsResult {
    private List<EventModel> familyEvents;

    public GetEventsResult() {
    }

    public GetEventsResult(List<EventModel> familyEvents) {
        this.familyEvents = familyEvents;
    }

    public GetEventsResult(Builder builder) {
        this.familyEvents = builder.familyEvents;
    }

    public List<EventModel> getFamilyEvents() {
        return familyEvents;
    }

    public void setFamilyEvents(List<EventModel> familyEvents) {
        this.familyEvents = familyEvents;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<EventModel> familyEvents;

        public Builder withFamilyEvents(List<EventModel> familyEvents) {
            this.familyEvents = familyEvents;
            return this;
        }

        public GetEventsResult build() {
            return new GetEventsResult(this);
        }
    }
}
