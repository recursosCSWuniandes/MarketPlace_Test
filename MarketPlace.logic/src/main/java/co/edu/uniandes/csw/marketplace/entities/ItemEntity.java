package co.edu.uniandes.csw.marketplace.entities;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @generated
 */
@Entity
public class ItemEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Item")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(nullable=false)
    private ProductEntity product;
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
    public ProductEntity getProduct() {
        return product;
    }

    /**
     * @generated
     */
    public void setProduct(ProductEntity product) {
        this.product = product;
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
