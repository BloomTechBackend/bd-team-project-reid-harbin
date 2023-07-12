package api.touchbase.lambda.family;

import api.touchbase.dependency.DaggerServiceComponent;
import api.touchbase.dependency.ServiceComponent;
import api.touchbase.models.requests.family.GetFamilyRequest;
import api.touchbase.models.results.family.GetFamilyResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetFamilyActivityProvider implements RequestHandler<GetFamilyRequest, GetFamilyResult> {

    @Override
    public GetFamilyResult handleRequest(final GetFamilyRequest getFamilyRequest, Context context) {
        return getDaggerServiceComponent().provideGetFamilyActivity().handleRequest(getFamilyRequest, context);
    }

    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }

}
