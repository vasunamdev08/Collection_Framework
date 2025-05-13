package collectionFrameworkHandsOn.service.impl;

import collectionFrameworkHandsOn.model.Course;
import collectionFrameworkHandsOn.model.Student;
import collectionFrameworkHandsOn.service.RegistrationService;

import java.util.*;
import java.util.stream.Collectors;

public class RegistrationServiceImpl implements RegistrationService {
    private final Map<String, Course> courseMap = new HashMap<>();
    private final Map<String, Student> studentMap = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public RegistrationServiceImpl() {
        seedData();
    }

    private void seedData() {
        // Sample students
        studentMap.put("S101", new Student("S101", "Alice", "alice@example.com", "2", "CSE"));
        studentMap.put("S102", new Student("S102", "Bob", "bob@example.com", "1", "ECE"));
        studentMap.put("S103", new Student("S103", "Charlie", "charlie@example.com", "3", "CSE"));

        // Sample courses
        courseMap.put("CS101", new Course("CS101", "Data Structures", "Prof. Rao", 2, 4));
        courseMap.put("EE201", new Course("EE201", "Circuits", "Dr. Mehta", 1, 3));
    }

    @Override
    public void registerStudentToCourse() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        Student student = studentMap.get(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        Course course = courseMap.get(courseId);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        if (course.getEnrolledStudents().contains(student)) {
            System.out.println("Student already enrolled.");
        } else if (course.getWaitlist().contains(student)) {
            System.out.println("Student is already waitlisted.");
        } else if (!course.isFull()) {
            course.getEnrolledStudents().add(student);
            System.out.println("Student enrolled successfully.");
        } else {
            course.getWaitlist().offer(student);
            System.out.println("Course full. Student added to waitlist.");
        }
    }

    @Override
    public void dropStudentFromCourse() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        Student student = studentMap.get(studentId);

        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        Course course = courseMap.get(courseId);

        if (student == null || course == null) {
            System.out.println("Invalid Student or Course ID.");
            return;
        }

        if (course.getEnrolledStudents().remove(student)) {
            System.out.println("Student dropped from course.");

            if (!course.getWaitlist().isEmpty()) {
                Student next = course.getWaitlist().poll();
                course.getEnrolledStudents().add(next);
                System.out.println("Promoted waitlisted student: " + next.getName());
            }
        } else if (course.getWaitlist().remove(student)) {
            System.out.println("Student removed from waitlist.");
        } else {
            System.out.println("Student not enrolled or waitlisted in this course.");
        }
    }

    @Override
    public void listStudentsInCourse() {
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        Course course = courseMap.get(courseId);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("Students enrolled in " + course.getCourseName() + ":");
        for (Student s : course.getEnrolledStudents()) {
            System.out.println("- " + s.getName() + " (" + s.getId() + ")");
        }
    }

    @Override
    public void listStudentsByBranch() {
        System.out.print("Enter Branch: ");
        String branch = scanner.nextLine().trim();

        Set<Student> result = new HashSet<>();
        for (Course course : courseMap.values()) {
            for (Student s : course.getEnrolledStudents()) {
                if (s.getBranch().equalsIgnoreCase(branch)) {
                    result.add(s);
                }
            }
        }

        if (result.isEmpty()) {
            System.out.println("No students found for branch: " + branch);
        } else {
            System.out.println("Students in branch " + branch + ":");
            result.stream()
                    .sorted(Comparator.comparing(Student::getName))
                    .forEach(s -> System.out.println("- " + s.getName() + " (" + s.getId() + ")"));
        }
    }

    @Override
    public void listCoursesSorted() {
        List<Course> sorted = courseMap.values().stream()
                .sorted(Comparator.comparingInt((Course c) -> c.getEnrolledStudents().size()).reversed())
                .collect(Collectors.toList());

        System.out.println("Courses sorted by enrollment:");
        for (Course c : sorted) {
            System.out.println(c.getCourseId() + ": " + c.getCourseName() + " (" + c.getEnrolledStudents().size() + " enrolled)");
        }
    }

    @Override
    public void listCoursesFiltered() {
        System.out.println("Filter by: 1. Credits  2. Instructor");
        int option = Integer.parseInt(scanner.nextLine());

        if (option == 1) {
            System.out.print("Enter credits: ");
            int credits = Integer.parseInt(scanner.nextLine());
            courseMap.values().stream()
                    .filter(c -> c.getCredits() == credits)
                    .forEach(c -> System.out.println(c.getCourseId() + ": " + c.getCourseName()));
        } else if (option == 2) {
            System.out.print("Enter instructor name: ");
            String instructor = scanner.nextLine();
            courseMap.values().stream()
                    .filter(c -> c.getInstructorName().equalsIgnoreCase(instructor))
                    .forEach(c -> System.out.println(c.getCourseId() + ": " + c.getCourseName()));
        } else {
            System.out.println("Invalid option.");
        }
    }
}
