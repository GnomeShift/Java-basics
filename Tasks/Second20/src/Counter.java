public class Counter {
    private static int count = 0;

    Counter() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}

class Main4 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        System.out.println(Counter.getCount());
    }
}