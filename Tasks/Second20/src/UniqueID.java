public class UniqueID {
    private static int ID = 1;

    public static int generateID() {
        return ID++;
    }
}

class Main10 {
    public static void main(String[] args) {
        System.out.println(UniqueID.generateID());
        System.out.println(UniqueID.generateID());
        System.out.println(UniqueID.generateID());
    }
}