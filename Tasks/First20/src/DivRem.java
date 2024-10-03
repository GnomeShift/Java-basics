public class DivRem {

    public static void DivRem(int first, int second) {
        try {
            int result = first / second;
            System.out.println(result);
        }
        catch (ArithmeticException e) {
            System.out.println("Сверхразум!");
        }
    }

    public static void main(String[] args) {
        DivRem(10, 2);
    }
}
