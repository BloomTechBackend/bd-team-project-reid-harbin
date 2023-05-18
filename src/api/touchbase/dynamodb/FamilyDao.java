package api.touchbase.dynamodb;

import api.touchbase.dynamodb.models.Family;
import api.touchbase.exceptions.FamilyNotFoundException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import javax.inject.Inject;

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


}
