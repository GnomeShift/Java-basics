import java.util.ArrayList;

public class ArrayListReverse {
    ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        ArrayListReverse lr = new ArrayListReverse();

        String[] items = {"Яблоко", "Банан", "Груша", "Апельсин", "Слива"};

        for (int i = 0; i < items.length; i++) {
            lr.list.add(items[i]);
        }

        System.out.println(lr.list.reversed());
    }
}
