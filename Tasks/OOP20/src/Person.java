import java.util.*;

public class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static class PersonManager {
        private List<Person> persons;

        public PersonManager() {
            persons = new ArrayList<>();
        }

        public void addPerson(Person person) {
            persons.add(person);
        }

        public void getPerson() {
            for (Person person : persons) {
                System.out.println("Имя: " + person.getName() + "\nВозраст: " + person.getAge() + "\nПол: " + person.getGender());
            }
        }

    }

    public static void main(String[] args) {
        Person first = new Person("Арсений", 20, "Мужской");
        Person second = new Person("Дмитрий", 21, "Мужской");

        PersonManager manager = new PersonManager();
        manager.addPerson(first);
        manager.addPerson(second);

        System.out.println("Список людей: ");
        manager.getPerson();
    }
}