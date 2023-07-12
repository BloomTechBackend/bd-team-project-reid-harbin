package api.touchbase.dynamodb.models;

import api.touchbase.converters.EventsListConverter;
import api.touchbase.converters.MapConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.List;
import java.util.Map;

@DynamoDBTable(tableName = "touchbase_families")
public class Family {
    private String familyId;
    private String familyName;
    private String familyPassword;
    private String familyPasswordSalt;
    private List<Event> familyEvents;
    private Map<String, String> familyMemberNamesToMemberIds;

    @DynamoDBHashKey(attributeName = "familyId")
    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "FamilyNameIndex", attributeName = "familyName")
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

    @DynamoDBAttribute(attributeName = "familyPasswordSalt")
    public String getFamilyPasswordSalt() {
        return familyPasswordSalt;
    }

    public void setFamilyPasswordSalt(String familyPasswordSalt) {
        this.familyPasswordSalt = familyPasswordSalt;
    }

    @DynamoDBTypeConverted(converter = EventsListConverter.class)
    @DynamoDBAttribute(attributeName = "familyEvents")
    public List<Event> getFamilyEvents() {
        return familyEvents;
    }

    public void setFamilyEvents(List<Event> familyEventIds) {
        this.familyEvents = familyEventIds;
    }

    @DynamoDBTypeConverted(converter = MapConverter.class)
    @DynamoDBAttribute(attributeName = "familyMemberNamesToMemberIds")
    public Map<String, String> getFamilyMemberNamesToMemberIds() {
        return familyMemberNamesToMemberIds;
    }

    public void setFamilyMemberNamesToMemberIds(Map<String, String> familyMemberNamesToMemberIds) {
        this.familyMemberNamesToMemberIds = familyMemberNamesToMemberIds;
    }
}
