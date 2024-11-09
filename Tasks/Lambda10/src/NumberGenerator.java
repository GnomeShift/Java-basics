import java.util.*;
import java.util.function.Supplier;

public class NumberGenerator {

    public static void main(String[] args) {
        Random rnd = new Random();
        List<Integer> randomNumbers = new ArrayList<>();
        Supplier<Integer> supplier = () -> rnd.nextInt(100);

        for (int i = 0; i < 10; i++) {
            randomNumbers.add(supplier.get());
        }

        System.out.println(randomNumbers);
    }
}
