package net.codejava.employee.repo;

import net.codejava.Product;
import net.codejava.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long > {
    Employee findByFirstName(String firsName);
} 
