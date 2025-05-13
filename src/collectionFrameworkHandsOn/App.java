package collectionFrameworkHandsOn;

import collectionFrameworkHandsOn.service.RegistrationService;
import collectionFrameworkHandsOn.service.impl.RegistrationServiceImpl;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try{
            RegistrationService service = new RegistrationServiceImpl();
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- University Course Registration System ---");
                System.out.println("1. Register Student to Course");
                System.out.println("2. Drop Student from Course");
                System.out.println("3. List Students in a Course");
                System.out.println("4. List Students by Branch");
                System.out.println("5. List Courses (sorted)");
                System.out.println("6. List Courses (filtered)");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> service.registerStudentToCourse();
                    case 2 -> service.dropStudentFromCourse();
                    case 3 -> service.listStudentsInCourse();
                    case 4 -> service.listStudentsByBranch();
                    case 5 -> service.listCoursesSorted();
                    case 6 -> service.listCoursesFiltered();
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice!");
                }
            } while (choice != 0);
        }catch (Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("Thank you for using the University Course Registration System!");
        }
    }
}
