import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class RandomDate {

    public static LocalDate randomDate(LocalDate startDate, LocalDate endDate) {
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        Random rnd = new Random();
        long randomDays = rnd.nextLong(daysBetween + 1);

        return startDate.plusDays(randomDays);
    }

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);

        System.out.println("Случайная дата: " + randomDate(startDate, endDate));
    }
}
