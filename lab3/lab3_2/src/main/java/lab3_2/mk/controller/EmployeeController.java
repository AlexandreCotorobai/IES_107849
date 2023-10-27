package lab3_2.mk.controller;

import lombok.AllArgsConstructor;
import lab3_2.mk.entity.Employee; // Import the Employee entity
import lab3_2.mk.service.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees") // Update the base URL
public class EmployeeController {

    private EmployeeService employeeService; // Update the service reference

    // Build create Employee REST API
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) { // Update method signature
        Employee savedEmployee = employeeService.createEmployee(employee); // Update method call
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build get employee by id REST API
    // http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) { // Update method signature
        Employee employee = employeeService.getEmployeeById(employeeId); // Update method call
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // Build Get All Employees REST API
    // http://localhost:8080/api/employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(name = "email", required = false) String email) { // Update method signature
        List<Employee> employees;
        if(email != null) {
            employees = employeeService.getEmployeeByEmail(email);
        } else {
            employees = employeeService.getAllEmployees();
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Build Update Employee REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/employees/1
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,
                                                  @RequestBody Employee employee) { // Update method signature
        employee.setId(employeeId);
        Employee updatedEmployee = employeeService.updateEmployee(employee); // Update method call
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) { // Update method signature
        employeeService.deleteEmployee(employeeId); // Update method call
        return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);
    }

}
