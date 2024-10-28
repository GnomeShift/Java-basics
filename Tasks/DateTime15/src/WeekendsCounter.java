import java.time.*;
import java.time.format.TextStyle;
import java.util.*;

public class WeekendsCounter {

    public static void count(int year, int month) {
        int count = 0;
        YearMonth ym = YearMonth.of(year, month);
        LocalDate start = ym.atDay(1);
        LocalDate end = ym.atEndOfMonth();

        for (LocalDate date = start; date.isBefore(end.plusDays(1)); date = date.plusDays(1)) {
            if (date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7) {
                count++;
            }
        }

        int weekends = count;
        String monthName = YearMonth.of(year, month).getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());

        System.out.println("В " + monthName + " " + year + " " + weekends + " выходных");
    }

    public static void main(String[] args) {
        count(2024, 2);
    }
}