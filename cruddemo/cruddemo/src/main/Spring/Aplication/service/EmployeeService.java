package Aplication.service;

import Aplication.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int theId);
    public Employee save(Employee theEmployee);
    public Employee deleteById(int theId);
}
