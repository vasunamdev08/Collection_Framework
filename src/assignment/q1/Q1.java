package assignment.q1;

import java.util.ArrayList;
import java.util.Comparator;

import static java.util.stream.Collectors.groupingBy;

public class Q1 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
//    add 15 students to the list
        students.add(new Student(1, "John", 20, "A", "CS"));
        students.add(new Student(2, "Jane", 21, "B", "IT"));
        students.add(new Student(3, "Jack", 22, "C", "ME"));
        students.add(new Student(4, "Jill", 23, "D", "CE"));
        students.add(new Student(5, "Jim", 24, "E", "EE"));
        students.add(new Student(6, "Joe", 25, "F", "CS"));
        students.add(new Student(7, "Jerry", 26, "G", "IT"));
        students.add(new Student(8, "Jasmine", 27, "H", "ME"));
        students.add(new Student(9, "Jordan", 28, "I", "CE"));
        students.add(new Student(10, "Jade", 29, "J", "EE"));
        students.add(new Student(11, "Jasper", 30, "K", "CS"));
        students.add(new Student(12, "Juno", 31, "L", "IT"));
        students.add(new Student(13, "Jett", 32, "M", "ME"));
        students.add(new Student(14, "Jade", 33, "N", "CE"));
        students.add(new Student(15, "Jules", 34, "O", "EE"));

        students.stream().sorted(Comparator.comparing(Student::getBranch).
                thenComparing(Student::getGrade)).
                forEach(
                student -> System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Age: " + student.getAge() + ", Grade: " + student.getGrade() + ", Branch: " + student.getBranch())
        );
        students.stream().collect(groupingBy(Student::getBranch)).forEach(
                (branch, studentList) -> {
                    System.out.println("Branch: " + branch);
                    studentList.stream().forEach(System.out::print);
                    System.out.println();
                });

    }
}
