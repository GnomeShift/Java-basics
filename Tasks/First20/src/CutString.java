public class CutString {

    public static void StringCutter(String str, int cutPos) {
        if (cutPos > str.length()) {
            throw new StringIndexOutOfBoundsException("Как я обрезать буду, если позиция больше длины строки?");
        }
        System.out.println("Обрезал: " + str.substring(0, cutPos));
    }

    public static void main(String[] args) {
        StringCutter("Строка для обрезки", 8);
    }
}
