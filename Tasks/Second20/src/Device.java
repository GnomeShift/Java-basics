public class Device {
    private String brand;

    public Device(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void turnOn() {
        System.out.println(getBrand() + " включен");
    }

    public void turnOff() {
        System.out.println(getBrand() + " отключен");
    }
}

class Smartphone extends Device {
    public Smartphone(String brand) {
        super(brand);
    }

    public void takePhoto() {
        System.out.println(getBrand() + " сфоткал");
    }

    public void makeCall() {
        System.out.println(getBrand() + " начал звонок");
    }
}

class Laptop extends Device {
    public Laptop(String brand) {
        super(brand);
    }

    public void runSteam() {
        System.out.println(getBrand() + " запустил Steam");
    }

    public void runPhotoshop() {
        System.out.println(getBrand() + " запустил Photoshop");
    }
}

class Main16 {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone("Samsung");
        Laptop laptop = new Laptop("Asus");

        phone.turnOn();
        phone.makeCall();
        phone.turnOff();
        laptop.turnOn();
        laptop.runPhotoshop();
        laptop.turnOff();
    }
}
