package api.touchbase.models.results.member;

import api.touchbase.models.objects.NotificationModel;

import java.util.List;

public class GetMemberNotificationsResult {
    private List<NotificationModel> notifications;

    public GetMemberNotificationsResult(Builder builder) {
        this.notifications = builder.notifications;
    }

    public List<NotificationModel> getNotifications() {
        return this.notifications;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<NotificationModel> notifications;

        public Builder withNotifications(List<NotificationModel> notifications) {
            this.notifications = notifications;
            return this;
        }

        public GetMemberNotificationsResult build() {
            return new GetMemberNotificationsResult(this);
        }
    }
}

