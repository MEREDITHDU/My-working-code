package Test;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *class EmployeeBean,implements the interface of EmployeeBeanRemote
 * @author 黑妹
 * @version 1.0
 */
@Stateless
public class EmployeeBean implements EmployeeBeanRemote {
    @PersistenceContext
    private EntityManager em;
    Employee emp=new Employee();
    Salaries salary=new Salaries();

    @Override
    /**
    * creating new entity in the database
    * @param name which is the name of employee
    */
    public void createEmployee(String name) {
        em.getTransaction().begin();
        emp.setName(name);
        em.persist(emp);
        em.getTransaction().commit();
    }
    /*
    * read the entities from database
    */
    public void read(){
        if(emp.getId()==null){
            em.persist(emp);
            em.persist(salary);
        }else {
         emp=em.find(Employee.class, 1);
        }
        //System.out.println("0:"+em.createQuery("Select e from Employee e").getResultList());
    }
    
    /*
    *update entities from database
    *@param name which is the name of employee
    */
    public void update(String name){
        if(emp!=null){
         em.getTransaction().begin();
         em.merge(emp);
         em.getTransaction().commit();
        }else{
            em.getTransaction().begin();
            emp.setName(name);
            em.persist(emp);
            salary.setEmp(emp);
            em.persist(salary);
            em.getTransaction().commit();
        }
    }
    /*
    *delete entities from database
    */
    public void delete(){
        if(emp!=null){
        em.getTransaction().begin();
        em.remove(emp);
        em.getTransaction().commit();
        }else{
            em.getTransaction().begin();
            em.persist(emp);
            salary.setEmp(emp);
            em.persist(salary);
            em.getTransaction().commit();
        }      
    }
}
