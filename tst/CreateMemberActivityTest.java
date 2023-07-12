import api.touchbase.activity.member.CreateMemberActivity;
import api.touchbase.converters.LocalDateConverter;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.models.objects.MemberModel;
import api.touchbase.models.requests.member.CreateMemberRequest;
import api.touchbase.models.results.member.CreateMemberResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class CreateMemberActivityTest {
    @Mock
    private MemberDao memberDao;

    private CreateMemberActivity createMemberActivity;

    @BeforeEach
    private void setup() {
        initMocks(this);
        createMemberActivity = new CreateMemberActivity(memberDao);
    }

    @Test
    void handleRequest_validRequest_returnsMatchingMemberModelInResult() {
        // GIVEN
        LocalDateConverter localDateConverter = new LocalDateConverter();

        String expectId = "AbcD1234";
        String expectedPassword = "abcjd7da";
        String expectedName = "John Doe";



        Member member = new Member();
        member.setMemberName(expectedName);
        member.setMemberId(expectId);

        when(memberDao.saveMember(member)).thenReturn(member);

        CreateMemberRequest request = CreateMemberRequest.builder()
                .withMemberPassword(expectedPassword)
                .withName(expectedName)
                .build();

        CreateMemberResult result = createMemberActivity.handleRequest(request, null);
        MemberModel actualMember = result.getMember();


        assertEquals(expectedName, actualMember.getMemberName());
        assertEquals("TouchBase", actualMember.getNotifications().get(0).getNotificationSenderName());
    }

    @Test
    void handleRequest_invalidPassword_throwsInvalidPasswordException() {

    }

    @Test
    void handleRequest_invalidBirthday_throwsInvalidInputException() {

    }

    @Test
    void handleRequest_nullName_throwsInvalidInputException() {

    }


}
