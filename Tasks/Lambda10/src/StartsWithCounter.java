import java.util.*;

public class StartsWithCounter {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("яблоко", "груша", "апельсин", "банан");
        char letter = 'я';
        long count = words.stream().filter(word -> word.startsWith(String.valueOf(letter))).count();

        System.out.println("Начинающихся с " + letter + ": " + count);
    }
}
