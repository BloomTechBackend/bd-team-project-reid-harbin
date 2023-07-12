package api.touchbase.converters;

import api.touchbase.dynamodb.models.Event;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Set;

public class StringSetConverter implements DynamoDBTypeConverter<String, Set> {
    private static final Gson GSON = new Gson();

    @Override
    public String convert(Set eventListToConvert) {
        System.out.println("EventListToConvert: "+ eventListToConvert.toString() +"\n");
        return GSON.toJson(eventListToConvert);
    }

    @Override
    public Set unconvert(String dynamoDbRepresentation) {
        System.out.println("DB REPRESENTATION: "+dynamoDbRepresentation+"\n");
        return GSON.fromJson(dynamoDbRepresentation, new TypeToken<Set<String>>(){ }.getType());
    }
}
