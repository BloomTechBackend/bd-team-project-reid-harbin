package api.touchbase.lambda;

import api.touchbase.dependency.DaggerServiceComponent;
import api.touchbase.dependency.ServiceComponent;
import api.touchbase.models.requests.JoinFamilyRequest;
import api.touchbase.models.results.JoinFamilyResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class JoinFamilyActivityProvider implements RequestHandler<JoinFamilyRequest, JoinFamilyResult> {

    @Override
    public JoinFamilyResult handleRequest(final JoinFamilyRequest joinFamilyRequest, Context context) {
        return getDaggerServiceComponent()
                .provideJoinFamilyActivity()
                .handleRequest(joinFamilyRequest, context);
    }

    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}
