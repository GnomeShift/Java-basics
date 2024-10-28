import java.time.*;
import java.time.temporal.ChronoUnit;

public class NYCounter {

    public static long counter() {
        LocalDate today = LocalDate.now();
        LocalDate newYear = LocalDate.of(today.getYear() + 1, 1, 1);
        return ChronoUnit.DAYS.between(today, newYear);
    }

    public static void main(String[] args) {
        long daysLeft = counter();
        System.out.println("До НГ " + daysLeft + " дней");
    }
}