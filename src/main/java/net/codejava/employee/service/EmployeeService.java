package net.codejava.employee.service;

import net.codejava.Product;
import net.codejava.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> listAll();
    void save(Employee employee);
    Employee get(Long id);
    void delete(Long id);
    Employee findByName(String findByName);
}
