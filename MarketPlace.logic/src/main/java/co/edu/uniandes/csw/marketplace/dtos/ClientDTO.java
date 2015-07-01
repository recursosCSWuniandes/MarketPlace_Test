package co.edu.uniandes.csw.marketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement 
public class ClientDTO {

    private Long id;
    private String name;
    private String phone;
    private ShoppingCartDTO shoppingCart;
    /**
     * @generated
     */
    public Long getId() {
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @generated
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @generated
     */
    public ShoppingCartDTO getShoppingCart() {
        return shoppingCart;
    }

    /**
     * @generated
     */
    public void setShoppingCart(ShoppingCartDTO shoppingcart) {
        this.shoppingCart = shoppingcart;
    }

}
