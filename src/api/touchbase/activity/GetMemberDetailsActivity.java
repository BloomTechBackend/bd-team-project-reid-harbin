package api.touchbase.activity;

import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.models.MemberModel;
import api.touchbase.models.requests.GetMemberDetailsRequest;
import api.touchbase.models.results.GetMemberDetailsResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;

public class GetMemberDetailsActivity implements RequestHandler<GetMemberDetailsRequest, GetMemberDetailsResult> {
    private final MemberDao memberDao;

    @Inject
    public GetMemberDetailsActivity(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public GetMemberDetailsResult handleRequest(final GetMemberDetailsRequest getMemberDetailsRequest, Context context) {
        ModelConverter converter = new ModelConverter();

        String memberId = getMemberDetailsRequest.getMemberId();
        Member member = memberDao.getMember(memberId);

        MemberModel memberModel = converter.toMemberModel(member);

        return GetMemberDetailsResult.builder()
                .withMember(memberModel)
                .build();
    }
}
