package api.touchbase.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class LocalTimeConverter implements DynamoDBTypeConverter<String, LocalTime> {
    private final Logger log = LogManager.getLogger();
    private Gson GSON = new Gson();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h m a");

    @Override
    public String convert(LocalTime localTimeToBeConverted) {
        return GSON.toJson(localTimeToBeConverted);
    }

    @Override
    public LocalTime unconvert(String dynamoDbRepresentation) {
        // need to provide the type parameter of the list to convert correctly
        return GSON.fromJson(dynamoDbRepresentation, new TypeToken<LocalTime>() { } .getType());
    }
}
