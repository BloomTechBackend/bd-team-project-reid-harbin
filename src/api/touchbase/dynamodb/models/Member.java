package api.touchbase.dynamodb.models;

import api.touchbase.NotificationContent;
import api.touchbase.converters.LocalDateConverter;
import api.touchbase.converters.NotificationsListConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

import java.time.LocalDate;
import java.util.List;

@DynamoDBTable(tableName = "touchbase_members")
public class Member {
    private String memberId;
    private String memberFamilyId;
    private String memberName;
    private String memberPassword;
    private boolean memberHasFamily;
    private LocalDate memberBirthday;
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

    @DynamoDBAttribute(attributeName = "memberPassword")
    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    @DynamoDBAttribute(attributeName = "memberHasFamily")
    public boolean getMemberHasFamily() {
        return memberHasFamily;
    }

    public void setMemberHasFamily(boolean memberHasFamily) {
        this.memberHasFamily = memberHasFamily;
    }

    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    @DynamoDBAttribute(attributeName = "memberBirthday")
    public LocalDate getMemberBirthday() {
        return memberBirthday;
    }

    public void setMemberBirthday(LocalDate memberBirthday) {
        this.memberBirthday = memberBirthday;
    }

    @DynamoDBTypeConverted(converter = NotificationsListConverter.class)
    @DynamoDBAttribute(attributeName = "memberNotifications")
    public List<NotificationContent> getMemberNotifications() {
        return memberNotifications;
    }

    public void setMemberNotifications(List<NotificationContent> memberNotifications) {
        this.memberNotifications = memberNotifications;
    }
}
