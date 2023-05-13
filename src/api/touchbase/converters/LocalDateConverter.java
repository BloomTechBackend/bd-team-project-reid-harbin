package api.touchbase.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.LocalDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter implements DynamoDBTypeConverter<String, LocalDate> {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");

    @Override
    public String convert(LocalDate localDateTimeToConvert) {
        Logger log = LogManager.getLogger();
        log.info("Converting LocalDate ", localDateTimeToConvert);
        return localDateTimeToConvert.format(formatter);
    }

    @Override
    public LocalDate unconvert(String dynamoDbRepresentation) {
        return LocalDate.parse(dynamoDbRepresentation, formatter);
    }
}
