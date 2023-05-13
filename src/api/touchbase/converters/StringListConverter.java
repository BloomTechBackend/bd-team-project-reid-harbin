package api.touchbase.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class StringListConverter implements DynamoDBTypeConverter<String, List> {
    private static final Gson GSON = new Gson();
    @Override
    public String convert(List stringListToConvert) {
        return GSON.toJson(stringListToConvert);
    }

    @Override
    public List unconvert(String dynamoDbRepresentation) {
        return GSON.fromJson(dynamoDbRepresentation, new TypeToken<List<String>>(){ }.getType());
    }
}
