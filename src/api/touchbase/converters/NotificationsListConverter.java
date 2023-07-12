package api.touchbase.converters;

import api.touchbase.dynamodb.models.Notification;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class NotificationsListConverter implements DynamoDBTypeConverter<String, List> {
    private static final Gson GSON = new Gson();

    @Override
    public String convert(List notificationContentToConvert) {
        return GSON.toJson(notificationContentToConvert);
    }

    @Override
    public List<Notification> unconvert(String dynamoDbRepresentation) {
        return GSON.fromJson(dynamoDbRepresentation, new TypeToken<List<Notification>>(){ }.getType());
    }
}
