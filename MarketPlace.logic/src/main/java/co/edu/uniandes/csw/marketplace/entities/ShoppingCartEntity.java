package co.edu.uniandes.csw.marketplace.entities;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

/**
 * @generated
 */
@Entity
public class ShoppingCartEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "ShoppingCart")
    private Long id;

    private String name;

    /**
     * @generated
     */
    public Long getId(){
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * @generated
     */
    public String getName(){
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name){
        this.name = name;
    }

}
