package co.edu.uniandes.csw.marketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement
public class ItemDTO {

    private Long id;
    private String name;
    private Integer quantity;
    private ProductDTO product;
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
    public ProductDTO getProduct() {
        return product;
    }

    /**
     * @generated
     */
    public void setProduct(ProductDTO product) {
        this.product = product;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
