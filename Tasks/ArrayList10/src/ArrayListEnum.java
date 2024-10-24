import java.util.ArrayList;

public class ArrayListEnum {
    ArrayList<Integer> list = new ArrayList<>();

    public void increaseList(int number) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + number);
        }
    }

    public static void main(String[] args) {
        ArrayListEnum le = new ArrayListEnum();

        for (int i = 0; i < 5; i++) {
            le.list.add(i);
        }

        le.increaseList(2);
        System.out.println("Измененный ArrayList: " + le.list);
    }
}
