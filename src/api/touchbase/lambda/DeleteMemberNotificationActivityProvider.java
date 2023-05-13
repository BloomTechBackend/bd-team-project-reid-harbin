package api.touchbase.lambda;

import api.touchbase.dependency.DaggerServiceComponent;
import api.touchbase.dependency.ServiceComponent;
import api.touchbase.models.requests.CreateMemberRequest;
import api.touchbase.models.requests.DeleteMemberNotificationRequest;
import api.touchbase.models.results.CreateMemberResult;
import api.touchbase.models.results.DeleteMemberNotificationResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class DeleteMemberNotificationActivityProvider implements RequestHandler<DeleteMemberNotificationRequest, DeleteMemberNotificationResult> {
    public DeleteMemberNotificationActivityProvider() {

    }
    @Override
    public DeleteMemberNotificationResult handleRequest(final DeleteMemberNotificationRequest deleteMemberNotificationRequest, Context context) {
        return getDaggerServiceComponent()
                .provideDeleteMemberNotificationActivity()
                .handleRequest(deleteMemberNotificationRequest, context);
    }

    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}
