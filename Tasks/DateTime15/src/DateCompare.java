import java.time.*;

public class DateCompare {

    public static String compare(LocalDate date, LocalDate date2) {
        if (date.isBefore(date2)) {
            return "Дата " + date + " меньше даты " + date2;
        } else if (date.isAfter(date2)) {
            return "Дата " + date + " больше даты " + date2;
        } else {
            return "Даты равны";
        }
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 10, 28);
        LocalDate date2 = LocalDate.of(2025, 10, 28);

        System.out.println(compare(date, date2));
    }
}
