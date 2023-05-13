package api.touchbase.models.results;

import api.touchbase.NotificationContent;

import java.util.List;

public class DeleteMemberNotificationResult {
    private List<NotificationContent> notifications;

    public DeleteMemberNotificationResult() {

    }

    public DeleteMemberNotificationResult(List<NotificationContent> notifications) {
        this.notifications = notifications;
    }

    public List<NotificationContent> getNotifications() {
        return this.notifications;
    }

    public void setNotifications(List<NotificationContent> notifications) {
        this.notifications = notifications;
    }

    public DeleteMemberNotificationResult(Builder builder) {
        this.notifications = builder.notifications;
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

        public DeleteMemberNotificationResult build() {
            return new DeleteMemberNotificationResult(this);
        }
    }

}

