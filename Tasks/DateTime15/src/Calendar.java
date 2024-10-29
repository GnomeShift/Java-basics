import java.time.*;
import java.time.format.TextStyle;
import java.util.*;

public class Calendar {

    public static void printCalendar(int year, int month) {
        YearMonth ym = YearMonth.of(year, month);
        LocalDate firstDay = ym.atDay(1);
        LocalDate lastDay = ym.atEndOfMonth();

        System.out.println("Календарь " + ym.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()) + " " + year);

        System.out.println("Пн Вт Ср Чт Пт Сб Вс");

        int dayOfWeek = firstDay.getDayOfWeek().getValue();
        for (int i = 1; i < dayOfWeek; i++) {
            System.out.print("   ");
        }

        for (LocalDate date = firstDay; date.isBefore(lastDay.plusDays(1)); date = date.plusDays(1)) {
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.print("[" + date.getDayOfMonth() + "] ");
            } else {
                System.out.print(" " + date.getDayOfMonth() + " ");
            }

            if (date.getDayOfWeek().getValue() == 7) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        printCalendar(2024, 10);
    }
}
