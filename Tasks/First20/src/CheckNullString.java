public class CheckNullString {

    public static void CheckNullString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Сверхразум ввел null");
        }
    }

    public static void main(String[] args) {
        CheckNullString("Строка");
    }
}
