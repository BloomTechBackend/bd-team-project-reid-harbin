package api.touchbase.activity.family;

import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.FamilyDao;
import api.touchbase.dynamodb.models.Event;
import api.touchbase.dynamodb.models.Family;
import api.touchbase.models.objects.EventModel;
import api.touchbase.models.requests.family.GetEventsRequest;
import api.touchbase.models.results.family.GetEventsResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GetEventsActivity implements RequestHandler<GetEventsRequest, GetEventsResult> {
    private final FamilyDao familyDao;

    @Inject
    public GetEventsActivity(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    @Override
    public GetEventsResult handleRequest(final GetEventsRequest getEventsRequest, Context context) {
        String requestFamilyId = getEventsRequest.getFamilyId();
        Family family = familyDao.getFamily(requestFamilyId);
        List<EventModel> eventModels = new ArrayList<>();
        family.getFamilyEvents().forEach((e) -> eventModels.add(ModelConverter.toEventModel(e)));

        return GetEventsResult.builder().withFamilyEvents(eventModels).build();
    }
}
