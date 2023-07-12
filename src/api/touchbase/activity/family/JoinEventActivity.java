package api.touchbase.activity.family;

import api.touchbase.dynamodb.models.Notification;
import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.FamilyDao;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Event;
import api.touchbase.dynamodb.models.Family;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.EventNotFoundException;
import api.touchbase.exceptions.InvalidInputException;
import api.touchbase.exceptions.MemberNotFoundException;
import api.touchbase.models.objects.EventModel;
import api.touchbase.models.requests.family.JoinEventRequest;
import api.touchbase.models.results.family.JoinEventResult;
import api.touchbase.utils.NotificationCreator;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JoinEventActivity implements RequestHandler<JoinEventRequest, JoinEventResult> {
    private final FamilyDao familyDao;
    private final MemberDao memberDao;

    @Inject
    public JoinEventActivity(FamilyDao familyDao, MemberDao memberDao) {
        this.memberDao = memberDao;
        this.familyDao = familyDao;
    }


    @Override
    public JoinEventResult handleRequest(final JoinEventRequest joinEventRequest, Context context) {
        String requestMemberId = joinEventRequest.getMemberId();
        String requestFamilyId = joinEventRequest.getFamilyId();
        String requestEventId = joinEventRequest.getEventId();

        Family family = familyDao.getFamily(requestFamilyId);
        Member member = memberDao.getMember(requestMemberId);

        List<Event> familyEvents = family.getFamilyEvents();
        Set<String> familyMemberNames = family.getFamilyMemberNamesToMemberIds().keySet();

        if (!familyMemberNames.contains(member.getMemberName())) {
            throw new MemberNotFoundException(String.format("The member provided is not part of the provided family"));
        }

        Event eventToJoin = null;
        for (Event e : familyEvents) {
            if (e.getEventId().equals(requestEventId)) {
                eventToJoin = e;
            }
        }
        if (eventToJoin == null) {
            throw new EventNotFoundException(String.format("There is no event with the Id {%s}", requestEventId));
        }

        if (eventToJoin.getEventAttendingMemberNames().contains(member.getMemberName())) {
            throw new InvalidInputException("Cannot join an event that you have already joined");
        }


        Set<String> attendingMemberNames = eventToJoin.getEventAttendingMemberNames();


        NotificationCreator notificationCreator = new NotificationCreator();



        for (String name : attendingMemberNames) {
            String familyMemberId = family.getFamilyMemberNamesToMemberIds().get(name);
            Member memberToNotify = memberDao.getMember(familyMemberId);
            List<Notification> memberToNotifyNotifications = memberToNotify.getMemberNotifications();
            memberToNotifyNotifications.add(0, notificationCreator.familyMemberJoinedEventNotification(
                    eventToJoin, member.getMemberName()));

            memberToNotify.setMemberNotifications(memberToNotifyNotifications);
            memberDao.saveMember(memberToNotify);
        }

        attendingMemberNames.add(member.getMemberName());
        eventToJoin.setEventAttendingMemberNames(attendingMemberNames);

        List<EventModel> eventModels = new ArrayList<>();
        family.getFamilyEvents().forEach(event -> eventModels.add(ModelConverter.toEventModel(event)));

        familyDao.save(family);

        return JoinEventResult.builder()
                .withEventModels(eventModels)
                .build();
    }
}
