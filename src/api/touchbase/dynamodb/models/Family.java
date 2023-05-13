package api.touchbase.dynamodb.models;

import api.touchbase.converters.NotificationsListConverter;
import api.touchbase.converters.StringListConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

import java.util.List;
@DynamoDBTable(tableName = "touchbase_families")
public class Family {
    private String familyId;
    private String familyName;
    private String familyPassword;
    private List<String> familyEventIds;
    private List<String> familyMemberIds;

    @DynamoDBHashKey(attributeName = "familyId")
    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    @DynamoDBAttribute(attributeName = "familyName")
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @DynamoDBAttribute(attributeName = "familyPassword")
    public String getFamilyPassword() {
        return familyPassword;
    }

    public void setFamilyPassword(String familyPassword) {
        this.familyPassword = familyPassword;
    }

    @DynamoDBTypeConverted(converter = StringListConverter.class)
    @DynamoDBAttribute(attributeName = "familyEventIds")
    public List<String> getFamilyEventIds() {
        return familyEventIds;
    }

    public void setFamilyEventIds(List<String> familyEventIds) {
        this.familyEventIds = familyEventIds;
    }

    @DynamoDBTypeConverted(converter = StringListConverter.class)
    @DynamoDBAttribute(attributeName = "familyMemberIds")
    public List<String> getFamilyMemberIds() {
        return familyMemberIds;
    }

    public void setFamilyMemberIds(List<String> familyMemberIds) {
        this.familyMemberIds = familyMemberIds;
    }
}
