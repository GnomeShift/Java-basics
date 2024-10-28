public class LYChecker {

    public static boolean isLY(int year) {
        if (year % 4 != 0) {
            return false;
        }
        else if (year % 100 == 0 && year % 400 != 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public static void main(String[] args) {
        int year = 2024;

        if (isLY(year)) {
            System.out.println(year + " - високосный");
        }
        else {
            System.out.println(year + " - не високосный");
        }
    }
}