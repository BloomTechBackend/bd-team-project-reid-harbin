package api.touchbase.utils;

import api.touchbase.dynamodb.models.Notification;
import api.touchbase.converters.LocalDateConverter;
import api.touchbase.dynamodb.models.Event;

import java.time.LocalDate;

public class NotificationCreator {
    private LocalDateConverter dateConverter = new LocalDateConverter();
    public NotificationCreator() {

    }

    public Notification newFamilyMemberNotification(String newMemberName) {
        Notification notification = new Notification();
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        notification.setNotificationHeadline("NEW FAMILY MEMBER!");
        notification.setNotificationDescription(String.format("%s has joined your family!", newMemberName));
        notification.setNotificationSenderName(newMemberName);
        notification.setNotificationDate(month +"/" + day + "/" + year);

        return notification;
    }

    public Notification newMemberNotification() {
        Notification welcomeNotification = new Notification();
        welcomeNotification.setNotificationDate(dateConverter.convert(LocalDate.now()));
        welcomeNotification.setNotificationHeadline("Welcome!");
        welcomeNotification.setNotificationDescription("Welcome to TouchBase! No matter how far from home, you'll" +
                                                       " always be able to touchbase!");
        welcomeNotification.setNotificationSenderName("TouchBase");

        return welcomeNotification;
    }

    public Notification addedToEventNotification(String eventType, String eventDescription, String senderName) {
        Notification inviteToEventNotification = new Notification();
        inviteToEventNotification.setNotificationDate(dateConverter.convert(LocalDate.now()));
        inviteToEventNotification.setNotificationHeadline("SENDER NAME ADDED YOU TO AN EVENT");
        inviteToEventNotification.setNotificationDescription(eventDescription);
        inviteToEventNotification.setNotificationSenderName(senderName);

        return inviteToEventNotification;
    }

    public Notification familyMemberJoinedEventNotification(Event event, String senderName) {
        LocalDate eventDate = event.getEventDate();
        int year = eventDate.getYear();
        int month = eventDate.getDayOfMonth();
        int day = eventDate.getDayOfMonth();

        Notification joinedNotification = new Notification();
        joinedNotification.setNotificationDate(dateConverter.convert(LocalDate.now()));
        joinedNotification.setNotificationHeadline(senderName + " Has Joined Your Event");
        joinedNotification.setNotificationDescription("The event is for " + event.getEventType() + " on " +
                month +"/" + day + "/" + year);
        joinedNotification.setNotificationSenderName(senderName);

        return joinedNotification;
    }
}
