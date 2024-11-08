import java.util.*;

public class WordsFinder {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Яблоко", "Груша", "Апельсин", "Банан");
        List<String> filtered = words.stream().filter(word -> word.length() > 5).toList();
        System.out.println(filtered);
    }
}
