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
import report.Animal;
import report.MyException;
import report.Owner;
import report.Pet;

/**
 * 
 * This Class is the pet bean class which consists of six functions
 * for creating, removing, updating and reading pets
 * @author mehow
 * @version 2.0
 */

@Stateless
@LocalBean
public class PetBean {
    
    @PersistenceContext
    private EntityManager em;

    /**
     * This function is used to create a new pet
     * 
     * @param arg it is the name of the pet
     * @param date it is date of birth
     * @param animal it is the species of the pet
     * @param ownerID it is id of the owner
     * @throws report.MyException throws when date cannot be parsed correctly 
     */
    
    public void creatingPet(String arg, String date, Animal animal, int ownerID) throws MyException{
        try{
            Owner owner = em.find(Owner.class,ownerID);
            if(owner == null) {
                throw new MyException("Missing owner");
            }
            Pet pet = new Pet(arg, new Date(), animal);
            pet.setBirthDate(new SimpleDateFormat("yyyy").parse(date));
            em.persist(owner);
            pet.setOwner(owner);
            em.persist(pet);
        }catch (NullPointerException e){
            throw new MyException(e.getMessage());
        } catch (ParseException ex) {  
            throw new MyException("Incorrect date, the correct date format in yyyy");
        }
    }
    
    /**
     * This function is used to delete a pet
     * 
     * @param petID it is id of the pet
     * @throws report.MyException throws when there is no pet under the passed ID
     */
    
    public void removingPet(int petID) throws MyException{
        try{
            Pet pet = em.find(Pet.class, petID);
            if(pet == null) {
                throw new MyException("No pet under this ID");
            }
            em.remove(pet);
        }catch (NullPointerException e){
            throw new MyException(e.getMessage());
        } 
    
    }
    
    /**
     * This function is used to update a pet
     * 
     * @param name it is the name of the pet
     * @param petID it is id of the pet
     * @throws report.MyException throws when there is no pet under the passed ID
     */
    
    public void updatingPet(String name, int petID) throws MyException{
        try{
            Pet pet = em.find(Pet.class, petID);
            if(pet == null) {
                throw new MyException("No pet under this ID");
            }
            pet.setName(name);
            em.merge(pet);
        }catch (NullPointerException e){
            throw new MyException(e.getMessage());
        }  
    }
    
        /**
     * This function is used to read all pet
     * 
     * @return it displays all the results
     */
    
    public List readingPetAll(){
        return em.createNamedQuery("Pet.findAll").getResultList();
    }
    
    /**
     * This function is used to read all pets with specific name
     * 
     * @param arg it is a name or part of a name
     * @return it displays all the results
     */
    
    public List readingPetBy(String arg){
        return em.createNamedQuery("Pet.findByName").setParameter("xyz", arg+"%").getResultList();
    }
    
    
    /**
     * This function is used to read specific owner of specific pet
     * 
     * @param petID it is the id of the pet
     * @return it displays all the results
     * @throws report.MyException throws when there is no pet under the passed ID
     */
    
   
    public Owner findPetofOwner(int petID) throws MyException {
        Pet pet = em.find(Pet.class, petID);
        Root<Owner> root;
        Expression<String> petNames;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Owner> cq = cb.createQuery(Owner.class);
        root = cq.from(Owner.class);
        cq.select(root);
        if(pet == null) {
            throw new MyException("No such pet exists");
        }
        
        cq.where(cb.isMember(pet, root.<List<Pet>>get("pets")));
        return em.createQuery(cq).getResultList().get(0);
    }
}
