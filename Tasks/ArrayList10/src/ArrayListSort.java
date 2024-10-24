import java.util.*;

public class ArrayListSort {
    ArrayList<String> list = new ArrayList<String>();

    public void sortList(ArrayList<String> list) {
        Collections.sort(list);

        for (String item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        ArrayListSort als = new ArrayListSort();

        String[] items = {"Яблоко", "Банан", "Груша", "Апельсин", "Слива"};

        for (int i = 0; i < items.length; i++) {
            als.list.add(items[i]);
        }

        als.sortList(als.list);
    }
}
