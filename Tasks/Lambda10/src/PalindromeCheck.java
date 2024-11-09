import java.util.*;

public class PalindromeCheck {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("шалаш", "дом", "оно", "кот", "казак", "топот");
        List<String> palindromes = new ArrayList<>();

        words.stream().filter(word -> {
            String reversed = new StringBuilder(word).reverse().toString();
            return word.equals(reversed);
        }).forEach(palindromes::add);

        System.out.println(palindromes);
    }
}
