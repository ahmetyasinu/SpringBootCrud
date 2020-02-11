package Byau.Thymeleaf.dao;


import Byau.Thymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //add a method short asc lastname
    public List<Employee> findAllByOrderByLastNameAsc();

    // that's it ... no need to write any code LOL!

}
