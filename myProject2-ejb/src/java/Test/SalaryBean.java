/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 黑妹
 */
@Stateless
public class SalaryBean implements SalaryBeanRemote {
    @PersistenceContext
    private EntityManager em;
    Employee emp=new Employee();
    Salaries salary=new Salaries();
    
    /**
    * creating new entity in the database
    * @param value,empId  which is the name of employee
    */
    @Override
    public void createSalary(Double value, Integer empId) {
        salary.setAmount(value);
        emp = em.find(Employee.class, empId);
        if(emp != null) {
            salary.setEmp(emp);
            em.getTransaction().begin();
            em.persist(salary);
            em.getTransaction().commit();
        } 
    }
}
