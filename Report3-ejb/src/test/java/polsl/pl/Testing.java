/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.pl;

import static java.lang.Integer.parseInt;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import report.Animal;
import report.Gender;
import report.MyException;
import report.Owner;
import report.Pet;
import report.crud.OwnerBean;
import report.crud.PetBean;

/**
 * 
 * This Class is the Test class which has multiple functions
 * to manage the testing
 * @author mehow
 * @version 3.0
 */
public class Testing {


    /**
     * Object of OwnerBean used for testing
     */
    private static OwnerBean ownerBean;

    /**
     * Object of PetBean used for testing
     */
    private static PetBean petBean;
    

    private static Properties properties;
    
    /**
     * This is the function which prepares the database
     */
    
    @BeforeClass
    public static void init(){
        properties = new Properties();
        
        properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.apache.openejb.client.LocalInitialContextFactory");
        properties.put("Lab-PU", "new://Resource?type=DataSource");
        properties.put("Lab-PU.UserName", "root");
        properties.put("Lab-PU.Password", "root");
        properties.put("Lab-PU.JtaManaged", "true");
        properties.put("Lab-PU.JdbcDriver", "com.mysql.jdbc.Driver");
        properties.put("Lab-PU.JdbcUrl", "jdbc:mysql://localhost/lab?characterEncoding=utf8");
        try {
            petBean = (PetBean) new InitialContext(properties).lookup("PetBeanLocalBean");
            ownerBean = (OwnerBean) new InitialContext(properties).lookup("OwnerBeanLocalBean");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * This is the function which prepares the testing
     * @throws report.MyException
     */

    
    @Before
    public void before() throws MyException{
        
        for (Iterator it = ownerBean.readingOwnerAll().iterator(); it.hasNext();) {
            Owner owner = (Owner) it.next();
            ownerBean.removingOwner(owner.getId());
        }
        for (Iterator it = petBean.readingPetAll().iterator(); it.hasNext();) {
            Pet pet = (Pet) it.next();
            petBean.removingPet(pet.getId());
        }
        for(int i=1;i<=5;i++){
            ownerBean.creatingOwner("owner", Integer.toString(Calendar.getInstance().get(Calendar.YEAR)-parseInt("20")), Gender.MALE);
            petBean.creatingPet("pet", Integer.toString(Calendar.getInstance().get(Calendar.YEAR)-parseInt("1")), Animal.CAT, i);
        }
    }
    
    
    /**
     * This is the function which tests reading.
     * @throws report.MyException
     */
    
    
    @Test
    public void reading() throws MyException {
        assertEquals("There should be five owners", 5, ownerBean.readingOwnerAll().size());
        assertEquals("There should be five pets", 5, petBean.readingPetAll().size());
        ownerBean.creatingOwner("owner", Integer.toString(Calendar.getInstance().get(Calendar.YEAR)-parseInt("20")), Gender.MALE);
        petBean.creatingPet("pet", Integer.toString(Calendar.getInstance().get(Calendar.YEAR)-parseInt("1")), Animal.CAT, 6);
        assertEquals("There should be six owners", 6, ownerBean.readingOwnerAll().size());
        assertEquals("There should be six pets", 6, petBean.readingPetAll().size());
        assertNotNull("There should be a pet for owner with id 6", ownerBean.findAllPetsOfOwner(6));
        assertNotNull("There should be an owner for pet with id 6", petBean.findPetofOwner(6));      
    }

    /**
     * This is the function which tests updating.
     * @throws report.MyException
     */
    @Test
    public void updating() throws MyException{
                
        ownerBean.updatingOwner("Dude",1);
        petBean.updatingPet("Dude",1);
        
        assertNotNull("There should be a owner with the name Dude", ownerBean.readingOwnerBy("Dude"));
        assertNotNull("There should be a pet with the name Dude", petBean.readingPetBy("Dude"));
    }

    /**
     * This is the function which tests removing.
     * @throws report.MyException
     */
    @Test
    public void removing() throws MyException{
        assertEquals("There should be six owners", 6, ownerBean.readingOwnerAll().size());
        assertEquals("There should be six pets", 6, petBean.readingPetAll().size());
        ownerBean.removingOwner(6);
        petBean.removingPet(6);
        assertEquals("There should be five owners", 5, ownerBean.readingOwnerAll().size());
        assertEquals("There should be five pets", 5, petBean.readingPetAll().size());
    }

    /**
     * This is the function which ends the testing
     * @throws report.MyException
     */
    @After
    public void after() throws MyException{
        for (Iterator it = ownerBean.readingOwnerAll().iterator(); it.hasNext();) {
            Owner owner = (Owner) it.next();
            ownerBean.removingOwner(owner.getId());
        }
        for (Iterator it = petBean.readingPetAll().iterator(); it.hasNext();) {
            Pet pet = (Pet) it.next();
            petBean.removingPet(pet.getId());
        }
    }
}
