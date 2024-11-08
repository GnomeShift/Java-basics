import java.util.*;

public class ACounter {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Яблоко", "Груша", "Апельсин", "Банан");
        words.forEach(word -> {
            long count = word.chars().filter(c -> c == 'а').count();
            System.out.println(word + ": " + count);
        });
    }
}
