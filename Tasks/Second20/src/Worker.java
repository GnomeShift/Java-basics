class Worker extends Person {
    double salary;

    Worker(String name, int age, String gender, int salary) {
        super(name, age, gender);
        this.salary = salary;
    }
}

class Manager extends Worker {
    Worker[] subordinate;

    Manager(String name, int age, String gender, int salary, Worker[] subordinate) {
        super(name, age, gender, salary);
        this.subordinate = subordinate;
    }
}