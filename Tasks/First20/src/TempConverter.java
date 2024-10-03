public class TempConverter {

    public static void TempConverter(double celsius) {
        double result = celsius * 9 / 5 + 32;
        if (result < -459.67) {
            throw new ArithmeticException("Абсолютный ноль на барабане!");
        }
        else {
            System.out.println("По Фаренгейту у нас: " + result);
        }
    }

    public static void main(String[] args) {
        TempConverter(100);
    }
}
