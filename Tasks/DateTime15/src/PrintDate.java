import java.time.*;
import java.time.format.*;
import java.util.*;

public class PrintDate {

    public static void printDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.getDefault());
        System.out.println(date.format(formatter));
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 10, 29);
        printDate(date);
    }
}
