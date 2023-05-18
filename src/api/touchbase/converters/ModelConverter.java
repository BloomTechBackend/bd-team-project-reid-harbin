package api.touchbase.converters;

import api.touchbase.NotificationContent;
import api.touchbase.dynamodb.models.Event;
import api.touchbase.dynamodb.models.Family;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.InvalidInputException;
import api.touchbase.models.EventModel;
import api.touchbase.models.FamilyModel;
import api.touchbase.models.MemberModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ModelConverter {
    private final Logger log = LogManager.getLogger();
    private LocalDateConverter dateConverter = new LocalDateConverter();
    private LocalTimeConverter timeConverter = new LocalTimeConverter();
    public ModelConverter() {

    }

    public MemberModel toMemberModel(Member member) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
        String memberModelBirthday = member.getMemberBirthday().format(formatter);
        List<NotificationContent> notificationContents = new ArrayList<>();

        if (member.getMemberNotifications() != null) {
            for (NotificationContent c : member.getMemberNotifications()) {
                NotificationContent modelNotification = new NotificationContent();

                modelNotification.setNotificationHeadline(c.getNotificationHeadline());
                modelNotification.setNotificationSenderName(c.getNotificationSenderName());
                modelNotification.setNotificationDescription(c.getNotificationDescription());
                modelNotification.setNotificationDate(c.getNotificationDate());

                notificationContents.add(modelNotification);
            }
        }

        return MemberModel.builder()
                .withMemberId(member.getMemberId())
                .withMemberName(member.getMemberName())
                .withMemberPassword(member.getMemberPassword())
                .withHasFamily(member.getMemberHasFamily())
                .withMemberBirthday(memberModelBirthday)
                .withNotifications(notificationContents)
                .build();
    }

    public FamilyModel toFamilyModel(Family family) {
        String familyModelId = family.getFamilyId();
        String familyModelName = family.getFamilyName();
        String familyModelPassword = family.getFamilyPassword();
        List<String> familyModelMemberIds = new ArrayList<>();
        for (String id : family.getFamilyMemberIds()) {
            familyModelMemberIds.add(id);
        }

        return FamilyModel.builder()
                .withFamilyId(familyModelId)
                .withFamilyName(familyModelName)
                .withFamilyPassword(familyModelPassword)
                .withFamilyMemberIds(familyModelMemberIds)
                .build();
    }

    public EventModel toEventModel(Event event) {
        log.info(event.toString());
        if (event == null) {
            throw new InvalidInputException("Cannot return a null event");
        }
        String eventType = event.getEventType();
        String eventId = event.getEventId();
        String eventOwnerId = event.getEventOwnerId();
        String eventDescription = event.getDescription();

        List<String> eventMemberIds = new ArrayList<>();

        for (String memberId : event.getEventAttendingMemberIds()) {
            eventMemberIds.add(memberId);
        }

        String eventTimeRange =
                timeConverter.convert(event.getEventStartTime())
                .concat(" to ")
                .concat(timeConverter.convert(event.getEventEndTime()));

        String eventDate = dateConverter.convert(event.getEventDate());

        return EventModel.builder()
                .withEventType(eventType)
                .withEventId(eventId)
                .withOwnerId(eventOwnerId)
                .withEventDescription(eventDescription)
                .withEventDate(eventDate)
                .withEventTimeRange(eventTimeRange)
                .withEventFamilyMemberIds(eventMemberIds)
                .build();
    }
}
