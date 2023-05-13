package api.touchbase.activity;

import api.touchbase.NotificationContent;
import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.models.MemberModel;
import api.touchbase.models.requests.GetMemberNotificationsRequest;
import api.touchbase.models.results.GetMemberNotificationsResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetMemberNotificationsActivity implements RequestHandler<GetMemberNotificationsRequest, GetMemberNotificationsResult> {
    private final MemberDao memberDao;
    private final Logger log = LogManager.getLogger();

    @Inject
    public GetMemberNotificationsActivity(MemberDao memberDao) {
        this.memberDao = memberDao;
    }


    @Override
    public GetMemberNotificationsResult handleRequest(final GetMemberNotificationsRequest getMemberNotificationsRequest, Context context) {
        log.info("Received get notification request with id: " + getMemberNotificationsRequest.getMemberId());
        ModelConverter converter = new ModelConverter();

        String requestMemberId = getMemberNotificationsRequest.getMemberId();
        Member member = memberDao.getMember(requestMemberId);

        MemberModel model = converter.toMemberModel(member);

        return GetMemberNotificationsResult.builder()
                .withNotifications(model.getNotifications())
                .build();
    }
}
