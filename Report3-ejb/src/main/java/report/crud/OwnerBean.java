/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report.crud;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import report.Gender;
import report.MyException;
import report.Owner;
import report.Pet;

/**
 * 
 * This Class is the owner bean class which consists of six functions
 * for creating, removing, updating and reading owners
 * @author mehow
 * @version 2.0
 */ 

@Stateless
@LocalBean
public class OwnerBean {

    @PersistenceContext
    private EntityManager em;
    /**
     * This function is used to create a new owner
     * 
     * @param arg it is the name of the owner
     * @param date it is date of birth
     * @param gender it is the gender of the owner 
     * @throws report.MyException thrown when date cannot be parsed correctly 
     */
    
    public void creatingOwner(String arg, String date, Gender gender) throws MyException{
        try{
        Owner owner = new Owner(arg, new Date(), gender);
        owner.setBirthDate(new SimpleDateFormat("yyyy").parse(date));
        em.persist(owner);
        }catch (NullPointerException e){
            throw new MyException(e.getMessage());
        }catch (ParseException ex) {  
            throw new MyException("Incorrect date, the correct date format in yyyy");
        }
    }
    
    /**
     * This function is used to delete a owner
     * 
     * @param ownerID it is the id of the owner
     * @throws report.MyException throws when there is no owner under the passed ID
     */
    
    public void removingOwner(int ownerID) throws MyException{
        try{
            Owner owner = em.find(Owner.class,ownerID);
            if(owner == null) {
                throw new MyException("No owner under this ID");
            }
            em.remove(owner);
        }catch (NullPointerException e){
            throw new MyException(e.getMessage());
        }      
    }
    
    /**
     * This function is used to update a owner
     * 
     * @param name it is the name of the owner
     * @param ownerID it is the id of the owner
     * @throws report.MyException throws when there is no owner under the passed ID
     */
    
    public void updatingOwner(String name, int ownerID) throws MyException{
        try{
            Owner owner = em.find(Owner.class, ownerID);
            if(owner == null) {
                throw new MyException("No owner under this ID");
            }
            owner.setName(name);
            em.merge(owner);
        }catch (NullPointerException e){
            throw new MyException(e.getMessage());
        }  
    }
    
    /**
     * This function is used to read all owner
     * 
     * @return it displays all the results
     */
    
    public List readingOwnerAll(){
        return em.createNamedQuery("Owner.findAll").getResultList();
    }
    
    /**
     * This function is used to read all owners with specific name
     * 
     * @param arg it is a name or part of a name
     * @return it displays all the results
     */
    
    public List readingOwnerBy(String arg){
        return em.createNamedQuery("Owner.findByName").setParameter("xyz", arg+"%").getResultList();
    }
    
        /**
     * This function is used to read all pets of a specific owner
     * 
     * @param ownerID it is the id of the owner
     * @return it displays all the results
     * @throws report.MyException throws when there is no owner under the passed ID 
     */
    
    public List<Pet> findAllPetsOfOwner(int ownerID) throws MyException {
        Owner owner = em.find(Owner.class, ownerID);
        Expression<Owner> owners;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Pet> cq = cb.createQuery(Pet.class);
        Root<Pet> pets = cq.from(Pet.class);
        cq.select(pets);
        owners = pets.get("owner");
        if(owner == null) {
            throw new MyException("No such owner exists");
        }
        cq.where(cb.equal(owners, owner));
        return em.createQuery(cq).getResultList();
    }



}
