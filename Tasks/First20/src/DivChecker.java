public class DivChecker {

    public static void DivChecker(double first, double second) {
        try {
            System.out.println(first / second);
        }
        catch (ArithmeticException e) {
            System.out.println("Сверхразум!");
        }
    }

    public static void main(String[] args) {
        DivChecker(1, 10);
    }
}
