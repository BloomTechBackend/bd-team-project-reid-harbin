package api.touchbase.lambda;

import api.touchbase.dependency.DaggerServiceComponent;
import api.touchbase.dependency.ServiceComponent;
import api.touchbase.models.requests.CreateMemberRequest;
import api.touchbase.models.results.CreateMemberResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateMemberActivityProvider implements RequestHandler<CreateMemberRequest, CreateMemberResult> {
    public CreateMemberActivityProvider() {}

    @Override
    public CreateMemberResult handleRequest(final CreateMemberRequest createMemberRequest, Context context) {
        return getDaggerServiceComponent()
                .provideCreateMemberActivity()
                .handleRequest(createMemberRequest, context);
    }

    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}
