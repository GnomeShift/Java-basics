public class PowCalc {

    public static void PowCalc(int number, int pow) {
        if (pow < 0) {
            throw new ArithmeticException("Отрицательная степень передает привет");
        }
        System.out.println(Math.pow(number, pow));
    }

    public static void main(String[] args) {
        PowCalc(10, 2);
    }
}
