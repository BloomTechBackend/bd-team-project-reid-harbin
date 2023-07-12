package api.touchbase.lambda.family;

import api.touchbase.dependency.DaggerServiceComponent;
import api.touchbase.dependency.ServiceComponent;
import api.touchbase.models.requests.family.GetEventsRequest;
import api.touchbase.models.results.family.GetEventsResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetEventsActivityProvider implements RequestHandler<GetEventsRequest, GetEventsResult> {

    @Override
    public GetEventsResult handleRequest(final GetEventsRequest getEventsRequest, Context context) {
        return getDaggerServiceComponent().provideGetEventsActivity().handleRequest(getEventsRequest, context);
    }
    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}
