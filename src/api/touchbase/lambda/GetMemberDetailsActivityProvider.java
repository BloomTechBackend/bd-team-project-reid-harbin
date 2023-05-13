package api.touchbase.lambda;

import api.touchbase.dependency.DaggerServiceComponent;
import api.touchbase.dependency.ServiceComponent;
import api.touchbase.models.requests.GetMemberDetailsRequest;
import api.touchbase.models.results.GetMemberDetailsResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetMemberDetailsActivityProvider implements RequestHandler<GetMemberDetailsRequest, GetMemberDetailsResult> {
    public GetMemberDetailsActivityProvider() {

    }

    @Override
    public GetMemberDetailsResult handleRequest(final GetMemberDetailsRequest getMemberDetailsRequest, Context context) {
        return getDaggerServiceComponent()
                .provideGetMemberDetailsActivity()
                .handleRequest(getMemberDetailsRequest, context);
    }

    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }

}
