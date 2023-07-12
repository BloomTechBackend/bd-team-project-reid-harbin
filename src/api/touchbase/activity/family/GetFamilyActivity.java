package api.touchbase.activity.family;

import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.FamilyDao;
import api.touchbase.dynamodb.models.Family;
import api.touchbase.models.requests.family.GetFamilyRequest;
import api.touchbase.models.results.family.GetFamilyResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;

public class GetFamilyActivity implements RequestHandler<GetFamilyRequest, GetFamilyResult> {
    private final FamilyDao familyDao;

    @Inject
    public GetFamilyActivity(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    @Override
    public GetFamilyResult handleRequest(final GetFamilyRequest getFamilyRequest, Context context) {
        Family family = familyDao.getFamily(getFamilyRequest.getFamilyId());

        return GetFamilyResult.builder()
                .withFamily(ModelConverter.toFamilyModel(family))
                .build();
    }
}
