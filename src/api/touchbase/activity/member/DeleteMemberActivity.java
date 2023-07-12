package api.touchbase.activity.member;

import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.InvalidInputException;
import api.touchbase.exceptions.InvalidPasswordException;
import api.touchbase.models.requests.member.DeleteMemberRequest;
import api.touchbase.models.results.member.DeleteMemberResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;

public class DeleteMemberActivity implements RequestHandler<DeleteMemberRequest, DeleteMemberResult> {
    private final MemberDao memberDao;

    @Inject
    public DeleteMemberActivity(MemberDao memberDao) {
        this.memberDao = memberDao;
    }


    @Override
    public DeleteMemberResult handleRequest(final DeleteMemberRequest deleteMemberRequest, Context context) {
        String requestId = deleteMemberRequest.getMemberId();
        String requestPassword = deleteMemberRequest.getMemberPassword();
        String requestName = deleteMemberRequest.getMemberName();

        Member member = memberDao.getMember(requestId);

        if (!requestPassword.equals(member.getMemberPassword())) {
            throw new InvalidPasswordException(
                    "CANNOT DELETE ACCOUNT! " +
                            "The PASSWORD provided does not match the PASSWORD associated with this account.");
        }

        if (!requestName.equals(member.getMemberName())) {
            throw new InvalidInputException(
                    "CANNOT DELETE ACCOUNT! " +
                            "The NAME provided does not match the NAME associated with this account.");
        }

        memberDao.deleteMember(member);


        return DeleteMemberResult.builder()
                .withResponseMessage("You have successfully deleted you account.")
                .build();
    }
}
