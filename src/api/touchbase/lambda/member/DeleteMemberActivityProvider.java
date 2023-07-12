package api.touchbase.lambda.member;

import api.touchbase.dependency.DaggerServiceComponent;
import api.touchbase.dependency.ServiceComponent;
import api.touchbase.models.requests.member.DeleteMemberRequest;
import api.touchbase.models.results.member.DeleteMemberResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class DeleteMemberActivityProvider implements RequestHandler<DeleteMemberRequest, DeleteMemberResult> {
    public DeleteMemberActivityProvider() {
    }

    @Override
    public DeleteMemberResult handleRequest(final DeleteMemberRequest deleteMemberRequest, Context context) {
        return getDaggerServiceComponent()
                .provideDeleteMemberActivity()
                .handleRequest(deleteMemberRequest, context);
    }
    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}
