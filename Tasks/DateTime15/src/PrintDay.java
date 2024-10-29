import java.time.*;
import java.time.format.*;
import java.util.*;

public class PrintDay {

    public static void printDay(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.getDefault());
        System.out.println(date.format(formatter));
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 10, 29);
        printDay(date);
    }
}
