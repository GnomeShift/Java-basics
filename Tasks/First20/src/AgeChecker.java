public class AgeChecker {

    public static void CheckAge(int age) {
        if (age <= 0||age >= 150) {
            throw new IllegalArgumentException("Ты сверхчеловек?");
        }
        else {
            System.out.printf("Ваш возраст: %d лет", age);
        }
    }

    public static void main(String[] args) {
        CheckAge(20);
    }
}
