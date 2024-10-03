import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateCheck {

    public static void DateCheck(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate.parse(date, formatter);
        }
        catch (DateTimeParseException e) {
            System.out.println("Некорректный формат!!");
        }
    }

    public static void main(String[] args) {
        DateCheck("01.01.2024");
    }
}
