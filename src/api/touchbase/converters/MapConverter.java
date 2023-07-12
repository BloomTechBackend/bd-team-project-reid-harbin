package api.touchbase.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

public class MapConverter implements DynamoDBTypeConverter<String, Map> {
    private static final Gson GSON = new Gson();
    @Override
    public String convert(Map mapToConvert) {
        return GSON.toJson(mapToConvert);
    }

    @Override
    public Map unconvert(String dynamoDbRepresentation) {
        return GSON.fromJson(dynamoDbRepresentation, new TypeToken<Map<String, String>>(){ }.getType());
    }
}
