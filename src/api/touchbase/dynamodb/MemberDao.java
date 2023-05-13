package api.touchbase.dynamodb;

import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.InvalidInputException;
import api.touchbase.exceptions.MemberNotFoundException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import javax.inject.Inject;

public class MemberDao {
    private final DynamoDBMapper mapper;

    @Inject
    public MemberDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public Member getMember(String memberId) {
        Member member = this.mapper.load(Member.class, memberId);

        if (member == null) {
            throw new MemberNotFoundException(String.format("Could not find member for memberId { %s }", memberId));
        }

        return member;
    }

    public Member saveMember(Member member) {
        mapper.save(member);
        return member;
    }

    public void deleteMember(Member memberToDelete) {
        mapper.delete(memberToDelete);
    }

}
