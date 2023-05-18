package api.touchbase.dynamodb;

import api.touchbase.dynamodb.models.Event;
import api.touchbase.exceptions.EventNotFoundException;
import api.touchbase.exceptions.InvalidInputException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import javax.inject.Inject;

public class EventDao {
    private final DynamoDBMapper mapper;

    @Inject
    public EventDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public Event getEvent(String familyId, String eventId) {
        Event event = mapper.load(Event.class, familyId, eventId);

        if (event == null) {
            throw new EventNotFoundException(String.format("There was no event for id {%s}", eventId));
        }

        return event;
    }

    public Event save(Event event) {
        if (event == null) {
            throw new InvalidInputException("Cannot save an event that does not exist");
        }
        mapper.save(event);
        return event;
    }
}
