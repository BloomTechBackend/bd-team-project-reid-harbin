package api.touchbase.lambda.family;

import api.touchbase.dependency.DaggerServiceComponent;
import api.touchbase.dependency.ServiceComponent;
import api.touchbase.models.requests.family.JoinEventRequest;
import api.touchbase.models.results.family.JoinEventResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class JoinEventActivityProvider implements RequestHandler<JoinEventRequest, JoinEventResult> {


    @Override
    public JoinEventResult handleRequest(final JoinEventRequest joinEventRequest, Context context) {
        return getDaggerServiceComponent().provideJoinEventActivity().handleRequest(joinEventRequest, context);
    }

    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}
