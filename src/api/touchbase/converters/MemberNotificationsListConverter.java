package api.touchbase.converters;

import api.touchbase.NotificationContent;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MemberNotificationsListConverter implements DynamoDBTypeConverter<String, List> {
    private static final Gson GSON = new Gson();

    @Override
    public String convert(List notificationContentToConvert) {
        return GSON.toJson(notificationContentToConvert);
    }

    @Override
    public List<NotificationContent> unconvert(String dynamoDbRepresentation) {
        Type type = new TypeToken<NotificationContent>(){}.getType();
        return GSON.fromJson(dynamoDbRepresentation, type);
    }
}
