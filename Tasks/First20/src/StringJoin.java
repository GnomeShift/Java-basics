public class StringJoin {

    public static void StringJoin(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("Я нашел null!!");
        }
        System.out.println(String.join(" ", str, str2));
    }

    public static void main(String[] args) {
        StringJoin("Строка 1", "Строка 2");
    }
}
