import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateFormat {
    public static void main(String[] args) {
        String inputDate = "26-10-2023";
        DateTimeFormatter inFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter outFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate date = LocalDate.parse(inputDate, inFormatter);
        LocalDate newDate = date.plusDays(10);

        String formattedDate = newDate.format(outFormatter);
        System.out.println("Отформатированная дата: " + formattedDate);
    }
}
