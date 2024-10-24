public interface Animal {
    void makeSound();
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Гав");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Мяу");
    }
}

class Cow implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Му");
    }
}

class Main2 {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Cow()};
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
