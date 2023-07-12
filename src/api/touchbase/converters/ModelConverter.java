package api.touchbase.converters;

import api.touchbase.dynamodb.models.Notification;
import api.touchbase.dynamodb.models.Event;
import api.touchbase.dynamodb.models.Family;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.models.objects.EventModel;
import api.touchbase.models.objects.FamilyModel;
import api.touchbase.models.objects.MemberModel;
import api.touchbase.models.objects.NotificationModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModelConverter {
    private final Logger log = LogManager.getLogger();
    public ModelConverter() {

    }

    public static MemberModel toMemberModel(Member member) {
        List<Notification> notifications = new ArrayList<>();

        if (member.getMemberNotifications() != null) {
            for (Notification c : member.getMemberNotifications()) {
                Notification modelNotification = new Notification();

                modelNotification.setNotificationHeadline(c.getNotificationHeadline());
                modelNotification.setNotificationSenderName(c.getNotificationSenderName());
                modelNotification.setNotificationDescription(c.getNotificationDescription());
                modelNotification.setNotificationDate(c.getNotificationDate());

                notifications.add(modelNotification);
            }
        }

        return MemberModel.builder()
                .withMemberId(member.getMemberId())
                .withMemberName(member.getMemberName())
                .withNotifications(notifications)
                .withFamilyId(member.getMemberFamilyId())
                .build();
    }

    public static FamilyModel toFamilyModel(Family family) {
        String familyModelId = family.getFamilyId();
        String familyModelName = family.getFamilyName();
        String familyModelPassword = family.getFamilyPassword();
        List<String> familyModelMemberNames = new ArrayList<>();
        List<Event> familyModelEvents = new ArrayList<>();
        for (String name : family.getFamilyMemberNamesToMemberIds().keySet()) {
            familyModelMemberNames.add(name);
        }

        for (Event event : family.getFamilyEvents()) {
            familyModelEvents.add(event);
        }

        return FamilyModel.builder()
                .withFamilyId(familyModelId)
                .withFamilyName(familyModelName)
                .withFamilyPassword(familyModelPassword)
                .withFamilyMemberNames(familyModelMemberNames)
                .withFamilyEvents(familyModelEvents)
                .build();
    }

    public static NotificationModel toNotificationModel(Notification notification) {
        String notificationHeadline = notification.getNotificationHeadline();
        String notificationDescription = notification.getNotificationDescription();
        String notificationSenderName = notification.getNotificationSenderName();
        String notificationDate = notification.getNotificationDate();

        NotificationModel model = new NotificationModel();
        model.setNotificationHeadline(notificationHeadline);
        model.setNotificationDescription(notificationDescription);
        model.setNotificationSenderName(notificationSenderName);
        model.setNotificationDate(notificationDate);

        return model;
    }

    public static EventModel toEventModel(Event event) {
        LocalDate eventDate = event.getEventDate();
        LocalTime eventStartTime = event.getEventStartTime();
        LocalTime eventEndTime = event.getEventEndTime();

        String startMins = eventStartTime.getMinute() < 10 ? ("0" + eventStartTime.getMinute()) :
                                                              Integer.toString(eventStartTime.getMinute());
        String endMins = eventEndTime.getMinute() < 10 ? ("0" + eventEndTime.getMinute()) :
                                                          Integer.toString(eventEndTime.getMinute());

        String eventDateString = eventDate.getMonthValue() + "/" +
                                 eventDate.getDayOfMonth() + "/" +
                                 eventDate.getYear();

        String eventStartTimeString = eventStartTime.getHour() + ":" + startMins + " " +
                event.getEventStartMeridian();

        String eventEndTimeString = eventEndTime.getHour() + ":" + endMins + " " +
               event.getEventEndMeridian();


        String eventId = event.getEventId();
        String eventOwnerId = event.getEventOwnerId();
        String eventDescription = event.getEventDescription();
        String eventType = event.getEventType();
        Set<String> eventAttendingMemberIds = new HashSet<>();

        for (String id : event.getEventAttendingMemberNames()) {
            eventAttendingMemberIds.add(id);
        }

        return EventModel.builder()
                .withEventId(eventId)
                .withOwnerId(eventOwnerId)
                .withEventDate(eventDateString)
                .withEventDescription(eventDescription)
                .withEventType(eventType)
                .withEventStartTime(eventStartTimeString)
                .withEventEndTime(eventEndTimeString)
                .withEventAttendingMemberNames(eventAttendingMemberIds)
                .build();
    }


}
