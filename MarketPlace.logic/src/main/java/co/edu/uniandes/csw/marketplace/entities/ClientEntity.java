package co.edu.uniandes.csw.marketplace.entities;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @generated
 */
@Entity
public class ClientEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Client")
    private Long id;

    private String name;

    private String phone;

    @ManyToOne
    private ShoppingCartEntity shoppingCart;
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

    /**
     * @generated
     */
    public String getPhone(){
        return phone;
    }

    /**
     * @generated
     */
    public void setPhone(String phone){
        this.phone = phone;
    }

    /**
     * @generated
     */
    public ShoppingCartEntity getShoppingCart() {
        return shoppingCart;
    }

    /**
     * @generated
     */
    public void setShoppingCart(ShoppingCartEntity shoppingcart) {
        this.shoppingCart = shoppingcart;
    }

}
