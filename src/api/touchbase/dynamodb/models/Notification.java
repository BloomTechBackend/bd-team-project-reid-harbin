package api.touchbase.dynamodb.models;

public class Notification {
    private String notificationHeadline;
    private String notificationDescription;
    private String notificationSenderName;
    private String notificationDate;

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

    public String getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate;
    }
}
