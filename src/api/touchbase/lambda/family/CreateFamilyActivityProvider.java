package api.touchbase.lambda.family;

import api.touchbase.dependency.DaggerServiceComponent;
import api.touchbase.dependency.ServiceComponent;
import api.touchbase.models.requests.family.CreateFamilyRequest;
import api.touchbase.models.results.family.CreateFamilyResult;
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
