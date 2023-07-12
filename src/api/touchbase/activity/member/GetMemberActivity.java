package api.touchbase.activity.member;

import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.models.objects.MemberModel;
import api.touchbase.models.requests.member.GetMemberRequest;
import api.touchbase.models.results.member.GetMemberResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;

public class GetMemberActivity implements RequestHandler<GetMemberRequest, GetMemberResult> {
    private final MemberDao memberDao;

    @Inject
    public GetMemberActivity(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public GetMemberResult handleRequest(final GetMemberRequest getMemberRequest, Context context) {
        Member member = memberDao.getMember(getMemberRequest.getMemberId());

        return GetMemberResult.builder()
                .withMember(ModelConverter.toMemberModel(member))
                .build();
    }
}
