package Collection_Framework_HandsOn.model;

import java.util.*;

public class Course {
    private String courseId, courseName, instructorName;
    private int capacity, credits;
    private TreeSet<Student> enrolledStudents = new TreeSet<>();
    private Queue<Student> waitlist = new LinkedList<>();

    public Course(String courseId, String courseName, String instructorName, int capacity, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.capacity = capacity;
        this.credits = credits;
    }

    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getInstructorName() { return instructorName; }
    public int getCapacity() { return capacity; }
    public int getCredits() { return credits; }
    public Set<Student> getEnrolledStudents() { return enrolledStudents; }
    public Queue<Student> getWaitlist() { return waitlist; }

    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }

    @Override
    public String toString() {
        return courseName + " (" + courseId + ")";
    }
}
