package lab3_2.mk.repository; // Change the package name if necessary

import lab3_2.mk.entity.Employee; // Change User to Employee

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // No need to add any additional methods here unless required
    List<Employee> findByEmail(String lastName);
}
