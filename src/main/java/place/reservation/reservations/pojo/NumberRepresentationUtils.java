package place.reservation.reservations.pojo;

public class NumberRepresentationUtils {
    public static String formatNumberForView(double number) {
        if (Math.round(number) == number) {
            return String.valueOf(Double.valueOf(number).intValue());
        } else {
            return String.valueOf(number);
        }

    }
}
