package api.touchbase.converters;

import api.touchbase.dynamodb.models.Event;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class EventsListConverter implements DynamoDBTypeConverter<String, List>  {
    private static final Gson GSON = new Gson();

    @Override
    public String convert(List eventListToConvert) {
        return GSON.toJson(eventListToConvert);
    }

    @Override
    public List unconvert(String dynamoDbRepresentation) {
        return GSON.fromJson(dynamoDbRepresentation, new TypeToken<List<Event>>(){ }.getType());
    }
}
