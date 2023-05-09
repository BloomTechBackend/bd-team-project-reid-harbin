package api.touchbase.dynamodb.models;

import api.touchbase.NotificationContent;
import api.touchbase.converters.BirthDateLocalDateTimeConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

import java.time.LocalDateTime;
import java.util.List;

@DynamoDBTable(tableName = "touchbase_members")
public class Member {
    private String memberId;
    private String memberFamilyId;
    private String memberName;
    private int memberAge;
    private boolean memberHasFamily;
    private LocalDateTime memberBirthday;
    private List<NotificationContent> memberNotifications;

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

    @DynamoDBAttribute(attributeName = "memberName")
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @DynamoDBAttribute(attributeName = "memberAge")
    public int getMemberAge() {
        return memberAge;
    }

    public void setMemberAge(int memberAge) {
        this.memberAge = memberAge;
    }

    @DynamoDBAttribute(attributeName = "memberHasFamily")
    public boolean isMemberHasFamily() {
        return memberHasFamily;
    }

    public void setMemberHasFamily(boolean memberHasFamily) {
        this.memberHasFamily = memberHasFamily;
    }

    @DynamoDBTypeConverted(converter = BirthDateLocalDateTimeConverter.class)
    @DynamoDBAttribute(attributeName = "memberBirthday")
    public LocalDateTime getMemberBirthday() {
        return memberBirthday;
    }

    public void setMemberBirthday(LocalDateTime memberBirthday) {
        this.memberBirthday = memberBirthday;
    }

    @DynamoDBAttribute(attributeName = "memberNotifications")
    public List<NotificationContent> getMemberNotifications() {
        return memberNotifications;
    }

    public void setMemberNotifications(List<NotificationContent> memberNotifications) {
        this.memberNotifications = memberNotifications;
    }
}
