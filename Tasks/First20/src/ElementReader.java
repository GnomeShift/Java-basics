import java.util.*;

public class ElementReader {

    public static void ElementReader(ArrayList<int[]> list, int index) {
        try {
            System.out.println(Arrays.toString(list.get(index)));
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("А индекс-то за пределами массива");
        }
    }

    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();
        int[] array= {1, 2, 3, 4, 5};
        list.add(array);

        ElementReader(list, 0);
    }
}
