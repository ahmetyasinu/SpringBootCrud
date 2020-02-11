package Application2.Aplication.service;

import Application2.Aplication.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Application2.Aplication.entity.Employee> findAll();
    public Application2.Aplication.entity.Employee findById(int theId);
    public Application2.Aplication.entity.Employee save(Application2.Aplication.entity.Employee theEmployee);
    public Employee deleteById(int theId);
}
