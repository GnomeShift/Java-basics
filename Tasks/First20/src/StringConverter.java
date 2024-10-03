public class StringConverter {

    public static void Converter(String str) {
        try {
            Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            System.out.println("Невозможно преобразовать в число");
            System.exit(-1);
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        Converter("abc");
    }
}
