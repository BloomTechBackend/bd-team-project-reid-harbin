package api.touchbase.activity.family;

import api.touchbase.dynamodb.models.Notification;
import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.FamilyDao;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Family;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.InvalidInputException;
import api.touchbase.exceptions.InvalidPasswordException;
import api.touchbase.exceptions.MemberHasFamilyException;
import api.touchbase.models.objects.FamilyModel;
import api.touchbase.models.requests.family.JoinFamilyRequest;
import api.touchbase.models.results.family.JoinFamilyResult;
import api.touchbase.utils.NotificationCreator;
import api.touchbase.utils.TouchBasePasswordAuthentication;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        String requestFamilyName = joinFamilyRequest.getFamilyName();
        String requestFamilyPassword = joinFamilyRequest.getFamilyPassword();

        Member member = memberDao.getMember(requestMemberId);

        if (requestFamilyPassword == null || requestFamilyPassword.isBlank()) {
            throw new InvalidPasswordException("You must provide a valid password");
        }

        if (requestFamilyName == null || requestFamilyName.isBlank()) {
            throw new InvalidInputException("You must provide a a family name");
        }

        if (member.getMemberFamilyId() != null) {
            throw new MemberHasFamilyException("You must leave your current family before you can join a new one");
        }

        Family family = familyDao.queryFamilyNames(requestFamilyName).get(0);

        if (!TouchBasePasswordAuthentication.isMatchingPassword(family.getFamilyPasswordSalt(),
                requestFamilyPassword, family.getFamilyPassword())) {
            throw new InvalidPasswordException("Incorrect password");
        }

        member.setMemberFamilyId(family.getFamilyId());
        memberDao.saveMember(member);

        Map<String, String> memberNamesToIds = family.getFamilyMemberNamesToMemberIds();
        Set<String> memberNames = memberNamesToIds.keySet();

        for(String name : memberNames) {
            String id = memberNamesToIds.get(name);

            Member memberToNotify = memberDao.getMember(id);

            List<Notification> familyMemberNotifications = new ArrayList<>(memberToNotify.getMemberNotifications());

            familyMemberNotifications.add(0,
                    new NotificationCreator()
                    .newFamilyMemberNotification(member.getMemberName()));

            memberToNotify.setMemberNotifications(familyMemberNotifications);

            memberDao.saveMember(memberToNotify);
        }

        memberNamesToIds.put(member.getMemberName(), requestMemberId);
        family.setFamilyMemberNamesToMemberIds(memberNamesToIds);

        familyDao.save(family);
        FamilyModel familyModel = ModelConverter.toFamilyModel(family);

        return JoinFamilyResult.builder()
                .withFamilyModel(familyModel)
                .build();
    }
}
