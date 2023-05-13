package api.touchbase.converters;

import api.touchbase.NotificationContent;
import api.touchbase.dynamodb.models.Event;
import api.touchbase.dynamodb.models.Family;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.InvalidInputException;
import api.touchbase.models.EventModel;
import api.touchbase.models.FamilyModel;
import api.touchbase.models.MemberModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ModelConverter {
    private LocalDateConverter dateConverter = new LocalDateConverter();
    public ModelConverter() {

    }

    public MemberModel toMemberModel(Member member) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
        String memberModelBirthday = member.getMemberBirthday().format(formatter);
        //LocalDate memberBirthday = member.getMemberBirthday();
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

        return null;
    }
}
