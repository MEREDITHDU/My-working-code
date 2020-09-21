/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * This Class is the Pet class which has multiple functions
 * to manage the Pet object
 * @author mehow
 * @version 2.0
 */

@Entity
@Table(name = "pet")
@NamedQueries({@NamedQuery(name = "Pet.findAll", query = "SELECT s FROM Pet s"),
@NamedQuery(name = "Pet.findByName", query = "SELECT s FROM Pet s WHERE s.name LIKE :xyz ORDER BY s.id DESC")})

public class Pet implements Serializable{
    /**
     * It is primary key which is responsible for the ID of the pet
     */ 
    @Id
    @Column(name = "petID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * It is primary key which is responsible for the name of the pet
     */
    @Column(name = "name",length = 50, nullable = false)
    private String name;
    /**
     * It is primary key which is responsible for the type of the pet
     */
    @Column(name = "animal")
    private Animal animal;
    /**
     * It is primary key which is responsible for the birth day of the pet
     */
    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    /**
     * It is connection many to one
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "onwerID")
    private Owner owner;

    /**
     * Empty Constructor
     */
    public Pet(){}
    
    /**
     * This function is used to return name of the owner
     * 
     * @return name of the owner
     */
    
    public Owner getOwner() {
        return owner;
    }

    /**
     * This function is used to set name of the owner
     * 
     * @param owner it is the name of the owner
     */
    
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    
    /**
     * This is Pet constructor 
     * 
     * @param name it is a name of the pet
     * @param birthDate it is birth date of the pet
     * @param animal it is species of the pet
     */
    
    public Pet(String name, Date birthDate, Animal animal) {
        this.name = name;
        this.birthDate = birthDate;
        this.animal = animal;
    }
    
    
     /**
     * This function is used to return name of the pet
     * 
     * @return name of the owner
     */
    
    public String getName() {
        return name;
    }

    /**
     * This function is used to set name of the pet
     * 
     * @param name of the owner
     */
    
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This function is used to return birthday of the pet
     * 
     * @return birthday of the pet
     */
    
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * This function is used to set birthday of the pet
     * 
     * @param birthDate it is birthday of the pet
     */
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * This function is used to return id of the pet
     * 
     * @return id of the pet
     */
    
    public Integer getId() {
        return id;
    }

    /**
     * This function is used to set id of the pet
     * 
     * @param id of the pet
     */
    
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This function is an override
     * 
     * @return hash
     */
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * This function is an override
     * @param obj it is another object which is being compared
     * @return true or false
     */
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pet other = (Pet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
      /**
     * This function is an override
     * 
     * @return data of the pet
     */
    
    @Override
    public String toString(){
        return new StringBuilder().append(id).append(", ").append(name).append(", ").append(new SimpleDateFormat("dd/MM/yyyy").format(birthDate)).append(", ").append(animal).append("->").append(owner).toString();
    
    }
    
}