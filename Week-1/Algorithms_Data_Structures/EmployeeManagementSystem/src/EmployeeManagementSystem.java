import java.util.Arrays;

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
    	if (count == employees.length) {
            System.out.println("Array is full, cannot add more employees.");
            return;
        }
        employees[count] = employee;
        count++;
    }

    // Search for an employee by ID
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and display all employees
    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by ID
    public void deleteEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        Employee emp1 = new Employee("E001", "Alice", "Manager", 70000);
        Employee emp2 = new Employee("E002", "Bob", "Developer", 50000);
        Employee emp3 = new Employee("E003", "Charlie", "Designer", 45000);

        ems.addEmployee(emp1);
        ems.addEmployee(emp2);
        ems.addEmployee(emp3);

        System.out.println("All employees:");
        ems.traverseEmployees();

        System.out.println("\nSearch for E002:");
        System.out.println(ems.searchEmployee("E002"));

        System.out.println("\nDelete E002:");
        ems.deleteEmployee("E002");

        System.out.println("\nAll employees after deletion:");
        ems.traverseEmployees();
    }
}