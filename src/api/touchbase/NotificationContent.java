package api.touchbase;

import java.time.LocalDateTime;

public class NotificationContent {
    private String notificationHeadline;
    private String notificationDescription;
    private String notificationSenderName;
    private LocalDateTime notificationDate;

    public String getNotificationHeadline() {
        return notificationHeadline;
    }

    public void setNotificationHeadline(String notificationHeadline) {
        this.notificationHeadline = notificationHeadline;
    }

    public String getNotificationDescription() {
        return notificationDescription;
    }

    public void setNotificationDescription(String notificationDescription) {
        this.notificationDescription = notificationDescription;
    }

    public String getNotificationSenderName() {
        return notificationSenderName;
    }

    public void setNotificationSenderName(String notificationSenderName) {
        this.notificationSenderName = notificationSenderName;
    }

    public LocalDateTime getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(LocalDateTime notificationDate) {
        this.notificationDate = notificationDate;
    }
}
