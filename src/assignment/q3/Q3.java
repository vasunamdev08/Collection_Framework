package assignment.q3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Q3 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "John Doe", "HR", 50000.0),
                new Employee(2, "Jane Smith", "IT", 60000.0),
                new Employee(3, "Sam Brown", "Finance", 55000.0),
                new Employee(4, "Lisa White", "IT", 70000.0),
                new Employee(5, "Tom Green", "HR", 52000.0)
        );

        Map<String, List<Employee>> mp = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        mp.forEach((department,employeeList)->{
            System.out.println("Department: " + department);
            employeeList.forEach(employee -> {
                System.out.println("Employee: " + employee.getName()+" - $"+employee.getSalary());
            });
        });
}

}
