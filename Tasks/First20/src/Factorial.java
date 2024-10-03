public class Factorial {

    public static double factorial(double number) {
        if (number == 0) {
            System.out.println("1");
            return 1;
        }
        else if (number < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не существует!!");
        }
        else {
            try {
                return number * factorial(number - 1);
            } catch (RuntimeException exc) {
                System.out.printf("Ошибка: %s", exc.getMessage());
                return Double.NaN;
            }
        }
    }

    public static void main(String[] args) {
        factorial(100);
    }
}
