package place.reservation.reservations.pojo;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DurationUtils {
    public static String formatDuration(Integer minutes) {
        Duration duration = Duration.ofMinutes(minutes);
        LocalTime localTime = LocalTime.ofSecondOfDay(duration.getSeconds());
        DateTimeFormatter formatter;
        if (minutes < 60) {
            formatter = DateTimeFormatter.ofPattern("mm");
            return localTime.format(formatter) + "m";
        } else {
            formatter = DateTimeFormatter.ofPattern("HH'h'mm");
            return localTime.format(formatter);
        }

    }
}
