package api.touchbase.dynamodb;

import api.touchbase.dynamodb.models.Family;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.FamilyNotFoundException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class FamilyDao {
    private final DynamoDBMapper mapper;

    @Inject
    public FamilyDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public Family getFamily(String familyId) {

        Family family = mapper.load(Family.class, familyId);

        if (family == null) {
            throw new FamilyNotFoundException(String.format("There is no family for the given familyId {%s}", familyId));
        }

        return family;
    }

    public Family save(Family family) {
        mapper.save(family);
        return family;
    }

    public PaginatedQueryList<Family> queryFamilyNames(String familyName) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":familyName", new AttributeValue().withS(familyName));

        DynamoDBQueryExpression<Family> queryExpression = new DynamoDBQueryExpression<Family>()
            .withIndexName("FamilyNameIndex")
            .withConsistentRead(false)
            .withKeyConditionExpression("familyName = :familyName")
            .withExpressionAttributeValues(valueMap);

        PaginatedQueryList<Family> familyPaginatedQueryList = mapper.query(Family.class, queryExpression);

        if (familyPaginatedQueryList == null ||familyPaginatedQueryList.isEmpty()) {
            throw new FamilyNotFoundException("Password or Username is incorrect");
        }

        return familyPaginatedQueryList;
    }
}
