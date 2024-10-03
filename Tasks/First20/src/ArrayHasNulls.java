public class ArrayHasNulls {

    public static void ArrayHasNull(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                throw new IllegalArgumentException("Ноль попался");
            }
        }
        System.out.println("Нулей нет");
    }

    public static void main(String[] args) {
        ArrayHasNull(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
    }
}
