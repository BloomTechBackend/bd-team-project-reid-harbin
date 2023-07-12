package api.touchbase.activity.member;

import api.touchbase.dynamodb.models.Notification;
import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.InvalidInputException;
import api.touchbase.models.objects.NotificationModel;
import api.touchbase.models.requests.member.DeleteMemberNotificationRequest;
import api.touchbase.models.results.member.DeleteMemberNotificationResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class DeleteMemberNotificationActivity implements RequestHandler<DeleteMemberNotificationRequest, DeleteMemberNotificationResult> {
    public final MemberDao memberDao;

    @Inject
    public DeleteMemberNotificationActivity(MemberDao memberDao) {
        this.memberDao = memberDao;
    }


    @Override
    public DeleteMemberNotificationResult handleRequest(final DeleteMemberNotificationRequest deleteMemberNotificationRequest, Context context) {

        Member member = memberDao.getMember(deleteMemberNotificationRequest.getMemberId());
        int indexToRemove = deleteMemberNotificationRequest.getMemberNotificationIndex();
        List<Notification> memberNotifications = member.getMemberNotifications();

        if (indexToRemove >= memberNotifications.size() || indexToRemove < 0) {
            throw new InvalidInputException("Member notification index is out of the notifications bounds");
        }

        memberNotifications.remove(indexToRemove);
        member.setMemberNotifications(memberNotifications);
        memberDao.saveMember(member);

        List<Notification> notifications = member.getMemberNotifications();
        List<NotificationModel> notificationModels = new ArrayList<>();

        for (Notification n : notifications) {
            notificationModels.add(ModelConverter.toNotificationModel(n));
        }

        return DeleteMemberNotificationResult.builder()
                .withNotifications(notificationModels)
                .build();
    }
}
