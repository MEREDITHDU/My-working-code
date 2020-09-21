/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * This Class is the Owner class which has multiple functions
 * to manage the Owner object
 * @author Qilin
 * @version 2.0
 */

@Entity
@Table(name = "owner")
@NamedQueries({@NamedQuery(name = "Owner.findAll", query = "SELECT s FROM Owner s"),
@NamedQuery(name = "Owner.findByName", query = "SELECT s FROM Owner s WHERE s.name LIKE :xyz ORDER BY s.id DESC")})
public class Owner implements Serializable {

    /**
     * It is primary key which is responsible for the ID of the owner
     */    
    @Id
    @Column(name = "onwerID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * It is primary key which is responsible for the name of the owner
     */
    @Column(name = "ownerName",length = 50, nullable = false)
    private String name;
    /**
     * It is primary key which is responsible for the birth day of the owner
     */ 
    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    /**
     * It is primary key which is responsible for the gender of the owner
     */ 
    @Column(name = "gender")
    private Gender gender;
    /**
     * It is one to many connection
     */ 
    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Pet> pets = new ArrayList<>();
    
    /**
     * Empty Constructor
     */
    public Owner(){}
    
    
    /**
     * This is Owner constructor 
     * 
     * @param name it is a name of the owner
     * @param birthDate it is birth date of the owner
     * @param gender it is gender of the owner
     */
    
    public Owner(String name, Date birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }
    
    /**
     * This function is used to return name of the owner
     * 
     * @return name of the owner
     */
    
    public String getName() {
        return name;
    }
    
    /**
     * This function is used to set name of the owner
     * 
     * @param name of the owner
     */
    
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * This function is used to return birthday of the owner
     * 
     * @return birthday of the owner
     */
    
    public Date getBirthDate() {
        return birthDate;
    }
    
    /**
     * This function is used to set birthday of the owner
     * 
     * @param birthDate it is birthday of the owner
     */
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    /**
     * This function is used to return id of the owner
     * 
     * @return id of the owner
     */
    
    public Integer getId() {
        return id;
    }
    
    /**
     * This function is used to set id of the owner
     * 
     * @param id of the owner
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
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Owner other = (Owner) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * This function is an override
     * 
     * @return data of the owner
     */
    
    @Override
    public String toString(){
        return new StringBuilder().append(id).append(", ").append(name).append(", ").append(new SimpleDateFormat("dd/MM/yyyy").format(birthDate)).append(", ").append(gender).toString();
    
    }
}
