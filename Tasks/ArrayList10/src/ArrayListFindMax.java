import java.util.ArrayList;

public class ArrayListFindMax {
    ArrayList<Integer> list =  new ArrayList<>();

    public static void main(String[] args) {
        ArrayListFindMax lfm = new ArrayListFindMax();

        for (int i = 0; i < 5; i++) {
            lfm.list.add(i);
        }

        int max = lfm.list.getFirst();
        for (int i = 0; i < lfm.list.size(); i++) {
            if (lfm.list.get(i) > max) {
                max = lfm.list.get(i);
            }
        }

        System.out.println("Максимальный элемент: " + max);
    }
}
