package Application2.Aplication.dao;

import Aplication.dao.EmployeeDAO;
import Aplication.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for entitymanager
    private final EntityManager entityManager;

    // set up constructor injection

    public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> theQuery =
                currentSession.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Transactional(readOnly = true)
    @Override
    public Employee findById(int theId) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

        Employee theEmployee =
                currentSession.get(Employee.class, theId);

        return theEmployee;

    }

    @Transactional
    @Override
    public void save(Employee theEmployee) {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
		//save employe
        currentSession.saveOrUpdate(theEmployee);

        return theEmployee;
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery=
				currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId",theId);
		theQuery.executeUpdate();
        return null;
    }

}







