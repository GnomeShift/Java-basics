import java.util.ArrayList;

public class ArrayListRemove {
    ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        ArrayListRemove ld = new ArrayListRemove();

        for (int i = 0; i < 10; i++) {
            ld.list.add(i);
        }

        ld.list.remove(3);
        System.out.println(ld.list);
    }
}
