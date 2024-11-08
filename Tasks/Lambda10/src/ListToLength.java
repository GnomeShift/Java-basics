import java.util.*;

public class ListToLength {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("S", "St", "Str", "Stri", "Strin", "String");
        List<String> lengths = list.stream().map(string -> String.valueOf(string.length())).toList();
        System.out.println(lengths);
    }
}
