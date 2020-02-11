package Aplication.dao;

import Aplication.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private final EntityManager entityManager;

    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        TypedQuery<Aplication.entity.Employee> theQuery=
                entityManager.createQuery("from Employee", Aplication.entity.Employee.class);
        List<Aplication.entity.Employee> employees = theQuery.getResultList();

        return employees;


    }

    @Override
    public Employee findById(int theId) {
           Aplication.entity.Employee theEmployee=entityManager.find(Aplication.entity.Employee.class,theId);
            return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Aplication.entity.Employee dbEmployee=entityManager.merge(theEmployee);
        theEmployee.setId(dbEmployee.getId());
        return dbEmployee;
    }

    @Override
    public Employee deleteById(int theId) {
        Query theQuery=entityManager.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId",theId);
        theQuery.executeUpdate();
        return null;
    }
}
