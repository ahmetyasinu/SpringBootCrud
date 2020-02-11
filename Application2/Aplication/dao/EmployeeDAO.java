package Application2.Aplication.dao;

import Application2.Aplication.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

	public List<Application2.Aplication.entity.Employee> findAll();
	public Application2.Aplication.entity.Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
		
}
