import java.util.ArrayList;

public class ArrayListFind {
    ArrayList<String> list =  new ArrayList<>();

    public void findElement(String element) {
        if (list.contains(element)) {
            System.out.println("Индекс элемента " + element + " в списке: " + list.indexOf(element));
        }
        else {
            System.out.println("Нет такого в списке!");
        }
    }

    public static void main(String[] args) {
        ArrayListFind lf = new ArrayListFind();

        for (int i = 0; i < 3; i++) {
            lf.list.add("String " + i);
        }

        lf.findElement("String 2");
    }
}
