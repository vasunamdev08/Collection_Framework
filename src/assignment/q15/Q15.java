package assignment.q15;

import java.util.*;

public class Q15 {
    public static void main(String[] args) {
        // Student -> List of Subjects
        Map<String, List<String>> studentSubjects = new HashMap<>();

        // Sample data
        studentSubjects.put("Alice", Arrays.asList("Math", "Physics"));
        studentSubjects.put("Bob", Arrays.asList("Chemistry", "Math"));
        studentSubjects.put("Charlie", Arrays.asList("Physics", "Biology"));

        // Print subject allotments
        System.out.println("Subject Allotments:");
        for (Map.Entry<String, List<String>> entry : studentSubjects.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Reverse lookup: Who chose "Math"?
        String subjectToFind = "Math";
        List<String> studentsForSubject = reverseLookup(studentSubjects, subjectToFind);

        System.out.println("\nStudents who chose " + subjectToFind + ":");
        for (String student : studentsForSubject) {
            System.out.println(student);
        }
    }

    // Reverse lookup method
    public static List<String> reverseLookup(Map<String, List<String>> studentSubjects, String subject) {
        List<String> students = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : studentSubjects.entrySet()) {
            if (entry.getValue().contains(subject)) {
                students.add(entry.getKey());
            }
        }
        return students;
    }
}
