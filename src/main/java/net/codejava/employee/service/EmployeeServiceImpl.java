package net.codejava.employee.service;

import net.codejava.employee.model.Employee;
import net.codejava.employee.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
       employeeRepository.save(employee);
    }

    @Override
    public Employee get(Long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
             employeeRepository.deleteById(id);
    }

    @Override
    public Employee findByName(String findByName) {
        return employeeRepository.findByFirstName(findByName);
    }
}
