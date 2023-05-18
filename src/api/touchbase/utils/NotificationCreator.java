package api.touchbase.utils;

import api.touchbase.NotificationContent;
import api.touchbase.converters.LocalDateConverter;
import api.touchbase.dynamodb.models.Event;
import api.touchbase.models.EventModel;

import java.time.LocalDate;

public class NotificationCreator {
    private LocalDateConverter dateConverter = new LocalDateConverter();
    public NotificationCreator() {

    }

    public NotificationContent newFamilyMemberNotification(String newMemberName) {
        NotificationContent notification = new NotificationContent();
        notification.setNotificationHeadline("NEW FAMILY MEMBER!");
        notification.setNotificationDescription(String.format("%s has joined your family!", newMemberName));
        notification.setNotificationSenderName(newMemberName);
        notification.setNotificationDate(dateConverter.convert(LocalDate.now()));

        return notification;
    }

    public NotificationContent newMemberNotification() {
        NotificationContent welcomeNotification = new NotificationContent();
        welcomeNotification.setNotificationDate(dateConverter.convert(LocalDate.now()));
        welcomeNotification.setNotificationHeadline("WELCOME!");
        welcomeNotification.setNotificationDescription("Welcome to TouchBase! No matter how far from home, you'll always be able to touchbase!");
        welcomeNotification.setNotificationSenderName("TouchBase");

        return welcomeNotification;
    }

    public NotificationContent addedToEventNotification(String eventType, String eventDescription, String senderName) {
        NotificationContent inviteToEventNotification = new NotificationContent();
        inviteToEventNotification.setNotificationDate(dateConverter.convert(LocalDate.now()));
        inviteToEventNotification.setNotificationHeadline("SENDER NAME ADDED YOU TO AN EVENT");
        inviteToEventNotification.setNotificationDescription(eventDescription);
        inviteToEventNotification.setNotificationSenderName(senderName);

        return inviteToEventNotification;
    }
}
