public class FindElementInArray {

    public static void ArrayHasElement(int[] array, int element) {
        boolean found = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                System.out.println("Элемент найден!!");
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("В следущий раз укажи что-то существующее");
        }
    }

    public static void main(String[] args) {
        ArrayHasElement(new int[]{1, 2, 3, 4, 5}, 4);
    }
}
