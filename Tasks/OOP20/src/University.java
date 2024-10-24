import java.util.*;

public class University {
    List<Student> students;

    public University() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName));
    }

    public void sortByGrade() {
        students.sort(Comparator.comparing(Student::getGrade).reversed()); // Сортировка по убыванию
    }

    List<Student> filterByGrade(int minGrade) {
        List<Student> filtered = new ArrayList<>();
        for (Student student : students) {
            if (student.getGrade() >= minGrade) {
                filtered.add(student);
            }
        }
        return filtered;
    }

    public void getStudents() {
        for (Student student : students) {
            System.out.println(student.getName() + ", " + student.getGrade());
        }
    }
}

class Student {
    String name;
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}

class Main7 {
    public static void main(String[] args) {
        University university = new University();

        Student student1 = new Student("Иван", 1);
        Student student2 = new Student("Сергей", 2);

        university.addStudent(student1);
        university.addStudent(student2);

        university.getStudents();
    }
}
