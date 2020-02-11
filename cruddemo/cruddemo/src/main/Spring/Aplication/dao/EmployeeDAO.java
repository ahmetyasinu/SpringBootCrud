package Aplication.dao;

import Aplication.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

	public List<Employee> findAll();
	public Employee findById(int theId);
	public Employee save(Employee theEmployee);
	public Employee deleteById(int theId);
		
}
