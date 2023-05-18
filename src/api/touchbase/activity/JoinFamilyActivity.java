package api.touchbase.activity;

import api.touchbase.NotificationContent;
import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.FamilyDao;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Family;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.InvalidInputException;
import api.touchbase.exceptions.InvalidPasswordException;
import api.touchbase.exceptions.MemberHasFamilyException;
import api.touchbase.models.FamilyModel;
import api.touchbase.models.requests.JoinFamilyRequest;
import api.touchbase.models.results.JoinFamilyResult;
import api.touchbase.utils.NotificationCreator;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class JoinFamilyActivity implements RequestHandler<JoinFamilyRequest, JoinFamilyResult> {
    private final MemberDao memberDao;
    private final FamilyDao familyDao;

    @Inject
    public JoinFamilyActivity(MemberDao memberDao, FamilyDao familyDao) {
        this.memberDao = memberDao;
        this.familyDao = familyDao;
    }

    @Override
    public JoinFamilyResult handleRequest(final JoinFamilyRequest joinFamilyRequest, Context context) {
        String requestMemberId = joinFamilyRequest.getMemberId();
        String requestFamilyId = joinFamilyRequest.getFamilyId();
        String requestFamilyName = joinFamilyRequest.getFamilyName();
        String requestFamilyPassword = joinFamilyRequest.getFamilyPassword();

        Family family = familyDao.getFamily(requestFamilyId);
        Member member = memberDao.getMember(requestMemberId);

        if (requestFamilyPassword == null || requestFamilyPassword.isBlank()) {
            throw new InvalidPasswordException("You must provide a valid password");
        }

        if (requestFamilyName == null || requestFamilyName.isBlank()) {
            throw new InvalidInputException("You must provide a a family name");
        }

        if (member.getMemberHasFamily()) {
            throw new MemberHasFamilyException("You must leave your current family before you can join a new one");
        }
        if (!requestFamilyName.equals(family.getFamilyName())) {
            throw new InvalidInputException(String.format("The provided familyId {%s} does not match the " +
                    "associated familyName", requestFamilyId));
        }
        if (!requestFamilyPassword.equals(family.getFamilyPassword())) {
            throw new InvalidPasswordException("The password provided is incorrect");
        }

        member.setMemberFamilyId(requestFamilyId);
        member.setMemberHasFamily(true);

        memberDao.saveMember(member);

        List<String> memberIds = family.getFamilyMemberIds();

        for(String id : memberIds) {
            Member memberToNotify = memberDao.getMember(id);

            List<NotificationContent> familyMemberNotifications =
                    new ArrayList<>(memberToNotify.getMemberNotifications());

            familyMemberNotifications.add(0, new NotificationCreator()
                            .newFamilyMemberNotification(member.getMemberName()));

            memberToNotify.setMemberNotifications(familyMemberNotifications);

            memberDao.saveMember(memberToNotify);
        }

        memberIds.add(requestMemberId);
        family.setFamilyMemberIds(memberIds);

        familyDao.save(family);
        FamilyModel familyModel = new ModelConverter().toFamilyModel(family);

        return JoinFamilyResult.builder()
                .withFamilyModel(familyModel)
                .build();
    }
}
