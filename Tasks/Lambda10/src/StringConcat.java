import java.util.*;

public class StringConcat {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("яблоко", "груша", "апельсин", "банан");
        String str = words.stream().reduce("", (acc, word) -> acc.isEmpty() ? word : acc + ", " + word);

        System.out.println(str);
    }
}
