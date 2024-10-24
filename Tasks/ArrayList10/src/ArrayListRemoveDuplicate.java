import java.util.*;

public class ArrayListRemoveDuplicate {
    ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> removeDuplicate(ArrayList<String> list) {
        Set<String> unique = new HashSet<>(list);
        ArrayList<String> result = new ArrayList<>(unique);
        return result;
    }

    public static void main(String[] args) {
        ArrayListRemoveDuplicate lrd = new ArrayListRemoveDuplicate();

        for (int i = 0; i < 5; i++) {
            lrd.list.add("String " + i);
        }

        for (int i = 0; i < 5; i++) {
            lrd.list.add("String " + i);
        }

        System.out.println(lrd.removeDuplicate(lrd.list));
    }
}
