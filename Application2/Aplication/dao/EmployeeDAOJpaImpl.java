package Application2.Aplication.dao;

import Aplication.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private final EntityManager entityManager;

    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Application2.Aplication.entity.Employee> findAll() {
        TypedQuery<Application2.Aplication.entity.Employee> theQuery=
                entityManager.createQuery("from Employee", Application2.Aplication.entity.Employee.class);
        List<Application2.Aplication.entity.Employee> employees = theQuery.getResultList();

        return employees;


    }

    @Override
    public Application2.Aplication.entity.Employee findById(int theId) {
            Application2.Aplication.entity.Employee theEmployee=entityManager.find(Application2.Aplication.entity.Employee.class,theId);
            return theEmployee;
    }

    @Override
    public void save(Application2.Aplication.entity.Employee theEmployee) {
        Application2.Aplication.entity.Employee dbEmployee=entityManager.merge(theEmployee);
        theEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int theId) {
        Query theQuery=entityManager.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId",theId);
        theQuery.executeUpdate();
    }
}
