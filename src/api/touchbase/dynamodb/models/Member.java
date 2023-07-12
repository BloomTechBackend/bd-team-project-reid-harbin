package api.touchbase.dynamodb.models;

import api.touchbase.converters.NotificationsListConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.List;

@DynamoDBTable(tableName = "touchbase_members")
public class Member {
    private String memberId;
    private String memberFamilyId;
    private String memberName;
    private String memberPassword;
    private String memberPasswordSalt;
    private List<Notification> memberNotifications;

    @DynamoDBHashKey(attributeName = "memberId")
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @DynamoDBAttribute(attributeName = "memberFamilyId")
    public String getMemberFamilyId() {
        return memberFamilyId;
    }

    public void setMemberFamilyId(String memberFamilyId) {
        this.memberFamilyId = memberFamilyId;
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "MemberNameIndex", attributeName = "memberName")
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @DynamoDBAttribute(attributeName = "memberPassword")
    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    @DynamoDBAttribute(attributeName = "memberPasswordSalt")
    public String getMemberPasswordSalt() {
        return memberPasswordSalt;
    }

    public void setMemberPasswordSalt(String memberPasswordSalt) {
        this.memberPasswordSalt = memberPasswordSalt;
    }


    @DynamoDBTypeConverted(converter = NotificationsListConverter.class)
    @DynamoDBAttribute(attributeName = "memberNotifications")
    public List<Notification> getMemberNotifications() {
        return memberNotifications;
    }

    public void setMemberNotifications(List<Notification> memberNotifications) {
        this.memberNotifications = memberNotifications;
    }
}
