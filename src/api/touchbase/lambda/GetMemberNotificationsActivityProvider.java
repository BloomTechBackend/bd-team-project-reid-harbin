package api.touchbase.lambda;

import api.touchbase.dependency.DaggerServiceComponent;
import api.touchbase.dependency.ServiceComponent;
import api.touchbase.models.requests.GetMemberNotificationsRequest;
import api.touchbase.models.results.GetMemberNotificationsResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetMemberNotificationsActivityProvider implements RequestHandler<GetMemberNotificationsRequest, GetMemberNotificationsResult> {
    public GetMemberNotificationsActivityProvider() {

    }

    @Override
    public GetMemberNotificationsResult handleRequest(final GetMemberNotificationsRequest getMemberNotificationsRequest, Context context) {
        return getDaggerServiceComponent()
                .provideGetMemberNotificationsActivity()
                .handleRequest(getMemberNotificationsRequest, context);
    }

    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}
