public class SqrtFinder {

    public static void SqrtFinder(double number, double pow) {
        if (number < 0) {
            throw new IllegalArgumentException("Как я корень из отрицательного числа считать буду?");
        }

        double sqrt = 1 / pow;
        System.out.println("Я все посчитал: " + Math.pow(number, sqrt));
    }

    public static void main(String[] args) {
        SqrtFinder(5, 3);
    }
}
