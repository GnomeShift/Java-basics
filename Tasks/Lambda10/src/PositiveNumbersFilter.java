import java.util.*;

public class PositiveNumbersFilter {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-1, 2, -3, 4, -5);
        numbers.stream().filter(number -> number > 0).forEach(System.out::println);
    }
}
