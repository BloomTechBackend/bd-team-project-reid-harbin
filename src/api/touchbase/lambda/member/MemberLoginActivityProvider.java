package api.touchbase.lambda.member;

import api.touchbase.dependency.DaggerServiceComponent;
import api.touchbase.dependency.ServiceComponent;
import api.touchbase.models.requests.member.MemberLoginRequest;
import api.touchbase.models.results.member.MemberLoginResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MemberLoginActivityProvider implements RequestHandler<MemberLoginRequest, MemberLoginResult> {
    @Override
    public MemberLoginResult handleRequest(final MemberLoginRequest memberLoginRequest, Context context) {
        return getDaggerServiceComponent().provideMemberLoginActivity().handleRequest(memberLoginRequest, context);
    }

    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}
