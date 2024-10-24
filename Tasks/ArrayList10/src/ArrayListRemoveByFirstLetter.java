import java.util.ArrayList;

public class ArrayListRemoveByFirstLetter {
    ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> deleteStartsWithLetter(ArrayList<String> list, String letter) {
        ArrayList<String> result = new ArrayList<>();

        for (String element : list) {
            if (!element.startsWith(letter)) {
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayListRemoveByFirstLetter ldl = new ArrayListRemoveByFirstLetter();

        String[] letters = {"A", "B", "C", "D", "E", "F"};

        for (int i = 0; i < letters.length; i++) {
            ldl.list.add(letters[i] + "BC");
        }

        System.out.println(ldl.deleteStartsWithLetter(ldl.list, "A"));
    }
}
