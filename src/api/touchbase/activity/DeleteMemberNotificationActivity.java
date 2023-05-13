package api.touchbase.activity;

import api.touchbase.NotificationContent;
import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.InvalidInputException;
import api.touchbase.models.MemberModel;
import api.touchbase.models.requests.DeleteMemberNotificationRequest;
import api.touchbase.models.results.DeleteMemberNotificationResult;
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
        ModelConverter converter = new ModelConverter();

        Member member = memberDao.getMember(deleteMemberNotificationRequest.getMemberId());
        int indexToRemove = deleteMemberNotificationRequest.getMemberNotificationIndex();
        List<NotificationContent> memberNotifications = member.getMemberNotifications();
        List<NotificationContent> memberUpdatedNotifications = new ArrayList<>();

        if (indexToRemove >= memberNotifications.size() || indexToRemove < 0) {
            throw new InvalidInputException("Member notification index is out of the notifications bounds");
        }

        memberNotifications.remove(indexToRemove);
        member.setMemberNotifications(memberNotifications);
        memberDao.saveMember(member);

        MemberModel model = converter.toMemberModel(member);

        return DeleteMemberNotificationResult.builder()
                .withNotifications(model.getNotifications())
                .build();

    }
}
