package lab3_2.mk.service; // Change the package name if necessary

import lab3_2.mk.entity.Employee; // Change User to Employee

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long employeeId);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long employeeId);

    List<Employee> getEmployeeByEmail(String email);
}
