package api.touchbase.models.results;

import api.touchbase.NotificationContent;

import java.util.List;

public class GetMemberNotificationsResult {
    private List<NotificationContent> notifications;

    public GetMemberNotificationsResult(Builder builder) {
        this.notifications = builder.notifications;
    }

    public List<NotificationContent> getNotifications() {
        return this.notifications;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<NotificationContent> notifications;

        public Builder withNotifications(List<NotificationContent> notifications) {
            this.notifications = notifications;
            return this;
        }

        public GetMemberNotificationsResult build() {
            return new GetMemberNotificationsResult(this);
        }
    }
}

