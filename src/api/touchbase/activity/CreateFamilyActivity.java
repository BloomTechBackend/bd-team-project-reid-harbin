package api.touchbase.activity;

import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.FamilyDao;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Family;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.InvalidInputException;
import api.touchbase.exceptions.InvalidPasswordException;
import api.touchbase.exceptions.MemberHasFamilyException;
import api.touchbase.models.FamilyModel;
import api.touchbase.models.requests.CreateFamilyRequest;
import api.touchbase.models.results.CreateFamilyResult;
import api.touchbase.utils.IdGenerator;
import api.touchbase.utils.InputStringValidator;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CreateFamilyActivity implements RequestHandler<CreateFamilyRequest, CreateFamilyResult> {
    private final FamilyDao familyDao;
    private final MemberDao memberDao;

    @Inject
    public CreateFamilyActivity(FamilyDao familyDao, MemberDao memberDao) {
        this.familyDao = familyDao;
        this.memberDao = memberDao;
    }

    @Override
    public CreateFamilyResult handleRequest(final CreateFamilyRequest createFamilyRequest, Context context) {
        String requestPassword = createFamilyRequest.getFamilyPassword();
        String requestName = createFamilyRequest.getFamilyName();
        String requestCreatorId = createFamilyRequest.getFamilyCreatorId();
        Member creator = memberDao.getMember(requestCreatorId);

        if (creator.getMemberHasFamily()) {
            throw new MemberHasFamilyException("You need to leave your current family before you can create a new one");
        }

        if (!InputStringValidator.isValidPassword(requestPassword)) {
            throw new InvalidPasswordException(String.format("The password provided {%s} " +
                            "did not follow the required format",
                            requestPassword));
        }

        if (requestName == null || requestName.isBlank()) {
            throw new InvalidInputException("You must provide a name for your family");
        }

        List<String> familyMemberIds = new ArrayList<>();
        familyMemberIds.add(requestCreatorId);

        Family familyToCreate = new Family();
        familyToCreate.setFamilyId(IdGenerator.generateId());
        familyToCreate.setFamilyName(requestName);
        familyToCreate.setFamilyPassword(requestPassword);
        familyToCreate.setFamilyMemberIds(familyMemberIds);
        familyToCreate.setFamilyEventIds(new ArrayList<>());

        creator.setMemberHasFamily(true);
        creator.setMemberFamilyId(familyToCreate.getFamilyId());

        memberDao.saveMember(creator);
        familyDao.save(familyToCreate);

        ModelConverter converter = new ModelConverter();
        FamilyModel familyModel = converter.toFamilyModel(familyToCreate);

        return CreateFamilyResult.builder()
                .withFamilyModel(familyModel)
                .build();
    }
}
