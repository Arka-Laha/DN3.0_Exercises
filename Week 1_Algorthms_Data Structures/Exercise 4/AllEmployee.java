import java.util.*;

// AllEmployee class
class AllEmployee {
    private ArrayList<Employee> employees;

    // Constructor
    public AllEmployee() {
        this.employees = new ArrayList<>();
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Method to search for an employee by ID
    public Employee searchEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    // Method to traverse all employees
    public void traverseEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // Method to delete an employee by ID
    public boolean deleteEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }
}
