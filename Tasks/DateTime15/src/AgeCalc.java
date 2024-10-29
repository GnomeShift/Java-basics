import java.time.*;

public class AgeCalc {

    public static int calcAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }

    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(2000, 10, 29);
        System.out.println("Возраст: " + calcAge(birthDate) + " лет");
    }
}
