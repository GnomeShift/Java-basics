import java.time.*;
import java.time.format.DateTimeFormatter;

public class TZConverter {
    public static String convertTZ(String UTC, String targetTZ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss XXX");

        ZonedDateTime utcDateTime = ZonedDateTime.parse(UTC, formatter);
        ZonedDateTime targetDateTime = utcDateTime.withZoneSameInstant(ZoneId.of(targetTZ));

        return targetDateTime.format(formatter);
    }

    public static void main(String[] args) {
        String DateTime = "29-10-2024 12:24:43 +00:00";
        String targetTZ = "Europe/Moscow";

        System.out.println("Конвертированное время: " + convertTZ(DateTime, targetTZ));
    }
}
