import java.time.*;

public class WorkHoursCounter {

    public static void calcWorkHours(LocalDateTime startTime, LocalDateTime endTime) {
        long workingHours = 0;
        LocalDateTime current = startTime;

        while (current.isBefore(endTime)) {
            if (current.getDayOfWeek() != DayOfWeek.SATURDAY && current.getDayOfWeek() != DayOfWeek.SUNDAY) {
                workingHours++;
            }
            current = current.plusHours(1);
        }

        System.out.println("Кол-во рабочих часов: " + workingHours);
    }

    public static void main(String[] args) {
        LocalDateTime startTime = LocalDateTime.of(2024, 10, 29, 9, 0);
        LocalDateTime endTime = LocalDateTime.of(2024, 10, 30, 18, 0);

        calcWorkHours(startTime, endTime);
    }
}
