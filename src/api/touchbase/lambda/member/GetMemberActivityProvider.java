package api.touchbase.lambda.member;

import api.touchbase.dependency.DaggerServiceComponent;
import api.touchbase.dependency.ServiceComponent;
import api.touchbase.models.requests.member.GetMemberRequest;
import api.touchbase.models.results.member.GetMemberResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetMemberActivityProvider implements RequestHandler<GetMemberRequest, GetMemberResult> {
    public GetMemberActivityProvider() {

    }

    @Override
    public GetMemberResult handleRequest(final GetMemberRequest getMemberRequest, Context context) {
        return getDaggerServiceComponent()
                .provideGetMemberDetailsActivity()
                .handleRequest(getMemberRequest, context);
    }

    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }

}
