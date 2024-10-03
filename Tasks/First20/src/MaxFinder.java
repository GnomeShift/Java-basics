import java.util.Random;

public class MaxFinder {

    public static void MaxFinder(int first, int second) {
        if (first == second) {
            throw new IllegalArgumentException("Ты зачем равные числа вводишь?");
        }
        else {
            System.out.println(Math.max(first, second));
        }
    }

    public static void main(String[] args) {
        Random rnd = new Random();

        MaxFinder(rnd.nextInt(100), rnd.nextInt(100));
    }
}