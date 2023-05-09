package api.touchbase.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class BirthDateLocalDateTimeConverter implements DynamoDBTypeConverter<String, LocalDateTime> {
    private static final Gson GSON = new Gson();

    @Override
    public String convert(LocalDateTime localDateTimeToConvert) {
        return GSON.toJson(localDateTimeToConvert);
    }

    @Override
    public LocalDateTime unconvert(String dynamoDbRepresentation) {
        Type type = new TypeToken<LocalDateTime>(){}.getType();
        return GSON.fromJson(dynamoDbRepresentation, type);
    }
}
