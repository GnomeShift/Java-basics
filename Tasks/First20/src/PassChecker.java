public class PassChecker {

    public static void PassChecker(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Я отправил брату в Китай твой пароль");
        }
        System.out.println("Длинный пароль, да");
    }

    public static void main(String[] args) {
        PassChecker("1234567890");
    }
}
