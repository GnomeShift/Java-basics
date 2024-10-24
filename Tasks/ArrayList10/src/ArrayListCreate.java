import java.util.*;

public class ArrayListCreate {
    public ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        ArrayListCreate lc = new ArrayListCreate();

        for (int i = 0; i < 5; i++) {
            lc.list.add("String " + i);
        }

        System.out.println("В ArrayList: " + lc.list);
    }
}
