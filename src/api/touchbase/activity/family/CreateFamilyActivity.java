package api.touchbase.activity.family;

import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.FamilyDao;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Family;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.*;
import api.touchbase.models.objects.FamilyModel;
import api.touchbase.models.requests.family.CreateFamilyRequest;
import api.touchbase.models.results.family.CreateFamilyResult;
import api.touchbase.utils.IdGenerator;
import api.touchbase.utils.InputStringValidator;
import api.touchbase.utils.TouchBasePasswordAuthentication;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;
import java.util.*;

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

        if (creator.getMemberFamilyId() != null) {
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

        try {
            familyDao.queryFamilyNames(requestName);
            throw new UsernameTakenException("Family Name has been taken");

        } catch (FamilyNotFoundException e) {
            Map<String, String> familyMemberNamesToMemberIds = new HashMap<>();
            familyMemberNamesToMemberIds.put(creator.getMemberName(), requestCreatorId);

            String passwordSalt = TouchBasePasswordAuthentication.getRandomSalt();
            String hashedPassword = TouchBasePasswordAuthentication.hashPassword(passwordSalt.concat(requestPassword));

            Family familyToCreate = new Family();
            familyToCreate.setFamilyId(IdGenerator.generateId());
            familyToCreate.setFamilyName(requestName);
            familyToCreate.setFamilyPassword(hashedPassword);
            familyToCreate.setFamilyPasswordSalt(passwordSalt);
            familyToCreate.setFamilyMemberNamesToMemberIds(familyMemberNamesToMemberIds);
            familyToCreate.setFamilyEvents(new ArrayList<>());

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
}
