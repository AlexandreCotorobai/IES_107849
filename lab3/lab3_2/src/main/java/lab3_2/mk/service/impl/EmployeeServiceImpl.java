package lab3_2.mk.service.impl;

import lombok.AllArgsConstructor;
import lab3_2.mk.entity.Employee; // Change User to Employee
import lab3_2.mk.repository.EmployeeRepository;
import lab3_2.mk.service.EmployeeService; // Change UserService to EmployeeService
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService { // Change UserService to EmployeeService

    private EmployeeRepository employeeRepository; // Change UserRepository to EmployeeRepository

    @Override
    public Employee createEmployee(Employee employee) { // Change User to Employee
        return employeeRepository.save(employee); // Change userRepository to employeeRepository
    }

    @Override
    public Employee getEmployeeById(Long employeeId) { // Change User to Employee
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId); // Change User to Employee
        return optionalEmployee.get(); // Change User to Employee
    }

    @Override
    public List<Employee> getAllEmployees() { // Change User to Employee
        return employeeRepository.findAll(); // Change userRepository to employeeRepository
    }

    @Override
    public Employee updateEmployee(Employee employee) { // Change User to Employee
        Employee existingEmployee = employeeRepository.findById(employee.getId()).get(); // Change User to Employee
        existingEmployee.setFirstName(employee.getFirstName()); // Change User to Employee
        existingEmployee.setLastName(employee.getLastName()); // Change User to Employee
        existingEmployee.setEmail(employee.getEmail()); // Change User to Employee
        Employee updatedEmployee = employeeRepository.save(existingEmployee); // Change User to Employee
        return updatedEmployee; // Change User to Employee
    }

    @Override
    public void deleteEmployee(Long employeeId) { // Change User to Employee
        employeeRepository.deleteById(employeeId); // Change userRepository to employeeRepository
    }

    @Override
    public List<Employee> getEmployeeByEmail(String email) {
        
        return employeeRepository.findByEmail(email);
    }
}
