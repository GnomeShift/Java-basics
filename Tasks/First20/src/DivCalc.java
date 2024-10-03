public class DivCalc {

    public static void Div(int first, int second) {
        try {
            System.out.println(Math.divideExact(first, second));
        }
        catch (ArithmeticException e) {
            System.out.println("Сверхразум!");
        }
    }

    public static void main(String[] args) {
        Div(1, 2);
    }
}