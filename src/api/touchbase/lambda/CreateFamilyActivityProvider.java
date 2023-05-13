package api.touchbase.lambda;

import api.touchbase.dependency.DaggerServiceComponent;
import api.touchbase.dependency.ServiceComponent;
import api.touchbase.models.requests.CreateFamilyRequest;
import api.touchbase.models.results.CreateFamilyResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateFamilyActivityProvider implements RequestHandler<CreateFamilyRequest, CreateFamilyResult> {
    public CreateFamilyActivityProvider() {

    }

    @Override
    public CreateFamilyResult handleRequest(final CreateFamilyRequest createFamilyRequest, Context context) {
        return getDaggerServiceComponent()
                .provideCreateFamilyActivity()
                .handleRequest(createFamilyRequest, context);
    }

    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}
