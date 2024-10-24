abstract class Transport {
    abstract void move();
}

class Car extends Transport {
    @Override
    void move() {
        System.out.println("Машина едет");
    }
}

class Bike extends Transport {
    @Override
    void move() {
        System.out.println("Велосипед едет");
    }
}

class Main3 {
    public static void main(String[] args) {
        Transport car = new Car();
        Transport bike = new Bike();

        car.move();
        bike.move();
    }
}
