package api.touchbase.utils;

import api.touchbase.dynamodb.models.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EventInserter {

    private static final String AM = "AM";
    private static final String PM = "PM";

    public static int insertEvent(List<Event> events, LocalDate targetDate, LocalTime targetStartTime,
                                  String startMeridian) {
        int left = 0;
        int right = events.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            LocalDate midDate = events.get(mid).getEventDate();
            String midMeridian = events.get(mid).getEventStartMeridian();
            LocalTime midStartTime = events.get(mid).getEventStartTime();

            if (midDate.isEqual(targetDate) && midStartTime.equals(targetStartTime) &&
                    midMeridian.equals(startMeridian)) {
                return mid;
            }

            if (midDate.isEqual(targetDate)) {
                if (midMeridian.equals(startMeridian)) {
                    if (midStartTime.isBefore(targetStartTime)) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else if (midMeridian.equals(AM) && startMeridian.equals(PM)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (midDate.isBefore(targetDate)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return left;
    }
}
