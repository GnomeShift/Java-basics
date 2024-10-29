import java.time.*;
import java.time.format.DateTimeFormatter;

public class EventTimeCounter {

    public static void eventTimeCounter(String eventDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime eventTime = LocalDateTime.parse(eventDateTime, formatter);
        LocalDateTime now = LocalDateTime.now();

        Duration duration = Duration.between(now, eventTime);

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        System.out.println("Осталось: " + hours + " ч " + minutes + " мин " + seconds + " сек");
    }

    public static void main(String[] args) {
        eventTimeCounter("2024-10-30 15:00:00");
    }
}
