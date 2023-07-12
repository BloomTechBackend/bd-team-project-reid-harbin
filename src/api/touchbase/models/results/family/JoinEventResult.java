package api.touchbase.models.results.family;

import api.touchbase.models.objects.EventModel;

import java.util.List;

public class JoinEventResult {
    private List<EventModel> events;

    public JoinEventResult(){}

    public JoinEventResult(List<EventModel> events) {
        this.events = events;
    }

    public JoinEventResult(Builder builder) {
        this.events = builder.events;
    }

    public List<EventModel> getEvents() {
        return events;
    }

    public void setEvents(List<EventModel> events) {
        this.events = events;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private List<EventModel> events;

        public Builder withEventModels(List<EventModel> events) {
            this.events = events;
            return this;
        }

        public JoinEventResult build() {
            return new JoinEventResult(this);
        }
    }
}
