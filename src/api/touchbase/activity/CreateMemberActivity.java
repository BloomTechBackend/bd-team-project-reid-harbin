package api.touchbase.activity;

import api.touchbase.NotificationContent;import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.InvalidPasswordException;
import api.touchbase.models.MemberModel;
import api.touchbase.models.requests.CreateMemberRequest;
import api.touchbase.models.results.CreateMemberResult;
import api.touchbase.utils.IdGenerator;
import api.touchbase.utils.InputStringValidator;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the CreateMemberActivity for the TouchBase API
 *
 * This API allows the user to create their Member profile
 */
public class CreateMemberActivity implements RequestHandler<CreateMemberRequest, CreateMemberResult> {
    private final Logger log = LogManager.getLogger();
    private final MemberDao memberDao;

    @Inject
    public CreateMemberActivity(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    /**
     * This method handles the incoming request by persisting a new member with the
     * provided member name, password,and birthday from the request
     * <p>
     * It then returns the new user
     * <p>
     *
     * If the provided name or password contain invalid characters, throws an InvalidAttributeException
     *
     * @param createMemberRequest Request object containing the member's name, password, and birthday associated
     *                            with it.
     * @return createMemberResult result object containing the API defined {@link MemberModel}
     */
    @Override
    public CreateMemberResult handleRequest(final CreateMemberRequest createMemberRequest, Context context) {

        log.info("Received CreateMemberRequest {}", createMemberRequest);
        String password = createMemberRequest.getPassword();
        String name = createMemberRequest.getName();
        String birthday = createMemberRequest.getBirthday();

        if (!InputStringValidator.isValidPassword(password)) {
            throw new InvalidPasswordException(
                    String.format("The password provided {%s} did not follow the required format", password));
        }


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");

        String now = LocalDate.now().format(formatter);

        NotificationContent welcomeNotification = new NotificationContent();
        welcomeNotification.setNotificationDate(now);
        welcomeNotification.setNotificationHeadline("WELCOME!");
        welcomeNotification.setNotificationDescription("Welcome to TouchBase! No matter how far from home, you'll always be able to touchbase!");
        welcomeNotification.setNotificationSenderName("TouchBase");

        List<NotificationContent> notifications = new ArrayList<>();
        notifications.add(welcomeNotification);

        Member memberToCreate = new Member();

        LocalDate date = LocalDate.parse(birthday, formatter);

        memberToCreate.setMemberId(IdGenerator.generateId());
        memberToCreate.setMemberBirthday(date);
        memberToCreate.setMemberName(name);
        memberToCreate.setMemberPassword(password);
        memberToCreate.setMemberHasFamily(false);
        memberToCreate.setMemberNotifications(notifications);

        memberDao.saveMember(memberToCreate);

        ModelConverter converter = new ModelConverter();

        MemberModel model = converter.toMemberModel(memberToCreate);

        return CreateMemberResult.builder()
                .withMember(model)
                .build();
    }
}
