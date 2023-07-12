package api.touchbase.lambda.family;

import api.touchbase.dependency.DaggerServiceComponent;
import api.touchbase.dependency.ServiceComponent;
import api.touchbase.models.requests.family.CreateEventRequest;
import api.touchbase.models.results.family.CreateEventResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateEventActivityProvider implements RequestHandler<CreateEventRequest, CreateEventResult> {
    @Override
    public CreateEventResult handleRequest(final CreateEventRequest createEventRequest, Context context) {
        return getDaggerServiceComponent().provideCreateEventActivity().handleRequest(createEventRequest, context);
    }

    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}
