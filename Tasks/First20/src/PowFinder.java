public class PowFinder {

    public static void powFinder(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным");
        }
        else {
            System.out.println(Math.sqrt(number));
        }
    }

    public static void main(String[] args) {
        powFinder(100);
    }
}
