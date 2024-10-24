import java.util.ArrayList;

public class ArrayListCombine {
    ArrayList<String> list =  new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();

    public ArrayList<String> combineList(ArrayList<String> list, ArrayList<String> list2) {
        ArrayList<String> combined = new ArrayList<>();
        combined.addAll(list);
        combined.addAll(list2);
        return combined;
    }

    public static void main(String[] args) {
        ArrayListCombine lc = new ArrayListCombine();

        for (int i = 0; i < 5; i++) {
            lc.list.add("String " + i);
            lc.list2.add("String " + (6 + i));
        }
        System.out.println(lc.combineList(lc.list, lc.list2));
    }
}
