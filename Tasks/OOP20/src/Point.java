public class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Rectangle2 {
    Point topLeft;
    Point bottomRight;

    Rectangle2(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public int getArea() {
        return (bottomRight.x - topLeft.x) * (bottomRight.y - topLeft.y);
    }
}

class Main11 {
    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(20, 30);
        Rectangle2 r1 = new Rectangle2(p1, p2);
        System.out.println(r1.getArea());
    }
}
