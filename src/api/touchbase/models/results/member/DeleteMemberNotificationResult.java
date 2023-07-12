package api.touchbase.models.results.member;

import api.touchbase.models.objects.NotificationModel;

import java.util.List;

public class DeleteMemberNotificationResult {
    private List<NotificationModel> notifications;

    public DeleteMemberNotificationResult() {

    }

    public DeleteMemberNotificationResult(List<NotificationModel> notifications) {
        this.notifications = notifications;
    }

    public List<NotificationModel> getNotifications() {
        return this.notifications;
    }

    public void setNotifications(List<NotificationModel> notifications) {
        this.notifications = notifications;
    }

    public DeleteMemberNotificationResult(Builder builder) {
        this.notifications = builder.notifications;
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

        public DeleteMemberNotificationResult build() {
            return new DeleteMemberNotificationResult(this);
        }
    }

}

