abstract class Shape {
    double area = 0;

    abstract double getArea();
}

class Circle extends Shape {
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length;
    Rectangle(double length) {
        this.length = length;
    }

    @Override
    double getArea() {
        return length * length;
    }
}

class Main5 {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        System.out.println(circle.getArea());
        Shape rectangle = new Rectangle(10);
        System.out.println(rectangle.getArea());
    }
}