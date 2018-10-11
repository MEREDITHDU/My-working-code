package javaapplication1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


/**
 *
 * @author บฺรร
 */
public class Main {
    
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("JavaApplication1PU").createEntityManager();
        Students student=new Students("Qilin",new Date(),StudentType.FULL_TIME);
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        System.out.println("1:"+em.find(Students.class, 1));
         System.out.println("2:"+em.createQuery("SELECT s FROM Students s").getResultList());
         System.out.println("3:"+em.createQuery("SELECT s FROM Students s where s.name like 'To%'").getResultList());
         //System.out.println("4:"+em.createQuery("SELECT s FROM Students s where s.name like 'To%'").getSingleResult());
        System.out.println("5:"+em.createNamedQuery("Students.findAll").getResultList());
        System.out.println("6:"+em.createNamedQuery("Students.findByName").setParameter("xyz", "To%").setMaxResults(2).setFirstResult(3).getResultList());
        System.out.println("7:"+em.createQuery(createCriteriaQuery(em,null,StudentType.PART_TIME)).getResultList());
        Students stud=em.find(Students.class, 1);
        stud.setName("Qilin");
        em.getTransaction().begin();
        em.merge(stud);
        em.getTransaction().commit();
        System.out.println("8:"+em.createQuery("SELECT s FROM Students s").getResultList());
        em.getTransaction().begin();
        em.remove(stud);
        em.getTransaction().commit();
        System.out.println("9:"+em.createQuery("SELECT s FROM Students s").getResultList());
        em.close();
    }
    
    private static CriteriaQuery<Students>
            createCriteriaQuery(EntityManager em,
                    String name,StudentType studentType){
                    
                    Expression expr;
            Root<Students> queryRoot;
            List<Predicate> predicates =new ArrayList<>();
            
            CriteriaBuilder builder=em.getCriteriaBuilder();
            CriteriaQuery<Students> queryDefinition =builder.createQuery(Students.class);
            queryRoot=queryDefinition.from(Students.class);
            queryDefinition.select(queryRoot);
            if(name!=null){
                expr=queryRoot.get("name");
                predicates.add(builder.like(expr, name+"s"));
            }
            if(studentType!=null){
                expr=queryRoot.get("studentType");
                predicates.add(builder.equal(expr,studentType));
            }
           if(!predicates.isEmpty()){
               queryDefinition.where(builder.and(predicates.toArray(
                       new Predicate[predicates.size()])));
           }
           
           return queryDefinition;
            }
}
