public class Animal2 {

    public void move() {}
}

class Fish extends Animal2 {
    @Override
    public void move() {
        System.out.println("Рыба плавает");
    }
}

class Bird extends Animal2 {
    @Override
    public void move() {
        System.out.println("Птица летает");
    }
}

class Dog2 extends Animal2 {
    @Override
    public void move() {
        System.out.println("Собака бегает");
    }
}

class Mai6 {
    public static void main(String[] args) {
        Fish fish = new Fish();
        fish.move();

        Bird bird = new Bird();
        bird.move();

        Dog2 dog2 = new Dog2();
        dog2.move();
    }
}